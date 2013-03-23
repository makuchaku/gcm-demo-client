package com.makulabs.gcmdemo;

import android.os.Bundle;
import android.app.Activity;
import android.util.Log;
import android.view.Menu;

import com.google.android.gcm.GCMRegistrar;

public class MainActivity extends Activity {

	static final String TAG = "GCMIntentService";
	static final String SENDER_ID = "38219521453";
	
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        GCMRegistrar.checkDevice(this);
        GCMRegistrar.checkManifest(this);
        final String regId = GCMRegistrar.getRegistrationId(this);
        if (regId.equals("")) {
          GCMRegistrar.register(this, SENDER_ID);
        } else {
          Log.v(TAG, "Already registered");
        }
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }
    
}
