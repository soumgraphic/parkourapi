package com.globalopencampus.parkourapi.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/hello")
public class HelloController {
    @GetMapping()
    Map<String,String> sayHello(){
        Map<String, String> hello = new HashMap<>();
        hello.put("welcomeMessage", "Hi everyone, welcome to Parkour API !, The best API about Parkour and its players");
        return hello;
    }
}

/*
We want to develop an API about Parkour sport.

Some features we want to have in our API.
We can invite some friends to a location to do parkour.
We can have examples about how to do some kinf of parkour.
We can share our experience as videos or pictures with another parkour artists.
We can also invite new comers to start experience parkour discipline and to start it if they want.

Can you help us to have the complete specificatio of our API as Homework without any implementation.
In the API
 */
