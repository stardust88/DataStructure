package com.ds.bny;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class NUmberlistproblem {
	
	public static void main(String args[]) {
		List<Integer> list = new ArrayList<>();
//
//		
//		if(list==null || list.size()<=2)
//			return;
//		
//		int prev =0;
//		int current =1;
//		
//		while(current<list.size()-1) {
//			
//			if(list.get(prev)>list.get(current)&& list.get(current)<list.get(current+1)) {
//				list.remove(current);
//				prev =0;
//				current=1;
//			}else {
//				current++;
//				prev++;
//			}
//		}
//		
//		list.forEach(i->{
//			System.out.println(i);
//		});
		
		
//		List<String> upRight = new ArrayList<String>();
//		upRight.add("1 4");
//		upRight.add("2 3");
//		upRight.add("4 1");
//		
//		Map<String, Integer> cordinateValues = new HashMap<>();
//
//		int max=0;
//		int count =0;
//		for (int k=0;k<upRight.size();k++) {
//			String[] arr = upRight.get(k).trim().split(" ");
//			if (arr.length<2)
//				continue;
//			int row = Integer.parseInt(arr[0]);
//			int col = Integer.parseInt(arr[1]);
//			
//			for (int i=1;i<=row;i++)
//			{
//				for(int j=1;j<=col;j++) {
//					String coo = i+" "+j;
//					int value =1;
//					if(cordinateValues.containsKey(coo)) {
//						value =cordinateValues.get(coo)+1;
//					}
//					cordinateValues.put(coo, value);
//					
//					if(value==max) {
//			        	   count++;
//			           }else if (value>max) {
//			        	   max= value;
//			        	   count=1;
//			           }
//				}
//			}
//		}
//		
////		for (Map.Entry<String, Integer> en : cordinateValues.entrySet()) { 
////           if(en.getValue()==max) {
////        	   count++;
////           }else if (en.getValue()>max) {
////        	   max= en.getValue();
////        	   count=1;
////           }
////			
////        }
////		
//		System.out.println(max+" "+count);
		List<String> scenarios = new ArrayList<String>();
		scenarios.add("6 2 2");
		
		for (int i=0;i<scenarios.size();i++) {
			String scene = scenarios.get(i);
			String[] arr= scene.split(" ");
			int n = Integer.parseInt(arr[0]);
			int cost = Integer.parseInt(arr[1]);
			int m = Integer.parseInt(arr[2]);
			max(n, cost, m);
		}
	}
	
	
	private static void max(int n, int cost, int m) {
		
		int numberOfCOntainer = n/cost;
		int totalcontainer = numberOfCOntainer;
		
		while(numberOfCOntainer>=m)
		{
			int newOne =numberOfCOntainer/m;
			int residual = numberOfCOntainer%m;
			totalcontainer = totalcontainer+newOne;
			numberOfCOntainer = newOne+residual;
		}
		
		System.out.println(totalcontainer);
		
	}

}
