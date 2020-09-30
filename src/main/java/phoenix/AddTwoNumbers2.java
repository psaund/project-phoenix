package phoenix;

public class AddTwoNumbers2 {

	
	public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
	    ListNode dummyHead = new ListNode(0);
	    ListNode p = l1, q = l2, curr = dummyHead;
	    int carry = 0;
	    while (p != null || q != null) {
	        int x = (p != null) ? p.val : 0;
	        int y = (q != null) ? q.val : 0;
	        int sum = carry + x + y;
	        carry = sum / 10;
	        curr.next = new ListNode(sum % 10);
	        curr = curr.next;
	        if (p != null) p = p.next;
	        if (q != null) q = q.next;
	    }
	    if (carry > 0) {
	        curr.next = new ListNode(carry);
	    }
	    return dummyHead.next;
	}
	
	public static void main(String[] args) {
		//represents number 342
		ListNode l1 = new ListNode(7, new ListNode(4, new ListNode(6))); 
		ListNode l2 = new ListNode(4, new ListNode(6, new ListNode(5)));
		print(l1);
		print(l2);
		ListNode result = addTwoNumbers(l1, l2);
		print(result);
		//addTwoNumbers();
	}
	
	public static void print(ListNode ll) {
		ListNode r = ll;
		while(r != null) {
			System.out.print(r.val + "-->");
			r = r.next;
		}
		System.out.println("");
	}
	
}
class ListNode {
	int val;
	ListNode next;
	ListNode() {}
	ListNode(int val) { this.val = val; }
	ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}
