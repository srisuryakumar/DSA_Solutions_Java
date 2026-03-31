class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List> map = new HashMap<>();
        int[] count = new int[26];
        for (String s : strs) {
            Arrays.fill(count, 0);
            for (int i = 0; i < s.length(); i++) {
                count[s.charAt(i) - 'a']++;
            }
            StringBuilder sb = new StringBuilder();
            for (int c : count) {
                sb.append(c);
                sb.append("#");
            }
            String key = sb.toString();
            if (!map.containsKey(key)) {
                map.put(key, new ArrayList());
            }
            map.get(key).add(s);
        }
        return new ArrayList(map.values());
    }
}




# 49. Group Anagrams

## 🧩 Pattern
Hash Map + String Encoding (Character Frequency)

## 💡 Key Trick
Convert each string into a canonical form that uniquely represents its character composition, then use it as a hash key.

## ⏱️ Complexity
n = number of strings
k = maximum string length

Time: O(n * k)
Space: O(n * k)

## 🧠 Alternative Approaches
Compare each string with every other string and group them if they are anagrams (by checking character counts or sorted forms).

Steps:

1. Pick a string
2. Compare it with all remaining strings
3. If two strings are anagrams, put them in the same group
4. Mark grouped strings as visited
5. Repeat for unvisited strings

Time: O(n² · k)
Space: O(n · k)