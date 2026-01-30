import java.util.*;

class Solution {
    public long minimumCost(String source, String target, String[] original, String[] changed, int[] cost) {
        int n = source.length();
        
        // 1. Collect all unique strings and map them to IDs
        Map<String, Integer> stringToId = new HashMap<>();
        for (String s : original) if (!stringToId.containsKey(s)) stringToId.put(s, stringToId.size());
        for (String s : changed) if (!stringToId.containsKey(s)) stringToId.put(s, stringToId.size());
        
        int numUnique = stringToId.size();
        long[][] dist = new long[numUnique][numUnique];
        for (long[] row : dist) Arrays.fill(row, Long.MAX_VALUE / 2);
        for (int i = 0; i < numUnique; i++) dist[i][i] = 0;
        
        // 2. Build the graph
        for (int i = 0; i < original.length; i++) {
            int u = stringToId.get(original[i]);
            int v = stringToId.get(changed[i]);
            dist[u][v] = Math.min(dist[u][v], cost[i]);
        }
        
        // 3. Floyd-Warshall for all-pairs shortest paths
        for (int k = 0; k < numUnique; k++) {
            for (int i = 0; i < numUnique; i++) {
                if (dist[i][k] == Long.MAX_VALUE / 2) continue;
                for (int j = 0; j < numUnique; j++) {
                    dist[i][j] = Math.min(dist[i][j], dist[i][k] + dist[k][j]);
                }
            }
        }
        
        // 4. DP with Trie or Hash Sets of lengths for optimization
        Set<Integer> lengths = new HashSet<>();
        for (String s : original) lengths.add(s.length());
        
        long[] dp = new long[n + 1];
        Arrays.fill(dp, Long.MAX_VALUE / 2);
        dp[0] = 0;
        
        for (int i = 0; i < n; i++) {
            if (dp[i] == Long.MAX_VALUE / 2) continue;
            
            // Case 1: Characters are already equal
            if (source.charAt(i) == target.charAt(i)) {
                dp[i + 1] = Math.min(dp[i + 1], dp[i]);
            }
            
            // Case 2: Substring replacement
            for (int len : lengths) {
                if (i + len <= n) {
                    String subSource = source.substring(i, i + len);
                    String subTarget = target.substring(i, i + len);
                    
                    if (stringToId.containsKey(subSource) && stringToId.containsKey(subTarget)) {
                        int u = stringToId.get(subSource);
                        int v = stringToId.get(subTarget);
                        if (dist[u][v] < Long.MAX_VALUE / 2) {
                            dp[i + len] = Math.min(dp[i + len], dp[i] + dist[u][v]);
                        }
                    }
                }
            }
        }
        
        return dp[n] >= Long.MAX_VALUE / 2 ? -1 : dp[n];
    }
}