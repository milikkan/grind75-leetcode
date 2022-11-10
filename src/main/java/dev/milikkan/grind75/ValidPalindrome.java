package dev.milikkan.grind75;

// problem link: https://leetcode.com/problems/valid-palindrome/
public class ValidPalindrome {
    // time: O(n)
    // space: O(1)
    public static boolean isPalindrome(String s) {
        int leftIndex = 0;
        int rightIndex = s.length() - 1;

        while (leftIndex < rightIndex) {
            if (!Character.isLetterOrDigit(s.charAt(leftIndex))) {
                leftIndex++;
                continue;
            }
            if (!Character.isLetterOrDigit(s.charAt(rightIndex))) {
                rightIndex--;
                continue;
            }
            if (Character.toLowerCase(s.charAt(leftIndex)) != Character.toLowerCase(s.charAt(rightIndex))) {
                return false;
            }
            leftIndex++;
            rightIndex--;
        }
        return true;
    }

    public static void main(String[] args) {
        String s1 = "A man, a plan, a canal: Panama";
        String s2 = "race a car";
        String s3 = " ";

        System.out.println(isPalindrome(s1)); // true
        System.out.println(isPalindrome(s2)); // false
        System.out.println(isPalindrome(s3)); // true
    }
}
