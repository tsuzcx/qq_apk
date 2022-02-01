package com.tencent.token.widget;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import com.tencent.token.rt;
import com.tencent.token.sw;
import com.tencent.token.sx;
import com.tencent.token.sx.2;
import com.tencent.token.xv;

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
        paramIntent = sw.a();
        if ((!rt.a().d()) && (!paramIntent.c()))
        {
          paramContext = sx.a(paramContext);
          paramIntent = rt.a().f();
          xv.a("start play token1");
          if (!paramContext.b)
          {
            paramContext.b = true;
            xv.a("start play token2");
            new sx.2(paramContext, paramIntent).execute(new String[] { Integer.toString(0) });
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