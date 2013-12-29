package ma.vinci.geolocalvehicule;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import ma.vinci.geolocalvehicule.MainActivity.JsonReadTask;
import ma.vinci.geolocalvehicule.action.VehiculeAdapter;
import ma.vinci.geolocalvehicule.action.VehiculetActions;
import ma.vinci.geolocalvehicule.modele.Chauffeur;
import ma.vinci.geolocalvehicule.modele.User;
import ma.vinci.geolocalvehicule.modele.Vehicule;
import ma.vinci.geolocalvehicule.viewanimation.CollapseAnimation;
import ma.vinci.geolocalvehicule.viewanimation.ExpandAnimation;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.animation.Animation;
import android.view.animation.TranslateAnimation;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

///import java.util.List;
public class Vehiculesliste extends Activity {

	
// Declaration zwa9 :p
		private LinearLayout slidingPanel;
		private boolean isExpanded;
		private DisplayMetrics metrics;
		private RelativeLayout headerPanel;
		private RelativeLayout menuPanel;
		private int panelWidth;
		private ImageView menuViewButton;
		Button menu1;
		Button menu2;
		TextView txtpays;
		FrameLayout.LayoutParams menuPanelParameters;
		FrameLayout.LayoutParams slidingPanelParameters;
		LinearLayout.LayoutParams headerPanelParameters;
		LinearLayout.LayoutParams listViewParameters;
//fin zwa9
		
	private ListView list_adapter;
	private Context cntxt = this;
	private Button aff_map, real_aug, apropos;
	public static Vehicule vh;
	
	
	boolean connectionfile = false; //si on arrive pas à accéder au lien
	String URL = "http://192.168.56.1/web_servicev2/public/index/?op=2";
	ArrayList<Vehicule> data=new ArrayList<Vehicule>();//la liste des véhicule Geolocalisé
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_vehiculesliste);

		list_adapter = (ListView) findViewById(R.id.listeviewvehicule);

		/*
		 * // remplire liste view final
		 *  ArrayList<Vehicule> data =null;
		 * 
		 * VehiculeAdapter adapter = new VehiculeAdapter(cntxt, data);
		 * list_adapter.setAdapter(adapter);/*
		 */

		
//zwa9 + action bouton menu----------------------------------------------------------------		
		// action bouton menu

		// Initialize
		metrics = new DisplayMetrics();
		getWindowManager().getDefaultDisplay().getMetrics(metrics);
		panelWidth = (int) ((metrics.widthPixels) * 0.75);

		headerPanel = (RelativeLayout) findViewById(R.id.header);
		headerPanelParameters = (LinearLayout.LayoutParams) headerPanel
				.getLayoutParams();
		headerPanelParameters.width = metrics.widthPixels;
		headerPanel.setLayoutParams(headerPanelParameters);

		menuPanel = (RelativeLayout) findViewById(R.id.menuPanel);
		menuPanelParameters = (FrameLayout.LayoutParams) menuPanel
				.getLayoutParams();
		menuPanelParameters.width = panelWidth;
		menuPanel.setLayoutParams(menuPanelParameters);

		slidingPanel = (LinearLayout) findViewById(R.id.slidingPanel);
		slidingPanelParameters = (FrameLayout.LayoutParams) slidingPanel
				.getLayoutParams();
		slidingPanelParameters.width = metrics.widthPixels;
		slidingPanel.setLayoutParams(slidingPanelParameters);

		listViewParameters = (LinearLayout.LayoutParams) list_adapter
				.getLayoutParams();
		listViewParameters.width = metrics.widthPixels;
		list_adapter.setLayoutParams(listViewParameters);

		// //
		menuViewButton = (ImageView) findViewById(R.id.menuViewButton);

		menuViewButton.setOnClickListener(new OnClickListener() {
			public void onClick(View v) {
				if (!isExpanded) {
					isExpanded = true;

					// Expand
					new ExpandAnimation(slidingPanel, panelWidth,
							Animation.RELATIVE_TO_SELF, 0.0f,
							Animation.RELATIVE_TO_SELF, 0.75f, 0, 0.0f, 0, 0.0f);
				} else {
					isExpanded = false;

					// Collapse
					new CollapseAnimation(slidingPanel, panelWidth,
							TranslateAnimation.RELATIVE_TO_SELF, 0.75f,
							TranslateAnimation.RELATIVE_TO_SELF, 0.0f, 0, 0.0f,
							0, 0.0f);

				}
			}
		});
	//--------------fin zwa9 Sliding menu 	
		
		
//bouton apres le click sur le sliding menu	--------------------------------	
		real_aug = (Button) findViewById(R.id.Real_Aug);
		apropos = (Button) findViewById(R.id.apropos);
		aff_map = (Button) findViewById(R.id.Aff_Map);

		
// Realité augmenér actionlistner--------------------------------
		real_aug.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				Toast.makeText(cntxt, "RA En cours de construction",
						Toast.LENGTH_LONG).show();

			}
		});
		

// afficher la carte map :p--------------------------------
		aff_map.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				Intent intent = new Intent(getBaseContext(), AfficherMap.class);
				startActivity(intent);

			}
		});

		
// à propos action----------------------------------------------------------------
		apropos.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				Toast.makeText(cntxt, "Zakaria & Souhail :p", Toast.LENGTH_LONG)
						.show();

			}
		});

		
		
//action de choix d'un véhicule depuis la liste----------------------------------------------------------------
		list_adapter.setOnItemClickListener(new OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> arg0, View arg1, int arg2,
					long arg3) {
if(data!=null){
				Intent intent = new Intent(getBaseContext(),
						Vehicule_Info.class);
				intent.putExtra("VehiculeSelected", data.get(arg2));
				startActivity(intent);
				}else{
					
				}

			}

		});
		
		
		
		accessWebService();

	}

	// -------------Web Service-----------

	public void accessWebService() {
		JsonReadTask task = new JsonReadTask();
		// passes values for the urls string array
		task.execute(new String[] { URL });
	}

	class JsonReadTask extends AsyncTask<String, Void, String> {
		String result = "";

		@Override
		protected String doInBackground(String... url) {

			try {
				HttpClient httpclient = new DefaultHttpClient();
				HttpPost httppost = new HttpPost(url[0]);
				HttpResponse response = httpclient.execute(httppost);
				HttpEntity entity = response.getEntity();
				InputStream webs = entity.getContent();
				BufferedReader reader = new BufferedReader(
						new InputStreamReader(webs));
				StringBuilder sb = new StringBuilder();
				String line = null;
				while ((line = reader.readLine()) != null) {
					sb.append(line + "\n");

					result = sb.toString();
				}
				webs.close();
			} catch (ClientProtocolException e) {

				e.printStackTrace();
			} catch (IOException e) {
				connectionfile = true;
				e.printStackTrace();
			}

			return null;
		}

		@Override
		protected void onPostExecute(String r) {

			try {
				JSONObject jsonResponse = new JSONObject(result);
				JSONArray jArray = jsonResponse.getJSONArray("vehicule");
				for (int i = 0; i < jArray.length(); i++) {
					JSONObject json_data = jArray.getJSONObject(i);

					
					int id_vehicule=	json_data.getInt("id_vehicule");
					String matricule_vehicule=	json_data.getString("matricule_vehicule");
					int status_vehicule=	json_data.getInt("status_vehicule");
					double latitude_vehicule=	json_data.getDouble("latitude_vehicule");
					double longitude_vehicule=	json_data.getDouble("longitude_vehicule");
					String description_vehicule=	json_data.getString("description_vehicule");
					int type_vehicule=	json_data.getInt("type_vehicule");
					
					//chaffeur information----
					JSONObject driver_json=json_data.getJSONObject("id_chaffeur");
					
					int id_chauffeur=	driver_json.getInt("id_chauffeur");
					int age_chauffeur=	driver_json.getInt("age_chauffeur");
					int sex_chauffeur=	driver_json.getInt("sex_chauffeur");
					String dateinscription_chauffeur=	driver_json.getString("dateinscription_chauffeur");
					String nom_chauffeur=	driver_json.getString("nom_chauffeur");
					String prenom_chauffeur=	driver_json.getString("prenom_chauffeur");
					String image_chauffeur=	driver_json.getString("image_chauffeur");
					String cin_chauffeur=	driver_json.getString("cin_chauffeur");
					int note_chauffeur= driver_json.getInt("note_chauffeur");
					
					Chauffeur driver=new Chauffeur(id_chauffeur, age_chauffeur, sex_chauffeur, dateinscription_chauffeur, nom_chauffeur, prenom_chauffeur, image_chauffeur, cin_chauffeur, note_chauffeur);
					
					 Vehicule vhcl =new Vehicule(driver, id_vehicule, matricule_vehicule, status_vehicule, latitude_vehicule, longitude_vehicule, description_vehicule, type_vehicule);
						 data.add(vhcl);
				}
				 VehiculeAdapter adapter = new VehiculeAdapter(cntxt, data);
				 list_adapter.setAdapter(adapter);

			} catch (JSONException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			super.onPostExecute(r);
		}

	}

}
