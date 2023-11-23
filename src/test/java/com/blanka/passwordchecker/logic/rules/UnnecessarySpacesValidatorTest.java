package com.blanka.passwordchecker.logic.rules;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class UnnecessarySpacesValidatorTest {
    UnnecessarySpacesValidator validator = new UnnecessarySpacesValidator();

    @Test
    void testValidCase() {
        String password = "it is a test.";
        boolean result = validator.isValid(password);
        assertTrue(result);
    }

    @Test
    void testWhenThereIsASpaceAtTheBeginning() {
        String password = " it is a test?";
        boolean result = validator.isValid(password);
        assertFalse(result);
    }

    @Test
    void testWhenThereIsASpaceBeforeTheEndingPunctuation() {
        String password = "it is a test ?";
        boolean result = validator.isValid(password);
        assertFalse(result);
    }

    @Test
    void testWhenThereAreMoreSpacesBetweenWords() {
        String password = "it is a       test?";
        boolean result = validator.isValid(password);
        assertFalse(result);
    }

    @Test
    void testWhenThereIsOnlyOneCharacter() {
        String password = "a";
        boolean result = validator.isValid(password);
        assertTrue(result);
    }
}