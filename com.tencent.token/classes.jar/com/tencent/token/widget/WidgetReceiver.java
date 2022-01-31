package com.tencent.token.widget;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.tencent.token.cx;
import com.tencent.token.cy;
import com.tencent.token.cz;

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
    }
    catch (Exception paramContext)
    {
      paramContext.printStackTrace();
      return;
    }
    if (paramIntent.equals("com.tencent.token.widget.SPEECH"))
    {
      paramIntent = cx.c();
      cy localcy = cy.a();
      if ((!paramIntent.g()) && (!localcy.c())) {
        cz.a(paramContext).a(paramIntent.l(), 0);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.widget.WidgetReceiver
 * JD-Core Version:    0.7.0.1
 */