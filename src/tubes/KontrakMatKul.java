package tubes;

public class KontrakMatKul {
	private String nrp;
	private int sems;
	private int tahunAjaran;
	private Kuliah kode;

	public KontrakMatKul(String nrp,int sems, int tahunAjaran,Kuliah kuliah){
		this.nrp=nrp;
		this.sems= sems;
		this.tahunAjaran= tahunAjaran;
		this.kode=kuliah;
	}
	public String toString(){
		return String.valueOf(kode);
	}
	public String getNrp() {
		return nrp;
	}
	public void setNrp(String nrp) {
		this.nrp = nrp;
	}
	public Kuliah getKode() {
		return kode;
	}
	public void setKode(Kuliah kode) {
		this.kode = kode;
	}
	
	
}
