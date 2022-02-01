package wf7;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.util.SparseArray;
import com.qq.taf.jce.JceStruct;
import com.tencent.wifisdk.services.common.api.b;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.concurrent.TimeUnit;

class hf$1
  extends Handler
{
  hf$1(hf paramhf, Looper paramLooper)
  {
    super(paramLooper);
  }
  
  public void handleMessage(Message paramMessage)
  {
    int k = paramMessage.what;
    int j = 0;
    int i = 0;
    switch (k)
    {
    default: 
      return;
    }
    try
    {
      paramMessage = ((Set)paramMessage.obj).iterator();
      while (paramMessage.hasNext())
      {
        Object localObject1 = (String)paramMessage.next();
        hf.f(this.sZ).remove((String)localObject1);
        continue;
        i = paramMessage.arg1;
        paramMessage = (q)paramMessage.obj;
        hf.f(this.sZ).b(i, paramMessage);
        hf.c(this.sZ).removeMessages(1);
        hf.c(this.sZ).sendEmptyMessage(1);
        return;
        paramMessage = ((Set)paramMessage.obj).iterator();
        while (paramMessage.hasNext())
        {
          localObject1 = (String)paramMessage.next();
          hf.d(this.sZ).remove((String)localObject1);
          continue;
          i = paramMessage.arg1;
          paramMessage = hf.d(this.sZ).getAll().entrySet().iterator();
          while (paramMessage.hasNext())
          {
            localObject1 = (Map.Entry)paramMessage.next();
            if (((j)((Map.Entry)localObject1).getValue()).aG == i)
            {
              hf.d(this.sZ).remove((String)((Map.Entry)localObject1).getKey());
              continue;
              paramMessage = (j)paramMessage.obj;
              if (paramMessage.aK == 8) {
                i = 1;
              }
              if (i != 0)
              {
                localObject1 = hf.d(this.sZ).getAll().entrySet().iterator();
                while (((Iterator)localObject1).hasNext())
                {
                  localObject2 = (Map.Entry)((Iterator)localObject1).next();
                  if (((j)((Map.Entry)localObject2).getValue()).aG == paramMessage.aG) {
                    hf.d(this.sZ).remove((String)((Map.Entry)localObject2).getKey());
                  }
                }
              }
              hf.d(this.sZ).a(paramMessage);
              hf.c(this.sZ).removeMessages(1);
              hf.c(this.sZ).sendEmptyMessage(1);
              return;
              long l1 = Math.abs(System.currentTimeMillis() - hf.a(this.sZ));
              if (l1 < hf.b(this.sZ))
              {
                hf.c(this.sZ).removeMessages(1);
                long l2 = hf.b(this.sZ);
                hf.c(this.sZ).sendEmptyMessageDelayed(1, l2 - l1);
                return;
              }
              if (l1 - hf.b(this.sZ) > TimeUnit.MINUTES.toMillis(1L))
              {
                hf.a(this.sZ, TimeUnit.SECONDS.toMillis(30L));
              }
              else if (hf.b(this.sZ) < hf.fn())
              {
                paramMessage = this.sZ;
                hf.a(paramMessage, hf.b(paramMessage) + TimeUnit.SECONDS.toMillis(30L));
              }
              hf.b(this.sZ, System.currentTimeMillis());
              paramMessage = new HashSet();
              localObject1 = new i();
              ((i)localObject1).aE = new ArrayList();
              Object localObject2 = hf.d(this.sZ).getAll().entrySet().iterator();
              i = 0;
              Object localObject5;
              while (((Iterator)localObject2).hasNext())
              {
                localObject4 = (Map.Entry)((Iterator)localObject2).next();
                localObject3 = (String)((Map.Entry)localObject4).getKey();
                localObject4 = (j)((Map.Entry)localObject4).getValue();
                localObject5 = new k();
                ((k)localObject5).aG = ((j)localObject4).aG;
                ((k)localObject5).aH = ((j)localObject4).aH;
                ((k)localObject5).count = ((j)localObject4).count;
                ((k)localObject5).aI = ((j)localObject4).aI;
                ((k)localObject5).aJ = ((j)localObject4).aJ;
                k = ((k)localObject5).toByteArray().length;
                if (k > 1024000)
                {
                  hf.d(this.sZ).remove((String)localObject3);
                }
                else
                {
                  k += i;
                  if (k <= 1024000)
                  {
                    paramMessage.add(localObject3);
                    ((i)localObject1).aE.add(localObject5);
                    i = k;
                  }
                }
              }
              if (((i)localObject1).aE.size() > 0) {
                hf.e(this.sZ).a(3651, (JceStruct)localObject1, null, new hf.1.1(this, paramMessage));
              }
              paramMessage = hf.f(this.sZ).getAll();
              localObject2 = new SparseArray();
              Object localObject4 = paramMessage.entrySet().iterator();
              Object localObject3 = new HashSet();
              i = 0;
              do
              {
                if (!((Iterator)localObject4).hasNext()) {
                  break;
                }
                localObject5 = (Map.Entry)((Iterator)localObject4).next();
                hg.a locala = (hg.a)((Map.Entry)localObject5).getValue();
                k = locala.td;
                localObject1 = (p)((SparseArray)localObject2).get(k);
                paramMessage = (Message)localObject1;
                if (localObject1 == null)
                {
                  paramMessage = new p();
                  paramMessage.bK = k;
                  paramMessage.bL = new ArrayList();
                  ((SparseArray)localObject2).put(k, paramMessage);
                }
                paramMessage.bL.add(locala.te);
                k = i + 1;
                ((Set)localObject3).add(((Map.Entry)localObject5).getKey());
                i = k;
              } while (k < 200);
              k = ((SparseArray)localObject2).size();
              if (k > 0)
              {
                i = j;
                while (i < k)
                {
                  paramMessage = (p)((SparseArray)localObject2).valueAt(i);
                  hf.e(this.sZ).a(4060, paramMessage, null, new hf.1.2(this, (Set)localObject3));
                  i += 1;
                }
              }
            }
          }
        }
      }
      return;
    }
    catch (Throwable paramMessage) {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     wf7.hf.1
 * JD-Core Version:    0.7.0.1
 */