package com.tencent.token;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Handler;
import android.text.TextUtils;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;
import java.util.Set;

public final class adi
{
  public static final String a;
  public Handler b;
  
  static
  {
    StringBuilder localStringBuilder = aeu.a("turingfd_conf_");
    localStringBuilder.append(afh.a);
    localStringBuilder.append("_baseFull");
    a = localStringBuilder.toString();
  }
  
  public adi(Handler paramHandler)
  {
    this.b = paramHandler;
  }
  
  public static long a(Context paramContext)
  {
    try
    {
      long l = Long.valueOf(a(paramContext, "503")).longValue();
      return l;
    }
    catch (Throwable paramContext)
    {
      label15:
      break label15;
    }
    return 0L;
  }
  
  public static String a(Context paramContext, String paramString)
  {
    int i = 0;
    try
    {
      paramContext = paramContext.getSharedPreferences(a, 0);
    }
    catch (Throwable paramContext)
    {
      label14:
      break label14;
    }
    paramContext = null;
    if (paramContext == null) {
      return "";
    }
    paramString = paramContext.getString(paramString, "");
    if (TextUtils.isEmpty(paramString)) {
      return paramString;
    }
    try
    {
      int j = paramString.length() / 2;
      paramContext = new byte[j];
      paramString = paramString.toUpperCase().toCharArray();
      while (i < j)
      {
        int k = i * 2;
        int m = paramString[k];
        m = (byte)"0123456789ABCDEF".indexOf(m);
        k = paramString[(k + 1)];
        paramContext[i] = ((byte)((byte)"0123456789ABCDEF".indexOf(k) | m << 4));
        i += 1;
      }
      paramContext = aey.b(paramContext, aey.b());
      paramContext = new String(paramContext, "UTF-8");
      return paramContext;
    }
    catch (Throwable paramContext)
    {
      label140:
      break label140;
    }
    return "";
  }
  
  public static ada b(Context paramContext)
  {
    String str1 = a(paramContext, "101");
    if (TextUtils.isEmpty(str1)) {
      return ada.a(1);
    }
    try
    {
      l = Long.valueOf(a(paramContext, "102")).longValue();
    }
    catch (Throwable localThrowable)
    {
      long l;
      label35:
      String str2;
      String str3;
      String str4;
      String str5;
      ada.a locala;
      break label35;
    }
    l = 0L;
    str2 = a(paramContext, "104");
    str3 = a(paramContext, "105");
    str4 = a(paramContext, "106");
    str5 = a(paramContext, "110");
    paramContext = a(paramContext, "111");
    locala = ada.a();
    locala.b = l;
    locala.a = str1;
    locala.d = str2;
    locala.e = str3;
    locala.f = str4;
    locala.g = str5;
    locala.h = new adj(paramContext);
    return locala.a();
  }
  
  private static void b(Context paramContext, Map<String, String> paramMap)
  {
    try
    {
      paramContext = paramContext.getSharedPreferences(a, 0);
    }
    catch (Throwable paramContext)
    {
      for (;;)
      {
        try
        {
          Iterator localIterator;
          label99:
          paramContext.commit();
          return;
        }
        catch (Throwable paramContext) {}
        paramContext = paramContext;
      }
    }
    paramContext = null;
    if (paramContext == null) {
      return;
    }
    paramContext = paramContext.edit();
    if (paramContext == null) {
      return;
    }
    localIterator = paramMap.keySet().iterator();
    while (localIterator.hasNext())
    {
      String str1 = (String)localIterator.next();
      String str2 = (String)paramMap.get(str1);
      try
      {
        paramContext.putString(str1, aey.e(aey.a(str2.getBytes(), aey.b())));
      }
      catch (Throwable localThrowable)
      {
        break label99;
      }
    }
  }
  
  public static long c(Context paramContext)
  {
    paramContext = a(paramContext, "107");
    try
    {
      long l = Long.valueOf(paramContext).longValue();
      return l;
    }
    catch (Throwable paramContext)
    {
      label17:
      break label17;
    }
    return 0L;
  }
  
  public static long c(Context paramContext, String paramString)
  {
    paramContext = a(paramContext, paramString);
    try
    {
      long l = Long.valueOf(paramContext).longValue();
      return l;
    }
    catch (Throwable paramContext)
    {
      label16:
      break label16;
    }
    return 0L;
  }
  
  public static String d(Context paramContext)
  {
    return a(paramContext, "404");
  }
  
  public static long e(Context paramContext)
  {
    paramContext = a(paramContext, "401");
    try
    {
      long l = Long.valueOf(paramContext).longValue();
      return l;
    }
    catch (Throwable paramContext)
    {
      label17:
      break label17;
    }
    return 0L;
  }
  
  public static ach<Long> f(Context paramContext)
  {
    System.currentTimeMillis();
    ach localach = new ach(6);
    paramContext = a(paramContext, "402").split("_");
    int j = paramContext.length;
    int i = 0;
    while (i < j)
    {
      String str = paramContext[i];
      try
      {
        long l = Long.valueOf(str).longValue();
        localach.a(Long.valueOf(l));
      }
      catch (NumberFormatException localNumberFormatException)
      {
        label60:
        break label60;
      }
      i += 1;
    }
    return localach;
  }
  
  public static String g(Context paramContext)
  {
    return a(paramContext, "203");
  }
  
  public static String h(Context paramContext)
  {
    return a(paramContext, "202");
  }
  
  public static String i(Context paramContext)
  {
    return a(paramContext, "201");
  }
  
  public static String j(Context paramContext)
  {
    return a(paramContext, "405");
  }
  
  public static boolean k(Context paramContext)
  {
    paramContext = a(paramContext, "403");
    try
    {
      if (TextUtils.isEmpty(paramContext)) {
        return true;
      }
      boolean bool = Boolean.valueOf(paramContext).booleanValue();
      return bool;
    }
    catch (Throwable paramContext) {}
    return true;
  }
  
  public static String l(Context paramContext)
  {
    return a(paramContext, "205");
  }
  
  public final void a(Context paramContext, long paramLong)
  {
    long l = paramLong;
    if (paramLong >= 9223372036854775807L) {
      l = 9223372036854775807L;
    }
    a(paramContext, "401", String.valueOf(l), true);
  }
  
  public final void a(Context paramContext, ach<Long> paramach)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    int i = 0;
    while (i < paramach.b.size())
    {
      localStringBuilder.append(paramach.a(i));
      if (i != paramach.b.size() - 1) {
        localStringBuilder.append("_");
      }
      i += 1;
    }
    a(paramContext, "402", localStringBuilder.toString(), true);
  }
  
  public final void a(Context paramContext, String paramString1, String paramString2)
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put(paramString1, paramString2);
    a(paramContext, localHashMap, false);
  }
  
  public final void a(Context paramContext, String paramString1, String paramString2, boolean paramBoolean)
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put(paramString1, paramString2);
    a(paramContext, localHashMap, paramBoolean);
  }
  
  public final void a(final Context paramContext, final Map<String, String> paramMap, boolean paramBoolean)
  {
    if (paramBoolean)
    {
      b(paramContext, paramMap);
      return;
    }
    this.b.post(new a(paramContext, paramMap));
  }
  
  public final void b(Context paramContext, long paramLong)
  {
    a(paramContext, "109", String.valueOf(paramLong), true);
  }
  
  public final void b(Context paramContext, String paramString)
  {
    a(paramContext, "404", paramString, true);
  }
  
  public final void c(Context paramContext, long paramLong)
  {
    a(paramContext, "503", String.valueOf(paramLong), true);
  }
  
  public final class a
    implements Runnable
  {
    public a(Context paramContext, Map paramMap) {}
    
    public final void run()
    {
      adi.a(paramContext, paramMap);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.adi
 * JD-Core Version:    0.7.0.1
 */