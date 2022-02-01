package com.tencent.turingfd.sdk.base;

import android.content.Context;
import android.os.HandlerThread;
import android.text.TextUtils;
import android.util.Log;
import java.util.Locale;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;

public class cz
{
  public static AtomicBoolean a = new AtomicBoolean(false);
  public static AtomicBoolean b = new AtomicBoolean(false);
  public static final Object c;
  public static AtomicBoolean d;
  
  static
  {
    new AtomicBoolean(false);
    c = new Object();
    d = new AtomicBoolean(false);
    Log.d("TuringFdJava", b());
  }
  
  public static int a()
  {
    if (!a.get()) {
      return -10001;
    }
    if (!b.get()) {
      return -10002;
    }
    return 0;
  }
  
  public static cf a(Context paramContext)
  {
    int i = a();
    if (i != 0) {
      return ao.a(i);
    }
    return as.a.b(paramContext, true);
  }
  
  public static void a(cu paramcu)
  {
    if (d.get()) {
      return;
    }
    synchronized (c)
    {
      if ((paramcu.b > 0) && (cv.a == 0)) {
        cv.a = paramcu.b;
      }
      if (b.get())
      {
        b(paramcu);
        return;
      }
      if (d.get()) {
        return;
      }
      d.set(true);
      if (!c(paramcu))
      {
        b.set(false);
        return;
      }
      int i = cv.a;
      if (i == 0)
      {
        Log.i("TuringFdJava", "error channel");
        b.set(false);
        return;
      }
      b(paramcu);
      b.set(true);
      d.set(false);
      return;
    }
  }
  
  public static String b()
  {
    return String.format(Locale.getDefault(), "TuringFD v%d (l%s, t%d, %s, %s, e%d, d%d, p%d, compiled %s)", new Object[] { Integer.valueOf(49), "09AEBC42447E1917", Integer.valueOf(1), "baseFull", "taf", Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), "2020_06_09_16_55_48" });
  }
  
  public static void b(cu paramcu)
  {
    Object localObject1 = ci.a("channel : ");
    ((StringBuilder)localObject1).append(cv.a);
    Log.i("TuringFdJava", ((StringBuilder)localObject1).toString());
    localObject1 = as.a;
    ((as)localObject1).d = paramcu;
    if (!((as)localObject1).f)
    {
      ((as)localObject1).f = true;
      cm.a(paramcu.j());
      e.a().a(paramcu.z());
      Object localObject2 = bd.a;
      paramcu.j();
      ((bd)localObject2).f = new ap((as)localObject1);
      localObject2 = ci.a("TuringFdCore_49_");
      ((StringBuilder)localObject2).append(cv.a);
      ((StringBuilder)localObject2).append("_");
      ((StringBuilder)localObject2).append("baseFull");
      localObject2 = new HandlerThread(((StringBuilder)localObject2).toString(), -8);
      ((HandlerThread)localObject2).start();
      ((as)localObject1).e = new as.b((as)localObject1, ((HandlerThread)localObject2).getLooper(), paramcu.j());
      ((as)localObject1).g = new aw(((as)localObject1).e);
      localObject2 = paramcu.j();
      if (bm.a.containsKey(bm.c)) {
        new bl((bm.a)bm.a.get(bm.c), (Context)localObject2).start();
      }
      if (((as)localObject1).d.d()) {
        new aq((as)localObject1).start();
      }
    }
    ag.a(paramcu);
  }
  
  public static boolean c(cu paramcu)
  {
    if (a.get()) {
      return a.get();
    }
    boolean bool2 = paramcu.c();
    boolean bool1 = true;
    if (bool2)
    {
      TextUtils.isEmpty(paramcu.p());
      paramcu = paramcu.p();
      try
      {
        bool2 = TextUtils.isEmpty(paramcu);
        if (bool2) {
          System.loadLibrary("turingbase");
        } else {
          System.load(paramcu);
        }
      }
      catch (Throwable paramcu)
      {
        Log.w("TuringFdJava", paramcu);
        bool1 = false;
      }
      a.set(bool1);
      if (!bool1) {
        Log.i("TuringFdJava", "load so failure");
      }
    }
    else
    {
      a.set(true);
    }
    return a.get();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.turingfd.sdk.base.cz
 * JD-Core Version:    0.7.0.1
 */