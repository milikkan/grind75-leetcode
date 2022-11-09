package dev.milikkan.grind75;

// problem link: https://leetcode.com/problems/best-time-to-buy-and-sell-stock/
public class BestTimeToBuyAndSellStock {
    // time: O(n)
    // space: O(1)
    public static int maxProfit(int[] prices) {
        int minPrice = 0;
        int maxPrice = 0;
        int profit;
        int maxProfit = 0;

        while (minPrice < prices.length - 1 && maxPrice < prices.length - 1) {
            if (prices[maxPrice + 1] < prices[maxPrice] && prices[maxPrice + 1] <= prices[minPrice]) {
                maxPrice = maxPrice + 1;
                minPrice = maxPrice;
            } else {
                maxPrice = maxPrice + 1;
                profit = prices[maxPrice] - prices[minPrice];
                if (profit > maxProfit) maxProfit = profit;
            }
        }
        return maxProfit;
    }

    public static void main(String[] args) {
        int[] prices1 = {7, 1, 5, 3, 6, 4};
        System.out.println(maxProfit(prices1)); // 5

        int[] prices2 = {7, 6, 4, 3, 1};
        System.out.println(maxProfit(prices2)); // 0
    }
}
