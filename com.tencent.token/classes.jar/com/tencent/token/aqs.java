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

public class aqs
  extends arj
  implements aqw, arc
{
  private static Object B = new Object();
  private static aqs C = null;
  private Handler A = null;
  AtomicInteger a = new AtomicInteger(0);
  public ari b = null;
  int c = 0;
  kf d = null;
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
  private apw t;
  private agy u;
  private agx v = new apj(this);
  private agx w = new apk(this);
  private ard x = new ard(new apl(this));
  private Handler y = new apm(this, Looper.getMainLooper());
  private aps z = null;
  
  private aqs()
  {
    this.b.b.c = this;
    this.b.a(this.r);
    this.z = new aps(this, this.o);
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
      this.A = new apo(this, this.o.getMainLooper());
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
  
  public static aqs a()
  {
    if (C == null) {
      synchronized (B)
      {
        if (C == null) {
          C = new aqs();
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
      Object localObject1 = (apt)this.i.get(paramInt3);
      if (localObject1 == null) {
        return;
      }
      this.i.remove(paramInt3);
      if (apf.filterNetworkCode(paramInt1) == -50000)
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
      paramArrayOfByte = new aqf(paramInt1, paramInt2, paramInt3, paramInt4, paramArrayOfByte, (apt)localObject1);
      paramInt1 = ((apt)localObject1).c & 0x18;
      if (paramInt1 != 8)
      {
        if (paramInt1 != 16)
        {
          ke.a();
          kf.b(new apq(this, paramArrayOfByte), "tcp run callback on thread");
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
  
  private void a(int paramInt1, int paramInt2, JceStruct arg3, agx paramagx)
  {
    paramagx = new apt(paramInt1, paramagx, ???);
    synchronized (this.m)
    {
      this.i.append(paramInt2, paramagx);
      return;
    }
  }
  
  private void a(long paramLong)
  {
    this.b.a(paramLong);
  }
  
  private void a(aqg paramaqg)
  {
    if ((paramaqg != null) && (paramaqg.f != null))
    {
      if (paramaqg.f.a == null) {
        return;
      }
      Object localObject = aqa.a(paramaqg.e, paramaqg.f.b);
      localObject = paramaqg.f.a.a(paramaqg.a, paramaqg.d, (JceStruct)localObject);
      if ((localObject != null) && (((Pair)localObject).first != null) && (((Pair)localObject).second != null))
      {
        ac localac = new ac();
        localac.a = ((Integer)((Pair)localObject).first).intValue();
        localac.b = aqa.a((JceStruct)((Pair)localObject).second);
        a(this.k, 655, 32, paramaqg.b, paramaqg.c, localac, null, null, -1L);
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
          Object localObject3 = (aqb)((Iterator)???).next();
          localObject2 = new aqg(paramInt3, paramInt4, paramArrayOfByte, paramInt1, paramInt2, (aqb)localObject3);
          int k = ((aqb)localObject3).c & 0x18;
          if (k != 8)
          {
            if (k != 16)
            {
              ke.a();
              kf.b(new apr(this, (aqg)localObject2), "tcp run push on thread");
            }
            else
            {
              a((aqg)localObject2);
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
  
  private static void b(aqf paramaqf)
  {
    if (paramaqf.f != null)
    {
      if (paramaqf.f.a == null) {
        return;
      }
      JceStruct localJceStruct = apu.a(null, paramaqf.e, paramaqf.f.b);
      if (localJceStruct == null) {
        localJceStruct = paramaqf.f.b;
      }
      paramaqf.f.a.a(paramaqf.c, paramaqf.d, paramaqf.a, paramaqf.b, localJceStruct);
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
    aps localaps = this.z;
    if (localaps != null) {
      localaps.removeMessages(0);
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
    this.g = new app(this, this.f.getLooper());
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
  
  final agy a(int paramInt)
  {
    synchronized (this.l)
    {
      Object localObject2 = (ArrayList)this.h.get(paramInt);
      if ((localObject2 != null) && (((ArrayList)localObject2).size() != 0))
      {
        this.h.remove(paramInt);
        localObject2 = ((aqb)((ArrayList)localObject2).get(0)).a;
        return localObject2;
      }
      return null;
    }
  }
  
  final WeakReference a(aqh paramaqh, int paramInt1, int paramInt2, int paramInt3, int paramInt4, JceStruct paramJceStruct1, JceStruct paramJceStruct2, agx paramagx, long paramLong)
  {
    if (apd.a())
    {
      paramagx.a(0, 0, -7, 0, paramJceStruct2);
      return null;
    }
    if (paramaqh != null) {
      this.k = paramaqh;
    }
    if (this.k == null)
    {
      paramagx.a(0, 0, -9, 0, paramJceStruct2);
      return null;
    }
    if (!this.e) {
      i();
    }
    byte[] arrayOfByte = apu.a(null, paramJceStruct1);
    paramJceStruct1 = new ai();
    paramJceStruct1.a = paramInt1;
    paramJceStruct1.b = paramaqh.b.a();
    paramJceStruct1.c = paramInt3;
    paramJceStruct1.d = arrayOfByte;
    boolean bool;
    if (paramInt1 == 999) {
      bool = true;
    } else {
      bool = false;
    }
    if (paramagx != null) {
      a(paramInt2, paramJceStruct1.b, paramJceStruct2, paramagx);
    }
    paramaqh = new agz();
    paramaqh.a(0);
    paramJceStruct2 = new aqc(paramJceStruct1, paramInt2, bool, paramaqh);
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
    return new WeakReference(paramaqh);
  }
  
  final WeakReference a(aqh paramaqh, int paramInt, agx paramagx, long paramLong)
  {
    return a(paramaqh, paramInt, 0, 0, 0, null, null, paramagx, paramLong);
  }
  
  final void a(int paramInt1, int paramInt2, JceStruct paramJceStruct, agy paramagy)
  {
    aqb localaqb = new aqb(paramInt1, paramagy, paramJceStruct);
    synchronized (this.l)
    {
      paramagy = (ArrayList)this.h.get(paramInt2);
      paramJceStruct = paramagy;
      if (paramagy == null)
      {
        paramJceStruct = new ArrayList();
        this.h.append(paramInt2, paramJceStruct);
      }
      paramJceStruct.add(localaqb);
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
      localObject = (ad)apu.a(null, (byte[])localObject, this.p);
      new StringBuilder("onRecvPush ECmd.Cmd_SCPush, push.cmd: ").append(((ad)localObject).a);
      k = paramal.b;
      b(k, paramInt, k, ((ad)localObject).a, ((ad)localObject).b);
      return;
    }
    a(paramal.d, paramal.e, paramal.c, k, (byte[])localObject);
  }
  
  public final void a(apw paramapw)
  {
    ari localari = this.b;
    if (localari != null) {
      localari.a(false);
    }
    this.t = paramapw;
    this.u = new apn(this);
    a(0, 10001, new aa(), this.u);
    paramapw = this.t;
    if (paramapw == null) {
      return;
    }
    paramapw.k();
    paramapw = this.t.l();
    if ((paramapw != null) && (paramapw.size() > 0))
    {
      localari = this.b;
      if (localari != null)
      {
        localari.d.a.clear();
        paramapw = paramapw.iterator();
        while (paramapw.hasNext())
        {
          int k = ((Integer)paramapw.next()).intValue();
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
 * Qualified Name:     com.tencent.token.aqs
 * JD-Core Version:    0.7.0.1
 */