package tubes;

import java.util.Scanner;

public class KontrakMatkulMhs {
	Node HEAD; NodeMahasiswa HEAD1;
	Scanner sc = new Scanner(System.in);
	Mahasiswa mhs = new Mahasiswa();
	Kuliah k = new Kuliah();
	
	public void addMatkul(KontrakMatKul data) {
		Node posNode=null, curNode;
		Node newNode = new Node (data);
		if(isEmpty()) {
			HEAD = new Node(data);
		}else {
			curNode = HEAD;
			while(curNode!= null) {
				posNode = curNode;
				curNode=curNode.getNext();
			}
			posNode.setNext(newNode);
		}
		System.out.println("Matkul diKontrak");
	}
	
	public void dropMatkul(String nrp,int pos) {
		Node preNode=null;
		Node temp = null;
		int i ;
		boolean ketemu;
		if (HEAD!=null) {
			ketemu =false;
			i = 1;
			temp = HEAD;
			while(temp!=null && ketemu==false) {
				if(i==pos) {
					ketemu = true;
				}else {
					preNode=temp;
					temp = temp.getNext();
					i++;
				}
				
			}
			if(ketemu==true) {
				System.out.println("Data terhapus");
				if(i==1) {
					temp = HEAD;
					HEAD = HEAD.getNext();
					dispose(temp);
				}else {
					preNode.setNext(temp.getNext());
					dispose(temp);
				}
			}else{
				System.out.println("gagal");
			}
		}
	}
	public Node dispose(Node temp) {
		return temp = null;
	}
	
	boolean isEmpty() {
		return HEAD==null;
	}
	
	
	public void displayElementKontrak(String string){
		Node curNode = HEAD;
		boolean ada = false;
		int no=1;
		while(curNode!= null){
			if(curNode.getData().getNrp().equals(string)){
				System.out.println(no+". "+curNode.getData());
				no++;
				curNode= curNode.getNext();
				ada = true;
			}else{
				curNode= curNode.getNext();
			}
		}
		if(ada==false){
			System.out.println("Mahasiswa Belum mengontrak MataKuliah");
		}
	}
	
	
	public void menuMahasiswa(){
		System.out.println("===================Menu Mahasiswa=================");
		boolean ulang = true;
		while(ulang == true){
			System.out.println("1. Tambah Mahasiswa\n"
							+ "2. Hapus Mahasiswa\n"
							+ "3. Edit Mahasiswa\n"
							+ "4. Menu Utama");
			
			System.out.print("pilih Submenu : ");
			int x = sc.nextInt();
			switch (x) {
				case 1:
					System.out.print("Masukan NRP : ");
					String nrp=sc.next();
					System.out.print("Masukan nama : ");
					String nama=sc.next();
					mhs.addMahasiswa(new Mahasiswa(nrp,nama));
					break;
				case 2:
					System.out.print("masukan nrp mahasiswa yang akan dihapus : ");
					String nrp3=sc.next();
//					if(!mhs.isEmpty2()){
						mhs.hapusMahasiswa(nrp3);
//					} else {
//						System.out.println("data kosong");
//					}
					break;
				case 3:
					System.out.print("Masukan nrp : ");
					String nrp5=sc.next();
					mhs.editMahasiswa(nrp5);
					break;
				case 4:
					ulang= false;
					break;
			default:
				System.out.println("Submenu belum ada");
				break;
			}
		}
	}
	public void menuKontrak(){
		System.out.println("===================Menu Kontrak Matkul=================");
		int no=1;
		boolean ulang =true;
		while(ulang==true){
			System.out.println("1. AddMatkul\n"
							+ "2. dropMatkul\n"
							+ "3. Menu Utama");
			
			System.out.print("pilih Submenu : ");
			int x = sc.nextInt();
			
			switch (x) {
				case 1:
					System.out.print("Masukan nrp : ");
					String nrp1=sc.next();
					NodeMahasiswa vi= mhs.HEAD1;
					boolean km= false;
					boolean adaNrp=false;
					
					if(!mhs.isEmpty2()){
						while(km==false&&vi!=null){
							if(vi.getData().getNrp().equals(nrp1)){
								System.out.print("Masukan semester : ");
								int sems=sc.nextInt();
								System.out.print("Masukan Tahun Ajaran : ");
								int tahun = sc.nextInt();
								
								System.out.println("========= Daftar MatKul =========");
								for (int i = 0; i < k.matkul.length; i++) {
									if(k.matkul[i]!=null){System.out.println(no+". "+k.matkul[i]);}
									no++;
								}
								no=1;
								
								System.out.print("pilih matkul : ");
								int pilihMatkul =sc.nextInt();
								addMatkul(new KontrakMatKul(nrp1,sems,tahun,k.matkul[pilihMatkul-1]));
								km=true;
								adaNrp=true;
							}else{
								vi=vi.getNext();
							}
						}
						
						if(adaNrp==false){
							km=true;
							System.out.println("maaf anda belum terdaftar sebagai mahasiswa");
						}
						
					} else{
						System.out.println("Data belum Ada");
					}
					break;
				case 2:
					NodeMahasiswa vii=mhs.HEAD1;
					boolean kmm= false;
					if(!mhs.isEmpty2()){
						System.out.print("Masukan nrp : ");
						String nrp4=sc.next();
						
						while(kmm==false&&vii!=null){
							if(vii.getData().getNrp().equals(nrp4)){
								displayElementKontrak(nrp4);
								System.out.print("pilih matkul yang akan didrop: ");
								int kode=sc.nextInt();
								
								dropMatkul(nrp4,kode);
								kmm=true;
								
							} else {
								vii= vii.getNext();
							}
						}
					}else{
						System.out.println("Data tidak Ada");
					}
					break;
				case 3:
					ulang=false;
					break;
				default:
					System.out.println("Submenu belum ada");
					break;
			}
		}
	}
	public void menuMatkul(){
		boolean ulang=true;
		while(ulang==true){
			System.out.println("===================Menu MatKul=================");
			System.out.println("1. Tambah Daftar Matkul\n"
							+ "2. Hapus Daftar Matkul\n"
							+ "3. Edit Daftar Matkul\n"
							+ "4. Tampil Daftar matkul\n"
							+ "5. Menu Utama");
			
			System.out.print("pilih menu : ");
			int x= sc.nextInt();
			
			switch (x) {
				case 1:
					k.tambah();
					break;
				case 2:
					k.displayElement();
					k.hapus();
					break;
				case 3:
					k.edit();
					break;
				case 4:
					k.displayElement();
					break;
				case 5:
					ulang=false;
					break;
				default:
					System.out.println("menu belum ada");
					break;
			}
		}
	}
	
	public void menu(){
		k.isi();
		boolean ulang= true;
		while(ulang==true){
			System.out.println("=====================MENU=====================");
			System.out.println("1. Mahasiswa\n"
							+ "2. Mata Kuliah\n"
							+ "3. Kontrak Mata Kuliah\n"
							+ "4. Tampil Daftar Mahasiswa\n"
							+ "5. Tampil Daftar Matkul yag dikontrak sesuai mahasiswa\n"
							+ "6. Keluar");
			System.out.print("pilih menu : ");
			int x =sc.nextInt();
			
			switch (x) {
				case 1:
					menuMahasiswa();
					break;
				case 2:
					menuMatkul();
					break;
				case 3:
					menuKontrak();
					break;
				case 4:
					System.out.println("==============Daftar Mahasiswa==============");
					if(mhs.isEmpty2()){
						System.out.println("Data Kosong");
					}else{
						mhs.displayElementMahasiswa();
					}
					break;
				case 5:
					System.out.print("masukan nrp mahasiswa : ");
					String nrp2=sc.next();
					System.out.println("==============Daftar Matkul Dikontrak==============");
					displayElementKontrak(nrp2);
					break;
				case 6:
					ulang = false;
					System.out.print("terima kasih sudah menggunakan layanan kami ");
					break;
				default:
					break;
			}
			
		}
	
	}
}

