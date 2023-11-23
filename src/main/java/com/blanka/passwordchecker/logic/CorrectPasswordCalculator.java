package com.blanka.passwordchecker.logic;

import com.blanka.passwordchecker.data.FileReader;
import com.blanka.passwordchecker.logic.rules.PasswordValidator;
import com.blanka.passwordchecker.ui.Screen;

import java.util.List;

public class CorrectPasswordCalculator {
    private final String FILE_PATH;
    private final List<PasswordValidator> rules;
    private final Screen screen;

    public CorrectPasswordCalculator(String FILE_PATH, List<PasswordValidator> rules) {
        this.FILE_PATH = FILE_PATH;
        this.rules = rules;
        screen = new Screen();
    }

    public void run() {
        var data = FileReader.readFile(FILE_PATH);
        List<String> sentences;
        if (data.isPresent()) {
            sentences = data.get();
        } else {
            screen.handleError();
            return;
        }

        int counter = 0;
        for (String password : sentences) {
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
