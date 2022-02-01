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
    if (localObject == null) {
      return paramContext;
    }
    localObject = ((Hickory)localObject).gd;
    if (localObject == null) {
      return paramContext;
    }
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
    if (paramContext == null) {
      return 57600L;
    }
    long l = paramContext.hd;
    if (l <= 0L) {
      return 57600L;
    }
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
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramContext.getAbsolutePath());
    paramContext = new File(ci.a(localStringBuilder, File.separator, "12"));
    if ((!paramContext.exists()) && (!paramContext.mkdirs())) {
      return "";
    }
    localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramContext.getAbsolutePath());
    localStringBuilder.append(File.separator);
    localStringBuilder.append(cv.a);
    localStringBuilder.append("_");
    localStringBuilder.append("baseFull");
    localStringBuilder.append("_");
    localStringBuilder.append("1");
    return localStringBuilder.toString();
  }
  
  public long f(Context paramContext)
  {
    paramContext = a.g(paramContext);
    if (paramContext == null) {
      return 0L;
    }
    paramContext = paramContext.jd;
    if (paramContext == null) {
      return 0L;
    }
    if (!paramContext.containsKey("1")) {
      return 0L;
    }
    try
    {
      long l = Long.valueOf((String)paramContext.get("1")).longValue();
      return l * 3600L * 1000L;
    }
    catch (Throwable paramContext) {}
    return 0L;
  }
  
  public final Hickory g(Context paramContext)
  {
    try
    {
      Hickory localHickory = new Hickory();
      localHickory.a(new cy(cm.b(e(paramContext))));
      return localHickory;
    }
    catch (Throwable paramContext)
    {
      label29:
      break label29;
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.turingfd.sdk.base.bc
 * JD-Core Version:    0.7.0.1
 */