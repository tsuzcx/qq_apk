package wf7;

import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import com.qq.taf.jce.JceStruct;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map.Entry;
import java.util.Set;
import java.util.TreeMap;

class eo$d
  implements Runnable
{
  private TreeMap<Integer, eo.c> oU = new TreeMap();
  private ArrayList<eo.c> oV = new ArrayList();
  private Handler oW = new eo.d.1(this, ea.getLooper());
  private Handler oX = new eo.d.2(this, ea.getLooper());
  
  private eo$d(eo parameo) {}
  
  private void a(ae paramae, eo.c paramc, Integer paramInteger1, Integer paramInteger2, Integer paramInteger3)
  {
    paramc.oR.setState(2);
    int i = dm.ad(paramInteger2.intValue());
    if (paramae == null)
    {
      el.cP().a("SharkProtocolQueue", paramInteger1.intValue(), paramc.oP, paramae, 30, i);
      el.cP().aj(paramc.oP);
    }
    while ((paramc.oi == null) && (paramc.oO == null))
    {
      return;
      el.cP().a("SharkProtocolQueue", paramInteger1.intValue(), paramae.ca, paramae, 30, i);
      el.cP().aj(paramae.ca);
    }
    switch (dy.af(paramc.oh))
    {
    default: 
      ea.bV().a(new eo.d.6(this, paramc, paramInteger1, i, paramInteger3), "shark callback");
      return;
    case 16: 
      if ((paramc.oO != null) && (paramc.ob > 0))
      {
        paramc.oO.a(paramc.nL, paramc.ob, paramc.oP, paramInteger1.intValue(), i, paramInteger3.intValue(), paramc.oN);
        return;
      }
      paramc.oi.a(paramc.oP, paramInteger1.intValue(), i, paramInteger3.intValue(), paramc.og);
      return;
    }
    paramae = eo.o(this.oz).obtainMessage(11, new Object[] { paramc, paramInteger1, Integer.valueOf(i), paramInteger3 });
    eo.o(this.oz).sendMessage(paramae);
  }
  
  private void an(int paramInt)
  {
    Object localObject2 = cZ();
    synchronized (this.oU)
    {
      this.oU.clear();
      ??? = ((Set)localObject2).iterator();
      for (;;)
      {
        if (((Iterator)???).hasNext())
        {
          localObject2 = (Map.Entry)((Iterator)???).next();
          try
          {
            a(null, (eo.c)((Map.Entry)localObject2).getValue(), Integer.valueOf(((eo.c)((Map.Entry)localObject2).getValue()).gV), Integer.valueOf(paramInt), Integer.valueOf(-1));
          }
          catch (Exception localException) {}
        }
      }
    }
  }
  
  private void b(boolean paramBoolean, int paramInt1, int paramInt2, ArrayList<ae> paramArrayList)
  {
    if (paramInt1 == 0)
    {
      paramArrayList = paramArrayList.iterator();
      while (paramArrayList.hasNext())
      {
        ae localae = (ae)paramArrayList.next();
        if (am(localae.ca)) {
          d(localae);
        } else if (eo.b(localae)) {
          this.oz.a(paramBoolean, paramInt2, localae);
        } else if (eo.c(localae)) {
          this.oz.b(paramBoolean, paramInt2, localae);
        }
      }
    }
    an(paramInt1);
  }
  
  private void d(ae paramae)
  {
    Object localObject6 = null;
    Object localObject1 = null;
    Object localObject4 = null;
    this.oW.removeMessages(paramae.ca);
    eo.c localc;
    synchronized (this.oU)
    {
      localc = (eo.c)this.oU.get(Integer.valueOf(paramae.ca));
      if (localc == null) {
        return;
      }
      this.oU.remove(Integer.valueOf(paramae.ca));
      if ((paramae.data == null) || (paramae.cc != 0)) {}
    }
    for (;;)
    {
      Object localObject3;
      try
      {
        if ((localc.oO != null) && (localc.ob > 0))
        {
          ??? = ee.a(eo.n(this.oz), eo.m(this.oz).cO().lv.getBytes(), paramae.data, paramae.cf);
          localObject1 = localObject4;
          localObject4 = ???;
          localObject6 = localObject1;
          if (localObject1 == null)
          {
            localObject4 = ???;
            localObject6 = localObject1;
            if (??? == null)
            {
              localObject4 = ???;
              localObject6 = localObject1;
            }
          }
        }
      }
      catch (Exception localException1)
      {
        localObject3 = null;
      }
      try
      {
        if (localc.og != null)
        {
          paramae.cc = dm.ad(-11000300);
          localObject6 = localObject1;
          localObject4 = ???;
        }
        if (localc.oN != localObject4) {
          localc.oN = localObject4;
        }
        if (localc.og != localObject6) {
          localc.og = localObject6;
        }
        try
        {
          a(paramae, localc, Integer.valueOf(paramae.bH), Integer.valueOf(paramae.cc), Integer.valueOf(paramae.cd));
          return;
        }
        catch (Exception paramae)
        {
          return;
        }
        paramae = finally;
        throw paramae;
      }
      catch (Exception localException2)
      {
        break label309;
      }
      ??? = ee.a(eo.n(this.oz), eo.m(this.oz).cO().lv.getBytes(), paramae.data, localc.og, false, paramae.cf);
      localObject1 = ???;
      ??? = null;
      continue;
      label309:
      paramae.cc = dm.ad(-11000900);
      localObject4 = localObject3;
      localObject6 = localObject1;
      continue;
      Object localObject5 = null;
    }
  }
  
  public void a(Integer paramInteger, eo.c paramc)
  {
    this.oU.put(paramInteger, paramc);
  }
  
  public boolean am(int paramInt)
  {
    synchronized (this.oU)
    {
      boolean bool = this.oU.containsKey(Integer.valueOf(paramInt));
      return bool;
    }
  }
  
  public Set<Map.Entry<Integer, eo.c>> cZ()
  {
    synchronized (this.oU)
    {
      TreeMap localTreeMap2 = (TreeMap)this.oU.clone();
      return localTreeMap2.entrySet();
    }
  }
  
  public void run()
  {
    long l = 0L;
    label522:
    label564:
    label844:
    label976:
    for (;;)
    {
      ArrayList localArrayList2;
      ArrayList localArrayList3;
      dx localdx;
      Object localObject1;
      try
      {
        ArrayList localArrayList1 = new ArrayList();
        localArrayList2 = new ArrayList();
        new ArrayList();
        localArrayList3 = new ArrayList();
        localdx = eo.m(this.oz).cO();
        localIterator = cZ().iterator();
        if (!localIterator.hasNext()) {
          break label564;
        }
        localObject1 = (Map.Entry)localIterator.next();
        if (((eo.c)((Map.Entry)localObject1).getValue()).oR.cq()) {
          break label976;
        }
        if (((eo.c)((Map.Entry)localObject1).getValue()).cW())
        {
          this.oX.obtainMessage(1, ((eo.c)((Map.Entry)localObject1).getValue()).oP, ((eo.c)((Map.Entry)localObject1).getValue()).gV).sendToTarget();
          continue;
        }
        ((eo.c)((Map.Entry)localObject1).getValue()).oR.setState(1);
      }
      catch (Exception localException1)
      {
        an(-10001200);
        return;
      }
      x localx = new x();
      localx.bH = ((eo.c)((Map.Entry)localObject1).getValue()).gV;
      localx.bZ = ((eo.c)((Map.Entry)localObject1).getValue()).oP;
      localx.cb = ((eo.c)((Map.Entry)localObject1).getValue()).oe;
      localx.ca = 0;
      localx.data = null;
      Object localObject2;
      if ((!TextUtils.isEmpty(localdx.lv)) || (((eo.c)((Map.Entry)localObject1).getValue()).oM != null))
      {
        localObject2 = ((eo.c)((Map.Entry)localObject1).getValue()).oM;
        localx.data = ee.a(eo.n(this.oz), (byte[])localObject2, localx.bH, localx);
        if (((eo.c)((Map.Entry)localObject1).getValue()).oS > 0L)
        {
          localObject2 = new eq(localx.bH);
          localObject2 = Message.obtain(this.oW, localx.bZ, localObject2);
          this.oW.sendMessageDelayed((Message)localObject2, ((eo.c)((Map.Entry)localObject1).getValue()).oS);
        }
        if ((((eo.c)((Map.Entry)localObject1).getValue()).oh & 0x800) == 0) {
          break label522;
        }
        localException1.add(localx);
      }
      for (;;)
      {
        el.cP().a("SharkProtocolQueue", localx.bH, localx.bZ, localx, 0);
        if (((eo.c)((Map.Entry)localObject1).getValue()).oT <= l) {
          break label976;
        }
        l = ((eo.c)((Map.Entry)localObject1).getValue()).oT;
        break label976;
        localObject2 = ((eo.c)((Map.Entry)localObject1).getValue()).of;
        localx.data = ee.a(eo.n(this.oz), (JceStruct)localObject2, localx.bH, localx);
        break;
        if ((((eo.c)((Map.Entry)localObject1).getValue()).oh & 0x200) != 0) {
          localArrayList2.add(localx);
        } else {
          localArrayList3.add(localx);
        }
      }
      Iterator localIterator = this.oV.iterator();
      for (;;)
      {
        if (localIterator.hasNext())
        {
          localObject1 = (eo.c)localIterator.next();
          if (((eo.c)localObject1).cW())
          {
            if (((eo.c)localObject1).gV != 1103) {
              continue;
            }
            continue;
          }
          localx = new x();
          localx.bH = ((eo.c)localObject1).gV;
          localx.bZ = ew.dg().di();
          localx.ca = ((eo.c)localObject1).oP;
          localx.data = null;
          localx.cc = ((eo.c)localObject1).cc;
          localx.cd = ((eo.c)localObject1).oQ;
          localObject2 = new w();
          ((w)localObject2).bY = ((eo.c)localObject1).bY;
          localx.ce = ((w)localObject2);
          boolean bool = TextUtils.isEmpty(localdx.lv);
          if (bool) {}
          try
          {
            if (((eo.c)localObject1).oM != null) {
              localObject2 = ((eo.c)localObject1).oM;
            }
            for (localx.data = ee.a(eo.n(this.oz), (byte[])localObject2, localx.bH, localx);; localx.data = ee.a(eo.n(this.oz), (JceStruct)localObject2, localx.bH, localx))
            {
              if ((((eo.c)localObject1).oh & 0x800) == 0) {
                break label844;
              }
              localException1.add(localx);
              el.cP().a("SharkProtocolQueue", localx.bH, localx.bZ, localx, 0);
              break;
              localObject2 = ((eo.c)localObject1).of;
            }
          }
          catch (Exception localException2)
          {
            for (;;)
            {
              continue;
              if ((((eo.c)localObject1).oh & 0x200) != 0) {
                localArrayList2.add(localx);
              } else {
                localArrayList3.add(localx);
              }
            }
          }
        }
      }
      if (localException1.size() > 0) {
        eo.m(this.oz).a(2048, l, true, localException1, new eo.d.3(this));
      }
      if (localArrayList2.size() > 0) {
        eo.m(this.oz).a(512, l, true, localArrayList2, new eo.d.4(this));
      }
      if (localArrayList3.size() > 0)
      {
        eo.m(this.oz).a(0, l, true, localArrayList3, new eo.d.5(this));
        return;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     wf7.eo.d
 * JD-Core Version:    0.7.0.1
 */