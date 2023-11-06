class Solution:
    def findChampion(self, n, edges):
        adj = [[] for _ in range(n)]
        for i in range(len(edges)):
            adj[edges[i][1]].append(edges[i][0])
        ans = -1
        for i in range(n):
            if len(adj[i]) == 0:
                if ans != -1:
                    return -1
                ans = i
        return ans

