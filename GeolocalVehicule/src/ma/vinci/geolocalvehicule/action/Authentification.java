package ma.vinci.geolocalvehicule.action;

import ma.vinci.geolocalvehicule.modele.User;

public class Authentification {
public static boolean seconnecter(User u){
	boolean isuser=false;
	//connection avec web service;
	//depuis web service
	//dans le web sercise se test va etre effectuer
	if("zakaria".equalsIgnoreCase(u.getLogin()) &&"passwo".equalsIgnoreCase(u.getPassword())){
		isuser=true;}
	return isuser;
}
}
