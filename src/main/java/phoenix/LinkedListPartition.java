package phoenix;

public class LinkedListPartition {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//[1,4,3,2,5,2]
		ListNode l1 = getLinkedList(1,4,3,2,5,2);//new ListNode(1, new ListNode(4, new ListNode(3, new ListNode()))); 
		print(l1);
		l1 = partition(l1, 3);
		print(l1);
	}

	public static ListNode getLinkedList(int ...args){
		ListNode head =  new ListNode(0);
		ListNode l1 = head;
		for(int i : args){
			l1.next = new ListNode(i);
			l1 = l1.next;
		}
		return head;
	}
	
	public static ListNode partition(ListNode head, int x) {
		//preserve the pointer for later referencing
		ListNode before_head = new ListNode(0); 
		ListNode before = before_head;
		//preserve the pointer for connecting parts later
		ListNode after_head = new ListNode(0);
		ListNode after = after_head;
		
		while(head != null){
			
			if(head.val < x){
				before.next = head;
				before = before.next;
			}else {
				after.next = head;
				after = after.next;
			}
			
			head = head.next;
		}
		//This is required to break cyclic 
		//otherwise after.next will hold head
		after.next = null;
		//Connect partitions
		before.next = after_head.next;
		return before_head.next;
	}

	public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
		if(headA==null || headB==null) 
			return null;

		int lenA = 1;
		ListNode a = headA;
		for(;a.next!=null;a=a.next) lenA++;

		int lenB = 1;
		ListNode b = headB;
		for(;b.next!=null;b=b.next) lenB++; // calculate length of A and B

		if (a!=b) return null;  // no intersection

		int pad = Math.abs(lenA-lenB); // length we have to pad
		a = lenA>lenB?headA:headB;  // a is longer list
		b = a==headA?headB:headA;  // b is shorter list 

		for(;pad!=0;pad--) a=a.next; // now a b are in the 
		for(;a!=b;a=a.next) b=b.next; // same distance with intersection
		return a;
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
