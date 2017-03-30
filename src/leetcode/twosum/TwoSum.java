/**
 * Leetcode Problem Solutions
 * Problem No: 1
 * Problem name: Two Sum
 * Description: Given an array of integers, return indices of the two numbers such that they add up to a specific target.
 *              You may assume that each input would have exactly one solution, and you may not use the same element twice.
 *              Example:	Given nums = [2, 7, 11, 15], target = 9,
 *              			Because nums[0] + nums[1] = 2 + 7 = 9,
 *              			return [0, 1].
 * Solved By: Arun Pokharna
 * 
 * */


package leetcode.twosum;

import java.util.*;

public class TwoSum {
	
	// Approach 1: Brute Force Method Time Complexity = O(n^2). Space Complexity = O(1)
	public int[] twoSum(int[] nums, int target) {
		int[] out = {-1, -1};
		for (int i = 0; i < nums.length; i++)
			for (int j = i + 1; j < nums.length; j++)
				if(target - nums[i] == nums[j]){
					out[0] = i;
					out[1] = j;
					return out;
				}
		return out;
	}
	
	// Approach 2: Using HashMap, 2 pass (1st for HashMap creation, 2nd for look up). Time Complexity = O(n). Space Complexity = O(n)
	
	public int[] twoSumHash(int[] nums, int target){
		Map<Integer, Integer> numMap = new HashMap<Integer, Integer>();
		int[] out = {-1, -1};
		for(int i = 0; i < nums.length; i++)
			numMap.put(nums[i], i);
		for(int i = 0; i < nums.length; i++){
			if ( numMap.containsKey(target - nums[i]) && numMap.get(target - nums[i]) != nums[i]){
				out[0] = i;
				out[1] = numMap.get(target - nums[i]);
				return out;
			}
		}
		
		return out;
	}
	
	// Approach 3: Using HashMap, 1 pass (Simultaneously HashMap creation and look up). Time Complexity = O(n). Space Complexity = O(n)
	
	public int[] twoSumHash1Pass(int[] nums, int target){
		Map<Integer, Integer> numMap = new HashMap<Integer, Integer>();
		int[] out = {-1, -1};
		for(int i = 0; i < nums.length; i++){
			if (numMap.containsKey(target - nums[i])){
				out[1] = i;
				out[0] = numMap.get(target - nums[i]);
				return out;
			}
			numMap.put(nums[i], i);
		}
		
		return out;
	}
	
	public static void main(String []args){
		TwoSum ts = new TwoSum();
		int[] nums = {2,2,8,6,10,11,9};
		int target = 5;
		int[] out = ts.twoSum(nums, target);
		System.out.println("1st Method........");
		for(int i : out)
			System.out.print(i+"\t");
		System.out.println("\n");
		System.out.println("2nd Method........");
		out = ts.twoSumHash(nums, target);
		for(int i : out)
			System.out.print(i+"\t");
		System.out.println("\n");
		System.out.println("3rd Method........");
		out = ts.twoSumHash1Pass(nums, target);
		for(int i : out)
			System.out.print(i+"\t");
	}
}
