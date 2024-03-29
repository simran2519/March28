//3.Problem statement
//        Given two sorted arrays 'a' and 'b' of size 'n' and 'm' respectively.
//
//
//
//        Find the median of the two sorted arrays.
//
//
//
//        Median is defined as the middle value of a sorted list of numbers. In case the length of list is even, median is the average of the two middle elements.
//
//
//
//        The expected time complexity is O(min(logn, logm)), where 'n' and 'm' are the sizes of arrays 'a' and 'b', respectively, and the expected space complexity is O(1).
//
//
//
//        Example:
//        Input: 'a' = [2, 4, 6] and 'b' = [1, 3, 5]
//
//        Output: 3.5
//
//        Explanation: The array after merging 'a' and 'b' will be { 1, 2, 3, 4, 5, 6 }. Here two medians are 3 and 4. So the median will be the average of 3 and 4, which is 3.5.
//        Detailed explanation ( Input/output format, Notes, Images )
//        Sample Input 1:
//        3 3
//        2 4 6
//        1 3 5
//        Sample Output 1:
//        3.5
//        Explanation of Sample Input 1 :
//        The array after merging 'a' and 'b' will be { 1, 2, 3, 4, 5, 6 }.
//        Here two medians are 3 and 4. So the median will be the average of 3 and 4, which is 3.5.
//        Sample Input 2:
//        3 2
//        2 4 6
//        1 3
//        Sample Output 2:
//        3
//        Explanation of Sample Input 2 :
//        The array after merging 'a' and 'b' will be { 1, 2, 3, 4, 6 }.
//        The median is 3.
//        Sample Input 3:
//        3 3
//        1 2 2
//        2 4 4
//        Sample Output 3:
//        2.0
//        Explanation of Sample Input 3 :
//        The array after merging 'a' and 'b' will be { 1, 2, 2, 2, 4, 4 }.
//        Here two medians are 2 and 2. So the median will be the average of 2 and 2, which is 2.
//        Constraints:
//        1 <= 'n' <= 10 ^ 6
//        1 <= 'm' <= 10 ^ 6
//        1 <= 'a[i]' <= 10 ^ 9
//        1 <= 'b[i]' <= 10 ^ 9
//
//        Time limit: 1 sec.
package march29;
public class Q3 {
    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int totalLength = nums1.length + nums2.length;
        if (totalLength % 2 == 0) {
            return (findKthElement(nums1, nums2, totalLength / 2) + findKthElement(nums1, nums2, totalLength / 2 - 1)) / 2.0;
        } else {
            return findKthElement(nums1, nums2, totalLength / 2);
        }
    }

    public static int findKthElement(int[] nums1, int[] nums2, int k) {
        int m = nums1.length;
        int n = nums2.length;
        int i = 0, j = 0;

        while (true) {
            if (i == m) return nums2[j + k];
            if (j == n) return nums1[i + k];
            if (k == 0) return Math.min(nums1[i], nums2[j]);

            int newIndexA = Math.min(i + k / 2, m) - 1;
            int newIndexB = Math.min(j + k / 2, n) - 1;

            if (nums1[newIndexA] <= nums2[newIndexB]) {
                k -= (newIndexA - i + 1);
                i = newIndexA + 1;
            } else {
                k -= (newIndexB - j + 1);
                j = newIndexB + 1;
            }
        }
    }

    public static void main(String[] args) {
        int[] nums1 = {2, 4, 6};
        int[] nums2 = {1, 3, 5};
        System.out.println(findMedianSortedArrays(nums1, nums2)); // Output: 3.5

        int[] nums3 = {2, 4, 6};
        int[] nums4 = {1, 3};
        System.out.println(findMedianSortedArrays(nums3, nums4)); // Output: 3

        int[] nums5 = {1, 2, 2};
        int[] nums6 = {2, 4, 4};
        System.out.println(findMedianSortedArrays(nums5, nums6)); // Output: 2.0
    }
}
