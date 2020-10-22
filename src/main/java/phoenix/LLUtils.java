package phoenix;

public class LLUtils {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public static ListNode reverseIterative(ListNode head){
		ListNode prev = null;
		ListNode curr = head;
		while(curr != null) {
			ListNode nextTemp = curr.next;
			curr.next = prev;
			prev = curr;
			curr = nextTemp;
		}
		return prev;
	}

	public static ListNode reverseRecur(ListNode head) {
		if (head == null || head.next == null) { 
			//Keep going until you hit the tail of original list
			return head;
		}
		//This is returning tail from very last call on the stack
		//Unloading stack will propagate it back to first call
		//head.next caught tail in last call
		ListNode p = reverseRecur(head.next); 
		head.next.next = head; //old tail.next = head
		head.next = null;      // new  
		return p; //propagate the old tail back as to-be new head
	}

	public static ListNode recurssiveReverseTrick(ListNode head) {
		if (head == null || head.next == null) { 
			//Keep going until you hit the tail of original list
			return head;
		}		
		ListNode p = recurssiveReverseTrick(head.next); 
		//Perform the logic on iteration here
		//DO NOT forget to initialize below
		head.next = null;
		return p;
	}
	
	public static void print(ListNode ll) {
		ListNode r = ll;
		while(r != null) {
			System.out.print(r.val + "->");
			r = r.next;
		}
		System.out.println("");
	}

}
