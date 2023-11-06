import java.util.ArrayList;
import java.util.List;

class Solution {
    public int findChampion(int n, List<List<Integer>> edges) {
        List<List<Integer>> adj = new ArrayList<>();
        for(int i=0; i<n; i++){
            adj.add(new ArrayList<>());
        }
        for(int i=0; i<edges.size(); i++){
            adj.get(edges.get(i).get(1)).add(edges.get(i).get(0));
        }
        int ans=-1;
        for(int i=0; i<n; i++){
            if(adj.get(i).size()==0){
                if(ans!=-1) return -1;
                ans = i;
            }
        }
        return ans;
    }
}

