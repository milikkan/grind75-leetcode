package dev.milikkan.grind75;

import java.util.HashMap;
import java.util.Map;

// problem link: https://leetcode.com/problems/ransom-note/
public class RansomNote {
    // first solution
    // time: O(n)
    // space: O(n)
    public boolean canConstruct1(String ransomNote, String magazine) {
        if (ransomNote.length() > magazine.length()) {
            return false;
        }

        Map<Character, Integer> letterCounts = new HashMap<>();
        for (char letter : magazine.toCharArray()) {
            letterCounts.compute(letter, (k, v) -> (v == null) ? 1 : v + 1);
        }

        for (char letter : ransomNote.toCharArray()) {
            if (!letterCounts.containsKey(letter) || letterCounts.get(letter) == 0) {
                return false;
            } else {
                letterCounts.computeIfPresent(letter, (k, v) -> v - 1);
            }
        }
        return true;
    }

    // second solution
    // time: O(n)
    // space: O(1)
    public boolean canConstruct2(String ransomNote, String magazine) {
        if (ransomNote.length() > magazine.length()) {
            return false;
        }

        int[] letterCounts = new int[26];
        for (char letter : magazine.toCharArray()) {
            letterCounts[letter - 'a'] += 1;
        }

        for (char letter : ransomNote.toCharArray()) {
            letterCounts[letter - 'a'] -= 1;
            if (letterCounts[letter - 'a'] == -1) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        RansomNote ransomNote = new RansomNote();
        System.out.println(ransomNote.canConstruct1("a", "b")); // false
        System.out.println(ransomNote.canConstruct1("aa", "ab")); // false
        System.out.println(ransomNote.canConstruct1("aa", "aab")); // true

        System.out.println(ransomNote.canConstruct2("a", "b")); // false
        System.out.println(ransomNote.canConstruct2("aa", "ab")); // false
        System.out.println(ransomNote.canConstruct2("aa", "aab")); // true
    }
}
