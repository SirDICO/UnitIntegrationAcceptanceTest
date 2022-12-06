package com.dico.UnitTestIntegration.controller;

import com.dico.UnitTestIntegration.service.HomeService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;


import static org.hamcrest.Matchers.equalTo;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest
class HomeControllerIntegrationTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private HomeService homeService;


   @Test
    void WelcomeHomeDefaultMessage() throws Exception {
       when(homeService.getWelcomeHome("Stranger"))
               .thenReturn("Welcome home Stranger!");

       mockMvc.perform(get("/welcome"))
               .andDo(print())
               .andExpect(status().isOk())
               .andExpect(content().string(equalTo("Welcome home Stranger!")));
  verify(homeService).getWelcomeHome("Stranger");

   }


    @Test
    void WelcomeHomeCustomMessage() throws Exception {
        when(homeService.getWelcomeHome("Ikenna"))
                .thenReturn("Welcome home Ikenna!");

        mockMvc.perform(get("/welcome?name=Ikenna"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().string(equalTo("Welcome home Ikenna!")));
        verify(homeService).getWelcomeHome("Ikenna");

    }
}