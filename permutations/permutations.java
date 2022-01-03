class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> temp = new ArrayList<>();
        solve(nums,ans,temp);
        return ans;
    }
    void solve(int[] nums,List<List<Integer>> ans,List<Integer> temp){
        if(temp.size() == nums.length){            
            ans.add(new ArrayList<>(temp));
            return;
        }
        for(int i=0;i<nums.length;i++){
            if(nums[i]!=-11){
                temp.add(nums[i]);
                int x=nums[i];
                nums[i]=-11;
                solve(nums,ans,temp);
                nums[i]=x;
                temp.remove(temp.size()-1);
                
            }
        }
    }
}