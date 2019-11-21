package springbootlearingempcrud.boot.customBeans;


import org.springframework.util.StringUtils;
import org.springframework.web.servlet.LocaleResolver;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Locale;

/**
 * ClassName: CustomLocalResolver
 * Description:  自定义区域解析器
 * Author: 殷青山
 * Date: 2019/11/21 23:31
 * Version: V1.0
 **/
public class CustomLocalResolver implements LocaleResolver {
    @Override
    public Locale resolveLocale(HttpServletRequest request) {
        //获取请求中的区域参数
        String localeParam = request.getParameter("localeParam");
        //声明Locale对象
        Locale locale = Locale.getDefault();
        if (!StringUtils.isEmpty(localeParam)) {
            //截取字符串
            String[] split = localeParam.split("_"); // zh_CN  zh表语言代码、CN表国家代码
            locale = new Locale(split[0], split[1]);
        }
        return locale;
    }

    @Override
    public void setLocale(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Locale locale) {

    }
}
