import java.util.ArrayList;

/**
 * Q1. Given two sorted lists of Integers as input, 
 * write a method that produces a sorted list of Integers as output that represents the union of the two input lists. 
 * If the size of the two input lists are respectively a and b, 
 * the running time and space required by the algorithm should both be O(a + b).
 */

/**
 * @author shahneev
 */

public class Q1 {

	public static ArrayList<Integer> Merge(ArrayList<Integer> list_a, ArrayList<Integer> list_b) {

		ArrayList<Integer> sorted_list = new ArrayList<Integer>();

		// wanted complexity O (size(a) + size(b)) where O denotes the complexity of the
		// algorithm in the worst case
		// This means, we need to run through both lists at most once and store do a
		// merging operation while preserving
		// sorted integers. just using the sort function would result in nlogn.

		// usually linear complexity involves running through array some number of times
		// (multiple of size of array)

		// already sorted so implies merge sort
		// algorithmic structure

		int index_a = 0;
		int index_b = 0;

		// 1. loop through both lists by updating both indices of lists (i.e., index_a
		// and index _b)
		// 2. in your loop, always update the sorted_list with the element with the
		// smallest value
		// (i.e., the pseudo code: if list_a[index_a] < list_b[index_b] then
		// sorted_list.add(list_a[index_a]); index_a++
		// 3. consider what happens when index_a >= size (list_a) or index_b >= size
		// (list_b) -> and update the sorted_list
		// with the remaining of the values
		// 4. return the sorted_list

		while ((index_a < list_a.size() || index_b < list_b.size())) {

			if (index_a < list_a.size() && index_b < list_b.size()) {
				if (list_a.get(index_a) < list_b.get(index_b)) { //smaller index value comes first in a list (lowest to highest)
					sorted_list.add(list_a.get(index_a));
					index_a++;
				}
				if (list_a.get(index_a) >= list_b.get(index_b)) {
					sorted_list.add(list_b.get(index_b));
					index_b++;
				}
			} 
			
			else { 
				if (index_a < list_a.size()) { //if not gone thru iterating all the elements, since already sorted
					//we can just add all these elements to list
					for (; index_a < list_a.size(); index_a++) {
						sorted_list.add(list_a.get(index_a));
					}
				}
				
				if (index_b < list_b.size()) {
					for (; index_b < list_b.size(); index_b++) {
						sorted_list.add(list_b.get(index_b));
					}
				}
			}
		}

		return sorted_list;
	}

	public static void main(String[] args) {
		// Test your Q1 class here by calling Q1 on two sorted lists of Integers i.e.,
		// print out: Merge(list_a, list_b)
		ArrayList<Integer> list_a = new ArrayList<Integer>();
		list_a.add(1);
		list_a.add(4);
		list_a.add(6);
		list_a.add(10);
		list_a.add(55);
		list_a.add(60);

		ArrayList<Integer> list_b = new ArrayList<Integer>();
		list_b.add(1);
		list_b.add(4);
		list_b.add(6);
		list_b.add(10);
		list_b.add(55);
		list_b.add(60);

		System.out.println(Merge(list_a, list_b));
	}
}
