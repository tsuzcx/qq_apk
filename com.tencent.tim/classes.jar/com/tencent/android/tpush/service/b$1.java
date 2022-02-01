package com.tencent.android.tpush.service;

import android.content.ComponentName;
import android.content.ServiceConnection;
import android.os.IBinder;
import com.tencent.android.tpush.logging.TLogger;

final class b$1
  implements ServiceConnection
{
  public void onServiceConnected(ComponentName paramComponentName, IBinder paramIBinder)
  {
    b.a(true);
    TLogger.d("PushServiceManager", "XGPushService onServiceConnected");
  }
  
  public void onServiceDisconnected(ComponentName paramComponentName)
  {
    b.a(false);
    TLogger.d("PushServiceManager", "XGPushService onServiceDisconnected");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.android.tpush.service.b.1
 * JD-Core Version:    0.7.0.1
 */