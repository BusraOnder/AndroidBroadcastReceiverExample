package com.example.broadcastreceiverpermissionapp01;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;

public class MainActivity extends AppCompatActivity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		try {

			Intent intent2 = getApplicationContext().getPackageManager().getLaunchIntentForPackage("com.example.broadcastreceiverpermissionapp02");
			intent2.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
			startActivity(intent2);

		}catch (Exception e){
			Log.i("Exception",e.getMessage());
		}

	}
}