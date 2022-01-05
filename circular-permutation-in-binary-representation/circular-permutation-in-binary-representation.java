class Solution {
    public List<Integer> circularPermutation(int n, int start) {
        List<Integer> ans = new ArrayList<>();
        Set<Integer>s = new HashSet<>();
        ans.add(start);        
        s.add(start);        
        solve(ans,n,s,start);
        return ans;
    }
    void solve(List<Integer> ans, int n, Set<Integer>s, int start){
       for(int i=0;i<n;i++){
           int x = start ^ (1<<i);
           if(!s.contains(x)){
               ans.add(x);
               s.add(x);
               solve(ans,n,s,x);
           }
       }
    }
}