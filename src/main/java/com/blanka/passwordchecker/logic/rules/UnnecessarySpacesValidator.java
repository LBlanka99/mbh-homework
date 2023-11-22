package com.blanka.passwordchecker.logic.rules;

public class UnnecessarySpacesValidator implements PasswordValidator {
    private final int SPACE = 32;

    @Override
    public boolean isValid(String password) {
        int firstChar = password.charAt(0);
        if (firstChar == SPACE) {
            return false;
        }

        int charBeforePunctuation = password.charAt(password.length() - 2);
        if (charBeforePunctuation == SPACE) {
            return false;
        }

        String[] words = password.split(" ");
        for (String word : words) {
            if (word.length() < 1) {
                return false;
            }
        }

        return true;
    }
}
