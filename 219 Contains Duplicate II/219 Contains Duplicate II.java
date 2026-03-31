class Solution {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            if (set.contains(nums[i]))
                return true;
            set.add(nums[i]);
            if (set.size() > k) {
                set.remove(nums[i - k]);
            }
        }
        return false;
    }
}






# 219. Contains Duplicate II

## 🧩 Pattern
Sliding Window + Hash Set

## 💡 Key Trick
Maintain a sliding window of size k using a HashSet.

If the current element already exists in the set → duplicate within range
Add current element to the set
If window size exceeds k, remove the element at i - k

## ⏱️ Complexity
Time: O(n)
Space: O(k)

## 🧠 Alternative Approaches
- Brute force (check all pairs within k distance) → O(n * k)
- HashMap storing last index → O(n) time, O(n) space