package com.tencent.qqlive.tvkplayer.vinfo.ckey.comm;

import android.content.Context;
import java.lang.reflect.Method;

public class DeviceInfoUtil
{
  private static String mQimei16;
  private static String mQimei36;
  
  private static String getNewQimei16(Context paramContext)
  {
    if (paramContext != null) {
      try
      {
        Object localObject1 = paramContext.getClassLoader().loadClass("com.tencent.beacon.event.open.BeaconReport");
        Object localObject2 = ((Class)localObject1).getMethod("getInstance", new Class[0]).invoke(null, new Object[0]);
        localObject1 = ((Class)localObject1).getMethod("getQimei", new Class[0]).invoke(localObject2, new Object[0]);
        mQimei16 = (String)paramContext.getClassLoader().loadClass("com.tencent.beacon.qimei.Qimei").getMethod("getQimeiOld", new Class[0]).invoke(localObject1, new Object[0]);
        paramContext = mQimei16;
        return paramContext;
      }
      catch (Throwable paramContext)
      {
        paramContext.printStackTrace();
      }
    }
    return "";
  }
  
  private static String getNewQimei36(Context paramContext)
  {
    if (paramContext != null) {
      try
      {
        Object localObject1 = paramContext.getClassLoader().loadClass("com.tencent.beacon.event.open.BeaconReport");
        Object localObject2 = ((Class)localObject1).getMethod("getInstance", new Class[0]).invoke(null, new Object[0]);
        localObject1 = ((Class)localObject1).getMethod("getQimei", new Class[0]).invoke(localObject2, new Object[0]);
        mQimei36 = (String)paramContext.getClassLoader().loadClass("com.tencent.beacon.qimei.Qimei").getMethod("getQimeiNew", new Class[0]).invoke(localObject1, new Object[0]);
        paramContext = mQimei36;
        return paramContext;
      }
      catch (Throwable paramContext)
      {
        paramContext.printStackTrace();
      }
    }
    return "";
  }
  
  private static String getOldQimei16(Context paramContext)
  {
    if (paramContext != null) {
      try
      {
        mQimei36 = (String)paramContext.getClassLoader().loadClass("com.tencent.beacon.event.UserAction").getMethod("getQIMEI", new Class[0]).invoke(null, new Object[0]);
        paramContext = mQimei36;
        return paramContext;
      }
      catch (Throwable paramContext)
      {
        paramContext.printStackTrace();
      }
    }
    return "";
  }
  
  public static String getQimei16()
  {
    return mQimei16;
  }
  
  private static String getQimei16Syn(Context paramContext)
  {
    Object localObject;
    if (paramContext == null) {
      localObject = "";
    }
    String str;
    do
    {
      return localObject;
      str = getNewQimei16(paramContext);
      localObject = str;
    } while (!str.isEmpty());
    return getOldQimei16(paramContext);
  }
  
  public static String getQimei36()
  {
    return mQimei36;
  }
  
  private static String getQimei36Syn(Context paramContext)
  {
    return getNewQimei36(paramContext);
  }
  
  public static void updateQimei(Context paramContext)
  {
    getQimei16Syn(paramContext);
    getQimei36Syn(paramContext);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqlive.tvkplayer.vinfo.ckey.comm.DeviceInfoUtil
 * JD-Core Version:    0.7.0.1
 */