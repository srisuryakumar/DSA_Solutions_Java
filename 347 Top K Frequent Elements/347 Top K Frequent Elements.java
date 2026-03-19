class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        if (nums.length == k)
            return nums;
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        Queue<Integer> queue = new PriorityQueue<>((a, b) -> map.get(a) - map.get(b));
        for (int m : map.keySet()) {
            queue.add(m);
            if (queue.size() > k)
                queue.poll();
        }
        int[] ans = new int[k];
        for (int i = 0; i < k; i++) {
            ans[i] = queue.poll();
        }
        return ans;
    }
}




# 347. Top K Frequent Elements

## 🧩 Pattern
Hash Map + Min Heap (Priority Queue)

## 💡 Key Trick
Count frequencies, then keep only the k most frequent elements using a min heap of size k.  
Remove the smallest frequency whenever heap size exceeds k.

## ⏱️ Complexity
Time: O(n log k)  
Space: O(n)

## 🧠 Alternative Approaches
- Bucket Sort: O(n) optimal solution  
- Sorting by frequency: O(n log n)