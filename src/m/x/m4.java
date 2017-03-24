package m.x;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.text.InputType;
import android.view.MotionEvent;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.view.View.OnTouchListener;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

public class m4 extends Activity implements OnTouchListener{
	EditText txt1;
	 
	double a,b;
	String x,y;
	TextView t;

	@Override
	    public void onCreate(Bundle savedInstanceState) {
	        super.onCreate(savedInstanceState);
	        setContentView(R.layout.mag3);
	        
	
	        txt1=(EditText)findViewById(R.id.e1);
	        t=(TextView)findViewById(R.id.t11);
	         
	         txt1.setInputType(InputType.TYPE_CLASS_NUMBER);
	         ImageView i=(ImageView)findViewById(R.id.i1);
		        i.setOnTouchListener(new OnTouchListener() {
					
					@Override
					public boolean onTouch(View v, MotionEvent event) {
						// TODO Auto-generated method stub

		    			Intent pg=new Intent(getApplicationContext(),m5.class);
		    			pg.putExtra("num",t.getText().toString());
		    			
		    			startActivity(pg);
						return true;
					}
				});
		
		        ImageView i22=(ImageView)findViewById(R.id.i2);
		    	i22.setOnTouchListener(new OnTouchListener() {
		    		
		    		@Override
		    		public boolean onTouch(View v, MotionEvent event) {
		    			// TODO Auto-generated method stub
		    			
		    			a=Double.parseDouble(txt1.getText().toString());
		    			b=a/2;
		    			t.setText(b+"");
		    			
		    			return true;
		    			
		    		}
		    	});
	
	
	
	
	
	
	
	
	
	
	
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	@Override
	public boolean onTouch(View v, MotionEvent event) {
		// TODO Auto-generated method stub
		return false;
	}}