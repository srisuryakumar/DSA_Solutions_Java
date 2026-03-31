class Solution {
    static Map<String, Integer> map = new HashMap<>();
    static {
        map.put("I", 1);
        map.put("V", 5);
        map.put("X", 10);
        map.put("L", 50);
        map.put("C", 100);
        map.put("D", 500);
        map.put("M", 1000);
        map.put("IV", 4);
        map.put("IX", 9);
        map.put("XL", 40);
        map.put("XC", 90);
        map.put("CD", 400);
        map.put("CM", 900);
    }

    public int romanToInt(String s) {
        int sum = 0, i = 0;
        while (i < s.length()) {
            if (i < s.length() - 1) {
                String twoStrings = s.substring(i, i + 2);
                if (map.containsKey(twoStrings)) {
                    sum += map.get(twoStrings);
                    i += 2;
                    continue;
                }
            }
            String oneString = s.substring(i, i + 1);
            if (map.containsKey(oneString)) {
                sum += map.get(oneString);
                i += 1;
            }
        }
        return sum;
    }
}






# 13. Roman To Integer

## 🧩 Pattern
Hash Map + String Traversal

## 💡 Key Trick
Check for two-character combinations first (like "IV", "IX").

If found → add value and move 2 steps
Otherwise → process single character and move 1 step

This handles subtractive cases correctly.

## ⏱️ Complexity
Time: O(n)
Space: O(1)

## 🧠 Alternative Approaches
- Compare current and next character values (no substring needed) → O(n)
- Reverse traversal with previous value tracking → O(n)
- Switch-case based parsing → O(n)