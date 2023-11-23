package com.blanka.passwordchecker.logic.inputchecker;

public class InputChecker {

    public boolean isInputBlankOrNull(String input) {
        if (input == null) {
            return true;
        }
        return input.isBlank();
    }
}
