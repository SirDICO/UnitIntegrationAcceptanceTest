package com.dico.UnitTestIntegration.controller;

import com.dico.UnitTestIntegration.service.HomeService;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

class HomeControllerUnitTest {

    @Test
    void welcomeHome() {
        HomeService homeService = Mockito.mock(HomeService.class);

        when(homeService.getWelcomeHome("Ikenna")).thenReturn("Welcome home Ikenna!");

        HomeController home = new HomeController(homeService);

        assertEquals("Welcome home Ikenna!", home.WelcomeHome("Ikenna"));
    }

}