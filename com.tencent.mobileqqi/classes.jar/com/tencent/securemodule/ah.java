package com.tencent.securemodule;

import android.content.ComponentName;
import android.content.ServiceConnection;
import android.os.IBinder;
import com.tencent.securemodule.ui.TransparentActivity;

public final class ah
  implements ServiceConnection
{
  public ah(TransparentActivity paramTransparentActivity) {}
  
  public final void onServiceConnected(ComponentName paramComponentName, IBinder paramIBinder)
  {
    TransparentActivity.a(this.a, (ae)paramIBinder);
  }
  
  public final void onServiceDisconnected(ComponentName paramComponentName)
  {
    TransparentActivity.a(this.a, null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     com.tencent.securemodule.ah
 * JD-Core Version:    0.7.0.1
 */