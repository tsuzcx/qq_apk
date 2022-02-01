package com.tencent.turingfd.sdk.base;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import java.util.LinkedList;
import java.util.Random;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;

public class as
{
  public static as a = new as();
  public static long b = TimeUnit.MINUTES.toMillis(30L);
  public static int[] c = { 0, 15, 30, 90, 240, 360, 600, 1200, 2400, 3200, 4800, 7200 };
  public cu d;
  public Handler e;
  public boolean f = false;
  public aw g;
  public final Object h = new Object();
  public final AtomicReference<ao> i = new AtomicReference(null);
  public final AtomicReference<Boolean> j = new AtomicReference(Boolean.valueOf(false));
  
  public final int a(ao paramao)
  {
    if (this.d.e()) {
      return 2;
    }
    if (paramao.d == 0)
    {
      if (TextUtils.isEmpty(paramao.b)) {
        return 2;
      }
      long l1 = System.currentTimeMillis() / 1000L;
      if (l1 >= paramao.c)
      {
        if (this.d.f()) {
          return 2;
        }
        return 3;
      }
      long l2 = this.g.c(cm.a());
      if (Math.abs(l1 - this.g.c(cm.a(), "108")) >= l2)
      {
        if (this.d.f()) {
          return 2;
        }
        return 3;
      }
      return 1;
    }
    return 2;
  }
  
  public final long a(Context paramContext, int paramInt, boolean paramBoolean)
  {
    long l3 = 0L;
    l1 = l3;
    if (paramBoolean) {
      l2 = l3;
    }
    try
    {
      bd localbd;
      String str;
      aw localaw;
      label78:
      try
      {
        l1 = System.currentTimeMillis();
      }
      finally {}
    }
    catch (Throwable paramContext)
    {
      for (;;)
      {
        l1 = l2;
      }
    }
    try
    {
      localbd = bd.a;
      str = this.d.a();
      localaw = this.g;
      if (localbd.a(paramContext, paramInt, str, localaw.c(paramContext, "501"), a(paramContext).b)) {
        this.g.l(paramContext);
      }
    }
    catch (Throwable localThrowable)
    {
      break label78;
    }
    l2 = l3;
    l1 = System.currentTimeMillis() - l1;
    l2 = l1;
    a(paramBoolean);
    l2 = l1;
    bd.a.a(paramContext);
    return l1;
  }
  
  public final ao a(Context paramContext)
  {
    synchronized (this.i)
    {
      ao localao2 = (ao)this.i.get();
      ao localao1 = localao2;
      if (localao2 == null)
      {
        localao1 = this.g.b(paramContext);
        this.i.set(localao1);
      }
      return localao1;
    }
  }
  
  public final ao a(Context paramContext, boolean paramBoolean1, boolean paramBoolean2)
  {
    throw new Runtime("d2j fail translate: java.lang.RuntimeException: can not merge Z and I\r\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.useAs(TypeTransformer.java:868)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.enexpr(TypeTransformer.java:668)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:719)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:703)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.s1stmt(TypeTransformer.java:810)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.sxStmt(TypeTransformer.java:840)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:206)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\r\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\r\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\r\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\r\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\r\n");
  }
  
  public final ao a(Context paramContext, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3)
  {
    int m = 1;
    int k;
    try
    {
      Object localObject1 = (ConnectivityManager)paramContext.getSystemService("connectivity");
      if (localObject1 == null)
      {
        k = 0;
      }
      else
      {
        localObject1 = ((ConnectivityManager)localObject1).getActiveNetworkInfo();
        if (localObject1 != null)
        {
          boolean bool = ((NetworkInfo)localObject1).isConnected();
          if (bool)
          {
            k = 1;
            break label94;
          }
        }
        k = 0;
      }
    }
    catch (Throwable localThrowable1)
    {
      localObject2 = localThrowable1.getMessage();
      if ((localObject2 != null) && (((String)localObject2).contains("ACCESS_NETWORK_STATE"))) {
        k = 1;
      } else {
        k = 0;
      }
    }
    label94:
    if (k == 0) {
      return ao.a(-10012);
    }
    Object localObject3;
    if (!this.d.e())
    {
      localObject2 = cm.a();
      if (Math.abs(System.currentTimeMillis() / 1000L - this.g.f((Context)localObject2) / 1000L) <= 3600L) {
        k = 0;
      } else {
        k = 1;
      }
      if (k != 0)
      {
        localObject2 = this.g.a(cm.a(), 6);
        if (((v)localObject2).b() == 0)
        {
          k = m;
          break label435;
        }
        l1 = this.g.e(cm.a());
        if (l1 > 0L)
        {
          long l2 = ((Long)((v)localObject2).b.getLast()).longValue();
          l2 = Math.abs(System.currentTimeMillis() - l2);
          localObject3 = c;
          if (l1 < localObject3.length) {
            k = (int)l1;
          } else {
            k = localObject3.length - 1;
          }
          if (k >= 1)
          {
            localObject3 = c;
            int n = localObject3[(k - 1)];
            k = localObject3[k];
            if (n >= k) {
              break label447;
            }
            k = new Random().nextInt(k - n + 1);
            if (l2 <= TimeUnit.SECONDS.toMillis(k + n))
            {
              k = 0;
              break label360;
            }
          }
        }
        k = 1;
        label360:
        if (k == 0)
        {
          if (paramBoolean2)
          {
            k = m;
            break label435;
          }
        }
        else
        {
          localObject3 = (Long)((v)localObject2).a();
          if (((v)localObject2).b() < ((v)localObject2).a)
          {
            k = m;
            break label435;
          }
          if (Math.abs(System.currentTimeMillis() - ((Long)localObject3).longValue()) >= b)
          {
            k = m;
            break label435;
          }
        }
      }
      k = 0;
      label435:
      if (k == 0)
      {
        return ao.a(-10011);
        label447:
        throw new IllegalArgumentException("");
      }
    }
    Object localObject2 = this.g.a(cm.a(), 6);
    ((v)localObject2).a(Long.valueOf(System.currentTimeMillis()));
    this.g.a(cm.a(), (v)localObject2);
    localObject2 = ae.b(paramContext);
    if (!TextUtils.isEmpty((CharSequence)localObject2)) {
      this.g.b(paramContext, (String)localObject2);
    }
    bj.a(paramContext, this.g);
    bj.b(paramContext, this.g);
    try
    {
      localObject2 = a(paramContext, paramBoolean1, paramBoolean3);
    }
    catch (Throwable localThrowable2)
    {
      label548:
      Object localObject4;
      break label548;
    }
    localObject2 = ao.a(-10015);
    if (((ao)localObject2).d == -30015) {
      this.g.c(paramContext, System.currentTimeMillis());
    } else if (this.g.f(paramContext) != 0L) {
      this.g.c(paramContext, 0L);
    }
    long l1 = this.g.e(paramContext);
    if (((ao)localObject2).d < 0) {
      this.g.b(paramContext, l1 + 1L);
    } else if (l1 != 0L) {
      this.g.b(paramContext, 0L);
    }
    if (!TextUtils.isEmpty(this.g.d(paramContext))) {
      this.g.b(paramContext, "");
    }
    if (((ao)localObject2).d == 0)
    {
      bj.c(paramContext, this.g);
      localObject4 = be.a();
      localObject3 = this.g;
      if (((be)localObject4).a(paramContext, (aw)localObject3))
      {
        l1 = System.currentTimeMillis();
        localObject4 = new StringBuilder();
        ((StringBuilder)localObject4).append("");
        ((StringBuilder)localObject4).append(l1);
        ((aw)localObject3).a(paramContext, "112", ((StringBuilder)localObject4).toString(), false);
      }
    }
    this.g.a(paramContext, ((ao)localObject2).d, paramBoolean1);
    return localObject2;
  }
  
  public final ao a(ao paramao, final Context paramContext, final boolean paramBoolean1, boolean paramBoolean2)
  {
    synchronized (this.h)
    {
      ??? = a(paramContext);
      if ((??? != paramao) && (a((ao)???) == 1)) {
        return ???;
      }
      synchronized (this.j)
      {
        if (!((Boolean)this.j.get()).booleanValue())
        {
          this.j.set(Boolean.valueOf(true));
          this.e.post(new a(paramContext, paramBoolean1));
        }
        try
        {
          localAtomicReference = this.j;
          if (!paramBoolean2) {
            break label171;
          }
          l = this.d.g();
        }
        catch (InterruptedException localInterruptedException)
        {
          for (;;)
          {
            AtomicReference localAtomicReference;
            continue;
            long l = 10000L;
          }
        }
        localAtomicReference.wait(l);
        paramContext = a(paramContext);
        if (paramContext != paramao) {
          return paramContext;
        }
        paramao = ao.a(-10004);
        return paramao;
      }
    }
  }
  
  public final av a(Context paramContext, byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    paramContext = e.a().a(paramInt1, paramInt2, 1, paramArrayOfByte, this.d.g());
    if (paramContext == null) {
      paramContext = new av(-20000, av.a);
    } else {
      paramContext = new av(0, paramContext);
    }
    if (paramContext.b != 0) {}
    return paramContext;
  }
  
  public final void a()
  {
    synchronized (this.j)
    {
      if (((Boolean)this.j.get()).booleanValue()) {
        return;
      }
      this.j.set(Boolean.valueOf(true));
      this.e.sendEmptyMessage(2);
      return;
    }
  }
  
  public final void a(Context arg1, boolean paramBoolean)
  {
    boolean bool = this.g.k(???);
    int k = 0;
    while (k < this.d.h())
    {
      ao localao = a(???, paramBoolean, bool, false);
      a(localao, true);
      if ((localao.d == 0) || (localao.d == -30014)) {
        break;
      }
      k += 1;
    }
    if (bool) {
      this.g.a(???, false);
    }
    synchronized (this.j)
    {
      this.j.set(Boolean.valueOf(false));
      this.j.notifyAll();
      return;
    }
  }
  
  /* Error */
  public final void a(ao paramao, boolean paramBoolean)
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 65	com/tencent/turingfd/sdk/base/as:i	Ljava/util/concurrent/atomic/AtomicReference;
    //   4: astore_3
    //   5: aload_3
    //   6: monitorenter
    //   7: aload_1
    //   8: ifnonnull +6 -> 14
    //   11: aload_3
    //   12: monitorexit
    //   13: return
    //   14: iload_2
    //   15: ifne +13 -> 28
    //   18: aload_1
    //   19: getfield 115	com/tencent/turingfd/sdk/base/ao:d	I
    //   22: ifeq +6 -> 28
    //   25: aload_3
    //   26: monitorexit
    //   27: return
    //   28: aload_0
    //   29: getfield 65	com/tencent/turingfd/sdk/base/as:i	Ljava/util/concurrent/atomic/AtomicReference;
    //   32: aload_1
    //   33: invokevirtual 192	java/util/concurrent/atomic/AtomicReference:set	(Ljava/lang/Object;)V
    //   36: aload_3
    //   37: monitorexit
    //   38: return
    //   39: aload_3
    //   40: monitorexit
    //   41: aload_1
    //   42: athrow
    //   43: astore_1
    //   44: goto -5 -> 39
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	47	0	this	as
    //   0	47	1	paramao	ao
    //   0	47	2	paramBoolean	boolean
    //   4	36	3	localAtomicReference	AtomicReference
    // Exception table:
    //   from	to	target	type
    //   11	13	43	finally
    //   18	27	43	finally
    //   28	38	43	finally
    //   39	41	43	finally
  }
  
  public final void a(boolean paramBoolean)
  {
    throw new Runtime("d2j fail translate: java.lang.RuntimeException: can not merge I and Z\r\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.provideAs(TypeTransformer.java:780)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.enexpr(TypeTransformer.java:659)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:719)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:703)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.enexpr(TypeTransformer.java:698)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:719)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:703)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.s1stmt(TypeTransformer.java:810)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.sxStmt(TypeTransformer.java:840)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:206)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\r\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\r\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\r\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\r\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\r\n");
  }
  
  public final ao b(Context paramContext, boolean paramBoolean)
  {
    ao localao = a(paramContext);
    int k = a(localao);
    if (k == 1) {
      return localao;
    }
    if (k == 2)
    {
      if (Looper.myLooper() == Looper.getMainLooper())
      {
        a();
        return ao.a(-10008);
      }
      return a(localao, paramContext, false, paramBoolean);
    }
    if (k == 3) {
      a();
    }
    return localao;
  }
  
  public class a
    implements Runnable
  {
    public a(Context paramContext, boolean paramBoolean) {}
    
    public void run()
    {
      as.b(as.this, paramContext, paramBoolean1);
    }
  }
  
  private class b
    extends Handler
  {
    public Context a;
    
    public b(Looper paramLooper, Context paramContext)
    {
      super();
      this.a = paramContext;
    }
    
    public void handleMessage(Message arg1)
    {
      System.currentTimeMillis();
      int i = ???.what;
      if (i != 1)
      {
        if (i != 2) {
          return;
        }
        ??? = as.a(as.this, this.a, true, false, true);
        as.a(as.this, ???, false);
        synchronized (as.c(as.this))
        {
          as.c(as.this).set(Boolean.valueOf(false));
          as.c(as.this).notifyAll();
          return;
        }
      }
      as.a(as.this, this.a, true);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.turingfd.sdk.base.as
 * JD-Core Version:    0.7.0.1
 */