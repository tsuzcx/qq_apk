package com.tencent.qqmail.widget.calendar;

import android.app.PendingIntent;
import android.appwidget.AppWidgetManager;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Paint.Style;
import android.graphics.drawable.BitmapDrawable;
import android.util.Log;
import android.widget.RemoteViews;
import com.tencent.qqmail.QMApplicationContext;
import com.tencent.qqmail.calendar.data.QMHolidayCalendar;
import com.tencent.qqmail.calendar.data.QMLunarCalendar;
import com.tencent.qqmail.calendar.model.QMCalendarManager;
import com.tencent.qqmail.calendar.util.QMLunarCalendarUtils;
import com.tencent.qqmail.calendar.view.DrawBitmapUtil;
import com.tencent.qqmail.utilities.log.QMLog;
import com.tencent.qqmail.utilities.sharedpreference.SharedPreferenceUtil;
import com.tencent.qqmail.view.fingerprint.BaseFingerprintManager;
import com.tencent.qqmail.view.fingerprint.FingerprintFactory;
import com.tencent.qqmail.widget.QMWidgetDataManager.WidgetState;
import com.tencent.qqmail.widget.QMWidgetProvider;
import com.tencent.qqmail.widget.WidgetEventService;
import java.text.DateFormatSymbols;
import java.util.Calendar;

public class MonthWidgetProvider
  extends QMWidgetProvider
{
  public static final String TAG = "MonthWidgetProvider";
  private int BLUE_TEXT_COLOR;
  private int MAIN_TEXT_COLOR;
  private int RED_TEXT_COLOR;
  private int SIDE_TEXT_COLOR;
  private int appWidgetId;
  private MonthWidgetManager monthWidgetManager = MonthWidgetManager.getInstance();
  private RemoteViews rv;
  
  private void drawWidget(Context paramContext)
  {
    Object localObject1 = this.monthWidgetManager.getWidgetState();
    this.rv.removeAllViews(2131371914);
    Object localObject2;
    if (localObject1 == QMWidgetDataManager.WidgetState.UNLOGIN)
    {
      localObject1 = new RemoteViews(paramContext.getPackageName(), 2131563355);
      ((RemoteViews)localObject1).setTextViewText(2131381280, paramContext.getString(2131721888));
      localObject2 = new Intent(paramContext, WidgetEventService.class);
      ((Intent)localObject2).putExtra("WIDGET_TYPE", 3);
      ((Intent)localObject2).putExtra("EVENT_TYPE", 4);
      ((RemoteViews)localObject1).setOnClickPendingIntent(2131381281, PendingIntent.getService(paramContext, this.appWidgetId + 4004, (Intent)localObject2, 134217728));
      this.rv.addView(2131371914, (RemoteViews)localObject1);
    }
    for (;;)
    {
      return;
      if (localObject1 == QMWidgetDataManager.WidgetState.SCREENLOCK)
      {
        localObject1 = new RemoteViews(paramContext.getPackageName(), 2131563355);
        if (FingerprintFactory.createInstance().isAvailable()) {
          ((RemoteViews)localObject1).setTextViewText(2131381280, paramContext.getString(2131721883));
        }
        for (;;)
        {
          localObject2 = new Intent(paramContext, WidgetEventService.class);
          ((Intent)localObject2).putExtra("WIDGET_TYPE", 3);
          ((Intent)localObject2).putExtra("EVENT_TYPE", 1);
          ((RemoteViews)localObject1).setOnClickPendingIntent(2131381281, PendingIntent.getService(paramContext, this.appWidgetId + 4005, (Intent)localObject2, 134217728));
          this.rv.addView(2131371914, (RemoteViews)localObject1);
          return;
          ((RemoteViews)localObject1).setTextViewText(2131381280, paramContext.getString(2131721881));
        }
      }
      if (localObject1 == QMWidgetDataManager.WidgetState.CLOSED)
      {
        localObject1 = new RemoteViews(paramContext.getPackageName(), 2131563355);
        ((RemoteViews)localObject1).setTextViewText(2131381280, paramContext.getString(2131721880));
        localObject2 = new Intent(paramContext, WidgetEventService.class);
        ((Intent)localObject2).putExtra("WIDGET_TYPE", 3);
        ((Intent)localObject2).putExtra("EVENT_TYPE", 5);
        ((RemoteViews)localObject1).setOnClickPendingIntent(2131381281, PendingIntent.getService(paramContext, this.appWidgetId + 4006, (Intent)localObject2, 134217728));
        this.rv.addView(2131371914, (RemoteViews)localObject1);
        return;
      }
      localObject1 = new RemoteViews(paramContext.getPackageName(), 2131563363);
      localObject2 = DateFormatSymbols.getInstance().getShortWeekdays();
      int i = 1;
      RemoteViews localRemoteViews;
      if (i <= 7)
      {
        localRemoteViews = new RemoteViews(paramContext.getPackageName(), 2131563361);
        localRemoteViews.setTextViewText(2131364376, localObject2[i].replace("周", ""));
        if ((i == 1) || (i == 7)) {
          localRemoteViews.setTextColor(2131364376, this.SIDE_TEXT_COLOR);
        }
        for (;;)
        {
          ((RemoteViews)localObject1).addView(2131377606, localRemoteViews);
          i += 1;
          break;
          localRemoteViews.setTextColor(2131364376, this.MAIN_TEXT_COLOR);
        }
      }
      this.rv.addView(2131371914, (RemoteViews)localObject1);
      localObject1 = Calendar.getInstance();
      int n = ((Calendar)localObject1).get(6);
      int i1 = ((Calendar)localObject1).get(1);
      int i2 = SharedPreferenceUtil.getCalendarWidgetMonth();
      i = SharedPreferenceUtil.getCalendarWidgetYear();
      ((Calendar)localObject1).set(5, 1);
      ((Calendar)localObject1).set(2, i2);
      ((Calendar)localObject1).set(1, i);
      ((Calendar)localObject1).set(5, 1);
      ((Calendar)localObject1).add(5, 1 - ((Calendar)localObject1).get(7));
      int j = 0;
      while (j < getWeekCountOfMonth((Calendar)localObject1))
      {
        localObject2 = new RemoteViews(paramContext.getPackageName(), 2131563364);
        int k = 0;
        if (k < 7)
        {
          boolean bool;
          label601:
          label614:
          int m;
          if (((Calendar)localObject1).get(2) == i2)
          {
            bool = true;
            if (((Calendar)localObject1).get(1) != i1) {
              break label976;
            }
            i = 1;
            if ((i == 0) || (!bool) || (((Calendar)localObject1).get(6) != n)) {
              break label981;
            }
            m = 1;
            label638:
            if (((Calendar)localObject1).get(5) == 1) {}
            i = 2131563359;
            if (bool) {
              i = 2131563360;
            }
            if (m != 0) {
              i = 2131563362;
            }
            localRemoteViews = new RemoteViews(paramContext.getPackageName(), i);
            if (k != 6) {
              localRemoteViews.setInt(2131364374, "setBackgroundResource", 2130852005);
            }
            localRemoteViews.setTextViewText(2131381044, Integer.toString(((Calendar)localObject1).get(5)));
            if (!hasSchedule((Calendar)localObject1)) {
              break label994;
            }
            localRemoteViews.setViewVisibility(2131368314, 0);
            if (m == 0) {
              break label987;
            }
            i = -1;
            label739:
            localRemoteViews.setImageViewBitmap(2131368314, ((BitmapDrawable)DrawBitmapUtil.drawCircle(paramContext, i, DrawBitmapUtil.CIRCLE_DIAMETER_SMALL, Paint.Style.FILL)).getBitmap());
            label763:
            Object localObject3 = getLunarInfo((Calendar)localObject1);
            localRemoteViews.setTextViewText(2131370933, (CharSequence)localObject3);
            if ((((String)localObject3).endsWith("月")) && (bool)) {
              localRemoteViews.setTextColor(2131370933, this.BLUE_TEXT_COLOR);
            }
            localObject3 = getHolidayCalendar((Calendar)localObject1);
            if (localObject3 == null) {
              break label1019;
            }
            localRemoteViews.setViewVisibility(2131368555, 0);
            localRemoteViews.setTextViewText(2131368555, ((QMHolidayCalendar)localObject3).getHolidayTag());
            if (!((QMHolidayCalendar)localObject3).isHoliday()) {
              break label1005;
            }
            localRemoteViews.setTextColor(2131368555, this.RED_TEXT_COLOR);
          }
          for (;;)
          {
            if (!bool)
            {
              localRemoteViews.setViewVisibility(2131370933, 8);
              localRemoteViews.setViewVisibility(2131381044, 8);
              localRemoteViews.setViewVisibility(2131368314, 8);
              localRemoteViews.setViewVisibility(2131368555, 8);
            }
            if ((k == 0) || (k == 6))
            {
              localRemoteViews.setTextColor(2131370933, this.SIDE_TEXT_COLOR);
              localRemoteViews.setTextColor(2131381044, this.BLUE_TEXT_COLOR);
            }
            ((RemoteViews)localObject2).addView(2131377605, localRemoteViews);
            setDayCellPendingIntent(bool, paramContext, localRemoteViews, (Calendar)localObject1);
            ((Calendar)localObject1).add(5, 1);
            k += 1;
            break;
            bool = false;
            break label601;
            label976:
            i = 0;
            break label614;
            label981:
            m = 0;
            break label638;
            label987:
            i = -7829368;
            break label739;
            label994:
            localRemoteViews.setViewVisibility(2131368314, 4);
            break label763;
            label1005:
            localRemoteViews.setTextColor(2131368555, this.SIDE_TEXT_COLOR);
            continue;
            label1019:
            localRemoteViews.setViewVisibility(2131368555, 8);
          }
        }
        this.rv.addView(2131371914, (RemoteViews)localObject2);
        j += 1;
      }
    }
  }
  
  public RemoteViews buildLayout(Context paramContext, int paramInt)
  {
    this.MAIN_TEXT_COLOR = paramContext.getResources().getColor(2131167678);
    this.SIDE_TEXT_COLOR = paramContext.getResources().getColor(2131167679);
    this.BLUE_TEXT_COLOR = paramContext.getResources().getColor(2131167676);
    this.RED_TEXT_COLOR = paramContext.getResources().getColor(2131167180);
    this.rv = new RemoteViews(paramContext.getPackageName(), 2131563358);
    this.appWidgetId = paramInt;
    this.rv.setTextViewText(2131371915, generateTitle());
    Object localObject = new Intent(paramContext, WidgetEventService.class);
    ((Intent)localObject).putExtra("WIDGET_TYPE", 3);
    ((Intent)localObject).putExtra("EVENT_TYPE", 16);
    localObject = PendingIntent.getService(paramContext, paramInt + 4003, (Intent)localObject, 134217728);
    this.rv.setOnClickPendingIntent(2131371915, (PendingIntent)localObject);
    localObject = new Intent(paramContext, WidgetEventService.class);
    ((Intent)localObject).putExtra("WIDGET_TYPE", 3);
    ((Intent)localObject).putExtra("EVENT_TYPE", 15);
    localObject = PendingIntent.getService(paramContext, paramInt + 4001, (Intent)localObject, 134217728);
    this.rv.setOnClickPendingIntent(2131372350, (PendingIntent)localObject);
    localObject = new Intent(paramContext, WidgetEventService.class);
    ((Intent)localObject).putExtra("WIDGET_TYPE", 3);
    ((Intent)localObject).putExtra("EVENT_TYPE", 14);
    localObject = PendingIntent.getService(paramContext, paramInt + 4002, (Intent)localObject, 134217728);
    this.rv.setOnClickPendingIntent(2131373565, (PendingIntent)localObject);
    drawWidget(paramContext);
    return this.rv;
  }
  
  public Intent createGesturePswIntent(Context paramContext)
  {
    return null;
  }
  
  public String generateTitle()
  {
    return String.format("%d年 %d月", new Object[] { Integer.valueOf(SharedPreferenceUtil.getCalendarWidgetYear()), Integer.valueOf(SharedPreferenceUtil.getCalendarWidgetMonth() + 1) });
  }
  
  public QMHolidayCalendar getHolidayCalendar(Calendar paramCalendar)
  {
    int i = paramCalendar.get(1);
    int j = paramCalendar.get(2);
    int k = paramCalendar.get(5);
    return QMCalendarManager.getInstance().getHolidayCalendar(i, j + 1, k);
  }
  
  public String getLunarInfo(Calendar paramCalendar)
  {
    int i = paramCalendar.get(7);
    return QMLunarCalendarUtils.getLunarInfo(paramCalendar.get(1), paramCalendar.get(2) + 1, paramCalendar.get(5), i - 1).getLunarString();
  }
  
  public int getWeekCountOfMonth(Calendar paramCalendar)
  {
    return paramCalendar.get(4);
  }
  
  public boolean hasSchedule(Calendar paramCalendar)
  {
    return QMCalendarManager.getInstance().hasSchedule(paramCalendar.get(1), paramCalendar.get(2) + 1, paramCalendar.get(5));
  }
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    super.onReceive(paramContext, paramIntent);
    Log.i("MonthWidgetProvider", "onReceive ");
    if (paramIntent != null) {
      try
      {
        if (paramIntent.getAction() == null) {
          return;
        }
        paramIntent = paramIntent.getAction();
        QMLog.log(4, "MonthWidgetProvider", "onReceive action = " + paramIntent);
        if ("com.tencent.qqmail.widget.month.refresh.ui".equals(paramIntent))
        {
          this.rv = buildLayout(paramContext, this.appWidgetId);
          if (this.rv != null)
          {
            Log.i("MonthWidgetProvider", "Try to update title");
            this.rv.setTextViewText(2131371915, generateTitle());
            AppWidgetManager.getInstance(QMApplicationContext.sharedInstance()).updateAppWidget(new ComponentName(QMApplicationContext.sharedInstance(), MonthWidgetProvider.class), this.rv);
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
  
  public void setDayCellPendingIntent(boolean paramBoolean, Context paramContext, RemoteViews paramRemoteViews, Calendar paramCalendar)
  {
    Intent localIntent = new Intent(paramContext, WidgetEventService.class);
    localIntent.putExtra("WIDGET_TYPE", 3);
    localIntent.putExtra("EVENT_TYPE", 17);
    localIntent.putExtra("CALENDAR_SELECT_DAY", paramCalendar.getTimeInMillis());
    paramContext = PendingIntent.getService(paramContext, this.appWidgetId + paramCalendar.get(1) + paramCalendar.get(6), localIntent, 134217728);
    if (paramBoolean) {}
    for (;;)
    {
      paramRemoteViews.setOnClickPendingIntent(2131364374, paramContext);
      return;
      paramContext = null;
    }
  }
  
  public void updateData() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.widget.calendar.MonthWidgetProvider
 * JD-Core Version:    0.7.0.1
 */