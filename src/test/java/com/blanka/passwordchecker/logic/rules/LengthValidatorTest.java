package com.blanka.passwordchecker.logic.rules;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class LengthValidatorTest {
    LengthValidator validator = new LengthValidator();

    @Test
    void testEmptyString() {
        String password = "";
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