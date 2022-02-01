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
import com.tencent.token.eh;
import com.tencent.token.ei;
import com.tencent.token.ej;
import com.tencent.token.ek;
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
  private static Object B = new Object();
  private static z C = null;
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
  private ei u;
  private eh v = new A(this);
  private eh w = new B(this);
  private tmsdk.common.d.a.c.n x = new tmsdk.common.d.a.c.n(new C(this));
  private Handler y = new D(this, Looper.getMainLooper());
  private J z = null;
  
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
    if (!g)
    {
      if (30000L < this.q) {
        return;
      }
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
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("间隔 : ");
      ((StringBuilder)localObject).append(parame.b);
      ((StringBuilder)localObject).toString();
    }
    if ((parame.c != null) && (parame.c.size() > 0))
    {
      this.m.a();
      localObject = parame.c.iterator();
      while (((Iterator)localObject).hasNext())
      {
        int i1 = ((Integer)((Iterator)localObject).next()).intValue();
        this.m.a(i1);
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("端口 : ");
        localStringBuilder.append(i1);
        localStringBuilder.toString();
      }
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("handleSharkConfPush() interval: ");
      ((StringBuilder)localObject).append(parame.b);
      ((StringBuilder)localObject).append(" ports.size(): ");
      ((StringBuilder)localObject).append(parame.c.size());
      ((StringBuilder)localObject).append(" hash: ");
      ((StringBuilder)localObject).append(parame.a);
      ((StringBuilder)localObject).toString();
    }
    else
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("handleSharkConfPush() interval: ");
      ((StringBuilder)localObject).append(parame.b);
      ((StringBuilder)localObject).append(" hash: ");
      ((StringBuilder)localObject).append(parame.a);
      ((StringBuilder)localObject).toString();
    }
    this.t.a(parame.b);
    this.t.a(parame.c);
    Object localObject = new a.a.b();
    ((a.a.b)localObject).a = parame.a;
    return new Pair(Integer.valueOf(1), localObject);
  }
  
  private WeakReference a(o paramo, int paramInt1, int paramInt2, int paramInt3, int paramInt4, JceStruct paramJceStruct1, JceStruct paramJceStruct2, eh parameh, long paramLong)
  {
    if (tmsdk.common.c.a.f.a())
    {
      parameh.a(0, 0, -7, 0, paramJceStruct2);
      return null;
    }
    if (paramo != null) {
      this.h = paramo;
    }
    if (this.h == null)
    {
      parameh.a(0, 0, -9, 0, paramJceStruct2);
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
    boolean bool;
    if (paramInt1 == 999) {
      bool = true;
    } else {
      bool = false;
    }
    if (parameh != null) {
      a(paramInt2, paramJceStruct1.b, paramJceStruct2, parameh);
    }
    paramo = new ek();
    paramo.a(0);
    paramJceStruct2 = new j(paramJceStruct1, paramInt2, bool, paramo);
    paramJceStruct2.a = paramInt4;
    paramJceStruct2.f = paramLong;
    this.x.a(paramJceStruct2);
    parameh = new StringBuilder();
    parameh.append("ClientSashimi seqNO : ");
    parameh.append(paramJceStruct1.b);
    parameh.toString();
    if (paramLong > 0L)
    {
      paramJceStruct1 = paramJceStruct2.b;
      if ((paramJceStruct1 != null) && (paramJceStruct1 != null))
      {
        paramInt1 = paramJceStruct1.b;
        paramJceStruct1 = new StringBuilder();
        paramJceStruct1.append("对 seqNo : ");
        paramJceStruct1.append(paramInt1);
        paramJceStruct1.append(" 的回包计时");
        paramJceStruct1.toString();
        this.A.sendEmptyMessageDelayed(paramInt1, paramLong);
      }
    }
    this.d.sendEmptyMessage(0);
    return new WeakReference(paramo);
  }
  
  public static z a()
  {
    if (C == null) {
      synchronized (B)
      {
        if (C == null) {
          C = new z();
        }
      }
    }
    return C;
  }
  
  private void a(int paramInt1, int paramInt2, int paramInt3, int paramInt4, byte[] paramArrayOfByte)
  {
    this.A.removeMessages(paramInt3);
    synchronized (this.j)
    {
      Object localObject1 = (a)this.f.get(paramInt3);
      if (localObject1 == null) {
        return;
      }
      this.f.remove(paramInt3);
      if (tmsdk.common.d.a.a.a.filterNetworkCode(paramInt1) == -50000)
      {
        ??? = new StringBuilder();
        ((StringBuilder)???).append("这个超时了 refSeqNo : ");
        ((StringBuilder)???).append(paramInt3);
        ((StringBuilder)???).append(" retCode : ");
        ((StringBuilder)???).append(paramInt1);
        ((StringBuilder)???).toString();
      }
      else
      {
        ??? = new StringBuilder();
        ((StringBuilder)???).append("onRecvCallBack : refSeqNo : ");
        ((StringBuilder)???).append(paramInt3);
        ((StringBuilder)???).append(" retCode : ");
        ((StringBuilder)???).append(paramInt1);
        ((StringBuilder)???).toString();
      }
      paramArrayOfByte = new m(paramInt1, paramInt2, paramInt3, paramInt4, paramArrayOfByte, (a)localObject1);
      paramInt1 = ej.a(((a)localObject1).c);
      if (paramInt1 != 8)
      {
        if (paramInt1 != 16)
        {
          com.tencent.token.f.a().b(new H(this, paramArrayOfByte), "tcp run callback on thread");
          return;
        }
        a(paramArrayOfByte);
        return;
      }
      localObject1 = Message.obtain();
      ((Message)localObject1).obj = paramArrayOfByte;
      ((Message)localObject1).what = 1;
      this.y.sendMessage((Message)localObject1);
      return;
    }
  }
  
  private void a(int paramInt1, int paramInt2, JceStruct arg3, eh parameh)
  {
    parameh = new a(paramInt1, parameh, ???);
    synchronized (this.j)
    {
      this.f.append(paramInt2, parameh);
      return;
    }
  }
  
  private void a(j paramj, int paramInt)
  {
    if (paramj != null)
    {
      if (paramj.b == null) {
        return;
      }
      paramj = paramj.b;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("onFail cmd : ");
      localStringBuilder.append(paramj.a);
      localStringBuilder.toString();
      a(paramInt, 0, paramj.b, paramj.a, null);
      return;
    }
  }
  
  private void a(m paramm)
  {
    if (paramm.f != null)
    {
      if (paramm.f.a == null) {
        return;
      }
      JceStruct localJceStruct = b.a(this.n, null, paramm.e, paramm.f.b);
      if (localJceStruct == null) {
        localJceStruct = paramm.f.b;
      }
      paramm.f.a.a(paramm.c, paramm.d, paramm.a, paramm.b, localJceStruct);
      return;
    }
  }
  
  private void a(n paramn)
  {
    if ((paramn != null) && (paramn.f != null))
    {
      if (paramn.f.a == null) {
        return;
      }
      Object localObject = h.a(paramn.e, paramn.f.b);
      localObject = paramn.f.a.a(paramn.a, paramn.d, (JceStruct)localObject);
      if ((localObject != null) && (((Pair)localObject).first != null) && (((Pair)localObject).second != null))
      {
        a.c.a locala = new a.c.a();
        locala.a = ((Integer)((Pair)localObject).first).intValue();
        locala.b = h.a((JceStruct)((Pair)localObject).second);
        a(this.h, 655, 32, paramn.b, paramn.c, locala, null, null, -1L);
      }
      return;
    }
  }
  
  private void b(int paramInt1, int paramInt2, int paramInt3, int paramInt4, byte[] paramArrayOfByte)
  {
    synchronized (this.i)
    {
      Object localObject2 = (ArrayList)this.e.get(paramInt4);
      if ((localObject2 != null) && (((ArrayList)localObject2).size() > 0))
      {
        localObject2 = (ArrayList)((ArrayList)localObject2).clone();
        ??? = ((List)localObject2).iterator();
        while (((Iterator)???).hasNext())
        {
          Object localObject3 = (i)((Iterator)???).next();
          localObject2 = new n(paramInt3, paramInt4, paramArrayOfByte, paramInt1, paramInt2, (i)localObject3);
          int i1 = ej.a(((i)localObject3).c);
          if (i1 != 8)
          {
            if (i1 != 16) {
              com.tencent.token.f.a().b(new I(this, (n)localObject2), "tcp run push on thread");
            } else {
              a((n)localObject2);
            }
          }
          else
          {
            localObject3 = Message.obtain();
            ((Message)localObject3).obj = localObject2;
            ((Message)localObject3).what = 2;
            this.y.sendMessage((Message)localObject3);
          }
        }
        return;
      }
      return;
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
  
  ei a(int paramInt, ei paramei)
  {
    for (;;)
    {
      int i1;
      Object localObject1;
      synchronized (this.i)
      {
        ArrayList localArrayList = (ArrayList)this.e.get(paramInt);
        Object localObject2 = null;
        if ((localArrayList != null) && (localArrayList.size() != 0))
        {
          i1 = 0;
          if (paramei == null)
          {
            this.e.remove(paramInt);
            paramei = ((i)localArrayList.get(0)).a;
          }
          else
          {
            localObject1 = localObject2;
            if (i1 < localArrayList.size())
            {
              if (((i)localArrayList.get(i1)).a != paramei) {
                break label152;
              }
              localObject1 = ((i)localArrayList.remove(i1)).a;
            }
            if (localArrayList.size() > 0) {
              break label159;
            }
            this.e.remove(paramInt);
            break label159;
          }
          return paramei;
        }
        else
        {
          return null;
        }
      }
      label152:
      i1 += 1;
      continue;
      label159:
      paramei = (ei)localObject1;
    }
  }
  
  WeakReference a(o paramo, int paramInt1, int paramInt2, JceStruct paramJceStruct1, JceStruct paramJceStruct2, eh parameh, long paramLong)
  {
    return a(paramo, paramInt1, paramInt2, 0, 0, paramJceStruct1, paramJceStruct2, parameh, paramLong);
  }
  
  WeakReference a(o paramo, int paramInt, JceStruct paramJceStruct1, JceStruct paramJceStruct2, eh parameh, long paramLong)
  {
    return a(paramo, paramInt, 0, 0, 0, paramJceStruct1, paramJceStruct2, parameh, paramLong);
  }
  
  public void a(int paramInt1, int paramInt2, a.e.f paramf)
  {
    Object localObject = paramf.f;
    paramInt2 = paramf.a;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("onRecv cmdId : ");
    localStringBuilder.append(paramInt2);
    localStringBuilder.append(" seqNo: ");
    localStringBuilder.append(paramf.b);
    localStringBuilder.toString();
    if (paramInt2 == 10655)
    {
      localObject = (a.c.b)b.a(this.n, null, (byte[])localObject, this.o);
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("onRecvPush ECmd.Cmd_SCPush, push.cmd: ");
      localStringBuilder.append(((a.c.b)localObject).a);
      localStringBuilder.toString();
      b(paramf.b, paramInt1, paramf.b, ((a.c.b)localObject).a, ((a.c.b)localObject).b);
      return;
    }
    a(paramf.d, paramf.e, paramf.c, paramInt2, (byte[])localObject);
  }
  
  void a(int paramInt1, int paramInt2, JceStruct paramJceStruct, ei paramei)
  {
    i locali = new i(paramInt1, paramei, paramJceStruct);
    synchronized (this.i)
    {
      paramei = (ArrayList)this.e.get(paramInt2);
      paramJceStruct = paramei;
      if (paramei == null)
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
    Object localObject = this.m;
    if (localObject != null) {
      ((s)localObject).a(paramBoolean);
    }
    this.t = paramd;
    p();
    paramd = this.t;
    if (paramd == null) {
      return;
    }
    long l1 = paramd.l();
    paramd = this.t.m();
    if (l1 > 0L)
    {
      a(l1);
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("初始化心跳包间隔 : ");
      ((StringBuilder)localObject).append(l1);
      ((StringBuilder)localObject).toString();
    }
    if ((paramd != null) && (paramd.size() > 0))
    {
      localObject = this.m;
      if (localObject != null)
      {
        ((s)localObject).a();
        paramd = paramd.iterator();
        while (paramd.hasNext())
        {
          int i1 = ((Integer)paramd.next()).intValue();
          this.m.a(i1);
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append("初始化端口 : ");
          ((StringBuilder)localObject).append(i1);
          ((StringBuilder)localObject).toString();
        }
      }
    }
  }
  
  public void a(boolean paramBoolean)
  {
    s locals = this.m;
    if (locals != null) {
      locals.a(paramBoolean);
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
    J localJ = this.z;
    if (localJ != null) {
      localJ.removeMessages(0);
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