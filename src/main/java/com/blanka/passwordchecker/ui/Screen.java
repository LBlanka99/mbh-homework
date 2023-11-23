package com.blanka.passwordchecker.ui;

public class Screen {

    public void showResult(int count) {
        System.out.println("Helyes jelmondatok szama: " + count);
    }

    public void handleError() {
        System.out.println("An error occurred. Check the error message and try again!");
    }
}
