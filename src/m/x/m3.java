package m.x;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.view.View.OnTouchListener;
import android.widget.ImageView;

public class m3 extends Activity implements OnTouchListener{

	@Override
	    public void onCreate(Bundle savedInstanceState) {
	        super.onCreate(savedInstanceState); 
	        setContentView(R.layout.mag2);
	       
	        ImageView i=(ImageView)findViewById(R.id.i1);
	        i.setOnTouchListener(new OnTouchListener() {
				
				@Override
				public boolean onTouch(View v, MotionEvent event) {
					// TODO Auto-generated method stub
					Intent p=new Intent(m3.this,m4.class);
					startActivity(p);
					
					return true;
				}
			});
	
	
	
	ImageView i22=(ImageView)findViewById(R.id.i2);
	i22.setOnTouchListener(new OnTouchListener() {
		
		@Override
		public boolean onTouch(View v, MotionEvent event) {
			// TODO Auto-generated method stub
			Intent p2=new Intent(m3.this,MAGActivity.class);
			startActivity(p2);
			
			return true;
		}
	});

	
	
	
	}
	
	@Override
	public boolean onTouch(View v, MotionEvent event) {
		return false;
		// TODO Auto-generated method stub
	
		
		
	}}


