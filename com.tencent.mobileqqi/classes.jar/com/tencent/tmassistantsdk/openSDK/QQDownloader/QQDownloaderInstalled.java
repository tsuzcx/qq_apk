package com.tencent.tmassistantsdk.openSDK.QQDownloader;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Handler;
import android.os.HandlerThread;
import com.tencent.tmassistantsdk.f.j;

public class QQDownloaderInstalled
  extends BroadcastReceiver
{
  private static QQDownloaderInstalled b = null;
  protected c a = null;
  private boolean c = false;
  private HandlerThread d = new HandlerThread("QQDownloaderInstalled");
  private Handler e = null;
  
  private QQDownloaderInstalled()
  {
    this.d.start();
    this.e = new Handler(this.d.getLooper());
  }
  
  public static QQDownloaderInstalled a()
  {
    try
    {
      if (b == null) {
        b = new QQDownloaderInstalled();
      }
      QQDownloaderInstalled localQQDownloaderInstalled = b;
      return localQQDownloaderInstalled;
    }
    finally {}
  }
  
  public final void a(Context paramContext)
  {
    IntentFilter localIntentFilter;
    if (!this.c)
    {
      j.b("QQDownloaderInstalled", "registeReceiver   context" + paramContext + "  receiver:" + this);
      localIntentFilter = new IntentFilter("com.tencent.assistant.ipc.firststart.action");
    }
    try
    {
      paramContext = paramContext.registerReceiver(this, localIntentFilter);
      j.b("QQDownloaderInstalled", paramContext);
      this.c = true;
      return;
    }
    catch (Throwable paramContext)
    {
      j.b("QQDownloaderInstalled", "registeReceiver exception!!!");
      this.c = false;
      paramContext.printStackTrace();
    }
  }
  
  public final void a(c paramc)
  {
    this.a = paramc;
  }
  
  public final void b()
  {
    this.a = null;
  }
  
  public final void b(Context paramContext)
  {
    if ((paramContext == null) || (b == null)) {}
    while (!this.c) {
      return;
    }
    j.b("QQDownloaderInstalled", "realy unRegisteReceiver  context:" + paramContext + "  receiver:" + this);
    try
    {
      paramContext.unregisterReceiver(this);
      this.c = false;
      return;
    }
    catch (Throwable paramContext)
    {
      j.b("QQDownloaderInstalled", "unRegisteReceiver exception!!!");
      this.c = false;
      paramContext.printStackTrace();
    }
  }
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    j.b("QQDownloaderInstalled", "onReceive!");
    if (this.e != null) {
      this.e.post(new b(this, paramContext));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     com.tencent.tmassistantsdk.openSDK.QQDownloader.QQDownloaderInstalled
 * JD-Core Version:    0.7.0.1
 */