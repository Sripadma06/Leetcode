class Solution {
    public int threeSumClosest(int[] nums, int target) {
         int n=nums.length;
        Arrays.sort(nums);
        int ans=nums[0]+nums[0+1]+nums[0+2];
        for(int i=0;i<nums.length;i++){
            int j=i+1;
            int k=n-1;
            while(j<k){
                int nas=nums[i]+nums[j]+nums[k];

                if(Math.abs(target-nas)<Math.abs(target-ans))ans=nas;
                if(nas>target)k--;
                else j++;
            }
        }

        return ans;
    }
}