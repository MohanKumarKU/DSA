package com.mo;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class KthLargestElementinArray {

	public static void main(String[] args)
	{
		int nums[] = {3,2,1,5,6,4};
		System.out.println(findKthLargestUsingMinHeap(nums, 2));
	}
	

public static int findKthLargestUsingMinHeap(int[] nums, int k) {
	PriorityQueue<Integer> minHeap = new PriorityQueue<>();
	for(int i=0; i<k; i++)
	{
		minHeap.offer(nums[i]);
	}
	
	for(int x = k; x<nums.length; x++)
	{
		if(nums[x] > minHeap.peek())
		{
			minHeap.poll();
			minHeap.offer(nums[x]);
		}
	}
	return minHeap.peek();
}

public static int findKthLargest(int[] nums, int k) {
    Map<Integer, Integer> map = new HashMap<>();
    int max = Integer.MIN_VALUE;
    int min = Integer.MAX_VALUE;
    for(int n : nums)
    {
        int quantity = map.get(n) != null ? map.get(n)+1 : 1;
        map.put(n, quantity);
        max = n > max ? n : max;
        min = n < min ? n : min; 
    }

    if(map.get(max) >= k)
        return max;

    for(int n = max; n >=min; n--)
    {
        if(map.get(n) != null)
        {
            k = k - map.get(n);
            if(k>0)
                continue;
            return n;
        }
    }
    return Integer.MIN_VALUE;
}

}