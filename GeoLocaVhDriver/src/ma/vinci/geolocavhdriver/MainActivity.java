package ma.vinci.geolocavhdriver;

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

import com.google.android.gms.maps.model.LatLng;

import android.app.Activity;
import android.content.Context;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.PowerManager;
import android.os.PowerManager.WakeLock;
import android.view.Menu;
import android.widget.TextView;

public class MainActivity extends Activity {
	TextView textview;
	private Context cntxt = this;
	private String URL,URL2;
	ArrayList<LatLng> trajectoire = new ArrayList<LatLng>();
	private final int ID_VH=1;
	private WakeLock wakeLock;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		// check if GPS enabled
        GPSTracker gpsTracker = new GPSTracker(this);

        if (gpsTracker.canGetLocation())
        {
			//192.168.11.11
			URL = "http://geoloca.hostingsiteforfree.com/public/index/?op=3"
					+ "&id_vh="+ID_VH
					+ "&latitude=" + gpsTracker.getLatitude()
					+ "&longitude=" + gpsTracker.getLongitude();
			accessWebService();
			trajectoire = null;
			trajectoire = new ArrayList<LatLng>();
        	
          /* /**/
        }
        else
        {
            // can't get location
            // GPS or Network is not enabled
            // Ask user to enable GPS/network in settings
            gpsTracker.showSettingsAlert();
        }
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}
	@Override
	protected void onStart() {
		// TODO Auto-generated method stub
		super.onStart();
		
		//Toast.makeText(cntxt, "Aucun connexion",Toast.LENGTH_LONG).show();
		PowerManager powerManager=(PowerManager)getSystemService(Context.POWER_SERVICE);
		wakeLock=powerManager.newWakeLock(PowerManager.PARTIAL_WAKE_LOCK, "No Sleep ");
		wakeLock.acquire();

	}
	@Override
	protected void onPause() {
		// TODO Auto-generated method stub
		super.onPause();
	}
	@Override
	protected void onStop() {
		super.onStop();
		wakeLock.release();
	}
		public void accessWebService() {
			JsonReadTask task = new JsonReadTask();
			// passes values for the urls string array
			task.execute(new String[] { URL });
		}

		class JsonReadTask extends AsyncTask<String, Void, String> {
			

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
					

				} catch (ClientProtocolException e) {

					e.printStackTrace();
				} catch (IOException e) {
					e.printStackTrace();
				}

				return null;
			}

			@Override
			protected void onPostExecute(String r) {


				super.onPostExecute(r);
			}

		}
}
