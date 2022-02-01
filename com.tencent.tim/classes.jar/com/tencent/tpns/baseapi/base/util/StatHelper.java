package com.tencent.tpns.baseapi.base.util;

import android.content.Context;
import com.tencent.tpns.baseapi.base.logger.TBaseLogger;
import java.lang.reflect.Method;

public class StatHelper
{
  public static void reportCloudControl(Context paramContext, long paramLong1, int paramInt, String paramString, long paramLong2)
  {
    TBaseLogger.i("StatHelper", "action - reportCloudControl, cloudVersion:" + paramLong1 + ", msg:" + paramString + ", req:" + paramLong2);
    try
    {
      Class localClass = Class.forName("com.tencent.android.tpush.stat.ServiceStat");
      localClass.getDeclaredMethod("reportCloudControl", new Class[] { Context.class, Long.TYPE, Integer.TYPE, String.class, Long.TYPE }).invoke(localClass, new Object[] { paramContext, Long.valueOf(paramLong1), Integer.valueOf(paramInt), paramString, Long.valueOf(paramLong2) });
      return;
    }
    catch (Throwable paramContext)
    {
      TBaseLogger.ww("StatHelper", "unexpected for reportCloudControl, exception:", paramContext);
    }
  }
  
  public static void reportErrCode(Context paramContext, int paramInt, String paramString1, long paramLong, String paramString2)
  {
    TBaseLogger.i("StatHelper", "action - reportErrCode, errCode:" + paramInt + ", msg:" + paramString1 + ", req:" + paramLong);
    try
    {
      Class localClass = Class.forName("com.tencent.android.tpush.stat.ServiceStat");
      localClass.getDeclaredMethod("reportErrCode", new Class[] { Context.class, Integer.TYPE, String.class, Long.TYPE, String.class }).invoke(localClass, new Object[] { paramContext, Integer.valueOf(paramInt), paramString1, Long.valueOf(paramLong), paramString2 });
      return;
    }
    catch (Throwable paramContext)
    {
      TBaseLogger.ww("StatHelper", "unexpected for reportErrCode, exception:", paramContext);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes12.jar
 * Qualified Name:     com.tencent.tpns.baseapi.base.util.StatHelper
 * JD-Core Version:    0.7.0.1
 */