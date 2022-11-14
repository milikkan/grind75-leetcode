package dev.milikkan.grind75;

import java.util.ArrayDeque;
import java.util.Deque;

// problem link: https://leetcode.com/problems/implement-queue-using-stacks/
public class ImplementQueueUsingStacks {
    public static void main(String[] args) {
        MyQueue queue1 = new MyQueue();
        queue1.push(1);
        System.out.println(queue1); // [1]

        queue1.push(2);
        System.out.println(queue1); // [1, 2]

        System.out.println(queue1.peek()); // 1
        System.out.println(queue1); // [1, 2]

        System.out.println(queue1.pop()); // 1
        System.out.println(queue1);// [2]

        System.out.println(queue1.empty()); // false

        MyQueue queue2 = new MyQueue();
        System.out.println(queue2.peek()); // null
    }
}

class MyQueue {
    private final Deque<Integer> stackForQueue;
    private final Deque<Integer> stackForSwap;

    public MyQueue() {
        stackForQueue = new ArrayDeque<>();
        stackForSwap = new ArrayDeque<>();
    }

    public void push(int x) {
        while (!stackForQueue.isEmpty()) {
            stackForSwap.push(stackForQueue.pop());
        }

        stackForQueue.push(x);

        while (!stackForSwap.isEmpty()) {
            stackForQueue.push(stackForSwap.pop());
        }
    }

    public Integer pop() {
        return stackForQueue.pop();
    }

    public Integer peek() {
        return stackForQueue.peek();
    }

    public boolean empty() {
        return stackForQueue.isEmpty();
    }

    @Override
    public String toString() {
        return stackForQueue.toString();
    }
}
