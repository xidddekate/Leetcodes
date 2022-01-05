class Solution {
    int ans = 0;
    public int getMaximumGold(int[][] grid) {
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[i].length;j++){
                if(grid[i][j]!=0){
                    solve(grid,i,j,-1,-1,grid.length,grid[i].length,0);
                }
            }
        }
        return ans;
    }
    boolean check(int r,int c,int n, int m){
        if(r>=n || r<0 || c>=m || c<0)return false;
        return true;
    }
    void solve(int[][] grid, int r, int c, int prevR, int prevC, int n, int m, int gold){
        int x = grid[r][c];
        if(check(r,c+1,n,m) && grid[r][c+1]!=0 && c+1!=prevC){
            gold += x;
            grid[r][c] = 0;
            solve(grid,r,c+1,r,c,n,m,gold);
            gold -= x;
            grid[r][c] = x;
        }
        if(check(r,c-1,n,m) && grid[r][c-1]!=0 && c-1!=prevC){
            gold += x;
            grid[r][c] = 0;
            solve(grid,r,c-1,r,c,n,m,gold);
            grid[r][c] = x;
            gold -= x;
        }
        if(check(r+1,c,n,m) && grid[r+1][c]!=0 && r+1!=prevR){
            gold += x;
            grid[r][c] = 0;
            solve(grid,r+1,c,r,c,n,m,gold);
            grid[r][c] = x;
            gold -= x;
        }
        if(check(r-1,c,n,m) && grid[r-1][c]!=0 && r-1!=prevR){
            gold += x;
            grid[r][c] = 0;
            solve(grid,r-1,c,r,c,n,m,gold);
            grid[r][c] = x;
            gold -= x;
        }
        ans = Math.max(ans,gold+x);
    }
}