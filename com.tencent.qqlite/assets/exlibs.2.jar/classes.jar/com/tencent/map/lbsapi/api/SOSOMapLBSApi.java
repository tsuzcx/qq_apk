package com.tencent.map.lbsapi.api;

import android.content.Context;
import com.tencent.map.location.f;

public class SOSOMapLBSApi
{
  public static final int AREA_MAIN_LAND = 0;
  public static final int AREA_OVERSEAS = 1;
  public static final int LOC_ERROR_NETWORK = 1;
  public static final int LOC_ERROR_NOERROR = 0;
  public static final int LOC_ERROR_RADIO = 3;
  public static final int LOC_ERROR_UNKNOW = 2;
  public static final int LOC_TYPE_GPS = 0;
  public static final int LOC_TYPE_NETWORK = 1;
  public static final int REQ_DELAY_FAST = 4;
  public static final int REQ_DELAY_FASTEST = 1;
  public static final int REQ_DELAY_NORMAL = 8;
  public static final int REQ_DELAY_SLOW = 12;
  public static final int REQ_GEO_TYPE_MARS = 1;
  public static final int REQ_GEO_TYPE_WGS84 = 0;
  public static final int REQ_LEVEL_ADMIN_AREA = 3;
  public static final int REQ_LEVEL_GEO = 0;
  public static final int REQ_LEVEL_GLOBAL_ADMINAREA = 7;
  public static final int REQ_LEVEL_NAME = 1;
  public static final int REQ_LEVEL_POI = 4;
  public static final int REQ_TYPE_DATA = 0;
  public static final int REQ_TYPE_LOC = 1;
  public static final int RES_LEVEL_ADMIN_AREA = 3;
  public static final int RES_LEVEL_GEO = 0;
  public static final int RES_LEVEL_GLOBAL_ADMINAREA = 7;
  public static final int RES_LEVEL_NAME = 1;
  public static final int RES_LEVEL_NONE = -1;
  public static final int RES_LEVEL_POI = 4;
  public static final int STATE_GPS_DISABLED = 1;
  public static final int STATE_GPS_ENABLED = 2;
  public static final int STATE_WIFI_DISABLED = 3;
  public static final int STATE_WIFI_ENABLED = 4;
  private static SOSOMapLBSApi mInstance;
  private static f mSosoLocMgr = ;
  
  public static SOSOMapLBSApi getInstance()
  {
    try
    {
      if (mInstance == null) {
        mInstance = new SOSOMapLBSApi();
      }
      SOSOMapLBSApi localSOSOMapLBSApi = mInstance;
      return localSOSOMapLBSApi;
    }
    finally {}
  }
  
  public SOSOMapLBSApiResult getLatestLocationResult()
  {
    return mSosoLocMgr.a();
  }
  
  public void removeLocationUpdate()
  {
    mSosoLocMgr.a();
  }
  
  public boolean requestLocationUpdate(Context paramContext, SOSOMapLBSApiListener paramSOSOMapLBSApiListener)
  {
    return mSosoLocMgr.a(paramContext, paramSOSOMapLBSApiListener, true);
  }
  
  public boolean requestLocationUpdate(Context paramContext, SOSOMapLBSApiListener paramSOSOMapLBSApiListener, boolean paramBoolean)
  {
    return mSosoLocMgr.a(paramContext, paramSOSOMapLBSApiListener, paramBoolean);
  }
  
  public void setGPSUpdateInterval(long paramLong)
  {
    mSosoLocMgr.a(paramLong);
  }
  
  public void setUserQQNum(String paramString)
  {
    mSosoLocMgr.a(paramString);
  }
  
  public boolean verifyRegCode(String paramString1, String paramString2)
  {
    return mSosoLocMgr.a(paramString1, paramString2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.2.jar\classes.jar
 * Qualified Name:     com.tencent.map.lbsapi.api.SOSOMapLBSApi
 * JD-Core Version:    0.7.0.1
 */