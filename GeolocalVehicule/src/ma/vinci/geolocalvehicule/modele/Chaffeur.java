package ma.vinci.geolocalvehicule.modele;

import java.util.Date;

import android.R.string;

public class Chaffeur {
int age;
string nom;
string prenom;
string password;
string login;
string image;
Double note;
Date registerdate;

public Chaffeur(string password, string login) {
	super();
	this.password = password;
	this.login = login;
}

public Chaffeur(int age, string nom, string prenom, string password,
		string login, string image, Double note, Date registerdate) {
	super();
	this.age = age;
	this.nom = nom;
	this.prenom = prenom;
	this.password = password;
	this.login = login;
	this.image = image;
	this.note = note;
	this.registerdate = registerdate;
}

public int getAge() {
	return age;
}
public void setAge(int age) {
	this.age = age;
}
public string getNom() {
	return nom;
}
public void setNom(string nom) {
	this.nom = nom;
}
public string getPrenom() {
	return prenom;
}
public void setPrenom(string prenom) {
	this.prenom = prenom;
}
public string getPassword() {
	return password;
}
public void setPassword(string password) {
	this.password = password;
}
public string getImage() {
	return image;
}
public void setImage(string image) {
	this.image = image;
}
public Double getNote() {
	return note;
}
public void setNote(Double note) {
	this.note = note;
}
public Date getRegisterdate() {
	return registerdate;
}
public void setRegisterdate(Date registerdate) {
	this.registerdate = registerdate;
}

}
