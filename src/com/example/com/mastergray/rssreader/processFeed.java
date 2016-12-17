package com.example.com.mastergray.rssreader;


import java.io.IOException;
import java.net.URL;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import org.xml.sax.InputSource;
import android.os.AsyncTask;
import android.widget.ArrayAdapter;

public class processFeed extends AsyncTask<String, Void, Boolean> {

	@Override
	protected Boolean doInBackground(String... urls) {
        
		try {
        	
        	InputSource is = new InputSource(new URL(urls[0]).openStream());
		
        try {

                // "Invokes" SAX API:
                SAXParserFactory factory = SAXParserFactory.newInstance();

                //  Creates new parser:
                SAXParser saxParser = factory.newSAXParser();
                
                //  Parses file with specified handler:
                saxParser.parse(is, new RSS_Handler());

                		return true;
 
            } catch (Exception e) {

            		return false;

            }
    	
    	
		} catch (IOException e) {
			
			return false;
			
		}
        
    	}
	
	protected void onPostExecute(Boolean result) {
		
		if (result) {
			
			 //  Display channel info:
            Channel channel = Channels.getChannel(0); 
            
            MainActivity.titleView.setText(channel.getTitle());
            MainActivity.descriptionView.setText(channel.getDescription());
            MainActivity.dateView.setText(channel.getPubDate());
            
            //	Display headlines for channel:
            ArrayAdapter<String> aa = new ArrayAdapter<String>(MainActivity.context, android.R.layout.simple_list_item_1, channel.getHeadLines());
            MainActivity.articleView.setAdapter(aa);
			
		}
		
	}
		
	}
	

