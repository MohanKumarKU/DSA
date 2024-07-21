package com.mo.string;

public class RepeatedStringSearch {
public static void main(String[] args) {
	System.out.println(repeatedStringMatch("abc", "cabcabca"));
}


public static int repeatedStringMatch(String a, String b) {
	
	int aLen = a.length();
	
	int bLen = b.length();
	
	int n = bLen/aLen;
	
	int count = n;
	String temp = "";
	
	while(n>0)
	{
		temp+=a;
		n--;
	}
	
	if(isPatternFoundKMP(temp, b))
		return count;
	
	temp+=a;
	
	if(isPatternFoundKMP(temp, b))
		return count+1;
	
	temp+=a;
	
	if(isPatternFoundKMP(temp, b))
		return count+2;
	
	return -1;
	
}


private static boolean isPatternFoundKMP(String temp, String b) {
	
	char aa[] = temp.toCharArray();
	char bb[] = b.toCharArray();
	
	int[] lps = new int[b.length()];
	
	computeLPS(bb, lps);
	int i=0;
	int j=0;
	
	while(i<aa.length)
	{
		if(aa[i] == bb[j])
		{
			i++;j++;
			if(j == b.length())
				return true;
		}
		else
		{
			if(j != 0)
			{
				j=lps[j-1];
			}
			else
			{
				i++;
			}
		}
	}
	return false;
}


private static void computeLPS(char aa[], int[] lps) {
	
	// length of the previous longest prefix suffix
	int len =0;
	lps[0] = 0; // lps[0] is always 0
	int i=1;
	
	// the loop calculates lps[i] for i = 1 to M-1
	while(i<aa.length)
	{
		if(aa[i] == aa[len])
		{
			len++;
			lps[i] = len;
			i++;
		}
		else // (pat[i] != pat[len])
		{
			if(len!=0) {
				len = lps[len-1];
				// Also, note that we do not increment
                // i here
			}
			else { // if (len == 0)
				lps[i] = 0;
				i++;
			}
		}
	}
	
}

}
