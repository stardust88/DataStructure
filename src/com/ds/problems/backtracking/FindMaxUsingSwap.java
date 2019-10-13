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
