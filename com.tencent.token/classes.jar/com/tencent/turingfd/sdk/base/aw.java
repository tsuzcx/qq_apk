package com.tencent.turingfd.sdk.base;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Handler;
import android.text.TextUtils;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class aw
{
  public static final String a = cv.a + "_" + "baseFull";
  public Handler b;
  
  public aw(Handler paramHandler)
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
    catch (Throwable paramContext) {}
    return 0L;
  }
  
  public static String a(Context paramContext, String paramString)
  {
    try
    {
      paramContext = paramContext.getSharedPreferences(a, 0);
      if (paramContext == null)
      {
        paramContext = "";
        return paramContext;
      }
    }
    catch (Throwable paramContext)
    {
      do
      {
        for (;;)
        {
          paramContext = null;
        }
        paramString = paramContext.getString(paramString, "");
        paramContext = paramString;
      } while (TextUtils.isEmpty(paramString));
      try
      {
        int j = paramString.length() / 2;
        paramContext = new byte[j];
        paramString = paramString.toUpperCase().toCharArray();
        int i = 0;
        while (i < j)
        {
          int k = i * 2;
          int m = paramString[k];
          m = (byte)"0123456789ABCDEF".indexOf(m);
          k = paramString[(k + 1)];
          paramContext[i] = ((byte)((byte)"0123456789ABCDEF".indexOf(k) | m << 4));
          i += 1;
        }
        paramContext = cm.b(paramContext, cm.b());
        paramContext = new String(paramContext, "UTF-8");
        return paramContext;
      }
      catch (Throwable paramContext) {}
    }
    return "";
  }
  
  public v<Long> a(Context paramContext, int paramInt)
  {
    System.currentTimeMillis();
    v localv = new v(paramInt);
    paramContext = a(paramContext, "402").split("_");
    int i = paramContext.length;
    paramInt = 0;
    while (paramInt < i)
    {
      String str = paramContext[paramInt];
      try
      {
        long l = Long.valueOf(str).longValue();
        localv.a(Long.valueOf(l));
      }
      catch (NumberFormatException localNumberFormatException)
      {
        label61:
        break label61;
      }
      paramInt += 1;
    }
    return localv;
  }
  
  public void a(Context paramContext, long paramLong)
  {
    a(paramContext, "107", "" + paramLong, true);
    a(paramContext, "108", "" + System.currentTimeMillis() / 1000L, true);
  }
  
  public void a(Context paramContext, long paramLong, int paramInt)
  {
    a(paramContext, "203", "" + paramLong + "_" + paramInt);
  }
  
  public void a(Context paramContext, long paramLong, boolean paramBoolean)
  {
    StringBuilder localStringBuilder = new StringBuilder().append("").append(paramLong).append("_");
    if (paramBoolean) {}
    for (String str = "1";; str = "0")
    {
      a(paramContext, "204", str);
      return;
    }
  }
  
  public void a(Context paramContext, ao paramao)
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("101", paramao.b);
    localHashMap.put("102", "" + paramao.c);
    if (!TextUtils.isEmpty(paramao.e)) {
      localHashMap.put("104", paramao.e);
    }
    if (!TextUtils.isEmpty(paramao.f)) {
      localHashMap.put("105", paramao.f);
    }
    if (!TextUtils.isEmpty(paramao.g)) {
      localHashMap.put("106", paramao.g);
    }
    if (!TextUtils.isEmpty(paramao.h)) {
      localHashMap.put("110", paramao.h);
    }
    paramao = paramao.i;
    if ((paramao != null) && (!TextUtils.isEmpty(paramao.toString()))) {
      localHashMap.put("111", paramao.toString());
    }
    a(paramContext, localHashMap, true);
  }
  
  public void a(Context paramContext, v<Long> paramv)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    int i = 0;
    while (i < paramv.b())
    {
      localStringBuilder.append(paramv.a(i));
      if (i != paramv.b() - 1) {
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
  
  public final void a(Context paramContext, Map<String, String> paramMap)
  {
    try
    {
      paramContext = paramContext.getSharedPreferences(a, 0);
      if (paramContext == null) {
        return;
      }
    }
    catch (Throwable paramContext)
    {
      do
      {
        for (;;)
        {
          paramContext = null;
        }
        paramContext = paramContext.edit();
      } while (paramContext == null);
      Iterator localIterator = paramMap.keySet().iterator();
      while (localIterator.hasNext())
      {
        String str1 = (String)localIterator.next();
        String str2 = (String)paramMap.get(str1);
        try
        {
          paramContext.putString(str1, cm.f(cm.a(str2.getBytes(), cm.b())));
        }
        catch (Throwable localThrowable) {}
      }
      try
      {
        paramContext.commit();
        return;
      }
      catch (Throwable paramContext) {}
    }
  }
  
  public final void a(final Context paramContext, final Map<String, String> paramMap, boolean paramBoolean)
  {
    if (paramBoolean)
    {
      a(paramContext, paramMap);
      return;
    }
    this.b.post(new a(paramContext, paramMap));
  }
  
  public void a(Context paramContext, boolean paramBoolean)
  {
    a(paramContext, "403", "" + paramBoolean, true);
  }
  
  public ao b(Context paramContext)
  {
    String str1 = a(paramContext, "101");
    if (TextUtils.isEmpty(str1)) {
      return ao.a(1);
    }
    long l1 = 0L;
    try
    {
      long l2 = Long.valueOf(a(paramContext, "102")).longValue();
      l1 = l2;
    }
    catch (Throwable localThrowable)
    {
      label40:
      String str2;
      String str3;
      String str4;
      String str5;
      ao.b localb;
      break label40;
    }
    str2 = a(paramContext, "104");
    str3 = a(paramContext, "105");
    str4 = a(paramContext, "106");
    str5 = a(paramContext, "110");
    paramContext = a(paramContext, "111");
    localb = ao.b(0);
    localb.b = l1;
    localb.a = str1;
    localb.e = str2;
    localb.f = str3;
    localb.g = str4;
    localb.h = str5;
    localb.i = new ax(paramContext);
    return localb.a();
  }
  
  public void b(Context paramContext, long paramLong)
  {
    long l = paramLong;
    if (paramLong >= 9223372036854775807L) {
      l = 9223372036854775807L;
    }
    a(paramContext, "401", "" + l, true);
  }
  
  public void b(Context paramContext, String paramString)
  {
    a(paramContext, "404", paramString, true);
  }
  
  public long c(Context paramContext)
  {
    paramContext = a(paramContext, "107");
    try
    {
      long l = Long.valueOf(paramContext).longValue();
      return l;
    }
    catch (Throwable paramContext) {}
    return 0L;
  }
  
  public final long c(Context paramContext, String paramString)
  {
    paramContext = a(paramContext, paramString);
    try
    {
      long l = Long.valueOf(paramContext).longValue();
      return l;
    }
    catch (Throwable paramContext) {}
    return 0L;
  }
  
  public void c(Context paramContext, long paramLong)
  {
    a(paramContext, "109", "" + paramLong, true);
  }
  
  public String d(Context paramContext)
  {
    return a(paramContext, "404");
  }
  
  public void d(Context paramContext, long paramLong)
  {
    a(paramContext, "503", "" + paramLong, true);
  }
  
  public long e(Context paramContext)
  {
    paramContext = a(paramContext, "401");
    try
    {
      long l = Long.valueOf(paramContext).longValue();
      return l;
    }
    catch (Throwable paramContext) {}
    return 0L;
  }
  
  public long f(Context paramContext)
  {
    return c(paramContext, "109");
  }
  
  public String g(Context paramContext)
  {
    return a(paramContext, "203");
  }
  
  public String h(Context paramContext)
  {
    return a(paramContext, "202");
  }
  
  public String i(Context paramContext)
  {
    return a(paramContext, "201");
  }
  
  public String j(Context paramContext)
  {
    return a(paramContext, "405");
  }
  
  public boolean k(Context paramContext)
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
  
  public void l(Context paramContext)
  {
    a(paramContext, "501", System.currentTimeMillis(), true);
  }
  
  public String m(Context paramContext)
  {
    return a(paramContext, "205");
  }
  
  public class a
    implements Runnable
  {
    public a(Context paramContext, Map paramMap) {}
    
    public void run()
    {
      aw.a(aw.this, paramContext, paramMap);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.turingfd.sdk.base.aw
 * JD-Core Version:    0.7.0.1
 */