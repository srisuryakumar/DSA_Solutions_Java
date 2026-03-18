class Solution {
    public int characterReplacement(String s, int k) {
        int l = 0, r = 0, ans = 0, maxOccurance = 0;
        int[] count = new int[26];
        for (int i = r; r < s.length(); r++) {
            maxOccurance = Math.max(maxOccurance, ++count[s.charAt(r) - 'A']);
            if (r - l + 1 - maxOccurance > k) {
                count[s.charAt(l) - 'A']--;
                l++;
            }
            ans = Math.max(ans, r - l + 1);
        }
        return ans;
    }
}




# 424. Longest Repeating Character Replacement

## 🧩 Pattern
Sliding Window + Frequency Count

## 💡 Key Trick
Keep a window `[l, r]` where you can replace at most `k` characters to make all characters the same.

Track the count of the most frequent character (`maxOccurrence`) in the window.

Valid window condition:
window_size - maxOccurrence ≤ k

If invalid → move `l` forward (shrink window).

## ⏱️ Complexity
Time: O(n)  
Space: O(1)

## 🧠 Alternative Approaches
Brute force: Check all substrings → O(n²)
Recompute max frequency every time → O(26·n) ≈ O(n)