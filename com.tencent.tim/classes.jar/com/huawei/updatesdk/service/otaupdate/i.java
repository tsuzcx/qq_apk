package com.huawei.updatesdk.service.otaupdate;

import android.content.Context;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.List;

public class i
{
  public static int a(int paramInt1, int paramInt2)
  {
    int i = 100;
    if (paramInt2 <= 0) {
      paramInt1 = 0;
    }
    do
    {
      return paramInt1;
      paramInt2 = (int)Math.round(paramInt1 / paramInt2 * 100.0D);
      paramInt1 = i;
    } while (paramInt2 > 100);
    return paramInt2;
  }
  
  public static String a(int paramInt)
  {
    NumberFormat localNumberFormat = NumberFormat.getPercentInstance();
    double d = paramInt / 100.0D;
    localNumberFormat.setMinimumFractionDigits(0);
    return localNumberFormat.format(d);
  }
  
  public static String a(Context paramContext, long paramLong)
  {
    if (paramLong == 0L) {
      return paramContext.getString(g.b(paramContext, "upsdk_storage_utils"), new Object[] { "0" });
    }
    DecimalFormat localDecimalFormat = null;
    if (paramLong > 104857L) {
      localDecimalFormat = new DecimalFormat("###.#");
    }
    while (localDecimalFormat != null)
    {
      double d = paramLong / 1048576.0D;
      return paramContext.getString(g.b(paramContext, "upsdk_storage_utils"), new Object[] { localDecimalFormat.format(d) });
      if (paramLong > 10485L) {
        localDecimalFormat = new DecimalFormat("###.##");
      }
    }
    return paramContext.getString(g.b(paramContext, "upsdk_storage_utils"), new Object[] { "0.01" });
  }
  
  public static boolean a(List paramList)
  {
    return (paramList == null) || (paramList.size() <= 0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     com.huawei.updatesdk.service.otaupdate.i
 * JD-Core Version:    0.7.0.1
 */