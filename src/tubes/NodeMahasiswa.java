package tubes;



public class NodeMahasiswa {
	private Mahasiswa data;
	private NodeMahasiswa next;
	
	public NodeMahasiswa(Mahasiswa data){
		this.data=data;
	}

	public Mahasiswa getData() {
		return data;
	}

	public void setData(Mahasiswa data) {
		this.data = data;
	}

	public NodeMahasiswa getNext() {
		return next;
	}

	public void setNext(NodeMahasiswa next) {
		this.next = next;
	}
		

}
