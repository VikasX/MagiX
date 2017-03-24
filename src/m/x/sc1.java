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
import android.speech.tts.TextToSpeech;
import android.speech.tts.TextToSpeech.OnInitListener;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class sc1 extends Activity implements OnInitListener {
	GestureLibrary gestureLibrary = null;
	GestureOverlayView gestureOverlayView;
	EditText gestureResult;
	  private TextToSpeech tts;
	  private int MY_DATA_CHECK_CODE = 0;
	  private Button speakButton;
	 
	 /** Called when the activity is first created. */
	 @Override
	 public void onCreate(Bundle savedInstanceState) {
	     super.onCreate(savedInstanceState);
	     setContentView(R.layout.s1);
	      
	     gestureResult = (EditText)findViewById(R.id.gestureresult);
	     gestureOverlayView = (GestureOverlayView)findViewById(R.id.gestures);
		 Button bx=(Button)findViewById(R.id.b2);	   
	     gestureLibrary = GestureLibraries.fromRawResource(this, R.raw.gestures);
	     gestureLibrary.load();
	   
	     gestureOverlayView.addOnGesturePerformedListener(gesturePerformedListener);
	     
	     
	     
	     gestureResult = (EditText) findViewById(R.id.gestureresult);
	     speakButton = (Button) findViewById(R.id.b1);
	      
	     speakButton.setOnClickListener(new OnClickListener() {           
	      @Override
	      public void onClick(View v) {
	          String text = gestureResult.getText().toString();
	          if (text!=null && text.length()>0) {
	       Toast.makeText(sc1.this, "Saying: " + text, Toast.LENGTH_LONG).show();
	       tts.speak(text, TextToSpeech.QUEUE_ADD, null);
	          }
	      }


	         });
	      bx.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				Intent v=new Intent(sc1.this,MAGActivity.class);
				startActivity(v);
			}
		})
	    ;
	     
	     
	     
	     
	     
	     
	     Intent checkIntent = new Intent();
	         checkIntent.setAction(TextToSpeech.Engine.ACTION_CHECK_TTS_DATA);
	         startActivityForResult(checkIntent, MY_DATA_CHECK_CODE);
	            
	       }
	 
	     protected void onActivityResult(int requestCode, int resultCode, Intent data) {
	           if (requestCode == MY_DATA_CHECK_CODE) {
	               if (resultCode == TextToSpeech.Engine.CHECK_VOICE_DATA_PASS) {
	                   // success, create the TTS instance
	                   tts = new TextToSpeech(this, this);
	               }
	               else {
	                   // missing data, install it
	                   Intent installIntent = new Intent();
	                   installIntent.setAction(TextToSpeech.Engine.ACTION_INSTALL_TTS_DATA);
	                   startActivity(installIntent);
	               }
	           }

	       }

	       @Override
	       public void onInit(int status) {       
	           if (status == TextToSpeech.SUCCESS) {
	               Toast.makeText(sc1.this,
	                       "Text-To-Speech engine is initialized", Toast.LENGTH_LONG).show();
	       }
	           else if (status == TextToSpeech.ERROR) {
	               Toast.makeText(sc1.this,
	                       "Error occurred while initializing Text-To-Speech engine", Toast.LENGTH_LONG).show();
	           }
	       }
	        
	  
	 OnGesturePerformedListener gesturePerformedListener
	 = new OnGesturePerformedListener(){
	 
	 @Override
	 public void onGesturePerformed(GestureOverlayView view, Gesture gesture) {
	  // TODO Auto-generated method stub
	  ArrayList<Prediction> prediction = gestureLibrary.recognize(gesture);
	  if(prediction.size() > 0){
	   gestureResult.setText(prediction.get(0).name);
	  }
	 }};
	 
}
	 
	 
	  
	 
	 
	


	 
