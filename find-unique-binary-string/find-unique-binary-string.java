class Solution {
    public String findDifferentBinaryString(String[] nums) {
        String x="";
        for(int i=0;i<nums.length;i++){
            x+= nums[i].charAt(i)=='1' ? '0' : '1'; 
        }
        return x;
    }
}