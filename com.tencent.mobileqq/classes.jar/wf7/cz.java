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
      Iterator localIterator = paramArrayList.iterator();
      for (;;)
      {
        paramArrayList = localArrayList;
        if (!localIterator.hasNext()) {
          break;
        }
        paramArrayList = (d)localIterator.next();
        if (!ck.L(paramArrayList.v)) {
          paramArrayList.v = 0;
        } else if ((!paramBoolean) && (ck.Q(paramArrayList.v)) && (cj.aS().K(paramArrayList.S) == null)) {
          paramArrayList.v = 0;
        }
        h localh = a(paramArrayList.u, paramArrayList.ssid, paramArrayList.C, paramList);
        if (localh != null)
        {
          int i = cb.E(localh.C);
          Object localObject = localh.ssid;
          localObject = c(localh);
          if (localObject != null)
          {
            ((ct)localObject).d(localh.u);
            ((ct)localObject).ik = System.currentTimeMillis();
            if (paramBoolean) {
              ((bl)((ct)localObject).getData()).b(true);
            } else {
              ((bl)((ct)localObject).getData()).a(true);
            }
            a(((ct)localObject).R(), paramArrayList);
            if (ck.f(paramArrayList.v, i))
            {
              ((ct)localObject).a(paramArrayList);
              ((ct)localObject).o(paramArrayList.V);
            }
            else if (((ct)localObject).R() == null)
            {
              ((ct)localObject).a(paramArrayList);
              ((ct)localObject).o(paramArrayList.V);
            }
            if (paramArrayList.v == 5)
            {
              paramArrayList.v = 4;
            }
            else if (paramArrayList.v == 15)
            {
              paramArrayList.x = 1;
              paramArrayList = ((ct)localObject).R();
              if (paramArrayList != null)
              {
                paramArrayList.x = 1;
                ((ct)localObject).a(paramArrayList);
              }
              ((ct)localObject).bd();
            }
            else if (paramArrayList.v == 2)
            {
              paramArrayList.A = null;
            }
            else if (paramArrayList.v == 19)
            {
              b((ct)localObject);
            }
            localArrayList.add(localObject);
            ((bl)((ct)localObject).getData()).S();
          }
        }
      }
    }
    paramArrayList = null;
    return paramArrayList;
  }
  
  private cz.b a(List<h> paramList, f paramf)
  {
    cz.b localb = new cz.b(this, null);
    if ((paramf != null) && (paramf.ak != null))
    {
      k(paramf.ak);
      localb.jG = a(paramList, paramf.ak, false);
      Object localObject1;
      Object localObject2;
      if (paramf.am != null)
      {
        localObject1 = paramf.am.iterator();
        while (((Iterator)localObject1).hasNext()) {
          localObject2 = (d)((Iterator)localObject1).next();
        }
      }
      localb.jI = d(localb.jG);
      paramList = paramList.iterator();
      while (paramList.hasNext())
      {
        localObject1 = (h)paramList.next();
        Object localObject3;
        if (localb.jG != null)
        {
          localObject2 = localb.jG.iterator();
          while (((Iterator)localObject2).hasNext())
          {
            localObject3 = (ct)((Iterator)localObject2).next();
            if (((ct)localObject3).a((h)localObject1))
            {
              ((ct)localObject3).d(((h)localObject1).u);
              i = 1;
              break label194;
            }
          }
        }
        int i = 0;
        label194:
        if (i == 0)
        {
          localObject2 = c((h)localObject1);
          if (localObject2 != null)
          {
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
          }
        }
      }
      localb.jH = paramf.al;
    }
    return localb;
  }
  
  private h a(byte[] paramArrayOfByte, String paramString, int paramInt, List<h> paramList)
  {
    if ((!TextUtils.isEmpty(paramString)) && (paramArrayOfByte != null) && (paramList != null))
    {
      if (paramList.isEmpty()) {
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
    if (paramct == null) {
      return;
    }
    d locald = paramct.R();
    Object localObject;
    if ((locald != null) && (locald.A != null))
    {
      if (locald.A.length <= 0) {
        return;
      }
      localObject = null;
    }
    try
    {
      c localc = new c();
      JceInputStream localJceInputStream = new JceInputStream(locald.A);
      localJceInputStream.setServerEncoding("UTF-8");
      localc.readFrom(localJceInputStream);
      locald.A = null;
      paramct.a(locald);
      localObject = localc;
    }
    catch (Exception localException)
    {
      label86:
      break label86;
    }
    paramct.a(localObject);
  }
  
  private boolean b(h paramh)
  {
    if ((paramh != null) && (!paramh.aC) && (paramh.ssid != null) && (paramh.ssid.length() > 1) && (paramh.u != null) && (paramh.C == 1))
    {
      paramh = c(paramh);
      return (paramh == null) || ((!((bl)paramh.getData()).Q()) && (!((bl)paramh.getData()).S()));
    }
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
    return false;
  }
  
  private boolean e(h paramh)
  {
    if ((paramh != null) && (paramh.ssid != null))
    {
      paramh = c(paramh);
      return (paramh == null) || ((!((bl)paramh.getData()).Q()) && (!((bl)paramh.getData()).S()));
    }
    return false;
  }
  
  private void k(List<d> paramList)
  {
    if (paramList == null) {
      return;
    }
    if (ch.aP().getBoolean("local_cache_offline_wifi_enable", true))
    {
      paramList = paramList.iterator();
      while (paramList.hasNext())
      {
        d locald = (d)paramList.next();
        int i = locald.aa;
        Object localObject;
        if (i != 1)
        {
          if (i == 3)
          {
            localObject = cw.bo().bs();
            if (localObject != null) {
              ((bj)localObject).c(locald.ssid, cb.c(locald.u), 9);
            }
          }
        }
        else if ((locald.C == 1) && (locald.w != null) && (locald.w.size() > 0))
        {
          localObject = cw.f(locald.ssid, cb.E(locald.C));
          if ((localObject != null) && (((ct)localObject).R() != null) && (ck.h(((ct)localObject).R().v, ((ct)localObject).af().ab())))
          {
            localObject = ((ct)localObject).R().w;
            if ((localObject != null) && (!((ArrayList)localObject).isEmpty()) && (((e)((ArrayList)localObject).get(0)).ah.equals(((e)locald.w.get(0)).ah)))
            {
              i = 1;
              break label237;
            }
          }
          i = 0;
          label237:
          if (i == 0)
          {
            localObject = cw.bo().bs();
            if (localObject != null) {
              ((bj)localObject).a(locald.ssid, cb.c(locald.u), ((e)locald.w.get(0)).ah);
            }
          }
        }
      }
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
    Object localObject4 = new ArrayList();
    boolean bool1 = TextUtils.isEmpty(ch.aP().aR());
    Object localObject5 = paramList.iterator();
    int j = 0;
    int i1 = 0;
    int i = 0;
    Object localObject3;
    Object localObject1;
    int m;
    for (int n = 0;; n = m)
    {
      boolean bool2 = ((Iterator)localObject5).hasNext();
      localObject3 = null;
      localObject2 = null;
      if (!bool2) {
        break;
      }
      localObject3 = (h)((Iterator)localObject5).next();
      if (b((h)localObject3))
      {
        localObject1 = cw.bo().bs();
        if (localObject1 != null)
        {
          localObject1 = ((bj)localObject1).a(cb.c(((h)localObject3).u), ((h)localObject3).ssid, cb.E(((h)localObject3).C));
          j = 1;
        }
        else
        {
          localObject1 = null;
        }
        k = j;
        if (localObject1 != null)
        {
          ((ArrayList)localObject4).add(localObject1);
          if (((d)localObject1).v == 22)
          {
            k = 1;
            i1 = 1;
            break label226;
          }
          k = 1;
          break label226;
        }
      }
      else
      {
        k = j;
      }
      m = 0;
      j = k;
      int k = m;
      label226:
      m = i;
      if (k == 0)
      {
        m = i;
        if (d((h)localObject3))
        {
          bj localbj = cw.bo().bs();
          localObject1 = localObject2;
          if (localbj != null)
          {
            localObject1 = localbj.b(cb.c(((h)localObject3).u), ((h)localObject3).ssid, cb.E(((h)localObject3).C));
            i = 1;
          }
          m = i;
          if (localObject1 != null)
          {
            ((ArrayList)localObject4).add(localObject1);
            i2 = 1;
            break label323;
          }
        }
      }
      i = m;
      int i2 = 0;
      label323:
      m = n;
      if (i2 == 0)
      {
        m = n;
        if (k == 0)
        {
          m = n;
          if (e((h)localObject3))
          {
            localObject1 = ((h)localObject3).ssid;
            localObject2 = cb.c(((h)localObject3).u);
            k = cb.E(((h)localObject3).C);
            localObject1 = cj.aS().d((String)localObject1, (String)localObject2, k);
            if (localObject1 != null)
            {
              localObject2 = new d();
              ((d)localObject2).u = ((h)localObject3).u;
              ((d)localObject2).ssid = ((h)localObject3).ssid;
              ((d)localObject2).C = ((h)localObject3).C;
              localObject3 = new StringBuilder();
              ((StringBuilder)localObject3).append("离线识别-专属WiFi ");
              ((StringBuilder)localObject3).append(((ci)localObject1).hj);
              ((d)localObject2).B = ((StringBuilder)localObject3).toString();
              ((d)localObject2).v = 27;
              ((d)localObject2).S = ((ci)localObject1).hi;
              ((d)localObject2).score = 4;
              if (((ci)localObject1).hi == 2) {
                ((d)localObject2).W = 2;
              }
              ((ArrayList)localObject4).add(localObject2);
            }
            m = 1;
          }
        }
      }
    }
    if (j != 0)
    {
      by.r(387321);
      if ((bool1 ^ true)) {
        by.r(387664);
      }
      if (i1 != 0) {
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
      if (((ArrayList)localObject4).size() > 0)
      {
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
      else
      {
        if (cm.R(3) == 3)
        {
          cm.q(3, 2);
          by.d(501100, -1);
        }
        if (cm.R(9) == 3)
        {
          cm.q(9, 2);
          by.d(501106, -1);
        }
      }
    }
    Object localObject2 = a(paramList, (ArrayList)localObject4, true);
    if ((j == 0) && (i == 0))
    {
      localObject1 = localObject2;
      if (n == 0) {}
    }
    else
    {
      localObject4 = paramList.iterator();
      paramList = (List<h>)localObject3;
      while (((Iterator)localObject4).hasNext())
      {
        localObject1 = (h)((Iterator)localObject4).next();
        if (localObject2 != null)
        {
          localObject3 = ((ArrayList)localObject2).iterator();
          while (((Iterator)localObject3).hasNext())
          {
            localObject5 = (ct)((Iterator)localObject3).next();
            if (((ct)localObject5).a((h)localObject1))
            {
              ((ct)localObject5).d(((h)localObject1).u);
              i = 1;
              break label826;
            }
          }
        }
        i = 0;
        label826:
        if ((i == 0) && ((b((h)localObject1)) || (d((h)localObject1)) || (e((h)localObject1))))
        {
          localObject3 = c((h)localObject1);
          if (localObject3 != null)
          {
            ((ct)localObject3).d(((h)localObject1).u);
            ((bl)((ct)localObject3).getData()).b(true);
            localObject1 = paramList;
            if (paramList == null) {
              localObject1 = new ArrayList();
            }
            ((ArrayList)localObject1).add(localObject3);
            paramList = (List<h>)localObject1;
          }
        }
      }
      if ((paramList != null) && (localObject2 != null))
      {
        ((ArrayList)localObject2).addAll(paramList);
        return localObject2;
      }
      localObject1 = localObject2;
      if (localObject2 == null)
      {
        localObject1 = localObject2;
        if (paramList != null) {
          localObject1 = paramList;
        }
      }
    }
    return localObject1;
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
    boolean bool;
    if (paramInt != 0) {
      bool = true;
    } else {
      bool = false;
    }
    a locala = new a();
    locala.e = bool;
    Object localObject = bz.av().u().y();
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
    localObject = this.jC.w();
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     wf7.cz
 * JD-Core Version:    0.7.0.1
 */