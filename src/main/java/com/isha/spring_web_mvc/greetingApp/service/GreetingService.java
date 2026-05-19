package com.isha.spring_web_mvc.greetingApp.service;

import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.time.LocalDateTime;

// service layer
@Service
public class GreetingService implements IGreetingService
{

    //now() is actually a static method.
    //Meaning you call it on the class, not object.

    @Override
    public String getGreetings(String name)
    {
        if(LocalDateTime.now().getHour()<12)
        {
            return "Good morning "+name;
        }
        else if(LocalDateTime.now().getHour()<16)
        {
            return "Good afternoon "+name;
        }
        else if(LocalDateTime.now().getHour()<19)
        {
            return "Good evening "+name;
        }
        else
        {
            return "Good night "+name;
        }

    }
}
