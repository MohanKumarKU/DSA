package com.mo;

public class MaximumSUbArray {
	public static void main(String[] args) {
		int[] nums = { -2, 1, -3, 4, -1, 2, 1, -5, 4 };

		int[] nums1 = { 1, -1, 1 };

		System.out.println(maxSubArray(nums1));
	}
	
	
	public static int maxSubArray(int[] nums) {
		int sum =0;
		int result = 0;
		int s =0;
		int start =0;
		int end = 0;
		for(int i=0; i<nums.length; i++)
		{
			if(sum ==0)
				s = i;
			
			sum+=nums[i];
			if(sum < 0)
			{
				sum =0;
			}
			else if(sum > result)
			{
				result = sum;
				end = i;
				start = s;
			}
		}
		System.out.println(start+"   "+end);
		return result;
	}
}
