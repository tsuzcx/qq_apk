package wf7;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.TreeMap;
import java.util.concurrent.ExecutorService;

class eo$2
  extends Handler
{
  eo$2(eo parameo, Looper paramLooper)
  {
    super(paramLooper);
  }
  
  public void handleMessage(Message arg1)
  {
    int j = ???.what;
    int i = 0;
    Object localObject8;
    Object localObject9;
    if (j != 1)
    {
      if (j != 2)
      {
        if (j != 3)
        {
          if (j != 4)
          {
            if (j != 5) {
              return;
            }
            i = ???.arg1;
            synchronized (eo.l(this.oz))
            {
              ??? = (ed)eo.l(this.oz).get(Integer.valueOf(i));
              synchronized (eo.k(this.oz))
              {
                localObject8 = (eo.a)eo.k(this.oz).remove(Integer.valueOf(i));
                if ((??? == null) || (localObject8 == null)) {
                  break label1003;
                }
                ea.bV().a(new eo.2.1(this, (eo.a)localObject8, i, ???), "shark callback: check cached push");
                return;
              }
            }
          }
          ??? = new HashMap();
          synchronized (eo.k(this.oz))
          {
            ((HashMap)???).putAll(eo.k(this.oz));
            eo.k(this.oz).clear();
            if (((HashMap)???).size() <= 0) {
              break label1003;
            }
            ??? = ((HashMap)???).entrySet().iterator();
            do
            {
              if (!???.hasNext()) {
                break;
              }
              ??? = (Map.Entry)???.next();
              localObject8 = (eo.a)((Map.Entry)???).getValue();
              ((Integer)((Map.Entry)???).getKey()).intValue();
            } while (((eo.a)localObject8).oK != 0);
            this.oz.a(((eo.a)localObject8).oI.bZ, ((eo.a)localObject8).bY, ((eo.a)localObject8).oI.bH, null, -2, -1000000001);
          }
        }
        Object localObject3 = new HashSet();
        synchronized (eo.k(this.oz))
        {
          if (eo.k(this.oz).size() > 0)
          {
            long l = System.currentTimeMillis();
            localObject8 = eo.k(this.oz).entrySet().iterator();
            while (((Iterator)localObject8).hasNext())
            {
              localObject9 = (Map.Entry)((Iterator)localObject8).next();
              if (l - ((eo.a)((Map.Entry)localObject9).getValue()).oH >= 1800000L) {
                ((Set)localObject3).add(((Map.Entry)localObject9).getKey());
              }
            }
          }
          if (((Set)localObject3).size() <= 0) {
            break label1003;
          }
          localObject3 = ((Set)localObject3).iterator();
          while (((Iterator)localObject3).hasNext())
          {
            localObject8 = (Integer)((Iterator)localObject3).next();
            synchronized (eo.k(this.oz))
            {
              localObject8 = (eo.a)eo.k(this.oz).remove(localObject8);
              if ((localObject8 != null) && (((eo.a)localObject8).oK == 0)) {
                this.oz.a(((eo.a)localObject8).oI.bZ, ((eo.a)localObject8).bY, ((eo.a)localObject8).oI.bH, null, -2, -1000000001);
              }
            }
          }
        }
      }
      ea.lz = true;
      synchronized (eo.a(this.oz))
      {
        i = eo.a(this.oz).size();
        if (i > 0) {
          eo.b(this.oz).sendEmptyMessage(1);
        }
        if (eo.c(this.oz)) {
          this.oz.bL();
        }
        if (eo.d(this.oz)) {
          this.oz.onReady();
        }
        if (eo.e(this.oz)) {
          this.oz.cU();
        }
        if (eo.f(this.oz)) {
          this.oz.cV();
        }
        if (eo.g(this.oz)) {
          this.oz.db();
        }
        if (eo.h(this.oz) != null)
        {
          ??? = eo.h(this.oz).iterator();
          while (???.hasNext())
          {
            eg localeg = (eg)???.next();
            if (localeg != null) {
              this.oz.b(localeg.md, localeg.me, localeg.mf);
            }
          }
          eo.a(this.oz, null);
        }
        if (!eo.i(this.oz)) {
          break label1003;
        }
        eo.a(this.oz, false);
        ??? = this.oz.cC();
        if (TextUtils.isEmpty(???)) {
          break label1003;
        }
        eo.a(this.oz, 0, ???);
        return;
      }
    }
    eo.b(this.oz).removeMessages(1);
    eo.d locald = new eo.d(this.oz, null);
    label1003:
    label1017:
    synchronized (eo.a(this.oz))
    {
      localObject8 = eo.a(this.oz).iterator();
      while (((Iterator)localObject8).hasNext())
      {
        localObject9 = (eo.c)((Iterator)localObject8).next();
        if ((((eo.c)localObject9).oh & 0x40000000) == 0)
        {
          if (!((eo.c)localObject9).oR.cq())
          {
            locald.a(Integer.valueOf(((eo.c)localObject9).oP), (eo.c)localObject9);
            break label1017;
          }
          el.cP().ai(((eo.c)localObject9).oP);
        }
        else
        {
          eo.d.a(locald).add(localObject9);
          break label1017;
        }
      }
      eo.a(this.oz).clear();
      if (i > 0) {
        eo.j(this.oz).submit(locald);
      }
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     wf7.eo.2
 * JD-Core Version:    0.7.0.1
 */