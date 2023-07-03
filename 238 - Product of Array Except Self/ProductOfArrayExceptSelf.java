

class Solution {
    public int[] productExceptSelf(int[] nums) {
        // array that contains the product of all nums before the current num
        int[] productList = new int[nums.length];
        int lastIndex = nums.length-1;


        // Note that nums.length is always greater than 2
        // Get an array containing the products from after index i to the end
        productList[lastIndex] = nums[lastIndex];
        for (int i = lastIndex-1; i > 0; --i) {
            productList[i] = productList[i+1] * nums[i];
        }
        
        
        int prefix = nums[0];
        int newProduct; // we need a variable to save this value
        productList[0] = productList[1];
        for (int i = 1; i <= lastIndex; ++i) {
            if (i != lastIndex) {
                newProduct = productList[i+1] * prefix;
            } else {
                newProduct = prefix;
            }
            
            prefix *= nums[i];
            productList[i] = newProduct;
        }
        
        return productList; // I guess we can just modify the original to save space
    }
}