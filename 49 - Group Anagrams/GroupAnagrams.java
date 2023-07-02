class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        
        HashMap<String, List<String>> hm = new HashMap<>();

        for (int i = 0; i < strs.length; ++i) {
            // add the words to the hashmap by sorting them by value
            String str = strs[i]; // technically don't need this variable
            char charArray[] = str.toCharArray();
            Arrays.sort(charArray);
            String key = new String(charArray);
            // create new bucket if we currently don't have it
            if (!hm.containsKey(key)) {
                ArrayList bucket = new ArrayList<String>();
                hm.put(key, bucket);
            }
            // add our word to the right bucket
            hm.get(key).add(str);
        }
        
        // all items have now been added to the hashmap, now iterate through it
        // and puch each of the "value" arrays into a new array.
        Iterator hmIterator = hm.entrySet().iterator();
        List<List<String>> anagramList = new ArrayList<>();

        while (hmIterator.hasNext()) {
 
            Map.Entry mapElement = (Map.Entry)hmIterator.next();
            
            anagramList.add((List<String>)mapElement.getValue());
            
        }

        return anagramList;
    }
}