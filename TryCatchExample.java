//***************************************************
//
// Assignment 1: Exception Processing
//
// Author: Joshua Spencer
// Course: CPT-237-W38
// Section: 01
// Semester: Fall 2026
//
// Description: Prompts user for an integer and double
// with try-catch input validation loops, and performs 
// division with divide-by-zero exception handling.
//
//***************************************************

import java.util.InputMismatchException;
import java.util.Scanner;

public class TryCatchExample {

    public static void main(String[] args) {
        
        Scanner input = new Scanner(System.in);
        int intVal = 0;
        double doubleVal = 0.0;
        boolean validInt = false;
        boolean validDouble = false;

        // Loop until a valid integer is entered
        while (!validInt) {
            try {
                System.out.print("Input integer value: ");
                intVal = input.nextInt();
                validInt = true; // Exit loop if successful
            } catch (InputMismatchException e) {
                System.out.println("Error: Invalid integer input! Please enter a valid whole number.");
                input.nextLine(); // Clear the invalid input buffer
            }
        }

        // Loop until a valid double is entered
        while (!validDouble) {
            try {
                System.out.print("Input double value: ");
                doubleVal = input.nextDouble();
                validDouble = true; // Exit loop if successful
            } catch (InputMismatchException e) {
                System.out.println("Error: Invalid double value input! Please enter a valid decimal number.");
                input.nextLine(); // Clear the invalid input buffer
            }
        }

        System.out.println("\nInteger input was: " + intVal);
        System.out.println("Double input was: " + doubleVal);

        // Perform division and handle divide by zero
        try {
            System.out.println("\nAttempting division (integer / double)...");
            
            // Explicitly throw ArithmeticException if double value is zero
            if (doubleVal == 0.0) {
                throw new ArithmeticException("Cannot divide by zero!");
            }

            double result = intVal / doubleVal;
            System.out.println("Result of " + intVal + " / " + doubleVal + " = " + result);

        } catch (ArithmeticException e) {
            System.out.println("Error: Division by zero is not allowed! Terminating program.");
            // Program terminates naturally after catching this exception
        }

        input.close();
    }
}