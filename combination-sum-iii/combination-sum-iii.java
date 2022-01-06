class Solution {
    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> tmp = new ArrayList<>();
        solve(ans,tmp,k,n,1);
        return ans;
    }
    void solve(List<List<Integer>> ans,List<Integer> tmp,int k, int n,int curr){
        if(k==0&&n==0){
           ans.add(new ArrayList<>(tmp));
           return;
        }
        if(k<0 || n<0 || curr>9)return;
        
        tmp.add(curr);
        solve(ans,tmp,k-1,n-curr,curr+1);
        tmp.remove(tmp.size()-1);
        solve(ans,tmp,k,n,curr+1);
        
    }
}