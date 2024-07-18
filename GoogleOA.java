/* Find the number of partitions of an array such that each contiguous partition consists of atleast one negative number.
eg. [-1,-2,-3,-4] has these possible partitions :
[-1],[-2],[-3],[-4];
[-1,-2],[-3,-4];
[-1,-2,-3] ,[-4];
[-1],[-2,-3,-4];
[-1][-2,-3],[-4];


*/

/* [-2, 1, -3]:

[-2, 1] and [-3]
[-2] and [1, -3]
[-2, 1, -3]
Total = 3
[-1, -2, -3, -4]:

[-1], [-2], [-3], [-4]
[-1, -2], [-3, -4]
[-1, -2, -3], [-4]
[-1], [-2, -3, -4]
[-1], [-2, -3], [-4]
Total = 5
 */

 
 public class GoogleOA {
    
    public static int countPartitions(int[] arr) {
        int n = arr.length;
        int[] dp = new int[n + 1];
        
        // Initialize dp[0] to 0 (no valid partitions for an empty subarray)
        dp[0] = 0;
        
        for (int i = 1; i <= n; i++) {
            dp[i] = dp[i - 1];
            for (int j = i - 1; j >= 0; j--) {
                if (arr[j] < 0) {
                    dp[i]++;
                    break;
                }
            }
        }
        
        return dp[n];
    }
    
    public static void main(String[] args) {
        int[] arr = {-1, -2, -3, -4};
        int[] arr2 = {-1, 2, -3};
        
        int result = countPartitions(arr);
        int result2 = countPartitions(arr2);
        
        System.out.println("Number of valid partitions for arr: " + result);
        System.out.println("Number of valid partitions for arr2: " + result2);
    }
}

