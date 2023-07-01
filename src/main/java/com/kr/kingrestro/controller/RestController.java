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
    @GetMapping("/service")
    public String ServiceAvail(Model model){
        try{
            return "service";
        }catch (Exception e){
            model.addAttribute("errorMessage", "An error occurred while processing the template.");
            return "error";
        }

    }

    @GetMapping("/menu")
    public String MenuDetails(Model model){
        try{
            return "menu";
        }catch (Exception e){
            model.addAttribute("errorMessage", "An error occurred while processing the template.");
            return "error";
        }

    }


    @GetMapping("/booking")
    public String Bookings(Model model){
        try{
            return "booking";
        }catch (Exception e){
            model.addAttribute("errorMessage", "An error occurred while processing the template.");
            return "error";

        }
    }

    @GetMapping("/team")
    public String Team(Model model){
        try{
            return "team";
        }catch (Exception e){
            model.addAttribute("errorMessage", "An error occurred while processing the template.");
            return "error";

        }
    }
    @GetMapping("/testimonial")
    public String Testimonials(Model model){
        try{
            return "testimonial";
        }catch (Exception e){
            model.addAttribute("errorMessage", "An error occurred while processing the template.");
            return "error";

        }
    }
    @GetMapping("/contact")
    public String ContactDetails(Model model){
        try{
            return "contact";
        }catch (Exception e){
            model.addAttribute("errorMessage", "An error occurred while processing the template.");
            return "error";

        }
    }

}
