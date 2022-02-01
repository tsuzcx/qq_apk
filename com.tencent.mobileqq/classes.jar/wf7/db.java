package wf7;

import android.content.Context;
import android.content.IntentFilter;
import android.net.wifi.ScanResult;
import android.net.wifi.WifiConfiguration;
import android.net.wifi.WifiInfo;
import android.os.Handler;
import android.text.TextUtils;
import android.util.SparseArray;
import android.util.SparseIntArray;
import com.tencent.qqpimsecure.wificore.api.event.b;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.List<Lwf7.br;>;

public class db
  implements bq
{
  private final Object hx = new Object();
  private final SparseArray<br> jJ = new SparseArray();
  private final SparseArray<bn> jK = new SparseArray();
  private final ArrayList<bp> jL = new ArrayList();
  private boolean jM = false;
  private boolean jN = false;
  private long jO = 0L;
  private ba jP = new db.1(this);
  private Handler mHandler = null;
  
  private void a(WifiConfiguration paramWifiConfiguration, int paramInt, boolean paramBoolean)
  {
    bD();
  }
  
  private void a(List<br> paramList1, List<br> paramList2, List<bn> paramList)
  {
    boolean bool2 = false;
    boolean bool1 = false;
    int i;
    if ((paramList != null) && (paramList.size() > 0)) {
      i = 1;
    } else {
      i = 0;
    }
    int j;
    if ((this.jO >= 0L) && (System.currentTimeMillis() - this.jO >= 10000L)) {
      j = 0;
    } else {
      j = 1;
    }
    Object localObject4 = this.hx;
    Iterator localIterator1 = null;
    Object localObject3 = null;
    if (paramList1 != null) {}
    for (;;)
    {
      try
      {
        if (paramList1.size() <= 0) {
          break label511;
        }
        Object localObject5 = ca.getConfiguredNetworks();
        Iterator localIterator2 = paramList1.iterator();
        Object localObject1 = null;
        localObject2 = localObject1;
        if (localIterator2.hasNext())
        {
          localObject2 = (br)localIterator2.next();
          bn localbn = new bn();
          dc localdc = r(localbn);
          localdc.c((br)localObject2);
          localdc.a(bw.a(localbn.Z(), localbn.ab(), (List)localObject5), true);
          if (j == 0) {
            localdc.bH();
          }
          this.jK.put(localbn.Y(), localbn);
          localObject2 = localObject1;
          if (localObject1 == null) {
            localObject2 = new ArrayList();
          }
          ((List)localObject2).add(localbn);
          bool1 = true;
          localObject1 = localObject2;
          continue;
        }
        j = bool1;
        localObject1 = localIterator1;
        if (paramList2 != null)
        {
          j = bool1;
          localObject1 = localIterator1;
          if (paramList2.size() > 0)
          {
            localIterator1 = paramList2.iterator();
            paramList2 = (List<br>)localObject3;
            j = bool1;
            localObject1 = paramList2;
            if (localIterator1.hasNext())
            {
              localObject3 = (br)localIterator1.next();
              localObject5 = (bn)this.jK.get(cb.d(((br)localObject3).ey, ((br)localObject3).ez));
              if (localObject5 == null) {
                continue;
              }
              localObject1 = paramList2;
              if (paramList2 == null) {
                localObject1 = new ArrayList();
              }
              ((List)localObject1).add(localObject5);
              bool1 |= b((br)localObject3);
              paramList2 = (List<br>)localObject1;
              continue;
            }
          }
        }
        if ((j != 0) || (i != 0))
        {
          paramList2 = bF().iterator();
          if (paramList2.hasNext())
          {
            localObject3 = (bp)paramList2.next();
            if ((paramList1 != null) && (paramList1.size() > 0)) {
              ((bp)localObject3).b((List)localObject2);
            }
            if ((localObject1 != null) && (((List)localObject1).size() > 0)) {
              ((bp)localObject3).c((List)localObject1);
            }
            if ((paramList == null) || (paramList.size() <= 0)) {
              continue;
            }
            ((bp)localObject3).d(paramList);
          }
        }
        return;
      }
      finally
      {
        continue;
      }
      continue;
      throw paramList1;
      continue;
      label511:
      Object localObject2 = null;
      bool1 = bool2;
    }
  }
  
  private void a(boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3)
  {
    int i3 = cm.R(11);
    int m = 4;
    int i1 = 0;
    int i2 = 1;
    int i;
    if (i3 == 1) {
      i = 4;
    } else {
      i = 0;
    }
    int i4 = cm.R(13);
    int j;
    if (i4 == 1) {
      j = 2;
    } else {
      j = 0;
    }
    int i5 = cm.R(14);
    int k;
    if (i5 == 1) {
      k = 1;
    } else {
      k = 0;
    }
    if (!paramBoolean1) {
      m = 0;
    }
    if (paramBoolean2) {
      i1 = 2;
    }
    int n = m | i1 | paramBoolean3;
    if (((i | j | k) != n) || (i3 == 3) || (i4 == 3) || (i5 == 3))
    {
      by.d(501097, n);
      if (paramBoolean1) {
        i = 1;
      } else {
        i = 2;
      }
      cm.q(11, i);
      if (paramBoolean2) {
        i = 1;
      } else {
        i = 2;
      }
      cm.q(13, i);
      if (paramBoolean3) {
        i = i2;
      } else {
        i = 2;
      }
      cm.q(14, i);
    }
  }
  
  private void b(List<bn> paramList1, List<bn> paramList2)
  {
    Iterator localIterator = bF().iterator();
    while (localIterator.hasNext())
    {
      bp localbp = (bp)localIterator.next();
      if ((paramList1 != null) || (paramList2 != null)) {
        localbp.a(paramList1, paramList2);
      }
    }
  }
  
  private boolean b(br parambr)
  {
    for (;;)
    {
      synchronized (this.hx)
      {
        int i = parambr.Y();
        if (this.jK.get(i) != null)
        {
          bool = true;
          if (bool) {
            this.jK.remove(i);
          }
          return bool;
        }
      }
      boolean bool = false;
    }
  }
  
  private void bA()
  {
    IntentFilter localIntentFilter;
    if (!this.jM)
    {
      localIntentFilter = new IntentFilter();
      localIntentFilter.addAction("android.net.wifi.SCAN_RESULTS");
      localIntentFilter.addAction("android.net.wifi.CONFIGURED_NETWORKS_CHANGE");
      localIntentFilter.setPriority(2147483647);
      this.jO = System.currentTimeMillis();
      this.jM = true;
    }
    try
    {
      bz.av().t().registerReceiver(this.jP, localIntentFilter);
      return;
    }
    catch (Throwable localThrowable)
    {
      label61:
      break label61;
    }
    this.jM = false;
  }
  
  private void bB()
  {
    this.jN = false;
    this.mHandler.removeMessages(1);
    this.jM = false;
    try
    {
      bz.av().t().unregisterReceiver(this.jP);
      return;
    }
    catch (Throwable localThrowable) {}
  }
  
  private void bC()
  {
    List localList = ca.getScanResults();
    int j = 0;
    boolean bool;
    if ((localList != null) && (!localList.isEmpty())) {
      bool = true;
    } else {
      bool = false;
    }
    a(bool, dj.g(bz.av().t()), dj.e(bz.av().t()));
    SparseArray localSparseArray = new SparseArray();
    int i;
    synchronized (this.hx)
    {
      int k = this.jJ.size();
      i = 0;
      int m;
      Object localObject3;
      if (i < k)
      {
        m = this.jJ.keyAt(i);
        localObject3 = (br)this.jJ.get(m);
        if (localObject3 != null)
        {
          ((br)localObject3).ai();
          ((br)localObject3).ah();
          localSparseArray.put(m, localObject3);
        }
      }
      else
      {
        Object localObject9 = null;
        Object localObject10;
        if (localList != null)
        {
          localObject10 = localList.iterator();
          ??? = null;
          localObject3 = ???;
          for (;;)
          {
            localObject8 = ???;
            localObject7 = localObject3;
            if (!((Iterator)localObject10).hasNext()) {
              break;
            }
            localObject7 = (ScanResult)((Iterator)localObject10).next();
            if ((localObject7 != null) && (!TextUtils.isEmpty(((ScanResult)localObject7).SSID)) && (!TextUtils.isEmpty(((ScanResult)localObject7).capabilities)) && (!((ScanResult)localObject7).capabilities.contains("[IBSS]")))
            {
              localObject8 = new br((ScanResult)localObject7);
              if (!TextUtils.isEmpty(((br)localObject8).ey))
              {
                Object localObject11 = (br)localSparseArray.get(((br)localObject8).Y());
                if (localObject11 != null)
                {
                  ((br)localObject11).a(((ScanResult)localObject7).BSSID, ((ScanResult)localObject7).level, ((ScanResult)localObject7).frequency);
                  localObject7 = ???;
                }
                else
                {
                  localSparseArray.put(((br)localObject8).Y(), localObject8);
                  localObject7 = ???;
                  if (??? == null) {
                    localObject7 = new ArrayList();
                  }
                  ((List)localObject7).add(localObject8);
                }
                synchronized (this.hx)
                {
                  localObject11 = (bn)this.jK.get(((br)localObject8).Y());
                  ??? = localObject7;
                  if (localObject11 != null)
                  {
                    ??? = localObject7;
                    if (r((bn)localObject11).bG())
                    {
                      localObject8 = localObject3;
                      if (localObject3 == null) {
                        localObject8 = new ArrayList();
                      }
                      ((List)localObject8).add(localObject11);
                      ??? = localObject7;
                      localObject3 = localObject8;
                    }
                  }
                }
              }
            }
          }
        }
        Object localObject8 = null;
        Object localObject7 = localObject8;
        k = localSparseArray.size();
        ??? = localObject9;
        if (k > 0)
        {
          localObject9 = new ArrayList();
          ??? = null;
          i = 0;
          while (i < k)
          {
            m = localSparseArray.keyAt(i);
            localObject10 = (br)localSparseArray.get(m);
            ??? = ???;
            if (localObject10 != null)
            {
              ??? = ???;
              if (((br)localObject10).ag())
              {
                ??? = ???;
                if (??? == null) {
                  ??? = new ArrayList();
                }
                ((List)???).add(localObject10);
                ((ArrayList)localObject9).add(Integer.valueOf(m));
              }
            }
            i += 1;
            ??? = ???;
          }
          ??? = ((ArrayList)localObject9).iterator();
          while (((Iterator)???).hasNext()) {
            localSparseArray.remove(((Integer)((Iterator)???).next()).intValue());
          }
        }
        synchronized (this.hx)
        {
          this.jJ.clear();
          k = localSparseArray.size();
          i = j;
          if (i < k)
          {
            j = localSparseArray.keyAt(i);
            localObject9 = (br)localSparseArray.get(j);
            if (localObject9 != null) {
              this.jJ.put(j, localObject9);
            }
          }
          else
          {
            a((List)localObject8, ???, (List)localObject7);
            o(localList);
            return;
          }
        }
      }
    }
  }
  
  private void bD()
  {
    Object localObject1 = ca.getConfiguredNetworks();
    SparseIntArray localSparseIntArray = new SparseIntArray();
    Object localObject4 = null;
    int i = 0;
    if (localObject1 != null) {}
    for (;;)
    {
      Object localObject5;
      int k;
      synchronized (this.hx)
      {
        a(new db.6(this, localSparseIntArray));
        localObject5 = ((List)localObject1).iterator();
        localObject4 = null;
        i = 0;
        if (!((Iterator)localObject5).hasNext()) {
          break label354;
        }
        localObject1 = (WifiConfiguration)((Iterator)localObject5).next();
        if (localObject1 == null) {
          continue;
        }
        bn localbn = a(cb.j(((WifiConfiguration)localObject1).SSID), cb.d((WifiConfiguration)localObject1));
        if (localbn == null) {
          continue;
        }
        dc localdc = r(localbn);
        localdc.a((WifiConfiguration)localObject1, false);
        j = localSparseIntArray.get(localbn.Y(), 3);
        if (j == 3)
        {
          localdc.h(true);
          i |= 0x1;
          localObject1 = localObject4;
          if (localObject4 == null) {
            localObject1 = new ArrayList();
          }
          ((List)localObject1).add(localbn);
          localObject4 = localObject1;
          continue;
        }
        if (j != 1) {
          continue;
        }
        localSparseIntArray.put(localbn.Y(), 2);
        continue;
        if (j < localSparseIntArray.size())
        {
          int m = localSparseIntArray.keyAt(j);
          k = i;
          localObject5 = localObject1;
          if (localSparseIntArray.valueAt(j) != 1) {
            break label362;
          }
          localbn = (bn)this.jK.get(m);
          k = i;
          localObject5 = localObject1;
          if (localbn == null) {
            break label362;
          }
          localObject5 = r(localbn);
          ((dc)localObject5).a(null, false);
          ((dc)localObject5).h(false);
          k = i | 0x1;
          localObject5 = localObject1;
          if (localObject1 == null) {
            localObject5 = new ArrayList();
          }
          ((List)localObject5).add(localbn);
          break label362;
        }
      }
      Object localObject3 = null;
      if (i != 0) {
        b(localObject4, (List)localObject3);
      }
      return;
      label354:
      localObject3 = null;
      int j = 0;
      continue;
      label362:
      j += 1;
      i = k;
      localObject3 = localObject5;
    }
  }
  
  private void bE()
  {
    ArrayList localArrayList = new ArrayList();
    a(new db.7(this, localArrayList));
    synchronized (this.hx)
    {
      this.jK.clear();
      n(new ArrayList(localArrayList));
      return;
    }
  }
  
  private List<bp> bF()
  {
    ArrayList localArrayList2 = new ArrayList();
    synchronized (this.jL)
    {
      Iterator localIterator = this.jL.iterator();
      while (localIterator.hasNext()) {
        localArrayList2.add((bp)localIterator.next());
      }
      return localArrayList2;
    }
    for (;;)
    {
      throw localObject;
    }
  }
  
  public static db bz()
  {
    return db.a.jU;
  }
  
  private void n(List<bn> paramList)
  {
    Iterator localIterator = bF().iterator();
    while (localIterator.hasNext())
    {
      bp localbp = (bp)localIterator.next();
      if ((paramList != null) && (paramList.size() > 0)) {
        localbp.c(paramList);
      }
    }
  }
  
  private void o(List<ScanResult> paramList)
  {
    Iterator localIterator = bF().iterator();
    while (localIterator.hasNext()) {
      ((bp)localIterator.next()).e(paramList);
    }
  }
  
  private bn q(String paramString)
  {
    Object localObject = this.hx;
    int i = 0;
    for (;;)
    {
      try
      {
        if (i < this.jK.size())
        {
          int j = this.jK.keyAt(i);
          bn localbn = (bn)this.jK.get(j);
          if ((localbn != null) && (cb.c(localbn.Z(), paramString))) {
            return localbn;
          }
        }
        else
        {
          return null;
        }
      }
      finally
      {
        continue;
        throw paramString;
        continue;
        i += 1;
      }
    }
  }
  
  private static dc r(bn parambn)
  {
    dc localdc2 = (dc)parambn.b(dc.class);
    dc localdc1 = localdc2;
    if (localdc2 == null)
    {
      localdc1 = new dc(parambn);
      parambn.a(dc.class, localdc1);
    }
    return localdc1;
  }
  
  public bn a(WifiInfo paramWifiInfo)
  {
    if (paramWifiInfo == null) {
      return null;
    }
    String str = cl.b(paramWifiInfo);
    if (cb.k(paramWifiInfo.getBSSID())) {
      return d(str, paramWifiInfo.getBSSID());
    }
    return q(str);
  }
  
  public bn a(String paramString, int paramInt)
  {
    synchronized (this.hx)
    {
      if (!cb.l(paramString)) {
        return null;
      }
      if (paramInt == -1)
      {
        paramString = q(paramString);
        return paramString;
      }
      paramString = (bn)this.jK.get(cb.d(paramString, paramInt));
      return paramString;
    }
  }
  
  public void a()
  {
    bC();
    bA();
    int i = cm.R(12);
    int j = 1;
    boolean bool1;
    if (i == 1) {
      bool1 = true;
    } else {
      bool1 = false;
    }
    boolean bool2 = ((b)ao.c().i(3)).m();
    if ((bool1 != bool2) || (i == 3))
    {
      if (bool2) {
        i = 1;
      } else {
        i = -1;
      }
      by.d(501096, i);
      if (bool2) {
        i = j;
      } else {
        i = 2;
      }
      cm.q(12, i);
    }
  }
  
  public void a(bo parambo)
  {
    Object localObject;
    int i;
    if (parambo != null)
    {
      localObject = this.hx;
      i = 0;
    }
    for (;;)
    {
      try
      {
        if (i < this.jK.size())
        {
          int j = this.jK.keyAt(i);
          if (parambo.g((bn)this.jK.get(j))) {
            break label69;
          }
        }
        return;
      }
      finally {}
      return;
      label69:
      i += 1;
    }
  }
  
  public void a(bp parambp)
  {
    if (parambp != null) {
      synchronized (this.jL)
      {
        this.jL.add(parambp);
        return;
      }
    }
  }
  
  public void b()
  {
    bB();
    bz.av().ax().post(new db.4(this));
  }
  
  public void b(bp parambp)
  {
    synchronized (this.jL)
    {
      Iterator localIterator = this.jL.iterator();
      while (localIterator.hasNext())
      {
        bp localbp = (bp)localIterator.next();
        if ((localbp == null) || (localbp == parambp)) {
          localIterator.remove();
        }
      }
      this.jL.size();
      return;
    }
    for (;;)
    {
      throw parambp;
    }
  }
  
  public List<bn> c(boolean paramBoolean)
  {
    if (paramBoolean) {
      bC();
    }
    ArrayList localArrayList = new ArrayList();
    a(new db.5(this, localArrayList));
    return localArrayList;
  }
  
  public bn d(String paramString1, String paramString2)
  {
    int i;
    label163:
    synchronized (this.hx)
    {
      if (!cb.l(paramString1)) {
        return null;
      }
      boolean bool = cb.k(paramString2) ^ true;
      if (bool)
      {
        paramString1 = q(paramString1);
        return paramString1;
        if (i < this.jK.size())
        {
          int j = this.jK.keyAt(i);
          bn localbn = (bn)this.jK.get(j);
          br localbr = r(localbn).al();
          if ((!cb.c(paramString1, localbn.Z())) || (localbr == null) || (!localbr.b(cb.m(paramString2)))) {
            break label163;
          }
          return localbn;
        }
        if (!bool)
        {
          paramString1 = q(paramString1);
          return paramString1;
        }
        return null;
      }
    }
  }
  
  public bs h(bn parambn)
  {
    return (bs)r(parambn).getData();
  }
  
  public void onCreate()
  {
    ca.isWifiEnabled();
    ((b)ao.c().i(3)).a(new db.3(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     wf7.db
 * JD-Core Version:    0.7.0.1
 */