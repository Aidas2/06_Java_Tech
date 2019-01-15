package it.akademija.vaisiai;

public class Vaisius {
	private String paveiksliukas;
    private String pavadinimas;
    private String aprasymas;
    private String nuoroda;
    
    public Vaisius() { }
    
    public Vaisius(String paveiksliukas, String pavadinimas, String aprasymas, String nuoroda) {
    	this.paveiksliukas = paveiksliukas;
    	this.pavadinimas = pavadinimas;
    	this.aprasymas = aprasymas;
    	this.nuoroda = nuoroda;
	}
    
    public String getPaveiksliukas() {
		return paveiksliukas;
	}
	public void setPaveiksliukas(String paveiksliukas) {
		this.paveiksliukas = paveiksliukas;
	}
	public String getPavadinimas() {
		return pavadinimas;
	}
	public void setPavadinimas(String pavadinimas) {
		this.pavadinimas = pavadinimas;
	}
	public String getAprasymas() {
		return aprasymas;
	}
	public void setAprasymas(String aprasymas) {
		this.aprasymas = aprasymas;
	}
	public String getNuoroda() {
		return nuoroda;
	}
	public void setNuoroda(String nuoroda) {
		this.nuoroda = nuoroda;
	}
}
