package com.tencent.token;

import android.content.Context;
import android.os.HandlerThread;
import android.text.TextUtils;
import java.util.Locale;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;

public final class afl
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
  
  public static aer a(Context paramContext)
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
      return ada.a(i);
    }
    return ade.a.a(paramContext, true);
  }
  
  public static void a(afg paramafg)
  {
    if (d.get()) {
      return;
    }
    synchronized (c)
    {
      if ((paramafg.b > 0) && (afh.a == 0)) {
        afh.a = paramafg.b;
      }
      if (b.get())
      {
        b(paramafg);
        return;
      }
      if (d.get()) {
        return;
      }
      d.set(true);
      if (!c(paramafg))
      {
        b.set(false);
        return;
      }
      if (afh.a == 0)
      {
        b.set(false);
        return;
      }
      b(paramafg);
      b.set(true);
      d.set(false);
      return;
    }
  }
  
  private static void b(afg paramafg)
  {
    aeu.a("channel : ").append(afh.a);
    ade localade = ade.a;
    localade.d = paramafg;
    if (!localade.f)
    {
      localade.f = true;
      aey.a(paramafg.a);
      abq.a().a(afg.c());
      adp.a.f = new adb(localade);
      Object localObject = aeu.a("TuringFdCore_49_");
      ((StringBuilder)localObject).append(afh.a);
      ((StringBuilder)localObject).append("_baseFull");
      localObject = new HandlerThread(((StringBuilder)localObject).toString(), -8);
      ((HandlerThread)localObject).start();
      localade.e = new ade.b(localade, ((HandlerThread)localObject).getLooper(), paramafg.a);
      localade.g = new adi(localade.e);
      localObject = paramafg.a;
      if (ady.a.containsKey(ady.c)) {
        new adx((ady.a)ady.a.get(ady.c), (Context)localObject).start();
      }
      if (localade.d.e) {
        new adc(localade).start();
      }
    }
    acs.a(paramafg);
  }
  
  private static boolean c(afg paramafg)
  {
    if (a.get()) {
      return a.get();
    }
    boolean bool2 = paramafg.d;
    boolean bool1 = true;
    if (bool2)
    {
      TextUtils.isEmpty(paramafg.h);
      paramafg = paramafg.h;
    }
    try
    {
      bool2 = TextUtils.isEmpty(paramafg);
      if (bool2) {
        System.loadLibrary("turingbase");
      } else {
        System.load(paramafg);
      }
    }
    catch (Throwable paramafg)
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
 * Qualified Name:     com.tencent.token.afl
 * JD-Core Version:    0.7.0.1
 */