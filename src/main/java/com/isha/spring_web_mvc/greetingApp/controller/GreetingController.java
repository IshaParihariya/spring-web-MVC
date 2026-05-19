package com.isha.spring_web_mvc.greetingApp.controller;


import com.isha.spring_web_mvc.greetingApp.service.GreetingService;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.io.IOException;
import java.io.Writer;
import java.net.http.HttpResponse;

// controller layer
@Controller
@RequestMapping("GreetingApp")
public class GreetingController
{
    // greeting service object
    @Autowired
    public GreetingService greetingService;

    // response from contoller --> to view --> to user
    @GetMapping("/greets")
    public String getGreetings(Model model)
    //Think of Model as a bag/container to send data from Controller → JSP.
    {
         String greetings=greetingService.getGreetings("Isha Parihariya");
         model.addAttribute("greet",greetings);
         return "greet";
    }

    // response directly from the controller --> to the user
    @GetMapping("/wish")
    public void getGreetings2(HttpServletResponse response) throws IOException
    {
        String greetings=greetingService.getGreetings("Isha Parihariya");
        Writer writer=response.getWriter();
        writer.write("<h1>this response is directly from the controller</h1>"+greetings);
    }
}
