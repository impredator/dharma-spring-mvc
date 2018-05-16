package com.dharma.springmvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/")
public class ByeController {
    @RequestMapping(method = RequestMethod.GET)
    public String Bye(ModelMap model) {
        model.addAttribute("greeting", "Goodbye from Dharma");
        model.addAttribute("ByeBye");
        System.out.println(model.toString());
        return "index";
    }

    @RequestMapping(value="/bye", method = RequestMethod.GET)
    public String sayThankYou(ModelMap model) {
        model.addAttribute("greeting", "Say Thanks to Dharma");
        return "index";
    }
}
