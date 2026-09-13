class Solution {
    public boolean isPalindrome(String s) {
        s = s.replaceAll("[^a-zA-Z0-9]", "").toUpperCase();

        int left_index = 0;
        int right_index = s.length() -1;

        char left = 0;
        char right = 0;

        for (; right_index >= left_index; left_index++, right_index--) {
            left = s.charAt(left_index);
            right = s.charAt(right_index);

            if (left != right) { return false; }
        }


        return true;
    } 
}
