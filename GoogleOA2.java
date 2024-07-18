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

 // o(n) tc and o(1) sc code


public class GoogleOA2 {
    
    public static int countPartitions(int[] arr) {
        int n = arr.length;
        int count = 0;
        int numNegatives = 0;
        
        for (int i = 0; i < n; i++) {
            if (arr[i] < 0) {
                numNegatives++;
            }
            else {
                if (numNegatives > 0) {
                    count += numNegatives;
                }
            }
        }
        
        // Add the last partition if it ends with negatives
        if (numNegatives > 0) {
            count += numNegatives;
        }
        
        return count;
    }
    
    public static void main(String[] args) {
        int[] arr1 = {-1, -2, -3, -4};
        int[] arr2 = {-2, 1, -3};
        
        int result1 = countPartitions(arr1);
        int result2 = countPartitions(arr2);
        
        System.out.println("Number of valid partitions for arr1: " + result1);
        System.out.println("Number of valid partitions for arr2: " + result2);
    }
}

    