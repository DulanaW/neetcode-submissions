class Solution {
    public boolean isValid(String s) {
        Deque<Character> stack = new ArrayDeque<>();

        for (Character c : s.toCharArray()) {
            
            if ((c == '(') || (c == '[') || (c == '{')) {
                stack.push(c);
            } else if (stack.peek() == null) {
                return false;
            }
            else if ((c == ')' && stack.peek() == '(') || (c == ']' && stack.peek() == '[') || (c == '}' && stack.peek() == '{')) {
                stack.pop();
            } else return false;
        }

        if (stack.peek() == null) { return true; }
        else { return false; }
    }
}
