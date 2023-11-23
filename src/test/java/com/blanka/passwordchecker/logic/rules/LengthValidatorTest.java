package com.blanka.passwordchecker.logic.rules;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class LengthValidatorTest {
    LengthValidator validator = new LengthValidator();

    @ParameterizedTest
    @NullAndEmptySource
    @ValueSource(strings = {"  ", "\t", "\n"})
    void testForAllTypesOfBlankStrings(String password) {
        boolean result = validator.isValid(password);
        assertFalse(result);
    }

    @Test
    void testWithOneWord() {
        String password = "right?";
        boolean result = validator.isValid(password);
        assertFalse(result);
    }

    @Test
    void testWithMoreWords() {
        String password = "it is a test?";
        boolean result = validator.isValid(password);
        assertTrue(result);
    }
}