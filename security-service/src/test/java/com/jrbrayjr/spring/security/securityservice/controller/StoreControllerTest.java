package com.jrbrayjr.spring.security.securityservice.controller;

import org.junit.jupiter.api.BeforeEach;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.junit.jupiter.api.Assertions.*;

class StoreControllerTest {

    private StoreController controller;
    private MockMvc mockMvc;

    @BeforeEach
    void setUp() {
        controller = new StoreController();
        mockMvc = MockMvcBuilders.standaloneSetup(controller).build();
    }
}