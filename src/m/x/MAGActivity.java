package m.x;


import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.widget.ImageView;

public class MAGActivity extends Activity implements OnTouchListener{
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.f11);
        ImageView i=(ImageView)findViewById(R.id.i1);
        i.setOnTouchListener(new OnTouchListener() {
     	
     	
     
        
             
             
             
         	@Override
	public boolean onTouch(View arg0, MotionEvent arg1) {
		// TODO Auto-generated method stub
		Intent px=new Intent(MAGActivity.this,ff2.class);
 		startActivity(px);
 		
 		return true;
	}
     	
        });
     	
     	
     	
     	
     	
     }

	@Override
	public boolean onTouch(View arg0, MotionEvent arg1) {
		// TODO Auto-generated method stub
		return false;
	}}