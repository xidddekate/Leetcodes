class Solution {
    int ans = 0;
    public int maxCompatibilitySum(int[][] students, int[][] mentors) {
        boolean[] v = new boolean[students.length];
        solve(students,mentors,v,0,0);
        return ans;
    }
    void solve(int[][] students, int[][] mentors,boolean[] v, int psf, int css){
        if(psf>=students.length){
            ans = Math.max(ans,css);
            return;
        }
        for(int i=0;i<mentors.length;i++){
            if(!v[i]){
                v[i]=true;
                int x=0;
                for(int j=0;j<students[i].length;j++){
                    if(students[psf][j]==mentors[i][j])x++;
                }
                solve(students,mentors,v,psf+1,css+x);
                v[i]=false;
            }
        }
    }
}