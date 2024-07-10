package com.mo;

public class MaxSubArrayWithDivideAndConquer {

	
	public static void main(String[] args) {
		int arr[] = { 2, 3, 4, 5, 7 };
		int n = arr.length;
		int max_sum = maxSubArraySum(arr, 0, n - 1);

		System.out.println("Maximum contiguous sum is " + max_sum);
	}

	private static int maxSubArraySum(int[] arr, int i, int j) {
		
		if(i>j)
			return Integer.MIN_VALUE;
		
		if(i==j)
			return arr[i];
		
		int m = (i+j)/2;
		
		return Math.max(Math.max(maxSubArraySum(arr, i, m-1), maxSubArraySum(arr, m+1, j)), maxCrossSubArray(arr, i, m ,j));
	}

	private static int maxCrossSubArray(int[] arr, int i, int m, int j) {
		
		int sum =0;
		int leftSum =Integer.MIN_VALUE;
		int rightSum =Integer.MIN_VALUE;
		
		for(int k=m; k>=i; k--)
		{
			sum+=arr[k];
			leftSum = Math.max(leftSum, sum);
		}
		sum =0;
		for(int k=m; k>=j; k++)
		{
			sum+=arr[k];
			rightSum=Math.max(rightSum, sum);
		}
		
		return Math.max(leftSum + rightSum - arr[m] ,  Math.max(leftSum, rightSum));
	}

}
