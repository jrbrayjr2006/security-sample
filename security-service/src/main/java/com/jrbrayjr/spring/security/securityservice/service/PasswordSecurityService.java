package com.jrbrayjr.spring.security.securityservice.service;

import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.crypto.encrypt.Encryptors;
import org.springframework.security.crypto.encrypt.TextEncryptor;
import org.springframework.security.crypto.keygen.KeyGenerators;
import org.springframework.stereotype.Service;

@Service
@NoArgsConstructor
@Slf4j
public class PasswordSecurityService {

    public static final String DEFAULT_PASSWORD = "p@ssword";
    private static final String TAG = "PasswordSecurityService";

    private TextEncryptor encryptor;
    private String salt;

    public String securePassword(String password) {
        this.salt = getSalt();
        this.encryptor = getEncryptor(password, this.salt);
        String encryptedPassword = this.encryptor.encrypt(password);
        return encryptedPassword;
    }

    public String decryptPassword(String ePassword) throws Exception {
        if(null == this.encryptor) {
            log.error(TAG, "The encryptor has not been initialized");
            throw new Exception();
        }
        String password = encryptor.decrypt(ePassword);
        return password;
    }

    public String getSalt() {
        return KeyGenerators.string().generateKey();
    }

    private TextEncryptor getEncryptor(String password, String storedSalt) {
        this.encryptor = Encryptors.queryableText(password, storedSalt);
        return this.encryptor;
    }
}
