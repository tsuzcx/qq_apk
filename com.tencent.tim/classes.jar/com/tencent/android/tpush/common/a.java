package com.tencent.android.tpush.common;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import com.tencent.android.tpush.logging.TLogger;
import com.tencent.tpns.baseapi.base.util.CommonWorkingThread;

public class a
{
  private static volatile b a = null;
  
  public static void a(Context paramContext)
  {
    try
    {
      if (a == null) {
        try
        {
          if (a == null)
          {
            a = new b(null);
            IntentFilter localIntentFilter = new IntentFilter();
            localIntentFilter.addDataScheme("package");
            localIntentFilter.addAction("android.intent.action.PACKAGE_ADDED");
            localIntentFilter.addAction("android.intent.action.PACKAGE_REMOVED");
            localIntentFilter.addAction("android.intent.action.PACKAGE_REPLACED");
            BroadcastAgent.registerReceiver(paramContext, a, localIntentFilter);
          }
          return;
        }
        finally {}
      }
      return;
    }
    catch (Throwable paramContext)
    {
      TLogger.e("AppChangesHandler", "AppChangesHandler setupHandler error", paramContext);
    }
  }
  
  static class a
    implements Runnable
  {
    private Context a = null;
    private Intent b = null;
    
    public a(Context paramContext, Intent paramIntent)
    {
      this.a = paramContext;
      this.b = paramIntent;
    }
    
    public void run()
    {
      String str = this.b.getAction();
      if (str == null) {}
      while ((!"android.intent.action.PACKAGE_ADDED".equals(str)) && (!"android.intent.action.PACKAGE_REPLACED".equals(str)) && (!"android.intent.action.PACKAGE_REMOVED".equals(str))) {
        return;
      }
      TLogger.d("AppChangesHandler", "action:" + str);
    }
  }
  
  static class b
    extends BroadcastReceiver
  {
    public void onReceive(Context paramContext, Intent paramIntent)
    {
      if ((paramIntent != null) && (paramContext != null)) {
        CommonWorkingThread.getInstance().execute(new a.a(paramContext, paramIntent));
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.android.tpush.common.a
 * JD-Core Version:    0.7.0.1
 */