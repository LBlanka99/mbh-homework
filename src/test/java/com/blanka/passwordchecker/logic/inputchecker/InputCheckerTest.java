package com.blanka.passwordchecker.logic.inputchecker;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.assertTrue;

class InputCheckerTest {
    InputChecker checker = new InputChecker();

    @ParameterizedTest
    @NullAndEmptySource
    @ValueSource(strings = {"  ", "\t", "\n"})
    void testForAllTypesOfBlankStrings(String input) {
        boolean result = checker.isInputBlankOrNull(input);
        assertTrue(result);
    }
}