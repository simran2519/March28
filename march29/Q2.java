//2.Problem statement
//        Bob lives with his wife in a city named Berland. Bob is a good husband, so he goes out with his wife every Friday to ‘Arcade’ mall.
//
//        ‘Arcade’ is a very famous mall in Berland. It has a very unique transportation method between shops. Since the shops in the mall are laying in a straight line, you can jump on a very advanced trampoline from the shop i, and land in any shop between (i) to (i + Arr[i]), where Arr[i] is a constant given for each shop.
//
//        There are N shops in the mall, numbered from 0 to N-1. Bob's wife starts her shopping journey from shop 0 and ends it in shop N-1. As the mall is very crowded on Fridays, unfortunately, Bob gets lost from his wife. So he wants to know, what is the minimum number of trampoline jumps from shop 0 he has to make in order to reach shop N-1 and see his wife again. If it is impossible to reach the last shop, return -1.
//
//        Detailed explanation ( Input/output format, Notes, Images )
//        Constraints :
//        1 <= T <= 10
//        1 <= N <= 5 * 10^4
//        0 <= Arr[i] <= N
//        Where T is the number of test cases, N is the size of the array and Arr[i] is the ith element in the array.
//        Sample Input 1:
//        2
//        5
//        2 1 3 2 4
//        3
//        3 2 1
//        Sample Output 1:
//        2
//        1
//        Explanation For Sample Input 1:
//        In the 1st test case, Bobs jumps from shop 0 to shop 2 and then jumps from shop 2 to shop 4, so he needs two jumps to reach the last shop.
//
//        In the 2nd test case, Bobs jumps from shop 0 to shop 2, so he needs only one jump to reach the last shop.
//        Sample Input 2:
//        2
//        5
//        1 0 3 2 1
//        4
//        1 1 1 1
//        Sample Output 2:
//        -1
//        3
package march29;

import java.util.*;

public class Q2 {
    static class Pair {
        int shop;
        int jumps;

        Pair(int shop, int jumps) {
            this.shop = shop;
            this.jumps = jumps;
        }
    }

    public static int minTrampolineJumps(int[] arr) {
        int n = arr.length;
        boolean[] visited = new boolean[n];
        Queue<Pair> queue = new LinkedList<>();
        queue.offer(new Pair(0, 0)); // Start from shop 0 with 0 jumps

        while (!queue.isEmpty()) {
            Pair current = queue.poll();
            int shop = current.shop;
            int jumps = current.jumps;

            if (shop == n - 1) { // Reached the last shop
                return jumps;
            }

            for (int i = shop + 1; i <= Math.min(shop + arr[shop], n - 1); i++) {
                if (!visited[i]) {
                    visited[i] = true;
                    queue.offer(new Pair(i, jumps + 1));
                }
            }
        }

        return -1; // Unable to reach the last shop
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt(); // Number of test cases

        while (t-- > 0) {
            int n = scanner.nextInt(); // Number of shops
            int[] arr = new int[n]; // Array of trampoline jumps

            for (int i = 0; i < n; i++) {
                arr[i] = scanner.nextInt();
            }

            int result = minTrampolineJumps(arr);
            System.out.println(result);
        }
        scanner.close();
    }
}
