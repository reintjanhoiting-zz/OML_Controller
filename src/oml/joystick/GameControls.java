package oml.joystick;

import oml.controller.R;
import android.content.Context;
import android.graphics.*;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;

public class GameControls extends View implements OnTouchListener
{	
	public final int INIT_X = 62;
	public final int INIT_Y = 53;
	public final float MAX_RADIUS = 50;
	public Point _touchingPoint = new Point(62, 53);
	private Boolean _dragging = false;
	
	//pythagoreon theorem
	public float _a = 0;
	public float _b = 0;
	public float _c = 0;
	public float _angle = 0;
	private MotionEvent lastEvent;
	
	public GameControls(Context context) 
	{
		this(context, null);
		// TODO Auto-generated constructor stub
	}
	
	public GameControls(Context context, AttributeSet attrs)
	{
		this(context, null, 0);
	}
	
	public GameControls(Context context, AttributeSet attrs, int defstyle)
	{
		super(context, attrs, defstyle);
		this.setOnTouchListener(this);
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
		{			
			// Snap back to center when the joystick is released
			_touchingPoint.x = (int) INIT_X;
			_touchingPoint.y = (int) INIT_Y;
			
			_dragging = false;
		}
		
		if ( _dragging )
		{
			// get the position
			_touchingPoint.x = (int)event.getX();
			_touchingPoint.y = (int)event.getY();
			
			_a = _touchingPoint.x - INIT_X;
			_b = _touchingPoint.y - INIT_Y;
			_c = (float)Math.sqrt(Math.pow(_a, 2) + Math.pow(_b, 2));
			
			if (_c > MAX_RADIUS)
				_touchingPoint = new Point((int)(((MAX_RADIUS/_c) * _a + INIT_X)), ((int)((MAX_RADIUS/_c) * _b + INIT_Y)));

			//get the angle
			//double angle = Math.atan2(_touchingPoint.y - INIT_Y,_touchingPoint.x - INIT_X)/(Math.PI/180);
		}
	}
	
	@Override
	public void onDraw(Canvas canvas)
	{
	
		if(!this.isInEditMode())
		{
			//draw the dragable joystick
			canvas.drawBitmap(BitmapFactory.decodeResource(this.getResources(), R.drawable.joystick), _touchingPoint.x, _touchingPoint.y, null);
		}
		//for debugging in edit mode
		else
		{
			 Paint innerCirclePaint = new Paint();
			 innerCirclePaint.setARGB(255, 255, 255, 255);
			 innerCirclePaint.setAntiAlias(true);
			
			 innerCirclePaint.setStyle(Paint.Style.FILL);
			 canvas.drawLine(0, 0, 61, 52, innerCirclePaint);
		}
	}
}
