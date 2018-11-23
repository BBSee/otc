package com.otc.api.config.interceptor;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

/**
 * Created by zhangzp on 2018/8/20 0008.
 */
@Configuration
public class SpringInterceptorRegister extends WebMvcConfigurerAdapter {

    // 添加spring中的拦截器  excludePathPatterns 可以排除
    @Override
    public void addInterceptors(InterceptorRegistry registry) {

      // 语言国际化
      registry.addInterceptor(new LanguageInterceptor()).
          addPathPatterns("/**");

      //app 登录拦截器
      registry.addInterceptor(new LoginInterceptor());

        super.addInterceptors(registry);
    }

}
