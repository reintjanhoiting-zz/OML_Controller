package oml.controller;

import android.app.Activity;
import android.os.Bundle;


public class Start extends Activity {

	 /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        GameControls pleasureStick = new GameControls(this);
        pleasureStick.setOnTouchListener(pleasureStick);
        setContentView(pleasureStick);
        
        
}}
