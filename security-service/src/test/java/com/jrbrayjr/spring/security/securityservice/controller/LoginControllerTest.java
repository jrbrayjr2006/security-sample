package com.jrbrayjr.spring.security.securityservice.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.jrbrayjr.spring.security.securityservice.model.Login;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

class LoginControllerTest {

    private LoginController controller;
    private MockMvc mockMvc;

    @BeforeEach
    void setUp() {
        controller = new LoginController();
        mockMvc = MockMvcBuilders.standaloneSetup(controller).build();
    }

    @Test
    @DisplayName("Given a login, when a GET request is made, should return status OK")
    void shouldReturnStatusOk() throws Exception {
        // Given
        String endpoint = "/login";
        Login someLogin = new Login("somemail@email.com", "somepassword");
        ObjectMapper mapper = new ObjectMapper();
        String loginJson = mapper.writeValueAsString(someLogin);
        // When
        mockMvc.perform(get(endpoint).contentType(MediaType.APPLICATION_JSON).content(loginJson)).andExpect(status().isOk());
        // Then
    }
}