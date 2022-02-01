package com.tencent.qqmail.calendar.data;

import java.util.Calendar;
import java.util.HashMap;
import java.util.Map;

public class CalendarDataCache
{
  private static final int DEFUALT_MAX_CACHE_SIZE = 3;
  private Map<Integer, QMCalendar> cacheData;
  
  public CalendarDataCache(int paramInt)
  {
    int i = paramInt;
    if (paramInt < 3) {
      i = 3;
    }
    this.cacheData = new HashMap(i);
  }
  
  private static int generateKey(int paramInt1, int paramInt2)
  {
    return paramInt1 * 100 + paramInt2;
  }
  
  public void add(int paramInt1, int paramInt2, QMCalendar paramQMCalendar)
  {
    this.cacheData.put(Integer.valueOf(generateKey(paramInt1, paramInt2)), paramQMCalendar);
  }
  
  public void add(Calendar paramCalendar, QMCalendar paramQMCalendar)
  {
    add(paramCalendar.get(1), paramCalendar.get(2) + 1, paramQMCalendar);
  }
  
  public void clear()
  {
    this.cacheData.clear();
  }
  
  public QMCalendar get(int paramInt1, int paramInt2)
  {
    return (QMCalendar)this.cacheData.get(Integer.valueOf(generateKey(paramInt1, paramInt2)));
  }
  
  public QMCalendar get(Calendar paramCalendar)
  {
    return get(paramCalendar.get(1), paramCalendar.get(2) + 1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.calendar.data.CalendarDataCache
 * JD-Core Version:    0.7.0.1
 */