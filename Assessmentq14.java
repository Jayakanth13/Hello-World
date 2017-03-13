package testing;

import java.util.*;

public class Assessmentq14 {

	public static void main(String[] args) {

		int array[] = new int[] { 8, 2, 5, 2, 4, 5, 6, 2, 5, 6, 5, 7, 5 };
		ArrayList<Integer> duplicate = new ArrayList<Integer>();
		ArrayList<Integer> copy = new ArrayList<Integer>();
		ArrayList<Integer> maxspan = new ArrayList<Integer>();

		int one = 0;
		int two = 0;

		int length = array.length;

		if (length == 1) {

			System.out.println("1");
		} else {
			// Check for duplicate values and add into an ArrayList duplicate
			for (int i = 0; i < length; i++) {
				for (int j = 0; j < length - 1; j++) {

					one = array[i];
					two = array[j];
					if (one == two && i != j) {
						one = array[i];
						duplicate.add(one);

					}
				}

			}
			// Create a unique set of duplicate values
			Set<Integer> unique = new HashSet<Integer>(duplicate);
			Iterator<Integer> itr = unique.iterator();
			// Create an ArrayList of the input array

			for (int l = 0; l < length; l++) {
				int num = array[l];
				copy.add(num);
			}
			/*
			 * Calculating the span of the duplicate values by parsing the
			 * iterator and the ArrayList of input. Adding the span values to an
			 * ArrayList called maxspan
			 */
			while (itr.hasNext()) {
				int com = itr.next();
				for (int m = 0; m < length; m++) {

					if (copy.get(m) == com) {

						int firstindex = copy.indexOf(copy.get(m));
						int lastindex = copy.lastIndexOf(copy.get(m));
						int finalspan = lastindex - firstindex + 1;
						maxspan.add(finalspan);

					}
				}
			}

			Set<Integer> uniquespan = new HashSet<Integer>(maxspan);
			boolean empty = uniquespan.isEmpty();
			if (empty == true) {
				System.out.println("-1");
			} else {
				
				System.out.println(Collections.max(uniquespan));
			}
		}
	}
}

/*
 * Q14)Find the Maximum span of the given array. -- 10marks span is the number
 * of elements between the duplicate element including those 2 repeated numbers.
 * BR1 : if the array as only one elemnt,then the span is 1. --2marks-- BR2 : If
 * the array doesn't have a duplicate element, then display -1. --3marks--
 * input[]={1,2,1,1,3} output1=4 input[]={1,2,3,4,1,1,5} output1=6
 * 
 * Test data : { 8,2,5,2, 4,5,6, 2,5,6,5,7,5} = 13 duplicates - span 2 = 7 5 =11
 * {RIGHT}
 * 
 * 6 = 4
 * 
 */
