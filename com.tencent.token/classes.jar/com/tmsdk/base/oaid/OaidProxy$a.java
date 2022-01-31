package com.tmsdk.base.oaid;

import android.content.ComponentName;
import android.content.ServiceConnection;
import android.os.IBinder;
import java.util.concurrent.LinkedBlockingQueue;

final class OaidProxy$a
  implements ServiceConnection
{
  boolean A = false;
  private final LinkedBlockingQueue B = new LinkedBlockingQueue(1);
  
  public IBinder getBinder()
  {
    if (this.A) {
      return null;
    }
    this.A = true;
    try
    {
      IBinder localIBinder = (IBinder)this.B.take();
      return localIBinder;
    }
    catch (Throwable localThrowable) {}
    return null;
  }
  
  public void onServiceConnected(ComponentName paramComponentName, IBinder paramIBinder)
  {
    try
    {
      this.B.put(paramIBinder);
      return;
    }
    catch (Throwable paramComponentName) {}
  }
  
  public void onServiceDisconnected(ComponentName paramComponentName) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tmsdk.base.oaid.OaidProxy.a
 * JD-Core Version:    0.7.0.1
 */