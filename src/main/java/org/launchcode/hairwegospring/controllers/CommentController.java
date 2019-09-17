package org.launchcode.hairwegospring.controllers;

import org.launchcode.hairwegospring.models.Post;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;

@Controller
@RequestMapping("comment")
public class CommentController {

    static ArrayList<Post> comments = new ArrayList<>();

    // Request path: /cheese
    @RequestMapping(value = "")
    public String index(Model model) {

        model.addAttribute("comments", comments);
        model.addAttribute("title", "Commentary");

        return "comment/index";
    }

    @RequestMapping(value = "add", method = RequestMethod.GET)
    public String displayAddCheeseForm(Model model) {
        model.addAttribute("title", "Add Comment");
        return "comment/add";
    }

    @RequestMapping(value = "add", method = RequestMethod.POST)
    public String processAddCheeseForm(@RequestParam String commentName,
                                       @RequestParam String commentDescription) {
        Post newComment = new Post(commentName, commentDescription);
        comments.add(newComment);
        return "redirect:";
    }

    @RequestMapping(value = "remove", method = RequestMethod.GET)
    public String displayRemoveCheeseForm(Model model) {
        model.addAttribute("comments", comments);
        model.addAttribute("title", "Remove Comment");
        return "comment/remove";
    }

    @RequestMapping(value = "remove", method = RequestMethod.POST)
    public String processRemoveCheeseForm(@RequestParam ArrayList<String> post) {

        for (String aPost : post) {
            comments.remove(aPost);
        }

        return "redirect:";
    }

}
