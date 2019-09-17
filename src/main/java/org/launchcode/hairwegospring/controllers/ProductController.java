package org.launchcode.hairwegospring.controllers;



import org.launchcode.hairwegospring.models.Shampoo;
import org.launchcode.hairwegospring.models.data.ShampooDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.persistence.Id;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Optional;

@Controller
@RequestMapping("products")
public class ProductController {

    @Autowired
    private ShampooDao shampooDao;
    private Object Iterable;

    @RequestMapping(value="")
    public String index(Model model){

        model.addAttribute("shampoos", shampooDao.findAll());

        return "products";
    }

    @RequestMapping(value="threeA")
    public String threeA(Model model, @ModelAttribute Shampoo shampoo){
        Optional<Shampoo> shampoos = shampooDao.findById(shampoo.getId());

        return "products";
    }

}
