package ma.vinci.geolocalvehicule;

public class Authentification {
public static boolean seconnecter(User u){
	boolean isuser=false;
	//connection avec web service;
	isuser=true;//depuis web service
	//dans le web sercise se test va etre effectuer
	if(u.getLogin()=="zakaria" &&u.getPassword()=="passwo"){
		isuser=true;}
	return isuser;
}
}
