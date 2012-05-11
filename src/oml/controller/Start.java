package oml.controller;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.RelativeLayout;


public class Start extends Activity 
{
	 /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) 
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.start);
        
        RelativeLayout smallslider0 = (RelativeLayout) findViewById(R.id.smallSlider0);
        RelativeLayout smallslider1 = (RelativeLayout) findViewById(R.id.smallSlider1);
		RelativeLayout bigslider = (RelativeLayout) findViewById(R.id.bigSlider);
        
        Button sliderButton = (Button) findViewById(R.id.sliderButton);
        sliderButton.setOnClickListener(new clickListener(this, smallslider0, smallslider1, bigslider));
    } 
    
    public class clickListener extends View implements OnClickListener
    {	    	
    	RelativeLayout smallslider0;
    	RelativeLayout smallslider1;
    	RelativeLayout bigslider;
    	
    	public clickListener(Context context) 
    	{
    		this(context, null);
    		
    		// TODO Auto-generated constructor stub
    	}
    	
    	public clickListener(Context context, AttributeSet attrs)
    	{
    		this(context, null, 0);
    	}
    	
    	public clickListener(Context context, AttributeSet attrs, int defstyle)
    	{
    		super(context, attrs, defstyle);
    	}
    	
    	public clickListener(Context context, RelativeLayout one, RelativeLayout two, RelativeLayout three)
    	{
    		this(context,null);
    		this.smallslider0 = one;
    		this.smallslider1 = two;
    		this.bigslider = three;
    	}

		public void onClick(View arg0) 
		{
			// TODO Auto-generated method stub			
			if (smallslider0.getVisibility() == VISIBLE)
			{
				smallslider0.setVisibility(GONE);
				smallslider1.setVisibility(GONE);
				bigslider.setVisibility(VISIBLE);
			}
			else if (bigslider.getVisibility() == VISIBLE)
			{
				bigslider.setVisibility(GONE);
				smallslider0.setVisibility(VISIBLE);
				smallslider1.setVisibility(VISIBLE);
			}
		}
    }
}
