package org.launchcode.hairwegospring.controllers;


import org.launchcode.hairwegospring.models.styleType;
import org.launchcode.hairwegospring.models.HairDAO;

import org.launchcode.hairwegospring.models.PersonForm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;


import java.util.List;

import static org.springframework.web.bind.annotation.RequestMethod.GET;



@Controller
public class HelloController {

    @Autowired
    private HairDAO hairDAO;

    @RequestMapping(value= "hey", method = GET)
    @ResponseBody
    public String helloForm() {

        String html = "<form method='post'>" +
                "<input type='text' name='username' value = 'username' />" +
                "<input type='submit' value='Submit' />" +
                "</form>";
        return html;
    }






    @RequestMapping(value= "goodbye")
    public String goodbye() {
        return "redirect:/";
    }

    /*@RequestMapping(value="/display", method = RequestMethod.GET)
    public String display(Model model){





        return "display";
    }

     */


    @RequestMapping(value = { "/display" }, method = RequestMethod.GET)
    public String selectOptionExample1Page(Model model) {

        PersonForm form = new PersonForm();
        model.addAttribute("personForm", form);

        List<styleType> list = hairDAO.getHairTypes();
        model.addAttribute("hair", list);

        return "display";
    }



















    @RequestMapping(value="/learn")
    public String submitForm(){

        //model.addAttribute("hairData", hairData);
        return "learn";
    }







}
