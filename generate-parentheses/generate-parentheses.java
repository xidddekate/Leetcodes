class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> ans = new ArrayList<>();
        Set<String>s = new HashSet<>();
        solve(s,"()",1,n);
        for(String x : s){
            ans.add(x);
        }
        return ans;
    }
    void solve(Set<String>s,String tmp,int curr,int n){
        if(curr==n){
            // System.out.println(tmp);
            s.add(new String(tmp));
            return;
        }
        for(int i=0;i<tmp.length();i++){
            if(tmp.charAt(i)==')'){
                String x = tmp.substring(0,i) + "(" + tmp.substring(i,tmp.length()) + ")";
                solve(s,x,curr+1,n);
            }
        }
        String x = tmp + "()";
        solve(s,x,curr+1,n);
        
    }
}