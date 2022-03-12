package phoenix;

public class ReverseLinkedList {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ListNode l1 = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4)))); 
		ListNode ll1 = new ListNode(1,null);
		ListNode ll2 = ll1; //new ListNode(1,null);
		System.out.println(ll1==ll2);
		print(l1);
		l1 = reverseList(l1);
		print(l1);
		l1 = testReverseLL(l1);
		print(l1);
	}
	
	public static void print(ListNode ll) {
		ListNode r = ll;
		while(r != null) {
			System.out.print(r.val + "-->");
			r = r.next;
		}
		System.out.println("");
	}
	
	// prev null, npht return prev
	public static ListNode testReverseLL(ListNode head) {
		ListNode prev = null;
		//ListNode curr = head;
		
		while(head != null ) {
			ListNode nxtTemp = head.next;
			head.next = prev;
			prev = head;
			head = nxtTemp;
		}	
		//return latest new head
		return prev;
	}
	
//	public static ListNode reverseList2(ListNode head){
//		ListNode prev = null;
//		ListNode curr = head;
//		while(curr != null) {
//			ListNode nextTemp = curr.next;
//			curr.next = prev;
//			prev = curr;
//			curr = nextTemp;
//		}
//		return prev;
//	}
	
	public static ListNode reverseList(ListNode head) {
		if (head == null || head.next == null) { 
			//Keep going until you hit the tail of original list
			return head;
		}
		//This is returning tail from very last call on the stack
		//Unloading stack will propagate it back to first call
		//head.next caught tail in last call
		ListNode p = reverseList(head.next); 
		head.next.next = head; //old tail.next = head
		head.next = null;      // new  
		return p; //propagate the old tail back as to-be new head
	}
	
	public static ListNode recurssiveReverseTrick(ListNode head) {
		if (head == null || head.next == null) { 
			//Keep going until you hit the tail of original list
			return head;
		}		
		ListNode p = reverseList(head.next); 
		//Perform the logic on iteration here
		//DO NOT forget to initialize below
		head.next = null;
		return p;
	}

}

