package wf7;

import com.tencent.qqpimsecure.wificore.api.event.CurrentSessionItem;
import com.tencent.qqpimsecure.wificore.api.event.a;
import com.tencent.qqpimsecure.wificore.api.event.b;
import com.tencent.qqpimsecure.wificore.api.event.d;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class cq
  implements b
{
  private long hI = 0L;
  private final List<a> hJ = new ArrayList();
  private final a hK = new cq.1(this);
  private cr hL = new cr();
  private final cs hM = new cs();
  private List<d> hN = new ArrayList();
  private as.a hO = new cq.2(this);
  private final Object hx = new Object();
  
  private cq()
  {
    this.hM.a(this.hL);
  }
  
  private void T(int paramInt)
  {
    int i = 1;
    Object localObject2 = new ArrayList();
    for (;;)
    {
      synchronized (this.hN)
      {
        ((List)localObject2).addAll(this.hN);
        ??? = ((List)localObject2).iterator();
        if (!((Iterator)???).hasNext()) {
          break;
        }
        localObject2 = (d)((Iterator)???).next();
        switch (paramInt)
        {
        default: 
          break;
        case 0: 
          ((d)localObject2).r();
        }
      }
      localObject3.p();
      continue;
      localObject3.q();
      continue;
      localObject3.s();
    }
    paramInt = cm.R(12);
    boolean bool1;
    if (paramInt == 1)
    {
      bool1 = true;
      boolean bool2 = m();
      if ((bool1 != bool2) || (paramInt == 12))
      {
        if (!bool2) {
          break label210;
        }
        paramInt = 1;
        label185:
        by.d(501096, paramInt);
        if (!bool2) {
          break label215;
        }
      }
    }
    label210:
    label215:
    for (paramInt = i;; paramInt = 2)
    {
      cm.q(12, paramInt);
      return;
      bool1 = false;
      break;
      paramInt = -1;
      break label185;
    }
  }
  
  public static final cq aV()
  {
    return cq.a.hS;
  }
  
  private long aX()
  {
    synchronized (this.hx)
    {
      long l = this.hI;
      this.hI += 1L;
      return l;
    }
  }
  
  private void b(CurrentSessionItem paramCurrentSessionItem)
  {
    ArrayList localArrayList = new ArrayList();
    synchronized (this.hJ)
    {
      localArrayList.addAll(this.hJ);
      ??? = localArrayList.iterator();
      if (((Iterator)???).hasNext()) {
        ((a)((Iterator)???).next()).a(paramCurrentSessionItem);
      }
    }
  }
  
  public void a()
  {
    aW();
    this.hM.aZ();
    bz.av().A().x().a(1034, this.hO);
  }
  
  public void a(a parama)
  {
    synchronized (this.hJ)
    {
      this.hJ.add(parama);
      return;
    }
  }
  
  public void a(d paramd)
  {
    synchronized (this.hN)
    {
      this.hN.add(paramd);
      return;
    }
  }
  
  public void aW()
  {
    if (this.hL != null) {
      this.hL.aW();
    }
  }
  
  public void b()
  {
    this.hM.ba();
    bz.av().A().x().a(this.hO);
  }
  
  public void b(a parama)
  {
    synchronized (this.hJ)
    {
      this.hJ.remove(parama);
      return;
    }
  }
  
  public void b(d paramd)
  {
    synchronized (this.hN)
    {
      this.hN.remove(paramd);
      return;
    }
  }
  
  public boolean m()
  {
    return ca.isWifiEnabled();
  }
  
  public CurrentSessionItem n()
  {
    if (this.hL != null) {
      return this.hL.n();
    }
    return null;
  }
  
  public bn o()
  {
    CurrentSessionItem localCurrentSessionItem = n();
    if ((localCurrentSessionItem != null) && (localCurrentSessionItem.isConnected())) {
      return ((bq)ao.c().i(1)).a(localCurrentSessionItem.ey, localCurrentSessionItem.eV);
    }
    return null;
  }
  
  public void onCreate()
  {
    this.hL.onCreate();
    this.hL.c(this.hK);
    this.hL.aW();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     wf7.cq
 * JD-Core Version:    0.7.0.1
 */