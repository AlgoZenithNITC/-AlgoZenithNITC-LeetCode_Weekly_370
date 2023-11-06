import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class Solution {
    public long get(List<Long> BIT, int ind) {
        ind++;
        long ans = 0;
        while (ind > 0) {
            ans = Math.max(ans, BIT.get(ind));
            ind -= (ind & (-ind));
        }
        return ans;
    }

    public void update(List<Long> BIT, int ind, long val, int n) {
        ind++;
        while (ind < BIT.size()) {
            BIT.set(ind, Math.max(val, BIT.get(ind)));
            ind += (ind & (-ind));
        }
    }

    public long maxBalancedSubsequenceSum(List<Integer> nums) {
        List<List<Long>> v = new ArrayList<>();
        int n = nums.size();
        for (int i = 0; i < n; i++) {
            v.add(new ArrayList<>(List.of((long) (nums.get(i) - i), (long) i)));
        }
        Collections.sort(v, (a, b) -> a.get(0).compareTo(b.get(0)));
        long ans = Long.MIN_VALUE;
        List<Long> BIT = new ArrayList<>(Collections.nCopies(n + 10, 0L));
        for (int i = 0; i < v.size(); i++) {
            int ind = v.get(i).get(1).intValue();
            long sum = nums.get(ind);
            sum += get(BIT, ind);
            update(BIT, ind, sum, n);
            ans = Math.max(ans, sum);
        }
        return ans;
    }
}


