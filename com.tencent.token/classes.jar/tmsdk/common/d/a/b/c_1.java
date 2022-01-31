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
    new StringBuilder().append("updateGuid() mGuid: ").append(this.f).toString();
    Object localObject1 = this.d.b();
    new StringBuilder().append("updateGuid() encodeKey: ").append(localObject1).toString();
    Object localObject3 = c(parama);
    Object localObject2 = new a.e.c();
    ((a.e.c)localObject2).b = this.d.c().a();
    ((a.e.c)localObject2).a = 2;
    ((a.e.c)localObject2).d = b.a(this.c, ((l)localObject1).b.getBytes(), (JceStruct)localObject3);
    b(((a.e.b)localObject3).a);
    localObject3 = new ArrayList();
    ((ArrayList)localObject3).add(localObject2);
    localObject2 = new AtomicReference();
    int i = this.d.a(false, false, true, (l)localObject1, (ArrayList)localObject3, (AtomicReference)localObject2);
    if (i != 0) {
      new StringBuilder().append("updateGuid() ESharkCode.ERR_NONE != retCode, retCode: ").append(i).toString();
    }
    do
    {
      do
      {
        do
        {
          return false;
          localObject1 = (ArrayList)((AtomicReference)localObject2).get();
        } while ((localObject1 == null) || (((ArrayList)localObject1).size() <= 0));
        localObject1 = (a.e.f)((ArrayList)localObject1).get(0);
      } while (localObject1 == null);
      new StringBuilder().append("updateGuid() rs.seqNo: ").append(((a.e.f)localObject1).b).append("rs.cmd").append(((a.e.f)localObject1).a).append(" rs.retCode: ").append(((a.e.f)localObject1).d).append(" rs.dataRetCode: ").append(((a.e.f)localObject1).e).toString();
    } while ((1 == ((a.e.f)localObject1).d) || (((a.e.f)localObject1).d != 0));
    new StringBuilder().append("updateGuid() succed, mGuid: ").append(this.f).toString();
    a(this.f, parama);
    return true;
  }
  
  private boolean a(String paramString1, String paramString2)
  {
    boolean bool2 = true;
    boolean bool1;
    if (TextUtils.isEmpty(paramString1)) {
      bool1 = false;
    }
    do
    {
      do
      {
        return bool1;
        bool1 = bool2;
      } while (TextUtils.isEmpty(paramString2));
      bool1 = bool2;
    } while (!paramString1.equals(paramString2));
    return false;
  }
  
  private boolean a(boolean paramBoolean1, boolean paramBoolean2)
  {
    return paramBoolean1 != paramBoolean2;
  }
  
  private void b(a parama)
  {
    new StringBuilder().append("printCSRegist()CSRegist.imei: ").append(parama.a).toString();
    new StringBuilder().append("printCSRegist()CSRegist.imsi: ").append(parama.b).toString();
    new StringBuilder().append("printCSRegist()CSRegist.mac: ").append(parama.c).toString();
    new StringBuilder().append("printCSRegist()CSRegist.qq: ").append(parama.d).toString();
    new StringBuilder().append("printCSRegist()CSRegist.phone: ").append(parama.e).toString();
    new StringBuilder().append("printCSRegist()CSRegist.product: ").append(parama.f).toString();
    new StringBuilder().append("printCSRegist()CSRegist.lc: ").append(parama.g).toString();
    new StringBuilder().append("printCSRegist()CSRegist.buildno: ").append(parama.h).toString();
    new StringBuilder().append("printCSRegist()CSRegist.channelid: ").append(parama.i).toString();
    new StringBuilder().append("printCSRegist()CSRegist.platform: ").append(parama.j).toString();
    new StringBuilder().append("printCSRegist()CSRegist.subplatform: ").append(parama.k).toString();
    new StringBuilder().append("printCSRegist()CSRegist.isbuildin: ").append(parama.l).toString();
    new StringBuilder().append("printCSRegist()CSRegist.pkgname: ").append(parama.m).toString();
    new StringBuilder().append("printCSRegist()CSRegist.ua: ").append(parama.n).toString();
    new StringBuilder().append("printCSRegist()CSRegist.sdkver: ").append(parama.o).toString();
    new StringBuilder().append("printCSRegist()CSRegist.androidid: ").append(parama.p).toString();
    new StringBuilder().append("printCSRegist()CSRegist.lang: ").append(parama.q).toString();
    new StringBuilder().append("printCSRegist()CSRegist.simnum: ").append(parama.r).toString();
    new StringBuilder().append("printCSRegist()CSRegist.cpu: ").append(parama.s).toString();
    new StringBuilder().append("printCSRegist()CSRegist.cpufreq: ").append(parama.t).toString();
    new StringBuilder().append("printCSRegist()CSRegist.cpunum: ").append(parama.u).toString();
    new StringBuilder().append("printCSRegist()CSRegist.resolution: ").append(parama.v).toString();
    new StringBuilder().append("printCSRegist()CSRegist.ram: ").append(parama.w).toString();
    new StringBuilder().append("printCSRegist()CSRegist.rom: ").append(parama.x).toString();
    new StringBuilder().append("printCSRegist()CSRegist.sdcard: ").append(parama.y).toString();
    new StringBuilder().append("printCSRegist()CSRegist.build_brand: ").append(parama.z).toString();
    new StringBuilder().append("printCSRegist()CSRegist.build_version_incremental: ").append(parama.A).toString();
    new StringBuilder().append("printCSRegist()CSRegist.build_version_release: ").append(parama.B).toString();
    new StringBuilder().append("printCSRegist()CSRegist.version: ").append(parama.P).toString();
    new StringBuilder().append("printCSRegist()CSRegist.extSdkVer: ").append(parama.Q).toString();
    new StringBuilder().append("printCSRegist()CSRegist.pkgkey: ").append(parama.R).toString();
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
    if (f()) {}
    a locala1;
    a locala2;
    boolean bool1;
    boolean bool2;
    boolean bool3;
    boolean bool4;
    boolean bool5;
    boolean bool6;
    boolean bool7;
    boolean bool8;
    boolean bool9;
    boolean bool10;
    boolean bool11;
    boolean bool12;
    boolean bool13;
    boolean bool14;
    boolean bool15;
    boolean bool16;
    boolean bool17;
    boolean bool18;
    boolean bool19;
    boolean bool20;
    boolean bool21;
    boolean bool22;
    boolean bool23;
    boolean bool24;
    boolean bool25;
    boolean bool26;
    boolean bool27;
    boolean bool28;
    boolean bool29;
    boolean bool30;
    do
    {
      do
      {
        long l;
        do
        {
          return null;
          l = System.currentTimeMillis();
        } while (!tmsdk.common.c.a.e.a(l, this.d.a().j(), 1));
        this.d.a().a(l);
        locala1 = h();
        locala2 = this.d.a().h();
      } while ((locala1 == null) || (locala2 == null));
      b(locala2);
      bool1 = a(locala1.a, locala2.a);
      bool2 = a(locala1.b, locala2.b);
      bool3 = a(locala1.c, locala2.c);
      bool4 = a(locala1.d, locala2.d);
      bool5 = a(locala1.e, locala2.e);
      bool6 = a(locala1.f, locala2.f);
      bool7 = a(locala1.g, locala2.g);
      bool8 = a(locala1.h, locala2.h);
      bool9 = a(locala1.i, locala2.i);
      bool10 = a(locala1.j, locala2.j);
      bool11 = a(locala1.k, locala2.k);
      bool12 = a(locala1.l, locala2.l);
      bool13 = a(locala1.m, locala2.m);
      bool14 = a(locala1.n, locala2.n);
      bool15 = a(locala1.o, locala2.o);
      bool16 = a(locala1.p, locala2.p);
      bool17 = a(locala1.q, locala2.q);
      bool18 = a(locala1.r, locala2.r);
      bool19 = a(locala1.s, locala2.s);
      bool20 = a(locala1.t, locala2.t);
      bool21 = a(locala1.u, locala2.u);
      bool22 = a(locala1.v, locala2.v);
      bool23 = a(locala1.w, locala2.w);
      bool24 = a(locala1.x, locala2.x);
      bool25 = a(locala1.y, locala2.y);
      bool26 = a(locala1.z, locala2.z);
      bool27 = a(locala1.A, locala2.A);
      bool28 = a(locala1.B, locala2.B);
      bool29 = a(locala1.P, locala2.P);
      bool30 = a(locala1.Q, locala2.Q);
    } while (!(a(locala1.R, locala2.R) | false | bool1 | bool2 | bool3 | bool4 | bool5 | bool6 | bool7 | bool8 | bool9 | bool10 | bool11 | bool12 | bool13 | bool14 | bool15 | bool16 | bool17 | bool18 | bool19 | bool20 | bool21 | bool22 | bool23 | bool24 | bool25 | bool26 | bool27 | bool28 | bool29 | bool30));
    return locala1;
  }
  
  private a h()
  {
    a locala = this.d.a().i();
    if (locala == null) {
      throw new RuntimeException("reqRegist is null");
    }
    if (locala.a == null) {
      locala.a = "";
    }
    return locala;
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
      new StringBuilder().append("checkGuid() !need, mGuid: ").append(this.f).toString();
      return this.f;
    }
    Object localObject1 = this.d.b();
    new StringBuilder().append("checkGuid() encodeKey: ").append(localObject1).toString();
    a locala = h();
    Object localObject3 = new a.e.c();
    ((a.e.c)localObject3).b = this.d.c().a();
    ((a.e.c)localObject3).a = 1;
    ((a.e.c)localObject3).d = b.a(this.c, ((l)localObject1).b.getBytes(), locala);
    b(locala);
    Object localObject2 = new ArrayList();
    ((ArrayList)localObject2).add(localObject3);
    localObject3 = new AtomicReference();
    int i = this.d.a(false, true, false, (l)localObject1, (ArrayList)localObject2, (AtomicReference)localObject3);
    if (i != 0)
    {
      new StringBuilder().append("checkGuid() ESharkCode.ERR_NONE != retCode, retCode: ").append(i).toString();
      return null;
    }
    localObject1 = (ArrayList)((AtomicReference)localObject3).get();
    if (localObject1 == null) {
      return null;
    }
    if (((ArrayList)localObject1).size() <= 0) {
      return null;
    }
    localObject2 = (a.e.f)((ArrayList)localObject1).get(0);
    if (localObject2 == null) {
      return null;
    }
    new StringBuilder().append("checkGuid() rs.seqNo: ").append(((a.e.f)localObject2).b).append(" rs.cmd: ").append(((a.e.f)localObject2).a).append(" rs.retCode: ").append(((a.e.f)localObject2).d).append(" rs.dataRetCode: ").append(((a.e.f)localObject2).e).toString();
    if (1 == ((a.e.f)localObject2).d) {
      return null;
    }
    if (((a.e.f)localObject2).e != 0) {
      return null;
    }
    localObject1 = ((a.e.f)localObject2).f;
    if (localObject1 == null) {
      return null;
    }
    new StringBuilder().append("checkGuid() rs.data.length: ").append(((a.e.f)localObject2).f.length).toString();
    localObject2 = new a.e.e();
    try
    {
      localObject1 = b.a(this.c, this.d.b().b.getBytes(), (byte[])localObject1, (JceStruct)localObject2);
      if (localObject1 == null) {
        return null;
      }
    }
    catch (Exception localException)
    {
      return null;
    }
    a(((a.e.e)localObject1).a, localException);
    new StringBuilder().append("checkGuid() ret.guid mGuid: ").append(this.f).toString();
    return this.f;
  }
  
  public boolean d()
  {
    a locala = g();
    StringBuilder localStringBuilder = new StringBuilder().append("checUpdateGuid() need: ");
    if (locala != null) {}
    for (boolean bool = true;; bool = false)
    {
      localStringBuilder.append(bool).toString();
      if (locala != null) {
        break;
      }
      return false;
    }
    bool = a(locala);
    new StringBuilder().append("checUpdateGuid() 检查guid注册信息更新：").append(bool).toString();
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