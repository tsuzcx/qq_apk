package wf7;

import android.os.Handler;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;

class em$2$2$1
  implements ej.a
{
  em$2$2$1(em.2.2 param2) {}
  
  public void a(int paramInt1, int paramInt2, int paramInt3)
  {
    paramInt3 = dm.ad(paramInt3);
    el.cP().a("SharkNetwork", paramInt2, paramInt1, (ae)null, 30, paramInt3);
    el.cP().aj(paramInt1);
    synchronized (em.h(this.nq.np.nm))
    {
      em.b(this.nq.np.nm, false);
      if (paramInt3 != 0) {
        break label443;
      }
      em.c(this.nq.np.nm, System.currentTimeMillis());
      em.a(this.nq.np.nm, false);
    }
    Object localObject6;
    synchronized (em.h(this.nq.np.nm))
    {
      if (em.m(this.nq.np.nm)) {
        em.c(this.nq.np.nm, false);
      }
      ??? = new ArrayList();
      synchronized (em.a(this.nq.np.nm))
      {
        if (em.a(this.nq.np.nm).size() <= 0) {
          break label314;
        }
        localObject6 = em.a(this.nq.np.nm).values().iterator();
        em.d locald;
        do
        {
          if (!((Iterator)localObject6).hasNext()) {
            break;
          }
          locald = (em.d)((Iterator)localObject6).next();
        } while ((locald.nu) || (locald.nv));
        ((List)???).add(locald);
      }
      localObject3 = finally;
      throw localObject3;
    }
    em.a(this.nq.np.nm).clear();
    label314:
    if (localCollection.size() > 0)
    {
      ??? = localCollection.iterator();
      while (((Iterator)???).hasNext())
      {
        localObject6 = (em.d)((Iterator)???).next();
        em.a(this.nq.np.nm, (em.d)localObject6);
      }
    }
    synchronized (em.o(this.nq.np.nm))
    {
      em.o(this.nq.np.nm).addAll(localCollection);
      em.d(this.nq.np.nm).sendEmptyMessage(1);
      return;
    }
    label443:
    if (paramInt3 > 0) {}
    for (paramInt1 = Math.abs(-900000000) + paramInt3;; paramInt1 = -900000000 + paramInt3)
    {
      em.a(this.nq.np.nm, false, true, paramInt1);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     wf7.em.2.2.1
 * JD-Core Version:    0.7.0.1
 */