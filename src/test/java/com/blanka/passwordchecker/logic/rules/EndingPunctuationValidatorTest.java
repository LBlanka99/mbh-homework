package com.blanka.passwordchecker.logic.rules;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class EndingPunctuationValidatorTest {
    EndingPunctuationValidator validator = new EndingPunctuationValidator();

    @Test
    void testValidCase() {
        String password = "it is a test!";
        boolean result = validator.isValid(password);
        assertTrue(result);
    }

    @Test
    void testWhenThereIsNoEndingPunctuation() {
        String password = "it is a test";
        boolean result = validator.isValid(password);
        assertFalse(result);
    }

    @Test
    void testWhenThereIsWrongPunctuation() {
        String password = "it is a test;";
        boolean result = validator.isValid(password);
        assertFalse(result);
    }

    @Test
    void testWhenThereIsOnlyOneCharacter() {
        String password = "?";
        boolean result = validator.isValid(password);
        assertTrue(result);
    }
}