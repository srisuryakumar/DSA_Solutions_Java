class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(nums);
        for (int i = 0; i < nums.length && nums[i] <= 0; i++) {
            if (i == 0 || nums[i] != nums[i - 1])
                twoSums(nums, i, result);
        }
        return result;
    }

    public void twoSums(int[] nums, int i, List<List<Integer>> result) {
        int l = i + 1;
        int r = nums.length - 1;
        while (l < r) {
            int sum = nums[i] + nums[l] + nums[r];
            if (sum < 0)
                l++;
            else if (sum > 0)
                r--;
            else {
                result.add(Arrays.asList(nums[i], nums[l++], nums[r--]));
                while (l < r && nums[l] == nums[l - 1]) {
                    ++l;
                }
            }
        }
    }
}





# 15. 3Sum

## 🧩 Pattern
Sorting + Two Pointers

## 💡 Key Trick
Sort the array, then fix one element and use two pointers (l, r) to find pairs that sum to -nums[i].
Skip duplicates to ensure unique triplets.

## ⏱️ Complexity
Time: O(n²)
Space: O(1) (excluding result)

## 🧠 Alternative Approaches
- Brute force (3 loops): O(n³)
- HashSet for 2Sum inside loop: O(n²) time, O(n) space