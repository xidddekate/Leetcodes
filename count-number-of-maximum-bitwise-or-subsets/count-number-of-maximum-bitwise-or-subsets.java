class Solution {
    Map<Integer,Integer>m=new HashMap<>();
    int max=-1;
    public int countMaxOrSubsets(int[] nums) {
        func(nums,0,0);
        return max;
        // return m.get(max);
    }
    
    public void func(int[] nums,int i,int or) {
        if(i==nums.length){
            if(m.containsKey(or)){
                max = Math.max(max,m.get(or)+1);
                m.put(or,m.get(or)+1);
            }
            else{
                m.put(or,1);
                max = Math.max(max,1);
            }
            return;
        }
        int orred = or | nums[i];
        func(nums,i+1,orred);
        func(nums,i+1,or);
    }
    
}