package com.tencent.turingfd.sdk.base;

import android.content.Context;
import java.io.File;
import java.util.HashMap;
import java.util.Map;

public class bc
{
  public static bc a = new bc();
  
  public Map<Integer, Integer> a(Context paramContext)
  {
    Object localObject = a.g(paramContext);
    paramContext = new HashMap();
    if (localObject == null) {}
    do
    {
      return paramContext;
      localObject = ((Hickory)localObject).gd;
    } while (localObject == null);
    return localObject;
  }
  
  public void a(Context paramContext, Hickory paramHickory)
  {
    paramHickory = paramHickory.c();
    cm.a(e(paramContext), paramHickory);
  }
  
  public String b(Context paramContext)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    paramContext = a.g(paramContext);
    if (paramContext != null)
    {
      localStringBuilder.append(paramContext.dd);
      localStringBuilder.append("_");
      localStringBuilder.append(paramContext.version);
    }
    return localStringBuilder.toString();
  }
  
  public long c(Context paramContext)
  {
    paramContext = a.g(paramContext);
    if (paramContext == null) {}
    long l;
    do
    {
      return 57600L;
      l = paramContext.hd;
    } while (l <= 0L);
    return l;
  }
  
  public void d(Context paramContext)
  {
    try
    {
      new File(e(paramContext)).delete();
      return;
    }
    catch (Throwable paramContext) {}
  }
  
  public String e(Context paramContext)
  {
    paramContext = paramContext.getDir("turingfd", 0);
    if (paramContext == null) {
      return "";
    }
    paramContext = new File(ci.a(new StringBuilder().append(paramContext.getAbsolutePath()), File.separator, "12"));
    if ((!paramContext.exists()) && (!paramContext.mkdirs())) {
      return "";
    }
    return paramContext.getAbsolutePath() + File.separator + cv.a + "_" + "baseFull" + "_" + "1";
  }
  
  public long f(Context paramContext)
  {
    paramContext = a.g(paramContext);
    if (paramContext == null) {}
    do
    {
      return 0L;
      paramContext = paramContext.jd;
    } while ((paramContext == null) || (!paramContext.containsKey("1")));
    try
    {
      l = Long.valueOf((String)paramContext.get("1")).longValue();
      l = l * 3600L * 1000L;
    }
    catch (Throwable paramContext)
    {
      for (;;)
      {
        long l = 0L;
      }
    }
    return l;
  }
  
  public final Hickory g(Context paramContext)
  {
    try
    {
      Hickory localHickory = new Hickory();
      localHickory.a(new cy(cm.b(e(paramContext))));
      return localHickory;
    }
    catch (Throwable paramContext) {}
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.turingfd.sdk.base.bc
 * JD-Core Version:    0.7.0.1
 */