package dov.com.qq.im.capture.control;

import android.support.annotation.NonNull;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.automator.AsyncStep;
import com.tencent.mobileqq.app.automator.Automator;
import com.tencent.qphone.base.util.QLog;
import java.util.LinkedList;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

public class CaptureAsyncAutomator
  extends Automator
  implements Runnable
{
  private final LinkedList<AsyncStep> N = new LinkedList();
  private AsyncStep a;
  private ThreadPoolExecutor h;
  
  public CaptureAsyncAutomator(QQAppInterface paramQQAppInterface)
  {
    super(paramQQAppInterface);
  }
  
  private void c(AsyncStep paramAsyncStep)
  {
    this.N.add(paramAsyncStep);
    if (QLog.isColorLevel()) {
      QLog.d("CaptureAsyncAutomator", 2, "addWaitingMode_Locked " + paramAsyncStep.mName);
    }
  }
  
  private void initExecutor()
  {
    this.h = new ThreadPoolExecutor(3, 3, 1000L, TimeUnit.MILLISECONDS, new LinkedBlockingQueue(24), new a(null));
    this.h.allowCoreThreadTimeOut(true);
  }
  
  public void a(AsyncStep paramAsyncStep)
  {
    if (QLog.isColorLevel()) {
      QLog.d("CaptureAsyncAutomator", 2, "start " + paramAsyncStep.mName);
    }
    synchronized (this.N)
    {
      if (this.a == null)
      {
        this.a = paramAsyncStep;
        if (QLog.isColorLevel()) {
          QLog.d("CaptureAsyncAutomator", 2, "run " + paramAsyncStep.mName);
        }
        if (this.h == null) {
          initExecutor();
        }
        this.h.execute(this);
        return;
      }
      c(paramAsyncStep);
    }
  }
  
  public void b(AsyncStep paramAsyncStep)
  {
    synchronized (this.M)
    {
      QLog.d("CaptureAsyncAutomator", 1, "CameraEmo, mCountRunning " + this.cyB);
      if (this.cyB < 3)
      {
        this.cyB += 1;
        if (this.h == null) {
          initExecutor();
        }
        this.h.execute(paramAsyncStep);
        return;
      }
      this.M.add(paramAsyncStep);
    }
  }
  
  public void run()
  {
    for (;;)
    {
      ??? = this.a;
      if (??? != null) {
        ((AsyncStep)???).run();
      }
      synchronized (this.N)
      {
        this.a = ((AsyncStep)this.N.poll());
        if (this.a == null) {
          return;
        }
      }
    }
  }
  
  class a
    implements ThreadFactory
  {
    private final AtomicInteger threadNumber = new AtomicInteger(1);
    
    private a() {}
    
    public Thread newThread(@NonNull Runnable paramRunnable)
    {
      paramRunnable = new Thread(paramRunnable, "CaptureAsyncAutomator_" + this.threadNumber.getAndIncrement());
      paramRunnable.setPriority(4);
      return paramRunnable;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     dov.com.qq.im.capture.control.CaptureAsyncAutomator
 * JD-Core Version:    0.7.0.1
 */