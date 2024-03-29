//1.Problem statement
//        You are given two strings, 'str1' and 'str2'. You have to find the length of the longest common substring.
//
//
//
//        A substring is a continuous segment of a string. For example, "bcd" is a substring of "abcd", while "acd" or "cda" are not.
//
//
//
//        Example:
//        Input: ‘str1’ = “abcjklp” , ‘str2’ = “acjkp”.
//
//        Output: 3
//
//        Explanation:  The longest common substring between ‘str1’ and ‘str2’ is “cjk”, of length 3.
//        Detailed explanation ( Input/output format, Notes, Images )
//        Sample Input 1:
//        wasdijkl
//        wsdjkl
//        Sample Output 1:
//        3
//        Explanation Of Sample Input 1 :
//        The longest common substring is “jkl”, of length 3.
//        Sample Input 2:
//        tyfg
//        cvbnuty
//        Sample Output 2:
//        2
//        Explanation Of Sample Input 2 :
//        The longest common substring is “ty”, of length 2.
//        Expected time complexity:
//        The expected time complexity is O(n*m),
//        Where ‘n’ and ‘m’ are the lengths of ‘st1’ and ‘str2’ respectively.
//        Constraints:
//        1 <= str1.length <= 1000
//        1 <= str2.length <= 1000

package march29;

public class Q1 {
    public static int longestCommonSubstring(String str1, String str2) {
        int m = str1.length();
        int n = str2.length();

        // Create a table to store lengths of longest common suffixes of substrings
        // Initialize a table with zeros
        int[][] dp = new int[m + 1][n + 1];

        // Variable to store the length of the longest common substring
        int maxLength = 0;

        // Fill the dp table
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (str1.charAt(i - 1) == str2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                    maxLength = Math.max(maxLength, dp[i][j]);
                }
            }
        }

        return maxLength;
    }

    public static void main(String[] args) {
        // Test cases
        System.out.println(longestCommonSubstring("abcjklp", "acjkp"));    // Output: 3
        System.out.println(longestCommonSubstring("wasdijkl", "wsdjkl"));   // Output: 3
        System.out.println(longestCommonSubstring("tyfg", "cvbnuty"));     // Output: 2
    }
}
