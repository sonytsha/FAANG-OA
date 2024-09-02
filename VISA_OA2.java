/* You are developing a simple version control system. Your system can support branches., and you can switch between branches or
 update the files in a branch using the following actions : 

Switch<branch name> -- so it's just to the branch with given name. 

Push < file name > -- pushes the file to the current branch. 

Note that if the file was pushed to the current branch before, then the number of files should be changed. 

Your task is to process all the logs and return the branch name that contains the largest number of files at the end. 
It is guaranteed that there is no tie.   */


/* logs = ["switch branch1", "push file1", "push file2", "switch branch2", "push file1", "switch branch1", "push file3"]   */
import java.util.*;

public class VISA_OA2 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Read the number of logs
        int numberOfLogs = sc.nextInt();
        sc.nextLine(); // Consume the newline character

        // Read log entries
        String[] logs = new String[numberOfLogs];
        for (int i = 0; i < numberOfLogs; i++) {
            logs[i] = sc.nextLine();
        }

        // Compute the result using the solution method
        String resultBranch = solution(logs);

        // Output the result
        System.out.println(resultBranch);
    }

    public static String solution(String[] logs) {
        Map<String, Set<String>> branches = new HashMap<>();
        String currentBranch = "";
        String resultBranch = "";
        int maxFiles = 0;

        // Iterate through each log entry
        for (int i = 0; i < logs.length; i++) {
            String[] parts = logs[i].split(" ");

            if (parts[0].equals("switch")) {
                currentBranch = parts[1];
                branches.putIfAbsent(currentBranch, new HashSet<>());
            } else if (parts[0].equals("push")) {
                branches.get(currentBranch).add(parts[1]);
            }
        }

        // Convert the map keys to a list to use index-based access
        List<String> branchNames = new ArrayList<>(branches.keySet());

        // Use a traditional for loop to find the branch with the most files
        for (int i = 0; i < branchNames.size(); i++) {
            String branchName = branchNames.get(i);
            int fileCount = branches.get(branchName).size();

            if (fileCount > maxFiles) {
                maxFiles = fileCount;
                resultBranch = branchName;
            }
        }

        return resultBranch;
    }

}


/* Example Input
Let's use the following input:

perl
Copy code
5
switch A
push file1
push file2
switch B
push file3
switch A
push file4
Walkthrough with Printed States
Here's the modified main method with added print statements to trace the execution:

java
Copy code
import java.util.*;

public class VISA_OA2 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Read the number of logs
        int numberOfLogs = sc.nextInt();
        sc.nextLine(); // Consume the newline character

        // Read log entries
        String[] logs = new String[numberOfLogs];
        for (int i = 0; i < numberOfLogs; i++) {
            logs[i] = sc.nextLine();
        }

        // Compute the result using the solution method
        String resultBranch = solution(logs);

        // Output the result
        System.out.println("Branch with the most files: " + resultBranch);
    }

    public static String solution(String[] logs) {
        Map<String, Set<String>> branches = new HashMap<>();
        String currentBranch = "";
        String resultBranch = "";
        int maxFiles = 0;

        System.out.println("Initial state:");
        System.out.println("Branches: " + branches);
        System.out.println("Current Branch: " + currentBranch);

        // Iterate through each log entry
        for (int i = 0; i < logs.length; i++) {
            String[] parts = logs[i].split(" ");

            System.out.println("\nProcessing log: " + logs[i]);

            if (parts[0].equals("switch")) {
                currentBranch = parts[1];
                branches.putIfAbsent(currentBranch, new HashSet<>());

                System.out.println("Switched to branch: " + currentBranch);
                System.out.println("Branches: " + branches);
            } else if (parts[0].equals("push")) {
                branches.get(currentBranch).add(parts[1]);

                System.out.println("Pushed file: " + parts[1] + " to branch: " + currentBranch);
                System.out.println("Branches: " + branches);
            }
        }

        // Convert the map keys to a list to use index-based access
        List<String> branchNames = new ArrayList<>(branches.keySet());

        // Use a traditional for loop to find the branch with the most files
        for (int i = 0; i < branchNames.size(); i++) {
            String branchName = branchNames.get(i);
            int fileCount = branches.get(branchName).size();

            System.out.println("\nChecking branch: " + branchName);
            System.out.println("File count for branch " + branchName + ": " + fileCount);

            if (fileCount > maxFiles) {
                maxFiles = fileCount;
                resultBranch = branchName;

                System.out.println("New max found! Branch: " + branchName + " with files: " + maxFiles);
            }
        }

        return resultBranch;
    }
}
Detailed Output Explanation
Initial State:
yaml
Copy code
Initial state:
Branches: {}
Current Branch:
Processing Each Log:
Log: switch A

less
Copy code
Processing log: switch A
Switched to branch: A
Branches: {A=[]}
Current Branch: A
Branches Map: {A=[]}
Log: push file1

css
Copy code
Processing log: push file1
Pushed file: file1 to branch: A
Branches: {A=[file1]}
Current Branch: A
Branches Map: {A=[file1]}
Log: push file2

css
Copy code
Processing log: push file2
Pushed file: file2 to branch: A
Branches: {A=[file1, file2]}
Current Branch: A
Branches Map: {A=[file1, file2]}
Log: switch B

less
Copy code
Processing log: switch B
Switched to branch: B
Branches: {A=[file1, file2], B=[]}
Current Branch: B
Branches Map: {A=[file1, file2], B=[]}
Log: push file3

css
Copy code
Processing log: push file3
Pushed file: file3 to branch: B
Branches: {A=[file1, file2], B=[file3]}
Current Branch: B
Branches Map: {A=[file1, file2], B=[file3]}
Log: switch A

less
Copy code
Processing log: switch A
Switched to branch: A
Branches: {A=[file1, file2], B=[file3]}
Current Branch: A
Branches Map: {A=[file1, file2], B=[file3]}
Log: push file4

css
Copy code
Processing log: push file4
Pushed file: file4 to branch: A
Branches: {A=[file1, file2, file4], B=[file3]}
Current Branch: A
Branches Map: {A=[file1, file2, file4], B=[file3]}
Finding the Branch with the Most Files:
Checking Branch A

less
Copy code
Checking branch: A
File count for branch A: 3
New max found! Branch: A with files: 3
Max Files: 3
Result Branch: A
Checking Branch B

less
Copy code
Checking branch: B
File count for branch B: 1
Max Files: 3
Result Branch: A
Final Output:
csharp
Copy code
Branch with the most files: A
Summary
By adding print statements, you can see how the internal state of your branches map and currentBranch variable changes after each operation. This detailed output helps you understand the flow of data and how the final result is derived. This approach is helpful for debugging and explaining the logic behind your code.
 */