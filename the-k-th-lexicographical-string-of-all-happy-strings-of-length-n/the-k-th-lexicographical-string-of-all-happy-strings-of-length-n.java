class Solution {
    String ans;int c=0;
    
    public String getHappyString(int n, int k) {
        solve(n,k,0,"");
        if(c>=k)
            return ans;
        else return "";
    }
    boolean solve(int n,int k,int currLen,String currString){
        if(currLen == n){
            c++;
            if(c==k){
                ans = new String(currString);
                return true;
            }
            return false;
        }
        if((currString.length()==0 || currString.charAt(currString.length()-1)!='a') && solve(n,k,currLen+1,currString+"a"))return true;
        else if((currString.length()==0 || currString.charAt(currString.length()-1)!='b') && solve(n,k,currLen+1,currString+"b"))return true;
        else if((currString.length()==0 || currString.charAt(currString.length()-1)!='c') && solve(n,k,currLen+1,currString+"c"))return true;
        else return false;
    }
}