class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> tmp = new ArrayList<>();
        solve(ans,tmp,candidates,target,0);
        return ans;
    }
    void solve(List<List<Integer>> ans, List<Integer> tmp, int[] arr, int n, int start){
        if(n<0)return;
        if(n==0){
            ans.add(new ArrayList<>(tmp));
            return;
        }
        for(int i=start;i<arr.length;i++){
            tmp.add(arr[i]);
            solve(ans,tmp,arr,n-arr[i],i);
            tmp.remove(tmp.size()-1);
        }
    }
}