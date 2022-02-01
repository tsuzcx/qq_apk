package com.tencent.qqmail.bottle.controller;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

final class BottleSettings
{
  private static final String CONF_FILE = "bottlesettings";
  private static final String FIELD_BEACH_BOTTLE_NUMBER = "beach_bottle_number";
  private static final String FIELD_BOTTLE_UNREAD_COUNT = "bottle_unread_count";
  private static final String FIELD_BOTTLE_UNREAD_LAST_TIME = "bottle_unread_last_time";
  private static final String FIELD_LAT = "lat";
  private static final String FIELD_LIST_DB_CHANGED_TIME_STAMP = "list_db_changed_time_stamp";
  private static final String FIELD_LIST_OVERDUE = "list_overdue";
  private static final String FIELD_LIST_SVN_TIME = "list_svn_time";
  private static final String FIELD_LIST_TOTAL = "list_total";
  private static final String FIELD_LNG = "lng";
  private static final String FIELD_LOAD_MY_INFORMATION_TIME = "loadmyinfotime";
  private static final String FIELD_LOCALITY = "loc";
  private static final String FIELD_LOCALITY_LAT = "loclat";
  private static final String FIELD_LOCALITY_LNG = "loclng";
  private static final String FIELD_OPENED_LBS = "openedLBS";
  private static final String FIELD_REQUEST_PERMISSION_TO_OPEN_LBS = "lbs";
  private static final double INVALID_LAT_LNG_VALIE = 999.0D;
  private final String mAccount;
  private final SharedPreferences mSharedPreferences;
  
  BottleSettings(Context paramContext, int paramInt)
  {
    this.mSharedPreferences = paramContext.getSharedPreferences("bottlesettings", 0);
    this.mAccount = String.valueOf(paramInt);
  }
  
  public void decBottleUnreadCount(int paramInt)
  {
    try
    {
      setUnreadCount(Math.max(0, getUnreadCount() - paramInt));
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public int getAndIncreaseBeachBottleNumber()
  {
    try
    {
      int i = this.mSharedPreferences.getInt("beach_bottle_number" + this.mAccount, 0) + 1;
      this.mSharedPreferences.edit().putInt("beach_bottle_number" + this.mAccount, i).commit();
      return i;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public long getLastRequestToOpenLBSTime()
  {
    return this.mSharedPreferences.getLong("lbs" + this.mAccount, 0L);
  }
  
  public double getLat()
  {
    return this.mSharedPreferences.getFloat("lat" + this.mAccount, 999.0F);
  }
  
  public long getListDBChangedTimeStamp()
  {
    return this.mSharedPreferences.getLong("list_db_changed_time_stamp" + this.mAccount, 0L);
  }
  
  public long getListSvnTime()
  {
    return this.mSharedPreferences.getLong("list_svn_time" + this.mAccount, 0L);
  }
  
  public int getListTotal()
  {
    return this.mSharedPreferences.getInt("list_total" + this.mAccount, 0);
  }
  
  public double getLng()
  {
    return this.mSharedPreferences.getFloat("lng" + this.mAccount, 999.0F);
  }
  
  public long getLoadMyInformationTime()
  {
    return this.mSharedPreferences.getLong("loadmyinfotime", 0L);
  }
  
  public String getLocality(double paramDouble1, double paramDouble2)
  {
    double d1 = this.mSharedPreferences.getFloat("loclat" + this.mAccount, 999.0F);
    double d2 = this.mSharedPreferences.getFloat("loclng" + this.mAccount, 999.0F);
    if ((validLatLng(d1, d2)) && (BottleManager.equalsCoordinate(paramDouble1, paramDouble2, d1, d2))) {
      return this.mSharedPreferences.getString("loc" + this.mAccount, null);
    }
    return null;
  }
  
  public int getUnreadCount()
  {
    return this.mSharedPreferences.getInt("bottle_unread_count" + this.mAccount, 0);
  }
  
  public long getUnreadLastTime()
  {
    return this.mSharedPreferences.getLong("bottle_unread_last_time" + this.mAccount, 0L);
  }
  
  public boolean isBeachLoaded()
  {
    boolean bool = false;
    if (this.mSharedPreferences.getInt("beach_bottle_number" + this.mAccount, 0) > 0) {
      bool = true;
    }
    return bool;
  }
  
  boolean isListOverdue()
  {
    return this.mSharedPreferences.getBoolean("list_overdue" + this.mAccount, false);
  }
  
  public boolean isOpenedLBS()
  {
    return this.mSharedPreferences.getBoolean("openedLBS" + this.mAccount, true);
  }
  
  public void removeAllItem()
  {
    Object localObject1 = new ArrayList();
    Object localObject2 = this.mSharedPreferences.getAll().keySet().iterator();
    while (((Iterator)localObject2).hasNext())
    {
      String str = (String)((Iterator)localObject2).next();
      if (str.endsWith(this.mAccount)) {
        ((ArrayList)localObject1).add(str);
      }
    }
    localObject2 = this.mSharedPreferences.edit();
    localObject1 = ((ArrayList)localObject1).iterator();
    while (((Iterator)localObject1).hasNext()) {
      ((SharedPreferences.Editor)localObject2).remove((String)((Iterator)localObject1).next());
    }
    ((SharedPreferences.Editor)localObject2).commit();
  }
  
  public void setCoordinate(double paramDouble1, double paramDouble2)
  {
    this.mSharedPreferences.edit().putFloat("lat" + this.mAccount, (float)paramDouble1).putFloat("lng" + this.mAccount, (float)paramDouble2).commit();
  }
  
  void setListOverdue(boolean paramBoolean)
  {
    this.mSharedPreferences.edit().putBoolean("list_overdue" + this.mAccount, paramBoolean).commit();
  }
  
  public void setListTotal(int paramInt)
  {
    this.mSharedPreferences.edit().putInt("list_total" + this.mAccount, paramInt).commit();
  }
  
  public void setListTotalAndSvnTime(int paramInt, long paramLong)
  {
    this.mSharedPreferences.edit().putInt("list_total" + this.mAccount, paramInt).putLong("list_svn_time" + this.mAccount, paramLong).commit();
  }
  
  public void setLoadMyInformationTime(long paramLong)
  {
    this.mSharedPreferences.edit().putLong("loadmyinfotime", paramLong).commit();
  }
  
  public void setLocality(double paramDouble1, double paramDouble2, String paramString)
  {
    String str = paramString;
    if ("".equals(paramString)) {
      str = null;
    }
    this.mSharedPreferences.edit().putFloat("loclat" + this.mAccount, (float)paramDouble1).putFloat("loclng" + this.mAccount, (float)paramDouble2).putString("loc" + this.mAccount, str).commit();
  }
  
  public void setOpenedLBS(boolean paramBoolean)
  {
    this.mSharedPreferences.edit().putBoolean("openedLBS" + this.mAccount, paramBoolean).commit();
  }
  
  public void setUnreadCount(int paramInt)
  {
    try
    {
      this.mSharedPreferences.edit().putInt("bottle_unread_count" + this.mAccount, paramInt).commit();
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public void setUnreadLastTime(long paramLong)
  {
    this.mSharedPreferences.edit().putLong("bottle_unread_last_time" + this.mAccount, paramLong).commit();
  }
  
  public void updateLastRequestToOpenLBSTime()
  {
    this.mSharedPreferences.edit().putLong("lbs" + this.mAccount, System.currentTimeMillis()).commit();
  }
  
  public void updateListDBChangedTimeStamp()
  {
    try
    {
      long l = getListDBChangedTimeStamp();
      this.mSharedPreferences.edit().putLong("list_db_changed_time_stamp" + this.mAccount, l + 1L).commit();
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public boolean validLatLng(double paramDouble1, double paramDouble2)
  {
    return (paramDouble1 < 999.0D) && (paramDouble2 < 999.0D);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.bottle.controller.BottleSettings
 * JD-Core Version:    0.7.0.1
 */