/*You are given an array of negative integers. Visits. Which represents how many people visited a website on consecutive days. Visit [0] is the number of visitors on the first day. Visits[1] is the number of visitors on the second day and so on. 

Your task is to return the index I of the first day when the total number of visits reach a given target. In other words, visit[0] visits [1]... visits [I]  >= target. If the sum of all daily visits never reaches the target, return -1. 

Note you are not expected to provide the most optimal solution, but a solution with time complexity not worse than o(visits.length)^2. Within the execution time limit. 

 

 

int[] visits = {-5, -3, -10, -1, -8}; 

int target = -15; 

   */



import java.util.Scanner;

public class VISA_OA1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int numberOfVisitors = sc.nextInt();
        int[] visits = new int[numberOfVisitors];
        
        for (int i = 0; i < numberOfVisitors; i++) {
            visits[i] = sc.nextInt();
        }
        
        int target = sc.nextInt();
        int ans = solution(visits, target);
        System.out.println(ans);
    }

    public static int solution(int[] visits, int target) {
        int sum = 0;
        for (int i = 0; i < visits.length; i++) {
            sum += visits[i];
            if (sum >= target) {
                return i;
            }
        }
        return -1;
    }
}

