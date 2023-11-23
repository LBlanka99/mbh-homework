package com.blanka.passwordchecker;


import com.blanka.passwordchecker.logic.CorrectPasswordCalculator;
import com.blanka.passwordchecker.logic.rules.*;

import java.util.ArrayList;
import java.util.List;

public class Application {
    public static final String FILE_PATH = "src/main/resources/input.txt";

    public static void main(String[] args) {

        List<PasswordValidator> rules = getRules();

        //instantiate calculator & run the program
        CorrectPasswordCalculator calculator = new CorrectPasswordCalculator(FILE_PATH, rules);
        calculator.run();
    }

    private static List<PasswordValidator> getRules() {
        //instantiate validators
        EndingPunctuationValidator endingPunctuationValidator = new EndingPunctuationValidator();
        LengthValidator lengthValidator = new LengthValidator();
        LowerCaseLetterValidator lowerCaseLetterValidator = new LowerCaseLetterValidator();
        UniqueWordsValidator uniqueWordsValidator = new UniqueWordsValidator();
        UnnecessarySpacesValidator unnecessarySpacesValidator = new UnnecessarySpacesValidator();

        //put all validators in a list
        return new ArrayList<>(
                List.of(endingPunctuationValidator,
                        lengthValidator,
                        lowerCaseLetterValidator,
                        uniqueWordsValidator,
                        unnecessarySpacesValidator)
        );
    }
}
