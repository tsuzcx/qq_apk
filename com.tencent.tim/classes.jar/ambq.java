import android.os.Handler;
import android.os.Handler.Callback;
import android.os.Looper;
import android.os.Message;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.richmedia.ordersend.OrderMediaMsgTimerController.1;
import com.tencent.mobileqq.richmedia.ordersend.OrderMediaMsgTimerController.2;
import com.tencent.mobileqq.richmedia.ordersend.OrderMediaMsgTimerController.3;
import com.tencent.mobileqq.richmedia.ordersend.OrderMediaMsgTimerController.4;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;

public class ambq
  implements Handler.Callback
{
  private ambq.a a;
  private boolean cBV;
  private Handler cq = new Handler(Looper.getMainLooper(), null);
  private Runnable ht;
  private HashMap<Long, Runnable> mK;
  private Handler mSubHandler = new Handler(ThreadManager.getSubThreadLooper(), this);
  
  public ambq(ambq.a parama)
  {
    this.a = parama;
  }
  
  public void O(long paramLong, int paramInt1, int paramInt2)
  {
    if (this.mK == null) {
      this.mK = new HashMap();
    }
    if (this.mK.containsKey(Long.valueOf(paramLong))) {
      return;
    }
    OrderMediaMsgTimerController.4 local4 = new OrderMediaMsgTimerController.4(this, paramLong, paramInt1, paramInt2);
    this.cq.postDelayed(local4, 30000L);
    this.mK.put(Long.valueOf(paramLong), local4);
  }
  
  public Runnable a(long paramLong)
  {
    OrderMediaMsgTimerController.1 local1 = new OrderMediaMsgTimerController.1(this, paramLong);
    this.cq.postDelayed(local1, 8000L);
    return local1;
  }
  
  public Runnable a(String paramString)
  {
    paramString = new OrderMediaMsgTimerController.2(this, paramString);
    this.cq.postDelayed(paramString, 8000L);
    return paramString;
  }
  
  public void ah(Runnable paramRunnable)
  {
    if (this.cq != null) {
      this.cq.removeCallbacks(paramRunnable);
    }
  }
  
  public boolean cA(long paramLong)
  {
    if (this.cBV) {
      return false;
    }
    this.ht = new OrderMediaMsgTimerController.3(this, paramLong);
    this.cq.postDelayed(this.ht, 30000L);
    this.cBV = true;
    return true;
  }
  
  public void dMh()
  {
    if (this.cq != null)
    {
      this.cq.removeCallbacks(this.ht);
      this.cBV = false;
    }
  }
  
  public void destroy()
  {
    if (this.mK != null)
    {
      Iterator localIterator = this.mK.values().iterator();
      while (localIterator.hasNext())
      {
        Runnable localRunnable = (Runnable)localIterator.next();
        if (this.cq != null) {
          this.cq.removeCallbacks(localRunnable);
        }
      }
      this.mK.clear();
      this.mK = null;
    }
    if (this.cq != null)
    {
      this.cq.removeCallbacksAndMessages(null);
      this.cq = null;
    }
    if (this.mSubHandler != null)
    {
      this.mSubHandler.removeCallbacksAndMessages(null);
      this.mSubHandler = null;
    }
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    long l = 0L;
    switch (paramMessage.what)
    {
    }
    for (;;)
    {
      return false;
      if ((paramMessage.obj != null) && (this.a != null))
      {
        this.a.bu(paramMessage.obj);
        continue;
        if (paramMessage.obj != null) {
          l = ((Long)paramMessage.obj).longValue();
        }
        if (this.a != null)
        {
          this.a.kV(l);
          continue;
          if (paramMessage.obj != null) {
            l = ((Long)paramMessage.obj).longValue();
          }
          if (this.a != null) {
            this.a.N(l, paramMessage.arg1, paramMessage.arg2);
          }
        }
      }
    }
  }
  
  public void la(long paramLong)
  {
    if ((this.mK != null) && (this.mK.containsKey(Long.valueOf(paramLong))))
    {
      if (this.cq != null) {
        this.cq.removeCallbacks((Runnable)this.mK.get(Long.valueOf(paramLong)));
      }
      this.mK.remove(Long.valueOf(paramLong));
    }
  }
  
  public static abstract interface a
  {
    public abstract void N(long paramLong, int paramInt1, int paramInt2);
    
    public abstract void bu(Object paramObject);
    
    public abstract void kV(long paramLong);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     ambq
 * JD-Core Version:    0.7.0.1
 */