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
  }
  
  public static String b()
  {
    return String.format(Locale.getDefault(), "TuringFD v%d (l%s, t%d, %s, %s, e%d, d%d, p%d, compiled %s)", new Object[] { Integer.valueOf(49), "09AEBC42447E1917", Integer.valueOf(1), "baseFull", "taf", Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), "2020_06_09_16_55_48" });
  }
  
  public static void b(cu paramcu)
  {
    Log.i("TuringFdJava", cv.a);
    as localas = as.a;
    localas.d = paramcu;
    if (localas.f) {}
    label227:
    for (;;)
    {
      ag.a(paramcu);
      return;
      localas.f = true;
      cm.a(paramcu.j());
      e.a().a(paramcu.z());
      Object localObject = bd.a;
      paramcu.j();
      ((bd)localObject).f = new ap(localas);
      localObject = new HandlerThread(cv.a + "_" + "baseFull", -8);
      ((HandlerThread)localObject).start();
      localas.e = new as.b(localas, ((HandlerThread)localObject).getLooper(), paramcu.j());
      localas.g = new aw(localas.e);
      localObject = paramcu.j();
      if (!bm.a.containsKey(bm.c)) {}
      for (;;)
      {
        if (!localas.d.d()) {
          break label227;
        }
        new aq(localas).start();
        break;
        new bl((bm.a)bm.a.get(bm.c), (Context)localObject).start();
      }
    }
  }
  
  public static boolean c(cu paramcu)
  {
    boolean bool1 = true;
    if (a.get()) {
      return a.get();
    }
    if (paramcu.c())
    {
      TextUtils.isEmpty(paramcu.p());
      paramcu = paramcu.p();
      try
      {
        boolean bool2 = TextUtils.isEmpty(paramcu);
        if (!bool2) {
          break label79;
        }
        System.loadLibrary("turingbase");
      }
      catch (Throwable paramcu)
      {
        for (;;)
        {
          Log.w("TuringFdJava", paramcu);
          bool1 = false;
        }
      }
      a.set(bool1);
      if (!bool1) {
        Log.i("TuringFdJava", "load so failure");
      }
    }
    for (;;)
    {
      return a.get();
      label79:
      System.load(paramcu);
      break;
      a.set(true);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.turingfd.sdk.base.cz
 * JD-Core Version:    0.7.0.1
 */