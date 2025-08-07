package com.financeapp.services;

import com.financeapp.models.User;
import com.financeapp.utils.EncryptionUtil;

import java.util.HashMap;
import java.util.UUID;

public class AuthService {
    private HashMap<String, User> users = new HashMap<>();

    public User register(String username, String password, String email) {
        String userId = UUID.randomUUID().toString();
        String hash = EncryptionUtil.hashPassword(password);
        User user = new User(userId, username, hash, email);
        users.put(userId, user);
        return user;
    }

    public boolean login(String username, String password) {
        for (User user : users.values()) {
            if (user.getUsername().equals(username) &&
                user.getPasswordHash().equals(EncryptionUtil.hashPassword(password))) {
                return true;
            }
        }
        return false;
    }
}
