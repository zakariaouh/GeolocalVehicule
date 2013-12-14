package ma.vinci.geolocalvehicule.modele;



public class Vehicule {
	User driver;
	private Double logitude;
	private Double latitude;
	private String adresscentrale;
	private int id;
	private String matricule;
	private int image;
	private String type;
	private String description;
	
public Vehicule(User driver, double logitude, double latitude, int id, String matricule, int image,String type,String description) {
		super();
		this.driver = driver;
		this.logitude = logitude;
		this.latitude = latitude;
		this.id = id;
		this.matricule = matricule;
		this.image = image;
		this.type=type;
		this.description=description;
	}
public String getDescription() {
	return description;
}
public void setDescription(String description) {
	this.description = description;
}
public String getType() {
	return type;
}
public void setType(String type) {
	this.type = type;
}
public User getDriver() {
		return driver;
	}
	public void setDriver(User driver) {
		this.driver = driver;
	}
	public Double getLogitude() {
		return logitude;
	}
	public void setLogitude(Double logitude) {
		this.logitude = logitude;
	}
	public Double getLatitude() {
		return latitude;
	}
	public void setLatitude(Double latitude) {
		this.latitude = latitude;
	}
	public String getAdresscentrale() {
		return adresscentrale;
	}
	public void setAdresscentrale(String adresscentrale) {
		this.adresscentrale = adresscentrale;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getMatricule() {
		return matricule;
	}
	public void setMatricule(String matricule) {
		this.matricule = matricule;
	}
	public int getImage() {
		return image;
	}
	public void setImage(int image) {
		this.image = image;
	}
	

}
