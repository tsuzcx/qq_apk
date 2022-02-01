package com.tencent.token;

import android.content.Context;
import android.text.TextUtils;
import com.qq.taf.jce.JceStruct;
import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicReference;

public final class apv
{
  private final boolean a = false;
  private final String b = "GuidCertifier";
  private Context c;
  private aqh d;
  private volatile boolean e = false;
  private volatile String f;
  private volatile long g = 0L;
  
  public apv(Context paramContext, aqh paramaqh)
  {
    this.c = paramContext;
    this.d = paramaqh;
    this.f = this.d.a.e();
    if (TextUtils.isEmpty(this.f))
    {
      this.e = false;
      this.f = this.d.a.f();
      return;
    }
    this.e = true;
  }
  
  private static void a(ag paramag)
  {
    new StringBuilder("printCSRegist()CSRegist.imei: ").append(paramag.a);
    new StringBuilder("printCSRegist()CSRegist.imsi: ").append(paramag.b);
    new StringBuilder("printCSRegist()CSRegist.mac: ").append(paramag.c);
    new StringBuilder("printCSRegist()CSRegist.qq: ").append(paramag.d);
    new StringBuilder("printCSRegist()CSRegist.phone: ").append(paramag.e);
    new StringBuilder("printCSRegist()CSRegist.product: ").append(paramag.f);
    new StringBuilder("printCSRegist()CSRegist.lc: ").append(paramag.g);
    new StringBuilder("printCSRegist()CSRegist.buildno: ").append(paramag.h);
    new StringBuilder("printCSRegist()CSRegist.channelid: ").append(paramag.i);
    new StringBuilder("printCSRegist()CSRegist.platform: ").append(paramag.j);
    new StringBuilder("printCSRegist()CSRegist.subplatform: ").append(paramag.k);
    new StringBuilder("printCSRegist()CSRegist.isbuildin: ").append(paramag.l);
    new StringBuilder("printCSRegist()CSRegist.pkgname: ").append(paramag.m);
    new StringBuilder("printCSRegist()CSRegist.ua: ").append(paramag.n);
    new StringBuilder("printCSRegist()CSRegist.sdkver: ").append(paramag.o);
    new StringBuilder("printCSRegist()CSRegist.androidid: ").append(paramag.p);
    new StringBuilder("printCSRegist()CSRegist.lang: ").append(paramag.q);
    new StringBuilder("printCSRegist()CSRegist.simnum: ").append(paramag.r);
    new StringBuilder("printCSRegist()CSRegist.cpu: ").append(paramag.s);
    new StringBuilder("printCSRegist()CSRegist.cpufreq: ").append(paramag.t);
    new StringBuilder("printCSRegist()CSRegist.cpunum: ").append(paramag.u);
    new StringBuilder("printCSRegist()CSRegist.resolution: ").append(paramag.v);
    new StringBuilder("printCSRegist()CSRegist.ram: ").append(paramag.w);
    new StringBuilder("printCSRegist()CSRegist.rom: ").append(paramag.x);
    new StringBuilder("printCSRegist()CSRegist.sdcard: ").append(paramag.y);
    new StringBuilder("printCSRegist()CSRegist.build_brand: ").append(paramag.z);
    new StringBuilder("printCSRegist()CSRegist.build_version_incremental: ").append(paramag.A);
    new StringBuilder("printCSRegist()CSRegist.build_version_release: ").append(paramag.B);
    new StringBuilder("printCSRegist()CSRegist.version: ").append(paramag.P);
    new StringBuilder("printCSRegist()CSRegist.extSdkVer: ").append(paramag.Q);
    new StringBuilder("printCSRegist()CSRegist.pkgkey: ").append(paramag.R);
  }
  
  private void a(String paramString, ag paramag)
  {
    if (TextUtils.isEmpty(paramString)) {
      return;
    }
    this.f = paramString;
    this.e = true;
    this.d.a.c(paramString);
    this.d.a.a(paramag);
  }
  
  private static boolean a(int paramInt1, int paramInt2)
  {
    return paramInt1 != paramInt2;
  }
  
  private static boolean a(long paramLong1, long paramLong2)
  {
    return paramLong1 != paramLong2;
  }
  
  private static boolean a(String paramString1, String paramString2)
  {
    if (TextUtils.isEmpty(paramString1)) {
      return false;
    }
    if (TextUtils.isEmpty(paramString2)) {
      return true;
    }
    return !paramString1.equals(paramString2);
  }
  
  private ag e()
  {
    ag localag = this.d.a.h();
    if (localag.a == null) {
      localag.a = "";
    }
    return localag;
  }
  
  public final boolean a()
  {
    return (TextUtils.isEmpty(d())) || (!this.e);
  }
  
  public final String b()
  {
    if (!a())
    {
      new StringBuilder("checkGuid() !need, mGuid: ").append(this.f);
      return this.f;
    }
    Object localObject1 = this.d.d.b();
    new StringBuilder("checkGuid() encodeKey: ").append(localObject1);
    ag localag = e();
    Object localObject3 = new ai();
    ((ai)localObject3).b = this.d.b.a();
    ((ai)localObject3).a = 1;
    ((ai)localObject3).d = apu.a(((aqe)localObject1).b.getBytes(), localag);
    a(localag);
    Object localObject2 = new ArrayList();
    ((ArrayList)localObject2).add(localObject3);
    localObject3 = new AtomicReference();
    if (this.d.a(false, true, false, (aqe)localObject1, (ArrayList)localObject2, (AtomicReference)localObject3) != 0) {
      return null;
    }
    localObject1 = (ArrayList)((AtomicReference)localObject3).get();
    if (localObject1 == null) {
      return null;
    }
    if (((ArrayList)localObject1).size() <= 0) {
      return null;
    }
    localObject1 = (al)((ArrayList)localObject1).get(0);
    if (localObject1 == null) {
      return null;
    }
    localObject2 = new StringBuilder("checkGuid() rs.seqNo: ");
    ((StringBuilder)localObject2).append(((al)localObject1).b);
    ((StringBuilder)localObject2).append(" rs.cmd: ");
    ((StringBuilder)localObject2).append(((al)localObject1).a);
    ((StringBuilder)localObject2).append(" rs.retCode: ");
    ((StringBuilder)localObject2).append(((al)localObject1).d);
    ((StringBuilder)localObject2).append(" rs.dataRetCode: ");
    ((StringBuilder)localObject2).append(((al)localObject1).e);
    if (1 == ((al)localObject1).d) {
      return null;
    }
    if (((al)localObject1).e != 0) {
      return null;
    }
    localObject2 = ((al)localObject1).f;
    if (localObject2 == null) {
      return null;
    }
    new StringBuilder("checkGuid() rs.data.length: ").append(((al)localObject1).f.length);
    localObject1 = new ak();
    try
    {
      localObject1 = apu.a(this.d.d.b().b.getBytes(), (byte[])localObject2, (JceStruct)localObject1);
      if (localObject1 == null) {
        return null;
      }
      a(((ak)localObject1).a, localag);
      new StringBuilder("checkGuid() ret.guid mGuid: ").append(this.f);
      return this.f;
    }
    catch (Exception localException) {}
    return null;
  }
  
  public final boolean c()
  {
    long l = System.currentTimeMillis();
    int i;
    if (!apc.a(l, this.g, 720))
    {
      i = 0;
    }
    else
    {
      this.g = l;
      i = 1;
    }
    Object localObject1 = null;
    boolean bool1;
    if (i == 0)
    {
      l = System.currentTimeMillis();
      if (l - this.d.a.i() > 86400000L) {
        i = 1;
      } else {
        i = 0;
      }
      if (i != 0)
      {
        this.d.a.a(l);
        localObject2 = e();
        localObject3 = this.d.a.g();
        if (localObject2 != null)
        {
          a((ag)localObject3);
          bool1 = a(((ag)localObject2).a, ((ag)localObject3).a);
          boolean bool2 = a(((ag)localObject2).b, ((ag)localObject3).b);
          boolean bool3 = a(((ag)localObject2).c, ((ag)localObject3).c);
          boolean bool4 = a(((ag)localObject2).d, ((ag)localObject3).d);
          boolean bool5 = a(((ag)localObject2).e, ((ag)localObject3).e);
          boolean bool6 = a(((ag)localObject2).f, ((ag)localObject3).f);
          boolean bool7 = a(((ag)localObject2).g, ((ag)localObject3).g);
          boolean bool8 = a(((ag)localObject2).h, ((ag)localObject3).h);
          boolean bool9 = a(((ag)localObject2).i, ((ag)localObject3).i);
          boolean bool10 = a(((ag)localObject2).j, ((ag)localObject3).j);
          boolean bool11 = a(((ag)localObject2).k, ((ag)localObject3).k);
          if (((ag)localObject2).l != ((ag)localObject3).l) {
            i = 1;
          } else {
            i = 0;
          }
          boolean bool12 = a(((ag)localObject2).m, ((ag)localObject3).m);
          boolean bool13 = a(((ag)localObject2).n, ((ag)localObject3).n);
          boolean bool14 = a(((ag)localObject2).o, ((ag)localObject3).o);
          boolean bool15 = a(((ag)localObject2).p, ((ag)localObject3).p);
          boolean bool16 = a(((ag)localObject2).q, ((ag)localObject3).q);
          boolean bool17 = a(((ag)localObject2).r, ((ag)localObject3).r);
          boolean bool18 = a(((ag)localObject2).s, ((ag)localObject3).s);
          boolean bool19 = a(((ag)localObject2).t, ((ag)localObject3).t);
          boolean bool20 = a(((ag)localObject2).u, ((ag)localObject3).u);
          boolean bool21 = a(((ag)localObject2).v, ((ag)localObject3).v);
          boolean bool22 = a(((ag)localObject2).w, ((ag)localObject3).w);
          boolean bool23 = a(((ag)localObject2).x, ((ag)localObject3).x);
          boolean bool24 = a(((ag)localObject2).y, ((ag)localObject3).y);
          boolean bool25 = a(((ag)localObject2).z, ((ag)localObject3).z);
          boolean bool26 = a(((ag)localObject2).A, ((ag)localObject3).A);
          boolean bool27 = a(((ag)localObject2).B, ((ag)localObject3).B);
          boolean bool28 = a(((ag)localObject2).P, ((ag)localObject3).P);
          boolean bool29 = a(((ag)localObject2).Q, ((ag)localObject3).Q);
          if ((a(((ag)localObject2).R, ((ag)localObject3).R) | bool1 | false | bool2 | bool3 | bool4 | bool5 | bool6 | bool7 | bool8 | bool9 | bool10 | bool11 | i | bool12 | bool13 | bool14 | bool15 | bool16 | bool17 | bool18 | bool19 | bool20 | bool21 | bool22 | bool23 | bool24 | bool25 | bool26 | bool27 | bool28 | bool29)) {
            localObject1 = localObject2;
          }
        }
      }
    }
    Object localObject2 = new StringBuilder("checUpdateGuid() need: ");
    if (localObject1 != null) {
      bool1 = true;
    } else {
      bool1 = false;
    }
    ((StringBuilder)localObject2).append(bool1);
    if (localObject1 == null) {
      return false;
    }
    new StringBuilder("updateGuid() mGuid: ").append(this.f);
    localObject2 = this.d.d.b();
    new StringBuilder("updateGuid() encodeKey: ").append(localObject2);
    Object localObject4 = new ah();
    ((ah)localObject4).a = localObject1;
    ((ah)localObject4).b = d();
    Object localObject3 = new ai();
    ((ai)localObject3).b = this.d.b.a();
    ((ai)localObject3).a = 2;
    ((ai)localObject3).d = apu.a(((aqe)localObject2).b.getBytes(), (JceStruct)localObject4);
    a(((ah)localObject4).a);
    localObject4 = new ArrayList();
    ((ArrayList)localObject4).add(localObject3);
    localObject3 = new AtomicReference();
    if (this.d.a(false, false, true, (aqe)localObject2, (ArrayList)localObject4, (AtomicReference)localObject3) != 0) {
      return false;
    }
    localObject2 = (ArrayList)((AtomicReference)localObject3).get();
    if (localObject2 == null) {
      return false;
    }
    if (((ArrayList)localObject2).size() <= 0) {
      return false;
    }
    localObject2 = (al)((ArrayList)localObject2).get(0);
    if (localObject2 == null) {
      return false;
    }
    localObject3 = new StringBuilder("updateGuid() rs.seqNo: ");
    ((StringBuilder)localObject3).append(((al)localObject2).b);
    ((StringBuilder)localObject3).append("rs.cmd");
    ((StringBuilder)localObject3).append(((al)localObject2).a);
    ((StringBuilder)localObject3).append(" rs.retCode: ");
    ((StringBuilder)localObject3).append(((al)localObject2).d);
    ((StringBuilder)localObject3).append(" rs.dataRetCode: ");
    ((StringBuilder)localObject3).append(((al)localObject2).e);
    if (1 == ((al)localObject2).d) {
      return false;
    }
    if (((al)localObject2).d != 0) {
      return false;
    }
    new StringBuilder("updateGuid() succed, mGuid: ").append(this.f);
    a(this.f, localObject1);
    return true;
  }
  
  public final String d()
  {
    if (this.f == null) {
      return "";
    }
    return this.f;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.apv
 * JD-Core Version:    0.7.0.1
 */