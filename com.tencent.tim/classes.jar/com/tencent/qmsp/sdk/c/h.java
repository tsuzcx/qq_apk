package com.tencent.qmsp.sdk.c;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Build.VERSION;
import android.os.Handler;
import com.tencent.qmsp.sdk.a.c;
import com.tencent.qmsp.sdk.app.QmspSDK;
import com.tencent.qmsp.sdk.f.g;
import com.tencent.qmsp.sdk.f.l;

public class h
{
  private static SharedPreferences a;
  private static final int b;
  
  static
  {
    int i = 23;
    if (Build.VERSION.SDK_INT >= 23) {}
    for (;;)
    {
      b = i;
      return;
      i = 9;
    }
  }
  
  private static void a()
  {
    try
    {
      String[] arrayOfString = new String[b];
      f.a(10L, 0L, 0L, 0L, null, null, null, arrayOfString);
      StringBuilder localStringBuilder2 = new StringBuilder();
      StringBuilder localStringBuilder3 = new StringBuilder();
      int i = 0;
      if (i < arrayOfString.length)
      {
        arrayOfString[i] = l.a(arrayOfString[i]);
        localStringBuilder2.append(arrayOfString[i]);
        localStringBuilder2.append(",");
        StringBuilder localStringBuilder1;
        if (i == 0) {
          localStringBuilder1 = localStringBuilder3.append(String.format("k%d:", new Object[] { Integer.valueOf(i + 1) }));
        }
        for (localObject = arrayOfString[i];; localObject = arrayOfString[i])
        {
          localStringBuilder1.append((String)localObject);
          i += 1;
          break;
          localStringBuilder1 = localStringBuilder3.append(String.format(";k%d:", new Object[] { Integer.valueOf(i + 1) }));
        }
      }
      Object localObject = localStringBuilder3.append(String.format(";k%d:", new Object[] { Integer.valueOf(arrayOfString.length + 1) }));
      ((StringBuilder)localObject).append("4.1");
      localObject = localStringBuilder2.append(localStringBuilder3.toString());
      ((StringBuilder)localObject).append(",");
      localStringBuilder2.append(c.a(localStringBuilder3.toString()));
      localObject = new StringBuilder();
      localObject = ((StringBuilder)localObject).append("Java -- cbid: ").append(localStringBuilder2.toString());
      g.b("cbid", 0, " bidMd5: " + c.a(localStringBuilder3.toString()));
      com.tencent.qmsp.sdk.a.f.a(localStringBuilder2.toString(), 5);
      return;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
  }
  
  public static void a(long paramLong)
  {
    f.i().c().postDelayed(new h.b(), paramLong);
  }
  
  public static void a(Context paramContext)
  {
    try
    {
      StringBuilder localStringBuilder = new StringBuilder().append(b.a);
      a = paramContext.getSharedPreferences("qmsp_cbid_time", 0);
      b();
      return;
    }
    catch (Exception paramContext)
    {
      paramContext.printStackTrace();
    }
  }
  
  public static void b()
  {
    long l2 = 28800000L;
    long l1 = 0L;
    try
    {
      boolean bool = QmspSDK.getTaskStatus();
      if (!bool)
      {
        g.a("cbid", 1, "Cbid Task Finish！");
        return;
      }
      if (a == null) {
        return;
      }
      if (!f.i().a(1002).booleanValue())
      {
        a(28800000L);
        return;
      }
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
      return;
    }
    long l3 = a.getLong("cbid_last_time", 0L);
    long l4 = System.currentTimeMillis();
    l3 = l4 - l3;
    if (l3 < 0L) {}
    for (;;)
    {
      Object localObject;
      if (l1 > 28800000L)
      {
        a();
        localObject = a.edit();
        ((SharedPreferences.Editor)localObject).putLong("cbid_last_time", l4);
        ((SharedPreferences.Editor)localObject).commit();
      }
      for (l1 = l2;; l1 = 28800000L - l1)
      {
        localObject = new StringBuilder();
        g.a("cbid", 1, "cbid rpt after: " + l1);
        f.i().c().postDelayed(new h.a(), l1);
        return;
      }
      l1 = l3;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qmsp.sdk.c.h
 * JD-Core Version:    0.7.0.1
 */