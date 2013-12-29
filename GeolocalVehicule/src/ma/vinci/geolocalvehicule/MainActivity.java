package ma.vinci.geolocalvehicule;



import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;



import android.os.AsyncTask;
import android.os.Bundle;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends Activity {
private Button btn;
private EditText login,password;
private Context cntxt=this;
boolean connectionfile=false;


private  String URL;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
     setContentView(R.layout.activity_main); 

        btn=(Button)findViewById(R.id.connexionbtn);
		login=(EditText)findViewById(R.id.login);
		password=(EditText)findViewById(R.id.password);
		
		btn.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				URL="http://192.168.56.1/web_servicev2/public/index/?op=1&"+"login="+login.getText()+"&pass="+password.getText();
				
				accessWebService();
		if(connectionfile==true){
			Toast.makeText(cntxt, "Aucun connexion",Toast.LENGTH_LONG).show();
			connectionfile=false;
		}
				
				
			}
		});
		
	
     
    }


    
    
	 public void accessWebService() {
		  JsonReadTask task = new JsonReadTask();
		  // passes values for the urls string array
		  task.execute(new String[] { URL });
		 }
	class JsonReadTask  extends AsyncTask<String, Void, String> {
		String result=""; 
		@Override
		protected String doInBackground(String... url) {
			
		
			try {	
				HttpClient httpclient=new DefaultHttpClient();
				HttpPost httppost =new HttpPost(url[0]);		
				HttpResponse response=httpclient.execute(httppost);
				HttpEntity entity = response.getEntity();
				InputStream webs=entity.getContent();
				BufferedReader reader=new BufferedReader(new InputStreamReader(webs));
				StringBuilder sb=new StringBuilder();
				String line=null;
				while ((line=reader.readLine())!=null) {
				sb.append(line+"\n");
				
				result=sb.toString(); 					
				}
				webs.close(); 
				} catch (ClientProtocolException e) {
					
					e.printStackTrace();
				} catch (IOException e) {
					connectionfile=true;
					e.printStackTrace();
				}
				
			
			return null;
		}
@Override
protected void onPostExecute(String r) {
	
	try { 
		JSONObject jsonResponse = new JSONObject(result);
		JSONArray jArray=jsonResponse.getJSONArray("auth");
		for (int i = 0; i < jArray.length(); i++) {
			JSONObject json_data=jArray.getJSONObject(i);
		
			boolean	canbeconnected=false;
			canbeconnected=Boolean.valueOf(json_data.getString("succes"));
		if (canbeconnected) {
			Intent intent=new Intent(getBaseContext(),Vehiculesliste.class);
			startActivity(intent);	
		}else{
			Toast.makeText(cntxt, "Combinaison login/mdp incorrect",Toast.LENGTH_LONG).show();
		}
			
		}
		

	} catch (JSONException e) {
		// TODO Auto-generated catch block  
		e.printStackTrace();
	}	
	
	
	
	
	super.onPostExecute(r);
}
	   
	}

    
}
