package btmsdkobf;

import android.os.Handler;
import android.os.Message;
import com.qq.taf.jce.JceStruct;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map.Entry;
import java.util.Set;
import java.util.TreeMap;

class hi
  implements Runnable
{
  private TreeMap b = new TreeMap();
  private ArrayList c = new ArrayList();
  private Handler d = new hj(this, cx.getLooper());
  private Handler e = new hk(this, cx.getLooper());
  
  private hi(db paramdb) {}
  
  private void a(ba paramba)
  {
    Object localObject6 = null;
    Object localObject1 = null;
    Object localObject3 = null;
    this.d.removeMessages(paramba.dd);
    hh localhh;
    synchronized (this.b)
    {
      localhh = (hh)this.b.get(Integer.valueOf(paramba.dd));
      if (localhh == null) {
        return;
      }
      this.b.remove(Integer.valueOf(paramba.dd));
      if ((paramba.data == null) || (paramba.df != 0)) {}
    }
    for (;;)
    {
      try
      {
        if ((localhh.k != null) && (localhh.b > 0))
        {
          ??? = cd.a(db.u(this.a), db.v(this.a).ai().is.getBytes(), paramba.data, paramba.di);
          localObject1 = localObject3;
          localObject3 = ???;
          localObject6 = localObject1;
          if (localObject1 == null)
          {
            localObject3 = ???;
            localObject6 = localObject1;
            if (??? == null)
            {
              localObject3 = ???;
              localObject6 = localObject1;
            }
          }
        }
      }
      catch (Throwable localThrowable1)
      {
        ??? = null;
      }
      try
      {
        if (localhh.g != null)
        {
          paramba.df = bz.p(-11000300);
          localObject6 = localObject1;
          localObject3 = ???;
        }
        if (localhh.h != localObject3) {
          localhh.h = localObject3;
        }
        if (localhh.g != localObject6) {
          localhh.g = localObject6;
        }
        try
        {
          a(paramba, localhh, Integer.valueOf(paramba.bM), Integer.valueOf(paramba.df), Integer.valueOf(paramba.dg));
          return;
        }
        catch (Exception paramba)
        {
          eh.a("SharkProtocolQueue", "callback crash", paramba);
          return;
        }
        paramba = finally;
        throw paramba;
      }
      catch (Throwable localThrowable2)
      {
        Object localObject4;
        break label317;
      }
      ??? = cd.a(db.u(this.a), db.v(this.a).ai().is.getBytes(), paramba.data, localhh.g, false, paramba.di);
      localObject1 = ???;
      ??? = null;
      continue;
      label317:
      eh.b("SharkProtocolQueue", "sashimi decode fail", localThrowable1);
      paramba.df = bz.p(-11000900);
      localObject4 = ???;
      localObject6 = localObject1;
      continue;
      Object localObject5 = null;
    }
  }
  
  private void a(ba paramba, hh paramhh, Integer paramInteger1, Integer paramInteger2, Integer paramInteger3)
  {
    paramhh.o.setState(2);
    int i = bz.p(paramInteger2.intValue());
    if (paramba == null)
    {
      cv.by().a("SharkProtocolQueue", paramInteger1.intValue(), paramhh.l, paramba, 30, i);
      cv.by().x(paramhh.l);
    }
    while ((paramhh.j == null) && (paramhh.k == null))
    {
      return;
      cv.by().a("SharkProtocolQueue", paramInteger1.intValue(), paramba.dd, paramba, 30, i);
      cv.by().x(paramba.dd);
    }
    switch (bv.k(paramhh.i))
    {
    default: 
      paramba = new hp(this, paramhh, paramInteger1, i, paramInteger3);
      if ((paramInteger1.intValue() == 2016) || (paramInteger1.intValue() == 12016))
      {
        ee.cT().addUrgentTask(paramba, "shark callback(urgent)");
        return;
      }
      break;
    case 16: 
      if ((paramhh.k != null) && (paramhh.b > 0))
      {
        paramhh.k.a(paramhh.a, paramhh.b, paramhh.l, paramInteger1.intValue(), i, paramInteger3.intValue(), paramhh.h);
        return;
      }
      paramhh.j.onFinish(paramhh.l, paramInteger1.intValue(), i, paramInteger3.intValue(), paramhh.g);
      return;
    case 8: 
      paramba = db.w(this.a).obtainMessage(11, new Object[] { paramhh, paramInteger1, Integer.valueOf(i), paramInteger3 });
      db.w(this.a).sendMessage(paramba);
      return;
    }
    ee.cT().addTask(paramba, "shark callback");
  }
  
  private void a(boolean paramBoolean, int paramInt1, int paramInt2, ArrayList paramArrayList)
  {
    if (paramInt1 == 0)
    {
      paramArrayList = paramArrayList.iterator();
      while (paramArrayList.hasNext())
      {
        ba localba = (ba)paramArrayList.next();
        if (a(localba.dd)) {
          a(localba);
        } else if (db.b(localba)) {
          this.a.a(paramBoolean, paramInt2, localba);
        } else if (db.c(localba)) {
          this.a.b(paramBoolean, paramInt2, localba);
        } else {
          eh.g("SharkProtocolQueue", "No callback xx: cmd : " + localba.bM + " seqNo : " + localba.dc + " refSeqNo : " + localba.dd);
        }
      }
    }
    b(paramInt1);
  }
  
  private void b(int paramInt)
  {
    Object localObject2 = a();
    synchronized (this.b)
    {
      this.b.clear();
      ??? = ((Set)localObject2).iterator();
      for (;;)
      {
        if (((Iterator)???).hasNext())
        {
          localObject2 = (Map.Entry)((Iterator)???).next();
          try
          {
            a(null, (hh)((Map.Entry)localObject2).getValue(), Integer.valueOf(((hh)((Map.Entry)localObject2).getValue()).d), Integer.valueOf(paramInt), Integer.valueOf(-1));
          }
          catch (Throwable localThrowable)
          {
            eh.b("SharkProtocolQueue", "callback crash", localThrowable);
          }
        }
      }
    }
  }
  
  public Set a()
  {
    synchronized (this.b)
    {
      TreeMap localTreeMap2 = (TreeMap)this.b.clone();
      return localTreeMap2.entrySet();
    }
  }
  
  public void a(Integer paramInteger, hh paramhh)
  {
    this.b.put(paramInteger, paramhh);
  }
  
  public boolean a(int paramInt)
  {
    synchronized (this.b)
    {
      boolean bool = this.b.containsKey(Integer.valueOf(paramInt));
      return bool;
    }
  }
  
  public void run()
  {
    long l1 = 0L;
    label569:
    label1245:
    for (;;)
    {
      ArrayList localArrayList2;
      ArrayList localArrayList3;
      ArrayList localArrayList4;
      Object localObject1;
      try
      {
        ArrayList localArrayList1 = new ArrayList();
        localArrayList2 = new ArrayList();
        localArrayList3 = new ArrayList();
        localArrayList4 = new ArrayList();
        localIterator = a().iterator();
        if (!localIterator.hasNext()) {
          break label642;
        }
        localObject1 = (Map.Entry)localIterator.next();
        if (((hh)((Map.Entry)localObject1).getValue()).o.bA()) {
          break label1245;
        }
        if (((hh)((Map.Entry)localObject1).getValue()).a())
        {
          this.e.obtainMessage(1, ((hh)((Map.Entry)localObject1).getValue()).l, ((hh)((Map.Entry)localObject1).getValue()).d).sendToTarget();
          continue;
        }
        ((hh)((Map.Entry)localObject1).getValue()).o.setState(1);
      }
      catch (Exception localException1)
      {
        eh.b("SharkProtocolQueue", "run shark task e: " + localException1.toString(), localException1);
        b(-10001200);
        return;
      }
      as localas = new as();
      localas.bM = ((hh)((Map.Entry)localObject1).getValue()).d;
      localas.dc = ((hh)((Map.Entry)localObject1).getValue()).l;
      localas.de = ((hh)((Map.Entry)localObject1).getValue()).c;
      localas.dd = 0;
      localas.data = null;
      Object localObject2;
      if (((hh)((Map.Entry)localObject1).getValue()).f != null)
      {
        localObject2 = ((hh)((Map.Entry)localObject1).getValue()).f;
        localas.data = cd.a(db.u(this.a), (byte[])localObject2, localas.bM, localas);
        long l3 = ((hh)((Map.Entry)localObject1).getValue()).p;
        long l2 = l3;
        if (l3 <= 0L) {
          l2 = 30000L;
        }
        eh.i("SharkProtocolQueue", "[shark_timer]对seq: " + localas.dc + "计时(ms): " + l2);
        localObject2 = new hw(localas.bM);
        localObject2 = Message.obtain(this.d, localas.dc, localObject2);
        this.d.sendMessageDelayed((Message)localObject2, l2);
        if ((((hh)((Map.Entry)localObject1).getValue()).i & 0x800) == 0) {
          break label569;
        }
        localException1.add(localas);
      }
      for (;;)
      {
        cv.by().a("SharkProtocolQueue", localas.bM, localas.dc, localas, 0);
        if (((hh)((Map.Entry)localObject1).getValue()).q <= l1) {
          break label1245;
        }
        l1 = ((hh)((Map.Entry)localObject1).getValue()).q;
        break label1245;
        localObject2 = ((hh)((Map.Entry)localObject1).getValue()).e;
        localas.data = cd.a(db.u(this.a), (JceStruct)localObject2, localas.bM, localas);
        break;
        if ((((hh)((Map.Entry)localObject1).getValue()).i & 0x200) != 0) {
          localArrayList2.add(localas);
        } else if ((((hh)((Map.Entry)localObject1).getValue()).i & 0x400) != 0) {
          localArrayList3.add(localas);
        } else {
          localArrayList4.add(localas);
        }
      }
      Iterator localIterator = this.c.iterator();
      for (;;)
      {
        if (localIterator.hasNext())
        {
          localObject1 = (hh)localIterator.next();
          if (((hh)localObject1).a())
          {
            if (((hh)localObject1).d == 1103)
            {
              eh.h("SharkProtocolQueue", "[time_out]发送push的业务回包超时： mSeqNo: " + ((hh)localObject1).l + " pushId: " + ((hh)localObject1).r);
              continue;
            }
            eh.h("SharkProtocolQueue", "[time_out]发送push的自动回包超时： mSeqNo: " + ((hh)localObject1).l + " pushId: " + ((hh)localObject1).r + " mCmdId: " + ((hh)localObject1).d);
            continue;
          }
          localas = new as();
          localas.bM = ((hh)localObject1).d;
          localas.dc = cu.bu().bm();
          localas.dd = ((hh)localObject1).l;
          localas.data = null;
          localas.df = ((hh)localObject1).m;
          localas.dg = ((hh)localObject1).n;
          localObject2 = new ar();
          ((ar)localObject2).db = ((hh)localObject1).r;
          localas.dh = ((ar)localObject2);
          eh.f("SharkProtocolQueue", "resp push, seqNo: " + localas.dc + " pushId: " + ((hh)localObject1).r);
          try
          {
            if (((hh)localObject1).f != null) {
              localObject2 = ((hh)localObject1).f;
            }
            for (localas.data = cd.a(db.u(this.a), (byte[])localObject2, localas.bM, localas);; localas.data = cd.a(db.u(this.a), (JceStruct)localObject2, localas.bM, localas))
            {
              if ((((hh)localObject1).i & 0x800) == 0) {
                break label1057;
              }
              localException1.add(localas);
              cv.by().a("SharkProtocolQueue", localas.bM, localas.dc, localas, 0);
              break;
              localObject2 = ((hh)localObject1).e;
            }
          }
          catch (Exception localException2)
          {
            for (;;)
            {
              continue;
              if ((((hh)localObject1).i & 0x200) != 0) {
                localArrayList2.add(localas);
              } else if ((((hh)localObject1).i & 0x400) != 0) {
                localArrayList3.add(localas);
              } else {
                localArrayList4.add(localas);
              }
            }
          }
        }
      }
      if (localException1.size() > 0) {
        db.v(this.a).a(2048, l1, true, localException1, new hl(this));
      }
      if (localArrayList2.size() > 0) {
        db.v(this.a).a(512, l1, true, localArrayList2, new hm(this));
      }
      if (localArrayList3.size() > 0) {
        db.v(this.a).a(1024, l1, true, localArrayList3, new hn(this));
      }
      if (localArrayList4.size() > 0)
      {
        db.v(this.a).a(0, l1, true, localArrayList4, new ho(this));
        return;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     btmsdkobf.hi
 * JD-Core Version:    0.7.0.1
 */