class Solution {
    public int maxProfit(int[] prices) {
        int min = prices[0];
        int profit = 0;
        for(int i = 0; i < prices.length; i++){
            if(prices[i] < min)
                min = prices[i];
            profit = Math.max(profit, prices[i] - min);
        }
        return profit;
    }
}





# 121. Best Time to Buy and Sell Stock

## 🧩 Pattern
Greedy (Tracking Minimum)

## 💡 Key Trick
For each price, track the minimum price so far and compute
profit = current price - min price

## ⏱️ Complexity
Time: O(n)
Space: O(1)

## 🧠 Alternative Approaches
- Brute force: O(n²)
- Dynamic Programming (not required for single transaction)