package com.tencent.tmassistantsdk.internal.openSDK.QQDownloader;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import com.tencent.tmassistantbase.util.ab;

public class QQDownloaderInstalled
  extends BroadcastReceiver
{
  protected static final String a = QQDownloaderInstalled.class.getSimpleName();
  protected static QQDownloaderInstalled b = null;
  protected boolean c = false;
  protected d d = null;
  
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
  
  public void a(Context paramContext)
  {
    ab.c(a, "context = " + paramContext);
    IntentFilter localIntentFilter;
    if (!this.c)
    {
      ab.c("QQDownloaderInstalled", "registeReceiver   context" + paramContext + "  receiver:" + this);
      localIntentFilter = new IntentFilter("com.tencent.assistant.ipc.firststart.action");
    }
    try
    {
      paramContext = paramContext.registerReceiver(this, localIntentFilter);
      ab.c("QQDownloaderInstalled", "" + paramContext);
      this.c = true;
      return;
    }
    catch (Throwable paramContext)
    {
      ab.c("QQDownloaderInstalled", "registeReceiver exception!!!");
      this.c = false;
      paramContext.printStackTrace();
    }
  }
  
  public void a(d paramd)
  {
    ab.c(a, "listener = " + paramd);
    this.d = paramd;
  }
  
  public void b()
  {
    ab.c(a, "unregisteListener start");
    this.d = null;
  }
  
  public void b(Context paramContext)
  {
    if ((paramContext == null) || (b == null)) {
      ab.c(a, "unRegisteReceiver fail! context = " + paramContext + ",mInstance = " + b);
    }
    while (!this.c) {
      return;
    }
    ab.c("QQDownloaderInstalled", "realy unRegisteReceiver  context:" + paramContext + "  receiver:" + this);
    try
    {
      paramContext.unregisterReceiver(this);
      this.c = false;
      return;
    }
    catch (Throwable paramContext)
    {
      ab.c("QQDownloaderInstalled", "unRegisteReceiver exception!!!");
      this.c = false;
      paramContext.printStackTrace();
    }
  }
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    ab.c("QQDownloaderInstalled", "onReceive!");
    new c(this, paramContext).start();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes12.jar
 * Qualified Name:     com.tencent.tmassistantsdk.internal.openSDK.QQDownloader.QQDownloaderInstalled
 * JD-Core Version:    0.7.0.1
 */