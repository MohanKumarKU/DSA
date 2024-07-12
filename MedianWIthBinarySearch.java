package com.mo.bs;

public class MedianOf2ArrayBS {
public static void main(String[] args) {
	
	int arrX[] = {1,2,3,4};
	int arrY[] = {2,4,6,8,10,12};
	
	System.out.println(getMedian(arrX, arrY));
	
}

private static double getMedian(int[] arrX, int[] arrY) {
	
	int l = 0;
	int h = arrX.length;
	
	if(arrX.length > arrY.length)
	{
		getMedian(arrY, arrX);
	}
	
	while(l<=h)
	{
	
	int pX = (l+h)/2;
	int pY = (arrX.length+arrY.length+1)/2 - pX;
	
	
	int maxLeftX = pX == 0 ? Integer.MIN_VALUE : arrX[pX-1];
	int minRightX = pX == arrX.length ? Integer.MAX_VALUE : arrX[pX];
	
	
	
	int maxLeftY = pY == 0 ? Integer.MIN_VALUE : arrY[pY-1];
	int minRightY = pY == arrY.length ? Integer.MAX_VALUE : arrY[pY];
	
	if(maxLeftX <= minRightY && maxLeftY <= minRightX)
	{
		
		if((arrX.length+arrY.length)%2 == 0)
		{
			return Double.valueOf(Math.max(maxLeftY, maxLeftX) + Math.min(minRightX, minRightY))/2;
		}
		return Math.max(maxLeftY, maxLeftX);
	}

	if(maxLeftX > minRightY)
	{
		h = pX-1;
	}
	if(maxLeftY > minRightX)
	{
		l = pX+1;
	}
	
	}
	return 0;
}
}
