package com.ds.problems.backtracking;

import java.util.ArrayList;
import java.util.List;

/**
 * A dearrangement is a permutation p of {1,.....,n} such that no item is in it's proper position,
 * i.e p(i)!=i for all 1<=i<=n. Write an efficient backtracking program with pruning that constructs all the de-arrangements of n items.
 * @author deepm
 *
 */
public class Dearrangements {
	
	public static void main(String args[]) {
		
		List<Integer> someInt = new ArrayList<>();
		someInt.add(1);
		someInt.add(2);
		someInt.add(3);
		someInt.add(4);
		someInt.add(5);
		
		dearrange(someInt, new ArrayList<Integer>(), 0, someInt.size());
		
	}
	
	private static void dearrange(List<Integer> input, List<Integer> output,int currentIndex,int size) {
		if(currentIndex>=size) {
			System.out.println(output);
			return;
		}
		
		for(int i=0;i<input.size();i++) {
			if(currentIndex+1==input.get(i))
				continue;
			int item = input.remove(i);
			output.add(currentIndex, item);
			dearrange(input, output, currentIndex+1, size);
			output.remove(currentIndex);
			input.add(i, item);
		}
		
		return;
	}
	

}
