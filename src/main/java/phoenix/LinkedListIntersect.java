package phoenix;

public class LinkedListIntersect {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

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

}
