package com.mo;

import java.util.ArrayList;
import java.util.List;

public class Pattern1 {

	public static void main(String[] args)
	{
		reverseTriangle();
	}
	
	private static void triangle1() {
		
		int n =7;
		int one = 1;
		
		List<Integer> list = new ArrayList<>();
		List<Integer> list2 = new ArrayList<>();
		
		for(int i=1; i<=n; i++)
		{
			for(int j=1; j<=n-i; j++)
			{
				System.out.print(" ");
			}
			
			for(int k=0; k<i; k++)
			{
				if(k==0 || k==i-1)
				{
					System.out.print(one+ " ");
					list.add(one);
					list2.add(one);
				}
				else
				{
					System.out.print(list.get(k) + list.get(k-1)+ " "); 
					list2.add(list.get(k-1) + list.get(k));
				}
			}
			list.clear();
			list.addAll(list2);
			list2.clear();
			System.out.println();
		}
		
	}
	private static void triangle() {
		
		int i= 5;
		for(int m=1; m<=i; m++)
		{
			for(int k=1; k<=i-m; k++)
			{
				System.out.print(" ");
			}
			for(int n=1; n<=m; n++)
			{
				System.out.print(m+" ");
			}
			System.out.println();
		}
		
	}
	
	private static void reverseTriangle() {
		
		int y = 9;
		int i= y/2+1;
		for(int m=1; m<=i; m++)
		{
			for(int k=1; k<m; k++)
			{
				System.out.print(" ");
			}
			for(int n=1; n<=i-m+1; n++)
			{
				if(n ==1 || n ==i-m+1)
				System.out.print("* ");
				else
				System.out.print("  ");
			}
			System.out.println();
		}
		
		for(int m=1; m<=y-i; m++)
		{
			for(int k=y-i-m; k<=y; k--)
			{
				System.out.print(" ");
			}
			for(int n=1; n<=m+1; n++)
			{
				if(n ==1 || n ==m+1)
				System.out.print("* ");
				else
				System.out.print("  ");
			}
			System.out.println();
		}
		
	}
}
