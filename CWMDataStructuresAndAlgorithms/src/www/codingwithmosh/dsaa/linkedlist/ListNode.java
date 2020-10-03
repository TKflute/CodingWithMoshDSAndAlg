package www.codingwithmosh.dsaa.linkedlist;

public class ListNode {

	private String data;
	private ListNode nextNode;
	
	public ListNode() {
		nextNode = null;
		data = null;		
	}
	
	public ListNode(String data, ListNode nextNode) {
		this.data = data;
		this.nextNode = nextNode;
	}

	public String getData() {
		return data;
	}

	public void setData(String data) {
		this.data = data;
	}

	public ListNode getNextNode() {
		return nextNode;
	}

	public void setNextNode(ListNode nextNode) {
		this.nextNode = nextNode;
	}
	
	
}