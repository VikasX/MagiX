package m.x;


import java.util.ArrayList;

import android.app.Activity;
import android.content.Intent;
import android.gesture.Gesture;
import android.gesture.GestureLibraries;
import android.gesture.GestureLibrary;
import android.gesture.GestureOverlayView;
import android.gesture.Prediction;
import android.gesture.GestureOverlayView.OnGesturePerformedListener;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;

public class sc2 extends Activity {
	GestureLibrary gestureLibrary = null;
	GestureOverlayView gestureOverlayView;
	EditText gestureResult;
	Button b; 
	
	 @Override
	 public void onCreate(Bundle savedInstanceState) {
	     super.onCreate(savedInstanceState);
	     setContentView(R.layout.s3);
	     
	     gestureResult = (EditText)findViewById(R.id.gestureresult);
	     gestureOverlayView = (GestureOverlayView)findViewById(R.id.gestures);
	 
	     
	        b=(Button)findViewById(R.id.b1);
	   b.setOnClickListener(new OnClickListener() {
		
		@Override
		public void onClick(View arg0) {
			// TODO Auto-generated method stub
			Intent pg=new Intent(getApplicationContext(),sc3.class);
			pg.putExtra("num",gestureResult.getText().toString());
			
			startActivity(pg);
		
			
			
		}
	});
	 }	}

	 
