package com.tencent.qqmail.widget.calendar;

import android.content.Context;
import android.content.Intent;
import android.graphics.Paint.Style;
import android.os.Binder;
import android.widget.RemoteViews;
import android.widget.RemoteViewsService.RemoteViewsFactory;
import com.tencent.qqmail.QMApplicationContext;
import com.tencent.qqmail.calendar.model.QMCalendarManager;
import com.tencent.qqmail.calendar.view.DrawBitmapUtil;
import com.tencent.qqmail.utilities.imageextention.ImageUtil;
import com.tencent.qqmail.utilities.log.QMLog;
import com.tencent.qqmail.utilities.sharedpreference.SharedPreferenceUtil;
import com.tencent.qqmail.view.fingerprint.BaseFingerprintManager;
import com.tencent.qqmail.view.fingerprint.FingerprintFactory;
import com.tencent.qqmail.widget.QMWidgetDataManager.WidgetState;
import com.tencent.qqmail.widget.model.CalendarWidgetItemInfo;
import com.tencent.qqmail.widget.model.CalendarWidgetItemInfo.CalendarWidgetItemType;
import com.tencent.qqmail.widget.model.CalendarWidgetScheduleInfo;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Iterator;

public class CalendarWidgetRemoteViewsFactory
  implements RemoteViewsService.RemoteViewsFactory
{
  private static final String TAG = "CalendarWidgetRemoteViewsFactory";
  private CalendarWidgetManager calendarWidgetManager;
  private boolean fingerprintLock = false;
  private int mAppWidgetId;
  private Context mContext;
  private ArrayList<CalendarWidgetItemInfo> mItemInfos = new ArrayList();
  private StringBuilder timeTextSB;
  private int widgetSize = 4;
  private QMWidgetDataManager.WidgetState widgetState;
  
  public CalendarWidgetRemoteViewsFactory(Context paramContext, Intent paramIntent)
  {
    this.mContext = paramContext;
    this.mAppWidgetId = paramIntent.getIntExtra("appWidgetId", 0);
    this.timeTextSB = new StringBuilder();
    this.widgetSize = CalendarWidgetManager.getInstance().getSizeWithID(this.mAppWidgetId);
  }
  
  public String generateDateStr(CalendarWidgetItemInfo paramCalendarWidgetItemInfo)
  {
    new GregorianCalendar().setTimeInMillis(paramCalendarWidgetItemInfo.getHappenTime());
    return paramCalendarWidgetItemInfo.getMonthDayString();
  }
  
  public int getCount()
  {
    if ((this.mItemInfos != null) && (!this.mItemInfos.isEmpty()) && (this.widgetState == QMWidgetDataManager.WidgetState.AVAILABLE)) {
      return this.mItemInfos.size();
    }
    return 1;
  }
  
  public long getItemId(int paramInt)
  {
    return paramInt;
  }
  
  public RemoteViews getLoadingView()
  {
    return null;
  }
  
  public RemoteViews getScheduleView(int paramInt)
  {
    Object localObject = (CalendarWidgetItemInfo)this.mItemInfos.get(paramInt);
    RemoteViews localRemoteViews = new RemoteViews(this.mContext.getPackageName(), 2131563353);
    String str = ((CalendarWidgetItemInfo)localObject).getSchedule();
    if (((CalendarWidgetItemInfo)localObject).isAllDay()) {
      localRemoteViews.setTextViewText(2131377704, this.mContext.getString(2131691112));
    }
    for (;;)
    {
      localRemoteViews.setTextViewText(2131377703, str);
      localRemoteViews.setImageViewBitmap(2131377691, ImageUtil.drawableToBitmap(DrawBitmapUtil.drawCircle(this.mContext, ((CalendarWidgetItemInfo)localObject).getColor(), DrawBitmapUtil.CIRCLE_DIAMETER_NORMAL, Paint.Style.STROKE)));
      localObject = new Intent();
      ((Intent)localObject).putExtra("EVENT_TYPE", 2);
      ((Intent)localObject).putExtra("EXTRA_CALENDAR_ID", ((CalendarWidgetItemInfo)this.mItemInfos.get(paramInt)).getId());
      localRemoteViews.setOnClickFillInIntent(2131369468, (Intent)localObject);
      return localRemoteViews;
      localRemoteViews.setTextViewText(2131377704, ((CalendarWidgetItemInfo)localObject).getHourMinuteString());
    }
  }
  
  public RemoteViews getViewAt(int paramInt)
  {
    RemoteViews localRemoteViews;
    Intent localIntent;
    switch (CalendarWidgetRemoteViewsFactory.1.$SwitchMap$com$tencent$qqmail$widget$QMWidgetDataManager$WidgetState[this.widgetState.ordinal()])
    {
    default: 
      if (this.mItemInfos.isEmpty())
      {
        localRemoteViews = new RemoteViews(this.mContext.getPackageName(), 2131563367);
        localRemoteViews.setTextViewText(2131381280, this.mContext.getString(2131721879));
        localIntent = new Intent();
        localIntent.putExtra("EVENT_TYPE", 3);
        localRemoteViews.setOnClickFillInIntent(2131362203, localIntent);
        return localRemoteViews;
      }
      break;
    case 1: 
      localRemoteViews = new RemoteViews(this.mContext.getPackageName(), 2131563355);
      localRemoteViews.setTextViewText(2131381280, this.mContext.getString(2131721888));
      localIntent = new Intent();
      localIntent.putExtra("EVENT_TYPE", 4);
      localRemoteViews.setOnClickFillInIntent(2131381281, localIntent);
      return localRemoteViews;
    case 2: 
      localRemoteViews = new RemoteViews(this.mContext.getPackageName(), 2131563355);
      if (this.fingerprintLock) {
        localRemoteViews.setTextViewText(2131381280, this.mContext.getString(2131721883));
      }
      for (;;)
      {
        localIntent = new Intent();
        localIntent.putExtra("EVENT_TYPE", 1);
        localRemoteViews.setOnClickFillInIntent(2131381281, localIntent);
        return localRemoteViews;
        localRemoteViews.setTextViewText(2131381280, this.mContext.getString(2131721881));
      }
    case 3: 
      localRemoteViews = new RemoteViews(this.mContext.getPackageName(), 2131563355);
      localRemoteViews.setTextViewText(2131381280, this.mContext.getString(2131721880));
      localIntent = new Intent();
      localIntent.putExtra("EVENT_TYPE", 5);
      localRemoteViews.setOnClickFillInIntent(2131381281, localIntent);
      return localRemoteViews;
    }
    if (((CalendarWidgetItemInfo)this.mItemInfos.get(paramInt)).getItemType() == CalendarWidgetItemInfo.CalendarWidgetItemType.DAY)
    {
      localRemoteViews = new RemoteViews(this.mContext.getPackageName(), 2131563354);
      localRemoteViews.setTextViewText(2131377694, generateDateStr((CalendarWidgetItemInfo)this.mItemInfos.get(paramInt)));
      return localRemoteViews;
    }
    if (((CalendarWidgetItemInfo)this.mItemInfos.get(paramInt)).getItemType() == CalendarWidgetItemInfo.CalendarWidgetItemType.DIVIDER) {
      return new RemoteViews(this.mContext.getPackageName(), 2131563352);
    }
    return getScheduleView(paramInt);
  }
  
  public int getViewTypeCount()
  {
    return 5;
  }
  
  public boolean hasStableIds()
  {
    return true;
  }
  
  public void onCreate()
  {
    this.calendarWidgetManager = CalendarWidgetManager.getInstance();
    this.widgetState = this.calendarWidgetManager.getWidgetState();
    this.fingerprintLock = FingerprintFactory.createInstance().isAvailable();
  }
  
  public void onDataSetChanged()
  {
    this.widgetState = this.calendarWidgetManager.getWidgetState();
    this.widgetSize = CalendarWidgetManager.getInstance().getSizeWithID(this.mAppWidgetId);
    QMLog.log(4, "CalendarWidgetRemoteViewsFactory", "onDataSetChanged widgetState = " + this.widgetState);
    long l = Binder.clearCallingIdentity();
    try
    {
      Object localObject1 = QMCalendarManager.getInstance().getScheduleListInThisYear(Calendar.getInstance());
      SharedPreferenceUtil.setWidgetScheduleHash(CalendarWidgetScheduleInfo.generateHash((ArrayList)localObject1));
      ArrayList localArrayList = new ArrayList();
      Iterator localIterator = ((ArrayList)localObject1).iterator();
      localObject1 = "";
      while (localIterator.hasNext())
      {
        CalendarWidgetItemInfo localCalendarWidgetItemInfo = (CalendarWidgetItemInfo)localIterator.next();
        if (!((String)localObject1).equals(localCalendarWidgetItemInfo.getMonthDayString()))
        {
          if (!((String)localObject1).isEmpty())
          {
            localObject1 = new CalendarWidgetItemInfo();
            ((CalendarWidgetItemInfo)localObject1).setItemType(CalendarWidgetItemInfo.CalendarWidgetItemType.DIVIDER);
            localArrayList.add(localObject1);
          }
          localObject1 = new CalendarWidgetItemInfo();
          ((CalendarWidgetItemInfo)localObject1).setItemType(CalendarWidgetItemInfo.CalendarWidgetItemType.DAY);
          ((CalendarWidgetItemInfo)localObject1).setMonthDayString(localCalendarWidgetItemInfo.getMonthDayString());
          ((CalendarWidgetItemInfo)localObject1).setWeekString(localCalendarWidgetItemInfo.getWeekString());
          ((CalendarWidgetItemInfo)localObject1).setHappenTime(localCalendarWidgetItemInfo.getHappenTime());
          localArrayList.add(localObject1);
        }
        localObject1 = localCalendarWidgetItemInfo.getMonthDayString();
        localArrayList.add(localCalendarWidgetItemInfo);
      }
      this.mItemInfos = localArrayList;
    }
    finally
    {
      Binder.restoreCallingIdentity(l);
    }
    Intent localIntent = new Intent();
    localIntent.setAction("com.tencent.qqmail.widget.calendar.refresh.ui");
    QMApplicationContext.sharedInstance().sendBroadcast(localIntent);
    Binder.restoreCallingIdentity(l);
  }
  
  public void onDestroy() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.widget.calendar.CalendarWidgetRemoteViewsFactory
 * JD-Core Version:    0.7.0.1
 */