package com.mo;

public class HappYNumber {
	public static void main(String[] arr) {

		int n = 2;
		System.out.println(isHappyNumber(n));
		
	}

	private static boolean isHappyNumber(int n) {
		boolean isHappy  = false;
		while(true)
		{
			int sum = 0;
			while(n>0)
			{
				int rem = n%10;
				sum+=rem*rem;
				n=n/10;
			}
			if(sum == 4)
			{
				isHappy = false;
				break;
			}
			else if (sum == 1)
			{
				isHappy = true;
				break;
			}
			else
				n = sum;
		}
		return isHappy;
	}
	
	
	private boolean isPrime(int n)
	{
		for(int i=2; i<n/2; i++)
		{
			if (n%i == 0)
				return false;
		}
		return true;
	}
}
