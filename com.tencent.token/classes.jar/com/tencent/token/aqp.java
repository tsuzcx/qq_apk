package com.tencent.token;

import android.content.Context;
import android.os.Process;
import java.util.concurrent.Executors;

public final class aqp
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
  
  public static void a(arv paramarv, int paramInt)
  {
    a = paramInt;
    asg localasg = (asg)aqr.a(asg.class);
    StringBuilder localStringBuilder = new StringBuilder("pid: ");
    localStringBuilder.append(Process.myPid());
    localStringBuilder.append("SharkProtocolQueue init()");
    localasg.a = new asd(b, paramarv);
    aso.a().a(paramarv);
    localasg.b = Executors.newSingleThreadExecutor();
    paramarv = localasg.a;
    if (paramarv.e.a())
    {
      long l1 = paramarv.a.j();
      long l2 = System.currentTimeMillis();
      boolean bool = aqy.a(l2, l1, 360);
      paramarv.a.b(l2);
      if (bool)
      {
        kh.a();
        ki.b(new ase(paramarv), "checkDoRegist");
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.aqp
 * JD-Core Version:    0.7.0.1
 */