package tubes;

import java.util.Scanner;

public class Kuliah {
	private String kodeMK;
	private String namaMK;
	private int sks;
	public Kuliah[] matkul;
	Scanner sc = new Scanner(System.in);
	
	public Kuliah(){
	}
	
	public void isi(){
		matkul = new Kuliah[15];
		matkul[0]= new Kuliah("MK01 ","Struktur Diskrit ",3);
		matkul[1]= new Kuliah("MK02 ","Algoritma Pemograman ",3);
		matkul[2]= new Kuliah("MK03 ","Dasar Pemograman ",4);
		matkul[3]= new Kuliah("MK04 ","Manajemen Sistem Informasi ",3);
		matkul[4]= new Kuliah("MK05 ","Ilmu Budaya Sunda ",2);
		matkul[5]= new Kuliah("MK06 ","Pembangunan Aplikasi Multimedia ",3);
		matkul[6]= new Kuliah("MK07 ","Pemograman Web ",4);
	}
	
	public Kuliah(String kodeMK,String namaMK,int sks){
		this.kodeMK=kodeMK;
		this.namaMK=namaMK;
		this.sks=sks;
	}
	
	public void tambah(){
		for (int i = 0; i < matkul.length; i++) {
			if(matkul[i]==null){
				System.out.print("Kode : ");
				String kode=sc.next();
				
				System.out.print("NamaMk : ");
				String nama=sc.next();
				
				System.out.print("Sks : ");
				int sks=sc.nextInt();
				
				matkul[i]=new Kuliah(kode+" ",nama+" ",sks);
				break;
			}
		}
	}
	
	public void edit(){
		System.out.println("Pilih Matkul Yang akan yang akan diubah : ");
		int x = sc.nextInt();
		
		for (int i = 0; i < matkul.length; i++) {
			if((x-1)==i){
				System.out.print("Kode : ");
				String kode=sc.next();
				
				System.out.print("NamaMk : ");
				String nama=sc.next();
				
				System.out.print("Sks : ");
				int sks=sc.nextInt();
				
				matkul[i]= new Kuliah(kode+" ",nama+" ",sks);
				break;
			}
		}
	}
	
	public void hapus(){
		System.out.println("Pilih Matkul Yang akan dihapus : ");
		int x = sc.nextInt();
		
		for (int i = 0; i < matkul.length; i++) {
			if((x-1)==i){
				for (int j = i; j < matkul.length; j++) {
					if (j == matkul.length-1) {
						matkul[j] = null;
					} else {
						matkul[j] = matkul[j+1];
					}		
				}
				break;
			}
		}
	}
	
	public void displayElement(){
		int no=1;
		for (int i = 0; i < matkul.length; i++) {
			if(matkul[i]!=null){
				System.out.println(no+". "+matkul[i]);
				no++;
			}
		}
	}
	
	public String toString(){
		return String.valueOf(kodeMK+namaMK+sks);
	}
	
	public String getKodeMK() {
		return kodeMK;
	}
	public void setKodeMK(String kodeMK) {
		this.kodeMK = kodeMK;
	}
	public String getNamaMK() {
		return namaMK;
	}
	public void setNamaMK(String namaMK) {
		this.namaMK = namaMK;
	}
	public int getSks() {
		return sks;
	}
	public void setSks(int sks) {
		this.sks = sks;
	}
	public Kuliah[] getMatkul() {
		return matkul;
	}
	public void setMatkul(Kuliah[] matkul) {
		this.matkul = matkul;
	}
	
}
