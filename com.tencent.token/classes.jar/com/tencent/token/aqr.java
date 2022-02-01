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

public class aqr
  extends ari
  implements aqv, arb
{
  private static Object B = new Object();
  private static aqr C = null;
  private Handler A = null;
  AtomicInteger a = new AtomicInteger(0);
  public arh b = null;
  int c = 0;
  ke d = null;
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
  private apv t;
  private agx u;
  private agw v = new api(this);
  private agw w = new apj(this);
  private arc x = new arc(new apk(this));
  private Handler y = new apl(this, Looper.getMainLooper());
  private apr z = null;
  
  private aqr()
  {
    this.b.b.c = this;
    this.b.a(this.r);
    this.z = new apr(this, this.o);
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
      this.A = new apn(this, this.o.getMainLooper());
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
  
  public static aqr a()
  {
    if (C == null) {
      synchronized (B)
      {
        if (C == null) {
          C = new aqr();
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
      Object localObject1 = (aps)this.i.get(paramInt3);
      if (localObject1 == null) {
        return;
      }
      this.i.remove(paramInt3);
      if (ape.filterNetworkCode(paramInt1) == -50000)
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
      paramArrayOfByte = new aqe(paramInt1, paramInt2, paramInt3, paramInt4, paramArrayOfByte, (aps)localObject1);
      paramInt1 = ((aps)localObject1).c & 0x18;
      if (paramInt1 != 8)
      {
        if (paramInt1 != 16)
        {
          kd.a();
          ke.b(new app(this, paramArrayOfByte), "tcp run callback on thread");
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
  
  private void a(int paramInt1, int paramInt2, JceStruct arg3, agw paramagw)
  {
    paramagw = new aps(paramInt1, paramagw, ???);
    synchronized (this.m)
    {
      this.i.append(paramInt2, paramagw);
      return;
    }
  }
  
  private void a(long paramLong)
  {
    this.b.a(paramLong);
  }
  
  private void a(aqf paramaqf)
  {
    if ((paramaqf != null) && (paramaqf.f != null))
    {
      if (paramaqf.f.a == null) {
        return;
      }
      Object localObject = apz.a(paramaqf.e, paramaqf.f.b);
      localObject = paramaqf.f.a.a(paramaqf.a, paramaqf.d, (JceStruct)localObject);
      if ((localObject != null) && (((Pair)localObject).first != null) && (((Pair)localObject).second != null))
      {
        ac localac = new ac();
        localac.a = ((Integer)((Pair)localObject).first).intValue();
        localac.b = apz.a((JceStruct)((Pair)localObject).second);
        a(this.k, 655, 32, paramaqf.b, paramaqf.c, localac, null, null, -1L);
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
          Object localObject3 = (aqa)((Iterator)???).next();
          localObject2 = new aqf(paramInt3, paramInt4, paramArrayOfByte, paramInt1, paramInt2, (aqa)localObject3);
          int k = ((aqa)localObject3).c & 0x18;
          if (k != 8)
          {
            if (k != 16)
            {
              kd.a();
              ke.b(new apq(this, (aqf)localObject2), "tcp run push on thread");
            }
            else
            {
              a((aqf)localObject2);
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
  
  private static void b(aqe paramaqe)
  {
    if (paramaqe.f != null)
    {
      if (paramaqe.f.a == null) {
        return;
      }
      JceStruct localJceStruct = apt.a(null, paramaqe.e, paramaqe.f.b);
      if (localJceStruct == null) {
        localJceStruct = paramaqe.f.b;
      }
      paramaqe.f.a.a(paramaqe.c, paramaqe.d, paramaqe.a, paramaqe.b, localJceStruct);
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
    apr localapr = this.z;
    if (localapr != null) {
      localapr.removeMessages(0);
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
    this.g = new apo(this, this.f.getLooper());
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
  
  final agx a(int paramInt)
  {
    synchronized (this.l)
    {
      Object localObject2 = (ArrayList)this.h.get(paramInt);
      if ((localObject2 != null) && (((ArrayList)localObject2).size() != 0))
      {
        this.h.remove(paramInt);
        localObject2 = ((aqa)((ArrayList)localObject2).get(0)).a;
        return localObject2;
      }
      return null;
    }
  }
  
  final WeakReference a(aqg paramaqg, int paramInt1, int paramInt2, int paramInt3, int paramInt4, JceStruct paramJceStruct1, JceStruct paramJceStruct2, agw paramagw, long paramLong)
  {
    if (apc.a())
    {
      paramagw.a(0, 0, -7, 0, paramJceStruct2);
      return null;
    }
    if (paramaqg != null) {
      this.k = paramaqg;
    }
    if (this.k == null)
    {
      paramagw.a(0, 0, -9, 0, paramJceStruct2);
      return null;
    }
    if (!this.e) {
      i();
    }
    byte[] arrayOfByte = apt.a(null, paramJceStruct1);
    paramJceStruct1 = new ai();
    paramJceStruct1.a = paramInt1;
    paramJceStruct1.b = paramaqg.b.a();
    paramJceStruct1.c = paramInt3;
    paramJceStruct1.d = arrayOfByte;
    boolean bool;
    if (paramInt1 == 999) {
      bool = true;
    } else {
      bool = false;
    }
    if (paramagw != null) {
      a(paramInt2, paramJceStruct1.b, paramJceStruct2, paramagw);
    }
    paramaqg = new agy();
    paramaqg.a(0);
    paramJceStruct2 = new aqb(paramJceStruct1, paramInt2, bool, paramaqg);
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
    return new WeakReference(paramaqg);
  }
  
  final WeakReference a(aqg paramaqg, int paramInt, agw paramagw, long paramLong)
  {
    return a(paramaqg, paramInt, 0, 0, 0, null, null, paramagw, paramLong);
  }
  
  final void a(int paramInt1, int paramInt2, JceStruct paramJceStruct, agx paramagx)
  {
    aqa localaqa = new aqa(paramInt1, paramagx, paramJceStruct);
    synchronized (this.l)
    {
      paramagx = (ArrayList)this.h.get(paramInt2);
      paramJceStruct = paramagx;
      if (paramagx == null)
      {
        paramJceStruct = new ArrayList();
        this.h.append(paramInt2, paramJceStruct);
      }
      paramJceStruct.add(localaqa);
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
      localObject = (ad)apt.a(null, (byte[])localObject, this.p);
      new StringBuilder("onRecvPush ECmd.Cmd_SCPush, push.cmd: ").append(((ad)localObject).a);
      k = paramal.b;
      b(k, paramInt, k, ((ad)localObject).a, ((ad)localObject).b);
      return;
    }
    a(paramal.d, paramal.e, paramal.c, k, (byte[])localObject);
  }
  
  public final void a(apv paramapv)
  {
    arh localarh = this.b;
    if (localarh != null) {
      localarh.a(false);
    }
    this.t = paramapv;
    this.u = new apm(this);
    a(0, 10001, new aa(), this.u);
    paramapv = this.t;
    if (paramapv == null) {
      return;
    }
    paramapv.k();
    paramapv = this.t.l();
    if ((paramapv != null) && (paramapv.size() > 0))
    {
      localarh = this.b;
      if (localarh != null)
      {
        localarh.d.a.clear();
        paramapv = paramapv.iterator();
        while (paramapv.hasNext())
        {
          int k = ((Integer)paramapv.next()).intValue();
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
 * Qualified Name:     com.tencent.token.aqr
 * JD-Core Version:    0.7.0.1
 */