package tmsdk.common.d.a.b;

import a.a.e;
import a.e.c;
import android.content.Context;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import android.util.Pair;
import android.util.SparseArray;
import com.qq.taf.jce.JceStruct;
import com.tencent.token.ef;
import com.tencent.token.eg;
import com.tencent.token.eh;
import com.tencent.token.ei;
import com.tencent.token.g;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import tmsdk.common.d.a.c.s;
import tmsdk.common.d.a.c.t;

public class z
  extends t
  implements tmsdk.common.d.a.c.d, tmsdk.common.d.a.c.m
{
  private static Object B;
  private static z C;
  private Handler A = null;
  g a = null;
  boolean b = false;
  HandlerThread c = null;
  Handler d = null;
  SparseArray e = new SparseArray();
  SparseArray f = new SparseArray();
  private Object i = new Object();
  private Object j = new Object();
  private tmsdk.common.d.a.c.j k = tmsdk.common.d.a.c.j.a();
  private AtomicInteger l = new AtomicInteger(0);
  private s m = null;
  private Context n = null;
  private a.c.b o = new a.c.b();
  private final long p = -1L;
  private long q = 180000L;
  private int r = 0;
  private AtomicInteger s = new AtomicInteger(0);
  private d t;
  private eg u;
  private ef v = new A(this);
  private ef w = new B(this);
  private tmsdk.common.d.a.c.n x = new tmsdk.common.d.a.c.n(new C(this));
  private Handler y = new D(this, Looper.getMainLooper());
  private J z = null;
  
  static
  {
    if (!z.class.desiredAssertionStatus()) {}
    for (boolean bool = true;; bool = false)
    {
      g = bool;
      B = new Object();
      C = null;
      return;
    }
  }
  
  private z()
  {
    this.m.a(this);
    this.m.a(this.q);
    this.z = new J(this, this.n);
    this.k.a(this);
    int i2 = (int)System.currentTimeMillis();
    int i1 = i2;
    if (i2 < 0) {
      i1 = -i2;
    }
    this.s.set(i1 / 100);
    this.A = new F(this, this.n.getMainLooper());
    if ((!g) && (30000L >= this.q)) {
      throw new AssertionError();
    }
  }
  
  private a.e.d a(c paramc)
  {
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(paramc);
    return this.h.a(localArrayList);
  }
  
  private Pair a(e parame)
  {
    if (this.t == null) {
      return null;
    }
    if (parame.b > 0)
    {
      a(parame.b);
      new StringBuilder().append("间隔 : ").append(parame.b).toString();
    }
    Object localObject;
    if ((parame.c != null) && (parame.c.size() > 0))
    {
      this.m.a();
      localObject = parame.c.iterator();
      while (((Iterator)localObject).hasNext())
      {
        int i1 = ((Integer)((Iterator)localObject).next()).intValue();
        this.m.a(i1);
        new StringBuilder().append("端口 : ").append(i1).toString();
      }
      new StringBuilder().append("handleSharkConfPush() interval: ").append(parame.b).append(" ports.size(): ").append(parame.c.size()).append(" hash: ").append(parame.a).toString();
    }
    for (;;)
    {
      this.t.a(parame.b);
      this.t.a(parame.c);
      localObject = new a.a.b();
      ((a.a.b)localObject).a = parame.a;
      return new Pair(Integer.valueOf(1), localObject);
      new StringBuilder().append("handleSharkConfPush() interval: ").append(parame.b).append(" hash: ").append(parame.a).toString();
    }
  }
  
  private WeakReference a(o paramo, int paramInt1, int paramInt2, int paramInt3, int paramInt4, JceStruct paramJceStruct1, JceStruct paramJceStruct2, ef paramef, long paramLong)
  {
    if (tmsdk.common.c.a.f.a())
    {
      paramef.a(0, 0, -7, 0, paramJceStruct2);
      return null;
    }
    if (paramo != null) {
      this.h = paramo;
    }
    if (this.h == null)
    {
      paramef.a(0, 0, -9, 0, paramJceStruct2);
      return null;
    }
    if (!q()) {
      r();
    }
    byte[] arrayOfByte = b.a(this.n, null, paramJceStruct1);
    paramJceStruct1 = new c();
    paramJceStruct1.a = paramInt1;
    paramJceStruct1.b = paramo.c().a();
    paramJceStruct1.c = paramInt3;
    paramJceStruct1.d = arrayOfByte;
    boolean bool = false;
    if (paramInt1 == 999) {
      bool = true;
    }
    if (paramef != null) {
      a(paramInt2, paramJceStruct1.b, paramJceStruct2, paramef);
    }
    paramo = new ei();
    paramo.a(0);
    paramJceStruct2 = new j(paramJceStruct1, paramInt2, bool, paramo);
    paramJceStruct2.a = paramInt4;
    paramJceStruct2.f = paramLong;
    this.x.a(paramJceStruct2);
    new StringBuilder().append("ClientSashimi seqNO : ").append(paramJceStruct1.b).toString();
    if (paramLong > 0L)
    {
      paramJceStruct1 = paramJceStruct2.b;
      if ((paramJceStruct1 != null) && (paramJceStruct1 != null))
      {
        paramInt1 = paramJceStruct1.b;
        new StringBuilder().append("对 seqNo : ").append(paramInt1).append(" 的回包计时").toString();
        this.A.sendEmptyMessageDelayed(paramInt1, paramLong);
      }
    }
    this.d.sendEmptyMessage(0);
    return new WeakReference(paramo);
  }
  
  public static z a()
  {
    if (C == null) {}
    synchronized (B)
    {
      if (C == null) {
        C = new z();
      }
      return C;
    }
  }
  
  private void a(int paramInt1, int paramInt2, int paramInt3, int paramInt4, byte[] paramArrayOfByte)
  {
    this.A.removeMessages(paramInt3);
    for (;;)
    {
      synchronized (this.j)
      {
        a locala = (a)this.f.get(paramInt3);
        if (locala == null) {
          return;
        }
        this.f.remove(paramInt3);
        if (tmsdk.common.d.a.a.a.filterNetworkCode(paramInt1) == -50000)
        {
          new StringBuilder().append("这个超时了 refSeqNo : ").append(paramInt3).append(" retCode : ").append(paramInt1).toString();
          paramArrayOfByte = new m(paramInt1, paramInt2, paramInt3, paramInt4, paramArrayOfByte, locala);
          switch (eh.a(locala.c))
          {
          default: 
            com.tencent.token.f.a().b(new H(this, paramArrayOfByte), "tcp run callback on thread");
            return;
          }
        }
      }
      new StringBuilder().append("onRecvCallBack : refSeqNo : ").append(paramInt3).append(" retCode : ").append(paramInt1).toString();
    }
    ??? = Message.obtain();
    ((Message)???).obj = paramArrayOfByte;
    ((Message)???).what = 1;
    this.y.sendMessage((Message)???);
    return;
    a(paramArrayOfByte);
  }
  
  private void a(int paramInt1, int paramInt2, JceStruct arg3, ef paramef)
  {
    paramef = new a(paramInt1, paramef, ???);
    synchronized (this.j)
    {
      this.f.append(paramInt2, paramef);
      return;
    }
  }
  
  private void a(j paramj, int paramInt)
  {
    if ((paramj == null) || (paramj.b == null)) {
      return;
    }
    paramj = paramj.b;
    new StringBuilder().append("onFail cmd : ").append(paramj.a).toString();
    a(paramInt, 0, paramj.b, paramj.a, null);
  }
  
  private void a(m paramm)
  {
    if ((paramm.f == null) || (paramm.f.a == null)) {
      return;
    }
    JceStruct localJceStruct2 = b.a(this.n, null, paramm.e, paramm.f.b);
    JceStruct localJceStruct1 = localJceStruct2;
    if (localJceStruct2 == null) {
      localJceStruct1 = paramm.f.b;
    }
    paramm.f.a.a(paramm.c, paramm.d, paramm.a, paramm.b, localJceStruct1);
  }
  
  private void a(n paramn)
  {
    if ((paramn == null) || (paramn.f == null) || (paramn.f.a == null)) {}
    Object localObject;
    do
    {
      return;
      localObject = h.a(paramn.e, paramn.f.b);
      localObject = paramn.f.a.a(paramn.a, paramn.d, (JceStruct)localObject);
    } while ((localObject == null) || (((Pair)localObject).first == null) || (((Pair)localObject).second == null));
    a.c.a locala = new a.c.a();
    locala.a = ((Integer)((Pair)localObject).first).intValue();
    locala.b = h.a((JceStruct)((Pair)localObject).second);
    a(this.h, 655, 32, paramn.b, paramn.c, locala, null, null, -1L);
  }
  
  private void b(int paramInt1, int paramInt2, int paramInt3, int paramInt4, byte[] paramArrayOfByte)
  {
    for (;;)
    {
      Object localObject2;
      synchronized (this.i)
      {
        localObject2 = (ArrayList)this.e.get(paramInt4);
        if ((localObject2 == null) || (((ArrayList)localObject2).size() <= 0)) {
          return;
        }
        localObject2 = (ArrayList)((ArrayList)localObject2).clone();
        ??? = ((List)localObject2).iterator();
        if (!((Iterator)???).hasNext()) {
          break;
        }
        localObject3 = (i)((Iterator)???).next();
        localObject2 = new n(paramInt3, paramInt4, paramArrayOfByte, paramInt1, paramInt2, (i)localObject3);
        switch (eh.a(((i)localObject3).c))
        {
        default: 
          com.tencent.token.f.a().b(new I(this, (n)localObject2), "tcp run push on thread");
        }
      }
      Object localObject3 = Message.obtain();
      ((Message)localObject3).obj = localObject2;
      ((Message)localObject3).what = 2;
      this.y.sendMessage((Message)localObject3);
      continue;
      a((n)localObject2);
    }
  }
  
  private void b(boolean paramBoolean)
  {
    try
    {
      this.b = paramBoolean;
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  private void p()
  {
    this.u = new E(this);
    a(0, 10001, new e(), this.u);
  }
  
  private boolean q()
  {
    return this.b;
  }
  
  private void r()
  {
    if (q()) {
      return;
    }
    b(true);
    this.c = new HandlerThread("sendHandlerThread");
    this.c.start();
    this.d = new G(this, this.c.getLooper());
  }
  
  private void s()
  {
    if (!q()) {
      return;
    }
    b(false);
    this.c.quit();
    this.c = null;
    this.d = null;
  }
  
  eg a(int paramInt, eg parameg)
  {
    ArrayList localArrayList;
    synchronized (this.i)
    {
      localArrayList = (ArrayList)this.e.get(paramInt);
      if ((localArrayList == null) || (localArrayList.size() == 0)) {
        return null;
      }
      if (parameg == null)
      {
        this.e.remove(paramInt);
        parameg = ((i)localArrayList.get(0)).a;
        return parameg;
      }
    }
    int i1 = 0;
    label78:
    if (i1 < localArrayList.size()) {
      if (((i)localArrayList.get(i1)).a != parameg) {}
    }
    for (parameg = ((i)localArrayList.remove(i1)).a;; parameg = null)
    {
      if (localArrayList.size() <= 0) {
        this.e.remove(paramInt);
      }
      break;
      i1 += 1;
      break label78;
    }
  }
  
  WeakReference a(o paramo, int paramInt1, int paramInt2, JceStruct paramJceStruct1, JceStruct paramJceStruct2, ef paramef, long paramLong)
  {
    return a(paramo, paramInt1, paramInt2, 0, 0, paramJceStruct1, paramJceStruct2, paramef, paramLong);
  }
  
  WeakReference a(o paramo, int paramInt, JceStruct paramJceStruct1, JceStruct paramJceStruct2, ef paramef, long paramLong)
  {
    return a(paramo, paramInt, 0, 0, 0, paramJceStruct1, paramJceStruct2, paramef, paramLong);
  }
  
  public void a(int paramInt1, int paramInt2, a.e.f paramf)
  {
    Object localObject = paramf.f;
    paramInt2 = paramf.a;
    new StringBuilder().append("onRecv cmdId : ").append(paramInt2).append(" seqNo: ").append(paramf.b).toString();
    if (paramInt2 == 10655)
    {
      localObject = (a.c.b)b.a(this.n, null, (byte[])localObject, this.o);
      new StringBuilder().append("onRecvPush ECmd.Cmd_SCPush, push.cmd: ").append(((a.c.b)localObject).a).toString();
      b(paramf.b, paramInt1, paramf.b, ((a.c.b)localObject).a, ((a.c.b)localObject).b);
      return;
    }
    a(paramf.d, paramf.e, paramf.c, paramInt2, (byte[])localObject);
  }
  
  void a(int paramInt1, int paramInt2, JceStruct paramJceStruct, eg parameg)
  {
    i locali = new i(paramInt1, parameg, paramJceStruct);
    synchronized (this.i)
    {
      parameg = (ArrayList)this.e.get(paramInt2);
      paramJceStruct = parameg;
      if (parameg == null)
      {
        paramJceStruct = new ArrayList();
        this.e.append(paramInt2, paramJceStruct);
      }
      paramJceStruct.add(locali);
      return;
    }
  }
  
  void a(long paramLong)
  {
    this.m.a(paramLong);
  }
  
  public void a(d paramd, boolean paramBoolean)
  {
    if (this.m != null) {
      this.m.a(paramBoolean);
    }
    this.t = paramd;
    p();
    if (this.t == null) {}
    for (;;)
    {
      return;
      long l1 = this.t.l();
      paramd = this.t.m();
      if (l1 > 0L)
      {
        a(l1);
        new StringBuilder().append("初始化心跳包间隔 : ").append(l1).toString();
      }
      if ((paramd != null) && (paramd.size() > 0) && (this.m != null))
      {
        this.m.a();
        paramd = paramd.iterator();
        while (paramd.hasNext())
        {
          int i1 = ((Integer)paramd.next()).intValue();
          this.m.a(i1);
          new StringBuilder().append("初始化端口 : ").append(i1).toString();
        }
      }
    }
  }
  
  public void a(boolean paramBoolean)
  {
    if (this.m != null) {
      this.m.a(paramBoolean);
    }
  }
  
  public void b()
  {
    try
    {
      this.m.a(false, this);
      this.m.a(true, this);
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  void c()
  {
    try
    {
      this.m.a(false, this);
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  void d()
  {
    this.l.incrementAndGet();
  }
  
  void e()
  {
    if (this.l.decrementAndGet() <= 0)
    {
      this.l.set(0);
      f();
    }
  }
  
  void f()
  {
    h();
    this.k.b(this.n);
    c();
    s();
    this.x.b();
    this.m.b();
    this.l.set(0);
  }
  
  boolean g()
  {
    if (this.l.get() <= 0) {
      return false;
    }
    h();
    if (!this.m.d())
    {
      this.z.sendEmptyMessageDelayed(0, 10000L);
      return false;
    }
    a(this.h, 998, null, null, this.w, 10000L);
    return true;
  }
  
  void h()
  {
    if (this.z != null) {
      this.z.removeMessages(0);
    }
  }
  
  void i()
  {
    a(this.h, 999, null, null, this.v, 30000L);
  }
  
  public void j()
  {
    i();
  }
  
  void k()
  {
    this.r = 0;
  }
  
  int l()
  {
    int i1 = this.r + 1;
    this.r = i1;
    return i1;
  }
  
  int m()
  {
    return 20;
  }
  
  void n()
  {
    this.r = 0;
  }
  
  public void o()
  {
    g();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     tmsdk.common.d.a.b.z
 * JD-Core Version:    0.7.0.1
 */