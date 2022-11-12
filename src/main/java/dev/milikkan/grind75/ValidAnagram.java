package dev.milikkan.grind75;

// problem link: https://leetcode.com/problems/valid-anagram/
public class ValidAnagram {
    // time: O(n)
    // space: O(1)
    public static boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) return false;

        char[] lettersS = new char[26];
        char[] lettersT = new char[26];

        for (int index = 0; index < s.length(); index++) {
            int letterPositionS = s.charAt(index) - 'a';
            lettersS[letterPositionS]++;

            int letterPositionT = t.charAt(index) - 'a';
            lettersT[letterPositionT]++;
        }

        for (int i = 0; i <= 25; i++) {
            if (lettersS[i] != lettersT[i]) return false;
        }

        return true;
    }

    public static void main(String[] args) {
        String s1 = "anagram";
        String t1 = "nagaram";

        System.out.println(isAnagram(s1, t1)); // true

        String s2 = "rat";
        String t2 = "car";
        System.out.println(isAnagram(s2, t2)); // false
    }
}
