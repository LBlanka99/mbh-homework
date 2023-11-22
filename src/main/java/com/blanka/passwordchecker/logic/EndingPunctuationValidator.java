package com.blanka.passwordchecker.logic;

import java.util.ArrayList;
import java.util.List;

public class EndingPunctuationValidator implements PasswordValidator {
    private final int EXCLAMATION_MARK = 33;
    private final int PERIOD = 46;
    private final int QUESTION_MARK = 63;

    private final List<Integer> ACCEPTABLE_ENDING_PUNCTUATIONS = new ArrayList<>(
            List.of(EXCLAMATION_MARK,
                    PERIOD,
                    QUESTION_MARK));

    @Override
    public boolean isValid(String password) {
        char lastChar = password.charAt(password.length() - 1);
        int lastCharCode = (int) lastChar;
        return ACCEPTABLE_ENDING_PUNCTUATIONS.contains(lastCharCode);
    }
}
