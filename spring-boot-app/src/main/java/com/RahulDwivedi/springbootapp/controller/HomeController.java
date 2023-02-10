package com.RahulDwivedi.springbootapp.controller;

import com.RahulDwivedi.springbootapp.model.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

//@Controller
//@ResponseBody
@RestController
public class HomeController {

    @RequestMapping("/")
    public String home(){
        return "Hello World";
    }

    //get request
    //by default get mapping
    //@RequestMapping("/user")
    //for any other do like below
    //@RequestMapping(value = "/user", method = RequestMethod.GET)

    //more efficient way
    @GetMapping("/user")
    //PostMapping,Put and Delete similar way
    public User user(){
        User user = new User();
        user.setId("1");
        user.setName("Rahul");
        user.setEmailid("rahul.dwivedi@mail.com");

        return user;
    }

    //new method for path variable
    //id is a dynamic field
    //in this user won't come,i.e, https://localhost:8080/1
    //we can pass any argument or any value in id
    @GetMapping("/{id}")
    //since we have defined id above we have to take it as a input in our method
    public String pathVariable(@PathVariable String id){
        return "The Path Variable is: " + id;
    }

    //we can pass any argument or any value in name
    @GetMapping("/user/{name}")
    public String name(@PathVariable String name){
        return "Name is: " + name;
    }

    @GetMapping("/{id1}/{id2}")
    public int value(@PathVariable int id1, @PathVariable int id2){
        int id3 = id1 + id2;
        return id3;
    }

    //take id2(second path variable) and attach it into name variable
    @GetMapping("user/{id1}/{id2}")
    public String valueReturn(@PathVariable String id1, @PathVariable("id2") String name){
        return "The Path Variables are: " + id1 + ", " + name;
    }

    /* Request Parameters */

    //attaching Request handler or Request Mapping
    //requestParam is the URL
    @GetMapping("/requestParam")
    //method return String to handle the request params
    public String requestParams(@RequestParam String name){
        return "Your Name is: " + name;
    }

    //name = "email" means second parameter name is email
    @GetMapping("/requestParamNameEmailId")
    public String requestParamNameEmailId(@RequestParam String name,
                                          @RequestParam(name="email",required = false,defaultValue = "") String emailid){
        return "Your name is " + name + " and your email id is " + emailid;
    }

    //code snippet in which it works even after not giving email id and these are non-mandatory fields
    //if fields are available then fine otherwise also fine
    //just do required = false as done above
    //if no email id is passed then we have set default value as blank
    //above we have discussed different types of parameter handling


}
