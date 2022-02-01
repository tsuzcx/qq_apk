package com.tencent.token;

import android.content.Context;
import com.tencent.turingfd.sdk.qps.Ginkgo;
import java.io.File;
import java.util.Map;
import java.util.concurrent.TimeUnit;

public final class aek
{
  public static long a = TimeUnit.HOURS.toMillis(32L);
  public static aek b = new aek();
  
  public static long a(Context paramContext, String paramString, long paramLong1, long paramLong2)
  {
    paramContext = b(paramContext);
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
  
  public static String a(Context paramContext)
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
    localStringBuilder.append(agh.a);
    localStringBuilder.append("_qps_1");
    return localStringBuilder.toString();
  }
  
  public static Ginkgo b(Context paramContext)
  {
    try
    {
      Ginkgo localGinkgo = new Ginkgo();
      localGinkgo.a(new agd(adg.a(a(paramContext))));
      return localGinkgo;
    }
    finally
    {
      label28:
      break label28;
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.aek
 * JD-Core Version:    0.7.0.1
 */