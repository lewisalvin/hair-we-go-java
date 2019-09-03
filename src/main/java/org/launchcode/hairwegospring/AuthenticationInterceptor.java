package org.launchcode.hairwegospring;

import org.launchcode.hairwegospring.controllers.AbstractController;
import org.launchcode.hairwegospring.models.User;
import org.launchcode.hairwegospring.models.data.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

public class AuthenticationInterceptor extends HandlerInterceptorAdapter {


    @Autowired
    UserDao userDao;


    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws IOException {
        List<String> nonAuthPages = Arrays.asList("/login", "/register");

        if (!nonAuthPages.contains(request.getRequestURI())) {

            Integer userId = (Integer) request.getSession().getAttribute(AbstractController.userSessionKey);

            if (userId != null){
                User user = userDao.getOne(userId);

                if (user != null){
                    return true;
                }

                response.sendRedirect("/login");
                return false;
            }
        }

        return true;


    }


}
