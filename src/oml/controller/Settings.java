package oml.controller;

import Settings.Singleton;
import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Settings extends Activity{
	/** Called when the activity is first created. */
    public void onCreate(Bundle savedInstanceState) {
    	super.onCreate(savedInstanceState);
        setContentView(R.layout.setting); 
        
        //Singleton.getInstance().IpAdress = R.id.ip_adress;
        
        Button btn = (Button) findViewById(R.id.back_button1);
        btn .setOnClickListener(new View.OnClickListener() {
        public void onClick(View v) {

        	System.exit(1);
        }

        });
    }
}
