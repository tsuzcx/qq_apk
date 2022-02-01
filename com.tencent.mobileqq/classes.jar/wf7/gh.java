package wf7;

import Protocol.MConch.ConchPushInfo;
import Protocol.MConch.c;
import Protocol.MConch.d;
import Protocol.MConch.h;
import android.os.Handler;
import android.os.HandlerThread;
import android.util.SparseArray;
import com.tencent.wifisdk.services.common.api.IThreadPool;
import com.tencent.wifisdk.services.common.api.a;
import com.tencent.wifisdk.services.common.api.e;
import java.util.HashSet;
import java.util.Set;

public class gh
{
  private static gh sc;
  private final Object lk = new Object();
  private Handler mHandler;
  private IThreadPool sd;
  private e se;
  private com.tencent.wifisdk.services.common.api.b sf;
  private SparseArray<a> sg = new SparseArray();
  private Set<Integer> sh = new HashSet();
  
  private gh(IThreadPool paramIThreadPool, com.tencent.wifisdk.services.common.api.b paramb, e parame)
  {
    this.sd = paramIThreadPool;
    this.se = parame;
    this.sf = paramb;
  }
  
  private d a(long paramLong1, long paramLong2, c paramc, int paramInt)
  {
    d locald = new d();
    locald.bt = paramLong1;
    locald.bu = paramLong2;
    if (paramc != null)
    {
      locald.bi = paramc.bi;
      locald.bk = paramc.bk;
    }
    locald.bv = paramInt;
    return locald;
  }
  
  public static gh a(IThreadPool paramIThreadPool, com.tencent.wifisdk.services.common.api.b paramb, e parame)
  {
    if (sc == null) {}
    try
    {
      if ((sc == null) && (paramIThreadPool != null) && (paramb != null) && (parame != null)) {
        sc = new gh(paramIThreadPool, paramb, parame);
      }
      return sc;
    }
    finally {}
  }
  
  private Handler getHandler()
  {
    if ((this.mHandler == null) && (this.sd != null))
    {
      HandlerThread localHandlerThread = this.sd.newFreeHandlerThread("ConchHandler", 5);
      if (localHandlerThread != null)
      {
        localHandlerThread.start();
        this.mHandler = new gh.3(this, localHandlerThread.getLooper());
      }
    }
    return this.mHandler;
  }
  
  public boolean a(int paramInt, a parama)
  {
    if (parama == null) {
      return false;
    }
    synchronized (this.lk)
    {
      if (this.sg.get(paramInt) == null)
      {
        this.sg.put(paramInt, parama);
        if (this.sh.contains(Integer.valueOf(paramInt)))
        {
          this.sh.remove(Integer.valueOf(paramInt));
          Handler localHandler = getHandler();
          if (localHandler != null) {
            localHandler.post(new gh.2(this, parama, paramInt));
          }
        }
        return true;
      }
    }
    return false;
  }
  
  public ConchPushInfo av(int paramInt)
  {
    try
    {
      ConchPushInfo localConchPushInfo = ConchPushInfo.a(this.se.getString("id_" + paramInt));
      return localConchPushInfo;
    }
    catch (Throwable localThrowable) {}
    return null;
  }
  
  public void aw(int paramInt)
  {
    if ((a)this.sg.get(paramInt) == null) {
      return;
    }
    Protocol.MConch.b localb = new Protocol.MConch.b();
    localb.bi = -1;
    this.sf.a(11, localb, new h(), new gh.1(this, paramInt));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     wf7.gh
 * JD-Core Version:    0.7.0.1
 */