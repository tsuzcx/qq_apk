package tmsdk.common.d.a.b;

import a.e.c;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.util.Pair;
import com.qq.taf.jce.JceStruct;
import com.tencent.token.ef;
import com.tencent.token.eg;
import com.tencent.token.eh;
import com.tencent.token.ei;
import com.tencent.token.g;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map.Entry;
import java.util.Set;
import java.util.TreeMap;
import java.util.concurrent.atomic.AtomicReference;

class u
  implements Runnable
{
  public ArrayList a = new ArrayList();
  private TreeMap c = new TreeMap();
  private Handler d = new v(this, Looper.getMainLooper());
  
  private u(r paramr) {}
  
  private void a(a.e.f paramf)
  {
    Object localObject2 = null;
    JceStruct localJceStruct = null;
    this.d.removeMessages(paramf.c);
    synchronized (this.c)
    {
      t localt = (t)this.c.get(Integer.valueOf(paramf.c));
      if (localt == null) {
        return;
      }
      this.c.remove(Integer.valueOf(paramf.c));
      ??? = localJceStruct;
      if (paramf.f != null)
      {
        ??? = localJceStruct;
        if (localt.d != null)
        {
          ??? = localJceStruct;
          if (paramf.d == 0) {
            ??? = localObject2;
          }
        }
      }
      try
      {
        localJceStruct = b.a(r.e(this.b), r.d(this.b).b().b.getBytes(), paramf.f, localt.d);
        ??? = localJceStruct;
        if (localJceStruct == null)
        {
          ??? = localJceStruct;
          paramf.d = -300;
          ??? = localJceStruct;
        }
      }
      catch (Exception localException)
      {
        for (;;)
        {
          paramf.d = -400;
        }
      }
      if (localt.d != ???) {
        localt.d = ((JceStruct)???);
      }
      try
      {
        a(localt, Integer.valueOf(paramf.d), Integer.valueOf(paramf.e));
        return;
      }
      catch (Exception paramf) {}
    }
  }
  
  private void a(t paramt, Integer paramInteger1, Integer paramInteger2)
  {
    paramt.h.a(2);
    if (paramt.f == null) {
      return;
    }
    switch (eh.a(paramt.e))
    {
    default: 
      com.tencent.token.f.a().b(new w(this, paramt, paramInteger1, paramInteger2), "shark callback");
      return;
    case 16: 
      paramt.f.a(paramt.g, paramt.b, paramInteger1.intValue(), paramInteger2.intValue(), paramt.d);
      return;
    }
    paramt = r.a(this.b).obtainMessage(2, new Object[] { paramt, paramInteger1, paramInteger2 });
    r.a(this.b).sendMessage(paramt);
  }
  
  private int b(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return paramInt;
    case -100: 
      return paramInt - 9;
    case -200: 
      return paramInt - 9;
    case -300: 
      return paramInt - 5;
    case -400: 
      return paramInt - 5;
    }
    return paramInt - 8;
  }
  
  private void c(int paramInt)
  {
    Object localObject2 = a();
    synchronized (this.c)
    {
      this.c.clear();
      ??? = ((Set)localObject2).iterator();
      for (;;)
      {
        if (((Iterator)???).hasNext())
        {
          localObject2 = (Map.Entry)((Iterator)???).next();
          try
          {
            a((t)((Map.Entry)localObject2).getValue(), Integer.valueOf(paramInt), Integer.valueOf(-1));
          }
          catch (Exception localException) {}
        }
      }
    }
  }
  
  public Set a()
  {
    synchronized (this.c)
    {
      TreeMap localTreeMap2 = (TreeMap)this.c.clone();
      return localTreeMap2.entrySet();
    }
  }
  
  public void a(Integer paramInteger, t paramt)
  {
    this.c.put(paramInteger, paramt);
  }
  
  public boolean a(int paramInt)
  {
    synchronized (this.c)
    {
      boolean bool = this.c.containsKey(Integer.valueOf(paramInt));
      return bool;
    }
  }
  
  public void run()
  {
    Object localObject4;
    Object localObject6;
    Object localObject7;
    Object localObject8;
    try
    {
      ArrayList localArrayList = new ArrayList();
      localObject4 = new AtomicReference();
      ??? = r.d(this.b).b();
      localObject6 = a().iterator();
      while (((Iterator)localObject6).hasNext())
      {
        localObject7 = (Map.Entry)((Iterator)localObject6).next();
        if (!((t)((Map.Entry)localObject7).getValue()).h.a())
        {
          ((t)((Map.Entry)localObject7).getValue()).h.a(1);
          localObject8 = new c();
          ((c)localObject8).a = ((t)((Map.Entry)localObject7).getValue()).b;
          ((c)localObject8).b = ((t)((Map.Entry)localObject7).getValue()).g;
          ((c)localObject8).e = ((t)((Map.Entry)localObject7).getValue()).a;
          ((c)localObject8).c = 0;
          ((c)localObject8).d = null;
          if (((t)((Map.Entry)localObject7).getValue()).c != null)
          {
            TextUtils.isEmpty(((l)???).b);
            ((c)localObject8).d = b.a(r.e(this.b), ((l)???).b.getBytes(), ((t)((Map.Entry)localObject7).getValue()).c);
          }
          if (((t)((Map.Entry)localObject7).getValue()).i > 0L)
          {
            new StringBuilder().append("对seq : ").append(((c)localObject8).b).append("计时 : ").append(((t)((Map.Entry)localObject7).getValue()).i).append("ms").toString();
            this.d.sendEmptyMessageDelayed(((c)localObject8).b, ((t)((Map.Entry)localObject7).getValue()).i);
          }
          localArrayList.add(localObject8);
        }
      }
      localObject6 = this.a.iterator();
    }
    catch (Exception localException1)
    {
      new StringBuilder().append("run shark task e: ").append(localException1.toString()).toString();
      c(-10);
      return;
    }
    for (;;)
    {
      if (((Iterator)localObject6).hasNext())
      {
        localObject8 = (t)((Iterator)localObject6).next();
        localObject7 = new c();
        ((c)localObject7).a = ((t)localObject8).b;
        ((c)localObject7).b = 0;
        ((c)localObject7).c = ((t)localObject8).g;
        ((c)localObject7).d = null;
        if (((t)localObject8).c != null) {
          TextUtils.isEmpty(((l)???).b);
        }
      }
      try
      {
        ((c)localObject7).d = b.a(r.e(this.b), ((l)???).b.getBytes(), ((t)localObject8).c);
        localException1.add(localObject7);
        continue;
        int i = r.d(this.b).a((l)???, localException1, (AtomicReference)localObject4);
        if (i == 0)
        {
          localObject4 = ((ArrayList)((AtomicReference)localObject4).get()).iterator();
          while (((Iterator)localObject4).hasNext())
          {
            ??? = (a.e.f)((Iterator)localObject4).next();
            if (a(((a.e.f)???).c))
            {
              a((a.e.f)???);
            }
            else
            {
              Object localObject1;
              if (r.f(this.b).containsKey(Integer.valueOf(((a.e.f)???).a)))
              {
                localObject6 = (Pair)r.f(this.b).get(Integer.valueOf(((a.e.f)???).a));
                if ((((Pair)localObject6).first == null) || (((a.e.f)???).f == null)) {
                  break label876;
                }
                localObject1 = b.a(r.e(this.b), r.d(this.b).b().b.getBytes(), ((a.e.f)???).f, (JceStruct)((Pair)localObject6).first);
                localObject1 = ((eg)((Pair)localObject6).second).a(((a.e.f)???).b, ((a.e.f)???).a, (JceStruct)localObject1);
                if (localObject1 != null)
                {
                  localObject1 = new t(this.b, -1L, ((Integer)((Pair)localObject1).first).intValue(), (JceStruct)((Pair)localObject1).second, null, 1073741824, null);
                  ((t)localObject1).g = ((a.e.f)???).b;
                }
              }
              else
              {
                synchronized (r.b(this.b))
                {
                  r.b(this.b).add(localObject1);
                  r.a(this.b).sendEmptyMessage(1);
                }
              }
            }
          }
          c(b(-500));
          return;
        }
        c(b(i));
        return;
      }
      catch (Exception localException2)
      {
        for (;;)
        {
          continue;
          label876:
          Object localObject3 = null;
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     tmsdk.common.d.a.b.u
 * JD-Core Version:    0.7.0.1
 */