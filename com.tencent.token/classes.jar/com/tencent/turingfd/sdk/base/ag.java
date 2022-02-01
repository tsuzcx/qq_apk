package com.tencent.turingfd.sdk.base;

import android.app.Activity;
import android.content.Context;
import java.lang.ref.WeakReference;
import java.util.ArrayList;

public class ag
{
  public static ak a;
  public static ak b;
  public static ak c;
  public static boolean d = false;
  public static cu e;
  public static Filbert f;
  public static boolean g = true;
  public static final f h = new a();
  public static final h i = new c();
  
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
  
  public static void a(int paramInt1, int paramInt2, ak paramak, Lemon paramLemon)
  {
    paramak.b();
    at.b localb = new at.b(cm.a(), paramInt1, null);
    paramInt1 = paramak.h;
    if (paramInt1 < 1) {
      localb.b = 1L;
    } else if (paramInt1 > 12) {
      localb.b = 12L;
    } else {
      localb.b = paramInt1;
    }
    localb.f = paramLemon;
    localb.d = new b(paramak);
    localb.e = paramInt2;
    paramak = new at(localb, null);
    ((bb)bb.a.b()).a(paramak);
  }
  
  public static void a(cu paramcu)
  {
    try
    {
      cm.a(paramcu.j());
      e = paramcu;
      Object localObject1 = new Filbert();
      Object localObject2 = new Ginkgo();
      ((Filbert)localObject1).metaData = paramcu.y();
      ((Ginkgo)localObject2).version = paramcu.m();
      ((Ginkgo)localObject2).Nb = paramcu.l();
      ((Ginkgo)localObject2).S = paramcu.o();
      ((Ginkgo)localObject2).xc = paramcu.n();
      StringBuilder localStringBuilder = ci.a("");
      localStringBuilder.append(paramcu.b());
      ((Ginkgo)localObject2).yc = localStringBuilder.toString();
      ((Filbert)localObject1).rc = ((Ginkgo)localObject2);
      f = (Filbert)localObject1;
      boolean bool = d;
      if (bool) {
        return;
      }
      d = true;
      localObject1 = a.a();
      localObject2 = paramcu.j();
      c = ((a)localObject1).a((Context)localObject2, 100);
      if (c == null) {
        c = new ak((Context)localObject2, paramcu.w(), paramcu.x(), paramcu.v(), paramcu.u(), 100);
      }
      a = ((a)localObject1).a((Context)localObject2, 999);
      if (a == null) {
        a = new ak((Context)localObject2, 20, 12, 30, 3, 999);
      }
      b = ((a)localObject1).a((Context)localObject2, 998);
      if (b == null) {
        b = new ak((Context)localObject2, 3, 1, 3600, 6, 998);
      }
      e.a().a(paramcu.z());
      al.a(paramcu.j(), h, i);
      al.a();
      if (paramcu.r() != null) {
        al.a((Activity)paramcu.r().get());
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
    implements f
  {
    public void a(String paramString, int paramInt1, int paramInt2, Lemon paramLemon)
    {
      if ((paramInt1 == 100) && (ag.c.a())) {
        paramString = ag.c;
      } else if ((paramInt1 == 999) && (ag.a.a())) {
        paramString = ag.a;
      } else {
        paramString = null;
      }
      if (paramString != null) {
        ag.a(paramInt1, paramInt2, paramString, paramLemon);
      }
    }
  }
  
  public static final class b
    implements ar
  {
    public b(ak paramak) {}
  }
  
  public static final class c
    implements h
  {
    public void a(Activity paramActivity) {}
    
    public void b(Activity paramActivity) {}
  }
  
  public static final class d
    extends Thread
  {
    public void run() {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.turingfd.sdk.base.ag
 * JD-Core Version:    0.7.0.1
 */