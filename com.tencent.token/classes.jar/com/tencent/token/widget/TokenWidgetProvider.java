package com.tencent.token.widget;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.appwidget.AppWidgetManager;
import android.appwidget.AppWidgetProvider;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import com.tencent.token.bu;
import com.tencent.token.global.g;

public class TokenWidgetProvider
  extends AppWidgetProvider
{
  public void onDeleted(Context paramContext, int[] paramArrayOfInt)
  {
    paramArrayOfInt = AppWidgetManager.getInstance(paramContext).getAppWidgetIds(new ComponentName(paramContext, TokenWidgetProvider.class));
    g.a("widget_big num=" + paramArrayOfInt.length);
    bu.a().a(System.currentTimeMillis(), 13);
    bu.a().a(paramContext);
    if (paramArrayOfInt.length <= 0)
    {
      paramArrayOfInt = new Intent(paramContext, TokenService.class);
      PendingIntent localPendingIntent = PendingIntent.getService(paramContext, 0, paramArrayOfInt, 0);
      ((AlarmManager)paramContext.getSystemService("alarm")).cancel(localPendingIntent);
      paramContext.stopService(paramArrayOfInt);
    }
  }
  
  public void onEnabled(Context paramContext)
  {
    g.a("widget enabled");
    bu.a().a(System.currentTimeMillis(), 7);
    bu.a().a(paramContext);
    super.onEnabled(paramContext);
  }
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    super.onReceive(paramContext, paramIntent);
  }
  
  public void onUpdate(Context paramContext, AppWidgetManager paramAppWidgetManager, int[] paramArrayOfInt)
  {
    super.onUpdate(paramContext, paramAppWidgetManager, paramArrayOfInt);
    try
    {
      paramContext.startService(new Intent(paramContext, TokenService.class));
      return;
    }
    catch (Exception paramContext)
    {
      paramContext.printStackTrace();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.widget.TokenWidgetProvider
 * JD-Core Version:    0.7.0.1
 */