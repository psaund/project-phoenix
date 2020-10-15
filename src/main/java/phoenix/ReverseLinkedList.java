package phoenix;

public class ReverseLinkedList {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ListNode l1 = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4)))); 
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
	
	
	public static ListNode testReverseLL(ListNode head) {
		ListNode prev = null;
		ListNode curr = head;
		
		while(curr != null ) {
			ListNode nxtTemp = curr.next;
			curr.next = prev;
			prev = curr;
			curr = nxtTemp;
		}	
		return prev;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	public static ListNode reverseList2(ListNode head){
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
	
  
	public static ListNode reverseList(ListNode head) {
		if (head == null || head.next == null) { 
			//Keep going until you hit the tail of original list
			return head;
		}
		//This is returning tail from last very last call on the stack
		ListNode p = reverseList(head.next); 
		head.next.next = head;  // old tail.next = head
		head.next = null;       // 
		return p;
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


class ListNode {
	int val;
	ListNode next = null;
	ListNode() {}
	ListNode(int val) { this.val = val; this.next = null;}
	ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}
