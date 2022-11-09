package dev.milikkan.grind75;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Map;

// problem link: https://leetcode.com/problems/valid-parentheses/
public class ValidParentheses {
    // time: O(n)
    // space: O(n)
    public static boolean isValid(String s) {
        Map<Character, Character> pairs = Map.of(
                ')', '(',
                ']', '[',
                '}', '{'
        );

        Deque<Character> stack = new ArrayDeque<>();

        for (char ch : s.toCharArray()) {
            if (!pairs.containsKey(ch)) {
                stack.push(ch);
            } else if (!stack.isEmpty() && stack.peek() == pairs.get(ch)) {
                stack.pop();
            } else {
                return false;
            }
        }
        return stack.isEmpty();
    }

    public static void main(String[] args) {
        String s1 = "()";
        System.out.println(isValid(s1));

        String s2 = "()[]{}";
        System.out.println(isValid(s2));

        String s3 = "(])";
        System.out.println(isValid(s3));
    }
}
