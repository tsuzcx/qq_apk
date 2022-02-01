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
    if (this.d.e()) {}
    do
    {
      long l1;
      do
      {
        do
        {
          return 2;
        } while ((paramao.d != 0) || (TextUtils.isEmpty(paramao.b)));
        l1 = System.currentTimeMillis() / 1000L;
        if (l1 < paramao.c) {
          break;
        }
      } while (this.d.f());
      return 3;
      long l2 = this.g.c(cm.a());
      if (Math.abs(l1 - this.g.c(cm.a(), "108")) < l2) {
        break;
      }
    } while (this.d.f());
    return 3;
    return 1;
  }
  
  /* Error */
  public final long a(Context paramContext, int paramInt, boolean paramBoolean)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: iload_3
    //   3: ifeq +114 -> 117
    //   6: invokestatic 130	java/lang/System:currentTimeMillis	()J
    //   9: lstore 4
    //   11: getstatic 163	com/tencent/turingfd/sdk/base/bd:a	Lcom/tencent/turingfd/sdk/base/bd;
    //   14: astore 8
    //   16: aload_0
    //   17: getfield 99	com/tencent/turingfd/sdk/base/as:d	Lcom/tencent/turingfd/sdk/base/cu;
    //   20: invokevirtual 166	com/tencent/turingfd/sdk/base/cu:a	()Ljava/lang/String;
    //   23: astore 9
    //   25: aload_0
    //   26: getfield 92	com/tencent/turingfd/sdk/base/as:g	Lcom/tencent/turingfd/sdk/base/aw;
    //   29: astore 10
    //   31: aload 8
    //   33: aload_1
    //   34: iload_2
    //   35: aload 9
    //   37: aload 10
    //   39: aload_1
    //   40: ldc 168
    //   42: invokevirtual 151	com/tencent/turingfd/sdk/base/aw:c	(Landroid/content/Context;Ljava/lang/String;)J
    //   45: aload_0
    //   46: aload_1
    //   47: invokevirtual 171	com/tencent/turingfd/sdk/base/as:a	(Landroid/content/Context;)Lcom/tencent/turingfd/sdk/base/ao;
    //   50: getfield 118	com/tencent/turingfd/sdk/base/ao:b	Ljava/lang/String;
    //   53: invokevirtual 174	com/tencent/turingfd/sdk/base/bd:a	(Landroid/content/Context;ILjava/lang/String;JLjava/lang/String;)Z
    //   56: ifeq +11 -> 67
    //   59: aload_0
    //   60: getfield 92	com/tencent/turingfd/sdk/base/as:g	Lcom/tencent/turingfd/sdk/base/aw;
    //   63: aload_1
    //   64: invokevirtual 178	com/tencent/turingfd/sdk/base/aw:l	(Landroid/content/Context;)V
    //   67: invokestatic 130	java/lang/System:currentTimeMillis	()J
    //   70: lstore 6
    //   72: lload 6
    //   74: lload 4
    //   76: lsub
    //   77: lstore 4
    //   79: aload_0
    //   80: iload_3
    //   81: invokevirtual 181	com/tencent/turingfd/sdk/base/as:a	(Z)V
    //   84: getstatic 163	com/tencent/turingfd/sdk/base/bd:a	Lcom/tencent/turingfd/sdk/base/bd;
    //   87: aload_1
    //   88: invokevirtual 183	com/tencent/turingfd/sdk/base/bd:a	(Landroid/content/Context;)V
    //   91: aload_0
    //   92: monitorexit
    //   93: lload 4
    //   95: lreturn
    //   96: astore_1
    //   97: aload_0
    //   98: monitorexit
    //   99: aload_1
    //   100: athrow
    //   101: astore_1
    //   102: lconst_0
    //   103: lstore 4
    //   105: goto -14 -> 91
    //   108: astore_1
    //   109: goto -18 -> 91
    //   112: astore 8
    //   114: goto -47 -> 67
    //   117: lconst_0
    //   118: lstore 4
    //   120: goto -41 -> 79
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	123	0	this	as
    //   0	123	1	paramContext	Context
    //   0	123	2	paramInt	int
    //   0	123	3	paramBoolean	boolean
    //   9	110	4	l1	long
    //   70	3	6	l2	long
    //   14	18	8	localbd	bd
    //   112	1	8	localThrowable	Throwable
    //   23	13	9	str	String
    //   29	9	10	localaw	aw
    // Exception table:
    //   from	to	target	type
    //   6	11	96	finally
    //   11	31	96	finally
    //   31	67	96	finally
    //   67	72	96	finally
    //   79	91	96	finally
    //   6	11	101	java/lang/Throwable
    //   67	72	101	java/lang/Throwable
    //   79	91	108	java/lang/Throwable
    //   11	31	112	java/lang/Throwable
    //   31	67	112	java/lang/Throwable
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
    throw new Runtime("d2j fail translate: java.lang.RuntimeException: can not merge Z and I\r\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.useAs(TypeTransformer.java:868)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.enexpr(TypeTransformer.java:668)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:719)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:703)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.enexpr(TypeTransformer.java:698)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:719)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:703)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.enexpr(TypeTransformer.java:698)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:719)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:703)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.s1stmt(TypeTransformer.java:810)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.sxStmt(TypeTransformer.java:840)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:206)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\r\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\r\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\r\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\r\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\r\n");
  }
  
  public final ao a(Context paramContext, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3)
  {
    for (;;)
    {
      try
      {
        localObject1 = (ConnectivityManager)paramContext.getSystemService("connectivity");
        if (localObject1 != null) {
          continue;
        }
        k = 0;
      }
      catch (Throwable localThrowable1)
      {
        Object localObject1;
        boolean bool;
        localObject2 = localThrowable1.getMessage();
        int m = 0;
        int k = m;
        if (localObject2 == null) {
          continue;
        }
        k = m;
        if (!((String)localObject2).contains("ACCESS_NETWORK_STATE")) {
          continue;
        }
        k = 1;
        continue;
        if (this.d.e()) {
          continue;
        }
        localObject2 = cm.a();
        if (Math.abs(System.currentTimeMillis() / 1000L - this.g.f((Context)localObject2) / 1000L) > 3600L) {
          continue;
        }
        k = 0;
        if (k != 0) {
          continue;
        }
        k = 0;
        if (k != 0) {
          continue;
        }
        return ao.a(-10011);
        k = 1;
        continue;
        localObject2 = this.g.a(cm.a(), 6);
        if (((v)localObject2).b() != 0) {
          continue;
        }
        k = 1;
        continue;
        l1 = this.g.e(cm.a());
        if (l1 > 0L) {
          continue;
        }
        k = 1;
        if (k != 0) {
          continue;
        }
        if (!paramBoolean2) {
          continue;
        }
        continue;
        long l2 = ((Long)((v)localObject2).b.getLast()).longValue();
        l2 = Math.abs(System.currentTimeMillis() - l2);
        localObject3 = c;
        if (l1 >= localObject3.length) {
          continue;
        }
        k = (int)l1;
        if (k < 1) {
          continue;
        }
        localObject3 = c;
        m = localObject3[(k - 1)];
        k = localObject3[k];
        if (m >= k) {
          continue;
        }
        k = new Random().nextInt(k - m + 1);
        if (l2 > TimeUnit.SECONDS.toMillis(k + m)) {
          continue;
        }
        k = 0;
        continue;
        k = localObject3.length - 1;
        continue;
        continue;
        localObject3 = (Long)((v)localObject2).a();
        if (((v)localObject2).b() < ((v)localObject2).a) {
          continue;
        }
        if (Math.abs(System.currentTimeMillis() - ((Long)localObject3).longValue()) < b) {
          continue;
        }
        continue;
        throw new IllegalArgumentException("");
        localObject2 = this.g.a(cm.a(), 6);
        ((v)localObject2).a(Long.valueOf(System.currentTimeMillis()));
        this.g.a(cm.a(), (v)localObject2);
        localObject2 = ae.b(paramContext);
        if (TextUtils.isEmpty((CharSequence)localObject2)) {
          continue;
        }
        this.g.b(paramContext, (String)localObject2);
        bj.a(paramContext, this.g);
        bj.b(paramContext, this.g);
      }
      if (k != 0) {
        continue;
      }
      return ao.a(-10012);
      localObject1 = ((ConnectivityManager)localObject1).getActiveNetworkInfo();
      if (localObject1 != null)
      {
        bool = ((NetworkInfo)localObject1).isConnected();
        if (bool)
        {
          k = 1;
          continue;
        }
      }
      k = 0;
    }
    try
    {
      Object localObject3;
      Object localObject2 = a(paramContext, paramBoolean1, paramBoolean3);
      if (((ao)localObject2).d == -30015)
      {
        this.g.c(paramContext, System.currentTimeMillis());
        l1 = this.g.e(paramContext);
        if (((ao)localObject2).d >= 0) {
          break label729;
        }
        this.g.b(paramContext, l1 + 1L);
        if (!TextUtils.isEmpty(this.g.d(paramContext))) {
          this.g.b(paramContext, "");
        }
        if (((ao)localObject2).d == 0)
        {
          bj.c(paramContext, this.g);
          localObject3 = be.a();
          aw localaw = this.g;
          if (((be)localObject3).a(paramContext, localaw))
          {
            l1 = System.currentTimeMillis();
            localaw.a(paramContext, "112", "" + l1, false);
          }
        }
        this.g.a(paramContext, ((ao)localObject2).d, paramBoolean1);
        return localObject2;
      }
    }
    catch (Throwable localThrowable2)
    {
      for (;;)
      {
        long l1;
        ao localao = ao.a(-10015);
        continue;
        if (this.g.f(paramContext) != 0L)
        {
          this.g.c(paramContext, 0L);
          continue;
          label729:
          if (l1 != 0L) {
            this.g.b(paramContext, 0L);
          }
        }
      }
    }
  }
  
  public final ao a(ao paramao, final Context paramContext, final boolean paramBoolean1, boolean paramBoolean2)
  {
    synchronized (this.h)
    {
      ??? = a(paramContext);
      if ((??? != paramao) && (a((ao)???) == 1)) {
        return ???;
      }
    }
    synchronized (this.j)
    {
      if (!((Boolean)this.j.get()).booleanValue())
      {
        this.j.set(Boolean.valueOf(true));
        this.e.post(new a(paramContext, paramBoolean1));
      }
      for (;;)
      {
        try
        {
          AtomicReference localAtomicReference = this.j;
          if (!paramBoolean2) {
            continue;
          }
          l = this.d.g();
          localAtomicReference.wait(l);
        }
        catch (InterruptedException localInterruptedException)
        {
          long l;
          continue;
        }
        paramContext = a(paramContext);
        if (paramContext == paramao) {
          continue;
        }
        return paramContext;
        paramao = finally;
        throw paramao;
        l = 10000L;
      }
      paramao = ao.a(-10004);
      return paramao;
    }
  }
  
  public final av a(Context paramContext, byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    paramContext = e.a().a(paramInt1, paramInt2, 1, paramArrayOfByte, this.d.g());
    if (paramContext == null) {}
    for (paramContext = new av(-20000, av.a);; paramContext = new av(0, paramContext))
    {
      if (paramContext.b != 0) {}
      return paramContext;
    }
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
    for (;;)
    {
      ao localao;
      if (k < this.d.h())
      {
        localao = a(???, paramBoolean, bool, false);
        a(localao, true);
        if (localao.d != 0) {}
      }
      else
      {
        label49:
        if (bool) {
          this.g.a(???, false);
        }
      }
      synchronized (this.j)
      {
        this.j.set(Boolean.valueOf(false));
        this.j.notifyAll();
        return;
        if (localao.d == -30014) {
          break label49;
        }
        k += 1;
      }
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
    //   15: ifne +18 -> 33
    //   18: aload_1
    //   19: getfield 115	com/tencent/turingfd/sdk/base/ao:d	I
    //   22: ifeq +11 -> 33
    //   25: aload_3
    //   26: monitorexit
    //   27: return
    //   28: astore_1
    //   29: aload_3
    //   30: monitorexit
    //   31: aload_1
    //   32: athrow
    //   33: aload_0
    //   34: getfield 65	com/tencent/turingfd/sdk/base/as:i	Ljava/util/concurrent/atomic/AtomicReference;
    //   37: aload_1
    //   38: invokevirtual 192	java/util/concurrent/atomic/AtomicReference:set	(Ljava/lang/Object;)V
    //   41: aload_3
    //   42: monitorexit
    //   43: return
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	44	0	this	as
    //   0	44	1	paramao	ao
    //   0	44	2	paramBoolean	boolean
    //   4	38	3	localAtomicReference	AtomicReference
    // Exception table:
    //   from	to	target	type
    //   11	13	28	finally
    //   18	27	28	finally
    //   29	31	28	finally
    //   33	43	28	finally
  }
  
  public final void a(boolean paramBoolean)
  {
    throw new Runtime("d2j fail translate: java.lang.RuntimeException: can not merge I and Z\r\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.provideAs(TypeTransformer.java:780)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.enexpr(TypeTransformer.java:659)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:719)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:703)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.enexpr(TypeTransformer.java:698)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:719)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:703)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.s1stmt(TypeTransformer.java:810)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.sxStmt(TypeTransformer.java:840)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:206)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\r\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\r\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\r\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\r\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\r\n");
  }
  
  public final ao b(Context paramContext, boolean paramBoolean)
  {
    ao localao = a(paramContext);
    int k = a(localao);
    if (k == 1) {}
    do
    {
      return localao;
      if (k == 2)
      {
        if (Looper.myLooper() == Looper.getMainLooper())
        {
          a();
          return ao.a(-10008);
        }
        return a(localao, paramContext, false, paramBoolean);
      }
    } while (k != 3);
    a();
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