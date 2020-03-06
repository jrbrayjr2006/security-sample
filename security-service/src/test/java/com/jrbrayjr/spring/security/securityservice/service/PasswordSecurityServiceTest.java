package com.jrbrayjr.spring.security.securityservice.service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PasswordSecurityServiceTest {

    private PasswordSecurityService service;

    @BeforeEach
    void setUp() {
        service = new PasswordSecurityService();
    }

    @Test
    @DisplayName("When a salt string is requested, then the salt is longer than 5 characters")
    void shouldGenerateSalt() {
        // When
        String actual = service.getSalt();

        // Then
        assertTrue(actual.length() > 5);
    }

    @Test
    @DisplayName("Given a clear text password, when it is salted, then the password is not in the clear")
    void shouldHashAndSaltPassword() throws Exception {
        // Given
        String clearPassword ="somepassword";

        // When
        String actual = service.securePassword(clearPassword);

        // Then
        assertNotEquals(clearPassword, actual);
        assertTrue(actual.length() > clearPassword.length());
    }

    @Test
    @DisplayName("Given an encrypted password, when the encrytped password is decrypted, then the decrypted password should be the same as the original password")
    void shouldDecryptEncryptedPassword() throws Exception {
        // Given
        String clearPassword ="somepassword";
        String encryptedPassword = service.securePassword(clearPassword);

        // when
        String decryptedPassword = service.decryptPassword(encryptedPassword);

        // Then
        assertEquals(clearPassword, decryptedPassword);
    }
}