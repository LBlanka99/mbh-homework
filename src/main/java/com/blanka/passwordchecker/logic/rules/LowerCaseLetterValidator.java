package com.blanka.passwordchecker.logic.rules;


public class LowerCaseLetterValidator implements PasswordValidator {
    private final int FIRST_LOWER_CASE = 97;
    private final int LAST_LOWER_CASE = 122;

    @Override
    public boolean isValid(String password) {
        //remove the ending punctuation of the string
        password = password.substring(0, password.length() - 1);

        String[] words = password.split(" ");

        for (String word : words) {
            for (int i = 0; i < word.length(); i++) {
                int currentCharCode = word.charAt(i);
                if (currentCharCode < FIRST_LOWER_CASE || currentCharCode > LAST_LOWER_CASE) {
                    return false;
                }
            }
        }

        return true;
    }
}
