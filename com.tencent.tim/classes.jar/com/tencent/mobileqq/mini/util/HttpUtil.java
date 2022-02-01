package com.tencent.mobileqq.mini.util;

import com.tencent.mobileqq.msf.sdk.AppNetConnInfo;

public class HttpUtil
{
  public static int getNetWorkType()
  {
    if (!AppNetConnInfo.isNetSupport()) {}
    do
    {
      return 0;
      if (AppNetConnInfo.isWifiConn()) {
        return 1;
      }
    } while (!AppNetConnInfo.isMobileConn());
    switch (AppNetConnInfo.getMobileInfo())
    {
    case -1: 
    default: 
      return -1;
    case 0: 
    case 1: 
      return 2;
    case 2: 
      return 3;
    }
    return 4;
  }
  
  static abstract interface NetType
  {
    public static final int CABLE = 5;
    public static final int G2 = 2;
    public static final int G3 = 3;
    public static final int G4 = 4;
    public static final int NONE = 0;
    public static final int WIFI = 1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.mini.util.HttpUtil
 * JD-Core Version:    0.7.0.1
 */