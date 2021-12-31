class Solution {
    
    public void dfs(int[][] graph,int src,int t,boolean[] v,ArrayList<Integer>tmp, List<List<Integer>>ans){
        if(src==t){
            // System.out.println(tmp);
            ans.add(new ArrayList<>(tmp));
            // System.out.println(ans);
            return;
        }
      
        for(int i=0;i<graph[src].length;i++){
            if(!v[graph[src][i]]){
                tmp.add(graph[src][i]);
                v[graph[src][i]] = true;
                dfs(graph,graph[src][i],t,v,tmp,ans);
                tmp.remove(tmp.size()-1);
                v[graph[src][i]] = false;
            }
        }
        return;
    }
    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        boolean[] v = new boolean[graph.length];
        ArrayList<Integer>tmp = new ArrayList<>();
        List<List<Integer>>ans = new ArrayList<List<Integer>>();
        v[0] = true;
        tmp.add(0);
        dfs(graph,0,graph.length-1,v,tmp,ans);       
        return ans;
    }
}