package org.launchcode.hairwegospring.controllers;

import javafx.scene.control.RadioButton;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.swing.*;
import java.util.ArrayList;



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


    @RequestMapping(value="welcome")
    public String homePage(Model model) {


        ArrayList<String> hairTypes = new ArrayList<>();
        hairTypes.add("3A");
        hairTypes.add("3B");
        hairTypes.add("3C");
        hairTypes.add("4A");
        hairTypes.add("4B");
        hairTypes.add("4C");




        model.addAttribute("hairTypes", hairTypes);
        model.addAttribute("title", "Hair We Go!");
        return "welcome";
    }
    @RequestMapping(value = "add")
    public String displayAddHairTypeForm(Model model){
        model.addAttribute("title", "Add Hair Type");
        return "/add";

    }
    @RequestMapping(value = "welcome")
    public class Buttons {

        public void main(String[] args){

            JFrame frame = new JFrame();
            frame.setTitle("Type Hair");
            frame.setSize(200, 100);
            frame.setLocationRelativeTo(null);
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

            JPanel panel = new JPanel();

            JRadioButton hair3A = new JRadioButton();
            hair3A.setText("3A");
            JRadioButton hair3B = new JRadioButton();
            hair3B.setText("3B");

            ButtonGroup group = new ButtonGroup();
            group.add(hair3A);
            group.add(hair3B);

            panel.add(hair3A);
            panel.add(hair3B);

            frame.getContentPane().add(panel);
            frame.setVisible(true);







        }
    }
}
