package com.tencent.securemodule.impl;

import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.os.Binder;
import android.os.IBinder;
import android.os.Parcelable;
import android.os.Process;
import com.tencent.securemodule.ac.a;
import com.tencent.securemodule.ad;
import com.tencent.securemodule.ae;
import com.tencent.securemodule.ui.SecureEventReceiver;
import com.tencent.securemodule.v;
import com.tencent.securemodule.x;

public class SecureService
  extends Service
{
  private Context a;
  private int b = 0;
  private boolean c = false;
  private boolean d = false;
  private a e = new a();
  
  public static void a(Context paramContext, String paramString)
  {
    Intent localIntent = new Intent(paramContext, SecureService.class);
    localIntent.setAction(paramString);
    paramContext.startService(localIntent);
  }
  
  private void a(String paramString, Parcelable paramParcelable)
  {
    Intent localIntent = new Intent();
    localIntent.setClass(this, SecureEventReceiver.class);
    localIntent.setAction(paramString);
    if (paramParcelable != null) {
      localIntent.putExtra("data", paramParcelable);
    }
    sendBroadcast(localIntent);
  }
  
  public IBinder onBind(Intent paramIntent)
  {
    return this.e;
  }
  
  public void onCreate()
  {
    super.onCreate();
    this.a = getApplicationContext();
  }
  
  public void onDestroy()
  {
    super.onDestroy();
  }
  
  public void onStart(Intent paramIntent, int paramInt)
  {
    super.onStart(paramIntent, paramInt);
    if ((paramIntent == null) || ("1000012".equals(paramIntent.getAction()))) {}
    while (!ac.a.a(getApplicationContext(), "sm_mq")) {
      return;
    }
    try
    {
      new Thread(new v(this, paramIntent)).start();
      return;
    }
    finally
    {
      paramIntent = finally;
      throw paramIntent;
    }
  }
  
  public boolean onUnbind(Intent paramIntent)
  {
    if (this.b == 0) {
      stopSelf();
    }
    try
    {
      Thread.sleep(500L);
      Process.killProcess(Process.myPid());
      System.exit(0);
      return super.onUnbind(paramIntent);
    }
    catch (InterruptedException localInterruptedException)
    {
      for (;;)
      {
        localInterruptedException.printStackTrace();
      }
    }
  }
  
  public final class a
    extends Binder
    implements ae
  {
    public a() {}
    
    public final void a(String paramString, ad paramad)
    {
      if (!ac.a.a(SecureService.this.getApplicationContext(), "sm_mq")) {
        return;
      }
      try
      {
        new Thread(new x(this, paramString, paramad)).start();
        return;
      }
      finally
      {
        paramString = finally;
        throw paramString;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     com.tencent.securemodule.impl.SecureService
 * JD-Core Version:    0.7.0.1
 */