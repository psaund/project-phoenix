package phoenix;

public class LinkedListReverseMtoN {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ListNode l1 = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4,new ListNode(5, new ListNode(6)))))); 
		ListNode ll1 = new ListNode(1,null);
		ListNode ll2 = ll1; //new ListNode(1,null);
		System.out.println(ll1==ll2);
		LLUtils.print(l1);
		//l1 = reverseList(l1);
		//print(l1);

		LinkedListReverseMtoN obj = new LinkedListReverseMtoN();
		l1 = obj.reverseBetweenIterative(l1, 1, 3);
		LLUtils.print(l1);
		
		//obj = new LinkedListReverseMtoN();
		//l1 = obj.reverseRecurrBetween(l1, 2, 4);
		//LLUtils.print(l1);


	}

	//iterative 
	//https://leetcode.com/problems/reverse-linked-list-ii/discuss/851295/Simple-Java-Iterative-Solution
	public ListNode reverseBetweenIterative(ListNode head, int m, int n) {

		if(m==1){
			return reverseNNodes(head,n-m+1);
		}

		ListNode tempHead = head;
		ListNode prev = null;
		for(int i=1;i<m;i++){
			prev = tempHead;
			tempHead =tempHead.next;
		}
		prev.next = reverseNNodes(tempHead,n-m+1); 
		return head;

	}

	ListNode reverseNNodes(ListNode head, int n){
		if(n==1||n==0)
			return head;
		ListNode newHead = null;
		ListNode prevHead = head;
		for(int i=1;i<=n;i++){
			ListNode temp = head;
			head = head.next;
			temp.next =newHead;
			newHead = temp;
		}
		prevHead.next = head;
		return newHead;
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
	
	//Recursively
	//https://leetcode.com/problems/reverse-linked-list-ii/solution/242639
	static ListNode successor = null;
	//reverse last n
	ListNode reverseN(ListNode head, int n) {
		if (n == 1) {
			successor = head.next;
			return head;
		}
		ListNode last = reverseN(head.next, n - 1);
		head.next.next = head;
		head.next = successor;
		return last;
	} 

	public ListNode reverseRecurrBetween(ListNode head, int m, int n) {
		if (m == 1) {
			return reverseN(head, n);
		}
		head.next = reverseRecurrBetween(head.next, m - 1, n - 1);
		return head;
	}   
	
}

