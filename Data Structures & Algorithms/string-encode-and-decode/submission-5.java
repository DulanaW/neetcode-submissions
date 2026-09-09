class Solution {

    public String encode(List<String> strs) {
 
        String output = null;

        if (strs.isEmpty()) {
            output = "\u001E";
        } else {
            output = String.join("\u001F", strs);    
        }    
        
        return output;
    }

    public List<String> decode(String str) {

        if (str.equals("\u001E")) {
            return new ArrayList<>();
        }
        
        List<String> output = new ArrayList<>(Arrays.asList(str.split("\u001F", -1)));
        return output;
    }
}
