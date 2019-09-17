package tubes;

import java.util.Scanner;

public class Mahasiswa {
	private String nrp;
	private String nama;
	NodeMahasiswa HEAD1;
	Scanner sc = new Scanner(System.in);
	public Mahasiswa(){	
	}
	
	public void addMahasiswa(Mahasiswa data) {
		NodeMahasiswa posNode=null;NodeMahasiswa curNode;
		NodeMahasiswa newNode = new NodeMahasiswa (data);
		
		if(isEmpty2()) {
			HEAD1 = new NodeMahasiswa(data);
		}else {
			curNode = HEAD1;
			while(curNode!= null) {
				posNode = curNode;
				curNode=curNode.getNext();
			}
			posNode.setNext(newNode);
		}
	}
	
	public void hapusMahasiswa(String nrp) {
		NodeMahasiswa preNode=null;
		NodeMahasiswa temp = null;
		int i ;
		boolean ketemu;
		
		if (HEAD1!=null) {
			ketemu =false;
			i = 1;
			temp = HEAD1;
			
			while(temp!=null && ketemu==false) {
				if(temp.getData().getNrp().equals(nrp)) {
					System.out.println("Data terhapus");
					ketemu = true;
				}else {
					preNode=temp;
					temp = temp.getNext();
					i++;
				}
			}
			
			if(ketemu==true) {
				if(i==1) {
					temp = HEAD1;
					HEAD1 = HEAD1.getNext();
					dispose1(temp);
				}else {
					preNode.setNext(temp.getNext());
					dispose1(temp);
				}
			}
			
			if(ketemu==false){
				System.out.println("gagal dihapus");
			}
		}
		
	}
	
	public void editMahasiswa(String ubahNrp) {
		NodeMahasiswa preNode = null, edNode;
		int i;
		boolean ketemu;
		if (HEAD1 != null) {
			ketemu = false;
			i = 1;
			edNode = HEAD1;
	
			while (edNode != null && !ketemu) {
				if (edNode.getData().getNrp().equals(ubahNrp)) {
					ketemu = true;
				} else {
					preNode = edNode;
					edNode = edNode.getNext();
					i++;
				}
			}
			
			if (ketemu == true) {
				Mahasiswa data = edNode.getData();
				System.out.print("Masukan Nama: ");
				data.setNama(sc.next());
				edNode.setData(data);
				System.out.println("Mahasiswa Berhasil diedit");
			} else {
				System.out.println("Mahasiswa gagal diedit");
			}
			
		} else {
			System.out.println("List Kosong");
		}
	}
	
	boolean isEmpty2() {
		return HEAD1==null;
	}
	
	public void displayElementMahasiswa(){
		NodeMahasiswa curNode = HEAD1;
		while(curNode!=null){
			System.out.println(curNode.getData());
			curNode=curNode.getNext();
		}
	}

	public NodeMahasiswa dispose1(NodeMahasiswa temp) {
		return temp = null;
	}
	public String getNama() {
		return nama;
	}
	public void setNama(String nama) {
		this.nama = nama;
	}
	public Mahasiswa(String nrp,String nama){
		this.nama=nama;
		this.nrp=nrp;
	}
	public String toString(){
		return String.valueOf(nrp+" "+nama+" ");
	}
	public String getNrp() {
		return nrp;
	}
	public void setNrp(String nrp) {
		this.nrp = nrp;
	}
	
	
}
