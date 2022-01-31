package wf7;

import android.net.NetworkInfo;
import android.text.TextUtils;
import com.qq.taf.jce.JceInputStream;
import com.tencent.qqpimsecure.wificore.api.recognize.monitor.DogFood;
import com.tencent.qqpimsecure.wificore.api.recognize.monitor.b;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.List<Lwf7.h;>;

public class cz
{
  aq jC;
  
  public cz(aq paramaq)
  {
    this.jC = paramaq;
  }
  
  private ArrayList<ct> a(List<h> paramList, ArrayList<d> paramArrayList, boolean paramBoolean)
  {
    if (paramArrayList.size() > 0)
    {
      ArrayList localArrayList = new ArrayList();
      paramArrayList = paramArrayList.iterator();
      int i = 0;
      d locald;
      if (paramArrayList.hasNext())
      {
        locald = (d)paramArrayList.next();
        if (!ck.L(locald.v)) {
          locald.v = 0;
        }
      }
      label152:
      label410:
      label411:
      for (;;)
      {
        label61:
        h localh = a(locald.u, locald.ssid, locald.C, paramList);
        if (localh == null) {
          break;
        }
        int j = cb.E(localh.C);
        Object localObject = localh.ssid;
        localObject = c(localh);
        if (localObject == null) {
          break;
        }
        ((ct)localObject).d(localh.u);
        ((ct)localObject).ik = System.currentTimeMillis();
        if (paramBoolean)
        {
          ((bl)((ct)localObject).getData()).b(true);
          a(((ct)localObject).R(), locald);
          if (!ck.f(locald.v, j)) {
            break label292;
          }
          ((ct)localObject).a(locald);
          ((ct)localObject).o(locald.V);
          label193:
          if (locald.v != 5) {
            break label320;
          }
          locald.v = 4;
          label208:
          localArrayList.add(localObject);
          if (!((bl)((ct)localObject).getData()).S()) {
            break label410;
          }
          i += 1;
        }
        for (;;)
        {
          break;
          if ((paramBoolean) || (!ck.Q(locald.v)) || (cj.aS().K(locald.S) != null)) {
            break label411;
          }
          locald.v = 0;
          break label61;
          ((bl)((ct)localObject).getData()).a(true);
          break label152;
          label292:
          if (((ct)localObject).R() != null) {
            break label193;
          }
          ((ct)localObject).a(locald);
          ((ct)localObject).o(locald.V);
          break label193;
          label320:
          if (locald.v == 15)
          {
            locald.x = 1;
            locald = ((ct)localObject).R();
            if (locald != null)
            {
              locald.x = 1;
              ((ct)localObject).a(locald);
            }
            ((ct)localObject).bd();
            break label208;
          }
          if (locald.v == 2)
          {
            locald.A = null;
            break label208;
          }
          if (locald.v != 19) {
            break label208;
          }
          b((ct)localObject);
          break label208;
          return localArrayList;
        }
      }
    }
    return null;
  }
  
  private cz.b a(List<h> paramList, f paramf)
  {
    cz.b localb = new cz.b(this, null);
    Object localObject1;
    Object localObject2;
    if ((paramf != null) && (paramf.ak != null))
    {
      k(paramf.ak);
      localb.jG = a(paramList, paramf.ak, false);
      if (paramf.am != null)
      {
        localObject1 = paramf.am.iterator();
        while (((Iterator)localObject1).hasNext()) {
          localObject2 = (d)((Iterator)localObject1).next();
        }
      }
      localb.jI = d(localb.jG);
      paramList = paramList.iterator();
    }
    label402:
    label405:
    for (;;)
    {
      Object localObject3;
      if (paramList.hasNext())
      {
        localObject1 = (h)paramList.next();
        if (localb.jG == null) {
          break label402;
        }
        localObject2 = localb.jG.iterator();
        while (((Iterator)localObject2).hasNext())
        {
          localObject3 = (ct)((Iterator)localObject2).next();
          if (((ct)localObject3).a((h)localObject1)) {
            ((ct)localObject3).d(((h)localObject1).u);
          }
        }
      }
      for (int i = 1;; i = 0)
      {
        if (i != 0) {
          break label405;
        }
        localObject2 = c((h)localObject1);
        if (localObject2 == null) {
          break;
        }
        ((ct)localObject2).d(((h)localObject1).u);
        ((bl)((ct)localObject2).getData()).a(true);
        ((ct)localObject2).ik = System.currentTimeMillis();
        if ((paramf.am != null) && (paramf.am.size() > 0))
        {
          localObject3 = paramf.am.iterator();
          while (((Iterator)localObject3).hasNext())
          {
            d locald = (d)((Iterator)localObject3).next();
            if ((!TextUtils.isEmpty(locald.ssid)) && (!TextUtils.isEmpty(((h)localObject1).ssid)) && (cb.c(locald.ssid, ((h)localObject1).ssid)) && (locald.C == ((h)localObject1).C))
            {
              a(((ct)localObject2).R(), locald);
              ((ct)localObject2).a(locald);
            }
          }
        }
        if (localb.jG == null) {
          localb.jG = new ArrayList();
        }
        localb.jG.add(localObject2);
        break;
        localb.jH = paramf.al;
        return localb;
      }
    }
  }
  
  private h a(byte[] paramArrayOfByte, String paramString, int paramInt, List<h> paramList)
  {
    if ((TextUtils.isEmpty(paramString)) || (paramArrayOfByte == null) || (paramList == null) || (paramList.isEmpty())) {
      return null;
    }
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      h localh = (h)paramList.next();
      if ((localh != null) && (Arrays.equals(localh.u, paramArrayOfByte)) && (paramString.equals(localh.ssid)) && (paramInt == localh.C)) {
        return localh;
      }
    }
    return null;
  }
  
  private void a(d paramd1, d paramd2)
  {
    if ((paramd1 != null) && (paramd2 != null))
    {
      paramd2.Y += paramd1.Y;
      paramd2.Z += paramd1.Z;
    }
  }
  
  private void b(ct paramct)
  {
    if (paramct == null) {}
    d locald;
    do
    {
      return;
      locald = paramct.R();
    } while ((locald == null) || (locald.A == null) || (locald.A.length <= 0));
    try
    {
      c localc = new c();
      JceInputStream localJceInputStream = new JceInputStream(locald.A);
      localJceInputStream.setServerEncoding("UTF-8");
      localc.readFrom(localJceInputStream);
      locald.A = null;
      paramct.a(locald);
      paramct.a(localc);
      return;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        Object localObject = null;
      }
    }
  }
  
  private boolean b(h paramh)
  {
    if ((paramh != null) && (!paramh.aC) && (paramh.ssid != null) && (paramh.ssid.length() > 1) && (paramh.u != null) && (paramh.C == 1))
    {
      paramh = c(paramh);
      return (paramh == null) || ((!((bl)paramh.getData()).Q()) && (!((bl)paramh.getData()).S()));
    }
    if (paramh != null) {}
    return false;
  }
  
  private int by()
  {
    Object localObject = bz.av().u().y();
    if ((localObject != null) && (((at)localObject).D()))
    {
      localObject = bu.ar();
      if ((localObject != null) && (((NetworkInfo)localObject).getType() == 0)) {
        return 2;
      }
      return 1;
    }
    return 0;
  }
  
  private ct c(h paramh)
  {
    return cw.f(paramh.ssid, cb.E(paramh.C));
  }
  
  private boolean d(ArrayList<ct> paramArrayList)
  {
    if (paramArrayList != null)
    {
      paramArrayList = paramArrayList.iterator();
      while (paramArrayList.hasNext())
      {
        ct localct = (ct)paramArrayList.next();
        if ((localct != null) && (ck.f(localct.L(), localct.af().ab()))) {
          return true;
        }
      }
    }
    return false;
  }
  
  private boolean d(h paramh)
  {
    if ((paramh != null) && (!paramh.aC) && (paramh.ssid != null) && (paramh.ssid.length() > 1) && (paramh.u != null))
    {
      paramh = c(paramh);
      return (paramh == null) || ((!((bl)paramh.getData()).Q()) && (!((bl)paramh.getData()).S()));
    }
    if (paramh != null) {}
    return false;
  }
  
  private boolean e(h paramh)
  {
    if ((paramh != null) && (paramh.ssid != null))
    {
      paramh = c(paramh);
      return (paramh == null) || ((!((bl)paramh.getData()).Q()) && (!((bl)paramh.getData()).S()));
    }
    if (paramh != null) {}
    return false;
  }
  
  private void k(List<d> paramList)
  {
    if (paramList == null) {}
    while (!ch.aP().getBoolean("local_cache_offline_wifi_enable", true)) {
      return;
    }
    paramList = paramList.iterator();
    label25:
    d locald;
    Object localObject;
    while (paramList.hasNext())
    {
      locald = (d)paramList.next();
      switch (locald.aa)
      {
      case 2: 
      default: 
        break;
      case 1: 
        if ((locald.C == 1) && (locald.w != null) && (locald.w.size() > 0))
        {
          localObject = cw.f(locald.ssid, cb.E(locald.C));
          if ((localObject == null) || (((ct)localObject).R() == null) || (!ck.h(((ct)localObject).R().v, ((ct)localObject).af().ab()))) {
            break label302;
          }
          localObject = ((ct)localObject).R().w;
          if ((localObject == null) || (((ArrayList)localObject).isEmpty()) || (!((e)((ArrayList)localObject).get(0)).ah.equals(((e)locald.w.get(0)).ah))) {
            break label302;
          }
        }
        break;
      }
    }
    label302:
    for (int i = 1;; i = 0)
    {
      if (i != 0) {
        break label25;
      }
      localObject = cw.bo().bs();
      if (localObject == null) {
        break label25;
      }
      ((bj)localObject).a(locald.ssid, cb.c(locald.u), ((e)locald.w.get(0)).ah);
      break label25;
      localObject = cw.bo().bs();
      if (localObject == null) {
        break label25;
      }
      ((bj)localObject).c(locald.ssid, cb.c(locald.u), 9);
      break label25;
      break;
    }
  }
  
  private ArrayList<ct> l(List<h> paramList)
  {
    if (cm.R(1) != 1)
    {
      cm.q(1, 1);
      by.d(501098, 1);
    }
    if (cm.R(7) != 1)
    {
      cm.q(7, 1);
      by.d(501104, 1);
    }
    ArrayList localArrayList = new ArrayList();
    int i1;
    Iterator localIterator;
    int i;
    int k;
    int j;
    label84:
    h localh;
    int i3;
    int i4;
    int m;
    int n;
    Object localObject1;
    Object localObject2;
    if (!TextUtils.isEmpty(ch.aP().aR()))
    {
      i1 = 1;
      localIterator = paramList.iterator();
      i = 0;
      k = 0;
      j = 0;
      i2 = 0;
      if (!localIterator.hasNext()) {
        break label521;
      }
      localh = (h)localIterator.next();
      i3 = 0;
      i4 = 0;
      m = i;
      n = i3;
      if (!b(localh)) {
        break label942;
      }
      localObject1 = null;
      localObject2 = cw.bo().bs();
      if (localObject2 != null)
      {
        localObject1 = ((bj)localObject2).a(cb.c(localh.u), localh.ssid, cb.E(localh.C));
        i = 1;
      }
      m = i;
      n = i3;
      if (localObject1 == null) {
        break label942;
      }
      localArrayList.add(localObject1);
      n = 1;
      m = i;
      if (((d)localObject1).v != 22) {
        break label942;
      }
      n = 1;
    }
    for (int i2 = 1;; i2 = i3)
    {
      m = k;
      i3 = i4;
      if (i2 == 0)
      {
        m = k;
        i3 = i4;
        if (d(localh))
        {
          localObject1 = null;
          localObject2 = cw.bo().bs();
          if (localObject2 != null)
          {
            localObject1 = ((bj)localObject2).b(cb.c(localh.u), localh.ssid, cb.E(localh.C));
            k = 1;
          }
          m = k;
          i3 = i4;
          if (localObject1 != null)
          {
            i3 = 1;
            localArrayList.add(localObject1);
            m = k;
          }
        }
      }
      if ((i3 == 0) && (i2 == 0) && (e(localh)))
      {
        localObject1 = localh.ssid;
        localObject2 = cb.c(localh.u);
        j = cb.E(localh.C);
        localObject1 = cj.aS().d((String)localObject1, (String)localObject2, j);
        if (localObject1 != null)
        {
          localObject2 = new d();
          ((d)localObject2).u = localh.u;
          ((d)localObject2).ssid = localh.ssid;
          ((d)localObject2).C = localh.C;
          ((d)localObject2).B = ("离线识别-专属WiFi " + ((ci)localObject1).hj);
          ((d)localObject2).v = 27;
          ((d)localObject2).S = ((ci)localObject1).hi;
          ((d)localObject2).score = 4;
          if (((ci)localObject1).hi == 2) {
            ((d)localObject2).W = 2;
          }
          localArrayList.add(localObject2);
        }
        j = 1;
      }
      for (;;)
      {
        i2 = n;
        k = m;
        break label84;
        i1 = 0;
        break;
        label521:
        if (i != 0)
        {
          by.r(387321);
          if (i1 != 0) {
            by.r(387664);
          }
          if (i2 != 0) {
            by.r(387665);
          }
          if (cm.R(2) != 1)
          {
            cm.q(2, 1);
            by.d(501099, 1);
          }
          if (cm.R(8) != 1)
          {
            cm.q(8, 1);
            by.d(501105, 1);
          }
          if (localArrayList.size() <= 0) {
            break label848;
          }
          if (cm.R(3) != 1)
          {
            cm.q(3, 1);
            by.d(501100, 1);
          }
          if (cm.R(9) != 1)
          {
            cm.q(9, 1);
            by.d(501106, 1);
          }
        }
        localArrayList = a(paramList, localArrayList, true);
        if ((i != 0) || (k != 0) || (j != 0))
        {
          localObject1 = null;
          localIterator = paramList.iterator();
          paramList = (List<h>)localObject1;
        }
        label934:
        label937:
        for (;;)
        {
          label682:
          if (localIterator.hasNext())
          {
            localh = (h)localIterator.next();
            if (localArrayList == null) {
              break label934;
            }
            localObject1 = localArrayList.iterator();
            while (((Iterator)localObject1).hasNext())
            {
              localObject2 = (ct)((Iterator)localObject1).next();
              if (((ct)localObject2).a(localh)) {
                ((ct)localObject2).d(localh.u);
              }
            }
          }
          for (i = 1;; i = 0)
          {
            if ((i != 0) || ((!b(localh)) && (!d(localh)) && (!e(localh)))) {
              break label937;
            }
            localObject1 = c(localh);
            if (localObject1 == null) {
              break label682;
            }
            ((ct)localObject1).d(localh.u);
            ((bl)((ct)localObject1).getData()).b(true);
            if (paramList == null) {
              paramList = new ArrayList();
            }
            for (;;)
            {
              paramList.add(localObject1);
              break label682;
              label848:
              if (cm.R(3) == 3)
              {
                cm.q(3, 2);
                by.d(501100, -1);
              }
              if (cm.R(9) != 3) {
                break;
              }
              cm.q(9, 2);
              by.d(501106, -1);
              break;
              if ((paramList != null) && (localArrayList != null))
              {
                localArrayList.addAll(paramList);
                localObject1 = localArrayList;
              }
              do
              {
                return localObject1;
                if (localArrayList != null) {
                  break;
                }
                localObject1 = paramList;
              } while (paramList != null);
              return localArrayList;
            }
          }
        }
      }
      label942:
      i3 = n;
      n = i2;
      i = m;
    }
  }
  
  private void m(List<h> paramList)
  {
    if ((paramList != null) && (paramList.size() > 0))
    {
      int i = by();
      paramList = paramList.iterator();
      while (paramList.hasNext())
      {
        h localh = (h)paramList.next();
        if (localh.C == 1)
        {
          String str = cb.c(localh.u);
          new cn(localh.ssid, str, localh.C, 0, false, i).b(new String[0]);
        }
      }
    }
  }
  
  public void a(long paramLong1, cz.a parama, List<h> paramList, long paramLong2, int paramInt)
  {
    if (paramInt != 0) {}
    a locala;
    for (boolean bool = true;; bool = false)
    {
      locala = new a();
      locala.e = bool;
      localObject = bz.av().u().y();
      if (localObject != null) {
        locala.d = ((at)localObject).C();
      }
      locala.f = cw.bo().bp().W();
      locala.g = 4;
      locala.j = paramInt;
      if ((localObject != null) && (((at)localObject).D())) {
        locala.i |= 1L;
      }
      if (!cw.bo().bp().T()) {
        locala.i |= 0x2;
      }
      if (cw.bo().bp().U()) {
        locala.i |= 0x4;
      }
      if (cw.bo().bp().V()) {
        locala.i |= 0x8;
      }
      locala.a = new ArrayList();
      locala.a.addAll(paramList);
      locala.k = new ArrayList();
      localObject = cw.bo().V(5).iterator();
      while (((Iterator)localObject).hasNext())
      {
        bn localbn = (bn)((Iterator)localObject).next();
        h localh = new h();
        localh.ssid = localbn.Z();
        localh.u = cb.m(localbn.aa());
        localh.C = cb.F(localbn.ab());
        br localbr = localbn.ac().al();
        if (localbr != null) {
          localh.frequency = localbr.h(localbn.aa());
        }
        locala.k.add(localh);
      }
    }
    Object localObject = this.jC.w();
    if (bool) {
      by.r(260783);
    }
    by.r(387644);
    if (cm.R(1) != 1)
    {
      cm.q(1, 1);
      by.d(501098, 1);
    }
    if (cm.R(4) != 1)
    {
      cm.q(4, 1);
      by.d(501101, 1);
    }
    if (paramLong1 > 0L) {
      cw.bo().br().a(paramLong1, new DogFood(b.fT));
    }
    ((ax)localObject).a(797, locala, new f(), false, new cz.2(this, paramLong1, paramList, parama), paramLong2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     wf7.cz
 * JD-Core Version:    0.7.0.1
 */