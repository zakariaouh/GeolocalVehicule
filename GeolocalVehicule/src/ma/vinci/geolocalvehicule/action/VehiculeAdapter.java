package ma.vinci.geolocalvehicule.action;

import java.util.ArrayList;

import ma.vinci.geolocalvehicule.R;
import ma.vinci.geolocalvehicule.modele.Chauffeur;
import ma.vinci.geolocalvehicule.modele.Vehicule;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

public class VehiculeAdapter  extends BaseAdapter{
	private Context m_context;
	private LayoutInflater inflater;
	private ArrayList<Vehicule> m_data;

	public VehiculeAdapter(Context context, ArrayList<Vehicule> data) {
		// TODO Auto-generated constructor stub
		m_context = context;
		inflater = LayoutInflater.from(context);
		m_data = data;
		
	}

	@Override
	public int getCount() {
		// TODO Auto-generated method stub
		
		return m_data.size();
	}

	@Override
	public Object getItem(int position) {
		// TODO Auto-generated method stub
		
		return m_data.get(position);
	}

	@Override
	public long getItemId(int position) {
		// TODO Auto-generated method stub
		
		return position;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		
		// TODO Auto-generated method stub
		LinearLayout layout_item;
		if(convertView == null){
			layout_item = (LinearLayout)inflater.inflate(R.layout.list_model, parent, false);
		}else{
			layout_item = (LinearLayout)convertView;
		}
		
		TextView title = (TextView)layout_item.findViewById(R.id.title_item);
		TextView description = (TextView)layout_item.findViewById(R.id.description_item);
		
		ImageView img = (ImageView)layout_item.findViewById(R.id.img);
		Chauffeur driver=m_data.get(position).getDriver();
		title.setText(driver.getPrenom()+ " " +driver.getNom());
		description.setText(m_data.get(position).getDescription_vehicule());
		
		int imgid=m_data.get(position).getType_vehicule();
		if(imgid==1){
			img.setImageResource(R.drawable.auto);
		}
		if(imgid==2){
			img.setImageResource(R.drawable.bus);
		}
		if(imgid==0){
		img.setImageResource(R.drawable.camion);
		}
		
		return layout_item;
		

	}
	
	

}
