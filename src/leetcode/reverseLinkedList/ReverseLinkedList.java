/**
 * Leetcode Problem Solutions
 * Problem No: 		206
 * Problem Name: 	Reverse Linked List
 * Description: 	Reverse a singly linked list.
 * Examples:		A linked list can be reversed either iteratively or recursively. Could you implement both?
 *  					
 * Solved By: Arun Pokharna
 * 
 * */

package leetcode.reverseLinkedList;

public class ReverseLinkedList {
	// Iterative Method
	public ListNode reverseListIter(ListNode head) {
		if (head == null || head.next == null) {
			return head;
		}
		ListNode newHead = null;
		while (head != null) {
			ListNode tmp = head.next;
			head.next = newHead;
			newHead = head;
			head = tmp;
		}
		return newHead;
	}

	//Recursive Method
	public ListNode reverseList(ListNode head) {
		if (head == null || head.next == null) {
			return head;
		}
		ListNode nextNode = head.next;
		ListNode newHead = reverseList(nextNode);
		nextNode.next = head;
		head.next = null;
		return newHead;
	}

	public static void main(String[] args) {
		ReverseLinkedList rl = new ReverseLinkedList();
		ListNode head = new ListNode(5);
		head.next = new ListNode(8);
		head.next.next = new ListNode(10);
		head.next.next.next = new ListNode(2);
		System.out.println("Recursive process result");
		ListNode newHead = rl.reverseList(head);
		System.out.println(newHead.val);
		System.out.println("Iterative process result");
		newHead = rl.reverseList(head);
		System.out.println(newHead.val);
	}

}
