package m.x
;

import m.x.R;
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


public class ff2 extends Activity implements OnInitListener {
    /** Called when the activity is first created. */
	  private int MY_DATA_CHECK_CODE = 0;
	     
      private TextToSpeech tts;
  
  private EditText inputText;
  private Button speakButton;
   
@Override
public void onCreate(Bundle savedInstanceState) {
   
super.onCreate(savedInstanceState);
setContentView(R.layout.f2);

Button bx=(Button)findViewById(R.id.bx1);

inputText = (EditText) findViewById(R.id.t1);
speakButton = (Button) findViewById(R.id.b1);
 bx.setOnClickListener(new OnClickListener() {
	
	@Override
	public void onClick(View arg0) {
		// TODO Auto-generated method stub
	Intent ix=new Intent(ff2.this,sc2.class)	;
	startActivity(ix);
	
	}
});
}
public void onInit(int arg0) {
	// TODO Auto-generated method stub
	
}
}