package com.tencent.tmassistantsdk.c;

import com.tencent.tmassistantsdk.e.c.a;
import com.tencent.tmassistantsdk.f.f;
import com.tencent.tmassistantsdk.f.k;
import java.util.ArrayList;
import java.util.List;

public abstract class b
{
  protected c a = null;
  protected int b = 0;
  protected final List c = new ArrayList();
  
  /* Error */
  public void a(com.qq.taf.jce.JceStruct paramJceStruct)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: ldc 27
    //   4: ldc 29
    //   6: invokestatic 34	com/tencent/tmassistantsdk/f/k:b	(Ljava/lang/String;Ljava/lang/String;)V
    //   9: aload_1
    //   10: ifnull +18 -> 28
    //   13: aload_1
    //   14: ifnonnull +17 -> 31
    //   17: aconst_null
    //   18: astore_1
    //   19: aload_0
    //   20: invokevirtual 37	com/tencent/tmassistantsdk/c/b:b	()Lcom/tencent/tmassistantsdk/e/c/a;
    //   23: aload_1
    //   24: invokevirtual 42	com/tencent/tmassistantsdk/e/c/a:a	([B)Z
    //   27: pop
    //   28: aload_0
    //   29: monitorexit
    //   30: return
    //   31: new 44	com/qq/taf/jce/JceOutputStream
    //   34: dup
    //   35: invokespecial 45	com/qq/taf/jce/JceOutputStream:<init>	()V
    //   38: astore_2
    //   39: aload_2
    //   40: ldc 47
    //   42: invokevirtual 51	com/qq/taf/jce/JceOutputStream:setServerEncoding	(Ljava/lang/String;)I
    //   45: pop
    //   46: aload_1
    //   47: aload_2
    //   48: invokevirtual 57	com/qq/taf/jce/JceStruct:writeTo	(Lcom/qq/taf/jce/JceOutputStream;)V
    //   51: aload_2
    //   52: invokevirtual 61	com/qq/taf/jce/JceOutputStream:toByteArray	()[B
    //   55: astore_1
    //   56: goto -37 -> 19
    //   59: astore_1
    //   60: aload_0
    //   61: monitorexit
    //   62: aload_1
    //   63: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	64	0	this	b
    //   0	64	1	paramJceStruct	com.qq.taf.jce.JceStruct
    //   38	14	2	localJceOutputStream	com.qq.taf.jce.JceOutputStream
    // Exception table:
    //   from	to	target	type
    //   2	9	59	finally
    //   19	28	59	finally
    //   31	56	59	finally
  }
  
  public void a(boolean paramBoolean)
  {
    k.b("BaseReportManager", "onLogReprotHttpRequestFinish,result:" + paramBoolean);
    if ((paramBoolean) && (this.c != null) && (this.c.size() > 0)) {
      b().a(this.c);
    }
    this.a = null;
    this.c.clear();
    if ((paramBoolean) && (this.b < 5))
    {
      k.b("BaseReportManager", "onLogReprotHttpRequestFinish wifi is true reportlog go on,result:" + paramBoolean + " count:" + this.b);
      f();
      this.b += 1;
    }
  }
  
  protected abstract a b();
  
  protected abstract byte c();
  
  public void d()
  {
    this.a = null;
    this.c.clear();
  }
  
  public void e()
  {
    if (this.a != null)
    {
      this.a.a();
      this.a = null;
    }
  }
  
  public void f()
  {
    boolean bool2 = false;
    for (;;)
    {
      try
      {
        f.a();
        bool1 = f.l();
        if (!bool1) {
          return;
        }
        k.b("BaseReportManager", "reportLogData,request:" + this.a);
        if (this.a != null) {
          continue;
        }
        this.a = new c();
        this.a.a(this);
        com.tencent.tmassistantsdk.e.c.b localb1 = b().a(1000);
        k.b("BaseReportManager", "readLogDataAndSendToServer,wrappterCount:" + localb1.b.size());
        bool1 = bool2;
        if (localb1 != null)
        {
          if (localb1.b.size() <= 0) {
            bool1 = bool2;
          }
        }
        else
        {
          if (bool1) {
            continue;
          }
          this.b = 0;
          this.a = null;
          continue;
        }
        this.c.addAll(localb2.a);
      }
      finally {}
      boolean bool1 = this.a.a(c(), localb2);
    }
  }
  
  public void g()
  {
    this.b = 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     com.tencent.tmassistantsdk.c.b
 * JD-Core Version:    0.7.0.1
 */