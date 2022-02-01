package com.tencent.token;

import android.content.Context;
import android.os.Process;
import java.util.concurrent.Executors;

public final class aot
{
  public static int a;
  private static Context b;
  
  public static int a(String paramString)
  {
    if ("build".equals(paramString)) {
      return a;
    }
    return 0;
  }
  
  public static Context a()
  {
    return b;
  }
  
  public static void a(Context paramContext)
  {
    b = paramContext.getApplicationContext();
  }
  
  public static void a(apz paramapz, int paramInt)
  {
    a = paramInt;
    aqk localaqk = (aqk)aov.a(aqk.class);
    StringBuilder localStringBuilder = new StringBuilder("pid: ");
    localStringBuilder.append(Process.myPid());
    localStringBuilder.append("SharkProtocolQueue init()");
    localaqk.a = new aqh(b, paramapz);
    aqs.a().a(paramapz);
    localaqk.b = Executors.newSingleThreadExecutor();
    paramapz = localaqk.a;
    if (paramapz.e.a())
    {
      long l1 = paramapz.a.j();
      long l2 = System.currentTimeMillis();
      boolean bool = apc.a(l2, l1, 360);
      paramapz.a.b(l2);
      if (bool)
      {
        ke.a();
        kf.b(new aqi(paramapz), "checkDoRegist");
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.aot
 * JD-Core Version:    0.7.0.1
 */