package ma.vinci.geolocalvehicule.modele;

import java.io.Serializable;

public class Vehicule implements Serializable {
	private Chauffeur driver;
	private int id_vehicule;
	private String matricule_vehicule;
	private int status_vehicule;
	private double latitude_vehicule;
	private double longitude_vehicule;
	private String description_vehicule;
	private int type_vehicule;
	
	public Vehicule(Chauffeur driver, int id_vehicule,
			String matricule_vehicule, int status_vehicule,
			double latitude_vehicule, double longitude_vehicule,
			String description_vehicule, int type_vehicule) {
		super();
		this.driver = driver;
		this.id_vehicule = id_vehicule;
		this.matricule_vehicule = matricule_vehicule;
		this.status_vehicule = status_vehicule;
		this.latitude_vehicule = latitude_vehicule;
		this.longitude_vehicule = longitude_vehicule;
		this.description_vehicule = description_vehicule;
		this.type_vehicule = type_vehicule;
	}
	public Chauffeur getDriver() {
		return driver;
	}
	public void setDriver(Chauffeur driver) {
		this.driver = driver;
	}
	public int getId_vehicule() {
		return id_vehicule;
	}
	public void setId_vehicule(int id_vehicule) {
		this.id_vehicule = id_vehicule;
	}
	public String getMatricule_vehicule() {
		return matricule_vehicule;
	}
	public void setMatricule_vehicule(String matricule_vehicule) {
		this.matricule_vehicule = matricule_vehicule;
	}
	public int getStatus_vehicule() {
		return status_vehicule;
	}
	public void setStatus_vehicule(int status_vehicule) {
		this.status_vehicule = status_vehicule;
	}
	public double getLatitude_vehicule() {
		return latitude_vehicule;
	}
	public void setLatitude_vehicule(double latitude_vehicule) {
		this.latitude_vehicule = latitude_vehicule;
	}
	public double getLongitude_vehicule() {
		return longitude_vehicule;
	}
	public void setLongitude_vehicule(double longitude_vehicule) {
		this.longitude_vehicule = longitude_vehicule;
	}
	public String getDescription_vehicule() {
		return description_vehicule;
	}
	public void setDescription_vehicule(String description_vehicule) {
		this.description_vehicule = description_vehicule;
	}
	public int getType_vehicule() {
		return type_vehicule;
	}
	public void setType_vehicule(int type_vehicule) {
		this.type_vehicule = type_vehicule;
	}
	
}
