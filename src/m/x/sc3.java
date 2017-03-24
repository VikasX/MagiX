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
import android.widget.TextView;
import android.widget.Toast;

public class sc3 extends Activity implements OnClickListener, OnInitListener{
	EditText txt1;
	private int MY_DATA_CHECK_CODE = 0;
    
    private TextToSpeech tts;

	double a,b;
	String x,y;
	String n1;
	String n2;TextView t;
	 @Override
	 public void onCreate(Bundle savedInstanceState) {
	     super.onCreate(savedInstanceState);
	    setContentView(R.layout.s2);
	      t=(EditText)findViewById(R.id.e1);
        
	     Button b23=(Button)findViewById(R.id.bb2);
         b23.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				Intent m=new Intent(sc3.this,sc2.class)		;
				startActivity(m);
				}
		});
         
         Button b24=(Button)findViewById(R.id.bb3);
         b24.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				Intent m=new Intent(sc3.this,MAGActivity.class)		;
				startActivity(m);
				}
		});
         
         Button b2=(Button)findViewById(R.id.bb1);
         b2.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				 String text = t.getText().toString();
			     if (text!=null && text.length()>0) {
			  Toast.makeText(sc3.this, text, Toast.LENGTH_LONG).show();
			  tts.speak(text, TextToSpeech.QUEUE_ADD, null);
			     }
			 

			     Intent p8=getIntent();
			     n1=p8.getStringExtra("num");
			     t.setText(n1);
				
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

       public void onInit(int status) {       
           if (status == TextToSpeech.SUCCESS) {
               Toast.makeText(sc3.this,
                       "Text-To-Speech engine is initialized", Toast.LENGTH_LONG).show();
       }
           else if (status == TextToSpeech.ERROR) {
               Toast.makeText(sc3.this,
                       "Error occurred while initializing Text-To-Speech engine", Toast.LENGTH_LONG).show();
           }
       }
        

	@Override
	public void onClick(View arg0) {
		// TODO Auto-generated method stub
		
	}}
