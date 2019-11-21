package springbootlearingempcrud.boot.customBeans;

import org.springframework.util.StringUtils;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * ClassName: LoginStatusInterceptor
 * Description:  登录状态检测拦截器,实现HandlerInterceptor接口
 * Author: 殷青山
 * Date: 2019/11/22 0:21
 * Version: V1.0
 **/
public class LoginStatusInterceptor implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        String userName = (String) request.getSession().getAttribute("userName");
        if (StringUtils.isEmpty(userName)) {
            request.setAttribute("errMsg", "尚未登录，请请登录！");
            request.getRequestDispatcher("/").forward(request, response);
            return false;
        } else {
            return true;
        }
    }
}
