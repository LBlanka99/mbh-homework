package com.blanka.passwordchecker.logic.rules;

import java.util.ArrayList;
import java.util.List;

public class UniqueWordsValidator implements PasswordValidator {
    @Override
    public boolean isValid(String password) {
        //remove the ending punctuation of the string
        password = password.substring(0, password.length() - 1);

        List<String> words = List.of(password.split(" "));
        List<String> compareList = new ArrayList<>();

        for (String word : words) {
            if (compareList.contains(word)) {
                return false;
            }
            compareList.add(word);
        }

        return true;
    }
}
