package com.tencent.token;

import com.tencent.halley.common.b;
import com.tencent.halley.common.e;

public final class ay
  implements ax
{
  private static ay a;
  
  public static ay a()
  {
    try
    {
      if (a == null) {
        a = new ay();
      }
      ay localay = a;
      return localay;
    }
    finally {}
  }
  
  private static bi a(ap paramap)
  {
    throw new Runtime("d2j fail translate: java.lang.RuntimeException: can not merge I and Z\r\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.copyTypes(TypeTransformer.java:311)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.fixTypes(TypeTransformer.java:226)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:207)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\r\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\r\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\r\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\r\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\r\n");
  }
  
  public final void a(ap paramap, aq paramaq)
  {
    b.b("AccessSchedulerStatistics", "AccessSchedulerStatistics...onAccessSchedulerFinished, do sdk report...");
    paramap = a(paramap);
    if (paramap != null)
    {
      paramaq = new StringBuilder("AccessSchedulerFinished：");
      paramaq.append(paramap.toString());
      b.b("AccessSchedulerStatistics", paramaq.toString());
      new a(paramap).start();
    }
  }
  
  public final void b(ap paramap, aq paramaq)
  {
    b.b("AccessSchedulerStatistics", "AccessSchedulerStatistics...onResSchedulerFinished, do sdk report...");
    paramap = a(paramap);
    if (paramap != null)
    {
      paramaq = new StringBuilder("ResSchedulerFinished：");
      paramaq.append(paramap.toString());
      b.b("AccessSchedulerStatistics", paramaq.toString());
      e.a("B_ACSDK_RES_Result", e.a(paramap));
    }
  }
  
  final class a
    extends Thread
  {
    private bi a;
    
    a(bi parambi)
    {
      this.a = parambi;
    }
    
    public final void run()
    {
      try
      {
        Thread.sleep(10000L);
        e.a("B_ACSDK_SDK_Result", e.a(this.a));
        return;
      }
      catch (InterruptedException localInterruptedException)
      {
        localInterruptedException.printStackTrace();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.ay
 * JD-Core Version:    0.7.0.1
 */