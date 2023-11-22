package com.blanka.passwordchecker.data;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.Optional;
import java.util.logging.Level;
import java.util.logging.Logger;

public class FileReader {
    private static final Logger LOGGER = Logger.getLogger(FileReader.class.getName());

    public static Optional<List<String>> readFile(String filename) {
        Optional<List<String>> sentences = Optional.empty();

        try {
            sentences = Optional.of(Files.readAllLines(Paths.get(filename)));
        } catch (IOException e) {
            LOGGER.log(Level.SEVERE, "Error reading file: " + filename, e);
        }

        return sentences;
    }
}

