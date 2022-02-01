package com.tencent.token;

import android.content.Context;
import android.os.Process;
import java.util.concurrent.Executors;

public final class arn
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
  
  public static void a(ast paramast, int paramInt)
  {
    a = paramInt;
    ate localate = (ate)arp.a(ate.class);
    StringBuilder localStringBuilder = new StringBuilder("pid: ");
    localStringBuilder.append(Process.myPid());
    localStringBuilder.append("SharkProtocolQueue init()");
    localate.a = new atb(b, paramast);
    atm.a().a(paramast);
    localate.b = Executors.newSingleThreadExecutor();
    paramast = localate.a;
    if (paramast.e.a())
    {
      long l1 = paramast.a.j();
      long l2 = System.currentTimeMillis();
      boolean bool = arw.a(l2, l1, 360);
      paramast.a.b(l2);
      if (bool)
      {
        kv.a();
        kw.b(new atc(paramast), "checkDoRegist");
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.arn
 * JD-Core Version:    0.7.0.1
 */