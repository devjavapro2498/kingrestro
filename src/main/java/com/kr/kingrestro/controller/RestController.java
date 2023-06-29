package com.kr.kingrestro.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class RestController {


    @GetMapping("/")
    public String index(Model model) {
        try {
            return "index";
        } catch (Exception e) {
            e.printStackTrace();
            model.addAttribute("errorMessage", "An error occurred while processing the template.");
            return "error";
        }
    }
    @GetMapping("/about")
    public String about(Model model) {
        try {
            return "about";
        } catch (Exception e) {
            e.printStackTrace();
            model.addAttribute("errorMessage", "An error occurred while processing the template.");
            return "error";
        }
    }
}
