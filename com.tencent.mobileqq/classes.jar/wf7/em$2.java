package wf7;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.concurrent.ExecutorService;

class em$2
  extends Handler
{
  em$2(em paramem, Looper paramLooper)
  {
    super(paramLooper);
  }
  
  private void b(boolean paramBoolean, em.d paramd)
  {
    em.f(this.nm).submit(new em.2.1(this, paramd, paramBoolean));
  }
  
  public void handleMessage(Message arg1)
  {
    switch (???.what)
    {
    case 5: 
    case 6: 
    case 7: 
    default: 
    case 0: 
      do
      {
        return;
        em.d(this.nm).removeMessages(0);
        if ((em.b(this.nm) != null) && (???.arg1 == 1))
        {
          b(false, em.b(this.nm));
          return;
        }
      } while ((em.c(this.nm) == null) || (???.arg1 != 2));
      b(true, em.c(this.nm));
      return;
    case 1: 
      em.d(this.nm).removeMessages(1);
      ??? = em.g(this.nm).cO();
      if ((TextUtils.isEmpty(???.lu)) || (TextUtils.isEmpty(???.lv)))
      {
        em.a(this.nm, 2);
        synchronized (em.h(this.nm))
        {
          if ((em.i(this.nm)) && (!ff.a(System.currentTimeMillis(), em.j(this.nm), 3))) {
            return;
          }
        }
        em.b(this.nm, true);
        em.a(this.nm, System.currentTimeMillis());
        em.d(this.nm).removeMessages(2);
        em.d(this.nm).sendEmptyMessage(2);
        return;
      }
      if (em.k(this.nm))
      {
        em.a(this.nm, 3);
        synchronized (em.h(this.nm))
        {
          if ((em.i(this.nm)) && (!ff.a(System.currentTimeMillis(), em.j(this.nm), 3))) {
            return;
          }
        }
        em.b(this.nm, true);
        em.a(this.nm, System.currentTimeMillis());
        em.d(this.nm).removeMessages(2);
        em.d(this.nm).sendEmptyMessageDelayed(2, 1000L);
        return;
      }
      if (em.l(this.nm).cA())
      {
        em.a(this.nm, 4);
        synchronized (em.h(this.nm))
        {
          if ((em.m(this.nm)) && (!ff.a(System.currentTimeMillis(), em.n(this.nm), 3))) {
            return;
          }
        }
        em.c(this.nm, true);
        em.b(this.nm, System.currentTimeMillis());
        em.d(this.nm).removeMessages(3);
        em.d(this.nm).sendEmptyMessageDelayed(3, 1000L);
        return;
      }
      synchronized (em.o(this.nm))
      {
        if (em.o(this.nm).size() <= 0) {
          return;
        }
      }
      Object localObject5 = (ArrayList)em.o(this.nm).clone();
      em.o(this.nm).clear();
      ??? = ((ArrayList)localObject5).iterator();
      while (???.hasNext())
      {
        localObject5 = (em.d)???.next();
        if (localObject5 != null)
        {
          if (em.k(this.nm))
          {
            em.a(this.nm, 3);
            synchronized (em.h(this.nm))
            {
              if ((em.i(this.nm)) && (!ff.a(System.currentTimeMillis(), em.j(this.nm), 3))) {
                return;
              }
            }
            em.b(this.nm, true);
            em.a(this.nm, System.currentTimeMillis());
            em.d(this.nm).removeMessages(2);
            em.d(this.nm).sendEmptyMessageDelayed(2, 1000L);
            return;
          }
          if (locald.nw) {
            b(false, locald);
          } else {
            b(true, locald);
          }
        }
      }
    case 2: 
      em.d(this.nm).removeMessages(2);
      em.f(this.nm).submit(new em.2.2(this));
      return;
    case 3: 
      em.d(this.nm).removeMessages(3);
      em.f(this.nm).submit(new em.2.3(this));
      return;
    case 4: 
      em.f(this.nm).submit(new em.2.4(this));
      return;
    case 8: 
      em.r(this.nm).dd();
      return;
    case 9: 
      em.r(this.nm).d(0, false);
      return;
    }
    em.s(this.nm);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     wf7.em.2
 * JD-Core Version:    0.7.0.1
 */