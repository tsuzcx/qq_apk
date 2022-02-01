package com.tencent.qmsp.sdk.g.a;

import android.content.ComponentName;
import android.content.ServiceConnection;
import android.os.IBinder;
import com.tencent.qmsp.sdk.base.c;

class d$a
  implements ServiceConnection
{
  d$a(d paramd) {}
  
  public void onServiceConnected(ComponentName paramComponentName, IBinder paramIBinder)
  {
    c.a("HSDID did service binded");
    this.a.c = a.a.a(paramIBinder);
    d.a(this.a, true);
  }
  
  public void onServiceDisconnected(ComponentName paramComponentName)
  {
    d.a(this.a, false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qmsp.sdk.g.a.d.a
 * JD-Core Version:    0.7.0.1
 */