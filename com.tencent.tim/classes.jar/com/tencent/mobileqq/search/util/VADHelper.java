package com.tencent.mobileqq.search.util;

import acfp;
import amxo;
import android.content.Context;
import android.os.SystemClock;
import aqha;
import aqju;
import aqlv;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;
import java.util.concurrent.ConcurrentHashMap;

public class VADHelper
{
  public static boolean Gy;
  private static String TAG = VADHelper.class.getSimpleName();
  public static boolean TRACE = false;
  public static boolean bVt;
  private static int dDY = aqlv.dZR;
  private static ConcurrentHashMap<String, Long[]> gW;
  private static ConcurrentHashMap<String, Long> sLogs = new ConcurrentHashMap(new HashMap(8));
  
  static
  {
    gW = new ConcurrentHashMap(new HashMap());
  }
  
  public static void PZ(String paramString)
  {
    if (TRACE)
    {
      long l = SystemClock.uptimeMillis();
      if (paramString != null) {
        sLogs.put(paramString, Long.valueOf(l));
      }
    }
  }
  
  public static void Qa(String paramString)
  {
    long l1;
    Long localLong;
    Long[] arrayOfLong;
    if (TRACE)
    {
      l1 = SystemClock.uptimeMillis();
      if (paramString != null)
      {
        localLong = (Long)sLogs.remove(paramString);
        if (localLong != null)
        {
          arrayOfLong = (Long[])gW.get(paramString);
          if (arrayOfLong != null) {
            break label87;
          }
          arrayOfLong = new Long[2];
          arrayOfLong[0] = Long.valueOf(1L);
          arrayOfLong[1] = Long.valueOf(l1 - localLong.longValue());
        }
      }
    }
    for (;;)
    {
      gW.put(paramString, arrayOfLong);
      return;
      label87:
      arrayOfLong[0] = Long.valueOf(arrayOfLong[0].longValue() + 1L);
      long l2 = arrayOfLong[1].longValue();
      arrayOfLong[1] = Long.valueOf(l1 - localLong.longValue() + l2);
    }
  }
  
  public static void aRK()
  {
    sLogs.clear();
    gW.clear();
  }
  
  public static long ax(String paramString)
  {
    long l2 = 0L;
    long l1 = l2;
    if (TRACE)
    {
      l1 = l2;
      if (paramString != null)
      {
        Long[] arrayOfLong = (Long[])gW.get(paramString);
        l1 = l2;
        if (arrayOfLong != null)
        {
          l1 = l2;
          if (arrayOfLong[0].longValue() > 0L)
          {
            Long localLong = arrayOfLong[1];
            l2 = localLong.longValue();
            l1 = l2;
            if (localLong != null)
            {
              l1 = l2;
              if (QLog.isColorLevel())
              {
                QLog.i(TAG, 2, paramString + ", AVG.cost=" + arrayOfLong[1].longValue() / arrayOfLong[0].longValue() + " totalTime:" + arrayOfLong[1] + " count:" + arrayOfLong[0]);
                l1 = l2;
              }
            }
          }
        }
      }
    }
    return l1;
  }
  
  public static void eR(Context paramContext)
  {
    if (!TRACE) {}
    while (!QLog.isColorLevel()) {
      return;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("服务器识别耗时：" + ax("voice_search_server_cost") + " ms \n");
    localStringBuilder.append("预搜索耗时：" + ax("voice_search_pre_cost") + " ms \n");
    localStringBuilder.append("精确搜索耗时：" + ax("voice_search_accurate_cost") + " ms \n");
    localStringBuilder.append("模糊搜索耗时：" + ax("voice_search_approximate_cost") + " ms \n");
    localStringBuilder.append("本地搜索总耗时：" + ax("voice_search_als_cost") + " ms \n");
    localStringBuilder.append("语音搜索总耗时：" + ax("voice_search_all_cost") + " ms \n");
    localStringBuilder.append("EditDistance总耗时：" + ax("voice_search_distance_cost") + " ms,平均 ：" + String.format("%.4f", new Object[] { Float.valueOf(f("voice_search_distance_cost")) }) + " ms \n");
    localStringBuilder.append("声母韵母总耗时：" + ax("voice_search_sy_cost") + " ms,平均 ：" + String.format("%.4f", new Object[] { Float.valueOf(f("voice_search_sy_cost")) }) + " ms");
    QLog.i(TAG, 2, localStringBuilder.toString());
    if ((bVt) && (!Gy))
    {
      aqha.a(paramContext, 230, acfp.m(2131716305), localStringBuilder.toString(), "", "ok", new amxo(), null).show();
      Gy = true;
    }
    aRK();
  }
  
  public static float f(String paramString)
  {
    float f2 = 0.0F;
    float f1 = f2;
    if (TRACE)
    {
      f1 = f2;
      if (paramString != null)
      {
        Long[] arrayOfLong = (Long[])gW.get(paramString);
        f1 = f2;
        if (arrayOfLong != null)
        {
          f1 = f2;
          if (arrayOfLong[0].longValue() > 0L)
          {
            f2 = (float)arrayOfLong[1].longValue() / (float)arrayOfLong[0].longValue();
            f1 = f2;
            if (QLog.isColorLevel())
            {
              QLog.i(TAG, 2, paramString + ", AVG.cost=" + arrayOfLong[1].longValue() / arrayOfLong[0].longValue() + " totalTime:" + arrayOfLong[1] + " count:" + arrayOfLong[0]);
              f1 = f2;
            }
          }
        }
      }
    }
    return f1;
  }
  
  public native int calcOneFrameBytes(int paramInt1, int paramInt2);
  
  public native long create(String paramString);
  
  public native int destroy(long paramLong);
  
  public native int init(long paramLong, int paramInt1, int paramInt2);
  
  public native int process(long paramLong, byte[] paramArrayOfByte, int paramInt, float[] paramArrayOfFloat);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.search.util.VADHelper
 * JD-Core Version:    0.7.0.1
 */