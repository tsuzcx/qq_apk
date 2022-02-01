package com.tencent.token;

import android.content.Context;
import android.os.HandlerThread;
import android.text.TextUtils;
import java.util.Locale;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;

public final class afm
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
    String.format(Locale.getDefault(), "TuringFD v%d (l%s, t%d, %s, %s, e%d, d%d, p%d, compiled %s)", new Object[] { Integer.valueOf(49), "09AEBC42447E1917", Integer.valueOf(1), "baseFull", "taf", Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), "2020_06_09_16_55_48" });
  }
  
  public static aes a(Context paramContext)
  {
    int i;
    if (!a.get()) {
      i = -10001;
    } else if (!b.get()) {
      i = -10002;
    } else {
      i = 0;
    }
    if (i != 0) {
      return adb.a(i);
    }
    return adf.a.a(paramContext, true);
  }
  
  public static void a(afh paramafh)
  {
    if (d.get()) {
      return;
    }
    synchronized (c)
    {
      if ((paramafh.b > 0) && (afi.a == 0)) {
        afi.a = paramafh.b;
      }
      if (b.get())
      {
        b(paramafh);
        return;
      }
      if (d.get()) {
        return;
      }
      d.set(true);
      if (!c(paramafh))
      {
        b.set(false);
        return;
      }
      if (afi.a == 0)
      {
        b.set(false);
        return;
      }
      b(paramafh);
      b.set(true);
      d.set(false);
      return;
    }
  }
  
  private static void b(afh paramafh)
  {
    aev.a("channel : ").append(afi.a);
    adf localadf = adf.a;
    localadf.d = paramafh;
    if (!localadf.f)
    {
      localadf.f = true;
      aez.a(paramafh.a);
      abr.a().a(afh.c());
      adq.a.f = new adc(localadf);
      Object localObject = aev.a("TuringFdCore_49_");
      ((StringBuilder)localObject).append(afi.a);
      ((StringBuilder)localObject).append("_baseFull");
      localObject = new HandlerThread(((StringBuilder)localObject).toString(), -8);
      ((HandlerThread)localObject).start();
      localadf.e = new adf.b(localadf, ((HandlerThread)localObject).getLooper(), paramafh.a);
      localadf.g = new adj(localadf.e);
      localObject = paramafh.a;
      if (adz.a.containsKey(adz.c)) {
        new ady((adz.a)adz.a.get(adz.c), (Context)localObject).start();
      }
      if (localadf.d.e) {
        new add(localadf).start();
      }
    }
    act.a(paramafh);
  }
  
  private static boolean c(afh paramafh)
  {
    if (a.get()) {
      return a.get();
    }
    boolean bool2 = paramafh.d;
    boolean bool1 = true;
    if (bool2)
    {
      TextUtils.isEmpty(paramafh.h);
      paramafh = paramafh.h;
    }
    try
    {
      bool2 = TextUtils.isEmpty(paramafh);
      if (bool2) {
        System.loadLibrary("turingbase");
      } else {
        System.load(paramafh);
      }
    }
    catch (Throwable paramafh)
    {
      label64:
      label83:
      break label64;
    }
    bool1 = false;
    a.set(bool1);
    break label83;
    a.set(true);
    return a.get();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.afm
 * JD-Core Version:    0.7.0.1
 */