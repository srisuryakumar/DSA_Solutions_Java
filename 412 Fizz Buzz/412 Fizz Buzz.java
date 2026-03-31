class Solution {
    public List<String> fizzBuzz(int n) {
        List<String> list = new ArrayList<>();
        for (int i = 1; i <= n; i++) {
            if (i % 3 == 0 && i % 5 == 0)
                list.add("FizzBuzz");
            else if (i % 3 == 0)
                list.add("Fizz");
            else if (i % 5 == 0)
                list.add("Buzz");
            else
                list.add(Integer.toString(i));
        }
        return list;
    }
}








# 412. Fizz Buzz

## 🧩 Pattern
Simulation / Conditional Logic

## 💡 Key Trick
Check divisibility in the correct order:

First check i % 3 == 0 && i % 5 == 0
Then check individually for 3 and 5
This avoids missing the "FizzBuzz" case.

## ⏱️ Complexity
Time: O(n)
Space: O(n)

## 🧠 Alternative Approaches
- String concatenation approach (build result using conditions instead of else-if)
- Using a map for divisibility rules (extensible but overkill for this problem)