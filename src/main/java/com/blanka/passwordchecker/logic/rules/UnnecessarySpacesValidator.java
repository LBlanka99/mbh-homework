package com.blanka.passwordchecker.logic.rules;

public class UnnecessarySpacesValidator implements PasswordValidator {
    private final int SPACE = 32;

    @Override
    public boolean isValid(String password) {
        //check if there is a space at the beginning
        int firstChar = password.charAt(0);
        if (firstChar == SPACE) {
            return false;
        }

        //check if there is a space before the ending punctuation
        if (password.length() >= 2) {
            int charBeforePunctuation = password.charAt(password.length() - 2);
            if (charBeforePunctuation == SPACE) {
                return false;
            }
        }

        //check if there are 2 or more spaces beside each other
        String[] words = password.split(" ");
        for (String word : words) {
            if (word.isEmpty()) {
                return false;
            }
        }

        return true;
    }
}
