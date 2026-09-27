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
        for (Integer num : hashedNums.keySet()) {
            if (!hashedNums.containsKey(num - 1)) { 
                starts_holder[holder_index] = num;
                holder_index++;
            }
        }

        /* copy the starts to a new array having only starting values to avoid 
        having trailing zeroes that are erroneously counted as starting values
        when they are actually just placeholders cos the array is bigger than needed*/
        int[] starts = new int[holder_index];

        for (int i = 0; i < holder_index; i++) {
            starts[i] = starts_holder[i];
        }

        return starts;
    }

    public int longestConsecutive(int[] nums) {

        Map <Integer, Integer> hashedNums = new HashMap<>();
        buildHashLinkedList(nums, hashedNums);

        /* initialising a holder array for starting values that
        will most likely get shrunk since only worst case would have 
        input with each number as its own subsequence */
        int[] starts_holder = new int[nums.length];
        int[] starts = makeStartList(hashedNums, starts_holder);

        int longest_seq_size = 0;
        int sub_seq_size = 1;
        int next = 0;

        for (int num : starts) {
            next = num + 1;
            // go through the entire subsequence starting from num
            while (hashedNums.containsKey(next)) {
                sub_seq_size++;
                next++;
            }

            longest_seq_size = Math.max(longest_seq_size, sub_seq_size);
            
            // reset subsequence size for next loop iteration
            sub_seq_size = 1;
        }

        return longest_seq_size;

    }
}
