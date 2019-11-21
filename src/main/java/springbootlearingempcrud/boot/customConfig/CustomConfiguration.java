package springbootlearingempcrud.boot.customConfig;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import springbootlearingempcrud.boot.customBeans.CustomLocalResolver;
import springbootlearingempcrud.boot.customBeans.LoginStatusInterceptor;
import springbootlearingempcrud.boot.entity.Account;

/**
 * ClassName: CustomConfiguration
 * Description:  自定义配置类
 * 实现WebMvcConfiguration接口
 * Author: 殷青山
 * Date: 2019/11/21 23:13
 * Version: V1.0
 **/
@Configuration
public class CustomConfiguration implements WebMvcConfigurer {

    /**
     * MethodName: addCorsMappings
     * Description: 添加对templates下页面的视图映射
     * Date: 2019/11/21 23:16 Author: 殷青山
     * Param: [registry]
     * return: void
     **/
    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        //浏览器访问项目根路径(localhost:8080/)，经视图解析器解析，映射到templates/login.html页面
        registry.addViewController("/").setViewName("/login");
        registry.addViewController("/main.html").setViewName("/dashboard");
    }

    /**
     * MethodName: getCustomLocalResolver
     * Description: 将自定义区域解析器实例化并装入IoC中
     * Date: 2019/11/21 23:44 Author: 殷青山
     * Param: []
     * return: CustomLocalResolver
     **/
    @Bean(name = "localeResolver")
    public LocaleResolver getCustomLocalResolver() {
        return new CustomLocalResolver();
    }

    @Bean
    public Account getAccount() {
        return new Account();
    }

    /**
      * MethodName: getLoginStatusInterceptor
      * Description: 实例化自定义拦截器
      * Date: 2019/11/22 0:30 Author: 殷青山
      * Param: []
      * return: org.springframework.web.servlet.HandlerInterceptor
      **/
    @Bean
    public HandlerInterceptor getLoginStatusInterceptor() {
        return new LoginStatusInterceptor();
    }
}
