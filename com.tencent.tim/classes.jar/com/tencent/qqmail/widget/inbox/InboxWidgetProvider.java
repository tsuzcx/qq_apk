package com.tencent.qqmail.widget.inbox;

import android.app.PendingIntent;
import android.appwidget.AppWidgetManager;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.util.Log;
import android.widget.RemoteViews;
import com.tencent.qqmail.QMApplicationContext;
import com.tencent.qqmail.account.AccountList;
import com.tencent.qqmail.account.AccountManager;
import com.tencent.qqmail.utilities.log.QMLog;
import com.tencent.qqmail.widget.QMWidgetProvider;
import com.tencent.qqmail.widget.QMWidgetService;
import com.tencent.qqmail.widget.WidgetEventService;
import com.tencent.qqmail.widget.WidgetGesturePswActivity;
import java.util.Arrays;

public class InboxWidgetProvider
  extends QMWidgetProvider
{
  public static final String TAG = "InboxWidgetProvider";
  private static RemoteViews remoteViews;
  private int appWidgetId;
  
  public RemoteViews buildLayout(Context paramContext, int paramInt)
  {
    this.appWidgetId = paramInt;
    remoteViews = new RemoteViews(paramContext.getPackageName(), 2131563356);
    if (AccountManager.shareInstance().getAccountList().hasMultiAccounts()) {
      remoteViews.setTextViewText(2131369130, paramContext.getString(2131693934));
    }
    for (;;)
    {
      Object localObject = new Intent(paramContext, WidgetEventService.class);
      ((Intent)localObject).putExtra("WIDGET_TYPE", 0);
      ((Intent)localObject).putExtra("EVENT_TYPE", 7);
      localObject = PendingIntent.getService(paramContext, paramInt + 1000, (Intent)localObject, 134217728);
      remoteViews.setOnClickPendingIntent(2131369129, (PendingIntent)localObject);
      localObject = QMWidgetService.createIntentForInboxWidget(paramContext, paramInt);
      remoteViews.setRemoteAdapter(paramInt, 2131369127, (Intent)localObject);
      localObject = new Intent(paramContext, WidgetEventService.class);
      ((Intent)localObject).putExtra("appWidgetId", paramInt);
      ((Intent)localObject).putExtra("WIDGET_TYPE", 0);
      paramContext = PendingIntent.getService(paramContext, paramInt, (Intent)localObject, 134217728);
      remoteViews.setPendingIntentTemplate(2131369127, paramContext);
      return remoteViews;
      remoteViews.setTextViewText(2131369130, paramContext.getString(2131693913));
    }
  }
  
  public Intent createGesturePswIntent(Context paramContext)
  {
    return WidgetGesturePswActivity.createInboxGesturePswIntent(paramContext);
  }
  
  public void onAppWidgetOptionsChanged(Context paramContext, AppWidgetManager paramAppWidgetManager, int paramInt, Bundle paramBundle)
  {
    super.onAppWidgetOptionsChanged(paramContext, paramAppWidgetManager, paramInt, paramBundle);
    int i = paramBundle.getInt("appWidgetMinWidth");
    int j = InboxWidgetManager.getInstance().getWidgetSize(i);
    QMLog.log(4, "InboxWidgetProvider", "onAppWidgetOptionsChanged widgetSize = " + j);
    QMLog.log(4, "InboxWidgetProvider", "onAppWidgetOptionsChanged widget_min_width = " + i);
    InboxWidgetManager.getInstance().putSizeWithID(paramInt, j);
    paramAppWidgetManager.notifyAppWidgetViewDataChanged(paramInt, 2131369127);
  }
  
  public void onDisabled(Context paramContext)
  {
    super.onDisabled(paramContext);
    InboxWidgetManager.getInstance().release();
  }
  
  public void onEnabled(Context paramContext)
  {
    super.onEnabled(paramContext);
    InboxWidgetManager.getInstance();
  }
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    super.onReceive(paramContext, paramIntent);
    if (paramIntent != null) {
      try
      {
        if (paramIntent.getAction() == null) {
          return;
        }
        paramIntent = paramIntent.getAction();
        Log.i("InboxWidgetProvider", "onReceive action= " + paramIntent);
        if ("com.tencent.qqmail.widget.inbox.refresh.ui".equals(paramIntent))
        {
          remoteViews = buildLayout(paramContext, this.appWidgetId);
          if (remoteViews != null)
          {
            paramIntent = paramContext.getResources().getString(2131693913);
            if (AccountManager.shareInstance().getAccountList().hasMultiAccounts()) {
              paramIntent = paramContext.getResources().getString(2131693934);
            }
            remoteViews.setTextViewText(2131369130, paramIntent);
            AppWidgetManager.getInstance(QMApplicationContext.sharedInstance()).updateAppWidget(new ComponentName(QMApplicationContext.sharedInstance(), InboxWidgetProvider.class), remoteViews);
            QMLog.log(4, "InboxWidgetProvider", "Try to update title to " + paramIntent);
            return;
          }
        }
      }
      catch (Exception paramContext)
      {
        paramContext.printStackTrace();
      }
    }
  }
  
  public void onUpdate(Context paramContext, AppWidgetManager paramAppWidgetManager, int[] paramArrayOfInt)
  {
    super.onUpdate(paramContext, paramAppWidgetManager, paramArrayOfInt);
    QMLog.log(4, "InboxWidgetProvider", "onUpdate appWidgetIds = " + Arrays.toString(paramArrayOfInt));
  }
  
  public void updateData()
  {
    QMLog.log(4, "InboxWidgetProvider", "update");
    InboxWidgetManager.getInstance().loadDataSource();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.widget.inbox.InboxWidgetProvider
 * JD-Core Version:    0.7.0.1
 */