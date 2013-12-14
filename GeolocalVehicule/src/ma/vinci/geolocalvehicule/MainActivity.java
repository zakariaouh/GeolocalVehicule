package ma.vinci.geolocalvehicule;



import ma.vinci.geolocalvehicule.action.Authentification;
import ma.vinci.geolocalvehicule.modele.User;
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
public  User u;
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
				
				
		
						 u=new User(login.getText()+"", password.getText()+"");
					boolean	cantbeconnected=Authentification.seconnecter(u);
					if (cantbeconnected) {
							Intent intent=new Intent(getBaseContext(),Accueil.class);
							startActivity(intent);	
					}else{
						Toast.makeText(cntxt, "Combinaison login/mdp incorrect",Toast.LENGTH_LONG).show();
					}
				
			}
		});
     
    }


    
}
