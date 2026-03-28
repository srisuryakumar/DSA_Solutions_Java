class Solution {
    public int maxArea(int[] height) {
        int l = 0, r = height.length - 1, result = 0;
        while (l < r) {
            int min = Math.min(height[l], height[r]);
            int area = min * (r - l);
            result = Math.max(area, result);
            if (height[l] < height[r])
                l++;
            else
                r--;
        }
        return result;
    }
}





# 11. Container With Most Water

## 🧩 Pattern
Two Pointers

## 💡 Key Trick
Start with two ends. Calculate area and move the pointer with the smaller height (since it limits the area).

## ⏱️ Complexity
Time: O(n)
Space: O(1)

## 🧠 Alternative Approaches
- Brute force: O(n²) (check all pairs)