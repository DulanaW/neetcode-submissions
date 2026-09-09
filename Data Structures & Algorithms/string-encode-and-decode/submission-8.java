class Solution {

    public String encode(List<String> strs) {
        StringBuilder output = new StringBuilder();
        for (String str : strs) {
            // use ascii unit seperator
            // System.out.println("Called");
            // System.out.println(str);
            // System.out.println("Up");
            output.append(str.length() + "/").append(str);
        }
        // System.out.println("encoded:" + output.toString());

        return output.toString();
    }

    public List<String> decode(String str) {
        
        List<String> output = new ArrayList<>();
    

        // the commented out stuff basically do str.split manually

        char[] buffer = new char[201];
        String stringSize = "";
        int substringLen = 0;

        for (int i = 0; i < str.length(); i++) {
            stringSize = "" + str.charAt(i);
            // System.out.println("substringLength:" + substringLen + " LoopIndex:" + i);
            // System.out.println("string:" + str.charAt(i));
            i++;
            // System.out.println("Incremented string:" + str.charAt(i));
            // if theres some characters between 
            while (str.charAt(i) != '/') {
                stringSize += str.charAt(i);
                // System.out.println("While:" + str.charAt(i));
                i++;
            }
            substringLen = Integer.parseInt(stringSize);
            // System.out.println("substringLength:" + substringLen + " LoopIndex:" + i);
            // skip the delimiter
            for (int j = 0; j < substringLen && i < str.length(); j++) {
                // System.out.print("Pre" + j + ":");
                // System.out.println(buffer);
                buffer[j] = str.charAt(++i);
                // System.out.print("Post" + j + ":");
                // System.out.println(buffer);
            }
            // System.out.print("BufferLoop:");
            // System.out.println(buffer);
            output.add(String.valueOf(buffer, 0, substringLen));

            // System.out.println(output);
        }

        // System.out.println(output.size());


        return output;
    }
}
