class Solution {
    public int removeDuplicates(int[] nums) {
        int l = 0, r = 0, k = 0;
        while (r < nums.length) {
            if (nums[l] != nums[r]) {
                l++;
                nums[l] = nums[r];
                k++;
            }
            r++;
        }
        return k + 1;
    }
}







# 26. Remove Duplicates from Sorted Array

## 🧩 Pattern
Two Pointers

## 💡 Key Trick
Use a slow pointer to track unique elements and a fast pointer to scan the array.
When a new element is found, place it at the next position of the slow pointer.

## ⏱️ Complexity
Time: O(n)
Space: O(1)

## 🧠 Alternative Approaches
- Use Set: O(n) time, O(n) space
- Brute force shifting: O(n²)