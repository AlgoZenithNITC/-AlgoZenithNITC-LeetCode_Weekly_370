class Solution {
public:
    int findChampion(vector<vector<int>>& grid) { 
        int n=grid.size(); 
        
        for(int i=0;i<n;i++)
        { 
            bool flag=true;
            for(int j=0;j<n;j++)
            {
                if(i!=j && grid[i][j]!=1)
                {
                    flag=false;
                }
            } 
            if(flag)
               return  i;
        }  

        return -1;
        
    }
};
