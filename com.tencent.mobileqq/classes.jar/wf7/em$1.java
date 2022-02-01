package wf7;

import android.os.Handler;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;

class em$1
  implements ep.a
{
  em$1(em paramem) {}
  
  public void a(boolean paramBoolean, int paramInt, byte[] arg3, em.d paramd)
  {
    if (paramInt != 0)
    {
      em.a(this.nm, paramBoolean, paramInt, paramd);
      return;
    }
    if (??? == null)
    {
      em.a(this.nm, paramBoolean, -21000005, paramd);
      return;
    }
    if (ea.f(???))
    {
      byte b = ???[0];
      paramInt = el.cP().a(b);
      if (paramInt < 0) {
        break label522;
      }
      synchronized (em.a(this.nm))
      {
        paramd = (em.d)em.a(this.nm).get(Integer.valueOf(paramInt));
        if (paramd != null)
        {
          em.a(this.nm, paramBoolean, paramd, 0, 0, null);
          return;
        }
      }
    }
    try
    {
      ??? = em.j(???);
      if (??? == null)
      {
        em.a(this.nm, paramBoolean, -21000400, paramd);
        return;
      }
      af localaf = (af)???;
      ArrayList localArrayList1 = localaf.cr;
      int i = localaf.ca;
      if ((em.b(this.nm) != null) && (em.b(this.nm).nB == i)) {
        paramd = em.b(this.nm);
      }
      for (;;)
      {
        if ((em.c(this.nm) != null) && (em.c(this.nm).nB == i)) {
          paramd = em.c(this.nm);
        } else {
          synchronized (em.a(this.nm))
          {
            paramd = (em.d)em.a(this.nm).get(Integer.valueOf(i));
            continue;
            if (localArrayList1 == null)
            {
              em.a(this.nm, paramBoolean, paramd, -21000005, localaf.bZ, null);
              return;
            }
            em.g(localArrayList1);
            if (em.a(this.nm, localArrayList1))
            {
              em.a(this.nm, true);
              em.d(this.nm).removeMessages(1);
              em.d(this.nm).sendEmptyMessageDelayed(1, 2000L);
              return;
            }
            ArrayList localArrayList2 = em.a(this.nm, paramd, paramBoolean, localaf, localArrayList1);
            if ((localArrayList2 != null) && (localArrayList2.size() > 0))
            {
              Iterator localIterator = localArrayList2.iterator();
              while (localIterator.hasNext())
              {
                ae localae = (ae)localIterator.next();
                if (localae != null)
                {
                  el localel = el.cP();
                  i = localae.bH;
                  int j = localae.ca;
                  if (??? != null) {
                    ??? = String.format("%d/%d", new Object[] { Integer.valueOf(???.length + 4), Integer.valueOf(localArrayList1.size()) });
                  } else {
                    ??? = null;
                  }
                  localel.a("SharkNetwork", i, j, localae, 17, paramInt, (String)???);
                }
              }
            }
            em.a(this.nm, paramBoolean, paramd, 0, localaf.bZ, localArrayList2);
            em.e(this.nm);
            label522:
            return;
          }
        }
      }
    }
    catch (Exception ???)
    {
      label529:
      break label529;
    }
    em.a(this.nm, paramBoolean, -21000400, paramd);
  }
  
  public void b(boolean paramBoolean, int paramInt, em.d paramd)
  {
    if (paramInt != 0) {
      em.a(this.nm, paramBoolean, paramInt, paramd);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     wf7.em.1
 * JD-Core Version:    0.7.0.1
 */