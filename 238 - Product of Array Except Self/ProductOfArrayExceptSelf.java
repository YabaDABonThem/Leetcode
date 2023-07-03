

class Solution {
    public int[] productExceptSelf(int[] nums) {
        // array that contains the product of all nums before the current num
        int[] productsExceptSelf = new int[nums.length];
        // int[] afterCurrentNumProducts = new int[nums.length];
        int lastIndex = nums.length-1;


        // Note that nums.length is always greater than 2
        // Get an array containing the products from after index i to the end
        productsExceptSelf[lastIndex] = nums[lastIndex];
        for (int i = lastIndex-1; i > 0; --i) {
            productsExceptSelf[i] = productsExceptSelf[i+1] * nums[i];
        }
        
        
        int beforeProduct = nums[0];
        int newProduct;
        for (int i = 1; i <= lastIndex; ++i) {
            if (i != lastIndex) {
                newProduct = productsExceptSelf[i+1] * beforeProduct;
            } else {
                newProduct = beforeProduct;
            }
            
            beforeProduct *= nums[i];
            nums[i] = newProduct;
        }
        nums[0] = productsExceptSelf[1];
        
        return nums; // I guess we can just modify the original to save space
    }
}