package com.isha.spring_web_mvc.courseApp.controller;

import com.isha.spring_web_mvc.courseApp.model.Course;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;


// controller
@Controller
public class CourseController {


    @GetMapping("/info")
    // without object
    public String getCourseInfo(Model model) {
        model.addAttribute("cid", 1);
        model.addAttribute("cname", "Java Developement");
        model.addAttribute("cprice", 4999.0);
        return "course";
    }

    @GetMapping("/info1")
    // with object
    public String getCourseInfo1(Model model)
    {
        Course course =new Course();
        course.setCid(2);
        course.setCname("DevOps with AWS");
        course.setCprice(5999.0);
        model.addAttribute("course",course);
        return "course1";
    }
}
