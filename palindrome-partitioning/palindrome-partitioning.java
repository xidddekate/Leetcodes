class Solution {
    public List<List<String>> partition(String s) {
        List<List<String>> ans = new ArrayList<>();
        List<String> tmp = new ArrayList<>(); 
        solve(ans,s,tmp,0);
        return ans;
    }
    void solve(List<List<String>> ans, String s, List<String> tmp,int start){
        if(start>=s.length()){
            ans.add(new ArrayList<>(tmp));
            return;
        }
        for(int i=start;i<s.length();i++){
            String x = s.substring(start,i+1);
            if(isP(x)){
                tmp.add(x);
                solve(ans,s,tmp,i+1);
                tmp.remove(tmp.size()-1);
            }
        }
    }
    boolean isP(String x){
        int i=0,j=x.length()-1;
        while(i<j && x.charAt(i)==x.charAt(j)){i++;j--;}
        if(i>=j)return true;
        return false;
    }
}