class Solution {
    public boolean containsDuplicate(int[] nums) {
        HashSet<Integer> bruh = new HashSet<>();
        for (int num : nums) {
            if (bruh.contains(num)) {
                return true;
            }
            bruh.add(num);
        }
        return false;
    }
}