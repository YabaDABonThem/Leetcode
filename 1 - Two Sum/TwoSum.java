class Solution {
    public int[] twoSum(int[] nums, int target) {
        // Young method
        HashMap<Integer, Integer> numList = new HashMap<>();
        
        for (int i = 0; i < nums.length; ++i) {
            // now that you've placed it into the HashMap, 
            // look thru the previous to see if the target you want is in the HashMap
            if (numList.containsKey(target - nums[i])) {
                return new int[] {i, numList.get(target - nums[i])};
            }
            numList.put(nums[i], i);
        }         
        return new int[] {};
    }

}