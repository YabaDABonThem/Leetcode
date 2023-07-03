

class Solution {
    public int[] productExceptSelf(int[] nums) {
        // array that contains the product of all nums before the current num
        int[] beforeCurrentNumProducts = new int[nums.length];
        // array that contains the product of all nums after the current num
        int[] afterCurrentNumProducts = new int[nums.length];

        // Note that nums.length is always greater than 2
        beforeCurrentNumProducts[0] = nums[0];
        for (int i = 1; i < nums.length; ++i) {
            beforeCurrentNumProducts[i] = beforeCurrentNumProducts[i-1] * nums[i];
        }

        int lastIndex = nums.length-1;
        afterCurrentNumProducts[lastIndex] = nums[lastIndex];
        for (int i = lastIndex-1; i > 0; --i) {
            afterCurrentNumProducts[i] = afterCurrentNumProducts[i+1] * nums[i];
        }
        

        nums[0] = afterCurrentNumProducts[1];
        for (int i = 1; i < nums.length-1; ++i) {
            nums[i] = beforeCurrentNumProducts[i-1] * afterCurrentNumProducts[i+1];
        }
        nums[lastIndex] = beforeCurrentNumProducts[lastIndex-1];
        
        
        return nums; // I guess we can just modify the original to save space
    }
}