class Solution {


    public List<List<Integer>> threeSum(int[] nums) {
        
        Arrays.sort(nums);

        List<List<Integer>> output = new ArrayList<>();

        int left = 0;
        int right = nums.length - 1;
        int current = 0;
        int remainder = 0;

        int target = 0;

        for (int i = 0; i < nums.length; i++) {
            if (i > 0 && nums[i] == nums[i-1]) { continue; }

            // twoSum
            target = nums[i];

            for (left = i+1; left < right; left++) {
                
                current = nums[left];
                
                if ((left - 1) > i && current == nums[left - 1]) { continue; }
                
                remainder = -(target + current);
                
                while (nums[right] > remainder && right > left) {
                    right--;
                }
                
                if (nums[right] == remainder && right != left) {
                    
                    output.add(List.of(target, nums[right], nums[left]));
                }
            }
            right = nums.length - 1;
        }
        return output;
    }
}
