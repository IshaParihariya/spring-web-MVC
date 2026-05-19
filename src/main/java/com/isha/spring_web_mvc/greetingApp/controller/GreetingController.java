package com.isha.spring_web_mvc.greetingApp.controller;


import com.isha.spring_web_mvc.greetingApp.service.GreetingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

// controller layer
@Controller
@RequestMapping("GreetingApp")
public class GreetingController
{
    // greeting service object
    @Autowired
    public GreetingService greetingService;

    //bean
    @GetMapping("/greets")
    public String getGreetings(Model model)
    //Think of Model as a bag/container to send data from Controller → JSP.
    {
         String greetings=greetingService.getGreetings("Isha Parihariya");
         model.addAttribute("greet",greetings);
         return "greet";
    }
}
