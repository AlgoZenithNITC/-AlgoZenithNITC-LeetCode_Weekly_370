class Solution:
    def solve(self, node, parent, values):
        if len(self.adj[node]) == 1 and node != 0:
            return values[node]
        sum = 0
        for it in self.adj[node]:
            if it == parent:
                continue
            sum += self.solve(it, node, values)
        return min(sum, 1 * values[node])

    def maximumScoreAfterOperations(self, edges, values):
        n = len(values)
        self.adj = [[] for _ in range(n)]
        for it in edges:
            self.adj[it[0]].append(it[1])
            self.adj[it[1]].append(it[0])
        ans = 0
        for i in range(n):
            ans += values[i]
        x = self.solve(0, -1, values)
        return ans - x

