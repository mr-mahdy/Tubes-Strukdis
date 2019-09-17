package tubes;



public class Node {
	private KontrakMatKul data;
	private Node next;
	
	public Node(KontrakMatKul data){
		this.data=data;
	}
	public KontrakMatKul getData() {
		return data;
	}
	public void setData(KontrakMatKul data) {
		this.data = data;
	}
	public Node getNext() {
		return next;
	}
	public void setNext(Node next) {
		this.next = next;
	}
	
	

}
