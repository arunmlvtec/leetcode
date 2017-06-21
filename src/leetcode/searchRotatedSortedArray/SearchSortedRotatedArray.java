/**
 * Leetcode Problem Solutions
 * Problem No: 33
 * Problem name: Search in Rotated Sorted Array
 * Description: Suppose an array sorted in ascending order is rotated at some pivot unknown to you beforehand.
 * 				(i.e., 0 1 2 4 5 6 7 might become 4 5 6 7 0 1 2).
 * You are given a target value to search. If found in the array return its index, otherwise return -1.
 * You may assume no duplicate exists in the array.
 * 
 * Input:	matrix = [4, 5, 6, 7, 0, 1, 2]
 * 			target = 5 , 9
 * Output:	1 , -1 
 */

package leetcode.searchRotatedSortedArray;

public class SearchSortedRotatedArray {

	public static void main(String[] args) {
		
		SearchSortedRotatedArray sa = new SearchSortedRotatedArray();
		int[] input = {4,5,6,7,8,0,1,2,3};
		int target = 7;
		System.out.println(sa.search(input, target));
	}

	private int search(int[] input, int target) {
		int low = 0;
		int high = input.length - 1;
		if (input == null || input.length == 0)
		    return -1;
		
		while (low < high) {
			int mid = (low + high) / 2;
			if (input[mid] == target)
				return mid;
			if (input[low] <= input[mid]) {
				if (target >= input[low] && target < input[mid]) {
					high = mid - 1;
				}
				else {
					low = mid + 1;
				}
			}
			else {
				if (target > input[mid] && target <= input[high]) {
					low = mid + 1;
				}
				else {
					high = mid - 1;
				}
			}
		}
		
		return (target == input[low])?low:-1;
	}

}
