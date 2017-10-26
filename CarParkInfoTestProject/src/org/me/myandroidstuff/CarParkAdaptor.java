package org.me.myandroidstuff;

import java.util.ArrayList;


import java.util.LinkedList;



import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.RelativeLayout;
import android.widget.TextView;

public class CarParkAdaptor extends ArrayAdapter<carParkData> {
	
	private LinkedList<carParkData> alist;

	public CarParkAdaptor(Context context, int textViewResourceId, LinkedList<carParkData> alist) {
		super(context, textViewResourceId, alist);
		// TODO Auto-generated constructor stub
		this.alist = alist;
		
	}
	
	 public View getView(int pos, View convertView, ViewGroup parent )
	    {
	    	RelativeLayout row = (RelativeLayout)convertView;
	    	if(null == row){
				//No recycled View, we have to inflate one.
				LayoutInflater inflater = (LayoutInflater)parent.getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
				row = (RelativeLayout)inflater.inflate(R.layout.cp_layout, parent, false);
			}
	    	//carParkData aCarParkIdentity = alist.get(pos);
	    	
	    	TextView carParkIdentity = (TextView)row.findViewById(R.id.car_Park_Identity);
	    	carParkIdentity.setText(getItem(pos).getcarParkIdentity());
	    	
	    	TextView textCarParkOccupancy =(TextView)row.findViewById(R.id.Occupancy);
	    	TextView carParkOccupancy = (TextView)row.findViewById(R.id.car_Park_Occupancy);
	        textCarParkOccupancy.setText("Car Park Occupancy:");
	    	carParkOccupancy.setText(getItem(pos).getcarParkOccupancy());
	        
	    	TextView textcarParkStatus = (TextView)row.findViewById(R.id.CarParkStatus);
	    	TextView carParkStatus = (TextView)row.findViewById(R.id.car_Park_Status);
	    	textcarParkStatus.setText("Car Park Status:");
	        carParkStatus.setText(getItem(pos).getcarParkStatus());
	        
	        TextView textOccupiedSpaces = (TextView)row.findViewById(R.id.OccupiedSpaces);
	        TextView occupiedSpaces = (TextView)row.findViewById(R.id.occupied_Spaces);
	        textOccupiedSpaces.setText("Occupied Spaces:");
	        occupiedSpaces.setText(getItem(pos).getoccupiedSpaces());
	        
	        TextView texttotalCapacity = (TextView)row.findViewById(R.id.TotalCapacity);
	        TextView totalCapacity = (TextView)row.findViewById(R.id.total_Capacity);
	        texttotalCapacity.setText("Total Capacity:");
	        totalCapacity.setText(getItem(pos).gettotalCapacity());
	        
	        
	       
	        
	      
	        
	        return row;
	    }

	
	
	

}
//Mathew McGerty - S1036834