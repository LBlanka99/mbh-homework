package com.blanka.passwordchecker.logic.rules;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class LowerCaseLetterValidatorTest {
    LowerCaseLetterValidator validator = new LowerCaseLetterValidator();

    @Test
    void testValidCase() {
        String password = "it is a test.";
        boolean result = validator.isValid(password);
        assertTrue(result);
    }

    @Test
    void testWithUpperCase() {
        String password = "it is a Test.";
        boolean result = validator.isValid(password);
        assertFalse(result);
    }

    @Test
    void testWithNotAllowedChars() {
        String password = "it is a test, or not?";
        boolean result = validator.isValid(password);
        assertFalse(result);
    }
}