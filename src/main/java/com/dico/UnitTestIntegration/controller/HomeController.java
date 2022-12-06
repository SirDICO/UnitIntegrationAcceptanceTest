package com.dico.UnitTestIntegration.controller;

import com.dico.UnitTestIntegration.service.HomeService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {

    private  HomeService homeService;

    public HomeController(HomeService homeService) {
        this.homeService = homeService;
    }

    @GetMapping("/welcome")
    public String WelcomeHome(@RequestParam(defaultValue = "Stranger") String name){
    return homeService.getWelcomeHome(name);
    }
}
