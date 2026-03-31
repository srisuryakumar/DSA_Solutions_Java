class Solution {
    public boolean containsDuplicate(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            if (set.contains(nums[i]))
                return true;
            set.add(nums[i]);
        }
        return false;
    }
}








# 217. Contains Duplicate

## 🧩 Pattern
Hash Set

## 💡 Key Trick
Use a HashSet to track seen elements.
If an element already exists in the set → duplicate found
Otherwise, add it to the set

Early return helps optimize runtime.

## ⏱️ Complexity
Time: O(n)
Space: O(n)

## 🧠 Alternative Approaches
- Sorting + checking adjacent elements → O(n log n)
- Brute force (compare every pair) → O(n²)