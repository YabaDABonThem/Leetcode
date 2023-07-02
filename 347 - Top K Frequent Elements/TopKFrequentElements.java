class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        // sort the array first
        Arrays.sort(nums);

        PriorityQueue<Pair<Integer, Integer>> kMostFrequent = new PriorityQueue<>(k, new FrequencyComparator());

        // Loop through nums and count the number of unique ones
        int count = 0;

        // i starts from the first, to pointing to the last in the section
        for(int i = 0; i < nums.length; ++i) {
            ++count;
            
            if (i == nums.length - 1 || nums[i] != nums[i+1]) {
                if (kMostFrequent.size() < k) {
                    kMostFrequent.add(new Pair<Integer, Integer>(nums[i], count));
                } else if (count > kMostFrequent.peek().getValue()) { // pq is full
                    // kMostFrequent.poll();
                    kMostFrequent.add(new Pair<Integer, Integer>(nums[i], count));
                } else {
                    // count is less than the smallest in pq then don't add
                }
                count = 0;
            }
        }

        // Now just need an int of the queue but reversed
        int[] mostFrequent = new int[k];
        System.out.println(kMostFrequent);
        for (int i = 0; i < k; ++i) {
            mostFrequent[i] = kMostFrequent.poll().getKey(); // We only need the keys
        }
        return mostFrequent; // Note that the order doesn't matter'
    }
}

class FrequencyComparator implements Comparator<Pair<Integer, Integer>> {
    public int compare(Pair<Integer, Integer> a, Pair<Integer, Integer> b) { 
        // we keep this in ascending order so we only need to compare with the first item
        if (a.getValue() > b.getValue()) {
            return 1;
        } else if (a.getValue() < b.getValue()) {
            return -1;
        }
        return 0; // don't worry about ties bc the answer is unique

    }
}