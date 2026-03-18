class Solution {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int sum = target - nums[i];
            if (map.containsKey(sum)) {
                return new int[] { i, map.get(sum) };
            }
            map.put(nums[i], i);
        }
        return new int[] { -1, -1 };
    }
}



# 1. Two Sum

## 🧩 Pattern
Hash Map

## 💡 Key Trick
For each number, check if the complement (target - num) already exists.

## ⏱️ Complexity
Time: O(n)
Space: O(n)

## 🧠 Alternative Approaches
- Brute force: O(n²)
- Sorting + Two pointers (not valid for original indices)