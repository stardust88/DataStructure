/*
 * 
 * Given a number K and string S of digits denoting a positive integer, build the largest number possible by performing swap operations on the digits of S atmost K times.

Input:
The first line of input contains an integer T denoting the number of test cases. Then T test cases follow. The first line of each test case contains a positive integer K. The second line of each test case contains a string of digits denoting a positive integer.

Output:
Print out the largest number possible.

Constraints:
1 <= T <= 100
0 <   S <= 30
0 <   K  <= 10

Examples :
Input:
3
4
1234567
3
3435335
2
1034

Output:
7654321
5543333
4301

Explanation:
Testcase 1: Three swaps can make the input 1234567 to 7654321, swapping 1 with 7, 2 with 6 and finally 3 with 5.
 * */

package com.ds.problems.backtracking;

import java.util.Scanner;

public class FindMaxUsingSwap {
	public static String max="0";
	public static void main(String args[]) {
		
//		Scanner sc=new Scanner(System.in);
//		  int tc=sc.nextInt();
//		  while(tc-->0)
//		  {
//		      int k=sc.nextInt();
//		      String max="0";
//		      String s;
//		      s=sc.next();
//		       
//		      findMaxSwap(s,k);
//		      if(max.equals("0"))
//		      System.out.println(s);
//		      else
//		      System.out.println(max);
//		  }
		
		String number = "6189";
		System.out.println(findMaxSwap(number, 2));
		
		char s[]=number.toCharArray();
		maxString(s, 2);
		System.out.println(max);
		
		
	}
	
	// back tracking approach. perfect for this kind of problems, where we need to look at all possible permutation combinations
	public static void maxString(char s[],int k){
        if(k==0){
            return;
        }
        for(int i=0;i<s.length;i++){
            for(int j=i+1;j<s.length;j++){
                if(s[j]>s[i]){
                	swapPos(i,j,s);
                    String x=String.valueOf(s);
                    if(x.compareTo(max)>0){
                        max=x;
                    }
                    maxString(s,k-1);
                    swapPos(i,j,s);
                }
            }
        }
    }
	// greedy approach. which fails in some cases
	public static String findMaxSwap(String number, int k) {
		
		char [] arr = number.toCharArray();
		int swapCount = 0;
		
		for (int i=0;i<arr.length-1;i++) {
			int maxPos = i+1;
			for(int j= i+1; j<arr.length;j++) {
				if(arr[maxPos]<=arr[j]) {
					maxPos = j;
				}
			}
			if(arr[i]<arr[maxPos]) {
				swapPos(i, maxPos, arr);
				swapCount++;
			}
			if(swapCount>=k)
				break;
		}
		
		
		return String.valueOf(arr);
	}
	//99876215431
	//99876125431
	private static void swapPos(int pos1, int pos2,char[] arr) {
		if(pos1 <0 || pos2<0 || pos1> arr.length-1 || pos2> arr.length-1)
			return;
		char temp;
		temp = arr[pos1];
		arr[pos1] = arr[pos2];
		arr[pos2] = temp;
		
	} 
	

}
