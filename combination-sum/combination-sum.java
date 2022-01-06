class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> tmp = new ArrayList<>();
        Set<List<Integer>> s = new HashSet<>();
        solve(ans,0,0,target,candidates,tmp,s);
        return ans;
    }
    void solve(List<List<Integer>> ans, int currInd, int currSum, int n, int[] arr, List<Integer> tmp,Set<List<Integer>> s){
        if(currSum==n && !s.contains(new ArrayList<>(tmp))){
            ans.add(new ArrayList<>(tmp));
            // System.out.println(tmp);
            s.add(tmp);
            return;
        }
        if(currInd>=arr.length){
            return;
        }
        
        if(currSum + arr[currInd] <= n){
            tmp.add(arr[currInd]);
            // System.out.println("Forst "+currSum+arr[currInd]);
            solve(ans,currInd,currSum+arr[currInd],n,arr,tmp,s);
            tmp.remove(tmp.size()-1);
        }
        if(currInd+1 < arr.length && currSum+arr[currInd+1]<=n){
            tmp.add(arr[currInd+1]);
            // System.out.println("Second "+currSum+arr[currInd+1]);
            solve(ans,currInd+1,currSum+arr[currInd+1],n,arr,tmp,s);
            tmp.remove(tmp.size()-1);
        }
        solve(ans,currInd+1,currSum,n,arr,tmp,s);
    }
}