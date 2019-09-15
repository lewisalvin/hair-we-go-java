package org.launchcode.hairwegospring.controllers;

import org.launchcode.hairwegospring.models.data.ShampooDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("products")
public class ProductController {

    @Autowired
    private ShampooDao shampooDao;

    @RequestMapping(value="")
    public String index(Model model){

        model.addAttribute("shampoos", shampooDao.findAll());

        return "products";
    }

}
