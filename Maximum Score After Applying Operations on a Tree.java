import java.util.ArrayList;
import java.util.List;

class Solution {
    List<List<Integer>> adj;
    
    long solve(int node, int parent, List<Integer> values) {
        if (adj.get(node).size() == 1 && node != 0)
            return values.get(node);
        
        long sum = 0;
        for (int it : adj.get(node)) {
            if (it == parent)
                continue;
            sum += solve(it, node, values);
        }
        
        return Math.min(sum, 1L * values.get(node));
    }
    
    long maximumScoreAfterOperations(List<List<Integer>> edges, List<Integer> values) {
        int n = values.size();
        adj = new ArrayList<>(n);
        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }
        
        for (List<Integer> it : edges) {
            int u = it.get(0);
            int v = it.get(1);
            adj.get(u).add(v);
            adj.get(v).add(u);
        }
        
        long ans = 0;
        for (int i = 0; i < n; i++) {
            ans += values.get(i);
        }
        
        long x = solve(0, -1, values);
        return ans - x;
    }
}


