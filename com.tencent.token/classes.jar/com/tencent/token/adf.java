package com.tencent.token;

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

public final class adf
{
  public static adf a = new adf();
  public static long b = TimeUnit.MINUTES.toMillis(30L);
  public static int[] c = { 0, 15, 30, 90, 240, 360, 600, 1200, 2400, 3200, 4800, 7200 };
  public afh d;
  public Handler e;
  public boolean f = false;
  public adj g;
  public final Object h = new Object();
  public final AtomicReference<adb> i = new AtomicReference(null);
  public final AtomicReference<Boolean> j = new AtomicReference(Boolean.FALSE);
  
  private int a(adb paramadb)
  {
    if (this.d.f) {
      return 2;
    }
    if ((paramadb.d == 0) && (!TextUtils.isEmpty(paramadb.b)))
    {
      long l1 = System.currentTimeMillis() / 1000L;
      if (l1 >= paramadb.c)
      {
        if (this.d.g) {
          return 2;
        }
        return 3;
      }
      long l2 = adj.c(aez.a());
      if (Math.abs(l1 - adj.c(aez.a(), "108")) >= l2)
      {
        if (this.d.g) {
          return 2;
        }
        return 3;
      }
      return 1;
    }
    return 2;
  }
  
  private adb a(Context paramContext)
  {
    synchronized (this.i)
    {
      adb localadb2 = (adb)this.i.get();
      adb localadb1 = localadb2;
      if (localadb2 == null)
      {
        localadb1 = adj.b(paramContext);
        this.i.set(localadb1);
      }
      return localadb1;
    }
  }
  
  private adb a(Context paramContext, boolean paramBoolean1, boolean paramBoolean2)
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
      return adb.a(-10012);
    }
    Object localObject3;
    if (!this.d.f)
    {
      localObject2 = aez.a();
      if (Math.abs(System.currentTimeMillis() / 1000L - adj.c((Context)localObject2, "109") / 1000L) <= 3600L) {
        k = 0;
      } else {
        k = 1;
      }
      if (k != 0)
      {
        localObject2 = adj.f(aez.a());
        k = m;
        if (((aci)localObject2).b.size() == 0) {
          break label426;
        }
        l1 = adj.e(aez.a());
        if (l1 > 0L)
        {
          long l2 = ((Long)((aci)localObject2).b.getLast()).longValue();
          l2 = Math.abs(System.currentTimeMillis() - l2);
          localObject3 = c;
          if (l1 < localObject3.length) {
            k = (int)l1;
          } else {
            k = localObject3.length - 1;
          }
          if (k > 0)
          {
            localObject3 = c;
            int n = localObject3[(k - 1)];
            k = localObject3[k];
            if (n < k)
            {
              k = new Random().nextInt(k - n + 1);
              if (l2 <= TimeUnit.SECONDS.toMillis(k + n))
              {
                k = 0;
                break label348;
              }
            }
            else
            {
              throw new IllegalArgumentException("");
            }
          }
        }
        k = 1;
        label348:
        if (k == 0)
        {
          if (paramBoolean2)
          {
            k = m;
            break label426;
          }
        }
        else
        {
          localObject3 = (Long)((aci)localObject2).b.getFirst();
          k = m;
          if (((aci)localObject2).b.size() < ((aci)localObject2).a) {
            break label426;
          }
          if (Math.abs(System.currentTimeMillis() - ((Long)localObject3).longValue()) >= b)
          {
            k = m;
            break label426;
          }
        }
      }
      k = 0;
      label426:
      if (k == 0) {
        return adb.a(-10011);
      }
    }
    Object localObject2 = adj.f(aez.a());
    ((aci)localObject2).a(Long.valueOf(System.currentTimeMillis()));
    this.g.a(aez.a(), (aci)localObject2);
    localObject2 = acr.a(paramContext);
    if (!TextUtils.isEmpty((CharSequence)localObject2)) {
      this.g.b(paramContext, (String)localObject2);
    }
    adw.a(paramContext, this.g);
    adw.b(paramContext, this.g);
    try
    {
      localObject2 = b(paramContext, paramBoolean1);
    }
    catch (Throwable localThrowable2)
    {
      label520:
      adj localadj;
      StringBuilder localStringBuilder;
      break label520;
    }
    localObject2 = adb.a(-10015);
    if (((adb)localObject2).d == -30015) {
      this.g.b(paramContext, System.currentTimeMillis());
    } else if (adj.c(paramContext, "109") != 0L) {
      this.g.b(paramContext, 0L);
    }
    long l1 = adj.e(paramContext);
    if (((adb)localObject2).d < 0) {
      this.g.a(paramContext, l1 + 1L);
    } else if (l1 != 0L) {
      this.g.a(paramContext, 0L);
    }
    if (!TextUtils.isEmpty(adj.d(paramContext))) {
      this.g.b(paramContext, "");
    }
    if (((adb)localObject2).d == 0)
    {
      adw.c(paramContext, this.g);
      adr.a();
      localObject3 = this.g;
      if (adr.a(paramContext)) {
        ((adj)localObject3).a(paramContext, "112", String.valueOf(System.currentTimeMillis()), false);
      }
    }
    localadj = this.g;
    l1 = ((adb)localObject2).d;
    localStringBuilder = new StringBuilder();
    localStringBuilder.append(l1);
    localStringBuilder.append("_");
    if (paramBoolean1) {
      localObject3 = "1";
    } else {
      localObject3 = "0";
    }
    localStringBuilder.append((String)localObject3);
    localadj.a(paramContext, "204", localStringBuilder.toString());
    return localObject2;
  }
  
  private adb a(adb paramadb, final Context paramContext, boolean paramBoolean)
  {
    synchronized (this.h)
    {
      ??? = a(paramContext);
      if ((??? != paramadb) && (a((adb)???) == 1)) {
        return ???;
      }
      synchronized (this.j)
      {
        if (!((Boolean)this.j.get()).booleanValue())
        {
          this.j.set(Boolean.valueOf(true));
          this.e.post(new a(paramContext));
        }
        try
        {
          localAtomicReference = this.j;
          if (!paramBoolean) {
            break label169;
          }
          l = this.d.n;
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
        if (paramContext != paramadb) {
          return paramContext;
        }
        paramadb = adb.a(-10004);
        return paramadb;
      }
    }
  }
  
  private adi a(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    paramArrayOfByte = abr.a().a(paramInt1, paramInt2, paramArrayOfByte, this.d.n);
    if (paramArrayOfByte == null) {
      paramArrayOfByte = new adi(-20000, adi.a);
    } else {
      paramArrayOfByte = new adi(0, paramArrayOfByte);
    }
    if (paramArrayOfByte.b != 0) {}
    return paramArrayOfByte;
  }
  
  private void a()
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
  
  /* Error */
  private void a(adb paramadb, boolean paramBoolean)
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 65	com/tencent/token/adf:i	Ljava/util/concurrent/atomic/AtomicReference;
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
    //   19: getfield 84	com/tencent/token/adb:d	I
    //   22: ifeq +6 -> 28
    //   25: aload_3
    //   26: monitorexit
    //   27: return
    //   28: aload_0
    //   29: getfield 65	com/tencent/token/adf:i	Ljava/util/concurrent/atomic/AtomicReference;
    //   32: aload_1
    //   33: invokevirtual 139	java/util/concurrent/atomic/AtomicReference:set	(Ljava/lang/Object;)V
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
    //   0	47	0	this	adf
    //   0	47	1	paramadb	adb
    //   0	47	2	paramBoolean	boolean
    //   4	36	3	localAtomicReference	AtomicReference
    // Exception table:
    //   from	to	target	type
    //   11	13	43	finally
    //   18	27	43	finally
    //   28	38	43	finally
    //   39	41	43	finally
  }
  
  private adb b(Context paramContext, boolean paramBoolean)
  {
    throw new Runtime("d2j fail translate: java.lang.RuntimeException: can not merge Z and I\r\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.useAs(TypeTransformer.java:868)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.enexpr(TypeTransformer.java:668)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:719)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:703)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.s1stmt(TypeTransformer.java:810)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.sxStmt(TypeTransformer.java:840)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:206)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\r\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\r\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\r\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\r\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\r\n");
  }
  
  private long c(Context paramContext, boolean paramBoolean)
  {
    throw new Runtime("d2j fail translate: java.lang.RuntimeException: can not merge I and Z\r\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.provideAs(TypeTransformer.java:780)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.e1expr(TypeTransformer.java:496)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:713)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:703)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.enexpr(TypeTransformer.java:698)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:719)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:703)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.s1stmt(TypeTransformer.java:810)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.sxStmt(TypeTransformer.java:840)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:206)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\r\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\r\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\r\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\r\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\r\n");
  }
  
  public final adb a(Context paramContext, boolean paramBoolean)
  {
    adb localadb = a(paramContext);
    int k = a(localadb);
    if (k == 1) {
      return localadb;
    }
    if (k == 2)
    {
      if (Looper.myLooper() == Looper.getMainLooper())
      {
        a();
        return adb.a(-10008);
      }
      return a(localadb, paramContext, paramBoolean);
    }
    if (k == 3) {
      a();
    }
    return localadb;
  }
  
  public final class a
    implements Runnable
  {
    public a(Context paramContext) {}
    
    public final void run()
    {
      adf.b(adf.this, paramContext, this.b);
    }
  }
  
  public final class b
    extends Handler
  {
    public Context a;
    
    public b(Looper paramLooper, Context paramContext)
    {
      super();
      this.a = paramContext;
    }
    
    public final void handleMessage(Message arg1)
    {
      System.currentTimeMillis();
      int i = ???.what;
      if (i != 1)
      {
        if (i == 2)
        {
          ??? = adf.b(adf.this, this.a);
          adf.a(adf.this, ???);
          synchronized (adf.c(adf.this))
          {
            adf.c(adf.this).set(Boolean.valueOf(false));
            adf.c(adf.this).notifyAll();
            return;
          }
        }
      }
      else {
        adf.a(adf.this, this.a, true);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.adf
 * JD-Core Version:    0.7.0.1
 */