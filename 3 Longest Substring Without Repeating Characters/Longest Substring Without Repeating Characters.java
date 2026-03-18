class Solution {
    public int lengthOfLongestSubstring(String s) {
        Set<Character> set = new HashSet<>();
        int l = 0, r = 0, ans = 0;
        for (int i = r; r < s.length(); r++) {
            while (set.contains(s.charAt(r))) {
                set.remove(s.charAt(l));
                l++;
            }
            set.add(s.charAt(r));
            ans = Math.max(ans, r - l + 1);
        }
        return ans;
    }
}



# 3. Longest Substring Without Repeating Characters

## 🧩 Pattern
Sliding Window + Hash Set

## 💡 Key Trick
Maintain a window `[l, r]` that always contains **unique characters**.

If a duplicate character appears, shrink the window from the left until the duplicate is removed.

## ⚙️ How It Works
- Expand `r` to include new characters
- If `s[r]` already exists in the set → remove characters from left (`l`)  
- Continue until the window has all unique characters
- Track the maximum window length

## ⏱️ Complexity
Time: O(n)  
Space: O(min(n, charset))

## 🧠 Alternative Approaches
- Brute force: Check all substrings → O(n²)
- Sliding Window + Hash Map (store last seen index for faster jumps)