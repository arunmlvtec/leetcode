/**
 * Leetcode Problem Solutions
 * Problem No: 162
 * Problem name: Find Peak Element
 * Description: A peak element is an element that is greater than its neighbors.
 * Given an input array where num[i] ≠ num[i+1], find a peak element and return its index.
 * The array may contain multiple peaks, in that case return the index to any one of the peaks is fine.
 * You may imagine that num[-1] = num[n] = -∞.
 * Input: [1, 2, 3, 1]
 * Output: 2 (index of element 3).
 * Solved By: Arun Pokharna
 * 
 * */
package leetcode.findpeakelement;

public class FindPeakElement {

	public static void main(String[] args) {
		int[] nums = {1,2,3,4,0,4,3,6,2,1};
		FindPeakElement f = new FindPeakElement();
		System.out.println(f.findPeakElement(nums));
	}
    public int findPeakElement(int[] nums) {
        return findPeak(nums, 0, nums.length-1);
    }
    public int findPeak(int[] nums, int start, int end){
        if (start == end){
            return start;
        }
        else if (start + 1 == end) {
            if (nums[start] > nums[end]){
                return start;
            }
            else{
                return end;
            }
        }
        else {
            int mid = (start + end) / 2;
            if (nums[mid-1] < nums[mid] && nums[mid+1] < nums[mid]) {
                return mid;
            }
            else if (nums[mid-1] > nums[mid] && nums[mid] > nums[mid+1]){
                return findPeak(nums, start, mid-1);
            }
            else {
                return findPeak(nums, mid+1, end);
            }
        }
    }
}