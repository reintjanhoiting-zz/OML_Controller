package oml.controller;

import oml.controller.R;
import android.content.Context;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Point;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;

public class GameControls extends View implements OnTouchListener
{
	public final int INIT_X = 450;
	public final int INIT_Y = 250;
	public final float MAX_RADIUS = 25;
	public Point _touchingPoint = new Point(450,250);
	public Point _pointerPosition = new Point(220,150);
	private Boolean _dragging = false;
	
	//pythagoreon theorem
	public float _a = 0;
	public float _b = 0;
	public float _c = 0;
	public float _angle = 0;
	
	public GameControls(Context context) 
	{
		super(context);
		// TODO Auto-generated constructor stub
	}

	public boolean onTouch(View v, MotionEvent event) 
	{
		update(event);
		this.invalidate();
		return true;
	}

	private MotionEvent lastEvent;
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
			double angle = Math.atan2(_touchingPoint.y - INIT_Y,_touchingPoint.x - INIT_X)/(Math.PI/180);
		}
	}
	
	@Override
	public void onDraw(Canvas canvas)
	{
		//white background
		canvas.drawColor(Color.WHITE);
		
		//draw the joystick background
		canvas.drawBitmap(BitmapFactory.decodeResource(this.getResources(), R.drawable.joystick_bg), 405, 205, null);

		//draw the dragable joystick
		canvas.drawBitmap(BitmapFactory.decodeResource(this.getResources(), R.drawable.joystick), _touchingPoint.x - 26, _touchingPoint.y - 26, null);
	}
}
