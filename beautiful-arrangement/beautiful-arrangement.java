class Solution {
    int ans = 0;
    public int countArrangement(int n) {
        boolean[] v = new boolean[n+1];
        solve(n,v,1);
        return ans;
    }
    void solve(int n, boolean[] vis, int currLen){
        if(currLen == n+1){
            ans++;
            return;
        }
        for(int i=1;i<=n;i++){
            if(!vis[i]){
                vis[i] = true;
                if(currLen%i==0 || i%currLen==0){
                    solve(n,vis,currLen+1);                    
                }
                vis[i] = false;
            }
        }
    }
}