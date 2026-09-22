class Solution {

    // public int[] twoSum(int[] nums, int target) {
    //     int left = 0;
    //     int right = nums.length - 1;
    //     int current = 0;
    //     int remainder = 0;

    //     for (; left < nums.length; left++) {
    //         current = nums[left];
    //         remainder = target - current;
            
    //         while (nums[right] > remainder) {
    //             right--;
    //         }
            
    //         if (nums[right] == remainder) {break;}
    //         else {right = nums.length - 1;}
    //     }

    //     int[] output = {left + 1, right + 1};
    //     return output;
        
    // }

    public List<List<Integer>> threeSum(int[] nums) {
        
        Arrays.sort(nums);
        // System.out.println(Arrays.toString(nums));

        List<List<Integer>> output = new ArrayList<>();

        int left = 0;
        int right = nums.length - 1;
        int current = 0;
        int remainder = 0;
        Boolean zero = false;

        int target = 0;

        for (int i = 0; i < nums.length; i++) {
            if (i > 0 && nums[i] == nums[i-1]) { continue; }

            // twoSum
            target = nums[i];

            for (left = i+1; left < nums.length; left++) {
                
                current = nums[left];
                if ((left - 1) > i && current == nums[left - 1]) { continue; }
                remainder = -(target + current);
                // System.out.println("Target: " + target + " Curr: " + current + " Rem: " + remainder);
                while (nums[right] > remainder && right > left) {
                    right--;
                }
                
                if (nums[right] == remainder && right != left && !zero) {
                    // System.out.print("If ");
                    // System.out.print(nums[right]);
                    // System.out.println(" Rem: " + remainder);
                    if (target == remainder && target == 0) { zero = true; }
                    output.add(List.of(target, nums[right], nums[left]));
                    // System.out.println(output);
                }
                else {right = nums.length - 1;}
            }
        }
        return output;
    }
}
