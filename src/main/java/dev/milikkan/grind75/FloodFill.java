package dev.milikkan.grind75;

import java.util.LinkedList;

// problem link: https://leetcode.com/problems/flood-fill/
public class FloodFill {
    // time: O(n)
    // space: O(n)
    public static int[][] floodFill(int[][] image, int sr, int sc, int color) {
        LinkedList<Node> nodes = new LinkedList<>();
        nodes.offer(new Node(sr, sc));
        int initialColor = image[sr][sc];
        if (initialColor == color) return image;

        while (!nodes.isEmpty()) {
            Node current = nodes.poll();
            int x = current.x;
            int y = current.y;
            image[x][y] = color;

            if (x >= 1 && image[x - 1][y] == initialColor) {
                nodes.offer(new Node(x - 1, y));
            }
            if (y >= 1 && image[x][y - 1] == initialColor) {
                nodes.offer(new Node(x, y - 1));
            }
            if (y < image[x].length - 1 && image[x][y + 1] == initialColor) {
                nodes.offer(new Node(x, y + 1));
            }
            if (x < image.length - 1 && image[x + 1][y] == initialColor) {
                nodes.offer(new Node(x + 1, y));
            }
        }
        return image;
    }

    public static void main(String[] args) {
        int[][] image1 = {
                {1, 1, 1},
                {1, 1, 0},
                {1, 0, 1}
        };
        int sr1 = 1;
        int sc1 = 1;
        int color1 = 2;

        int[][] result1 = floodFill(image1, sr1, sc1, color1);
        printImage(result1);

        int[][] image2 = {
                {0, 0, 0},
                {0, 0, 0}
        };
        int sr2 = 0;
        int sc2 = 0;
        int color2 = 0;

        int[][] result2 = floodFill(image2, sr2, sc2, color2);
        printImage(result2);
    }

    private static void printImage(int[][] image) {
        for (int[] row : image) {
            for (int num : row) {
                System.out.print(num + " ");
            }
            System.out.println();
        }
        System.out.println("---------");
    }
}

class Node {
    int x;
    int y;

    public Node(int x, int y) {
        this.x = x;
        this.y = y;
    }
}

/*
- create a queue
- offer root  node (sr, sc)
- check following
  - sr - 1  sc
  - sr, sc - 1
  - sr, sc + 1
  - sr + 1, sc
- if sr = 0 -> dont do sr -1
- if sc = 0 -> dont do sc -1
- if sr = image.len - 1 -> dont do sr
- if sc = image[sr].len -> dont do sc
- if sr, sc != original color -> dont do sr, sc
- else offet the node to the queue
- stop if the queue is empty
 */
