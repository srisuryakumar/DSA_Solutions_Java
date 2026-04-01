class Solution {
    public String longestCommonPrefix(String[] strs) {
        for (int i = 0; i < strs[0].length(); i++) {
            char c = strs[0].charAt(i);
            for (int j = 1; j < strs.length; j++) {
                if (i == strs[j].length() || strs[j].charAt(i) != c)
                    return strs[j].substring(0, i);
            }
        }
        return strs[0];
    }
}






# 14. Longest Common Prefix

## 🧩 Pattern
Vertical Scanning

## 💡 Key Trick
Compare characters column-wise across all strings.

Fix index i and take character from first string
Compare with same index in all other strings
If mismatch or end of any string → return prefix till i

## ⏱️ Complexity
Time: O(n * m)
Space: O(1)

## 🧠 Alternative Approaches
- Horizontal scanning → compare prefix with each string
- Sorting + compare first and last strings → O(n log n)
- Trie-based approach → O(n * m) but more complex