package com.blanka.passwordchecker.logic.rules;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class UniqueWordsValidatorTest {
    UniqueWordsValidator validator = new UniqueWordsValidator();

    @Test
    void testValidCase() {
        String password = "it is a test.";
        boolean result = validator.isValid(password);
        assertTrue(result);
    }

    @Test
    void testWhenThereAreRepetitiveWords() {
        String password = "tests and more tests!";
        boolean result = validator.isValid(password);
        assertFalse(result);
    }
}