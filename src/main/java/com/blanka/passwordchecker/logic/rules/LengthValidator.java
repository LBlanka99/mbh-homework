package com.blanka.passwordchecker.logic.rules;


public class LengthValidator implements PasswordValidator {
    @Override
    public boolean isValid(String password) {
        String[] words = password.split(" ");
        return words.length >= 2;

    }
}
