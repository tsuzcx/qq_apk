package com.tencent.token.widget;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.tencent.token.ag;
import com.tencent.token.ah;
import com.tencent.token.ai;

public class WidgetReceiver
  extends BroadcastReceiver
{
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    paramIntent = paramIntent.getAction();
    if ("android.intent.action.SCREEN_ON".equals(paramIntent)) {
      paramContext.startService(new Intent(paramContext, TokenService.class));
    }
    ah localah;
    do
    {
      do
      {
        return;
        if ("android.intent.action.SCREEN_OFF".equals(paramIntent))
        {
          paramIntent = PendingIntent.getService(paramContext, 0, new Intent(paramContext, TokenService.class), 0);
          ((AlarmManager)paramContext.getSystemService("alarm")).cancel(paramIntent);
          return;
        }
      } while (!paramIntent.equals("com.tencent.token.widget.SPEECH"));
      paramIntent = ag.c();
      localah = ah.a();
    } while ((paramIntent.g()) || (localah.c()));
    ai.a(paramContext).a(paramIntent.l());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.widget.WidgetReceiver
 * JD-Core Version:    0.7.0.1
 */