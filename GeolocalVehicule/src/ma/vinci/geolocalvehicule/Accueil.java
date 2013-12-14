package ma.vinci.geolocalvehicule;

import android.os.Bundle;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.widget.Button;

public class Accueil extends Activity {
Button btn;
Context cntx=this;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_accueil);
		btn=(Button)findViewById(R.id.localiserbtn);
		btn.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
			
				Intent intent=new Intent(getBaseContext(),Vehiculesliste.class);
				startActivity(intent);	
			}
		});
	}


}
