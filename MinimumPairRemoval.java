import java.util.*;

class Solution {
    public int minimumPairRemoval(int[] nums) {
        int operations = 0;
        // Convert to a List for easy manipulation
        List<Integer> list = new ArrayList<>();
        for (int num : nums) {
            list.add(num);
        }

        // Continue until the array is non-decreasing
        while (!isNonDecreasing(list)) {
            int minSum = Integer.MAX_VALUE;
            int leftIndex = -1;

            // Find the leftmost pair with the minimum sum
            for (int i = 0; i < list.size() - 1; i++) {
                int currentSum = list.get(i) + list.get(i + 1);
                if (currentSum < minSum) {
                    minSum = currentSum;
                    leftIndex = i;
                }
            }

            // Replace the pair with their sum
            list.set(leftIndex, minSum);
            list.remove(leftIndex + 1);
            operations++;
        }

        return operations;
    }

    // Helper method to check if the list is non-decreasing
    private boolean isNonDecreasing(List<Integer> list) {
        for (int i = 0; i < list.size() - 1; i++) {
            if (list.get(i) > list.get(i + 1)) {
                return false;
            }
        }
        return true;
    }
}