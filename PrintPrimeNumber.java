package com.mo;

import java.util.Arrays;

public class PrintPrimeNumber {

	public static void main(String[] arr)
	{
		printPrimeNumber(20);
	}

	//sieveOfEratosthenes
	private static void printPrimeNumber(int i) {
		
		int arr[] = new int[i+1];
		
		Arrays.fill(arr, 1);
		
		for(int k=2; k*k<=i; k++)
		{
			if(arr[k] == 1)
			{
				for(int x = k*k; x<=i; x+=k)
				{
					arr[x] = 0;
				}
			}
		}
		
		for(int l=1; l<arr.length; l++)
		{
			if(arr[l] == 1)
			{
				System.out.println(l);
			}
		}
	}
	
	
}
