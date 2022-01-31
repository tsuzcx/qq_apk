package com.tencent.tmassistantsdk.openSDK.QQDownloader;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import com.tencent.tmassistantsdk.f.k;

public class QQDownloaderInstalled
  extends BroadcastReceiver
{
  private static QQDownloaderInstalled b = null;
  protected c a = null;
  private boolean c = false;
  
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
      k.b("QQDownloaderInstalled", "registeReceiver   context" + paramContext + "  receiver:" + this);
      localIntentFilter = new IntentFilter("com.tencent.assistant.ipc.firststart.action");
    }
    try
    {
      paramContext = paramContext.registerReceiver(this, localIntentFilter);
      k.b("QQDownloaderInstalled", paramContext);
      this.c = true;
      return;
    }
    catch (Throwable paramContext)
    {
      k.b("QQDownloaderInstalled", "registeReceiver exception!!!");
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
    k.b("QQDownloaderInstalled", "realy unRegisteReceiver  context:" + paramContext + "  receiver:" + this);
    try
    {
      paramContext.unregisterReceiver(this);
      this.c = false;
      return;
    }
    catch (Throwable paramContext)
    {
      k.b("QQDownloaderInstalled", "unRegisteReceiver exception!!!");
      this.c = false;
      paramContext.printStackTrace();
    }
  }
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    k.b("QQDownloaderInstalled", "onReceive!");
    new b(this, paramContext).start();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     com.tencent.tmassistantsdk.openSDK.QQDownloader.QQDownloaderInstalled
 * JD-Core Version:    0.7.0.1
 */