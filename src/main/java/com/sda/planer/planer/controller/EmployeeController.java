package com.sda.planer.planer.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/employees")
public class EmployeeController {

    @GetMapping
    public ModelAndView allEmployees() {
        ModelAndView modelAndView = new ModelAndView("allEmployees");
        modelAndView.addObject("message", "Hello World");
        return modelAndView;
    }

}
