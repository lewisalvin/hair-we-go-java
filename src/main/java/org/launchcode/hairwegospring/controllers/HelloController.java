package org.launchcode.hairwegospring.controllers;


import org.launchcode.hairwegospring.models.HairData;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import org.springframework.web.servlet.ModelAndView;


import java.util.ArrayList;
import java.util.List;

import static org.springframework.web.bind.annotation.RequestMethod.GET;



@Controller
public class HelloController {












    @RequestMapping(value= "hey", method = GET)
    @ResponseBody
    public String helloForm() {

        String html = "<form method='post'>" +
                "<input type='text' name='username' value = 'username' />" +
                "<input type='submit' value='Submit' />" +
                "</form>";
        return html;
    }


    @RequestMapping(value="homepage")
    private ModelAndView landing(){
        ModelAndView mav = new ModelAndView("welcome");

        List<String> typeHairs = new ArrayList<String>();
        typeHairs.add("3A");
        typeHairs.add("3B");
        typeHairs.add("3C");

        mav.addObject("typeHairs", typeHairs);
        //mav.addObject("hairData", new HairData());

        return mav;
    }



    @RequestMapping(value= "goodbye")
    public String goodbye() {
        return "redirect:/";
    }


    @RequestMapping(value="/welcome", method = RequestMethod.GET)
    public ModelAndView homePage() {
        //HairData hairData = new HairData();

        List<String> typeHair = new ArrayList<String>();
        typeHair.add("3A");
        typeHair.add("3B");
        typeHair.add("3C");

        ModelAndView mv = new ModelAndView("hairData");
        //mv.addObject("hairData", hairData);

        mv.addObject("typeHair", typeHair);

        return mv;












    }



    @RequestMapping(value="/learn")
    public String submitForm(Model model, HairData hairData){

        //model.addAttribute("hairData", hairData);
        return "learn";
    }







}
