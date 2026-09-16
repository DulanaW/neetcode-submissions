class Solution {

    public void twoSum(int[] numbers, int anchor_index, List<List<Integer>> output) {
        int left = anchor_index + 1;
        int right = numbers.length - 1;
        int current = 0;
        int start = numbers[anchor_index];

        List<Integer> triplet = new ArrayList<>(3);

        for (; left < numbers.length && left < right; left++) {
            //System.out.println("Inner");
            current = numbers[left];
            

            while (numbers[right] + current + start != 0) {
                //System.out.println("while");
                //System.out.println("a:" + numbers[anchor_index] + " c:" + current + " r:" + numbers[right]);

                right--;
                if (right <= left) {
                    right++;
                    break;
                }
            }

            //System.out.print("Out");
            //System.out.println("a:" + numbers[anchor_index] + " c:" + current + " r:" + numbers[right]);

            if (numbers[right] + current + start == 0) {
                //System.out.println("Added");
                triplet = List.of(numbers[anchor_index], current, numbers[right]);
                if (!output.contains(triplet)) {
                    output.add(triplet);
                }
                // return output;
            }
            else {right = numbers.length - 1;}
        }
        
        //System.out.println(output);

        // return output;

    }
    
    public List<List<Integer>> threeSum(int[] nums) {

        Arrays.sort(nums);

        //System.out.print("Sorted: ");
        //System.out.println(Arrays.toString(nums));;

        List<Integer> triplet = new ArrayList<>(3);
        List<List<Integer>> output = new ArrayList<>(nums.length/3);
        List<List<Integer>> temp = new ArrayList<>(1);

        int current = 0;

        for (int i = 0; i < nums.length; i++) {
            // ////System.out
            //System.out.println("\n" + "Main:" + nums[i]);
            // if (i != 0 && nums[i] == current) {
            //     ////System.out.println("Skipped");
            //     continue;
            // }

            twoSum(nums, i, output);
            // //System.out.println("\nTemp: " + temp);
            // if (temp.isEmpty() || output.contains(temp)) {
            //     //System.out.println("TT");
            //     continue;
            // }
            // output.addAll(temp);
            current = nums[i];
        }

        return output;
    }
}
