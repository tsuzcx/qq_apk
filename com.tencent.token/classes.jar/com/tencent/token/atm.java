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

public class atm
  extends aud
  implements atq, atw
{
  private static Object B = new Object();
  private static atm C = null;
  private Handler A = null;
  AtomicInteger a = new AtomicInteger(0);
  public auc b = null;
  int c = 0;
  kw d = null;
  boolean e = false;
  HandlerThread f = null;
  Handler g = null;
  SparseArray h = new SparseArray();
  SparseArray i = new SparseArray();
  private Object l = new Object();
  private Object m = new Object();
  private j n = j.a();
  private Context o = null;
  private ar p = new ar();
  private final long q = -1L;
  private long r = 180000L;
  private AtomicInteger s = new AtomicInteger(0);
  private asq t;
  private ajj u;
  private aji v = new asd(this);
  private aji w = new ase(this);
  private atx x = new atx(new asf(this));
  private Handler y = new asg(this, Looper.getMainLooper());
  private asm z = null;
  
  private atm()
  {
    this.b.b.c = this;
    this.b.a(this.r);
    this.z = new asm(this, this.o);
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
      this.A = new asi(this, this.o.getMainLooper());
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
  
  public static atm a()
  {
    if (C == null) {
      synchronized (B)
      {
        if (C == null) {
          C = new atm();
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
      Object localObject1 = (asn)this.i.get(paramInt3);
      if (localObject1 == null) {
        return;
      }
      this.i.remove(paramInt3);
      if (arz.filterNetworkCode(paramInt1) == -50000)
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
      paramArrayOfByte = new asz(paramInt1, paramInt2, paramInt3, paramInt4, paramArrayOfByte, (asn)localObject1);
      paramInt1 = ((asn)localObject1).c & 0x18;
      if (paramInt1 != 8)
      {
        if (paramInt1 != 16)
        {
          kv.a();
          kw.b(new ask(this, paramArrayOfByte), "tcp run callback on thread");
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
  
  private void a(int paramInt1, int paramInt2, JceStruct arg3, aji paramaji)
  {
    paramaji = new asn(paramInt1, paramaji, ???);
    synchronized (this.m)
    {
      this.i.append(paramInt2, paramaji);
      return;
    }
  }
  
  private void a(long paramLong)
  {
    this.b.a(paramLong);
  }
  
  private void a(ata paramata)
  {
    if ((paramata != null) && (paramata.f != null))
    {
      if (paramata.f.a == null) {
        return;
      }
      Object localObject = asu.a(paramata.e, paramata.f.b);
      localObject = paramata.f.a.a(paramata.a, paramata.d, (JceStruct)localObject);
      if ((localObject != null) && (((Pair)localObject).first != null) && (((Pair)localObject).second != null))
      {
        aq localaq = new aq();
        localaq.a = ((Integer)((Pair)localObject).first).intValue();
        localaq.b = asu.a((JceStruct)((Pair)localObject).second);
        a(this.k, 655, 32, paramata.b, paramata.c, localaq, null, null, -1L);
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
          Object localObject3 = (asv)((Iterator)???).next();
          localObject2 = new ata(paramInt3, paramInt4, paramArrayOfByte, paramInt1, paramInt2, (asv)localObject3);
          int k = ((asv)localObject3).c & 0x18;
          if (k != 8)
          {
            if (k != 16)
            {
              kv.a();
              kw.b(new asl(this, (ata)localObject2), "tcp run push on thread");
            }
            else
            {
              a((ata)localObject2);
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
  
  private static void b(asz paramasz)
  {
    if (paramasz.f != null)
    {
      if (paramasz.f.a == null) {
        return;
      }
      JceStruct localJceStruct = aso.a(null, paramasz.e, paramasz.f.b);
      if (localJceStruct == null) {
        localJceStruct = paramasz.f.b;
      }
      paramasz.f.a.a(paramasz.c, paramasz.d, paramasz.a, paramasz.b, localJceStruct);
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
    asm localasm = this.z;
    if (localasm != null) {
      localasm.removeMessages(0);
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
    this.g = new asj(this, this.f.getLooper());
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
  
  final ajj a(int paramInt)
  {
    synchronized (this.l)
    {
      Object localObject2 = (ArrayList)this.h.get(paramInt);
      if ((localObject2 != null) && (((ArrayList)localObject2).size() != 0))
      {
        this.h.remove(paramInt);
        localObject2 = ((asv)((ArrayList)localObject2).get(0)).a;
        return localObject2;
      }
      return null;
    }
  }
  
  final WeakReference a(atb paramatb, int paramInt1, int paramInt2, int paramInt3, int paramInt4, JceStruct paramJceStruct1, JceStruct paramJceStruct2, aji paramaji, long paramLong)
  {
    if (arx.a())
    {
      paramaji.a(0, 0, -7, 0, paramJceStruct2);
      return null;
    }
    if (paramatb != null) {
      this.k = paramatb;
    }
    if (this.k == null)
    {
      paramaji.a(0, 0, -9, 0, paramJceStruct2);
      return null;
    }
    if (!this.e) {
      i();
    }
    byte[] arrayOfByte = aso.a(null, paramJceStruct1);
    paramJceStruct1 = new aw();
    paramJceStruct1.a = paramInt1;
    paramJceStruct1.b = paramatb.b.a();
    paramJceStruct1.c = paramInt3;
    paramJceStruct1.d = arrayOfByte;
    boolean bool;
    if (paramInt1 == 999) {
      bool = true;
    } else {
      bool = false;
    }
    if (paramaji != null) {
      a(paramInt2, paramJceStruct1.b, paramJceStruct2, paramaji);
    }
    paramatb = new ajk();
    paramatb.a(0);
    paramJceStruct2 = new asw(paramJceStruct1, paramInt2, bool, paramatb);
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
    return new WeakReference(paramatb);
  }
  
  final WeakReference a(atb paramatb, int paramInt, aji paramaji, long paramLong)
  {
    return a(paramatb, paramInt, 0, 0, 0, null, null, paramaji, paramLong);
  }
  
  final void a(int paramInt1, int paramInt2, JceStruct paramJceStruct, ajj paramajj)
  {
    asv localasv = new asv(paramInt1, paramajj, paramJceStruct);
    synchronized (this.l)
    {
      paramajj = (ArrayList)this.h.get(paramInt2);
      paramJceStruct = paramajj;
      if (paramajj == null)
      {
        paramJceStruct = new ArrayList();
        this.h.append(paramInt2, paramJceStruct);
      }
      paramJceStruct.add(localasv);
      return;
    }
  }
  
  public final void a(int paramInt, az paramaz)
  {
    Object localObject = paramaz.f;
    int k = paramaz.a;
    StringBuilder localStringBuilder = new StringBuilder("onRecv cmdId : ");
    localStringBuilder.append(k);
    localStringBuilder.append(" seqNo: ");
    localStringBuilder.append(paramaz.b);
    if (k == 10655)
    {
      localObject = (ar)aso.a(null, (byte[])localObject, this.p);
      new StringBuilder("onRecvPush ECmd.Cmd_SCPush, push.cmd: ").append(((ar)localObject).a);
      k = paramaz.b;
      b(k, paramInt, k, ((ar)localObject).a, ((ar)localObject).b);
      return;
    }
    a(paramaz.d, paramaz.e, paramaz.c, k, (byte[])localObject);
  }
  
  public final void a(asq paramasq)
  {
    auc localauc = this.b;
    if (localauc != null) {
      localauc.a(false);
    }
    this.t = paramasq;
    this.u = new ash(this);
    a(0, 10001, new ao(), this.u);
    paramasq = this.t;
    if (paramasq == null) {
      return;
    }
    paramasq.k();
    paramasq = this.t.l();
    if ((paramasq != null) && (paramasq.size() > 0))
    {
      localauc = this.b;
      if (localauc != null)
      {
        localauc.d.a.clear();
        paramasq = paramasq.iterator();
        while (paramasq.hasNext())
        {
          int k = ((Integer)paramasq.next()).intValue();
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
 * Qualified Name:     com.tencent.token.atm
 * JD-Core Version:    0.7.0.1
 */