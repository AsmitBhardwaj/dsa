public class SwapArrays {
    public int minSwaps(int[][] grid) {
        int n = grid.length;
        int[] trailingZeros = new int[n];
        
        // Step 1: Precompute trailing zeros for each row
        for (int i = 0; i < n; i++) {
            int count = 0;
            for (int j = n - 1; j >= 0; j--) {
                if (grid[i][j] == 0) {
                    count++;
                } else {
                    break;
                }
            }
            trailingZeros[i] = count;
        }
        
        int totalSwaps = 0;
        
        // Step 2: Greedy selection for each position i
        for (int i = 0; i < n; i++) {
            int target = n - 1 - i;
            int foundIdx = -1;
            
            // Find the first row that satisfies the zero requirement
            for (int j = i; j < n; j++) {
                if (trailingZeros[j] >= target) {
                    foundIdx = j;
                    break;
                }
            }
            
            // If no such row exists, it's impossible
            if (foundIdx == -1) return -1;
            
            // Step 3: Simulate adjacent swaps (bubble the row up to index i)
            // This is equivalent to shifting elements down
            for (int k = foundIdx; k > i; k--) {
                int temp = trailingZeros[k];
                trailingZeros[k] = trailingZeros[k - 1];
                trailingZeros[k - 1] = temp;
                totalSwaps++;
            }
        }
        
        return totalSwaps;
    }
} 
    

