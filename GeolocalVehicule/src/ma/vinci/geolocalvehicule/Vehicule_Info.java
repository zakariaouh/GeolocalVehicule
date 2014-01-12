package ma.vinci.geolocalvehicule;



import ma.vinci.geolocalvehicule.modele.Vehicule;
import android.os.Bundle;
import android.app.Activity;
import android.content.Context;
import android.widget.TextView;
public class Vehicule_Info extends Activity {
private TextView driver,descriptionv,typev;
private Context cntxt=this;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_vehicule__info);
		
		driver=(TextView)findViewById(R.id.driver);
		descriptionv=(TextView)findViewById(R.id.description);
		typev=(TextView)findViewById(R.id.typev);
		
		
		Vehicule vh=(Vehicule) getIntent().getSerializableExtra("VehiculeSelected");
		
		driver.setText(vh.getDriver().getPrenom()+ " " +vh.getDriver().getNom());
	
		String typevh="";
		switch (vh.getType_vehicule()) {
		case 0:
			typevh=" Camion de Gazoil Renault";
			break;
	case 1:
			
		typevh=" Voiture de sercice Renault";
	case 2:
		typevh=" Trasport Car";
		break;
		default:
			break;
		}
		
		typev.setText(typevh);
		descriptionv.setText(vh.getDescription_vehicule());/**/
	}

	

}
