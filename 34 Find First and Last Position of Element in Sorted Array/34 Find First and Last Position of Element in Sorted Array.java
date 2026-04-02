class Solution {
    public int[] searchRange(int[] nums, int target) {
        int firstElement = findPositionOfElement(nums, target, true);
        if (firstElement == -1)
            return new int[] { -1, -1 };
        int lastElement = findPositionOfElement(nums, target, false);
        return new int[] { firstElement, lastElement };
    }

    private int findPositionOfElement(int[] nums, int target, boolean isFirstElement) {
        int l = 0, r = nums.length - 1;
        while (l <= r) {
            int mid = l + (r - l) / 2;
            if (nums[mid] == target) {
                if (isFirstElement) {
                    if (l == mid || nums[mid - 1] != target)
                        return mid;
                    r = mid - 1;
                } else {
                    if (r == mid || nums[mid + 1] != target)
                        return mid;
                    l = mid + 1;
                }
            } else if (nums[mid] < target)
                l = mid + 1;
            else
                r = mid - 1;
        }
        return -1;
    }
}








# 34. Find First and Last Position of Element in Sorted Array/34 Find First and Last Position of Element in Sorted Array

## 🧩 Pattern
Binary Search (Modified)

## 💡 Key Trick
Use binary search twice to find boundaries:

First pass → find first occurrence
Second pass → find last occurrence
Adjust search space when target is found to continue searching left/right

## ⏱️ Complexity
Time: O(log n)
Space: O(1)

## 🧠 Alternative Approaches
- Linear scan → O(n)
- Using built-in lower_bound & upper_bound (in other languages) → O(log n)