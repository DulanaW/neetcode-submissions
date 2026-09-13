class Solution {
    public boolean isPalindrome(String s) {
        s = s.replaceAll("[^a-zA-Z0-9]", "").toUpperCase();
        // System.out.println(s.charAt(s.length() - 1));
        int left_index = 0;
        int right_index = s.length() -1;
        
        // System.out.println(left_index);
        // System.out.println(right_index);

        char left = 0;
        char right = 0;

        for (; right_index >= left_index; left_index++, right_index--) {
            left = s.charAt(left_index);
            right = s.charAt(right_index);
            // System.out.println(left);
            // System.out.println(right);
            if (left != right) { return false; }
        }


        return true;
    } 
}
