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
    Object localObject2 = new ArrayList();
    synchronized (this.hN)
    {
      ((List)localObject2).addAll(this.hN);
      ??? = ((List)localObject2).iterator();
      boolean bool1;
      int i;
      for (;;)
      {
        bool1 = ((Iterator)???).hasNext();
        i = 2;
        if (!bool1) {
          break;
        }
        localObject2 = (d)((Iterator)???).next();
        if (paramInt != 0)
        {
          if (paramInt != 1)
          {
            if (paramInt != 2)
            {
              if (paramInt == 3) {
                ((d)localObject2).q();
              }
            }
            else {
              ((d)localObject2).p();
            }
          }
          else {
            ((d)localObject2).s();
          }
        }
        else {
          ((d)localObject2).r();
        }
      }
      paramInt = cm.R(12);
      if (paramInt == 1) {
        bool1 = true;
      } else {
        bool1 = false;
      }
      boolean bool2 = m();
      if ((bool1 != bool2) || (paramInt == 12))
      {
        if (bool2) {
          paramInt = 1;
        } else {
          paramInt = -1;
        }
        by.d(501096, paramInt);
        paramInt = i;
        if (bool2) {
          paramInt = 1;
        }
        cm.q(12, paramInt);
      }
      return;
    }
    for (;;)
    {
      throw localObject3;
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
      while (((Iterator)???).hasNext()) {
        ((a)((Iterator)???).next()).a(paramCurrentSessionItem);
      }
      return;
    }
    for (;;)
    {
      throw paramCurrentSessionItem;
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
    cr localcr = this.hL;
    if (localcr != null) {
      localcr.aW();
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
    cr localcr = this.hL;
    if (localcr != null) {
      return localcr.n();
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     wf7.cq
 * JD-Core Version:    0.7.0.1
 */