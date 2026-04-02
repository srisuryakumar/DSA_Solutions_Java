class Solution {
    public boolean checkInclusion(String s1, String s2) {
        if (s2.length() < s1.length())
            return false;
        int[] count1 = new int[26];
        int[] count2 = new int[26];
        for (int i = 0; i < s1.length(); i++) {
            count1[s1.charAt(i) - 'a']++;
            count2[s2.charAt(i) - 'a']++;
        }

        for (int i = 0; i < s2.length() - s1.length(); i++) {
            if (matches(count1, count2))
                return true;
            count2[s2.charAt(i + s1.length()) - 'a']++;
            count2[s2.charAt(i) - 'a']--;
        }
        return matches(count1, count2);
    }

    private boolean matches(int[] count1, int[] count2) {
        for (int i = 0; i < 26; i++) {
            if (count1[i] != count2[i])
                return false;
        }
        return true;
    }
}






# 567. Permutation in String

## 🧩 Pattern
Sliding Window + Frequency Count

## 💡 Key Trick
Use a fixed-size sliding window of length s1.length().

Maintain frequency arrays for s1 and current window in s2
Slide the window by adding next character and removing previous
Compare both frequency arrays to check for permutation

## ⏱️ Complexity
Time: O(n)
Space: O(1)

## 🧠 Alternative Approaches
- Sorting each window → O(n * m log m)
- HashMap frequency tracking → O(n) time, O(1) space (since charset is fixed)