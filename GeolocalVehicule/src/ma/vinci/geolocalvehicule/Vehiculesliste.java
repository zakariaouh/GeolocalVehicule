package ma.vinci.geolocalvehicule;

import java.util.ArrayList;
///import java.util.List;

import ma.vinci.geolocalvehicule.R;
import ma.vinci.geolocalvehicule.action.VehiculeAdapter;
import ma.vinci.geolocalvehicule.action.VehiculetActions;
import ma.vinci.geolocalvehicule.modele.Vehicule;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import android.app.Activity;
import android.content.Context;


public class Vehiculesliste extends Activity {

	private ListView list_adapter;
	private Context cntext = this;
	private Button btn_menu;
	//private List<Integer> arrayidvehicule = new ArrayList<Integer>();

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_vehiculesliste);
		
		 
		btn_menu = (Button)findViewById(R.id.btn_menu);
        
        list_adapter = (ListView)findViewById(R.id.listeviewvehicule);
        
        //remplire liste view
    	ArrayList<Vehicule> data = VehiculetActions.getvihicules();	
	       
        VehiculeAdapter adapter = new VehiculeAdapter(cntext,data);
        list_adapter.setAdapter(adapter);
		
        //action bouton menu
        btn_menu.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				
			
				
			}
		});    
        
	}



}
