class Solution:
    def findChampion(self, grid):
        n = len(grid)
        for i in range(n):
            flag = True
            for j in range(n):
                if i != j and grid[i][j] != 1:
                    flag = False
            if flag:
                return i
        return -1

