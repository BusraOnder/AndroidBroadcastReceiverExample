package com.example.broadcastreceiverpermissionapp01;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.widget.Toast;


public class BroadcastingClass extends BroadcastReceiver {

	@Override
	public void onReceive(Context context, Intent intent) {

		String action = intent.getAction();

		if (action.equals("my.signal")) {

			String state = intent.getExtras().getString("isForeground");
			Log.i("BroadcastingClass", state);

			if (state.equals("0")) {

				Log.i("BroadcastingClass", "uygulama açılıyor....");

				try {

					Intent intent2 = context.getPackageManager().getLaunchIntentForPackage("com.example.broadcastreceiverpermissionapp02");
					intent2.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
					context.startActivity(intent2);

				}catch (Exception e){
					Log.i("Exception",e.getMessage());
				}


			}
		}
	}
}
