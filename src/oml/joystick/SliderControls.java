package oml.joystick;

import oml.controller.R;
import oml.controller.R.id;
import android.content.Context;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Point;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.widget.RelativeLayout;

public class SliderControls extends View implements OnTouchListener
{
	public final int INIT_X = 0;
	public final int INIT_Y = 179;
	
	public Point _touchingPoint = new Point(INIT_X, INIT_Y);
	
	private Boolean _dragging = false;
	private MotionEvent lastEvent;
	
	public float percentage = 0;
	
	public SliderControls(Context context) 
	{
		this(context, null);
		// TODO Auto-generated constructor stub
	}
	
	public SliderControls(Context context, AttributeSet attrs)
	{
		this(context, null, 0);
	}
	
	public SliderControls(Context context, AttributeSet attrs, int defstyle)
	{
		super(context, attrs, defstyle);
		this.setOnTouchListener(this);
		
		//get the sliderbox view
	}
	
	public boolean onTouch(View v, MotionEvent event) 
	{
		update(event);
		this.invalidate();
		return true;
	}
	
	public void update(MotionEvent event)
	{
		if (event == null && lastEvent == null)
			return;
		
		else if(event == null && lastEvent != null)
			event = lastEvent;
		
		else
			lastEvent = event;
		
		//drag drop 
		if ( event.getAction() == MotionEvent.ACTION_DOWN )
			_dragging = true;
		
		else if ( event.getAction() == MotionEvent.ACTION_UP)							
			_dragging = false;
		
		if ( _dragging )
		{
			// get the position
			_touchingPoint.x = INIT_X;
			
			if ((int)event.getY() < 0)
				_touchingPoint.y = 0;
			else if((int)event.getY() > 179)
				_touchingPoint.y = 179;
			else
				_touchingPoint.y = (int)event.getY();
		}
		
		//determine the percentage of power
		percentage = ((Math.abs(_touchingPoint.y - 179) / 179) * 100);
	}
	
	@Override
	public void onDraw(Canvas canvas)
	{			
		if(!this.isInEditMode())
		{			
			if (((View) this.getParent()).getVisibility() == VISIBLE && ((View) this.getParent()).getId() != id.bigSlider)
			{
				//draw the dragable slider(s)
				canvas.drawBitmap(BitmapFactory.decodeResource(this.getResources(), R.drawable.slidersmall), _touchingPoint.x, _touchingPoint.y, null);
			}
			else
			{
				//draw the dragable slider
				canvas.drawBitmap(BitmapFactory.decodeResource(this.getResources(), R.drawable.sliderbig), _touchingPoint.x, _touchingPoint.y, null);
			}
		}
		//for debugging in edit mode
		else
		{
			 Paint innerCirclePaint = new Paint();
			 innerCirclePaint.setARGB(255, 255, 255, 255);
			 innerCirclePaint.setAntiAlias(true);
			
			 innerCirclePaint.setStyle(Paint.Style.FILL);
			 canvas.drawLine(21, 0, 21, 205, innerCirclePaint);
		}
	}
}
