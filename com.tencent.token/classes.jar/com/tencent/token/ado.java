package com.tencent.token;

import android.content.Context;
import com.tencent.turingfd.sdk.base.Hickory;
import java.io.File;
import java.util.HashMap;
import java.util.Map;

public final class ado
{
  public static ado a = new ado();
  
  public static Map<Integer, Integer> a(Context paramContext)
  {
    Object localObject = f(paramContext);
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
  
  public static String b(Context paramContext)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    paramContext = f(paramContext);
    if (paramContext != null)
    {
      localStringBuilder.append(paramContext.dd);
      localStringBuilder.append("_");
      localStringBuilder.append(paramContext.version);
    }
    return localStringBuilder.toString();
  }
  
  public static long c(Context paramContext)
  {
    paramContext = f(paramContext);
    if (paramContext == null) {
      return 57600L;
    }
    long l = paramContext.hd;
    if (l <= 0L) {
      return 57600L;
    }
    return l;
  }
  
  public static String d(Context paramContext)
  {
    paramContext = paramContext.getDir("turingfd", 0);
    if (paramContext == null) {
      return "";
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramContext.getAbsolutePath());
    paramContext = new File(aeu.a(localStringBuilder, File.separator, "12"));
    if ((!paramContext.exists()) && (!paramContext.mkdirs())) {
      return "";
    }
    localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramContext.getAbsolutePath());
    localStringBuilder.append(File.separator);
    localStringBuilder.append(afh.a);
    localStringBuilder.append("_baseFull_1");
    return localStringBuilder.toString();
  }
  
  public static long e(Context paramContext)
  {
    paramContext = f(paramContext);
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
  
  private static Hickory f(Context paramContext)
  {
    try
    {
      Hickory localHickory = new Hickory();
      localHickory.a(new afk(aey.b(d(paramContext))));
      return localHickory;
    }
    catch (Throwable paramContext)
    {
      label28:
      break label28;
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.ado
 * JD-Core Version:    0.7.0.1
 */