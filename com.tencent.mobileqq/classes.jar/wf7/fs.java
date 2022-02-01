package wf7;

import android.net.wifi.ScanResult;
import android.net.wifi.WifiConfiguration;
import android.util.Pair;
import android.util.SparseArray;
import com.tencent.qqpimsecure.wificore.api.connect.d;
import com.tencent.qqpimsecure.wificore.api.event.b;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class fs
  implements bp
{
  private long rs = 10000L;
  private boolean rt = false;
  private final SparseArray<Pair<String, Integer>> ru = new SparseArray();
  private final cf rv = new fs.2(this);
  private as.a rw = new fs.3(this);
  
  private fs()
  {
    eG();
    ce.aK().a(1577, this.rv);
    ft.eJ();
    eA();
    eB();
    eC();
    eD();
  }
  
  private void J(boolean paramBoolean)
  {
    Object localObject3 = I(paramBoolean);
    Object localObject4;
    int i;
    Object localObject1;
    if (localObject3 != null)
    {
      if (((SparseArray)localObject3).size() <= 0) {
        return;
      }
      localObject4 = ((b)ao.c().i(3)).o();
      if (localObject4 == null) {
        i = -1122;
      } else {
        i = ((bn)localObject4).Y();
      }
      localObject1 = new ArrayList();
    }
    for (;;)
    {
      int j;
      int m;
      try
      {
        int k = ((SparseArray)localObject3).size();
        j = 0;
        Object localObject5;
        if (j < k)
        {
          m = ((SparseArray)localObject3).keyAt(j);
          localObject5 = (Pair)((SparseArray)localObject3).valueAt(j);
          if (localObject5 != null) {
            break label410;
          }
          if ((goto 421) || (!eF()) || (!bw.as().c((String)((Pair)localObject5).first, ((Integer)((Pair)localObject5).second).intValue()))) {
            break label421;
          }
          ((ArrayList)localObject1).add(localObject5);
          by.r(266579);
          break label421;
        }
        localObject3 = bw.as().at();
        if (localObject3 == null)
        {
          localObject1 = ((ArrayList)localObject1).iterator();
          if (((Iterator)localObject1).hasNext())
          {
            localObject3 = (Pair)((Iterator)localObject1).next();
            i((String)((Pair)localObject3).first, ((Integer)((Pair)localObject3).second).intValue());
            ft.eJ().k((String)((Pair)localObject3).first, ((Integer)((Pair)localObject3).second).intValue());
            continue;
          }
          return;
        }
        localObject4 = ((List)localObject3).iterator();
        if (((Iterator)localObject4).hasNext())
        {
          if ((WifiConfiguration)((Iterator)localObject4).next() == null) {
            continue;
          }
          localObject5 = ((ArrayList)localObject1).iterator();
          if (((Iterator)localObject5).hasNext())
          {
            Pair localPair = (Pair)((Iterator)localObject5).next();
            i((String)localPair.first, ((Integer)localPair.second).intValue());
            if (a((String)localPair.first, ((Integer)localPair.second).intValue(), (List)localObject3) != null) {
              continue;
            }
            ft.eJ().k((String)localPair.first, ((Integer)localPair.second).intValue());
            continue;
          }
          continue;
        }
        return;
      }
      finally {}
      return;
      label410:
      if ((localObject4 != null) && (i == m)) {
        label421:
        j += 1;
      }
    }
  }
  
  public static WifiConfiguration a(String paramString, int paramInt, List<WifiConfiguration> paramList)
  {
    if (paramList != null)
    {
      paramList = paramList.iterator();
      while (paramList.hasNext())
      {
        WifiConfiguration localWifiConfiguration = (WifiConfiguration)paramList.next();
        if ((cb.j(localWifiConfiguration.SSID).compareTo(paramString) == 0) && (cb.d(localWifiConfiguration) == paramInt)) {
          return localWifiConfiguration;
        }
      }
    }
    return null;
  }
  
  public static final fs ez()
  {
    return fs.a.rz;
  }
  
  protected SparseArray<Pair<String, Integer>> I(boolean paramBoolean)
  {
    if (!paramBoolean) {
      return this.ru;
    }
    Object localObject1 = ft.eJ().eI();
    if ((localObject1 != null) && (!((List)localObject1).isEmpty())) {
      synchronized (this.ru)
      {
        localObject1 = ((List)localObject1).iterator();
        while (((Iterator)localObject1).hasNext())
        {
          Pair localPair = (Pair)((Iterator)localObject1).next();
          if ((localPair != null) && (cb.l((String)localPair.first)))
          {
            localPair = as(cb.d((String)localPair.first, ((Integer)localPair.second).intValue()));
            if (localPair == null) {
              h((String)localPair.first, ((Integer)localPair.second).intValue());
            }
          }
        }
        return this.ru;
      }
    }
    return this.ru;
  }
  
  protected void a(int paramInt1, String paramString, int paramInt2)
  {
    synchronized (this.ru)
    {
      this.ru.put(paramInt1, new Pair(paramString, Integer.valueOf(paramInt2)));
      return;
    }
  }
  
  public void a(List<bn> paramList1, List<bn> paramList2)
  {
    if ((paramList2 != null) && (paramList2.size() > 0))
    {
      paramList1 = paramList2.iterator();
      while (paramList1.hasNext())
      {
        paramList2 = (bn)paramList1.next();
        i(paramList2.Z(), paramList2.ab());
        ft.eJ().k(paramList2.Z(), paramList2.ab());
      }
    }
  }
  
  protected Pair<String, Integer> as(int paramInt)
  {
    synchronized (this.ru)
    {
      Pair localPair = (Pair)this.ru.get(paramInt, null);
      return localPair;
    }
  }
  
  protected void at(int paramInt)
  {
    synchronized (this.ru)
    {
      this.ru.delete(paramInt);
      return;
    }
  }
  
  public void b(List<bn> paramList) {}
  
  public void c(List<bn> paramList) {}
  
  public void d(List<bn> paramList) {}
  
  public void d(boolean paramBoolean1, boolean paramBoolean2)
  {
    if ((!paramBoolean2) && (!eE()) && (!eF())) {
      return;
    }
    if ((eH() <= 0) && (!paramBoolean1)) {
      return;
    }
    av localav = bz.av().u().v();
    if (localav == null)
    {
      J(paramBoolean1);
      return;
    }
    localav.a(new fs.4(this, paramBoolean1), "checkAndRemoveConfig");
  }
  
  public void e(List<ScanResult> paramList) {}
  
  protected void eA()
  {
    hm.fq().a(this);
  }
  
  protected void eB()
  {
    as localas = bz.av().u().x();
    localas.a(1034, this.rw);
    localas.a(1013, this.rw);
  }
  
  protected void eC()
  {
    ((d)ao.c().i(4)).a(new fs.1(this));
  }
  
  protected void eD()
  {
    d(true, false);
  }
  
  protected boolean eE()
  {
    boolean bool3 = this.rt;
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (!bool3)
    {
      bool1 = bool2;
      if (this.rs > 0L) {
        bool1 = true;
      }
    }
    return bool1;
  }
  
  protected boolean eF()
  {
    return this.rt;
  }
  
  protected void eG()
  {
    cd localcd = ce.aK().H(1577);
    this.rs = (localcd.e(0, 30) * 60L * 1000L);
    this.rt = cb.G(localcd.e(1, 0));
  }
  
  protected int eH()
  {
    synchronized (this.ru)
    {
      int i = this.ru.size();
      return i;
    }
  }
  
  protected void h(String paramString, int paramInt)
  {
    int i = cb.d(paramString, paramInt);
    if (as(i) == null)
    {
      a(i, paramString, paramInt);
      if (ft.eJ().j(paramString, paramInt)) {
        by.r(266578);
      }
    }
  }
  
  protected void i(String paramString, int paramInt)
  {
    at(cb.d(paramString, paramInt));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     wf7.fs
 * JD-Core Version:    0.7.0.1
 */