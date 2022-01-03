class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer>temp = new ArrayList<>();
        solve(ans,temp,nums,0);
        return ans;
    }
    void solve(List<List<Integer>> ans,List<Integer>temp,int[] nums,int ind){
        if(ind==nums.length){
            ans.add(new ArrayList<>(temp));
            return;
        }
        solve(ans,temp,nums,ind+1);
        temp.add(nums[ind]);
        solve(ans,temp,nums,ind+1);
        temp.remove(temp.size()-1);
    }
}