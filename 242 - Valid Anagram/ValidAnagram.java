class Solution {
    public boolean isAnagram(String s, String t) {
        //s = s.replaceAll("\\s", "");
        //t = t.replaceAll("\\s", "");
        
        if (s.length() != t.length()) return false;
        
        int[] charCount = new int[26];
        
        for (int i = 0; i < s.length(); ++i) {
            ++charCount[s.charAt(i)-'a'];
            --charCount[t.charAt(i)-'a'];
        }
        
        // check if it's all 0
        
        for (int num : charCount) {
            if (num != 0) return false;
        }
        
        return true;
    }
}