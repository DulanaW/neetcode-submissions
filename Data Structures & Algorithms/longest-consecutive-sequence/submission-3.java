class Solution {

    public boolean hasNextNode(int node, Map <Integer, Integer> hashedNums) {
        /*check if nums actually has the number that follows 
        the value node*/
        // done by checking if the hash has populated the bucket for node + 1 value
        return hashedNums.containsKey(node+1);
    }

    public void buildHashLinkedList(int[] nums, Map <Integer, Integer> hashedNums) {       
        /* insert each number in the array as a key followed by number + 1
        regardless of whether its in the array or not */
        for (int num : nums) {
            hashedNums.put(num, num+1);
        }
    }

    public int[] makeStartList(Map <Integer, Integer> hashedNums, int[] starts_holder) {
        /*go through each key in the hashmap and make an array with all the starting ints*/
        int holder_index = 0;
        // //System.out.println(hashedNums.keySet());
        for (Integer num : hashedNums.keySet()) {
            //System.out.println("Holder num: " + num);
            if (!hashedNums.containsKey(num - 1)) { 
                //System.out.println("if");
                starts_holder[holder_index] = num;
                holder_index++;
                //System.out.println(Arrays.toString(starts_holder));
            }
            //System.out.println("Holder index: " + holder_index);
            // break;
        }

        int[] starts = new int[holder_index];

        for (int i = 0; i < holder_index; i++) {
            starts[i] = starts_holder[i];
        }

        return starts;
    }

    public int longestConsecutive(int[] nums) {

        Map <Integer, Integer> hashedNums = new HashMap<>();
        int[] starts_holder = new int[nums.length];

        buildHashLinkedList(nums, hashedNums);
        int[] starts = makeStartList(hashedNums, starts_holder);

        int longest_seq_size = 0;
        int sub_seq_size = 1;
        int next = 0;

        //System.out.println(Arrays.toString(starts));

        for (int num : starts) {
            next = num+1;
            //System.out.println("for: " + num);
            while (hashedNums.containsKey(next)) {
                //System.out.print("next: " + next);
                sub_seq_size++;
                //System.out.println(" size: " + sub_seq_size);
                next++;
            }
            if (sub_seq_size > longest_seq_size) {
                longest_seq_size = sub_seq_size;
            }
            sub_seq_size = 1;
        }

        return longest_seq_size;

    }
}
