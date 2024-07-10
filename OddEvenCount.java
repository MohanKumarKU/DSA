package com.mo;

public class OddEvenCount {
	public static void main(String[] args)
	{
		int range =10;
		int i =1;
		int nOdd = 0;
		int nEven = 0;
		while(i<=range)
		{
			if(i%2 ==0)
			{
				System.out.println("Even ---> "+i);
				nEven++;
			}
			else
			{
				System.out.println("Odd ---> "+i);
				nOdd++;
			}
			i++;
		}
		System.out.println("Number of even's --->"+nEven);
		System.out.println("Number of odd's --->"+nOdd);
		
		System.out.println(GCD(98, 56, 0));
		
	}
	
	private static int GCD(int x, int y, int gcd)
	{
		
		if(x >= y)
		{
			int balance = x%y;
			if(balance != 0)
			{
				gcd = GCD(y, balance, gcd);
			}
			else
			{
				gcd = y;
			}
		}
		else
		{
			int balance = y%x;
			if(balance != 0)
			{
				gcd = GCD(x, balance, gcd);
			}
			else
			{
				gcd = x;
			}
		}
		return gcd;
	}
}
