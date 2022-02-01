package com.tencent.gdtad.ipc;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import com.tencent.gdtad.aditem.GdtBaseAdItem;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import tkw;
import tll;

public class AppInstallerReceiver
  extends BroadcastReceiver
{
  private boolean KQ;
  private Map<String, GdtBaseAdItem> gG = new ConcurrentHashMap();
  
  public static AppInstallerReceiver a()
  {
    return a.a;
  }
  
  public void a(GdtBaseAdItem paramGdtBaseAdItem)
  {
    if (paramGdtBaseAdItem != null) {
      this.gG.put(paramGdtBaseAdItem.packageName, paramGdtBaseAdItem);
    }
  }
  
  public void aI(Context paramContext)
  {
    if ((!this.KQ) && (paramContext != null))
    {
      IntentFilter localIntentFilter = new IntentFilter();
      localIntentFilter.addAction("android.intent.action.PACKAGE_ADDED");
      localIntentFilter.addDataScheme("package");
      paramContext.registerReceiver(this, localIntentFilter);
      this.KQ = true;
      tkw.d("GdtAppOpenUtil", "regeist AppInstallerReceiver");
    }
  }
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    paramIntent = paramIntent.getDataString();
    if ((paramIntent != null) && (paramIntent.startsWith("package:"))) {
      paramIntent = paramIntent.substring("package:".length());
    }
    for (;;)
    {
      tkw.d("GdtAppOpenUtil", "package added " + paramIntent);
      if (this.gG.containsKey(paramIntent))
      {
        tll.a(paramContext, (GdtBaseAdItem)this.gG.get(paramIntent));
        this.gG.remove(paramIntent);
      }
      return;
    }
  }
  
  static final class a
  {
    static AppInstallerReceiver a = new AppInstallerReceiver(null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes7.jar
 * Qualified Name:     com.tencent.gdtad.ipc.AppInstallerReceiver
 * JD-Core Version:    0.7.0.1
 */