package oml.controller;

import oml.joystick.GameControls;
import android.app.Activity;
import android.os.Bundle;
import android.view.View;


public class Start extends Activity {

	 /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) 
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.start);
        
        GameControls pleasureStick = new GameControls(this);
        
        View joyView = findViewById(R.id.joyBox);
        joyView.setOnTouchListener(pleasureStick);
        
//        RelativeLayout startLayout = (RelativeLayout)findViewById(R.id.startLayout);
//        startLayout.addView(pleasureStick);
    }     
}
