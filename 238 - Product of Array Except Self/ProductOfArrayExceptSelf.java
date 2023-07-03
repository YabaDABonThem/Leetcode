

class Solution {
    public int[] productExceptSelf(int[] nums) {
        // array that contains the product of all nums before the current num
        int[] suffixList = new int[nums.length];
        int lastIndex = nums.length-1;


        // Note that nums.length is always greater than 2
        // Get an array containing the products from after index i to the end
        suffixList[lastIndex] = nums[lastIndex];
        for (int i = lastIndex-1; i > 0; --i) {
            suffixList[i] = suffixList[i+1] * nums[i];
        }
        
        
        int prefix = nums[0];
        int newProduct;
        for (int i = 1; i <= lastIndex; ++i) {
            if (i != lastIndex) {
                newProduct = suffixList[i+1] * prefix;
            } else {
                newProduct = prefix;
            }
            
            prefix *= nums[i];
            nums[i] = newProduct;
        }
        nums[0] = suffixList[1];
        
        return nums; // I guess we can just modify the original to save space
    }
}