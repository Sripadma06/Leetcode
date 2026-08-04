class Solution {
    public int maxProduct(int[] nums) {
        int maxEnd=nums[0];
        int minEnd=nums[0];
        int maxProd=nums[0];
        for(int i=1;i<nums.length;i++){
            if(nums[i]<0){
                int temp=maxEnd;
                maxEnd=minEnd;
                minEnd=temp;
            }
            maxEnd=Math.max(nums[i],nums[i]*maxEnd);
            minEnd=Math.min(nums[i],nums[i]*minEnd);
            maxProd=Math.max(maxProd,maxEnd);
        }
        return maxProd;
    }
}