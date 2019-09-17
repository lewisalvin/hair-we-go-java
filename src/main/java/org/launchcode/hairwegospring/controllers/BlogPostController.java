package org.launchcode.hairwegospring.controllers;

import org.launchcode.hairwegospring.models.Post;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

@Controller
@RequestMapping("blog")
public class BlogPostController {

    @RequestMapping(value = "newPost", method = RequestMethod.GET)
    public String newPostForm() {
        return "newpost";
    }

    @RequestMapping(value = "newPost", method = RequestMethod.POST)
    public String newPost(@ModelAttribute @Valid Post postUp, Errors errors, HttpServletRequest request, Model model) {
        String username = request.getParameter("title");
        String postId = request.getParameter("body");

        model.addAttribute("username", username);
        model.addAttribute("postId", postId);




        return "blog";
    }

}