class Solution {
    public int[] twoSum(int[] numbers, int target) {
        int left = 0;
        int right = numbers.length - 1;
        int current = 0;
        int remainder = 0;

        for (; left < numbers.length; left++) {
            current = numbers[left];
            remainder = target - current;
            
            while (numbers[right] > remainder) {
                right--;
            }
            
            if (numbers[right] == remainder) {break;}
            else {right = numbers.length - 1;}
        }

        int[] output = {left + 1, right + 1};
        return output;
        
    }
}
