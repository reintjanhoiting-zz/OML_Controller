package oml.controller;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;


public class Info extends Activity {
	/** Called when the activity is first created. */
    public void onCreate(Bundle savedInstanceState) {
    	super.onCreate(savedInstanceState);
        setContentView(R.layout.info); 
        /*ImageView image = (ImageView) findViewById(R.id.nhl_image);*/
        
        /**
         * maybe this for calling the exit please
         */
        Button btn = (Button) findViewById(R.id.back_button);
        btn .setOnClickListener(new View.OnClickListener() {
        public void onClick(View v) {

        	System.exit(1);
        }

        });
    }
}
