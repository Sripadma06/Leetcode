class Solution {
    public int maxProfit(int[] prices) {
        int n=prices.length;
        int maxRight[]=new int[n];
        maxRight[n-1]=prices[n-1];
        for(int i=n-2;i>=0;i--){
            maxRight[i]=Math.max(prices[i],maxRight[i+1]);
        }
        int maxProfit=0;
        for(int i=0;i<n;i++){
            int profit=maxRight[i]-prices[i];
            maxProfit=Math.max(maxProfit,profit);
        }
        return maxProfit;
    }
}