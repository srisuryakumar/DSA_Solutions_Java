class Solution {
    public boolean isPalindrome(String s) {
        s = s.toLowerCase();
        int l = 0, r = s.length() - 1;
        while (l < r) {
            if (!Character.isLetterOrDigit(s.charAt(l)))
                l++;
            else if (!Character.isLetterOrDigit(s.charAt(r)))
                r--;
            else {
                if (s.charAt(l) != s.charAt(r))
                    return false;
                l++;
                r--;
            }
        }
        return true;
    }
}




# 125. Valid Palindrome

## 🧩 Pattern
Two Pointers (Ignore Non-Alphanumeric)

## 💡 Key Trick
Use two pointers from both ends.  
Skip characters that are not letters or digits, and compare remaining characters case-insensitively.

## ⏱️ Complexity
Time: O(n)
Space: O(1)

## 🧠 Alternative Approaches
- Build filtered string + reverse + compare → O(n) space  
- Stack-based comparison → unnecessary overhead