package ma.vinci.geolocalvehicule;

import java.util.ArrayList;
///import java.util.List;

import ma.vinci.geolocalvehicule.R;
import ma.vinci.geolocalvehicule.action.VehiculeAdapter;
import ma.vinci.geolocalvehicule.action.VehiculetActions;
import ma.vinci.geolocalvehicule.modele.Vehicule;
import ma.vinci.geolocalvehicule.viewanimation.CollapseAnimation;
import ma.vinci.geolocalvehicule.viewanimation.ExpandAnimation;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.widget.Button;
import android.widget.ListView;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;


import android.view.View;
import android.view.View.OnClickListener;
import android.view.animation.Animation;
import android.view.animation.TranslateAnimation;

import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;
public class Vehiculesliste extends Activity {

	private ListView list_adapter;
	private Context cntxt = this;
	private Button aff_map,real_aug,apropos;
	public static int index_selected_item;
	//Declare
		private LinearLayout slidingPanel;
		private boolean isExpanded;
		private DisplayMetrics metrics;	
		private RelativeLayout headerPanel;
		private RelativeLayout menuPanel;
		private int panelWidth;
		private ImageView menuViewButton;
		Button menu1 ;
		Button menu2 ;
		TextView txtpays;
		FrameLayout.LayoutParams menuPanelParameters;
		FrameLayout.LayoutParams slidingPanelParameters;
		LinearLayout.LayoutParams headerPanelParameters ;
		LinearLayout.LayoutParams listViewParameters;	
	//private List<Integer> arrayidvehicule = new ArrayList<Integer>();

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_vehiculesliste);
		
		
        list_adapter = (ListView)findViewById(R.id.listeviewvehicule);
        
        //remplire liste view
    	ArrayList<Vehicule> data = VehiculetActions.getvihicules();	
	       
        VehiculeAdapter adapter = new VehiculeAdapter(cntxt,data);
        list_adapter.setAdapter(adapter);
		
        //action bouton menu
       
        
        
      //Initialize
      		metrics = new DisplayMetrics();
      		getWindowManager().getDefaultDisplay().getMetrics(metrics);
      		panelWidth = (int) ((metrics.widthPixels)*0.75);
      	
      		headerPanel = (RelativeLayout) findViewById(R.id.header);
      		headerPanelParameters = (LinearLayout.LayoutParams) headerPanel.getLayoutParams();
      		headerPanelParameters.width = metrics.widthPixels;
      		headerPanel.setLayoutParams(headerPanelParameters);
      		
      		menuPanel = (RelativeLayout) findViewById(R.id.menuPanel);
      		menuPanelParameters = (FrameLayout.LayoutParams) menuPanel.getLayoutParams();
      		menuPanelParameters.width = panelWidth;
      		menuPanel.setLayoutParams(menuPanelParameters);
      		
      		slidingPanel = (LinearLayout) findViewById(R.id.slidingPanel);
      		slidingPanelParameters = (FrameLayout.LayoutParams) slidingPanel.getLayoutParams();
      		slidingPanelParameters.width = metrics.widthPixels;
      		slidingPanel.setLayoutParams(slidingPanelParameters);
      		
      	
      		listViewParameters = (LinearLayout.LayoutParams) list_adapter.getLayoutParams();
      		listViewParameters.width = metrics.widthPixels;
      		list_adapter.setLayoutParams(listViewParameters);
      		
////
      		menuViewButton = (ImageView) findViewById(R.id.menuViewButton);
    		
    		menuViewButton.setOnClickListener(new OnClickListener() {
    		    public void onClick(View v) {
    		    	if(!isExpanded){
    		    		isExpanded = true;   		    				        		
    		        	
    		    		//Expand
    		    		new ExpandAnimation(slidingPanel, panelWidth,
    		    	    Animation.RELATIVE_TO_SELF, 0.0f,
    		    	    Animation.RELATIVE_TO_SELF, 0.75f, 0, 0.0f, 0, 0.0f);		    			         	    
    		    	}else{
    		    		isExpanded = false;
    		    		
    		    		//Collapse
    		    		new CollapseAnimation(slidingPanel,panelWidth,
                	    TranslateAnimation.RELATIVE_TO_SELF, 0.75f,
                	    TranslateAnimation.RELATIVE_TO_SELF, 0.0f, 0, 0.0f, 0, 0.0f);
    		   
    					
    		    	}         	   
    		    }
    		});
    		real_aug=(Button)findViewById(R.id.Real_Aug);
    		apropos=(Button)findViewById(R.id.apropos);
    		aff_map=(Button)findViewById(R.id.Aff_Map);
    		real_aug.setOnClickListener(new View.OnClickListener() {
				
				@Override
				public void onClick(View v) {
					Toast.makeText(cntxt, "RA En cours de construction",Toast.LENGTH_LONG).show();
					
				}
			});
    		aff_map.setOnClickListener(new View.OnClickListener() {
				
				@Override
				public void onClick(View v) {
					Toast.makeText(cntxt, "aff_map En cours de construction",Toast.LENGTH_LONG).show();
					
				}
			});
    		apropos.setOnClickListener(new View.OnClickListener() {
				
				@Override
				public void onClick(View v) {
					Toast.makeText(cntxt, "Zakaria & Souhail :p",Toast.LENGTH_LONG).show();
					
				}
			});

    		list_adapter.setOnItemClickListener(new OnItemClickListener() {

				@Override
				public void onItemClick(AdapterView<?> arg0, View arg1,
						int arg2, long arg3) {
					//Toast.makeText(cntxt, ""+arg2,Toast.LENGTH_LONG).show();
					index_selected_item=arg2;
					Intent intent=new Intent(getBaseContext(),Vehicule_Info.class);
					startActivity(intent);	
					
				}
  	          
				                 
  	       });
        
	}



}
