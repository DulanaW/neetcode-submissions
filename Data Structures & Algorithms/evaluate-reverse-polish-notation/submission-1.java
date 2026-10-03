class Solution {
    public int evalRPN(String[] tokens) {
        Deque<String> stack = new ArrayDeque<>();

        int first_operand = 0;
        int second_operand = 0;
        int result = 0;

        for(int i = 0; i < tokens.length; i++) {
            switch (tokens[i]) {
                case "+" -> {
                    second_operand = Integer.parseInt(stack.pop());
                    first_operand = Integer.parseInt(stack.pop());
                    result = first_operand + second_operand;
                    stack.push(Integer.toString(result));
                }

                case "-" -> {
                    second_operand = Integer.parseInt(stack.pop());
                    first_operand = Integer.parseInt(stack.pop());
                    result = first_operand - second_operand;
                    stack.push(Integer.toString(result));
                }

                case "*" -> {
                    second_operand = Integer.parseInt(stack.pop());
                    first_operand = Integer.parseInt(stack.pop());
                    result = first_operand * second_operand;
                    stack.push(Integer.toString(result));
                }

                case "/" -> {
                    second_operand = Integer.parseInt(stack.pop());
                    first_operand = Integer.parseInt(stack.pop());
                    result = first_operand / second_operand;
                    stack.push(Integer.toString(result));
                }

                default -> {
                    stack.push(tokens[i]);
                }
            }
        }
        // System.out.println(stack.peek());
        return Integer.parseInt(stack.pop());
    }
}
