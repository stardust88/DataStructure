package com.ds.sorting;

public class MergeSort {
	
	public static void main(String args[]) {
		
		int arr[] = new int[] {5,6,3,1};
		sort(arr);
		
		for(int i=0;i<arr.length;i++) {
			System.out.println(arr[i]);
		}
	}
	
	public static void sort(int[] arr) {
		sort(arr,new int[arr.length], 0, arr.length-1);
	}
	
	private static void sort(int[] arr,int[] helper, int low, int high) {
		if(high>low) {
			int mid = (low+high)/2;
			sort(arr,helper, low, mid);
			sort(arr,helper, mid+1, high);
			merge(arr,helper, low, mid, high); 
		}
		
	}
	
	private static void merge(int[] arr, int[] helper,int low,int mid, int high) {
		
		//copy both halves into helper array;
		for(int i=low;i<=high;i++) {
			helper[i] = arr[i];
		}
		
		// get track of start of two halves in the helper array.
		int leftStart = low;
		int rightStart = mid+1;
		int current =low;
		
		
		while(leftStart<=mid && rightStart<=high) {
			if(helper[leftStart]<=helper[rightStart]) {
				arr[current] = helper[leftStart];
				leftStart++;
			}else {
				arr[current] = helper[rightStart];
				rightStart++;
			}
			
			current++;
		}
		
		int remaining = mid - leftStart;
		
		for (int i=0;i<=remaining;i++) {
			arr[current+i] = helper[leftStart+i];
		}
		
	}

}
