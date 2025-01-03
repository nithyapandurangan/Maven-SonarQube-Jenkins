package com.example;

import org.junit.jupiter.api.Test;

public class MainTest {

    @Test
    public void testMainMethod() {
        // Testing the main method by calling it without arguments
        Main.main(new String[] {}); // No input is passed here.
    }

    @Test
    public void testConstructor() {
        // Testing the constructor by creating an instance of Main
        new Main();  // This will cover the constructor and any logic within it
    }
}
