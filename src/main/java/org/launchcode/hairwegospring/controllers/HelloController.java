package org.launchcode.hairwegospring.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.support.AbstractMultipartHttpServletRequest;

import javax.servlet.http.HttpServletRequest;


@Controller
public class HelloController {



    @RequestMapping(value= "")
    @ResponseBody
    public String index(HttpServletRequest request) {

        String name = request.getParameter("username");
        if(name == null){
            name = "World";
        }
        return "Hello " + name;
    }

    @RequestMapping(value= "hello", method = RequestMethod.GET)
    @ResponseBody
    public String helloForm() {

        String html = "<form method='post'>" +
                "<input type='text' name='username' />" +
                "<input type='submit' value='Submit' />" +
                "</form>";
        return html;
    }

    @RequestMapping(value= "hello", method = RequestMethod.POST)
    @ResponseBody
    public String helloPost(HttpServletRequest request) {

        String name = request.getParameter("username");

        return "Hello " + name;


    }



    @RequestMapping(value= "goodbye")
    public String goodbye() {
        return "redirect:/";
    }
}
