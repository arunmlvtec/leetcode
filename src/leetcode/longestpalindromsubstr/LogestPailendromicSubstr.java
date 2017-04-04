/**
 * Leetcode Problem Solutions
 * Problem No: 5
 * Problem Name: Longest Palindromic Substring
 * Description: Given a string s, find the longest palindromic substring in s. 
 * 				You may assume that the maximum length of s is 1000.
 * Example:
 * 			Input: "babad"
 * 			Output: "bab"
 *			Note: "aba" is also a valid answer.
 *
 * Example:
 * 			Input: "cbbd"
 * 			Output: "bb"
 * 
 * Solved By: Arun Pokharna
 * 
 * */

package leetcode.longestpalindromsubstr;
public class LogestPailendromicSubstr {
	/* 1st Method: Brute force method.
	
	// longestPalindrome(String s) and isPailendrome(String s, int i, int j) are used to build Brute force logic.
	// Generate all pairs of substrings and check for palindrome. 
	// Longest palindrome indices are stored to return the answer.*/
	
	// generates all pairs of substrings from S and pass it check for palindrome.
	// Returns substring with longest palindrome.
	public String longestPalindrome(String s) {
        int start = 0, end = 0, maxLen = 0;
        for (int i = 0; i < s.length(); i++) {
            for (int j = i+1; j < s.length(); j++) {
                if (isPailendrome(s, i, j)){
                    if (maxLen < (j - i)) {
                        maxLen = j - i;
                        start = i;
                        end = j;
                    }
                }
            }
        }
        return s.substring(start, end + 1);
    }
    
	// return true if the substring is palindrome and false if the substring is not palindrome.
    public boolean isPailendrome(String s, int i, int j) {
        while (i <= j) {
            if (s.charAt(i) != s.charAt(j))
                return false;
            else{
                i += 1;
                j -= 1;
            }
        }
        return true;
    }
	
    
    // 1st approach: Expand Around Center.
    // longestPalindrome2(String s) and checkPalindrome(String s, int i, int j) are used to build this approach.
    // start and maxLen stores start index and length of the longest palindrome substring.
	int start, maxLen;
    public String longestPalindrome2(String s) {
        int len = s.length();
        if (len < 2){
            return s;
        }
        
        for (int i = 0; i < len - 1; i++){
        	if (len % 2 != 0)
        		checkPalindrome(s, i, i); // in-case input string length is odd.
        	else
        		checkPalindrome(s, i, i+1); // in-case input string length is even.
        }
        return s.substring(start, (start + maxLen));
    }
    
    // Checking palindrome and storing indices of the palindrome.
    public void checkPalindrome(String s, int i, int j) {
        int len = s.length();
        while ((i >= 0) && (j < len) && (s.charAt(i) == s.charAt(j))) {
            i -= 1;
            j += 1;
        }
        if (maxLen < j - i - 1) {
            start = i + 1;
            maxLen = j - i - 1;
        }
    }
    
    public static void main(String[] args) {
		LogestPailendromicSubstr lps = new LogestPailendromicSubstr();
		System.out.println(lps.longestPalindrome("baab"));
		System.out.println(lps.longestPalindrome2("babab"));
	}
}