package org.launchcode.hairwegospring.controllers;

import org.launchcode.hairwegospring.models.User;
import org.launchcode.hairwegospring.models.data.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ModelAttribute;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

public class AbstractController {

    @Autowired
    protected UserDao userDao;


    public static final String userSessionKey = "user_id";

    protected User getUserFromSession(HttpSession session){
        Integer userId = (Integer) session.getAttribute(userSessionKey);
        return userId == null ? null : userDao.findOne(userId);
    }

    protected void setUserInSession(HttpSession session, User user){
        session.setAttribute(userSessionKey, user.getUid());
    }
@ModelAttribute("user")
    public User getUserForModel(HttpServletRequest request){
        return getUserFromSession(request.getSession());
    }
}
