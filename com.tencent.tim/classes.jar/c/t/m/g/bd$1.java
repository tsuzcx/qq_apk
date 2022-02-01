package c.t.m.g;

import android.os.Handler;
import android.os.Message;
import android.util.Pair;
import com.tencent.map.geolocation.internal.TencentExtraKeys;
import java.util.concurrent.LinkedBlockingQueue;

final class bd$1
  implements Runnable
{
  bd$1(bd parambd, Handler paramHandler) {}
  
  public final void run()
  {
    this.b.a.clear();
    bd localbd = this.b;
    Handler localHandler = this.a;
    LinkedBlockingQueue localLinkedBlockingQueue = localbd.a;
    Object localObject1 = null;
    for (;;)
    {
      if (localbd.g) {
        for (;;)
        {
          try
          {
            locala = (bd.a)localLinkedBlockingQueue.take();
          }
          catch (Exception localException3)
          {
            bd.a locala;
            long l1;
            long l2;
            long l3;
            Object localObject3;
            long l4;
            int i;
            Object localObject2;
            continue;
          }
          try
          {
            if (bd.a.e == locala) {
              return;
            }
            l1 = 0L;
            if (TencentExtraKeys.COMPHTTPIO)
            {
              l1 = System.currentTimeMillis();
              localbd.b.a(bd.a.c(locala), bd.a.a(locala));
              l1 = System.currentTimeMillis() - l1;
            }
            new StringBuilder("request:").append(locala.b);
            l2 = System.currentTimeMillis();
            localObject1 = localbd.b.a(bd.a.c(locala), bd.a.a(locala));
            l3 = System.currentTimeMillis() - l2;
            new StringBuilder("request:").append(bd.a.c(locala));
            new StringBuilder("cost:").append(l3).append(",request:").append((String)localObject1);
            localbd.c += 1L;
            localbd.d += bd.a.a(locala).length;
            localObject3 = ai.c(((String)localObject1).getBytes());
            l4 = localbd.e;
            if (localObject3 != null)
            {
              i = localObject3.length;
              localbd.e = (l4 + i);
              if (TencentExtraKeys.COMPHTTPIO)
              {
                new StringBuilder("Halley:").append(l3).append("ms,HttpURLConnection:").append(l1).append("ms");
                new StringBuilder("Halley:").append(l3).append("ms,HttpURLConnection:").append(l1).append("ms");
              }
              localObject3 = localHandler.obtainMessage();
              ((Message)localObject3).arg1 = ((int)l3);
              ((Message)localObject3).arg2 = ((int)l1);
              locala.c = l2;
              if (1 == bd.a.b(locala))
              {
                ((Message)localObject3).obj = Pair.create(localObject1, locala);
                ((Message)localObject3).what = 4999;
                ((Message)localObject3).sendToTarget();
              }
              if (4 == bd.a.b(locala))
              {
                ((Message)localObject3).obj = Pair.create(localObject1, locala);
                ((Message)localObject3).what = 4999;
                ((Message)localObject3).sendToTarget();
              }
              if (3 == bd.a.b(locala))
              {
                ((Message)localObject3).obj = Pair.create(localObject1, locala);
                ((Message)localObject3).what = 4997;
                ((Message)localObject3).sendToTarget();
              }
              localObject1 = locala;
              break;
            }
            i = 0;
          }
          catch (Exception localException1)
          {
            localObject2 = locala;
            localbd.a(localObject2);
            i = 0;
            if (bd.a.b(localObject2) == 1) {
              i = 1;
            }
            try
            {
              int j = bd.a.b(localObject2);
              if (j == 1) {
                continue;
              }
            }
            catch (Exception localException2)
            {
              localException2.printStackTrace();
              continue;
            }
            if ((i == 0) && (4 == bd.a.b(localObject2))) {
              localHandler.sendEmptyMessageDelayed(4998, 60000L);
            }
            if (3 == bd.a.b(localObject2)) {
              localHandler.sendEmptyMessageDelayed(4996, 0L);
            }
            break;
            if ((localObject2 != null) && (bd.a.c(localObject2) != null))
            {
              bd.a.d(localObject2);
              bd.a.a(localObject2, bd.a.c(localObject2).replace("lbs.map.qq.com", "iplocreptest.map.qq.com"));
              new StringBuilder("postLocationIpv6Request ").append(localObject2.toString());
              if (bd.a.a(localObject2) != null) {
                localbd.a.offer(localObject2);
              }
            }
          }
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     c.t.m.g.bd.1
 * JD-Core Version:    0.7.0.1
 */