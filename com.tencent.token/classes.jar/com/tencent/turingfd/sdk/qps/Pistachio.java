package com.tencent.turingfd.sdk.qps;

import android.content.Context;
import com.tencent.token.acy;
import com.tencent.token.afb;
import com.tencent.token.agb;
import java.io.File;
import java.util.Map;
import java.util.concurrent.TimeUnit;

public class Pistachio
{
  public static long a = TimeUnit.HOURS.toMillis(32L);
  public static Pistachio b = new Pistachio();
  public Gooseberry c = null;
  
  public final long a(Context paramContext, String paramString, long paramLong1, long paramLong2)
  {
    c(paramContext);
    paramContext = this.c;
    if (paramContext == null) {
      return paramLong1;
    }
    paramContext = paramContext.k;
    if (paramContext == null) {
      return paramLong1;
    }
    if (!paramContext.containsKey(paramString)) {
      return paramLong1;
    }
    try
    {
      long l = Long.valueOf((String)paramContext.get(paramString)).longValue();
      return l * paramLong2;
    }
    finally {}
    return paramLong1;
  }
  
  public String a(Context paramContext)
  {
    paramContext = paramContext.getDir("turingfd", 0);
    if (paramContext == null) {
      return "";
    }
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append(paramContext.getAbsolutePath());
    paramContext = File.separator;
    ((StringBuilder)localObject).append(paramContext);
    ((StringBuilder)localObject).append("12");
    localObject = new File(((StringBuilder)localObject).toString());
    if ((!((File)localObject).exists()) && (!((File)localObject).mkdirs())) {
      return "";
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(((File)localObject).getAbsolutePath());
    localStringBuilder.append(paramContext);
    localStringBuilder.append(agb.a);
    localStringBuilder.append("_qps_1");
    return localStringBuilder.toString();
  }
  
  public final boolean a(Context paramContext, String paramString, boolean paramBoolean)
  {
    c(paramContext);
    try
    {
      int i = Integer.parseInt((String)this.c.k.get(paramString));
      if (i > 0) {
        return true;
      }
      return paramBoolean;
    }
    finally {}
    return paramBoolean;
  }
  
  public final Gooseberry b(Context paramContext)
  {
    try
    {
      Gooseberry localGooseberry = new Gooseberry();
      localGooseberry.a(new afb(acy.a(a(paramContext))));
      return localGooseberry;
    }
    finally
    {
      label29:
      break label29;
    }
    return null;
  }
  
  public final void c(Context paramContext)
  {
    paramContext = b.b(paramContext);
    if (paramContext != null) {
      this.c = paramContext;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.turingfd.sdk.qps.Pistachio
 * JD-Core Version:    0.7.0.1
 */