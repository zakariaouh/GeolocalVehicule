package ma.vinci.geolocalvehicule.modele;

import java.io.Serializable;

public class Chauffeur  implements Serializable {
	private int id;
	private int age;
	private int sex;
	private String dateinscription;
	private String nom;
	private String prenom;
	private String image;
	private String cin;
	private int note;
	public Chauffeur(int id, int age, int sex, String dateinscription,
			String nom, String prenom, String image, String cin, int note) {
		super();
		this.id = id;
		this.age = age;
		this.sex = sex;
		this.dateinscription = dateinscription;
		this.nom = nom;
		this.prenom = prenom;
		this.image = image;
		this.cin = cin;
		this.note = note;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public int getSex() {
		return sex;
	}
	public void setSex(int sex) {
		this.sex = sex;
	}
	public String getDateinscription() {
		return dateinscription;
	}
	public void setDateinscription(String dateinscription) {
		this.dateinscription = dateinscription;
	}
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public String getPrenom() {
		return prenom;
	}
	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}
	public String getImage() {
		return image;
	}
	public void setImage(String image) {
		this.image = image;
	}
	public String getCin() {
		return cin;
	}
	public void setCin(String cin) {
		this.cin = cin;
	}
	public int getNote() {
		return note;
	}
	public void setNote(int note) {
		this.note = note;
	}
	
}
