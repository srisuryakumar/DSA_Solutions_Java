class Solution {
    public String minWindow(String s, String t) {
        if (s.length() == 0 || t.length() == 0 || s.length() < t.length())
            return "";
        Map<Character, Integer> tMap = new HashMap<>();
        for (int i = 0; i < t.length(); i++) {
            tMap.put(t.charAt(i), tMap.getOrDefault(t.charAt(i), 0) + 1);
        }
        int unique = tMap.size();
        int create = 0, l = 0, r = 0;
        int[] ans = { -1, 0, 0 };
        Map<Character, Integer> subStringMap = new HashMap<>();
        while (r < s.length()) {
            char c = s.charAt(r);
            subStringMap.put(c, subStringMap.getOrDefault(c, 0) + 1);
            if (tMap.containsKey(c) && tMap.get(c).intValue() == subStringMap.get(c).intValue())
                create++;
            while (l <= r && unique == create) {
                if (ans[0] == -1 || ans[0] >= r - l + 1) {
                    ans[0] = r - l + 1;
                    ans[1] = l;
                    ans[2] = r;
                }
                c = s.charAt(l);
                subStringMap.put(c, subStringMap.get(c) - 1);
                if (tMap.containsKey(c) && subStringMap.get(c).intValue() < tMap.get(c).intValue())
                    create--;
                l++;
            }
            r++;
        }
        if (ans[0] == -1)
            return "";
        return s.substring(ans[1], ans[2] + 1);
    }
}






# 76. Minimum Window Substring

## 🧩 Pattern
Sliding Window + Hash Map (Variable Size)

## 💡 Key Trick
Find the smallest window in `s` that contains all characters of `t` (including duplicates).

Track character counts using two maps:

- `tMap` → required frequencies
- `windowMap` → current window frequencies

Maintain a counter of how many required characters are fully satisfied.

Shrink the window whenever all requirements are met.

## ⚙️ How It Works
- Expand `r` to include characters
- Update window frequency
- If a character’s required count is satisfied → increment `formed`
- When all required characters are satisfied → try shrinking from `l`
- Update minimum window during shrinking

## ⏱️ Complexity
Time: O(n + m)  
Space: O(charset)

## 🧠 Alternative Approaches
- Brute force: Check all substrings → O(n²)
- Sliding Window with array (faster when charset is small)