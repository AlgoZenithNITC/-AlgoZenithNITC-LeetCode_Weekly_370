class Solution:
    def get(self, BIT, ind):
        ind += 1
        ans = 0
        while ind > 0:
            ans = max(ans, BIT[ind])
            ind -= (ind & (-ind))
        return ans
    
    def update(self, BIT, ind, val, n):
        ind += 1
        while ind < len(BIT):
            BIT[ind] = max(val, BIT[ind])
            ind += (ind & (-ind))
    
    def maxBalancedSubsequenceSum(self, nums):
        v = []
        n = len(nums)
        for i in range(n):
            v.append([nums[i] - i, i])
        v.sort()
        ans = float('-inf')
        BIT = [0] * (n + 10)
        for i in range(len(v)):
            ind = v[i][1]
            sum = nums[ind]
            sum += self.get(BIT, ind)
            self.update(BIT, ind, sum, n)
            ans = max(ans, sum)
        return ans


