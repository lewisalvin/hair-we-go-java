package org.launchcode.hairwegospring.controllers;

import org.launchcode.hairwegospring.models.User;
import org.launchcode.hairwegospring.models.forms.LoginForm;
import org.launchcode.hairwegospring.models.forms.RegisterForm;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

@Controller
public class AuthenticationController extends AbstractController {

    @RequestMapping(value="")
    public String index(){
        return "index";
    }

    @RequestMapping(value="/register")
    public String registerForm(Model model){
        model.addAttribute(new RegisterForm());
        model.addAttribute("title", "Register");
        return "register";

    }

    @RequestMapping(value="/register", method = RequestMethod.POST)
    public String register(@ModelAttribute @Valid RegisterForm form, Errors errors, HttpServletRequest request){

        if (errors.hasErrors()){
            return "register";
        }


        User existingUser = userDao.findByUsername(form.getUsername());

        if (existingUser != null) {
            errors.rejectValue("username", "username.alreadyexists", "A user with that username already exists");
            return "register";
        }

        User newUser = new User(form.getUsername(), form.getPassword());
        userDao.save(newUser);
        setUserInSession(request.getSession(), newUser);

        return "redirect:";


    }

    @RequestMapping(value="/login", method = RequestMethod.GET)
    public String login(Model model){
        model.addAttribute(new LoginForm());
        model.addAttribute("title","login");

        return "login";

    }

    @RequestMapping(value="/login", method = RequestMethod.POST)
    public String login(@ModelAttribute @Valid LoginForm form, Errors errors, HttpServletRequest request){
        if (errors.hasErrors()){
            return "login";
        }

        User theUser = userDao.findByUsername(form.getUsername());
        String password = form.getPassword();

        if (theUser == null){
            errors.rejectValue("username", "user.invalid", "the given username does not exist");
            return "login";
        }

        if (!theUser.isMatchingPassword(password)){
            errors.rejectValue("password", "password.invalid", "Invalid password");
            return "login";
        }

        setUserInSession(request.getSession(), theUser);

        return "redirect:";

    }

    @RequestMapping(value="/logout", method = RequestMethod.GET)
    public String logout(HttpServletRequest request){
        request.getSession().invalidate();

        return "redirect:/login";

    }
}
