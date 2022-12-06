package com.dico.UnitTestIntegration.service;

import org.springframework.stereotype.Service;

@Service
public class HomeService {

    public String getWelcomeHome(String name){
        return String.format("Welcome home %s!", name);
    }
}
