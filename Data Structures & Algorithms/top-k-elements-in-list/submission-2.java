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
            Integer freq = entry.getValue();
            Integer num = entry.getKey();
            countsByFreq.computeIfAbsent(freq, f -> new ArrayList<>()).add(num);
        }
    
        List<Integer> output = new ArrayList<>();
        // for (Map.Entry<Integer, List<Integer>> entry : max.entrySet()) {
        //     if (entry.getKey() >= k) {
        //         output.add(entry.getKey());
        //     }
        // }
        int addedElements = 0;
        while (maxFreq > 0 && addedElements < k) {
            if (countsByFreq.containsKey(maxFreq)) {
                output.addAll(countsByFreq.get(maxFreq));
                addedElements += countsByFreq.get(maxFreq).size();
            }
            maxFreq--;
        }

        // convert back into int from Integer
        int[] out = output.stream().mapToInt(Integer::intValue).toArray();
        return out;
    }
}
