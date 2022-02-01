package com.tencent.qqmail.calendar.data;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map.Entry;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

public class CalendarDefaultSettingData
{
  private long ReminderCacheEnd = 0L;
  private long ScheduleCacheEnd = 0L;
  private long ScheduleCacheStart = 0L;
  private int defaultAccountId = -1;
  private int defaultAllDayReminderTime = 0;
  private int defaultEventDuration = 60;
  private int defaultFolderId = -1;
  private int defaultReminderTime = 15;
  private boolean defaultShowLunarCalendar = true;
  private boolean defaultShowSystemCalendar = false;
  private int defaultStartDayOfWeek = 1;
  private int defaultSyncTime = 1;
  private long refreshLocalTime = 0L;
  private long refreshLogTime = 0L;
  private long refreshTime = 0L;
  private ConcurrentHashMap<Long, Boolean> systemCalendarVisible = new ConcurrentHashMap();
  
  public int getDefaultAccountId()
  {
    return this.defaultAccountId;
  }
  
  public int getDefaultAllDayReminderTime()
  {
    return this.defaultAllDayReminderTime;
  }
  
  public int getDefaultEventDuration()
  {
    return this.defaultEventDuration;
  }
  
  public int getDefaultFolderId()
  {
    return this.defaultFolderId;
  }
  
  public int getDefaultReminderTime()
  {
    return this.defaultReminderTime;
  }
  
  public int getDefaultStartDayOfWeek()
  {
    return this.defaultStartDayOfWeek;
  }
  
  public int getDefaultSyncTime()
  {
    return this.defaultSyncTime;
  }
  
  public long getRefreshLocalTime()
  {
    return this.refreshLocalTime;
  }
  
  public long getRefreshLogTime()
  {
    return this.refreshLogTime;
  }
  
  public long getRefreshTime()
  {
    return this.refreshTime;
  }
  
  public long getReminderCacheEnd()
  {
    return this.ReminderCacheEnd;
  }
  
  public long getScheduleCacheEnd()
  {
    return this.ScheduleCacheEnd;
  }
  
  public long getScheduleCacheStart()
  {
    return this.ScheduleCacheStart;
  }
  
  public boolean getSystemCalendarVisible(long paramLong)
  {
    Boolean localBoolean = (Boolean)this.systemCalendarVisible.get(Long.valueOf(paramLong));
    if (localBoolean != null) {
      return localBoolean.booleanValue();
    }
    return true;
  }
  
  public String getSystemCalendarVisibleStr()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    Iterator localIterator = this.systemCalendarVisible.entrySet().iterator();
    while (localIterator.hasNext())
    {
      Object localObject = (Map.Entry)localIterator.next();
      Long localLong = (Long)((Map.Entry)localObject).getKey();
      localObject = (Boolean)((Map.Entry)localObject).getValue();
      if (localObject != null)
      {
        localStringBuilder.append(localLong);
        localStringBuilder.append("=");
        localStringBuilder.append(localObject);
        localStringBuilder.append(";");
      }
    }
    return localStringBuilder.toString();
  }
  
  public boolean isDefaultShowLunarCalendar()
  {
    return this.defaultShowLunarCalendar;
  }
  
  public boolean isDefaultShowSystemCalendar()
  {
    return this.defaultShowSystemCalendar;
  }
  
  public void setDefaultAccountId(int paramInt)
  {
    this.defaultAccountId = paramInt;
  }
  
  public void setDefaultAllDayReminderTime(int paramInt)
  {
    this.defaultAllDayReminderTime = paramInt;
  }
  
  public void setDefaultEventDuration(int paramInt)
  {
    this.defaultEventDuration = paramInt;
  }
  
  public void setDefaultFolderId(int paramInt)
  {
    this.defaultFolderId = paramInt;
  }
  
  public void setDefaultReminderTime(int paramInt)
  {
    this.defaultReminderTime = paramInt;
  }
  
  public void setDefaultShowLunarCalendar(boolean paramBoolean)
  {
    this.defaultShowLunarCalendar = paramBoolean;
  }
  
  public void setDefaultShowSystemCalendar(boolean paramBoolean)
  {
    this.defaultShowSystemCalendar = paramBoolean;
  }
  
  public void setDefaultStartDayOfWeek(int paramInt)
  {
    this.defaultStartDayOfWeek = paramInt;
  }
  
  public void setDefaultSyncTime(int paramInt)
  {
    this.defaultSyncTime = paramInt;
  }
  
  public void setRefreshLocalTime(long paramLong)
  {
    this.refreshLocalTime = paramLong;
  }
  
  public void setRefreshLogTime(long paramLong)
  {
    this.refreshLogTime = paramLong;
  }
  
  public void setRefreshTime(long paramLong)
  {
    this.refreshTime = paramLong;
  }
  
  public void setReminderCacheEnd(long paramLong)
  {
    this.ReminderCacheEnd = paramLong;
  }
  
  public void setScheduleCacheEnd(long paramLong)
  {
    this.ScheduleCacheEnd = paramLong;
  }
  
  public void setScheduleCacheStart(long paramLong)
  {
    this.ScheduleCacheStart = paramLong;
  }
  
  public void setSystemCalendarVisible(ArrayList<Long> paramArrayList, ArrayList<Boolean> paramArrayList1)
  {
    int i = 0;
    while (i < paramArrayList.size())
    {
      this.systemCalendarVisible.put(paramArrayList.get(i), paramArrayList1.get(i));
      i += 1;
    }
  }
  
  public void setSystemCalendarVisibleStr(String paramString)
  {
    this.systemCalendarVisible.clear();
    if (paramString != null)
    {
      paramString = paramString.split(";");
      int i = 0;
      while (i < paramString.length)
      {
        Object localObject1 = paramString[i];
        if (!"".equals(localObject1))
        {
          Object localObject2 = localObject1.split("=");
          localObject1 = localObject2[0];
          localObject2 = localObject2[1];
          this.systemCalendarVisible.put(Long.valueOf(localObject1), Boolean.valueOf((String)localObject2));
        }
        i += 1;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.calendar.data.CalendarDefaultSettingData
 * JD-Core Version:    0.7.0.1
 */