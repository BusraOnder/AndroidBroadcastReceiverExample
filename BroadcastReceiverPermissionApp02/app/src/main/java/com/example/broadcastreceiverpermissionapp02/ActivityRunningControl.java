package com.example.broadcastreceiverpermissionapp02;

import android.app.ActivityManager;
import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.os.IBinder;
import android.util.Log;

import androidx.annotation.Nullable;

import java.util.List;

public class ActivityRunningControl extends Service {

	@Override
	public void onCreate() {
		super.onCreate();



		new Thread(new Runnable() {
			@Override
			public void run() {

				String isForeground ="1";

				while (true){

					try {
						Log.i("ActivityRunningControl","start");
						Thread.sleep(5000); // Her döngümde Thread'ımı 5000 ms uyutuyorum.

						ActivityManager.RunningAppProcessInfo myProcess = new ActivityManager.RunningAppProcessInfo();
						ActivityManager.getMyMemoryState(myProcess);

						if (myProcess.importance == ActivityManager.RunningAppProcessInfo.IMPORTANCE_FOREGROUND){
							isForeground = "1";
						}else{
							isForeground = "0";
						}


						Intent signal = new Intent("my.signal");
						signal.putExtra("isForeground",isForeground);
						sendBroadcast(signal,"my.permission");

					}catch (Exception e){
						Log.i("serviceAppcontrol Exc",e.getMessage());
					}
				}
			}
		}).start();

	}


	@Nullable
	@Override
	public IBinder onBind(Intent intent) {
		return null;
	}
}
