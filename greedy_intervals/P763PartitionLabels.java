/**
* ============================================================
* Problem    : 763. Partition Labels
* Platform   : LeetCode
* Difficulty : Medium
*
* Topics     : Strings, Greedy, Hash Table
* Pattern    : Greedy
*
* Link       : https://leetcode.com/problems/partition-labels
* ============================================================
*/

/*
Intuition

We need to divide the string into as many parts as possible such that each
character appears in only one partition.

The idea is to find the last occurrence of every character.

While traversing the string, keep extending the current partition to the last
occurrence of every character encountered in that partition.

When the current index reaches the end of the partition, all characters inside
the partition are completely contained within it, so we can finalize the
partition.
*/

/*
Approach
Greedy + Last Occurrence

First, store the last occurrence of every character in the string.

Traverse the string while maintaining the end of the current partition.

For each character, extend the partition end to the last occurrence of that
character if necessary.

When the current index reaches the partition end, finalize the partition,
store its length, and start a new partition.

Time: O(n)
Space: O(1)
*/

package greedy_intervals;

public class P763PartitionLabels {
    public List<Integer> partitionLabels(String s) {
        int[] lastOccurrence = new int[26];
        for (int i = 0; i < s.length(); i++) {
            lastOccurrence[s.charAt(i) - 'a'] = i;
        }
        List<Integer> partitionLengths = new ArrayList<>();
        int start = 0, end = 0;
        for (int i = 0; i < s.length(); i++) {
            end = Math.max(end, lastOccurrence[s.charAt(i) - 'a']);
            if (i == end) {
                partitionLengths.add(end - start + 1);
                start = i + 1;
            }
        }
        return partitionLengths;
    }
}