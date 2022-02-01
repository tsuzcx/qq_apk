package com.tencent.token.widget;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import com.tencent.token.qy;
import com.tencent.token.sc;
import com.tencent.token.sd;
import com.tencent.token.sd.2;
import com.tencent.token.xa;

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
        paramIntent = sc.a();
        if ((!qy.a().d()) && (!paramIntent.c()))
        {
          paramContext = sd.a(paramContext);
          paramIntent = qy.a().f();
          xa.a("start play token1");
          if (!paramContext.b)
          {
            paramContext.b = true;
            xa.a("start play token2");
            new sd.2(paramContext, paramIntent).execute(new String[] { Integer.toString(0) });
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