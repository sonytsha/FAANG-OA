/* A text editor is a type. Off computer program that allows users to edit plain text. Your task is to simulate a simplified text
 editor which can handle three types of operations. 

INSERT< text> - adds <text> to the end of the current text where <text> Is a string consisting of 20 English letters at most. 

BACKSPACE - It is is the last character of the current text. If the current text is empty, this does nothing. 

UNDO  - undo the last successful insert or backspace operation. If there is nothing to undo, this does nothing. 

Note. An operation is considered successful if the current text in the editor is changed by the operation.  */

import java.util.Scanner;

public class VISA_OA3 {
    public static void main(String[] args) {
        // Initialize the scanner to read user input
        Scanner sc = new Scanner(System.in);
        
        // Prompt the user for the number of operations
        System.out.println("Enter the number of operations: ");
        int n = sc.nextInt();
        sc.nextLine(); // consume the remaining newline character
        
        // Initialize an array to hold the operations
        String[] operations = new String[n];
        
        // Prompt the user to enter each operation
        System.out.println("Enter the operations (INSERT <text>, BACKSPACE, or UNDO): ");
        for (int i = 0; i < n; i++) {
            operations[i] = sc.nextLine();
        }
        
        // Call the solution function and store the result
        String[] result = solution(operations);
        
        // Display the final result
        System.out.println("Final Text States after each operation:");
        for (int i = 0; i < result.length; i++) {
            System.out.println("After operation " + (i + 1) + ": " + result[i]);
        }
        
        // Close the scanner
        sc.close();
    }
    
    public static String[] solution(String[] operations) {
        // Initialize a StringBuilder to keep track of the current text in the editor
        StringBuilder currentText = new StringBuilder();
        
        // Initialize an array to store the history of text states for undo operations
        String[] history = new String[operations.length];
        
        // Index to track the position in the history array
        int historyIndex = -1;
        
        // Array to store the result after each operation
        String[] result = new String[operations.length];
        
        // Loop through each operation in the operations array
        for (int i = 0; i < operations.length; i++) {
            // Get the current operation
            String operation = operations[i];
            System.out.println("Current Operation: " + operation);
            
            // If the operation is an INSERT
            if (operation.startsWith("INSERT")) {
                // Save the current state of text in history before modification
                history[++historyIndex] = currentText.toString();
                System.out.println("Before INSERT: " + currentText);
                
                // Extract the text to be inserted by removing "INSERT " from the operation
                String textToInsert = operation.substring("INSERT ".length());
                
                // Append the extracted text to the current text
                currentText.append(textToInsert);
                System.out.println("After INSERT: " + currentText);
                
            // If the operation is a BACKSPACE
            } else if (operation.equals("BACKSPACE")) {
                // Ensure there is something to delete
                if (currentText.length() > 0) {
                    // Save the current state of text in history before modification
                    history[++historyIndex] = currentText.toString();
                    System.out.println("Before BACKSPACE: " + currentText);
                    
                    // Remove the last character from the current text
                    currentText.deleteCharAt(currentText.length() - 1);
                    System.out.println("After BACKSPACE: " + currentText);
                } else {
                    System.out.println("BACKSPACE ignored, text is empty.");
                }
                
            // If the operation is an UNDO
            } else if (operation.equals("UNDO")) {
                // Ensure there is a previous state to revert to
                if (historyIndex >= 0) {
                    System.out.println("Before UNDO: " + currentText);
                    // Revert to the last saved state in history
                    currentText = new StringBuilder(history[historyIndex--]);
                    System.out.println("After UNDO: " + currentText);
                } else {
                    System.out.println("UNDO ignored, nothing to undo.");
                }
            }
            
            // Store the current state of text after the operation in the result array
            result[i] = currentText.toString();
            System.out.println("Result after operation " + (i + 1) + ": " + result[i]);
        }
        
        // Return the final result array containing the text state after each operation
        return result;
    }
}
