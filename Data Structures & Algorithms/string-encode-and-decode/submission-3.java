class Solution {

    // check for escape characters
    // static String escape(String s) {
    //     StringBuilder sb = new StringBuilder();
    //     for (int i = 0; i < s.length(); i++) {
    //         char c = s.charAt(i);
    //         switch (c) {
    //             case '\n': sb.append("\\n"); break;
    //             case '\r': sb.append("\\r"); break;
    //             case '\t': sb.append("\\t"); break;
    //             case '\\': sb.append("\\\\"); break;
    //             case '"':  sb.append("\\\""); break;
    //             default:
    //                 if (c < 0x20 || c > 0x7E) {
    //                     sb.append(String.format("\\u%04X", (int) c));
    //                 } else {
    //                     sb.append(c);
    //                 }
    //         }
    //     }
    //     return sb.toString();
    // }

    public String encode(List<String> strs) {
        // StringBuilder output = new StringBuilder();
        
        // debugging to check the escape characters
        // for (int i = 0; i < strs.size(); i++) {
        //     System.out.printf("[%d] %s%n", i, escape(strs.get(i)));
        // }
        
        // System.out.println(strs.size());


        // loop essentially is a manual implementation of join. Except a crucial difference. Join doesn't add a delimiter after the last string in the list. This is usefull because a list with an empty string (i.e. [""] NOT []) will be encoded into an empty string with no delimiter rather than a string with ONLY the delimiter, which when decoding screws up and outputs an empty list [] rather than a list with an empty string [""]
        // for (String str : strs) {
        //     // use ascii unit seperator
        //     // System.out.println("Called");
        //     System.out.println(str);
        //     // System.out.println("Up");
        //     output.append(str).append("\u241F");
        // }
        // System.out.println(output.toString());
        
        // 
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
    

        // the commented out stuff basically do str.split manually

        // char[] buffer = new char[1000];
        // int bufferIndex = 0;
        // System.out.println(str.length());
        // for (int i = 0; i < str.length(); i++) {
        //     if (str.charAt(i) == ' ') {
                
        //         // System.out.println(buffer);

        //         output.add(String.valueOf(buffer, 0, bufferIndex));
        //         bufferIndex = 0;
        //         continue;
        //     }
        //     // System.out.println(str.charAt(i));
        //     buffer[bufferIndex++] = str.charAt(i);            
        // }
        // System.out.println(str.length());
        // output = List.of(str.split("\u241F"));
        // if (output.isEmpty()){
        //     output.add("");
        // }
        // System.out.println(output.size());


        return output;
    }
}
