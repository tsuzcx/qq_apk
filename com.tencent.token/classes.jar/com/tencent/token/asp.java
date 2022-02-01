package com.tencent.token;

import android.content.Context;
import android.text.TextUtils;
import com.qq.taf.jce.JceStruct;
import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicReference;

public final class asp
{
  private final boolean a = false;
  private final String b = "GuidCertifier";
  private Context c;
  private atb d;
  private volatile boolean e = false;
  private volatile String f;
  private volatile long g = 0L;
  
  public asp(Context paramContext, atb paramatb)
  {
    this.c = paramContext;
    this.d = paramatb;
    this.f = this.d.a.e();
    if (TextUtils.isEmpty(this.f))
    {
      this.e = false;
      this.f = this.d.a.f();
      return;
    }
    this.e = true;
  }
  
  private static void a(au paramau)
  {
    new StringBuilder("printCSRegist()CSRegist.imei: ").append(paramau.a);
    new StringBuilder("printCSRegist()CSRegist.imsi: ").append(paramau.b);
    new StringBuilder("printCSRegist()CSRegist.mac: ").append(paramau.c);
    new StringBuilder("printCSRegist()CSRegist.qq: ").append(paramau.d);
    new StringBuilder("printCSRegist()CSRegist.phone: ").append(paramau.e);
    new StringBuilder("printCSRegist()CSRegist.product: ").append(paramau.f);
    new StringBuilder("printCSRegist()CSRegist.lc: ").append(paramau.g);
    new StringBuilder("printCSRegist()CSRegist.buildno: ").append(paramau.h);
    new StringBuilder("printCSRegist()CSRegist.channelid: ").append(paramau.i);
    new StringBuilder("printCSRegist()CSRegist.platform: ").append(paramau.j);
    new StringBuilder("printCSRegist()CSRegist.subplatform: ").append(paramau.k);
    new StringBuilder("printCSRegist()CSRegist.isbuildin: ").append(paramau.l);
    new StringBuilder("printCSRegist()CSRegist.pkgname: ").append(paramau.m);
    new StringBuilder("printCSRegist()CSRegist.ua: ").append(paramau.n);
    new StringBuilder("printCSRegist()CSRegist.sdkver: ").append(paramau.o);
    new StringBuilder("printCSRegist()CSRegist.androidid: ").append(paramau.p);
    new StringBuilder("printCSRegist()CSRegist.lang: ").append(paramau.q);
    new StringBuilder("printCSRegist()CSRegist.simnum: ").append(paramau.r);
    new StringBuilder("printCSRegist()CSRegist.cpu: ").append(paramau.s);
    new StringBuilder("printCSRegist()CSRegist.cpufreq: ").append(paramau.t);
    new StringBuilder("printCSRegist()CSRegist.cpunum: ").append(paramau.u);
    new StringBuilder("printCSRegist()CSRegist.resolution: ").append(paramau.v);
    new StringBuilder("printCSRegist()CSRegist.ram: ").append(paramau.w);
    new StringBuilder("printCSRegist()CSRegist.rom: ").append(paramau.x);
    new StringBuilder("printCSRegist()CSRegist.sdcard: ").append(paramau.y);
    new StringBuilder("printCSRegist()CSRegist.build_brand: ").append(paramau.z);
    new StringBuilder("printCSRegist()CSRegist.build_version_incremental: ").append(paramau.A);
    new StringBuilder("printCSRegist()CSRegist.build_version_release: ").append(paramau.B);
    new StringBuilder("printCSRegist()CSRegist.version: ").append(paramau.P);
    new StringBuilder("printCSRegist()CSRegist.extSdkVer: ").append(paramau.Q);
    new StringBuilder("printCSRegist()CSRegist.pkgkey: ").append(paramau.R);
  }
  
  private void a(String paramString, au paramau)
  {
    if (TextUtils.isEmpty(paramString)) {
      return;
    }
    this.f = paramString;
    this.e = true;
    this.d.a.c(paramString);
    this.d.a.a(paramau);
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
  
  private au e()
  {
    au localau = this.d.a.h();
    if (localau.a == null) {
      localau.a = "";
    }
    return localau;
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
    au localau = e();
    Object localObject3 = new aw();
    ((aw)localObject3).b = this.d.b.a();
    ((aw)localObject3).a = 1;
    ((aw)localObject3).d = aso.a(((asy)localObject1).b.getBytes(), localau);
    a(localau);
    Object localObject2 = new ArrayList();
    ((ArrayList)localObject2).add(localObject3);
    localObject3 = new AtomicReference();
    if (this.d.a(false, true, false, (asy)localObject1, (ArrayList)localObject2, (AtomicReference)localObject3) != 0) {
      return null;
    }
    localObject1 = (ArrayList)((AtomicReference)localObject3).get();
    if (localObject1 == null) {
      return null;
    }
    if (((ArrayList)localObject1).size() <= 0) {
      return null;
    }
    localObject1 = (az)((ArrayList)localObject1).get(0);
    if (localObject1 == null) {
      return null;
    }
    localObject2 = new StringBuilder("checkGuid() rs.seqNo: ");
    ((StringBuilder)localObject2).append(((az)localObject1).b);
    ((StringBuilder)localObject2).append(" rs.cmd: ");
    ((StringBuilder)localObject2).append(((az)localObject1).a);
    ((StringBuilder)localObject2).append(" rs.retCode: ");
    ((StringBuilder)localObject2).append(((az)localObject1).d);
    ((StringBuilder)localObject2).append(" rs.dataRetCode: ");
    ((StringBuilder)localObject2).append(((az)localObject1).e);
    if (1 == ((az)localObject1).d) {
      return null;
    }
    if (((az)localObject1).e != 0) {
      return null;
    }
    localObject2 = ((az)localObject1).f;
    if (localObject2 == null) {
      return null;
    }
    new StringBuilder("checkGuid() rs.data.length: ").append(((az)localObject1).f.length);
    localObject1 = new ay();
    try
    {
      localObject1 = aso.a(this.d.d.b().b.getBytes(), (byte[])localObject2, (JceStruct)localObject1);
      if (localObject1 == null) {
        return null;
      }
      a(((ay)localObject1).a, localau);
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
    if (!arw.a(l, this.g, 720))
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
          a((au)localObject3);
          bool1 = a(((au)localObject2).a, ((au)localObject3).a);
          boolean bool2 = a(((au)localObject2).b, ((au)localObject3).b);
          boolean bool3 = a(((au)localObject2).c, ((au)localObject3).c);
          boolean bool4 = a(((au)localObject2).d, ((au)localObject3).d);
          boolean bool5 = a(((au)localObject2).e, ((au)localObject3).e);
          boolean bool6 = a(((au)localObject2).f, ((au)localObject3).f);
          boolean bool7 = a(((au)localObject2).g, ((au)localObject3).g);
          boolean bool8 = a(((au)localObject2).h, ((au)localObject3).h);
          boolean bool9 = a(((au)localObject2).i, ((au)localObject3).i);
          boolean bool10 = a(((au)localObject2).j, ((au)localObject3).j);
          boolean bool11 = a(((au)localObject2).k, ((au)localObject3).k);
          if (((au)localObject2).l != ((au)localObject3).l) {
            i = 1;
          } else {
            i = 0;
          }
          boolean bool12 = a(((au)localObject2).m, ((au)localObject3).m);
          boolean bool13 = a(((au)localObject2).n, ((au)localObject3).n);
          boolean bool14 = a(((au)localObject2).o, ((au)localObject3).o);
          boolean bool15 = a(((au)localObject2).p, ((au)localObject3).p);
          boolean bool16 = a(((au)localObject2).q, ((au)localObject3).q);
          boolean bool17 = a(((au)localObject2).r, ((au)localObject3).r);
          boolean bool18 = a(((au)localObject2).s, ((au)localObject3).s);
          boolean bool19 = a(((au)localObject2).t, ((au)localObject3).t);
          boolean bool20 = a(((au)localObject2).u, ((au)localObject3).u);
          boolean bool21 = a(((au)localObject2).v, ((au)localObject3).v);
          boolean bool22 = a(((au)localObject2).w, ((au)localObject3).w);
          boolean bool23 = a(((au)localObject2).x, ((au)localObject3).x);
          boolean bool24 = a(((au)localObject2).y, ((au)localObject3).y);
          boolean bool25 = a(((au)localObject2).z, ((au)localObject3).z);
          boolean bool26 = a(((au)localObject2).A, ((au)localObject3).A);
          boolean bool27 = a(((au)localObject2).B, ((au)localObject3).B);
          boolean bool28 = a(((au)localObject2).P, ((au)localObject3).P);
          boolean bool29 = a(((au)localObject2).Q, ((au)localObject3).Q);
          if ((a(((au)localObject2).R, ((au)localObject3).R) | bool1 | false | bool2 | bool3 | bool4 | bool5 | bool6 | bool7 | bool8 | bool9 | bool10 | bool11 | i | bool12 | bool13 | bool14 | bool15 | bool16 | bool17 | bool18 | bool19 | bool20 | bool21 | bool22 | bool23 | bool24 | bool25 | bool26 | bool27 | bool28 | bool29)) {
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
    Object localObject4 = new av();
    ((av)localObject4).a = localObject1;
    ((av)localObject4).b = d();
    Object localObject3 = new aw();
    ((aw)localObject3).b = this.d.b.a();
    ((aw)localObject3).a = 2;
    ((aw)localObject3).d = aso.a(((asy)localObject2).b.getBytes(), (JceStruct)localObject4);
    a(((av)localObject4).a);
    localObject4 = new ArrayList();
    ((ArrayList)localObject4).add(localObject3);
    localObject3 = new AtomicReference();
    if (this.d.a(false, false, true, (asy)localObject2, (ArrayList)localObject4, (AtomicReference)localObject3) != 0) {
      return false;
    }
    localObject2 = (ArrayList)((AtomicReference)localObject3).get();
    if (localObject2 == null) {
      return false;
    }
    if (((ArrayList)localObject2).size() <= 0) {
      return false;
    }
    localObject2 = (az)((ArrayList)localObject2).get(0);
    if (localObject2 == null) {
      return false;
    }
    localObject3 = new StringBuilder("updateGuid() rs.seqNo: ");
    ((StringBuilder)localObject3).append(((az)localObject2).b);
    ((StringBuilder)localObject3).append("rs.cmd");
    ((StringBuilder)localObject3).append(((az)localObject2).a);
    ((StringBuilder)localObject3).append(" rs.retCode: ");
    ((StringBuilder)localObject3).append(((az)localObject2).d);
    ((StringBuilder)localObject3).append(" rs.dataRetCode: ");
    ((StringBuilder)localObject3).append(((az)localObject2).e);
    if (1 == ((az)localObject2).d) {
      return false;
    }
    if (((az)localObject2).d != 0) {
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
 * Qualified Name:     com.tencent.token.asp
 * JD-Core Version:    0.7.0.1
 */