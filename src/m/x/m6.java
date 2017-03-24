package m.x;



import android.app.Activity;
import android.app.Dialog;
import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.view.View.OnTouchListener;

import android.widget.ImageView;
import android.widget.TextView;

public class m6 extends Activity implements OnTouchListener{

	TextView tex1,tex2;
	String n1;
	String n2;
	String n3;
	progressThread pt;
	ProgressDialog pd;
	int t, d=10, max=100;
	@Override
	    public void onCreate(Bundle savedInstanceState) {
	        super.onCreate(savedInstanceState); 
	        setContentView(R.layout.mag5);
	        
	        ImageView i22=(ImageView)findViewById(R.id.i2);
	        ImageView i33=(ImageView)findViewById(R.id.i3);
	        ImageView i11=(ImageView)findViewById(R.id.i1);

	        tex2=(TextView)findViewById(R.id.t2);
	        
		      
	        t=0;
			showDialog(t); 
	            
	
	
	
     i22.setOnTouchListener(new OnTouchListener() {
			
			@Override
			public boolean onTouch(View v, MotionEvent event) {
				// TODO Auto-generated method stub
				Intent p6=new Intent(m6.this,m4.class);
				startActivity(p6);
				
				return true;
			}
		});
     i33.setOnTouchListener(new OnTouchListener() {
			
			@Override
			public boolean onTouch(View v, MotionEvent event) {
				// TODO Auto-generated method stub
				Intent p=new Intent(m6.this,MAGActivity.class);
				startActivity(p);
				
				return true;
			}
		});
	
	
	
     i11.setOnTouchListener(new OnTouchListener() {
			
			@Override
			public boolean onTouch(View v, MotionEvent event) {
				// TODO Auto-generated method stub

			     Intent p8=getIntent();
			     n1=p8.getStringExtra("num");
			     tex2.setText(n1);
				
				return true;
			}
		});
	
	
	
	
	
	
	
	
	
	
	}
	
	
	
	
	
			 @Override
		      
		      protected Dialog onCreateDialog(int id)
		      
		      {switch(id)
		      	{
		      case 0:
		      	pd=new ProgressDialog(this);
		      	pd.setProgressStyle(ProgressDialog.STYLE_SPINNER);
		      	pd.setMessage("Loading");
		      	pt=new progressThread(h);
		      	pt.start();
		      	return pd;
		      	
		      case 1:
		      	pd=new ProgressDialog(this);
		      	pd.setProgressStyle(ProgressDialog.STYLE_HORIZONTAL);
		      	pd.setMax(max);
		      	pd.setMessage("Loading bar");
		      	pt=new progressThread(h);
		      	pt.start();
		      	return pd;
		      	
		      	default:
		      		return null; }
		      }

		   final Handler h=new Handler(){
		  	 public void handleMessage(Message ms)
		  	 {int tt=ms.getData().getInt("total");
		  	 pd.setProgress(tt);
		  	 if(tt<=0)
		  	 {
		  		 dismissDialog(t);
		  		 		 pt.setState(progressThread.DONE);
		  	 }}};
		  	 
		  	private class progressThread extends Thread
		  	{
		  		final static int DONE=0;
		  		final static int RUNNING=0;
		  		
		  		Handler mh;
		  		int mstate,total;
		  		progressThread(Handler h)
		  		{
		  		mh=h;}
		  	
		  	
		  	

		  	@Override
		  	public void run()
		  	{
		  		mstate=RUNNING;
		  		total=max;
		  		while (mstate==RUNNING)
		  		{ try
		  		{Thread.sleep(d);
		  		}
		  		catch(InterruptedException e)
		  		{
		  			Log.e("error", "Thread interupt");
		  		}
		  	
		  		Message msg=mh.obtainMessage();
		  		Bundle b=new Bundle();
		          b.putInt("total",total) ;
		          msg.setData(b);
		          mh.sendMessage(msg);
		          total--;
		  		}}
		  	
		  	
		  	public void setState(int s) {
		  		// TODO Auto-generated method stub
		  	mstate=s;
		  	}
		  	
	
	
	
	
	}
	
	        
	        
	        
	        
	        
	        
	        
	        
	        
	        
	        
	        
	        
	        
	        
	        
	        
	        
	        @Override
	public boolean onTouch(View v, MotionEvent event) {
		// TODO Auto-generated method stub
		return false;
	}}