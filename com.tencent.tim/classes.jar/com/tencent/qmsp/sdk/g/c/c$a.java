package com.tencent.qmsp.sdk.g.c;

import android.content.ComponentName;
import android.content.ServiceConnection;
import android.os.IBinder;

class c$a
  implements ServiceConnection
{
  c$a(c paramc) {}
  
  public void onServiceConnected(ComponentName paramComponentName, IBinder paramIBinder)
  {
    try
    {
      this.a.b = a.a.a(paramIBinder);
      if (this.a.d != null) {
        this.a.d.a(this.a);
      }
      paramComponentName = this.a;
      c.a(paramComponentName, "Service onServiceConnected");
      return;
    }
    finally {}
  }
  
  public void onServiceDisconnected(ComponentName paramComponentName)
  {
    paramComponentName = this.a;
    paramComponentName.b = null;
    c.a(paramComponentName, "Service onServiceDisconnected");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qmsp.sdk.g.c.c.a
 * JD-Core Version:    0.7.0.1
 */