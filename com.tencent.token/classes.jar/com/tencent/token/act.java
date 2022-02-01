package com.tencent.token;

import android.app.Activity;
import android.content.Context;
import com.tencent.turingfd.sdk.base.Filbert;
import com.tencent.turingfd.sdk.base.Ginkgo;
import com.tencent.turingfd.sdk.base.Lemon;
import java.lang.ref.WeakReference;
import java.util.ArrayList;

public final class act
{
  public static acx a;
  public static acx b;
  public static acx c;
  public static boolean d = false;
  public static afh e;
  public static Filbert f;
  public static boolean g = true;
  public static final abs h = new a();
  public static final abu i = new c();
  
  public static void a()
  {
    try
    {
      if (b.a())
      {
        b.b();
        new d().start();
      }
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public static void a(int paramInt1, int paramInt2, acx paramacx, Lemon paramLemon)
  {
    paramacx.b();
    adh.a locala = new adh.a(aez.a(), paramInt1);
    paramInt1 = paramacx.h;
    if (paramInt1 <= 0) {
      locala.b = 1L;
    } else if (paramInt1 > 12) {
      locala.b = 12L;
    } else {
      locala.b = paramInt1;
    }
    locala.f = paramLemon;
    locala.d = new b(paramacx);
    locala.e = paramInt2;
    paramacx = new adh(locala);
    ((ado)ado.a.b()).a(paramacx);
  }
  
  public static void a(afh paramafh)
  {
    try
    {
      aez.a(paramafh.a);
      e = paramafh;
      Object localObject1 = new Filbert();
      Object localObject2 = new Ginkgo();
      ((Filbert)localObject1).metaData = paramafh.m;
      ((Ginkgo)localObject2).version = paramafh.j;
      ((Ginkgo)localObject2).Nb = paramafh.i;
      ((Ginkgo)localObject2).S = paramafh.l;
      ((Ginkgo)localObject2).xc = paramafh.k;
      StringBuilder localStringBuilder = aev.a("");
      localStringBuilder.append(paramafh.q);
      ((Ginkgo)localObject2).yc = localStringBuilder.toString();
      ((Filbert)localObject1).rc = ((Ginkgo)localObject2);
      f = (Filbert)localObject1;
      boolean bool = d;
      if (bool) {
        return;
      }
      d = true;
      abn.a();
      localObject1 = paramafh.a;
      localObject2 = abn.a((Context)localObject1, 100);
      c = (acx)localObject2;
      if (localObject2 == null) {
        c = new acx((Context)localObject1, paramafh.x, paramafh.y, paramafh.w, paramafh.v, 100);
      }
      localObject2 = abn.a((Context)localObject1, 999);
      a = (acx)localObject2;
      if (localObject2 == null) {
        a = new acx((Context)localObject1, 20, 12, 30, 3, 999);
      }
      localObject2 = abn.a((Context)localObject1, 998);
      b = (acx)localObject2;
      if (localObject2 == null) {
        b = new acx((Context)localObject1, 3, 1, 3600, 6, 998);
      }
      abr.a().a(afh.c());
      acy.a(paramafh.a, h, i);
      acy.a();
      if (paramafh.t != null) {
        acy.a((Activity)paramafh.t.get());
      }
      a();
      return;
    }
    finally {}
  }
  
  public static void b()
  {
    try
    {
      Lemon localLemon = new Lemon();
      localLemon.od = System.currentTimeMillis();
      localLemon.duration = 0;
      localLemon.pd = new ArrayList();
      a(998, 0, b, localLemon);
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public static final class a
    implements abs
  {
    public final void a(String paramString, int paramInt1, int paramInt2, Lemon paramLemon)
    {
      if ((paramInt1 == 100) && (act.c.a())) {
        paramString = act.c;
      } else if ((paramInt1 == 999) && (act.a.a())) {
        paramString = act.a;
      } else {
        paramString = null;
      }
      if (paramString != null) {
        act.a(paramInt1, paramInt2, paramString, paramLemon);
      }
    }
  }
  
  public static final class b
    implements ade
  {
    public b(acx paramacx) {}
  }
  
  public static final class c
    implements abu
  {
    public final void a(Activity paramActivity) {}
    
    public final void b(Activity paramActivity) {}
  }
  
  public static final class d
    extends Thread
  {
    public final void run() {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.act
 * JD-Core Version:    0.7.0.1
 */