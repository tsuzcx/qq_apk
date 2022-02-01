package com.tencent.token;

import android.content.Context;
import android.os.Process;
import java.util.concurrent.Executors;

public final class aos
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
  
  public static void a(apy paramapy, int paramInt)
  {
    a = paramInt;
    aqj localaqj = (aqj)aou.a(aqj.class);
    StringBuilder localStringBuilder = new StringBuilder("pid: ");
    localStringBuilder.append(Process.myPid());
    localStringBuilder.append("SharkProtocolQueue init()");
    localaqj.a = new aqg(b, paramapy);
    aqr.a().a(paramapy);
    localaqj.b = Executors.newSingleThreadExecutor();
    paramapy = localaqj.a;
    if (paramapy.e.a())
    {
      long l1 = paramapy.a.j();
      long l2 = System.currentTimeMillis();
      boolean bool = apb.a(l2, l1, 360);
      paramapy.a.b(l2);
      if (bool)
      {
        kd.a();
        ke.b(new aqh(paramapy), "checkDoRegist");
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.aos
 * JD-Core Version:    0.7.0.1
 */