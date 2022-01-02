class CombinationIterator {

    int len;
    List<String>ans;
    Iterator<String>itr;
    public CombinationIterator(String characters, int combinationLength) {
        this.len = combinationLength;
        this.ans = new ArrayList<>();
        
        char[] arr = characters.toCharArray();
        Arrays.sort(arr);
        characters = String.valueOf(arr);
        StringBuilder sb=new StringBuilder(characters);  
        sb.reverse();  
        characters = sb.toString();  
        solve(characters,"");
        
        this.itr = this.ans.listIterator();
        // System.out.println(ans);
    }
    void solve(String characters, String tmp){
        if(characters.length()==0){
            if(tmp.length()==this.len){
                this.ans.add(new String(tmp));
            }
            return;
        }
        String t = characters.substring(0,characters.length()-1);
        tmp = tmp + characters.charAt(characters.length()-1);
        solve(t,tmp);
        tmp = tmp.substring(0,tmp.length()-1);
        solve(t,tmp);
    }
    public String next() {
        if(this.itr.hasNext())
            return this.itr.next();
        else return "";
    }
    
    public boolean hasNext() {
        return this.itr.hasNext();   
    }
}

/**
 * Your CombinationIterator object will be instantiated and called as such:
 * CombinationIterator obj = new CombinationIterator(characters, combinationLength);
 * String param_1 = obj.next();
 * boolean param_2 = obj.hasNext();
 */