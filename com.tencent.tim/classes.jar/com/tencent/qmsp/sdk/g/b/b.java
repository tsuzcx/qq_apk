package com.tencent.qmsp.sdk.g.b;

import android.content.ComponentName;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.util.Log;
import java.util.concurrent.LinkedBlockingQueue;

public final class b
  implements ServiceConnection
{
  public boolean a = false;
  public final LinkedBlockingQueue b = new LinkedBlockingQueue(1);
  
  public final void onServiceConnected(ComponentName paramComponentName, IBinder paramIBinder)
  {
    try
    {
      paramComponentName = new StringBuilder();
      Log.d("PPSSerivceConnection", "onServiceConnected " + System.currentTimeMillis());
      this.b.put(paramIBinder);
      return;
    }
    catch (InterruptedException paramComponentName)
    {
      Log.w("PPSSerivceConnection", "onServiceConnected InterruptedException " + System.currentTimeMillis());
    }
  }
  
  public final void onServiceDisconnected(ComponentName paramComponentName)
  {
    Log.d("PPSSerivceConnection", "onServiceDisconnected " + System.currentTimeMillis());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qmsp.sdk.g.b.b
 * JD-Core Version:    0.7.0.1
 */