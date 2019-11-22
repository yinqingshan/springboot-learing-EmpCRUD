package springbootlearingempcrud.boot.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import springbootlearingempcrud.boot.dao.DepartmentDao;
import springbootlearingempcrud.boot.dao.EmployeeDao;
import springbootlearingempcrud.boot.entity.Department;
import springbootlearingempcrud.boot.entity.Employee;

import java.util.Collection;
import java.util.Map;

/**
 * ClassName: EmpController
 * Description:  员工管理处理器
 * Author: 殷青山
 * Date: 2019/11/14 23:24
 * Version: V1.0
 **/
@Controller
public class EmpController {

    @Autowired
    EmployeeDao employeeDao;
    @Autowired
    DepartmentDao departmentDao;

    @GetMapping("/emps")
    public String getAll(Map<String, Object> map) {
        Collection<Employee> emps = employeeDao.getAll();
        map.put("emps", emps);
        return "list";
    }

    @GetMapping("/emp")
    public String toAddPage(Map<String, Object> map) {
        Collection<Department> departments = departmentDao.getDepartments();
        map.put("departments", departments);
        return "/addEmp";
    }

    @PostMapping("/emp")
    public String add(Employee employee) {
        System.out.println(employee);
        employeeDao.save(employee);
        return "redirect:/emps";
    }

    @GetMapping("/emp/{id}")
    public String toEdit(@PathVariable("id") Integer id, ModelMap modelMap) {

        Employee employee = employeeDao.get(id);
        Collection<Department> departments = departmentDao.getDepartments();
        modelMap.addAttribute("employee", employee);
        modelMap.addAttribute("departments", departments);
        return "/editEmp";
    }


    @PutMapping("/emp")
    public String Edit(Employee employee) {

        employeeDao.save(employee);
        return "redirect:/emps";
    }

    //chrome浏览器始终无法实现Delete请求，亲测postman可以成功。故删除功能没实现restful
    @RequestMapping(value = "/empDel/{id}")
    public String delete(@PathVariable("id") Integer id) {
        employeeDao.delete(id);
        return "redirect:/emps";
    }
}
