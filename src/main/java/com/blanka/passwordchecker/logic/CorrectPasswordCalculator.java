package com.blanka.passwordchecker.logic;

import com.blanka.passwordchecker.data.FileReader;
import com.blanka.passwordchecker.logic.inputchecker.InputChecker;
import com.blanka.passwordchecker.logic.rules.PasswordValidator;
import com.blanka.passwordchecker.ui.Screen;

import java.util.List;

public class CorrectPasswordCalculator {
    private final String FILE_PATH;
    private final List<PasswordValidator> rules;
    private final Screen screen;
    private final InputChecker inputChecker;

    public CorrectPasswordCalculator(String FILE_PATH, List<PasswordValidator> rules) {
        this.FILE_PATH = FILE_PATH;
        this.rules = rules;
        screen = new Screen();
        inputChecker = new InputChecker();
    }

    public void run() {
        //read data from file
        var data = FileReader.readFile(FILE_PATH);
        List<String> sentences;
        if (data.isPresent()) {
            sentences = data.get();
        } else {
            screen.handleError();
            return;
        }

        //check every not blank sentence with every validator & count the right ones
        int counter = 0;
        for (String password : sentences) {
            if (inputChecker.isInputBlankOrNull(password)) {
                continue;
            }

            boolean isCorrect = true;
            for (PasswordValidator rule : rules) {
                if (!rule.isValid(password)) {
                    isCorrect = false;
                    break;
                }
            }

            if (isCorrect) {
                counter++;
            }
        }

        screen.showResult(counter);
    }
}
