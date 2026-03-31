class Solution {
    public int longestConsecutive(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            set.add(nums[i]);
        }
        int lcs = 0;
        for (int num : set) {
            if (set.contains(num - 1)) {
                continue;
            } else {
                int currentNum = num + 1;
                int count = 1;
                while (set.contains(currentNum)) {
                    currentNum++;
                    count++;
                }
                lcs = Math.max(lcs, count);
            }
        }
        return lcs;
    }
}






# 128. Longest Consecutive Sequence

## 🧩 Pattern
Hash Set

## 💡 Key Trick
Only start counting when the number is the start of a sequence.
- Check if num - 1 is NOT in the set → start new sequence
- Expand forward (num + 1, num + 2...) to count length
- Track maximum length

This avoids redundant work.

## ⏱️ Complexity
Time: O(n)
Space: O(n)

## 🧠 Alternative Approaches
- Sorting + linear scan → O(n log n)
- Union-Find (overkill) → O(n) but complex implementation