/**
 * Leetcode Problem Solutions
 * Problem No: 2
 * Description: You are given two non-empty linked lists representing two non-negative integers. The digits are stored in reverse order 
 * and each of their nodes contain a single digit. Add the two numbers and return it as a linked list.
 * You may assume the two numbers do not contain any leading zero, except the number 0 itself.
 * Input: (2 -> 4 -> 3) + (5 -> 6 -> 4)
 * Output: 7 -> 0 -> 8
 * Solved By: Arun Pokharna
 * 
 * */

package leetcode.addtwonumbers;
public class AddTwoNumbers{
	//Add two numbers of LinkedList. Iterate through the numbers, sum the elements node-wise,
	// store the remainder, and take carry forward.
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
		int carry = 0;
		ListNode l3 = new ListNode(carry);
		ListNode curL1 = l1, curL2 = l2, curL3 = l3;
		while (curL1 != null || curL2 != null) {
			int a = (curL1 != null)? curL1.val : 0;
			int b = (curL2 != null)? curL2.val : 0;
			int sum = carry + a + b;
			carry = sum / 10;
			curL3.next = new ListNode(sum % 10);
			curL3 = curL3.next;
			if (curL1 != null) curL1 = curL1.next;
			if (curL2 != null) curL2 = curL2.next;
			//System.out.println(curL3.val);
		}
		if (carry > 0)
			curL3.next = new ListNode(carry);
		//System.out.println(curL3.val);
		//System.out.println("-------------");
		return l3.next;
	}

	public static void main(String [] args){
		ListNode l1 = new ListNode(1);
		l1.next = new ListNode(2);
		l1.next.next = new ListNode(3);
		ListNode l2 = new ListNode(7);
		l2.next = new ListNode(8);
		l2.next.next = new ListNode(6);
		l2.next.next.next = new ListNode(5);
		AddTwoNumbers a = new AddTwoNumbers();
		ListNode l3 = a.addTwoNumbers(l1, l2);
		//System.out.println(l3.val);
		while (l3 != null){
			System.out.println(l3.val);
			l3 = l3.next;
		}
	}
}