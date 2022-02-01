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
    int j;
    label49:
    Object localObject3;
    if ((paramList != null) && (paramList.size() > 0))
    {
      i = 1;
      if ((this.jO >= 0L) && (System.currentTimeMillis() - this.jO >= 10000L)) {
        break label473;
      }
      j = 1;
      localObject3 = this.hx;
      if (paramList1 == null) {
        break label479;
      }
    }
    for (;;)
    {
      try
      {
        if (paramList1.size() <= 0) {
          break label479;
        }
        Object localObject4 = ca.getConfiguredNetworks();
        Object localObject5 = paramList1.iterator();
        localObject1 = null;
        localObject2 = localObject1;
        bn localbn;
        if (((Iterator)localObject5).hasNext())
        {
          localObject2 = (br)((Iterator)localObject5).next();
          localbn = new bn();
          dc localdc = r(localbn);
          localdc.c((br)localObject2);
          localdc.a(bw.a(localbn.Z(), localbn.ab(), (List)localObject4), true);
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
        if ((paramList2 == null) || (paramList2.size() <= 0)) {
          break label492;
        }
        localObject4 = paramList2.iterator();
        paramList2 = null;
        localObject1 = paramList2;
        j = bool1;
        if (((Iterator)localObject4).hasNext())
        {
          localObject5 = (br)((Iterator)localObject4).next();
          localbn = (bn)this.jK.get(cb.d(((br)localObject5).ey, ((br)localObject5).ez));
          if (localbn != null)
          {
            localObject1 = paramList2;
            if (paramList2 == null) {
              localObject1 = new ArrayList();
            }
            ((List)localObject1).add(localbn);
            bool1 = b((br)localObject5) | bool1;
            paramList2 = (List<br>)localObject1;
            break label489;
          }
        }
        else
        {
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
              continue;
            }
          }
          return;
        }
      }
      finally {}
      break label489;
      i = 0;
      break;
      label473:
      j = 0;
      break label49;
      label479:
      Object localObject2 = null;
      bool1 = bool2;
      continue;
      label489:
      continue;
      label492:
      Object localObject1 = null;
      j = bool1;
    }
  }
  
  private void a(boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3)
  {
    int m = 4;
    int i1 = 0;
    int i2 = 1;
    int i3 = cm.R(11);
    int j;
    label41:
    int k;
    label57:
    label61:
    int n;
    if (i3 == 1)
    {
      i = 4;
      int i4 = cm.R(13);
      if (i4 != 1) {
        break label173;
      }
      j = 2;
      int i5 = cm.R(14);
      if (i5 != 1) {
        break label179;
      }
      k = 1;
      if (!paramBoolean1) {
        break label185;
      }
      if (!paramBoolean2) {
        break label191;
      }
      n = 2;
      label68:
      if (paramBoolean3) {
        i1 = 1;
      }
      m = n | m | i1;
      if (((i | j | k) != m) || (i3 == 3) || (i4 == 3) || (i5 == 3))
      {
        by.d(501097, m);
        if (!paramBoolean1) {
          break label197;
        }
        i = 1;
        label130:
        cm.q(11, i);
        if (!paramBoolean2) {
          break label203;
        }
        i = 1;
        label144:
        cm.q(13, i);
        if (!paramBoolean3) {
          break label209;
        }
      }
    }
    label173:
    label179:
    label185:
    label191:
    label197:
    label203:
    label209:
    for (int i = i2;; i = 2)
    {
      cm.q(14, i);
      return;
      i = 0;
      break;
      j = 0;
      break label41;
      k = 0;
      break label57;
      m = 0;
      break label61;
      n = 0;
      break label68;
      i = 2;
      break label130;
      i = 2;
      break label144;
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
      this.jM = false;
    }
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
    int j = 0;
    List localList = ca.getScanResults();
    boolean bool;
    SparseArray localSparseArray;
    int k;
    int i;
    label77:
    Object localObject10;
    Object localObject9;
    Object localObject8;
    label365:
    Object localObject6;
    if ((localList != null) && (!localList.isEmpty()))
    {
      bool = true;
      a(bool, dj.g(bz.av().t()), dj.e(bz.av().t()));
      localSparseArray = new SparseArray();
      int m;
      br localbr;
      for (;;)
      {
        synchronized (this.hx)
        {
          k = this.jJ.size();
          i = 0;
          if (i < k)
          {
            m = this.jJ.keyAt(i);
            ??? = (br)this.jJ.get(m);
            if (??? == null) {
              break label708;
            }
            ((br)???).ai();
            ((br)???).ah();
            localSparseArray.put(m, ???);
            break label708;
          }
          if (localList == null) {
            break;
          }
          localObject10 = localList.iterator();
          ??? = null;
          ??? = null;
          localObject9 = ???;
          localObject8 = ???;
          if (!((Iterator)localObject10).hasNext()) {
            break label447;
          }
          localObject8 = (ScanResult)((Iterator)localObject10).next();
          if ((localObject8 == null) || (TextUtils.isEmpty(((ScanResult)localObject8).SSID)) || (TextUtils.isEmpty(((ScanResult)localObject8).capabilities)) || (((ScanResult)localObject8).capabilities.contains("[IBSS]"))) {
            continue;
          }
          localObject9 = new br((ScanResult)localObject8);
          if ((localObject9 == null) || (TextUtils.isEmpty(((br)localObject9).ey))) {
            continue;
          }
          localbr = (br)localSparseArray.get(((br)localObject9).Y());
          if (localbr != null)
          {
            localbr.a(((ScanResult)localObject8).BSSID, ((ScanResult)localObject8).level, ((ScanResult)localObject8).frequency);
            localObject8 = ???;
          }
        }
        synchronized (this.hx)
        {
          localObject9 = (bn)this.jK.get(((br)localObject9).Y());
          ??? = localObject8;
          if (localObject9 != null)
          {
            ??? = localObject8;
            if (r((bn)localObject9).bG())
            {
              if (??? != null) {
                break label705;
              }
              ??? = new ArrayList();
              ((List)???).add(localObject9);
              ??? = localObject8;
              continue;
              localObject5 = finally;
              throw localObject5;
              localSparseArray.put(((br)localObject9).Y(), localObject9);
              localObject8 = localObject5;
              if (localObject5 == null) {
                localObject8 = new ArrayList();
              }
              ((List)localObject8).add(localObject9);
            }
          }
        }
      }
      localObject9 = null;
      localObject8 = null;
      label447:
      k = localSparseArray.size();
      if (k > 0)
      {
        localObject10 = new ArrayList();
        ??? = null;
        i = 0;
        while (i < k)
        {
          m = localSparseArray.keyAt(i);
          localbr = (br)localSparseArray.get(m);
          localObject6 = ???;
          if (localbr != null)
          {
            localObject6 = ???;
            if (localbr.ag())
            {
              localObject6 = ???;
              if (??? == null) {
                localObject6 = new ArrayList();
              }
              ((List)localObject6).add(localbr);
              ((ArrayList)localObject10).add(Integer.valueOf(m));
            }
          }
          i += 1;
          ??? = localObject6;
        }
        localObject10 = ((ArrayList)localObject10).iterator();
        for (;;)
        {
          localObject6 = ???;
          if (!((Iterator)localObject10).hasNext()) {
            break;
          }
          localSparseArray.remove(((Integer)((Iterator)localObject10).next()).intValue());
        }
      }
      localObject6 = null;
    }
    for (;;)
    {
      synchronized (this.hx)
      {
        this.jJ.clear();
        k = localSparseArray.size();
        i = j;
        if (i < k)
        {
          j = localSparseArray.keyAt(i);
          localObject10 = (br)localSparseArray.get(j);
          if (localObject10 == null) {
            break label721;
          }
          this.jJ.put(j, localObject10);
          break label721;
        }
        a((List)localObject8, (List)localObject6, (List)localObject9);
        o(localList);
        return;
      }
      label705:
      break label365;
      label708:
      i += 1;
      break label77;
      bool = false;
      break;
      label721:
      i += 1;
    }
  }
  
  private void bD()
  {
    int k = 0;
    Object localObject1 = ca.getConfiguredNetworks();
    SparseIntArray localSparseIntArray = new SparseIntArray();
    if (localObject1 != null) {}
    for (;;)
    {
      Object localObject5;
      int j;
      synchronized (this.hx)
      {
        a(new db.6(this, localSparseIntArray));
        localObject4 = ((List)localObject1).iterator();
        localObject1 = null;
        i = 0;
        if (!((Iterator)localObject4).hasNext()) {
          break label354;
        }
        Object localObject7 = (WifiConfiguration)((Iterator)localObject4).next();
        if (localObject7 == null) {
          continue;
        }
        localObject5 = a(cb.j(((WifiConfiguration)localObject7).SSID), cb.d((WifiConfiguration)localObject7));
        if (localObject5 == null) {
          break label351;
        }
        dc localdc = r((bn)localObject5);
        localdc.a((WifiConfiguration)localObject7, false);
        j = localSparseIntArray.get(((bn)localObject5).Y(), 3);
        if (j == 3)
        {
          localdc.h(true);
          if (localObject1 == null)
          {
            localObject1 = new ArrayList();
            ((List)localObject1).add(localObject5);
            i |= 0x1;
            break label348;
          }
        }
        else
        {
          if (j != 1) {
            break label351;
          }
          localSparseIntArray.put(((bn)localObject5).Y(), 2);
          break label351;
          if (k < localSparseIntArray.size())
          {
            int m = localSparseIntArray.keyAt(k);
            localObject5 = localObject4;
            j = i;
            if (localSparseIntArray.valueAt(k) != 1) {
              break label360;
            }
            localObject7 = (bn)this.jK.get(m);
            localObject5 = localObject4;
            j = i;
            if (localObject7 == null) {
              break label360;
            }
            localObject5 = r((bn)localObject7);
            ((dc)localObject5).a(null, false);
            ((dc)localObject5).h(false);
            j = i | 0x1;
            localObject5 = localObject4;
            if (localObject4 == null) {
              localObject5 = new ArrayList();
            }
            ((List)localObject5).add(localObject7);
            break label360;
          }
          if (i != 0) {
            b((List)localObject1, (List)localObject4);
          }
          return;
        }
      }
      continue;
      Object localObject4 = null;
      Object localObject3 = null;
      int i = 0;
      continue;
      label348:
      label351:
      for (;;)
      {
        break;
      }
      label354:
      localObject4 = null;
      continue;
      label360:
      k += 1;
      i = j;
      localObject4 = localObject5;
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
      if (localIterator.hasNext()) {
        localArrayList2.add((bp)localIterator.next());
      }
    }
    return localList;
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
      finally {}
      i += 1;
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
    }
    paramString = (bn)this.jK.get(cb.d(paramString, paramInt));
    return paramString;
  }
  
  public void a()
  {
    int j = 1;
    bC();
    bA();
    int i = cm.R(12);
    boolean bool1;
    if (i == 1)
    {
      bool1 = true;
      boolean bool2 = ((b)ao.c().i(3)).m();
      if ((bool1 != bool2) || (i == 3))
      {
        if (!bool2) {
          break label84;
        }
        i = 1;
        label58:
        by.d(501096, i);
        if (!bool2) {
          break label89;
        }
      }
    }
    label84:
    label89:
    for (i = j;; i = 2)
    {
      cm.q(12, i);
      return;
      bool1 = false;
      break;
      i = -1;
      break label58;
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
            break label66;
          }
        }
        return;
      }
      finally {}
      return;
      label66:
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
      if (this.jL.size() <= 0) {}
      return;
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
    for (;;)
    {
      synchronized (this.hx)
      {
        if (!cb.l(paramString1)) {
          return null;
        }
        if (!cb.k(paramString2))
        {
          i = 1;
          if (i == 0) {
            break;
          }
          paramString1 = q(paramString1);
          return paramString1;
        }
      }
      i = 0;
    }
    int j = 0;
    for (;;)
    {
      if (j < this.jK.size())
      {
        int k = this.jK.keyAt(j);
        bn localbn = (bn)this.jK.get(k);
        br localbr = r(localbn).al();
        if ((cb.c(paramString1, localbn.Z())) && (localbr != null) && (localbr.b(cb.m(paramString2)))) {
          return localbn;
        }
      }
      else
      {
        if (i == 0)
        {
          paramString1 = q(paramString1);
          return paramString1;
        }
        return null;
      }
      j += 1;
    }
  }
  
  public bs h(bn parambn)
  {
    return (bs)r(parambn).getData();
  }
  
  public void onCreate()
  {
    if (ca.isWifiEnabled()) {}
    ((b)ao.c().i(3)).a(new db.3(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     wf7.db
 * JD-Core Version:    0.7.0.1
 */