package com.tencent.token;

import android.content.Context;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import android.util.Pair;
import android.util.SparseArray;
import com.qq.taf.jce.JceStruct;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import tmsdk.common.d.a.c.j;

public class aso
  extends atf
  implements ass, asy
{
  private static Object B = new Object();
  private static aso C = null;
  private Handler A = null;
  AtomicInteger a = new AtomicInteger(0);
  public ate b = null;
  int c = 0;
  ki d = null;
  boolean e = false;
  HandlerThread f = null;
  Handler g = null;
  SparseArray h = new SparseArray();
  SparseArray i = new SparseArray();
  private Object l = new Object();
  private Object m = new Object();
  private j n = j.a();
  private Context o = null;
  private ad p = new ad();
  private final long q = -1L;
  private long r = 180000L;
  private AtomicInteger s = new AtomicInteger(0);
  private ars t;
  private aij u;
  private aii v = new arf(this);
  private aii w = new arg(this);
  private asz x = new asz(new arh(this));
  private Handler y = new ari(this, Looper.getMainLooper());
  private aro z = null;
  
  private aso()
  {
    this.b.b.c = this;
    this.b.a(this.r);
    this.z = new aro(this, this.o);
    j localj = this.n;
    synchronized (localj.a)
    {
      new StringBuilder("添加网络监听 : ").append(getClass().getName());
      localj.a.add(this);
      int i1 = (int)System.currentTimeMillis();
      int k = i1;
      if (i1 < 0) {
        k = -i1;
      }
      this.s.set(k / 100);
      this.A = new ark(this, this.o.getMainLooper());
      if (!j)
      {
        if (30000L < this.r) {
          return;
        }
        throw new AssertionError();
      }
      return;
    }
  }
  
  public static aso a()
  {
    if (C == null) {
      synchronized (B)
      {
        if (C == null) {
          C = new aso();
        }
      }
    }
    return C;
  }
  
  private void a(int paramInt1, int paramInt2, int paramInt3, int paramInt4, byte[] paramArrayOfByte)
  {
    this.A.removeMessages(paramInt3);
    synchronized (this.m)
    {
      Object localObject1 = (arp)this.i.get(paramInt3);
      if (localObject1 == null) {
        return;
      }
      this.i.remove(paramInt3);
      if (arb.filterNetworkCode(paramInt1) == -50000)
      {
        ??? = new StringBuilder("这个超时了 refSeqNo : ");
        ((StringBuilder)???).append(paramInt3);
        ((StringBuilder)???).append(" retCode : ");
        ((StringBuilder)???).append(paramInt1);
      }
      else
      {
        ??? = new StringBuilder("onRecvCallBack : refSeqNo : ");
        ((StringBuilder)???).append(paramInt3);
        ((StringBuilder)???).append(" retCode : ");
        ((StringBuilder)???).append(paramInt1);
      }
      paramArrayOfByte = new asb(paramInt1, paramInt2, paramInt3, paramInt4, paramArrayOfByte, (arp)localObject1);
      paramInt1 = ((arp)localObject1).c & 0x18;
      if (paramInt1 != 8)
      {
        if (paramInt1 != 16)
        {
          kh.a();
          ki.b(new arm(this, paramArrayOfByte), "tcp run callback on thread");
          return;
        }
        b(paramArrayOfByte);
        return;
      }
      localObject1 = Message.obtain();
      ((Message)localObject1).obj = paramArrayOfByte;
      ((Message)localObject1).what = 1;
      this.y.sendMessage((Message)localObject1);
      return;
    }
  }
  
  private void a(int paramInt1, int paramInt2, JceStruct arg3, aii paramaii)
  {
    paramaii = new arp(paramInt1, paramaii, ???);
    synchronized (this.m)
    {
      this.i.append(paramInt2, paramaii);
      return;
    }
  }
  
  private void a(long paramLong)
  {
    this.b.a(paramLong);
  }
  
  private void a(asc paramasc)
  {
    if ((paramasc != null) && (paramasc.f != null))
    {
      if (paramasc.f.a == null) {
        return;
      }
      Object localObject = arw.a(paramasc.e, paramasc.f.b);
      localObject = paramasc.f.a.a(paramasc.a, paramasc.d, (JceStruct)localObject);
      if ((localObject != null) && (((Pair)localObject).first != null) && (((Pair)localObject).second != null))
      {
        ac localac = new ac();
        localac.a = ((Integer)((Pair)localObject).first).intValue();
        localac.b = arw.a((JceStruct)((Pair)localObject).second);
        a(this.k, 655, 32, paramasc.b, paramasc.c, localac, null, null, -1L);
      }
      return;
    }
  }
  
  private void a(boolean paramBoolean)
  {
    try
    {
      this.e = paramBoolean;
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  private void b(int paramInt1, int paramInt2, int paramInt3, int paramInt4, byte[] paramArrayOfByte)
  {
    synchronized (this.l)
    {
      Object localObject2 = (ArrayList)this.h.get(paramInt4);
      if ((localObject2 != null) && (((ArrayList)localObject2).size() > 0))
      {
        localObject2 = (ArrayList)((ArrayList)localObject2).clone();
        ??? = ((List)localObject2).iterator();
        while (((Iterator)???).hasNext())
        {
          Object localObject3 = (arx)((Iterator)???).next();
          localObject2 = new asc(paramInt3, paramInt4, paramArrayOfByte, paramInt1, paramInt2, (arx)localObject3);
          int k = ((arx)localObject3).c & 0x18;
          if (k != 8)
          {
            if (k != 16)
            {
              kh.a();
              ki.b(new arn(this, (asc)localObject2), "tcp run push on thread");
            }
            else
            {
              a((asc)localObject2);
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
  
  private static void b(asb paramasb)
  {
    if (paramasb.f != null)
    {
      if (paramasb.f.a == null) {
        return;
      }
      JceStruct localJceStruct = arq.a(null, paramasb.e, paramasb.f.b);
      if (localJceStruct == null) {
        localJceStruct = paramasb.f.b;
      }
      paramasb.f.a.a(paramasb.c, paramasb.d, paramasb.a, paramasb.b, localJceStruct);
      return;
    }
  }
  
  private void g()
  {
    try
    {
      this.b.a(false, this);
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  private void h()
  {
    aro localaro = this.z;
    if (localaro != null) {
      localaro.removeMessages(0);
    }
  }
  
  private void i()
  {
    if (this.e) {
      return;
    }
    a(true);
    this.f = new HandlerThread("sendHandlerThread");
    this.f.start();
    this.g = new arl(this, this.f.getLooper());
  }
  
  private void j()
  {
    if (!this.e) {
      return;
    }
    a(false);
    this.f.quit();
    this.f = null;
    this.g = null;
  }
  
  final aij a(int paramInt)
  {
    synchronized (this.l)
    {
      Object localObject2 = (ArrayList)this.h.get(paramInt);
      if ((localObject2 != null) && (((ArrayList)localObject2).size() != 0))
      {
        this.h.remove(paramInt);
        localObject2 = ((arx)((ArrayList)localObject2).get(0)).a;
        return localObject2;
      }
      return null;
    }
  }
  
  final WeakReference a(asd paramasd, int paramInt1, int paramInt2, int paramInt3, int paramInt4, JceStruct paramJceStruct1, JceStruct paramJceStruct2, aii paramaii, long paramLong)
  {
    if (aqz.a())
    {
      paramaii.a(0, 0, -7, 0, paramJceStruct2);
      return null;
    }
    if (paramasd != null) {
      this.k = paramasd;
    }
    if (this.k == null)
    {
      paramaii.a(0, 0, -9, 0, paramJceStruct2);
      return null;
    }
    if (!this.e) {
      i();
    }
    byte[] arrayOfByte = arq.a(null, paramJceStruct1);
    paramJceStruct1 = new ai();
    paramJceStruct1.a = paramInt1;
    paramJceStruct1.b = paramasd.b.a();
    paramJceStruct1.c = paramInt3;
    paramJceStruct1.d = arrayOfByte;
    boolean bool;
    if (paramInt1 == 999) {
      bool = true;
    } else {
      bool = false;
    }
    if (paramaii != null) {
      a(paramInt2, paramJceStruct1.b, paramJceStruct2, paramaii);
    }
    paramasd = new aik();
    paramasd.a(0);
    paramJceStruct2 = new ary(paramJceStruct1, paramInt2, bool, paramasd);
    paramJceStruct2.a = paramInt4;
    paramJceStruct2.f = paramLong;
    this.x.a(paramJceStruct2);
    new StringBuilder("ClientSashimi seqNO : ").append(paramJceStruct1.b);
    if (paramLong > 0L)
    {
      paramJceStruct1 = paramJceStruct2.b;
      if ((paramJceStruct1 != null) && (paramJceStruct1 != null))
      {
        paramInt1 = paramJceStruct1.b;
        paramJceStruct1 = new StringBuilder("对 seqNo : ");
        paramJceStruct1.append(paramInt1);
        paramJceStruct1.append(" 的回包计时");
        this.A.sendEmptyMessageDelayed(paramInt1, paramLong);
      }
    }
    this.g.sendEmptyMessage(0);
    return new WeakReference(paramasd);
  }
  
  final WeakReference a(asd paramasd, int paramInt, aii paramaii, long paramLong)
  {
    return a(paramasd, paramInt, 0, 0, 0, null, null, paramaii, paramLong);
  }
  
  final void a(int paramInt1, int paramInt2, JceStruct paramJceStruct, aij paramaij)
  {
    arx localarx = new arx(paramInt1, paramaij, paramJceStruct);
    synchronized (this.l)
    {
      paramaij = (ArrayList)this.h.get(paramInt2);
      paramJceStruct = paramaij;
      if (paramaij == null)
      {
        paramJceStruct = new ArrayList();
        this.h.append(paramInt2, paramJceStruct);
      }
      paramJceStruct.add(localarx);
      return;
    }
  }
  
  public final void a(int paramInt, al paramal)
  {
    Object localObject = paramal.f;
    int k = paramal.a;
    StringBuilder localStringBuilder = new StringBuilder("onRecv cmdId : ");
    localStringBuilder.append(k);
    localStringBuilder.append(" seqNo: ");
    localStringBuilder.append(paramal.b);
    if (k == 10655)
    {
      localObject = (ad)arq.a(null, (byte[])localObject, this.p);
      new StringBuilder("onRecvPush ECmd.Cmd_SCPush, push.cmd: ").append(((ad)localObject).a);
      k = paramal.b;
      b(k, paramInt, k, ((ad)localObject).a, ((ad)localObject).b);
      return;
    }
    a(paramal.d, paramal.e, paramal.c, k, (byte[])localObject);
  }
  
  public final void a(ars paramars)
  {
    ate localate = this.b;
    if (localate != null) {
      localate.a(false);
    }
    this.t = paramars;
    this.u = new arj(this);
    a(0, 10001, new aa(), this.u);
    paramars = this.t;
    if (paramars == null) {
      return;
    }
    paramars.k();
    paramars = this.t.l();
    if ((paramars != null) && (paramars.size() > 0))
    {
      localate = this.b;
      if (localate != null)
      {
        localate.d.a.clear();
        paramars = paramars.iterator();
        while (paramars.hasNext())
        {
          int k = ((Integer)paramars.next()).intValue();
          this.b.a(k);
        }
      }
    }
  }
  
  public final void b()
  {
    try
    {
      this.b.a(false, this);
      this.b.a(true, this);
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  final void c()
  {
    h();
    this.n.b(this.o);
    g();
    j();
    this.x.b();
    this.b.a();
    this.a.set(0);
  }
  
  final boolean d()
  {
    if (this.a.get() <= 0) {
      return false;
    }
    h();
    if (!this.b.b())
    {
      this.z.sendEmptyMessageDelayed(0, 10000L);
      return false;
    }
    a(this.k, 998, this.w, 10000L);
    return true;
  }
  
  public final void e()
  {
    a(this.k, 999, this.v, 30000L);
  }
  
  public final void f()
  {
    d();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.aso
 * JD-Core Version:    0.7.0.1
 */