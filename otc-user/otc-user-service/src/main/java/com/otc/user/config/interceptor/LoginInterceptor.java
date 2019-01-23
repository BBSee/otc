package com.otc.user.config.interceptor;

import com.otc.platform.login.IdentityValidator;
import com.otc.platform.login.LoginErrException;
import com.otc.platform.login.Principal;
import com.otc.platform.springmvc.WebApplicationContextUtils;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

/**
 * Created by zhangzp on 2018/9/17.
 */
public class LoginInterceptor implements HandlerInterceptor {

    Logger logger = LoggerFactory.getLogger(LoginInterceptor.class);

    private IdentityValidator identityValidator;

    @Override
    public boolean preHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o) throws Exception {

        if (identityValidator == null) {
            Object o1 = WebApplicationContextUtils.getService(IdentityValidator.class,
                httpServletRequest.getServletContext());
            identityValidator = (IdentityValidator)o1;
        }

        Principal principal = identityValidator.currentPrincipal();

        if (principal == null) { // 未登录
            throw new LoginErrException();
        }

        return true;
    }

    @Override
    public void postHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, ModelAndView modelAndView) throws Exception {

    }

    @Override
    public void afterCompletion(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception e) throws Exception {

    }
}
