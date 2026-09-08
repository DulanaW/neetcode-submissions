class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        
        Map<Integer, Integer> counts = new HashMap<>();
        
        // count occurences and track max freq
        int maxFreq = 0;
        
        for (int num : nums) {
            counts.merge(num, 1, Integer::sum);

            if (counts.get(num) > maxFreq) {
                maxFreq = counts.get(num);
            }
        }
        
        // store indexes of all nums keyed by their frequency (essentially reverse swap the key value pairing of the previous loop
        Map<Integer, List<Integer>> countsByFreq = new HashMap<>();
        
        for (Map.Entry<Integer, Integer> entry : counts.entrySet()) {
            // Integer freq = entry.getValue();
            // Integer num = entry.getKey();
            countsByFreq.computeIfAbsent(entry.getValue(), f -> new ArrayList<>()).add(entry.getKey());
        }
    
        List<Integer> output = new ArrayList<>();
        int addedElements = 0;
        List<Integer> loopHolder = new ArrayList<>();
        while (maxFreq > 0 && addedElements < k) {
            
            if (countsByFreq.containsKey(maxFreq)) {
                loopHolder = countsByFreq.get(maxFreq);
                output.addAll(loopHolder);
                addedElements += loopHolder.size();
            }
            maxFreq--;
        }

        // convert back into int from Integer
        // int[] out = new int[k];
        // for (int i = 0; i < k; i++) {
        //     out[i] = output.get(i);
        // }
        int[] out = output.stream().mapToInt(Integer::intValue).toArray(); 
        return out;
    }
}
