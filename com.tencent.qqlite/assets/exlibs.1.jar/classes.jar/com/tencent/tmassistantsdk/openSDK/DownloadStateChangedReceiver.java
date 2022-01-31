package com.tencent.tmassistantsdk.openSDK;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Handler;
import android.os.HandlerThread;
import com.tencent.tmassistantsdk.f.k;
import java.util.ArrayList;

public class DownloadStateChangedReceiver
  extends BroadcastReceiver
{
  private static DownloadStateChangedReceiver b = null;
  ArrayList a = new ArrayList();
  private HandlerThread c = new HandlerThread("downloadStateChangedThread");
  private Handler d = null;
  private boolean e = false;
  
  public DownloadStateChangedReceiver()
  {
    this.c.start();
    this.d = new Handler(this.c.getLooper());
  }
  
  public static DownloadStateChangedReceiver a()
  {
    try
    {
      if (b == null) {
        b = new DownloadStateChangedReceiver();
      }
      DownloadStateChangedReceiver localDownloadStateChangedReceiver = b;
      return localDownloadStateChangedReceiver;
    }
    finally {}
  }
  
  public final void a(Context paramContext)
  {
    IntentFilter localIntentFilter;
    if (!this.e)
    {
      k.b("DownloadStateChangedReceiver", "registeReceiver   context" + paramContext + "  receiver:" + this);
      localIntentFilter = new IntentFilter("com.tencent.assistantOpenSDK.downloadStateChange.action");
    }
    try
    {
      paramContext = paramContext.registerReceiver(this, localIntentFilter);
      k.b("DownloadStateChangedReceiver", paramContext);
      this.e = true;
      return;
    }
    catch (Throwable paramContext)
    {
      k.b("DownloadStateChangedReceiver", "registeReceiver exception!!!");
      this.e = false;
      paramContext.printStackTrace();
    }
  }
  
  public final void a(b paramb)
  {
    if ((paramb != null) && (!this.a.contains(paramb))) {
      this.a.add(paramb);
    }
  }
  
  public final void b(Context paramContext)
  {
    if ((paramContext == null) || (b == null)) {}
    while (!this.e) {
      return;
    }
    k.b("DownloadStateChangedReceiver", "realy unRegisteReceiver  context:" + paramContext + "  receiver:" + this);
    try
    {
      paramContext.unregisterReceiver(this);
      this.e = false;
      return;
    }
    catch (Throwable paramContext)
    {
      k.b("DownloadStateChangedReceiver", "unRegisteReceiver exception!!!");
      this.e = false;
      paramContext.printStackTrace();
    }
  }
  
  public final void b(b paramb)
  {
    if (paramb != null) {
      this.a.remove(paramb);
    }
  }
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    if (this.d != null) {
      this.d.post(new a(this, paramIntent));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     com.tencent.tmassistantsdk.openSDK.DownloadStateChangedReceiver
 * JD-Core Version:    0.7.0.1
 */