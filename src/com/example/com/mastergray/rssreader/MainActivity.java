package com.example.com.mastergray.rssreader;

import android.net.Uri;
import android.os.Bundle;
import android.os.StrictMode;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Paint;
import android.text.method.ScrollingMovementMethod;
import android.view.Menu;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

import java.io.IOException;
import java.net.URL;
import org.xml.sax.InputSource;

public class MainActivity extends Activity {

	EditText rss_url;
	static TextView titleView;
	static TextView descriptionView;
	static TextView dateView;
	static ListView articleView;
	static Context context;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		//StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
		//StrictMode.setThreadPolicy(policy); 
		
		context = this;
		rss_url = (EditText) findViewById(R.id.rss_url);
		
		titleView = (TextView) findViewById(R.id.titleView);
		descriptionView = (TextView) findViewById(R.id.descriptionView);
		dateView = (TextView) findViewById(R.id.dateView);
		articleView = (ListView) findViewById(R.id.articleView);
		
		//articleView.setMovementMethod(new ScrollingMovementMethod());
		
		Button readButton = (Button) findViewById(R.id.readButton);
	
		//		Adds new item to list:
		readButton.setOnClickListener( new View.OnClickListener() {
			
				@Override
	            public void onClick(View v) {
					
					String url = rss_url.getText().toString();
					new processFeed().execute(url);
					
	            	
	            }
	    });
		
	
	   articleView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
	
		      @Override
		      public void onItemClick(AdapterView<?> parent, final View view, int position, long id) {
		      
		    	  String url = Channels.getChannel(0).getArticle(position).getLink();
		    	  Uri uri = Uri.parse(url);
		    	  Intent intent = new Intent(Intent.ACTION_VIEW, uri);
		    	  startActivity(intent);
		    	  
		    	 
		    	  
		      }
	
		});
		
		
		
		
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}
	
	

	

}
