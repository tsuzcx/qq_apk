package com.tencent.token;

import android.app.Activity;
import android.content.Context;
import com.tencent.turingfd.sdk.base.Filbert;
import com.tencent.turingfd.sdk.base.Ginkgo;
import com.tencent.turingfd.sdk.base.Lemon;
import java.lang.ref.WeakReference;
import java.util.ArrayList;

public final class acs
{
  public static acw a;
  public static acw b;
  public static acw c;
  public static boolean d = false;
  public static afg e;
  public static Filbert f;
  public static boolean g = true;
  public static final abr h = new a();
  public static final abt i = new c();
  
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
  
  public static void a(int paramInt1, int paramInt2, acw paramacw, Lemon paramLemon)
  {
    paramacw.b();
    adg.a locala = new adg.a(aey.a(), paramInt1);
    paramInt1 = paramacw.h;
    if (paramInt1 <= 0) {
      locala.b = 1L;
    } else if (paramInt1 > 12) {
      locala.b = 12L;
    } else {
      locala.b = paramInt1;
    }
    locala.f = paramLemon;
    locala.d = new b(paramacw);
    locala.e = paramInt2;
    paramacw = new adg(locala);
    ((adn)adn.a.b()).a(paramacw);
  }
  
  public static void a(afg paramafg)
  {
    try
    {
      aey.a(paramafg.a);
      e = paramafg;
      Object localObject1 = new Filbert();
      Object localObject2 = new Ginkgo();
      ((Filbert)localObject1).metaData = paramafg.m;
      ((Ginkgo)localObject2).version = paramafg.j;
      ((Ginkgo)localObject2).Nb = paramafg.i;
      ((Ginkgo)localObject2).S = paramafg.l;
      ((Ginkgo)localObject2).xc = paramafg.k;
      StringBuilder localStringBuilder = aeu.a("");
      localStringBuilder.append(paramafg.q);
      ((Ginkgo)localObject2).yc = localStringBuilder.toString();
      ((Filbert)localObject1).rc = ((Ginkgo)localObject2);
      f = (Filbert)localObject1;
      boolean bool = d;
      if (bool) {
        return;
      }
      d = true;
      abm.a();
      localObject1 = paramafg.a;
      localObject2 = abm.a((Context)localObject1, 100);
      c = (acw)localObject2;
      if (localObject2 == null) {
        c = new acw((Context)localObject1, paramafg.x, paramafg.y, paramafg.w, paramafg.v, 100);
      }
      localObject2 = abm.a((Context)localObject1, 999);
      a = (acw)localObject2;
      if (localObject2 == null) {
        a = new acw((Context)localObject1, 20, 12, 30, 3, 999);
      }
      localObject2 = abm.a((Context)localObject1, 998);
      b = (acw)localObject2;
      if (localObject2 == null) {
        b = new acw((Context)localObject1, 3, 1, 3600, 6, 998);
      }
      abq.a().a(afg.c());
      acx.a(paramafg.a, h, i);
      acx.a();
      if (paramafg.t != null) {
        acx.a((Activity)paramafg.t.get());
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
    implements abr
  {
    public final void a(String paramString, int paramInt1, int paramInt2, Lemon paramLemon)
    {
      if ((paramInt1 == 100) && (acs.c.a())) {
        paramString = acs.c;
      } else if ((paramInt1 == 999) && (acs.a.a())) {
        paramString = acs.a;
      } else {
        paramString = null;
      }
      if (paramString != null) {
        acs.a(paramInt1, paramInt2, paramString, paramLemon);
      }
    }
  }
  
  public static final class b
    implements add
  {
    public b(acw paramacw) {}
  }
  
  public static final class c
    implements abt
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
 * Qualified Name:     com.tencent.token.acs
 * JD-Core Version:    0.7.0.1
 */