package com.tencent.trackrecordlib.g;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import com.tencent.trackrecordlib.core.c;

public class f
{
  private static final String a = f.class.getSimpleName();
  private static BroadcastReceiver b;
  
  public static void a(Context paramContext)
  {
    if (paramContext == null) {
      return;
    }
    b = new a(null);
    IntentFilter localIntentFilter = new IntentFilter("android.intent.action.CLOSE_SYSTEM_DIALOGS");
    paramContext.registerReceiver(b, localIntentFilter);
  }
  
  public static void b(Context paramContext)
  {
    if ((paramContext != null) && (b != null)) {
      paramContext.unregisterReceiver(b);
    }
  }
  
  static class a
    extends BroadcastReceiver
  {
    final String a = "reason";
    final String b = "recentapps";
    final String c = "homekey";
    
    public void onReceive(Context paramContext, Intent paramIntent)
    {
      if ("android.intent.action.CLOSE_SYSTEM_DIALOGS".equals(paramIntent.getAction()))
      {
        paramContext = paramIntent.getStringExtra("reason");
        if (paramContext != null)
        {
          if (!paramContext.equals("homekey")) {
            break label39;
          }
          c.a().d();
        }
      }
      label39:
      while (!paramContext.equals("recentapps")) {
        return;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes12.jar
 * Qualified Name:     com.tencent.trackrecordlib.g.f
 * JD-Core Version:    0.7.0.1
 */