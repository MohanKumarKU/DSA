package com.mo;

public class MedianOf2Array {
	
	public static void main(String[] args) {
		
		int[] a= {1,1,1,1,1,1,1,1,1,1,4,4};
		int b[] = {1,3,4,4,4,4,4,4,4,4,4};
		
	int n[] = new int[a.length + b.length];
		
		int i=0;
		int j=0;
		int k=0;
		
		while(i<a.length && j<b.length)
		{
			 if(a[i] < b[j])
			 {
				 n[k] = a[i];
				 k++;
				 i++;
			 }
			 else if(a[i] > b[j])
			 {
				 n[k] = b[j];
				 k++;
				 j++;
			 }
			 else
			 {
		        n[k] = b[j];
                k++;
                j++;
                n[k] = a[i];
			    i++;
			    k++;
			 }
		}
		
		while(i<a.length)
		{
			n[k] = a[i];
			i++;
			k++;
		}
		
		while(j<b.length)
		{
			n[k] = b[j];
			j++;
			k++;
		}
		
		int size = n.length;
		double median = size % 2 != 0 ? n[size/2] : Double.valueOf(n[(size/2)-1] + n[size/2])/2; 
		System.out.println(median);
		 
				 
	}
}
