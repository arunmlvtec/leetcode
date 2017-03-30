/**
 * Leetcode Problem Solutions
 * Problem No: 3
 * Problem Name: Longest Substring Without Repeating Characters
 * Description: Given a string, find the length of the longest substring without repeating characters.
 * Examples:
 * Given "abcabcbb", the answer is "abc", which the length is 3.
 * Given "bbbbb", the answer is "b", with the length of 1.
 * Given "pwwkew", the answer is "wke", with the length of 3. Note that the answer must be a substring, "pwke" is a subsequence and not a substring.
 * Solved By: Arun Pokharna
 * 
 * */

package leetcode.longestuniqsubstr;

import java.util.*;

public class LongestUniqueSubstring {
	
	//	Brute force approach: Time Complexity O(n^3).
	//	Implemented in lengthOfLongestSubstring(String s) and containsAllUniq(String s, int i, int j) methods.
	
	//This method returns the length of longest substring that is unique.
	// the 2 loops iterate over all subsets of the given input string to find the longest unique substring. 
    public int lengthOfLongestSubstring(String s) {
        int len = s.length();
        int maxLen = 0;
        int[] ind = new int[2];
        for (int i = 0; i < len; i++) {
            for (int j = i+1; j <= len; j++) {
                if (containsAllUniq(s, i, j)) {
                    if (maxLen < (j - i) ) {
                    	ind[0] = i;
                        ind[1] = j;
                        maxLen = Math.max(maxLen, j - i);
                    }
                }
            }
        }
        // return ind; in case substring is to be returned instead of substring length.
        return maxLen;
    }
    
    // This method returns true if the substring is all unique, and false if substring has duplicates.
    public boolean containsAllUniq(String s, int i, int j){
        Set<Character> charSet = new HashSet<Character>();
        for(int k = i; k < j; k++) {
            char ch = s.charAt(k);
            if(charSet.contains(ch)) {
                return false;
            }
            charSet.add(ch);
        }
        return true;
    }
    
    //	2nd approach: Sliding window. Time Complexity O(2n) ==> O(n).
    //	i represents left side of window, j represents right side of the window. until duplicate, j slides towards right.
    //	In case duplicate is encountered, i slides towards right (by 1) to remove one element from the window.
	public int longestUniqSubstr(String s) {
        int len = s.length();
        int maxLen = 0;
        int i = 0, j = 0;
        Set<Character> set = new HashSet<Character>();
        while (i < len && j < len) {
            // try to extend the range [i, j]
            if (!set.contains(s.charAt(j))) {
                set.add(s.charAt(j++));
                maxLen = Math.max(maxLen, j-i);
            }
            else {
                set.remove(s.charAt(i++));
            }
        }
        return maxLen;
    }
    
	// 3rd approach: Optimized sliding window. Time Complexity O(n).
	// i represents left side of window, j represents right side of the window. until duplicate, j slides towards right.
	// In case duplicate is encountered, i slides towards right (by j+1) to remove elements from the window.
	public int optimizedLongestUniqSubstr(String s) {
        int len = s.length();
        int maxLen = 0;
        Map<Character, Integer> map = new HashMap<Character, Integer>();
        for (int i = 0, j = 0; j < len; j++) {
            if (map.containsKey(s.charAt(j))) {
                i = Math.max(map.get(s.charAt(j)), i);
            }
            maxLen = Math.max(maxLen, j - i + 1);
            map.put(s.charAt(j), j+1);
        }
        return maxLen;
    }
	
    public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s1 = "abcabcbb", s2 = "bbbbb", s3 = "pwwkew", s4 = "abcdefghi";
		LongestUniqueSubstring lus = new LongestUniqueSubstring();
		int ans11 = lus.lengthOfLongestSubstring(s1),
			ans12 = lus.lengthOfLongestSubstring(s2),
			ans13 = lus.lengthOfLongestSubstring(s3),
			ans14 = lus.lengthOfLongestSubstring(s4);
		int ans21 = lus.longestUniqSubstr(s1),
			ans22 = lus.longestUniqSubstr(s2),
			ans23 = lus.longestUniqSubstr(s3),
			ans24 = lus.longestUniqSubstr(s4);
		int ans31 = lus.optimizedLongestUniqSubstr(s1),
			ans32 = lus.optimizedLongestUniqSubstr(s2),
			ans33 = lus.optimizedLongestUniqSubstr(s3),
			ans34 = lus.optimizedLongestUniqSubstr(s4);
		
		System.out.print(ans11+" ");
		System.out.print(ans12+" ");
		System.out.print(ans13+" ");
		System.out.println(ans14);
		System.out.println();
		System.out.print(ans21+" ");
		System.out.print(ans22+" ");
		System.out.print(ans23+" ");
		System.out.println(ans24);
		System.out.println();
		System.out.print(ans31+" ");
		System.out.print(ans32+" ");
		System.out.print(ans33+" ");
		System.out.println(ans34);
	}

}