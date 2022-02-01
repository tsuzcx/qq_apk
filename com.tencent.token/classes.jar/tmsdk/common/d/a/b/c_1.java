package tmsdk.common.d.a.b;

import a.e.a;
import android.content.Context;
import android.text.TextUtils;
import com.qq.taf.jce.JceStruct;
import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicReference;

public class c
{
  private final boolean a = false;
  private final String b = "GuidCertifier";
  private Context c;
  private o d;
  private volatile boolean e = false;
  private volatile String f;
  private volatile long g = 0L;
  
  public c(Context paramContext, o paramo)
  {
    this.c = paramContext;
    this.d = paramo;
    b();
  }
  
  private void a(String paramString, a parama)
  {
    if (TextUtils.isEmpty(paramString)) {
      return;
    }
    this.f = paramString;
    this.e = true;
    this.d.a().c(paramString);
    this.d.a().d(paramString);
    this.d.a().a(parama);
  }
  
  private boolean a(int paramInt1, int paramInt2)
  {
    return paramInt1 != paramInt2;
  }
  
  private boolean a(long paramLong1, long paramLong2)
  {
    return paramLong1 != paramLong2;
  }
  
  private boolean a(a parama)
  {
    Object localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append("updateGuid() mGuid: ");
    ((StringBuilder)localObject1).append(this.f);
    ((StringBuilder)localObject1).toString();
    localObject1 = this.d.b();
    Object localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append("updateGuid() encodeKey: ");
    ((StringBuilder)localObject2).append(localObject1);
    ((StringBuilder)localObject2).toString();
    Object localObject3 = c(parama);
    localObject2 = new a.e.c();
    ((a.e.c)localObject2).b = this.d.c().a();
    ((a.e.c)localObject2).a = 2;
    ((a.e.c)localObject2).d = b.a(this.c, ((l)localObject1).b.getBytes(), (JceStruct)localObject3);
    b(((a.e.b)localObject3).a);
    localObject3 = new ArrayList();
    ((ArrayList)localObject3).add(localObject2);
    localObject2 = new AtomicReference();
    int i = this.d.a(false, false, true, (l)localObject1, (ArrayList)localObject3, (AtomicReference)localObject2);
    if (i != 0)
    {
      parama = new StringBuilder();
      parama.append("updateGuid() ESharkCode.ERR_NONE != retCode, retCode: ");
      parama.append(i);
      parama.toString();
      return false;
    }
    localObject1 = (ArrayList)((AtomicReference)localObject2).get();
    if (localObject1 == null) {
      return false;
    }
    if (((ArrayList)localObject1).size() <= 0) {
      return false;
    }
    localObject1 = (a.e.f)((ArrayList)localObject1).get(0);
    if (localObject1 == null) {
      return false;
    }
    localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append("updateGuid() rs.seqNo: ");
    ((StringBuilder)localObject2).append(((a.e.f)localObject1).b);
    ((StringBuilder)localObject2).append("rs.cmd");
    ((StringBuilder)localObject2).append(((a.e.f)localObject1).a);
    ((StringBuilder)localObject2).append(" rs.retCode: ");
    ((StringBuilder)localObject2).append(((a.e.f)localObject1).d);
    ((StringBuilder)localObject2).append(" rs.dataRetCode: ");
    ((StringBuilder)localObject2).append(((a.e.f)localObject1).e);
    ((StringBuilder)localObject2).toString();
    if (1 == ((a.e.f)localObject1).d) {
      return false;
    }
    if (((a.e.f)localObject1).d != 0) {
      return false;
    }
    localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append("updateGuid() succed, mGuid: ");
    ((StringBuilder)localObject1).append(this.f);
    ((StringBuilder)localObject1).toString();
    a(this.f, parama);
    return true;
  }
  
  private boolean a(String paramString1, String paramString2)
  {
    if (TextUtils.isEmpty(paramString1)) {
      return false;
    }
    if (TextUtils.isEmpty(paramString2)) {
      return true;
    }
    return paramString1.equals(paramString2) ^ true;
  }
  
  private boolean a(boolean paramBoolean1, boolean paramBoolean2)
  {
    return paramBoolean1 != paramBoolean2;
  }
  
  private void b(a parama)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("printCSRegist()CSRegist.imei: ");
    localStringBuilder.append(parama.a);
    localStringBuilder.toString();
    localStringBuilder = new StringBuilder();
    localStringBuilder.append("printCSRegist()CSRegist.imsi: ");
    localStringBuilder.append(parama.b);
    localStringBuilder.toString();
    localStringBuilder = new StringBuilder();
    localStringBuilder.append("printCSRegist()CSRegist.mac: ");
    localStringBuilder.append(parama.c);
    localStringBuilder.toString();
    localStringBuilder = new StringBuilder();
    localStringBuilder.append("printCSRegist()CSRegist.qq: ");
    localStringBuilder.append(parama.d);
    localStringBuilder.toString();
    localStringBuilder = new StringBuilder();
    localStringBuilder.append("printCSRegist()CSRegist.phone: ");
    localStringBuilder.append(parama.e);
    localStringBuilder.toString();
    localStringBuilder = new StringBuilder();
    localStringBuilder.append("printCSRegist()CSRegist.product: ");
    localStringBuilder.append(parama.f);
    localStringBuilder.toString();
    localStringBuilder = new StringBuilder();
    localStringBuilder.append("printCSRegist()CSRegist.lc: ");
    localStringBuilder.append(parama.g);
    localStringBuilder.toString();
    localStringBuilder = new StringBuilder();
    localStringBuilder.append("printCSRegist()CSRegist.buildno: ");
    localStringBuilder.append(parama.h);
    localStringBuilder.toString();
    localStringBuilder = new StringBuilder();
    localStringBuilder.append("printCSRegist()CSRegist.channelid: ");
    localStringBuilder.append(parama.i);
    localStringBuilder.toString();
    localStringBuilder = new StringBuilder();
    localStringBuilder.append("printCSRegist()CSRegist.platform: ");
    localStringBuilder.append(parama.j);
    localStringBuilder.toString();
    localStringBuilder = new StringBuilder();
    localStringBuilder.append("printCSRegist()CSRegist.subplatform: ");
    localStringBuilder.append(parama.k);
    localStringBuilder.toString();
    localStringBuilder = new StringBuilder();
    localStringBuilder.append("printCSRegist()CSRegist.isbuildin: ");
    localStringBuilder.append(parama.l);
    localStringBuilder.toString();
    localStringBuilder = new StringBuilder();
    localStringBuilder.append("printCSRegist()CSRegist.pkgname: ");
    localStringBuilder.append(parama.m);
    localStringBuilder.toString();
    localStringBuilder = new StringBuilder();
    localStringBuilder.append("printCSRegist()CSRegist.ua: ");
    localStringBuilder.append(parama.n);
    localStringBuilder.toString();
    localStringBuilder = new StringBuilder();
    localStringBuilder.append("printCSRegist()CSRegist.sdkver: ");
    localStringBuilder.append(parama.o);
    localStringBuilder.toString();
    localStringBuilder = new StringBuilder();
    localStringBuilder.append("printCSRegist()CSRegist.androidid: ");
    localStringBuilder.append(parama.p);
    localStringBuilder.toString();
    localStringBuilder = new StringBuilder();
    localStringBuilder.append("printCSRegist()CSRegist.lang: ");
    localStringBuilder.append(parama.q);
    localStringBuilder.toString();
    localStringBuilder = new StringBuilder();
    localStringBuilder.append("printCSRegist()CSRegist.simnum: ");
    localStringBuilder.append(parama.r);
    localStringBuilder.toString();
    localStringBuilder = new StringBuilder();
    localStringBuilder.append("printCSRegist()CSRegist.cpu: ");
    localStringBuilder.append(parama.s);
    localStringBuilder.toString();
    localStringBuilder = new StringBuilder();
    localStringBuilder.append("printCSRegist()CSRegist.cpufreq: ");
    localStringBuilder.append(parama.t);
    localStringBuilder.toString();
    localStringBuilder = new StringBuilder();
    localStringBuilder.append("printCSRegist()CSRegist.cpunum: ");
    localStringBuilder.append(parama.u);
    localStringBuilder.toString();
    localStringBuilder = new StringBuilder();
    localStringBuilder.append("printCSRegist()CSRegist.resolution: ");
    localStringBuilder.append(parama.v);
    localStringBuilder.toString();
    localStringBuilder = new StringBuilder();
    localStringBuilder.append("printCSRegist()CSRegist.ram: ");
    localStringBuilder.append(parama.w);
    localStringBuilder.toString();
    localStringBuilder = new StringBuilder();
    localStringBuilder.append("printCSRegist()CSRegist.rom: ");
    localStringBuilder.append(parama.x);
    localStringBuilder.toString();
    localStringBuilder = new StringBuilder();
    localStringBuilder.append("printCSRegist()CSRegist.sdcard: ");
    localStringBuilder.append(parama.y);
    localStringBuilder.toString();
    localStringBuilder = new StringBuilder();
    localStringBuilder.append("printCSRegist()CSRegist.build_brand: ");
    localStringBuilder.append(parama.z);
    localStringBuilder.toString();
    localStringBuilder = new StringBuilder();
    localStringBuilder.append("printCSRegist()CSRegist.build_version_incremental: ");
    localStringBuilder.append(parama.A);
    localStringBuilder.toString();
    localStringBuilder = new StringBuilder();
    localStringBuilder.append("printCSRegist()CSRegist.build_version_release: ");
    localStringBuilder.append(parama.B);
    localStringBuilder.toString();
    localStringBuilder = new StringBuilder();
    localStringBuilder.append("printCSRegist()CSRegist.version: ");
    localStringBuilder.append(parama.P);
    localStringBuilder.toString();
    localStringBuilder = new StringBuilder();
    localStringBuilder.append("printCSRegist()CSRegist.extSdkVer: ");
    localStringBuilder.append(parama.Q);
    localStringBuilder.toString();
    localStringBuilder = new StringBuilder();
    localStringBuilder.append("printCSRegist()CSRegist.pkgkey: ");
    localStringBuilder.append(parama.R);
    localStringBuilder.toString();
  }
  
  private a.e.b c(a parama)
  {
    a.e.b localb = new a.e.b();
    localb.a = parama;
    localb.b = e();
    return localb;
  }
  
  private boolean f()
  {
    long l = System.currentTimeMillis();
    if (!tmsdk.common.c.a.e.b(l, this.g, 720)) {
      return false;
    }
    this.g = l;
    return true;
  }
  
  private a g()
  {
    if (f()) {
      return null;
    }
    long l = System.currentTimeMillis();
    if (!tmsdk.common.c.a.e.a(l, this.d.a().j(), 1)) {
      return null;
    }
    this.d.a().a(l);
    a locala1 = h();
    a locala2 = this.d.a().h();
    if (locala1 != null)
    {
      if (locala2 == null) {
        return null;
      }
      b(locala2);
      boolean bool1 = a(locala1.a, locala2.a);
      boolean bool2 = a(locala1.b, locala2.b);
      boolean bool3 = a(locala1.c, locala2.c);
      boolean bool4 = a(locala1.d, locala2.d);
      boolean bool5 = a(locala1.e, locala2.e);
      boolean bool6 = a(locala1.f, locala2.f);
      boolean bool7 = a(locala1.g, locala2.g);
      boolean bool8 = a(locala1.h, locala2.h);
      boolean bool9 = a(locala1.i, locala2.i);
      boolean bool10 = a(locala1.j, locala2.j);
      boolean bool11 = a(locala1.k, locala2.k);
      boolean bool12 = a(locala1.l, locala2.l);
      boolean bool13 = a(locala1.m, locala2.m);
      boolean bool14 = a(locala1.n, locala2.n);
      boolean bool15 = a(locala1.o, locala2.o);
      boolean bool16 = a(locala1.p, locala2.p);
      boolean bool17 = a(locala1.q, locala2.q);
      boolean bool18 = a(locala1.r, locala2.r);
      boolean bool19 = a(locala1.s, locala2.s);
      boolean bool20 = a(locala1.t, locala2.t);
      boolean bool21 = a(locala1.u, locala2.u);
      boolean bool22 = a(locala1.v, locala2.v);
      boolean bool23 = a(locala1.w, locala2.w);
      boolean bool24 = a(locala1.x, locala2.x);
      boolean bool25 = a(locala1.y, locala2.y);
      boolean bool26 = a(locala1.z, locala2.z);
      boolean bool27 = a(locala1.A, locala2.A);
      boolean bool28 = a(locala1.B, locala2.B);
      boolean bool29 = a(locala1.P, locala2.P);
      boolean bool30 = a(locala1.Q, locala2.Q);
      if (!(a(locala1.R, locala2.R) | bool1 | false | bool2 | bool3 | bool4 | bool5 | bool6 | bool7 | bool8 | bool9 | bool10 | bool11 | bool12 | bool13 | bool14 | bool15 | bool16 | bool17 | bool18 | bool19 | bool20 | bool21 | bool22 | bool23 | bool24 | bool25 | bool26 | bool27 | bool28 | bool29 | bool30)) {
        return null;
      }
      return locala1;
    }
    return null;
  }
  
  private a h()
  {
    a locala = this.d.a().i();
    if (locala != null)
    {
      if (locala.a == null) {
        locala.a = "";
      }
      return locala;
    }
    throw new RuntimeException("reqRegist is null");
  }
  
  public boolean a()
  {
    return (TextUtils.isEmpty(e())) || (!this.e);
  }
  
  public void b()
  {
    this.f = this.d.a().f();
    if (TextUtils.isEmpty(this.f))
    {
      this.e = false;
      this.f = this.d.a().g();
      return;
    }
    this.e = true;
  }
  
  public String c()
  {
    if (!a())
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("checkGuid() !need, mGuid: ");
      ((StringBuilder)localObject1).append(this.f);
      ((StringBuilder)localObject1).toString();
      return this.f;
    }
    Object localObject2 = this.d.b();
    Object localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append("checkGuid() encodeKey: ");
    ((StringBuilder)localObject1).append(localObject2);
    ((StringBuilder)localObject1).toString();
    localObject1 = h();
    Object localObject4 = new a.e.c();
    ((a.e.c)localObject4).b = this.d.c().a();
    ((a.e.c)localObject4).a = 1;
    ((a.e.c)localObject4).d = b.a(this.c, ((l)localObject2).b.getBytes(), (JceStruct)localObject1);
    b((a)localObject1);
    Object localObject3 = new ArrayList();
    ((ArrayList)localObject3).add(localObject4);
    localObject4 = new AtomicReference();
    int i = this.d.a(false, true, false, (l)localObject2, (ArrayList)localObject3, (AtomicReference)localObject4);
    if (i != 0)
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("checkGuid() ESharkCode.ERR_NONE != retCode, retCode: ");
      ((StringBuilder)localObject1).append(i);
      ((StringBuilder)localObject1).toString();
      return null;
    }
    localObject2 = (ArrayList)((AtomicReference)localObject4).get();
    if (localObject2 == null) {
      return null;
    }
    if (((ArrayList)localObject2).size() <= 0) {
      return null;
    }
    localObject2 = (a.e.f)((ArrayList)localObject2).get(0);
    if (localObject2 == null) {
      return null;
    }
    localObject3 = new StringBuilder();
    ((StringBuilder)localObject3).append("checkGuid() rs.seqNo: ");
    ((StringBuilder)localObject3).append(((a.e.f)localObject2).b);
    ((StringBuilder)localObject3).append(" rs.cmd: ");
    ((StringBuilder)localObject3).append(((a.e.f)localObject2).a);
    ((StringBuilder)localObject3).append(" rs.retCode: ");
    ((StringBuilder)localObject3).append(((a.e.f)localObject2).d);
    ((StringBuilder)localObject3).append(" rs.dataRetCode: ");
    ((StringBuilder)localObject3).append(((a.e.f)localObject2).e);
    ((StringBuilder)localObject3).toString();
    if (1 == ((a.e.f)localObject2).d) {
      return null;
    }
    if (((a.e.f)localObject2).e != 0) {
      return null;
    }
    localObject3 = ((a.e.f)localObject2).f;
    if (localObject3 == null) {
      return null;
    }
    localObject4 = new StringBuilder();
    ((StringBuilder)localObject4).append("checkGuid() rs.data.length: ");
    ((StringBuilder)localObject4).append(((a.e.f)localObject2).f.length);
    ((StringBuilder)localObject4).toString();
    localObject2 = new a.e.e();
    try
    {
      localObject2 = b.a(this.c, this.d.b().b.getBytes(), (byte[])localObject3, (JceStruct)localObject2);
      if (localObject2 == null) {
        return null;
      }
      a(((a.e.e)localObject2).a, (a)localObject1);
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("checkGuid() ret.guid mGuid: ");
      ((StringBuilder)localObject1).append(this.f);
      ((StringBuilder)localObject1).toString();
      return this.f;
    }
    catch (Exception localException) {}
    return null;
  }
  
  public boolean d()
  {
    Object localObject = g();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("checUpdateGuid() need: ");
    if (localObject != null) {
      bool = true;
    } else {
      bool = false;
    }
    localStringBuilder.append(bool);
    localStringBuilder.toString();
    if (localObject == null) {
      return false;
    }
    boolean bool = a((a)localObject);
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append("checUpdateGuid() 检查guid注册信息更新：");
    ((StringBuilder)localObject).append(bool);
    ((StringBuilder)localObject).toString();
    return bool;
  }
  
  public String e()
  {
    if (this.f == null) {
      return "";
    }
    return this.f;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     tmsdk.common.d.a.b.c
 * JD-Core Version:    0.7.0.1
 */