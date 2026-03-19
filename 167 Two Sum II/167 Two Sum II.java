class Solution {
    public int[] twoSum(int[] numbers, int target) {
        int l = 0, r = numbers.length - 1;
        while (l < r) {
            int sum = numbers[l] + numbers[r];
            if (sum == target)
                return new int[] { l + 1, r + 1 };
            else if (sum > target)
                r--;
            else
                l++;
        }
        return new int[] {};
    }
}




# 167. Two Sum II — Input Array Is Sorted

## 🧩 Pattern
Two Pointers (Sorted Array)

## 💡 Key Trick
Since the array is sorted, use two pointers from both ends.  
Move the left pointer right to increase sum, or the right pointer left to decrease sum until target is found.

## ⏱️ Complexity
Time: O(n)  
Space: O(1)

## 🧠 Alternative Approaches
- Hash Map → O(n) time, O(n) space (not optimal for sorted input)  
- Binary search for each element → O(n log n)