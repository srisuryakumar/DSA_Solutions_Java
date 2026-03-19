public class Codec {

    // Encodes a list of strings to a single string.
    public String encode(List<String> strs) {
        if(strs.size() == 0)
            return Character.toString((char)258);
        String seperate = Character.toString((char)257);
        StringBuilder sb = new StringBuilder();
        for(String s: strs){
            sb.append(s);
            sb.append(seperate);
        }
        sb.deleteCharAt(sb.length - 1);
        return sb.toString();
    }

    // Decodes a single string to a list of strings.
    public List<String> decode(String s) {
        if(s.equals(Character.toString((char)258)))
            return new ArrayList();
        String seperate = Character.toString((char)257);
        return Arrays.asList(s.split(seperate, -1));
    }
}

// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.decode(codec.encode(strs));




# 271. Encode and Decode Strings

## 🧩 Pattern
Design / String Manipulation (Length-Prefixing)

## 💡 Key Trick
Instead of just using a delimiter, prefix each string with its length followed by a special character (e.g., 4#code). This allows the decoder to know exactly how many characters to read next, making the content of the string (even if it contains the delimiter) irrelevant.

## ⏱️ Complexity
Time: O(n)
Space: O(n)

## 🧠 Alternative Approaches
- Non-ASCII Delimiters: Use a character that is guaranteed not to be in the input (e.g., Unicode (char)257). This is faster to implement but less robust if the input range expands.
- Escaping Characters: Use a standard delimiter (like a comma) and "escape" any actual commas in the text (like \,). This is how CSV files work but is more complex to parse manually.