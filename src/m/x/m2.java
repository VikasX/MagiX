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

public class m2 extends Activity   implements OnTouchListener{
	  
	progressThread pt;
	ProgressDialog pd;
	int t, d=20, max=100;
	
	  
 
    
    
	
	
	
	@Override
	    public void onCreate(Bundle savedInstanceState) {
	        super.onCreate(savedInstanceState); 
	        
	        setContentView(R.layout.main);
	       
	      
	        
	        
	        
	        ImageView i=(ImageView)findViewById(R.id.i2);
	        i.setOnTouchListener(this); 

	        t=0;
			showDialog(t);
			
	
	}
	        
	        
 @Override
	        
	        protected Dialog onCreateDialog(int id)
	        
	        {switch(id)
	        	{
	        case 0:
	        	pd=new ProgressDialog(this);
	        	pd.setProgressStyle(ProgressDialog.STYLE_SPINNER);
	        	pd.setMessage("Loading Please Wait");
	        	pt=new progressThread(h);
	        	pt.start();
	        	return pd;
	        	
	        case 1:
	        	pd=new ProgressDialog(this);
	        	pd.setProgressStyle(ProgressDialog.STYLE_HORIZONTAL);
	        	pd.setMax(max);
	        	pd.setMessage("Loading Please Wait");
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
			public boolean onTouch(View arg0, MotionEvent arg1) {
				// TODO Auto-generated method stub
				Intent p=new Intent(m2.this,m3.class);
				startActivity(p);
				
				return true;
			}
}