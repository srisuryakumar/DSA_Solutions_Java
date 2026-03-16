class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List> map = new HashMap<>();
        int[] count = new int[26];
        for (String s : strs) {
            Arrays.fill(count, 0);
            for (int i = 0; i < s.length(); i++) {
                count[s.charAt(i) - 'a']++;
            }
            StringBuilder sb = new StringBuilder();
            for (int c : count) {
                sb.append(c);
                sb.append("#");
            }
            String key = sb.toString();
            if (!map.containsKey(key)) {
                map.put(key, new ArrayList());
            }
            map.get(key).add(s);
        }
        return new ArrayList(map.values());
    }
}