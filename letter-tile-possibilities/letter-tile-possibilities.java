class Solution {
    Set<String> s = new HashSet<>();
    public int numTilePossibilities(String tiles) {
        solve("",tiles);
        return s.size();
    }
    void solve(String tiles, String tilesLeft){
        if(tilesLeft.length()==0){
            return;
        }
        for(int i=0;i<tilesLeft.length();i++){
            tiles+=tilesLeft.charAt(i);
            String t = tilesLeft.substring(0,i) + tilesLeft.substring(i+1,tilesLeft.length());
            // System.out.println(tiles + " " + t);
            s.add(tiles);
            solve(tiles,t);
            tiles = tiles.substring(0, tiles.length()-1);
        }
    }
}