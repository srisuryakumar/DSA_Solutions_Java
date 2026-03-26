class Solution {
    public int[] productExceptSelf(int[] nums) {
        int pre = 1, pos = 1;
        int[] ans = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            ans[i] = pre;
            pre *= nums[i];
        }
        for (int i = nums.length - 1; i >= 0; i--) {
            ans[i] *= pos;
            pos *= nums[i];
        }
        return ans;
    }
}





# 238. Product of Array Except Self

## 🧩 Pattern
Prefix + Suffix Product

## 💡 Key Trick
Build result using:
* Left product (prefix)
* Right product (suffix)
  → Multiply both for each index

## ⏱️ Complexity
Time: O(n)
Space: O(1)

## 🧠 Alternative Approaches
- Using division (fails with zeros)
- Brute force: O(n²)