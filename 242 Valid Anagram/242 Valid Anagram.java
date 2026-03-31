class Solution {
    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length())
            return false;

        int[] count = new int[26];

        Arrays.fill(count, 0);

        for (int i = 0; i < s.length(); i++) {
            count[s.charAt(i) - 'a']++;
            count[t.charAt(i) - 'a']--;
        }

        for (int c : count) {
            if (c != 0)
                return false;
        }

        return true;
    }
}







# 242. Valid Anagram

## 🧩 Pattern
Frequency Count (Array / Hashing)

## 💡 Key Trick
Use a fixed-size array to count characters.
Increment for s, decrement for t.
If all values are zero, the strings are anagrams.

## ⏱️ Complexity
Time: O(n)
Space: O(1)

## 🧠 Alternative Approaches
- Sorting both strings and comparing → O(n log n)
- HashMap frequency count → O(n) time, O(n) space