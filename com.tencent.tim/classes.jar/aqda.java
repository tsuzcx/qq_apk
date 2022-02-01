import android.annotation.TargetApi;
import android.os.Build.VERSION;
import android.os.Handler;
import android.os.Looper;
import android.view.Choreographer;
import android.view.Choreographer.FrameCallback;
import com.tencent.mobileqq.util.FPSCalculator.2;
import com.tencent.mobileqq.util.FPSCalculator.3;
import com.tencent.qphone.base.util.QLog;
import java.util.Vector;
import java.util.concurrent.TimeUnit;

@TargetApi(16)
public class aqda
{
  private static volatile aqda a;
  private Choreographer mChoreographer;
  private boolean mEnable;
  private Choreographer.FrameCallback mFPSMeasuringCallback;
  private Runnable mFakeFPSRunnable = new FPSCalculator.3(this);
  private long mFrameStartTime;
  private int mFramesRendered;
  private Handler mHandler;
  private Runnable mInitFPSRunnable = new FPSCalculator.2(this);
  private Vector<aqda.a> mListener = new Vector();
  private Object mLock = new Object();
  
  public static aqda a()
  {
    if (a == null) {}
    try
    {
      if (a == null) {
        a = new aqda();
      }
      return a;
    }
    finally {}
  }
  
  private void disable()
  {
    if (this.mEnable)
    {
      if (Build.VERSION.SDK_INT < 16) {
        break label82;
      }
      if (this.mChoreographer != null)
      {
        this.mChoreographer.removeFrameCallback(this.mFPSMeasuringCallback);
        if (QLog.isColorLevel()) {
          QLog.d("FPSCalculator", 2, "removeFrameCallback ");
        }
      }
      this.mHandler.removeCallbacksAndMessages(Boolean.valueOf(true));
    }
    for (;;)
    {
      this.mFrameStartTime = 0L;
      this.mFramesRendered = 0;
      this.mEnable = false;
      QLog.d("FPSCalculator", 2, "FPSCalculator set enable = false");
      return;
      label82:
      this.mHandler.removeCallbacksAndMessages(Boolean.valueOf(true));
    }
  }
  
  private void doOnFrame(long paramLong)
  {
    paramLong = nsToMs(paramLong);
    if (this.mFrameStartTime <= 0L) {
      this.mFrameStartTime = paramLong;
    }
    for (;;)
    {
      this.mChoreographer.postFrameCallback(this.mFPSMeasuringCallback);
      return;
      long l = paramLong - this.mFrameStartTime;
      this.mFramesRendered += 1;
      if (l <= 500L) {
        continue;
      }
      double d = this.mFramesRendered * 1000 / l;
      this.mFrameStartTime = paramLong;
      this.mFramesRendered = 0;
      Object localObject1 = this.mLock;
      int i = 0;
      try
      {
        while (i < this.mListener.size())
        {
          ((aqda.a)this.mListener.get(i)).onInfo(this.mFrameStartTime, d);
          i += 1;
        }
      }
      finally {}
    }
  }
  
  private void enable()
  {
    if (this.mEnable)
    {
      QLog.d("FPSCalculator", 2, "FPSCalculator is enable");
      return;
    }
    this.mEnable = true;
    QLog.d("FPSCalculator", 2, "FPSCalculator set enable = true");
    if (this.mHandler == null) {
      this.mHandler = new Handler(Looper.getMainLooper());
    }
    if (Build.VERSION.SDK_INT > 16)
    {
      if (this.mFPSMeasuringCallback == null) {
        this.mFPSMeasuringCallback = new aqdb(this);
      }
      this.mHandler.post(this.mInitFPSRunnable);
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("FPSCalculator", 2, "build version is not support ");
    }
    this.mHandler.postDelayed(this.mFakeFPSRunnable, 500L);
  }
  
  private static long nsToMs(long paramLong)
  {
    return TimeUnit.NANOSECONDS.toMillis(paramLong);
  }
  
  public void a(aqda.a parama)
  {
    synchronized (this.mLock)
    {
      if (!this.mListener.contains(parama)) {
        this.mListener.add(parama);
      }
      if (this.mListener.size() > 0) {
        enable();
      }
      return;
    }
  }
  
  public void b(aqda.a parama)
  {
    synchronized (this.mLock)
    {
      if (this.mListener.contains(parama)) {
        this.mListener.remove(parama);
      }
      if (this.mListener.size() <= 0) {
        disable();
      }
      return;
    }
  }
  
  public static abstract interface a
  {
    public abstract void onInfo(long paramLong, double paramDouble);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     aqda
 * JD-Core Version:    0.7.0.1
 */