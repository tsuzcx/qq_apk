package wf7;

import android.os.Handler;
import android.os.HandlerThread;
import android.os.Message;
import android.support.annotation.NonNull;
import com.tencent.wifisdk.services.common.api.IThreadPool;
import com.tencent.wifisdk.services.common.api.b;
import com.tencent.wifisdk.services.common.api.c;
import com.tencent.wifisdk.services.common.api.e;
import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

public class hf
  implements c
{
  private static hf sT;
  private static final long sW = TimeUnit.MINUTES.toMillis(10L);
  private Handler mHandler;
  private volatile long sU = 0L;
  private long sV = TimeUnit.SECONDS.toMillis(30L);
  private he sX;
  private hg sY;
  private b sf;
  
  private hf(IThreadPool paramIThreadPool, b paramb, e parame1, e parame2)
  {
    paramIThreadPool = paramIThreadPool.newFreeHandlerThread("FeatureHandler", 5);
    if (paramIThreadPool != null)
    {
      paramIThreadPool.start();
      this.mHandler = new hf.1(this, paramIThreadPool.getLooper());
    }
    this.sf = paramb;
    this.sX = new he(parame1);
    this.sY = new hg(parame2);
  }
  
  public static hf a(@NonNull IThreadPool paramIThreadPool, @NonNull b paramb, @NonNull e parame1, @NonNull e parame2)
  {
    if (sT == null) {}
    try
    {
      if (sT == null) {
        sT = new hf(paramIThreadPool, paramb, parame1, parame2);
      }
      return sT;
    }
    finally {}
  }
  
  private void a(int paramInt1, int paramInt2, ArrayList<Integer> paramArrayList, ArrayList<String> paramArrayList1, int paramInt3)
  {
    if (this.mHandler == null) {
      return;
    }
    j localj = new j();
    localj.aG = paramInt1;
    localj.aH = ((int)(System.currentTimeMillis() / 1000L));
    localj.count = paramInt2;
    localj.aI = paramArrayList;
    localj.aJ = paramArrayList1;
    localj.aK = paramInt3;
    localj.aL = 0;
    Message.obtain(this.mHandler, 2, localj).sendToTarget();
  }
  
  public void a(int paramInt, q paramq)
  {
    Message.obtain(this.mHandler, 5, paramInt, -1, paramq).sendToTarget();
  }
  
  public void b(int paramInt, String paramString)
  {
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(paramString);
    a(paramInt, 1, null, localArrayList, 1);
  }
  
  public void c(int paramInt1, int paramInt2)
  {
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(Integer.valueOf(paramInt2));
    a(paramInt1, 1, localArrayList, null, 1);
  }
  
  public void fl()
  {
    this.mHandler.removeMessages(1);
    this.mHandler.sendEmptyMessage(1);
  }
  
  public void r(int paramInt)
  {
    a(paramInt, 1, null, null, 1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     wf7.hf
 * JD-Core Version:    0.7.0.1
 */