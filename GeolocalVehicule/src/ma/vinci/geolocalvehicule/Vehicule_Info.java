package ma.vinci.geolocalvehicule;


import android.os.Bundle;
import android.app.Activity;
import android.content.Context;
import android.widget.TextView;
import android.widget.Toast;

public class Vehicule_Info extends Activity {
private TextView txtview;
private Context cntxt=this;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_vehicule__info);
		Toast.makeText(cntxt, ""+Vehiculesliste.index_selected_item,Toast.LENGTH_LONG).show();
	/*	Vehicule vh=VehiculetActions.getvihiculeinfo(0);
		txtview.setText(vh.getDriver().getLogin());*/
	}

	

}
