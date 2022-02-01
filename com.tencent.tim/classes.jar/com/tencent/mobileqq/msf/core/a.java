package com.tencent.mobileqq.msf.core;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Handler;
import android.text.TextUtils;
import com.tencent.mobileqq.msf.core.c.k;
import com.tencent.mobileqq.msf.service.MsfService;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.CodecWarpper;
import com.tencent.qphone.base.util.QLog;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.HashMap;

public class a
{
  private static long A = 0L;
  private static String B = "none";
  private static long C = 0L;
  private static long D = 30000L;
  private static final int E = 10000;
  private static final long F = 600000L;
  private static Handler G = new b();
  public static String a = "none";
  private static final String b = "_decode_stat_";
  private static final int c = 0;
  private static final int d = 1;
  private static final int e = 2;
  private static final int f = 3;
  private static final int g = 4;
  private static final int h = 5;
  private static final int i = 6;
  private static final int j = 7;
  private static final int k = 8;
  private static final int l = 9;
  private static final int m = 10;
  private static final int n = 11;
  private static final int o = 12;
  private static final int p = 13;
  private static int q = 0;
  private static int r = 0;
  private static int s = 0;
  private static int t = 0;
  private static int u = 0;
  private static int v = 0;
  private static int w = 0;
  private static int x = 0;
  private static int y = 0;
  private static long z;
  
  private static int a(int paramInt, String[] paramArrayOfString)
  {
    try
    {
      paramInt = Integer.parseInt(paramArrayOfString[paramInt]);
      return paramInt;
    }
    catch (Exception paramArrayOfString) {}
    return 0;
  }
  
  public static void a()
  {
    Object localObject = null;
    try
    {
      String str = BaseApplication.getContext().getSharedPreferences(CodecWarpper.tag, 0).getString("_decode_stat_", null);
      localObject = str;
    }
    catch (Exception localException)
    {
      label23:
      break label23;
    }
    if (TextUtils.isEmpty((CharSequence)localObject))
    {
      A = f();
      h();
      G.sendEmptyMessageDelayed(10000, 600000L);
      QLog.d("CodecStatHelper", 4, "CodecStatHelper Restore " + b());
      return;
    }
    localObject = ((String)localObject).split("\\|");
    if ((localObject == null) || (localObject.length != 14))
    {
      A = f();
      h();
      G.sendEmptyMessageDelayed(10000, 600000L);
      QLog.d("CodecStatHelper", 4, "CodecStatHelper Restore " + b());
      return;
    }
    q = a(0, (String[])localObject);
    z = b(1, (String[])localObject);
    r = a(2, (String[])localObject);
    s = a(3, (String[])localObject);
    t = a(4, (String[])localObject);
    u = a(5, (String[])localObject);
    v = a(6, (String[])localObject);
    w = a(7, (String[])localObject);
    x = a(8, (String[])localObject);
    y = a(9, (String[])localObject);
    A = b(10, (String[])localObject);
    B = localObject[11];
    C = b(12, (String[])localObject);
    a = localObject[13];
    if (A == 0L)
    {
      A = f();
      h();
      QLog.d("CodecStatHelper", 4, "CodecStatHelper Restore " + b());
    }
    G.sendEmptyMessageDelayed(10000, 600000L);
    QLog.d("CodecStatHelper", 4, "CodecStatHelper Restore " + b());
  }
  
  public static void a(int paramInt)
  {
    if (paramInt == 1)
    {
      r += 1;
      return;
    }
    if (paramInt == 2)
    {
      s += 1;
      return;
    }
    if (System.currentTimeMillis() - C <= D) {
      q += 1;
    }
    for (;;)
    {
      B = b(System.currentTimeMillis());
      h();
      return;
      switch (paramInt)
      {
      default: 
        q += 1;
        break;
      case -2: 
        t += 1;
        break;
      case -3: 
        u += 1;
        break;
      case -4: 
        v += 1;
        break;
      case -5: 
        w += 1;
        break;
      case -6: 
        x += 1;
        break;
      case -7: 
        y += 1;
      }
    }
  }
  
  public static void a(long paramLong)
  {
    C = paramLong;
  }
  
  private static long b(int paramInt, String[] paramArrayOfString)
  {
    try
    {
      long l1 = Long.parseLong(paramArrayOfString[paramInt]);
      return l1;
    }
    catch (Exception paramArrayOfString) {}
    return 0L;
  }
  
  public static String b()
  {
    StringBuffer localStringBuffer = new StringBuffer();
    localStringBuffer.append(q).append("|");
    localStringBuffer.append(z).append("|");
    localStringBuffer.append(r).append("|");
    localStringBuffer.append(s).append("|");
    localStringBuffer.append(t).append("|");
    localStringBuffer.append(u).append("|");
    localStringBuffer.append(v).append("|");
    localStringBuffer.append(w).append("|");
    localStringBuffer.append(x).append("|");
    localStringBuffer.append(y).append("|");
    localStringBuffer.append(A).append("|");
    localStringBuffer.append(B).append("|");
    localStringBuffer.append(C).append("|");
    localStringBuffer.append(a);
    return localStringBuffer.toString();
  }
  
  private static String b(long paramLong)
  {
    SimpleDateFormat localSimpleDateFormat = new SimpleDateFormat("yy-MM-dd HH:mm:ss");
    Calendar localCalendar = Calendar.getInstance();
    localCalendar.setTimeInMillis(paramLong);
    return localSimpleDateFormat.format(localCalendar.getTime());
  }
  
  public static String c()
  {
    int i1 = q;
    int i2 = r;
    int i3 = s;
    int i4 = t;
    int i5 = u;
    int i6 = v;
    int i7 = w;
    int i8 = x;
    int i9 = y;
    StringBuffer localStringBuffer = new StringBuffer();
    localStringBuffer.append(g()).append("|");
    localStringBuffer.append(i1 + i2 + i3 + i4 + i5 + i6 + i7 + i8 + i9).append("|");
    localStringBuffer.append(r).append("|");
    localStringBuffer.append(s).append("|");
    localStringBuffer.append(t).append("|");
    localStringBuffer.append(u).append("|");
    localStringBuffer.append(v).append("|");
    localStringBuffer.append(w).append("|");
    localStringBuffer.append(x).append("|");
    localStringBuffer.append(y).append("|");
    localStringBuffer.append(q).append("|");
    localStringBuffer.append(B).append("|");
    localStringBuffer.append(b(C)).append("|");
    localStringBuffer.append(a);
    return localStringBuffer.toString();
  }
  
  private static long f()
  {
    Calendar localCalendar = Calendar.getInstance();
    localCalendar.setTimeInMillis(System.currentTimeMillis() + 86400000L);
    return localCalendar.getTimeInMillis();
  }
  
  private static String g()
  {
    SimpleDateFormat localSimpleDateFormat = new SimpleDateFormat("yy-MM-dd");
    Calendar localCalendar = Calendar.getInstance();
    localCalendar.setTimeInMillis(System.currentTimeMillis() - 86400000L);
    return localSimpleDateFormat.format(localCalendar.getTime());
  }
  
  private static void h()
  {
    for (;;)
    {
      try
      {
        long l1 = System.currentTimeMillis();
        String str;
        if (l1 > A)
        {
          str = c();
          QLog.d("CodecStatHelper", 4, "CodecStatHelper Report " + str);
          HashMap localHashMap = new HashMap();
          localHashMap.put("param_appSpec", str);
          bool = true;
          if ((t <= 0) && (u <= 0) && (v <= 0))
          {
            if (MsfService.getCore().getStatReporter() != null) {
              MsfService.getCore().getStatReporter().a("dim.Msf.DecPack_trunk_test", bool, 0L, 0L, localHashMap, false, false);
            }
            q = 0;
            r = 0;
            s = 0;
            t = 0;
            u = 0;
            v = 0;
            w = 0;
            x = 0;
            y = 0;
            A = 0L;
            A = f();
            z = l1;
            B = "none";
            C = 0L;
            a = "none";
            BaseApplication.getContext().getSharedPreferences(CodecWarpper.tag, 0).edit().putString("_decode_stat_", b()).commit();
          }
        }
        else
        {
          str = b();
          QLog.d("CodecStatHelper", 4, "CodecStatHelper Save " + str);
          z = l1;
          BaseApplication.getContext().getSharedPreferences(CodecWarpper.tag, 0).edit().putString("_decode_stat_", str).commit();
          return;
        }
      }
      catch (Exception localException)
      {
        localException.printStackTrace();
        return;
      }
      boolean bool = false;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes.jar
 * Qualified Name:     com.tencent.mobileqq.msf.core.a
 * JD-Core Version:    0.7.0.1
 */