package com.tencent.turingfd.sdk.base;

import android.content.ComponentName;
import android.content.ServiceConnection;
import android.os.IBinder;
import java.util.concurrent.atomic.AtomicReference;

public class cd
  implements ServiceConnection
{
  public cd(cj paramcj, AtomicReference paramAtomicReference1, AtomicReference paramAtomicReference2, Object paramObject) {}
  
  public void onServiceConnected(ComponentName arg1, IBinder paramIBinder)
  {
    this.a.set(paramIBinder);
    this.b.set(this);
    try
    {
      synchronized (this.c)
      {
        this.c.notifyAll();
        label30:
        return;
      }
    }
    catch (Throwable paramIBinder)
    {
      break label30;
    }
  }
  
  public void onServiceDisconnected(ComponentName paramComponentName) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.turingfd.sdk.base.cd
 * JD-Core Version:    0.7.0.1
 */