class Solution {
    public int maxIncreaseKeepingSkyline(int[][] grid) {
        int n = grid.length, m = grid[0].length;
        int[] v = new int[n];
        int[] h = new int[m];
        
        for(int i=0;i<n;i++){
            int h_max=0;
            for(int j=0;j<m;j++){
                if(h[j]<grid[i][j])h[j]=grid[i][j];
                h_max = Math.max(h_max,grid[i][j]);
            }
            v[i] = h_max;
        }
        int ans=0;
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                int x = Math.min(h[j],v[i])-grid[i][j];
                if(x>0)ans+=x;
            }
        }
        return ans;
    }
}