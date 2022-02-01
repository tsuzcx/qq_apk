package com.tencent.qmsp.sdk.g.h;

import android.content.ComponentName;
import android.content.ServiceConnection;
import android.os.IBinder;
import com.tencent.qmsp.sdk.base.c;

class b$a
  implements ServiceConnection
{
  b$a(b paramb) {}
  
  public void onServiceConnected(ComponentName paramComponentName, IBinder paramIBinder)
  {
    try
    {
      this.a.d = a.a.a(paramIBinder);
      if (this.a.a != null) {
        this.a.a.a(this.a);
      }
      paramComponentName = new StringBuilder().append(b.f);
      c.c(" Service onServiceConnected");
      return;
    }
    finally {}
  }
  
  public void onServiceDisconnected(ComponentName paramComponentName)
  {
    this.a.d = null;
    c.c(b.f + " Service onServiceDisconnected");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qmsp.sdk.g.h.b.a
 * JD-Core Version:    0.7.0.1
 */