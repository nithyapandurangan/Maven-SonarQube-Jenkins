package com.example;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

class Main {
    private static final Logger logger = LoggerFactory.getLogger(Main.class);

    public static void main(String[] args) {
        logger.info("Main application running...");
        
        // Simulate some action
        try {
            processApplication(args);
        } catch (Exception e) {
            logger.error("An error occurred: ", e);
        }
        
        logger.info("Main application finished.");
    }

    // Refactored method for better testability
    public static void processApplication(String[] args) throws Exception {
        logger.info("Processing...");

        // Simulate some process logic
        if (args.length == 0) {
            throw new IllegalArgumentException("No arguments provided");
        }
        
        if ("error".equals(args[0])) {
            throw new RuntimeException("Simulated error");
        }
        
        // More processing logic...
    }
}
