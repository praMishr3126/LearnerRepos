package com.example.LearningJenkinsWithMS;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {

    @GetMapping("/sayHello")
    public void print()
    {
        System.out.println("Hello Prashant");
    }
}
