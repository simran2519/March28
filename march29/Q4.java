//4.Problem statement
//        You are given an array 'ARR' of 'N' positive integers. Your task is to find if we can partition the given array into two subsets such that the sum of elements in both subsets is equal.
//
//        For example, let’s say the given array is [2, 3, 3, 3, 4, 5], then the array can be partitioned as [2, 3, 5], and [3, 3, 4] with equal sum 10.
//
//        Follow Up:
//
//        Can you solve this using not more than O(S) extra space, where S is the sum of all elements of the given array?
//        Detailed explanation ( Input/output format, Notes, Images )
//        Constraints:
//        1 <= 'T' <= 10
//        1 <= 'N' <= 100
//        1 <= 'ARR'[i] <= 100
//
//        Time Limit: 1 sec
//        Sample Input 1:
//        2
//        6
//        3 1 1 2 2 1
//        5
//        5 6 5 11 6
//        Sample Output 1:
//        true
//        false
//        Explanation Of Sample Input 1:
//        For the first test case, the array can be partitioned as ([2,1,1,1] and [3, 2]) or ([2,2,1], and [1,1,3]) with sum 5.
//
//        For the second test case, the array can’t be partitioned.
//        Sample Input 2:
//        2
//        9
//        2 2 1 1 1 1 1 3 3
//        6
//        8 7 6 12 4 5
//        Sample Output 2:
//        false
//        true
package march29;

import java.util.*;

public class Q4 {
    public static boolean canPartition(int[] nums) {
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }
        if (sum % 2 != 0) {
            return false; // If sum is odd, can't partition into equal sum subsets
        }

        sum /= 2; // As we're looking for equal sum subsets, divide by 2

        boolean[] dp = new boolean[sum + 1];
        dp[0] = true; // Base case: 0 sum is always possible

        for (int num : nums) {
            for (int j = sum; j >= num; j--) {
                dp[j] = dp[j] || dp[j - num];
            }
        }

        return dp[sum];
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt(); // Number of test cases

        while (t-- > 0) {
            int n = scanner.nextInt(); // Size of the array
            int[] arr = new int[n];

            for (int i = 0; i < n; i++) {
                arr[i] = scanner.nextInt();
            }

            boolean result = canPartition(arr);
            System.out.println(result);
        }
        scanner.close();
    }
}
