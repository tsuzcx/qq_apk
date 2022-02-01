package wf7;

import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import com.tencent.wifisdk.TMSDKCustomConfig.IThreadPoolManager;
import com.tencent.wifisdk.services.common.api.IThreadPool;

final class fq$3
  implements IThreadPool
{
  Handler rp;
  
  fq$3(TMSDKCustomConfig.IThreadPoolManager paramIThreadPoolManager) {}
  
  public void addTask(Runnable paramRunnable, String paramString, int paramInt)
  {
    int i = 4;
    if (paramInt == 2) {
      paramInt = 2;
    } else if (paramInt == 3) {
      paramInt = 3;
    } else if (paramInt == 4) {
      paramInt = i;
    } else {
      paramInt = 1;
    }
    this.rq.addTypeTask(paramRunnable, paramInt);
  }
  
  public Handler getSubThreadHandler()
  {
    if (this.rp == null) {
      this.rp = new Handler(getSubThreadLooper());
    }
    return this.rp;
  }
  
  public Looper getSubThreadLooper()
  {
    return this.rq.getSubThreadLooper();
  }
  
  public HandlerThread newFreeHandlerThread(String paramString, int paramInt)
  {
    return new HandlerThread(paramString, paramInt);
  }
  
  public Thread newFreeThread(Runnable paramRunnable, String paramString)
  {
    return new Thread(paramRunnable, paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     wf7.fq.3
 * JD-Core Version:    0.7.0.1
 */