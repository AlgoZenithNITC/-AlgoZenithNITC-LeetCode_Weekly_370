import java.util.List;

class Solution {
    public int findChampion(List<List<Integer>> grid) {
        int n = grid.size();
        for (int i = 0; i < n; i++) {
            boolean flag = true;
            for (int j = 0; j < n; j++) {
                if (i != j && grid.get(i).get(j) != 1) {
                    flag = false;
                }
            }
            if (flag) {
                return i;
            }
        }
        return -1;
    }
}

