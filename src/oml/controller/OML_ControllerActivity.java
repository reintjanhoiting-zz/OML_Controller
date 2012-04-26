package oml.controller;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class OML_ControllerActivity extends Activity {
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);      
    
    /**
     * Create start
     */
    Button btnOpenNewActivity1 = (Button) findViewById(R.id.start_button);
    btnOpenNewActivity1 .setOnClickListener(new View.OnClickListener() {
        public void onClick(View v) {
        	Intent myIntent2 = new Intent(OML_ControllerActivity.this,Start.class);
        	OML_ControllerActivity.this.startActivity(myIntent2);
        	}
        }
    );
    
    /**
     * Create info sometimes
     */
    Button btnOpenNewActivity = (Button) findViewById(R.id.info_button);
    btnOpenNewActivity .setOnClickListener(new View.OnClickListener() {
    	public void onClick(View v) {
	        Intent myIntent = new Intent(OML_ControllerActivity.this,Info.class);
	        OML_ControllerActivity.this.startActivity(myIntent);
    		}
    	}
    );
 
    /**
     * Create settings
     */
    Button btnOpenNewActivity2 = (Button) findViewById(R.id.setting_button);
    btnOpenNewActivity2 .setOnClickListener(new View.OnClickListener() {
    	public void onClick(View v) {
    		Intent myIntent1 = new Intent(OML_ControllerActivity.this,Settings.class);
    		OML_ControllerActivity.this.startActivity(myIntent1);
    		}
    	}
    );
    
    /**
     * Exit
     */
    Button btnOpenNewActivity3 = (Button) findViewById(R.id.exit_button);
    btnOpenNewActivity3 .setOnClickListener(new View.OnClickListener() {
    	public void onClick(View v) {
    		System.exit(1);
    		
    		}
    	}
    );
}}