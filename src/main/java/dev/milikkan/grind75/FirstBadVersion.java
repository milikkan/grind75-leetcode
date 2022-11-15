package dev.milikkan.grind75;

// problem link: https://leetcode.com/problems/first-bad-version/
public class FirstBadVersion {
    private int badVersion;

    // time: O(logn)
    // space: O(1)
    // using Binary Search
    public int firstBadVersion(int n) {
        if (isBadVersion(1)) return 1;

        long left = 1;
        long right = n;

        while (left < right) {
            // using long to prevent integer overflow
            long middle = (left + right) / 2;
            boolean isBad = isBadVersion((int) middle);

            if (isBad) right = middle;
            else left = middle;

            if (right - left == 1) return (int) right;
        }
        return (int) right;
    }

    public static void main(String[] args) {
        FirstBadVersion fbv = new FirstBadVersion();
        fbv.setBadVersion(4);
        System.out.println(fbv.firstBadVersion(5)); // 4

        fbv.setBadVersion(1);
        System.out.println(fbv.firstBadVersion(1)); // 1
    }

    public void setBadVersion(int version) {
        this.badVersion = version;
    }

    public boolean isBadVersion(int version) {
        return version == this.badVersion;
    }
}
