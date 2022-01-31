package com.tencent.mobileqq.utils;

import android.os.Build;
import android.os.Build.VERSION;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.commonsdk.soload.SoLoadReport;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.qphone.base.BaseConstants;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;

public class SoLoadReportImpl
  implements SoLoadReport
{
  private static SimpleDateFormat a = new SimpleDateFormat("yyyy-MM-dd_HH:mm:ss");
  
  private HashMap a(String paramString, long paramLong)
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put(BaseConstants.RDM_NoChangeFailCode, "");
    localHashMap.put("osVersion", Build.VERSION.RELEASE);
    localHashMap.put("deviceName", Build.MANUFACTURER + "_" + Build.MODEL);
    localHashMap.put("time", a.format(new Date(System.currentTimeMillis())));
    localHashMap.put("libName", paramString);
    localHashMap.put("costTime", paramLong + "");
    return localHashMap;
  }
  
  private void a(boolean paramBoolean, int paramInt, HashMap paramHashMap)
  {
    StatisticCollector.a(paramHashMap, paramInt);
    StatisticCollector localStatisticCollector = StatisticCollector.a(BaseApplicationImpl.getContext());
    if (paramBoolean)
    {
      localStatisticCollector.a("", "loadSoNew", false, 0L, 0L, paramHashMap, "");
      return;
    }
    localStatisticCollector.a("", "loadSoOld", false, 0L, 0L, paramHashMap, "");
  }
  
  public void report(int paramInt, String paramString, long paramLong)
  {
    HashMap localHashMap = a(paramString, paramLong);
    paramString = a(paramString, paramLong);
    int i;
    if (((paramInt & 0x2) == 2) || ((paramInt & 0x40000) == 262144))
    {
      a(true, 0, localHashMap);
      if ((paramInt & 0x2) != 2) {
        break label137;
      }
      if (((paramInt & 0x8000) != 32768) || ((paramInt & 0x1000) != 4096) || ((paramInt & 0x800) != 0)) {
        break label97;
      }
      i = 0;
    }
    for (;;)
    {
      a(false, i, paramString);
      return;
      a(true, paramInt, localHashMap);
      break;
      label97:
      i = paramInt;
      if ((paramInt & 0x200) == 512)
      {
        i = paramInt;
        if ((paramInt & 0x40) == 0)
        {
          i = paramInt;
          if ((paramInt & 0x8) == 0)
          {
            i = 0;
            continue;
            label137:
            i = paramInt;
            if ((paramInt & 0x40000) == 262144) {
              i = 0;
            }
          }
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\classes.jar
 * Qualified Name:     com.tencent.mobileqq.utils.SoLoadReportImpl
 * JD-Core Version:    0.7.0.1
 */