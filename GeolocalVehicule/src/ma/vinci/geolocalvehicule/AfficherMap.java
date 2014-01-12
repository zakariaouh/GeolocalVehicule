package ma.vinci.geolocalvehicule;

import java.util.ArrayList;

import ma.vinci.geolocalvehicule.modele.Vehicule;

import android.app.Activity;
import android.os.Bundle;
import android.widget.Toast;

import com.google.android.gms.maps.CameraUpdate;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

public class AfficherMap extends Activity {
	private GoogleMap googleMap;
	private final ArrayList<LatLng> LOCATIONS = new ArrayList<LatLng>(); 
	ArrayList<Vehicule> data=new ArrayList<Vehicule>();
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_afficher_map);
		
		googleMap = ((MapFragment) getFragmentManager().findFragmentById( R.id.map)).getMap();
		if (googleMap == null) { 
			Toast.makeText(getApplicationContext(), "Sorry! unable to create maps", Toast.LENGTH_SHORT) .show();
			}else {
				
				
				data=(ArrayList<Vehicule>) getIntent().getSerializableExtra("data");
				LatLng firstelm=new LatLng(34.034453, -6.767578);
		for (int i = 0; i < data.size(); i++) {
			Vehicule vh=data.get(i);
			 LatLng elm = new LatLng(vh.getLatitude_vehicule(), vh.getLongitude_vehicule());
			 googleMap.addMarker(new MarkerOptions().position(elm).title(vh.getDriver().getPrenom()+" "+vh.getDriver().getNom())); 
			 if(i==0){
				firstelm=elm; 
			 }
		}
		
		
		 
		 googleMap.setMapType(GoogleMap.MAP_TYPE_SATELLITE);
			CameraUpdate update = CameraUpdateFactory.newLatLngZoom(firstelm, 16);
			googleMap.animateCamera(update);
	}}

	

}
