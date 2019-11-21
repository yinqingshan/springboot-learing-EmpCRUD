package springbootlearingempcrud.boot.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import springbootlearingempcrud.boot.entity.Account;


/**
 * ClassName: LoginController
 * Description:  //TODO
 * Author: 殷青山
 * Date: 2019/11/21 23:47
 * Version: V1.0
 **/
@Controller
@SessionAttributes(value = "userName")
public class LoginController {

    @RequestMapping("/login")
    public String login(Account account, Model model) {

        if (!account.getUserName().equals("admin") || !account.getPassword().equals("123456")) {
            model.addAttribute("errMsg", "账户或密码不正确!");
            return "/login";
        }
        model.addAttribute("userName", account.getUserName());
        return "redirect:/main.html";
    }
}
