package wf7;

import android.text.TextUtils;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class cv
{
  private final Object hx = new Object();
  private ArrayList<ct> it = null;
  private ArrayList<ct> iu = null;
  public long iv = 60L;
  public long iw = 60L;
  private final ArrayList<bg> ix = new ArrayList();
  
  public static final cv bj()
  {
    return cv.a.iA;
  }
  
  private void c(ArrayList<ct> paramArrayList)
  {
    synchronized (this.hx)
    {
      if ((this.it == null) || (this.it.size() <= 0)) {
        break label106;
      }
      Iterator localIterator = this.it.iterator();
      while (localIterator.hasNext()) {
        if (((ct)localIterator.next()).c(this.iw * 60L * 1000L)) {
          localIterator.remove();
        }
      }
    }
    ((bq)ao.c().i(1)).a(new cv.1(this, paramArrayList));
    label106:
  }
  
  private void f(List<ct> paramList)
  {
    for (;;)
    {
      bg localbg;
      ArrayList localArrayList2;
      synchronized (this.ix)
      {
        if (this.ix.size() <= 0) {
          break;
        }
        Iterator localIterator1 = this.ix.iterator();
        if (!localIterator1.hasNext()) {
          break;
        }
        localbg = (bg)localIterator1.next();
        localArrayList2 = new ArrayList();
        Iterator localIterator2 = paramList.iterator();
        if (localIterator2.hasNext()) {
          localArrayList2.add(((ct)localIterator2.next()).af());
        }
      }
      localbg.a(localArrayList2);
    }
  }
  
  protected void a(ct paramct)
  {
    if (paramct != null) {
      synchronized (this.hx)
      {
        this.iu.remove(paramct);
        return;
      }
    }
  }
  
  public boolean b(ArrayList<ct> paramArrayList)
  {
    if ((paramArrayList != null) && (paramArrayList.size() > 0))
    {
      Iterator localIterator = paramArrayList.iterator();
      while (localIterator.hasNext())
      {
        ct localct = (ct)localIterator.next();
        bn localbn = ((bq)ao.c().i(1)).a(localct.af().Z(), localct.af().ab());
        if (localbn != null)
        {
          localct.f(localbn);
          cw.a(localbn, localct);
        }
      }
      c(paramArrayList);
      f(paramArrayList);
      return true;
    }
    return false;
  }
  
  protected boolean bk()
  {
    synchronized (this.hx)
    {
      ((bq)ao.c().i(1)).a(new cv.2(this));
      return false;
    }
  }
  
  protected boolean bl()
  {
    boolean bool = false;
    for (;;)
    {
      synchronized (this.hx)
      {
        Iterator localIterator = this.iu.iterator();
        if (localIterator.hasNext())
        {
          if (((ct)localIterator.next()).c(300000L))
          {
            localIterator.remove();
            bool = true;
          }
        }
        else {
          return bool;
        }
      }
    }
  }
  
  protected void bm()
  {
    synchronized (this.hx)
    {
      this.iu.clear();
      return;
    }
  }
  
  protected void bn()
  {
    synchronized (this.hx)
    {
      if (this.it != null) {
        this.it.clear();
      }
      return;
    }
  }
  
  public ct e(String paramString, int paramInt)
  {
    if (!TextUtils.isEmpty(paramString)) {
      for (;;)
      {
        synchronized (this.hx)
        {
          if (!this.iu.isEmpty())
          {
            Iterator localIterator = this.iu.iterator();
            if (localIterator.hasNext())
            {
              ct localct = (ct)localIterator.next();
              if ((localct == null) || (!cb.a(paramString, localct.af().Z(), paramInt, localct.af().ab()))) {
                continue;
              }
              paramString = localct;
              return paramString;
            }
          }
        }
        paramString = null;
      }
    }
    return null;
  }
  
  protected void g(List<bn> arg1)
  {
    if ((??? != null) && (???.size() > 0))
    {
      Iterator localIterator1 = ???.iterator();
      while (localIterator1.hasNext())
      {
        bn localbn = (bn)localIterator1.next();
        if (localbn != null)
        {
          ct localct1 = cw.p(localbn);
          synchronized (this.hx)
          {
            if (this.it != null)
            {
              localIterator2 = this.it.iterator();
              while (localIterator2.hasNext()) {
                if (((ct)localIterator2.next()).af().e(localbn)) {
                  localIterator2.remove();
                }
              }
            }
          }
          Iterator localIterator2 = this.iu.iterator();
          while (localIterator2.hasNext())
          {
            ct localct2 = (ct)localIterator2.next();
            if ((localct2 != null) && (localct2.af().e(localbn))) {
              localIterator2.remove();
            }
          }
          localct1.ik = System.currentTimeMillis();
          this.iu.add(localct1);
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     wf7.cv
 * JD-Core Version:    0.7.0.1
 */