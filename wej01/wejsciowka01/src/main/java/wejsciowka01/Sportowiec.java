package wejsciowka01;

public class Sportowiec {
	public Sportowiec(String name, String nazwisko, int age, String dyscyplina) {
		super();
		this.name = name;
		this.nazwisko = nazwisko;
		this.age = age;
		this.dyscyplina = dyscyplina;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getNazwisko() {
		return nazwisko;
	}
	public void setNazwisko(String nazwisko) {
		this.nazwisko = nazwisko;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getDyscyplina() {
		return dyscyplina;
	}
	public void setDyscyplina(String dyscyplina) {
		this.dyscyplina = dyscyplina;
	}
	String name;
	String nazwisko;
	int age;
	String dyscyplina;
}
