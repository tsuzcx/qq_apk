package wf7;

import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.support.annotation.NonNull;
import com.tencent.wifisdk.services.common.api.IThreadPool;

public class gd
  implements IThreadPool, av, dw
{
  private IThreadPool rZ;
  
  public gd(@NonNull IThreadPool paramIThreadPool)
  {
    this.rZ = paramIThreadPool;
  }
  
  public void a(Runnable paramRunnable, String paramString)
  {
    this.rZ.addTask(paramRunnable, paramString, 0);
  }
  
  public void addTask(Runnable paramRunnable, String paramString, int paramInt)
  {
    this.rZ.addTask(paramRunnable, paramString, 0);
  }
  
  public void b(Runnable paramRunnable, String paramString)
  {
    this.rZ.addTask(paramRunnable, paramString, 1);
  }
  
  public Handler getSubThreadHandler()
  {
    return this.rZ.getSubThreadHandler();
  }
  
  public Looper getSubThreadLooper()
  {
    return this.rZ.getSubThreadLooper();
  }
  
  public HandlerThread newFreeHandlerThread(String paramString, int paramInt)
  {
    return this.rZ.newFreeHandlerThread(paramString, paramInt);
  }
  
  public Thread newFreeThread(Runnable paramRunnable, String paramString)
  {
    return this.rZ.newFreeThread(paramRunnable, paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     wf7.gd
 * JD-Core Version:    0.7.0.1
 */