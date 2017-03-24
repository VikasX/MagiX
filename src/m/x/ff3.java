package m.x;

import android.app.Activity;
import android.content.Intent;
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


public class ff3 extends Activity implements OnInitListener {
    /** Called when the activity is first created. */
	  private int MY_DATA_CHECK_CODE = 0;
	     
      private TextToSpeech tts;
   
  private EditText inputText;
  private Button speakButton;
   
@Override
public void onCreate(Bundle savedInstanceState) {
   
super.onCreate(savedInstanceState);
setContentView(R.layout.f3);

Button bx=(Button)findViewById(R.id.bx2);
inputText = (EditText) findViewById(R.id.t1);
speakButton = (Button) findViewById(R.id.b1);
bx.setOnClickListener(new OnClickListener() {
	
	@Override
	public void onClick(View arg0) {
		// TODO Auto-generated method stub
	Intent ix=new Intent(ff3.this,m2.class)	;
	startActivity(ix);
	
	}
});
speakButton.setOnClickListener(new OnClickListener() {           
 @Override
 public void onClick(View v) {
     String text = inputText.getText().toString();
     if (text!=null && text.length()>0) {
  Toast.makeText(ff3.this, text, Toast.LENGTH_LONG).show();
  tts.speak(text, TextToSpeech.QUEUE_ADD, null);
     }
 }


    });
 
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
public void onInit(int arg0) {
	// TODO Auto-generated method stub
	
}
}