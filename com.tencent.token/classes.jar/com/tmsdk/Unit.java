package com.tmsdk;

import android.util.Log;
import java.math.BigDecimal;
import java.text.DecimalFormat;

public final class Unit
{
  public static final long ONE_GB = 1073741824L;
  public static final long ONE_KB = 1024L;
  public static final long ONE_MB = 1048576L;
  public static final long ONE_TB = 1099511627776L;
  
  static String getFloatValue(double paramDouble, int paramInt)
  {
    int i = 0;
    if (paramDouble >= 1000.0D) {
      paramInt = 0;
    }
    try
    {
      localObject = new BigDecimal(paramDouble);
      if (paramInt > 0) {
        break label110;
      }
      f = ((BigDecimal)localObject).setScale(0, 1).floatValue();
      paramDouble = f;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        Object localObject;
        float f;
        label41:
        label110:
        Log.w("Unit.getFloatValue", localException.getMessage());
      }
    }
    localObject = new StringBuilder();
    if (paramInt <= 0) {
      ((StringBuilder)localObject).append("#");
    }
    for (;;)
    {
      return new DecimalFormat("###." + ((StringBuilder)localObject).toString()).format(paramDouble);
      if (paramDouble < 100.0D) {
        break;
      }
      paramInt = 1;
      break;
      f = ((BigDecimal)localObject).setScale(paramInt, 1).floatValue();
      paramDouble = f;
      break label41;
      while (i < paramInt)
      {
        localException.append("#");
        i += 1;
      }
    }
  }
  
  public static String transform(long paramLong, boolean paramBoolean)
  {
    long l1;
    int i;
    if (paramLong < 0L)
    {
      paramLong *= -1L;
      l1 = 1024L;
      i = 0;
    }
    for (int j = 1;; j = 0)
    {
      String str1;
      try
      {
        for (;;)
        {
          long l2 = paramLong / l1;
          if (l2 <= 0L) {
            break;
          }
          l1 = 1024L * l1;
          i += 1;
        }
        str2 = str1;
      }
      catch (Exception localException)
      {
        str1 = null;
        switch (i)
        {
        }
      }
      for (;;)
      {
        String str2;
        if (j != 0) {
          str2 = "-" + str1;
        }
        return str2;
        str1 = paramLong + "B";
        continue;
        double d = paramLong * 1.0D / 1024.0D;
        str1 = getFloatValue(d, 1) + "K";
        continue;
        d = paramLong * 1.0D / 1048576.0D;
        str1 = getFloatValue(d, 1) + "M";
        continue;
        d = paramLong * 1.0D / 1073741824.0D;
        str1 = getFloatValue(d, 2) + "G";
        continue;
        str1 = getFloatValue(paramLong * 1.0D / 1099511627776.0D, 2) + "T";
      }
      l1 = 1024L;
      i = 0;
    }
  }
  
  public static String transformShortType(long paramLong)
  {
    if (paramLong < 1024L) {
      return "OK";
    }
    return transformShortType(paramLong, false);
  }
  
  public static String transformShortType(long paramLong, boolean paramBoolean)
  {
    long l3 = 1024L;
    int k = 0;
    int i = 0;
    int j = k;
    long l1 = l3;
    long l2 = paramLong;
    if (paramLong < 0L)
    {
      i = 1;
      l2 = paramLong * -1L;
      l1 = l3;
      j = k;
    }
    while (l2 / l1 > 0L)
    {
      j += 1;
      paramLong = l1 * 1024L;
      l1 = paramLong;
      if (paramLong == 0L) {
        return null;
      }
    }
    String str;
    switch (j)
    {
    default: 
      str = null;
    }
    while (i != 0)
    {
      return "-" + str;
      str = "0M";
      continue;
      double d = l2 / 1024L;
      str = getFloatValue(d, 1) + "K";
      continue;
      d = l2 * 1.0D / 1048576.0D;
      str = getFloatValue(d, 1) + "M";
      continue;
      d = l2 * 1.0D / 1073741824.0D;
      str = getFloatValue(d, 2) + "G";
      continue;
      str = getFloatValue(l2 * 1.0D / 1099511627776.0D, 2) + "T";
    }
    return str;
  }
  
  public static String[] transformSplite(long paramLong, boolean paramBoolean)
  {
    long l1;
    int i;
    if (paramLong < 0L)
    {
      paramLong *= -1L;
      l1 = 1024L;
      i = 0;
    }
    for (int j = 1;; j = 0)
    {
      String str1;
      String str2;
      try
      {
        for (;;)
        {
          long l2 = paramLong / l1;
          if (l2 <= 0L) {
            break;
          }
          l1 *= 1024L;
          i += 1;
        }
        str3 = str1;
      }
      catch (Exception localException)
      {
        Log.e("Unit", "" + localException.getMessage());
        switch (i)
        {
        default: 
          str1 = null;
          str2 = null;
        }
      }
      for (;;)
      {
        String str3;
        if (j != 0) {
          str3 = "-" + str1;
        }
        return new String[] { str3, str2 };
        str1 = "0";
        str2 = "M";
        continue;
        str1 = getFloatValue(paramLong / 1024L, 1);
        str2 = "K";
        continue;
        str1 = getFloatValue(paramLong * 1.0D / 1048576.0D, 1);
        str2 = "M";
        continue;
        str1 = getFloatValue(paramLong * 1.0D / 1073741824.0D, 2);
        str2 = "G";
        continue;
        str1 = getFloatValue(paramLong * 1.0D / 1099511627776.0D, 2);
        str2 = "T";
      }
      l1 = 1024L;
      i = 0;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tmsdk.Unit
 * JD-Core Version:    0.7.0.1
 */