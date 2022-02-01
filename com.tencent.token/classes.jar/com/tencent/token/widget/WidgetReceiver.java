package com.tencent.token.widget;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import com.tencent.token.rf;
import com.tencent.token.sk;
import com.tencent.token.sl;
import com.tencent.token.sl.2;
import com.tencent.token.xj;

public class WidgetReceiver
  extends BroadcastReceiver
{
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    try
    {
      paramIntent = paramIntent.getAction();
      if ("android.intent.action.SCREEN_ON".equals(paramIntent))
      {
        paramContext.startService(new Intent(paramContext, TokenService.class));
        return;
      }
      if ("android.intent.action.SCREEN_OFF".equals(paramIntent))
      {
        paramIntent = PendingIntent.getService(paramContext, 0, new Intent(paramContext, TokenService.class), 0);
        ((AlarmManager)paramContext.getSystemService("alarm")).cancel(paramIntent);
        return;
      }
      if ("com.tencent.token.widget.SPEECH".equals(paramIntent))
      {
        paramIntent = sk.a();
        if ((!rf.a().d()) && (!paramIntent.c()))
        {
          paramContext = sl.a(paramContext);
          paramIntent = rf.a().f();
          xj.a("start play token1");
          if (!paramContext.b)
          {
            paramContext.b = true;
            xj.a("start play token2");
            new sl.2(paramContext, paramIntent).execute(new String[] { Integer.toString(0) });
          }
        }
      }
      return;
    }
    catch (Exception paramContext)
    {
      paramContext.printStackTrace();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.widget.WidgetReceiver
 * JD-Core Version:    0.7.0.1
 */