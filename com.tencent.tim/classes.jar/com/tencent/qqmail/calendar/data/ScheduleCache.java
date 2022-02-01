package com.tencent.qqmail.calendar.data;

import com.tencent.qqmail.calendar.util.CalendarUtils;
import java.util.HashMap;

public class ScheduleCache
{
  private HashMap<Integer, HashMap<Integer, Boolean>> mCache = new HashMap();
  private HashMap<Integer, Boolean> mCacheYears = new HashMap();
  private HashMap<Integer, HashMap<Integer, Integer>> mHolidayCache = new HashMap();
  
  public boolean cacheYear(int paramInt)
  {
    if (this.mCacheYears == null) {
      return false;
    }
    Boolean localBoolean = (Boolean)this.mCacheYears.get(Integer.valueOf(paramInt));
    if ((localBoolean == null) || (!localBoolean.booleanValue())) {
      this.mCacheYears.put(Integer.valueOf(paramInt), Boolean.valueOf(true));
    }
    if (localBoolean == null) {}
    for (boolean bool = false;; bool = localBoolean.booleanValue()) {
      return bool;
    }
  }
  
  public void clear()
  {
    this.mCache.clear();
    this.mHolidayCache.clear();
    this.mCacheYears.clear();
  }
  
  public void clearCacheYear(int paramInt)
  {
    if (this.mCacheYears != null) {
      this.mCacheYears.put(Integer.valueOf(paramInt), Boolean.valueOf(false));
    }
  }
  
  public int getHolidayType(int paramInt1, int paramInt2, int paramInt3)
  {
    HashMap localHashMap = getScheduleHolidayCache(paramInt1);
    paramInt1 = CalendarUtils.computeDate(paramInt1, paramInt2, paramInt3);
    if ((localHashMap != null) && (localHashMap.containsKey(Integer.valueOf(paramInt1))) && (localHashMap.get(Integer.valueOf(paramInt1)) != null)) {
      return ((Integer)localHashMap.get(Integer.valueOf(paramInt1))).intValue();
    }
    return -1;
  }
  
  public HashMap<Integer, Boolean> getScheduleCache(int paramInt)
  {
    HashMap localHashMap2 = (HashMap)this.mCache.get(Integer.valueOf(paramInt));
    HashMap localHashMap1 = localHashMap2;
    if (localHashMap2 == null)
    {
      localHashMap1 = new HashMap();
      this.mCache.put(Integer.valueOf(paramInt), localHashMap1);
    }
    return localHashMap1;
  }
  
  public HashMap<Integer, Integer> getScheduleHolidayCache(int paramInt)
  {
    HashMap localHashMap2 = (HashMap)this.mHolidayCache.get(Integer.valueOf(paramInt));
    HashMap localHashMap1 = localHashMap2;
    if (localHashMap2 == null)
    {
      localHashMap1 = new HashMap();
      this.mHolidayCache.put(Integer.valueOf(paramInt), localHashMap1);
    }
    return localHashMap1;
  }
  
  public boolean hasSchedule(int paramInt1, int paramInt2, int paramInt3)
  {
    HashMap localHashMap = getScheduleCache(paramInt1);
    paramInt1 = CalendarUtils.computeDate(paramInt1, paramInt2, paramInt3);
    return (localHashMap != null) && (localHashMap.containsKey(Integer.valueOf(paramInt1))) && (localHashMap.get(Integer.valueOf(paramInt1)) != null) && (((Boolean)localHashMap.get(Integer.valueOf(paramInt1))).booleanValue());
  }
  
  public boolean isInited()
  {
    return this.mCache.size() > 0;
  }
  
  public void updateCache(int paramInt)
  {
    getScheduleCache(paramInt / 10000).put(Integer.valueOf(paramInt), Boolean.valueOf(true));
  }
  
  public void updateHolidayCache(int paramInt1, int paramInt2)
  {
    getScheduleHolidayCache(paramInt1 / 10000).put(Integer.valueOf(paramInt1), Integer.valueOf(paramInt2));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.calendar.data.ScheduleCache
 * JD-Core Version:    0.7.0.1
 */