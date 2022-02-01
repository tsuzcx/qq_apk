package com.tencent.qqmail.widget;

import android.appwidget.AppWidgetManager;
import android.appwidget.AppWidgetProvider;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.widget.RemoteViews;
import com.tencent.qqmail.account.AccountList;
import com.tencent.qqmail.account.AccountManager;
import com.tencent.qqmail.account.activity.AccountTypeListActivity;
import com.tencent.qqmail.protocol.DataCollector;
import com.tencent.qqmail.utilities.log.QMLog;
import com.tencent.qqmail.utilities.schedule.QMScheduledJobs;
import com.tencent.qqmail.utilities.schedule.QMScheduledJobs.FromType;
import com.tencent.qqmail.utilities.sharedpreference.SharedPreferenceUtil;
import com.tencent.qqmail.widget.calendar.CalendarWidgetManager;
import com.tencent.qqmail.widget.calendar.CalendarWidgetProvider;
import com.tencent.qqmail.widget.calendar.MonthWidgetProvider;
import com.tencent.qqmail.widget.inbox.InboxWidgetManager;
import com.tencent.qqmail.widget.inbox.InboxWidgetProvider;
import com.tencent.qqmail.widget.notelist.NoteWidgetManager;
import com.tencent.qqmail.widget.notelist.NoteWidgetProvider;
import java.util.Arrays;
import moai.oss.KvHelper;

public abstract class QMWidgetProvider
  extends AppWidgetProvider
{
  private static final String TAG = "QMWidgetProvider";
  
  public static boolean hasQQMailAccount()
  {
    return AccountManager.shareInstance().getAccountList().hasQQMailAccounts();
  }
  
  public static void logWidgetEvent(String paramString)
  {
    DataCollector.logEvent(paramString);
  }
  
  protected abstract RemoteViews buildLayout(Context paramContext, int paramInt);
  
  protected abstract Intent createGesturePswIntent(Context paramContext);
  
  public void onAppWidgetOptionsChanged(Context paramContext, AppWidgetManager paramAppWidgetManager, int paramInt, Bundle paramBundle)
  {
    QMLog.log(4, "QMWidgetProvider", "onAppWidgetOptionsChanged appWidgetId = " + paramInt);
  }
  
  public void onDeleted(Context paramContext, int[] paramArrayOfInt)
  {
    int j = paramArrayOfInt.length;
    int i = 0;
    if (i < j)
    {
      int k = paramArrayOfInt[i];
      if ((this instanceof NoteWidgetProvider))
      {
        QMLog.log(4, "QMWidgetProvider", "onDeleted NoteWidgetProvider appWidgetIds = " + k);
        NoteWidgetManager.getInstance().removeSizeWithID(k);
      }
      for (;;)
      {
        i += 1;
        break;
        if ((this instanceof CalendarWidgetProvider))
        {
          QMLog.log(4, "QMWidgetProvider", "onDeleted CalendarWidgetProvider appWidgetIds = " + k);
          CalendarWidgetManager.getInstance().removeSizeWithID(k);
        }
        else if ((this instanceof InboxWidgetProvider))
        {
          QMLog.log(4, "QMWidgetProvider", "onDeleted InboxWidgetProvider appWidgetIds = " + k);
          InboxWidgetManager.getInstance().removeSizeWithID(k);
        }
      }
    }
  }
  
  public void onDisabled(Context paramContext)
  {
    KvHelper.eventWidgetDisable(new double[0]);
    if ((this instanceof NoteWidgetProvider))
    {
      QMLog.log(4, "QMWidgetProvider", "onDisabled, NoteWidgetProvider");
      logWidgetEvent("Event_widget_note_disable");
      SharedPreferenceUtil.setEnableNoteWidget(false);
      SharedPreferenceUtil.setExistedNoteWidget(false);
    }
    do
    {
      return;
      if ((this instanceof CalendarWidgetProvider))
      {
        QMLog.log(4, "QMWidgetProvider", "onDisabled, CalendarWidgetProvider");
        logWidgetEvent("Event_widget_calendar_disable");
        SharedPreferenceUtil.setEnableCalendarWidget(false);
        SharedPreferenceUtil.setExistedCalendarWidget(false);
        return;
      }
      if ((this instanceof InboxWidgetProvider))
      {
        QMLog.log(4, "QMWidgetProvider", "onDisabled, InboxWidgetProvider");
        logWidgetEvent("Event_widget_inbox_disable");
        SharedPreferenceUtil.setEnableInboxWidget(false);
        SharedPreferenceUtil.setExistedInboxWidget(false);
        return;
      }
    } while (!(this instanceof MonthWidgetProvider));
    QMLog.log(4, "QMWidgetProvider", "onDisabled, MonthWidgetProvider");
    logWidgetEvent("Event_widget_month_disable");
    SharedPreferenceUtil.setEnableMonthWidget(false);
    SharedPreferenceUtil.setExistedMonthWidget(false);
  }
  
  public void onEnabled(Context paramContext)
  {
    KvHelper.eventWidgetEnable(new double[0]);
    if ((this instanceof NoteWidgetProvider))
    {
      QMLog.log(4, "QMWidgetProvider", "onEnabled, NoteWidgetProvider");
      logWidgetEvent("Event_widget_note_enable");
      SharedPreferenceUtil.setExistedNoteWidget(true);
    }
    do
    {
      return;
      if ((this instanceof CalendarWidgetProvider))
      {
        QMLog.log(4, "QMWidgetProvider", "onEnabled, CalendarWidgetProvider");
        logWidgetEvent("Event_widget_calendar_enable");
        SharedPreferenceUtil.setExistedCalendarWidget(true);
        return;
      }
      if ((this instanceof InboxWidgetProvider))
      {
        QMLog.log(4, "QMWidgetProvider", "onEnabled, InboxWidgetProvider");
        logWidgetEvent("Event_widget_Inbox_enable");
        SharedPreferenceUtil.setExistedInboxWidget(true);
        return;
      }
    } while (!(this instanceof MonthWidgetProvider));
    QMLog.log(4, "QMWidgetProvider", "onEnabled, MonthWidgetProvider");
    logWidgetEvent("Event_widget_month_enable");
    SharedPreferenceUtil.setExistedMonthWidget(true);
  }
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    if ((paramIntent == null) || (paramIntent.getAction() == null)) {}
    for (;;)
    {
      return;
      super.onReceive(paramContext, paramIntent);
      try
      {
        if ("com.tencent.qqmail.widget.ACTION_LOGIN".equals(paramIntent.getAction()))
        {
          paramIntent = AccountTypeListActivity.createIntent(true);
          paramIntent.setFlags(268435456);
          paramContext.startActivity(paramIntent);
          return;
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
    int i = 0;
    QMLog.log(4, "QMWidgetProvider", "onUpdate appWidgetIds = " + Arrays.toString(paramArrayOfInt));
    KvHelper.eventWidgetUpdate(new double[0]);
    int j = paramArrayOfInt.length;
    while (i < j)
    {
      int k = paramArrayOfInt[i];
      RemoteViews localRemoteViews = buildLayout(paramContext, k);
      updateData();
      paramAppWidgetManager.updateAppWidget(k, localRemoteViews);
      i += 1;
    }
    paramContext = new Bundle();
    paramContext.putSerializable("from", QMScheduledJobs.FromType.WIDGET_UPDATE);
    QMScheduledJobs.doJobs(paramContext);
  }
  
  protected abstract void updateData();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.widget.QMWidgetProvider
 * JD-Core Version:    0.7.0.1
 */