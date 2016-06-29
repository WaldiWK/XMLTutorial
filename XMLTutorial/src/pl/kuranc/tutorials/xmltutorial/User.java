package pl.kuranc.tutorials.xmltutorial;

public class User {
	String imie = "brak danych";
	String nazwisko = "brak danych";
	String tytul = "brak danych";
	
	public String getImie() {
		return imie;
	}
	public void setImie(String imie) {
		this.imie = imie;
	}
	public String getNazwisko() {
		return nazwisko;
	}
	public void setNazwisko(String nazwisko) {
		this.nazwisko = nazwisko;
	}
	public String getTytlul() {
		return tytul;
	}
	public void setTytlul(String tytul) {
		this.tytul = tytul;
	}
	
	public String toString() {
		return "Imie: "+imie+" Nazwisko: "+nazwisko+" Tytu³: "+tytul;
	}
}
