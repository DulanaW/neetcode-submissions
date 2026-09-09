class Solution {

    public String encode(List<String> strs) {
 
        String output = null;

        if (strs.isEmpty()) {
            output = "\u241E";
        } else {
            output = String.join("\u241F", strs);    
        }    
        
        return output;
    }

    public List<String> decode(String str) {

        if (str.equals("\u241E")) {
            return new ArrayList<>();
        }
        
        List<String> output = new ArrayList<>(Arrays.asList(str.split("\u241F", -1)));
        return output;
    }
}
