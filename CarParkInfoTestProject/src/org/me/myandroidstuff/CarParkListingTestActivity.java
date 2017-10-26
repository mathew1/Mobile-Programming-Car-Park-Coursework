package org.me.myandroidstuff;

import java.io.BufferedReader;


import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.LinkedList;

import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;
import org.xmlpull.v1.XmlPullParserFactory;

//import com.makemyandroidapp.example.stacksites.R;






import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.AdapterView.OnItemClickListener;

public class CarParkListingTestActivity extends Activity 
{
	private TextView response;
	private TextView errorText;
	private String result;
    private String sourceListingURL = "http://open.glasgow.gov.uk/api/live/parking.php?type=xml";
    private ListView carParks;
    private String text;
    
    LinkedList <carParkData> alist;
   // private CarParkAdaptor adapter;
    
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) 
    {
    	super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        
        LinkedList <carParkData> alist = null;
        
        carParks = (ListView) findViewById(R.id.carParks);
       
        
        alist = parseData(sourceListingURL);
       // ArrayAdapter<carParkData> adapter = new ArrayAdapter<carParkData>(this, android.R.layout.simple_list_item_1, alist);
//        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, items);
       
        ArrayAdapter<carParkData> adapter = new CarParkAdaptor(getApplicationContext(), android.R.layout.simple_list_item_1, alist);
        
        carParks.setAdapter(adapter);
        
        
      //Make call to parsing code
      		//Note this is not the best location
        
       
        
       // carParks.setOnItemClickListener(new OnItemClickListener() {
         //   public void onItemClick(AdapterView<?> parent, View view, int position,
           //         long aCarParkCapacity) {
                
             //   String item = ((TextView)view).getText().toString();
                
               // Toast.makeText(getBaseContext(), item, Toast.LENGTH_LONG).show();
                
        //    }
        //}
        //);
      
     // Write list to Log for testing
     		if (alist != null)
     		{
     			Log.e("MyTag","List not null");
     			for (Object o : alist)
     			{
     				Log.e("MyTag",o.toString());
     			}
     		}
     		else
     		{
     			Log.e("MyTag","List is null");
     		}
     	}
    
   public LinkedList<carParkData> getCarParks()
   {
	   return alist;
   }
	
    
    private LinkedList<carParkData> parseData(String dataToParse)
    {
		carParkData car = null;
		//LinkedList <carParkData> alist = null;
		alist = new LinkedList<carParkData>();
        // Get the TextView object on which to display the results
        //response = (TextView)findViewById(R.id.urlResponse);
		
        try
        {
        	dataToParse =  sourceListingString(sourceListingURL);
        	XmlPullParserFactory factory = XmlPullParserFactory.newInstance();
			factory.setNamespaceAware(true);
			XmlPullParser xpp = factory.newPullParser();
			xpp.setInput( new StringReader ( dataToParse ) );
			int eventType = xpp.getEventType();
			
			
			while (eventType != XmlPullParser.END_DOCUMENT){
			
				String tagname = xpp.getName();
				switch (eventType) {
				case XmlPullParser.START_TAG:
					
					if(tagname.equalsIgnoreCase("situationRecord")) {
						car = new carParkData();
					}
					break;
					
				case XmlPullParser.TEXT:
					
					text = xpp.getText();
					break;
					
				case XmlPullParser.END_TAG:
					
					if(tagname.equalsIgnoreCase("situationRecord")) {
						alist.add(car);
					}else if(tagname.equalsIgnoreCase("carParkIdentity")) {
						car.setcarParkIdentity(text);
					}else if(tagname.equalsIgnoreCase("carParkOccupancy")) {
						car.setcarParkOccupancy(text);
					}else if(tagname.equalsIgnoreCase("carParkStatus")) {
						car.setcarParkStatus(text);
					}else if(tagname.equalsIgnoreCase("occupiedSpaces")) {
						car.setoccupiedSpaces(text);
					}else if(tagname.equalsIgnoreCase("totalCapacity")) {
						car.settotalCapacity(text);
					}
					break;
				default:
					break;
				}
				
				// Found a start tag 
				//if(eventType == XmlPullParser.START_TAG) 
				//{
					// Check which Tag we have
				//	if (xpp.getName().equalsIgnoreCase("situation"))
				//	{
				//		alist  = new LinkedList<carParkData>();
				//	}
				//	else
				//		if (xpp.getName().equalsIgnoreCase("situationRecord"))
				//		{
				//			Log.e("MyTag","Item Start Tag found");
				//			car = new carParkData();
				//			
				//		}
					
					
				//		else						
				//			if (xpp.getName().equalsIgnoreCase("carParkIdentity"))
		        //    		{
								// Now just get the associated text 
		        //    			String temp = xpp.nextText();
		            			// Do something with text
		         //   			Log.e("MyTag","carParkIdentity is " + temp);
		         //   			car.setcarParkIdentity(temp);
		         //   		}
				//			else						
								// Check which Tag we have
				//				if (xpp.getName().equalsIgnoreCase("carParkOccupancy"))
				//				{
									// Now just get the associated text 
				//					String temp = xpp.nextText();
									// Do something with text
				//					Log.e("MyTag","carParkOccupancy is " + temp);
					//				car.setcarParkOccupancy(temp);
				//				}
				//				else						
									// Check which Tag we have
					//				if (xpp.getName().equalsIgnoreCase("carParkStatus"))
					//				{
										// Now just get the associated text 
					//					String temp = xpp.nextText();
										// Do something with text
					//					Log.e("MyTag","carParkStatus is " + temp);
					///					car.setcarParkStatus(temp);
					//				}
					//				else						
										// Check which Tag we have
					//					if (xpp.getName().equalsIgnoreCase("occupiedSpaces"))
					//					{
											// Now just get the associated text 
					//						String temp = xpp.nextText();
											// Do something with text
					//						Log.e("MyTag","OccupiedSpaces is " + temp);
					//						car.setoccupiedSpaces(temp);
					//					}
					//					else						
											// Check which Tag we have
					//						if (xpp.getName().equalsIgnoreCase("totalCapacity"))
					//						{
												// Now just get the associated text 
					//							String temp = xpp.nextText();
												// Do something with text
					//							Log.e("MyTag","TotalCapacity is " + temp);
					//							car.settotalCapacity(temp);
					//						}
					
			//}
			//	if(eventType == XmlPullParser.END_TAG) 
			//	{
			//		if (xpp.getName().equalsIgnoreCase("situation"))
			//		{
			//			Log.e("MyTag","situation is " + car.toString());
			///			alist.add(car);
			//		}
			//		else
			//			if (xpp.getName().equalsIgnoreCase("situationRecord"))
			//			{
			//				int size;
			///				size = alist.size();
			//				Log.e("MyTag","situationRecord size is " + size);
							
			//			}
					
					
					
			//	}
				// Get the next event	
				eventType = xpp.next();
			}
        }
        	// Get the data from the RSS stream as a string
        	
        	
        	// Do some processing of the data to get the individual parts of the XML stream
        	// At some point put this processing into a separate thread of execution
        	
        	
        	// Display the string in the TextView object just to demonstrate this capability
        	// This will need to be removed at some point
        	//response.setText(result);
					//}
			
        
					
       catch(XmlPullParserException ae1)
        {
    	   Log.e("MyTag","Parsing error" + ae1.toString());
        }
        
        catch(IOException ae)
        {
        	// Handle error
        	response.setText("Error");
        	// Add error info to log for diagnostics
        	errorText.setText(ae.toString());
        	Log.e("MyTag","IO error during parsing");
        } 
        
        Log.e("MyTag","End document");
        
        return alist;
        
        
    
    } 
    
    // Method to handle the reading of the data from the XML stream
    private static String sourceListingString(String urlString)throws IOException
    {
	 	String result = "";
    	InputStream anInStream = null;
    	int response = -1;
    	URL url = new URL(urlString);
    	URLConnection conn = url.openConnection();
    	
    	// Check that the connection can be opened
    	if (!(conn instanceof HttpURLConnection))
    			throw new IOException("Not an HTTP connection");
    	try
    	{
    		// Open connection
    		HttpURLConnection httpConn = (HttpURLConnection) conn;
    		httpConn.setAllowUserInteraction(false);
    		httpConn.setInstanceFollowRedirects(true);
    		httpConn.setRequestMethod("GET");
    		httpConn.connect();
    		response = httpConn.getResponseCode();
    		// Check that connection is Ok
    		if (response == HttpURLConnection.HTTP_OK)
    		{
    			// Connection is Ok so open a reader 
    			anInStream = httpConn.getInputStream();
    			InputStreamReader in= new InputStreamReader(anInStream);
    			BufferedReader bin= new BufferedReader(in);
    			
    			// Read in the data from the XML stream
    			bin.readLine(); // Throw away the header
    			String line = new String();
    			while (( (line = bin.readLine())) != null)
    			{
    				result = result + "\n" + line;
    			}
    		}
    	}
    	catch (Exception ex)
    	{
    			throw new IOException("Error connecting");
    	}
    	
    	// Return result as a string for further processing
    	return result;
    	
    } // End of sourceListingString
    
} // End of Activity class

// Mathew McGerty - S1036834