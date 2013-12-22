package ma.vinci.geolocalvehicule;

import java.util.ArrayList;

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
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_afficher_map);
		
		googleMap = ((MapFragment) getFragmentManager().findFragmentById( R.id.map)).getMap();
		if (googleMap == null) { 
			Toast.makeText(getApplicationContext(), "Sorry! unable to create maps", Toast.LENGTH_SHORT) .show();
			}
		
		 LatLng elm1 = new LatLng(34.034453, -6.767578);
		 LatLng elm2 = new LatLng(33.953043, -6.881561);
		 LatLng elm3 = new LatLng(33.851029, -7.028503);
		 LatLng elm4 = new LatLng(33.824223, -6.926193);
		 LatLng elm5 = new LatLng(34.268566, -6.589050);
		 LatLng elm6 = new LatLng(33.605470, -7.619019);
			
		 LOCATIONS.add(elm1);
		 LOCATIONS.add(elm2);
		 LOCATIONS.add(elm4);
		 LOCATIONS.add(elm3);
		 LOCATIONS.add(elm5);
		 LOCATIONS.add(elm6);
			 
		
		for (int h = 0; h < LOCATIONS.size(); h++) {
			LatLng element  = LOCATIONS.get(h);
			googleMap.addMarker(new MarkerOptions().position(element).title("Vehicule"+h));
			
		}

		
		
		
		
		 LatLng LOCATION_SURRREY = new LatLng(34.020226, -6.841049);
		 
		 
		 googleMap.addMarker(new MarkerOptions().position(LOCATION_SURRREY).title("Static")); 
		 
		 googleMap.setMapType(GoogleMap.MAP_TYPE_SATELLITE);
			CameraUpdate update = CameraUpdateFactory.newLatLngZoom(LOCATION_SURRREY, 16);
			googleMap.animateCamera(update);
	}

	

}
