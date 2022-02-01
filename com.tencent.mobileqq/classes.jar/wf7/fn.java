package wf7;

import android.os.Handler;
import com.tencent.wifisdk.services.common.api.e;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;

public class fn
{
  private static AtomicBoolean qA = new AtomicBoolean(false);
  private static fn qw;
  private final Handler mHandler = new fn.1(this, fq.getSubThreadLooper());
  private final e qx = fq.ek();
  private final Object qy = new Object();
  private volatile long qz = -1L;
  
  private fn()
  {
    fn.2 local2 = new fn.2(this);
    fq.eo().a(-1, local2);
    fq.eo().a(6065, local2);
    fq.eo().a(6165, local2);
  }
  
  public static fn dT()
  {
    if (qw == null) {}
    try
    {
      if (qw == null) {
        qw = new fn();
      }
      return qw;
    }
    finally {}
  }
  
  public void dU()
  {
    synchronized (this.qy)
    {
      long l = System.currentTimeMillis();
      if (l - this.qz < TimeUnit.MINUTES.toMillis(10L)) {
        return;
      }
      this.qz = l;
      fq.em().addTask(new fn.3(this), "doPullAndReport", 4);
      return;
    }
  }
  
  public void dV()
  {
    if (!qA.compareAndSet(false, true)) {}
    while (this.qx.getBoolean("wfk70100", false)) {
      return;
    }
    this.mHandler.sendEmptyMessageDelayed(1, 10000L);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     wf7.fn
 * JD-Core Version:    0.7.0.1
 */