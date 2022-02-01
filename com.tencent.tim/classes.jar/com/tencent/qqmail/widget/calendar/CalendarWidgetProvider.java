package com.tencent.qqmail.widget.calendar;

import android.app.PendingIntent;
import android.appwidget.AppWidgetManager;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.RemoteViews;
import com.tencent.qqmail.QMApplicationContext;
import com.tencent.qqmail.calendar.model.QMCalendarManager;
import com.tencent.qqmail.calendar.util.QMLunarCalendarUtils;
import com.tencent.qqmail.utilities.log.QMLog;
import com.tencent.qqmail.utilities.sharedpreference.SharedPreferenceUtil;
import com.tencent.qqmail.widget.QMWidgetProvider;
import com.tencent.qqmail.widget.QMWidgetService;
import com.tencent.qqmail.widget.WidgetEventService;
import com.tencent.qqmail.widget.WidgetGesturePswActivity;
import java.util.Arrays;
import java.util.Calendar;

public class CalendarWidgetProvider
  extends QMWidgetProvider
{
  private static final String TAG = "CalendarWidgetProvider";
  private static RemoteViews remoteViews;
  
  public RemoteViews buildLayout(Context paramContext, int paramInt)
  {
    remoteViews = new RemoteViews(paramContext.getPackageName(), 2131563351);
    Object localObject = new Intent(paramContext, WidgetEventService.class);
    ((Intent)localObject).putExtra("WIDGET_TYPE", 2);
    ((Intent)localObject).putExtra("EVENT_TYPE", 9);
    localObject = PendingIntent.getService(paramContext, paramInt + 2002, (Intent)localObject, 134217728);
    remoteViews.setOnClickPendingIntent(2131364172, (PendingIntent)localObject);
    localObject = new Intent(paramContext, WidgetEventService.class);
    ((Intent)localObject).putExtra("WIDGET_TYPE", 2);
    ((Intent)localObject).putExtra("EVENT_TYPE", 8);
    localObject = PendingIntent.getService(paramContext, paramInt + 2001, (Intent)localObject, 134217728);
    remoteViews.setOnClickPendingIntent(2131362235, (PendingIntent)localObject);
    localObject = QMWidgetService.createIntentForCalendarWidget(paramContext, paramInt);
    remoteViews.setRemoteAdapter(paramInt, 2131364161, (Intent)localObject);
    localObject = new Intent(paramContext, WidgetEventService.class);
    ((Intent)localObject).putExtra("appWidgetId", paramInt);
    ((Intent)localObject).putExtra("WIDGET_TYPE", 2);
    paramContext = PendingIntent.getService(paramContext, paramInt, (Intent)localObject, 134217728);
    remoteViews.setPendingIntentTemplate(2131364161, paramContext);
    return remoteViews;
  }
  
  public Intent createGesturePswIntent(Context paramContext)
  {
    return WidgetGesturePswActivity.createCalendarWidgetGesturePswIntent(paramContext);
  }
  
  public String generateTitleOnlySolar()
  {
    return Calendar.getInstance().get(2) + "月" + Calendar.getInstance().get(5) + "日";
  }
  
  public String generateTitleWithLunar()
  {
    String str1 = Calendar.getInstance().get(2) + 1 + "月" + Calendar.getInstance().get(5) + "日";
    String str2 = QMLunarCalendarUtils.getLunarDate(System.currentTimeMillis(), false);
    return str1 + "  " + str2;
  }
  
  public void onAppWidgetOptionsChanged(Context paramContext, AppWidgetManager paramAppWidgetManager, int paramInt, Bundle paramBundle)
  {
    super.onAppWidgetOptionsChanged(paramContext, paramAppWidgetManager, paramInt, paramBundle);
    int i = paramBundle.getInt("appWidgetMinWidth");
    int j = CalendarWidgetManager.getInstance().getWidgetSize(i);
    CalendarWidgetManager.getInstance().putSizeWithID(paramInt, j);
    QMLog.log(4, "CalendarWidgetProvider", "onAppWidgetOptionsChanged widgetSize = " + j);
    QMLog.log(4, "CalendarWidgetProvider", "onAppWidgetOptionsChanged widget_min_height = " + paramBundle.getInt("appWidgetMinHeight"));
    QMLog.log(4, "CalendarWidgetProvider", "onAppWidgetOptionsChanged widget_min_width = " + i);
    if (remoteViews == null) {
      return;
    }
    if (j <= 2)
    {
      remoteViews.setTextViewText(2131364175, generateTitleOnlySolar());
      AppWidgetManager.getInstance(QMApplicationContext.sharedInstance()).updateAppWidget(new ComponentName(QMApplicationContext.sharedInstance(), CalendarWidgetProvider.class), remoteViews);
      return;
    }
    remoteViews.setTextViewText(2131364175, generateTitleWithLunar());
    AppWidgetManager.getInstance(QMApplicationContext.sharedInstance()).updateAppWidget(new ComponentName(QMApplicationContext.sharedInstance(), CalendarWidgetProvider.class), remoteViews);
  }
  
  public void onDisabled(Context paramContext)
  {
    super.onDisabled(paramContext);
    SharedPreferenceUtil.setEnableCalendarWidget(false);
    CalendarWidgetManager.getInstance().release();
  }
  
  public void onEnabled(Context paramContext)
  {
    super.onEnabled(paramContext);
    CalendarWidgetManager.getInstance();
  }
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    super.onReceive(paramContext, paramIntent);
    if (paramIntent != null) {
      for (;;)
      {
        try
        {
          if (paramIntent.getAction() == null) {
            return;
          }
          paramContext = paramIntent.getAction();
          QMLog.log(4, "CalendarWidgetProvider", "onReceive action = " + paramContext);
          if (!"com.tencent.qqmail.widget.calendar.refresh.ui".equals(paramContext)) {
            break;
          }
          if (remoteViews == null)
          {
            paramContext = "remoteViews = null";
            Log.i("CalendarWidgetProvider", paramContext);
            if (remoteViews == null) {
              break;
            }
            Log.i("CalendarWidgetProvider", "Try to update title");
            remoteViews.setTextViewText(2131364175, generateTitleWithLunar());
            AppWidgetManager.getInstance(QMApplicationContext.sharedInstance()).updateAppWidget(new ComponentName(QMApplicationContext.sharedInstance(), CalendarWidgetProvider.class), remoteViews);
            return;
          }
        }
        catch (Exception paramContext)
        {
          paramContext.printStackTrace();
          return;
        }
        paramContext = "remoteViews != null";
      }
    }
  }
  
  public void onUpdate(Context paramContext, AppWidgetManager paramAppWidgetManager, int[] paramArrayOfInt)
  {
    super.onUpdate(paramContext, paramAppWidgetManager, paramArrayOfInt);
    QMLog.log(4, "CalendarWidgetProvider", "onUpdate appWidgetIds = " + Arrays.toString(paramArrayOfInt));
    if (remoteViews != null)
    {
      QMLog.log(4, "CalendarWidgetProvider", "Try to update title");
      remoteViews.setTextViewText(2131364175, generateTitleWithLunar());
      AppWidgetManager.getInstance(QMApplicationContext.sharedInstance()).updateAppWidget(new ComponentName(QMApplicationContext.sharedInstance(), CalendarWidgetProvider.class), remoteViews);
    }
    updateData();
  }
  
  public void updateData()
  {
    QMCalendarManager.getInstance().syncCalendar();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.widget.calendar.CalendarWidgetProvider
 * JD-Core Version:    0.7.0.1
 */