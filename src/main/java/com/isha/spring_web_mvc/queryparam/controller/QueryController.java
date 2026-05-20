package com.isha.spring_web_mvc.queryparam.controller;


import org.springframework.boot.context.properties.bind.DefaultValue;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Map;

/*
1. Query Parameter (@RequestParam)
Definition

Query parameter is small data sent in URL after ?.

Syntax
?key=value
Example URL
/greet?name=isha

Here:

name → key
isha → value
Spring Code
@GetMapping("/greet")
public String greet(
        @RequestParam String name)
{
    return "Hello " + name;
}
Request
/greet?name=isha
Output
Hello isha
Multiple Query Parameters
/add?a=10&b=20
@GetMapping("/add")
public String add(
        @RequestParam int a,
        @RequestParam int b)
{
    return String.valueOf(a+b);
}
Optional Query Parameter
@RequestParam(required=false)
String name
Default Value
@RequestParam(defaultValue="Guest")
String name
Uses
Searching
Filtering
Pagination
Small data passing
 */
@Controller
public class QueryController
{
    //  http://localhost:8080/info2?name=isha
    @GetMapping("/info2")
    // model used map internally so we can directly use this
    // so lesser reliability on 3rd party
    public String getInfo1(@RequestParam String name, Map<String,Object> model)
    {
        String info="Hello "+name+" I hope you are doing well!!";
        model.put("msg",info);
        return "queryparam";
    }



    // multiple query params
    //  http://localhost:8080/info3?name=isha&city=jaipur
    @GetMapping("/info3")
    public String getInfo2(@RequestParam String name,@RequestParam String city, Map<String,Object> model)
    {
        String info="Hello "+name+" I hope you are doing well and so you are from "+city +" right??!";
        model.put("msg",info);
        return "queryparam";
    }



    // default one
    //  http://localhost:8080/info4?city=jaipur
    // http://localhost:8080/info4?name&city=jaipur
    @GetMapping("/info4")
    public String getInfo3(@RequestParam(defaultValue="Guest") String name, @RequestParam String city, Map<String,Object> model)
    {
        String info="Hello "+name+" I hope you are doing well and so you are from "+city +" right??!";
        model.put("msg",info);
        return "queryparam";
    }


    // optional one
    // here city is optional info even if not given its fine!
    @GetMapping("/info5")
    public String getInfo4(@RequestParam String name, @RequestParam(required = false,defaultValue = "city") String city, Map<String,Object> model)
    {
        String info="Hello "+name+" I hope you are doing well and so you are from "+city +" right??!";
        model.put("msg",info);
        return "queryparam";
    }

}
