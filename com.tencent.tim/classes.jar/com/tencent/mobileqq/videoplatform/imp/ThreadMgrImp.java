package com.tencent.mobileqq.videoplatform.imp;

import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import com.tencent.mobileqq.videoplatform.api.IThreadMgr;
import com.tencent.mobileqq.videoplatform.util.LogUtil;

public class ThreadMgrImp
  implements IThreadMgr
{
  Handler mMainHandler;
  Handler mSubHandler;
  volatile HandlerThread mSubThread;
  
  private String getLogTag()
  {
    return "[VideoPlatForm]ThreadMgrImp";
  }
  
  public void postOnSubThread(Runnable paramRunnable)
  {
    try
    {
      if (this.mSubThread == null)
      {
        this.mSubThread = new HandlerThread("VideoPlatfom_SUB", 0);
        this.mSubThread.start();
        this.mSubHandler = new Handler(this.mSubThread.getLooper());
        if (LogUtil.isColorLevel()) {
          LogUtil.d(getLogTag(), 2, "new sub thread");
        }
      }
      this.mSubHandler.post(paramRunnable);
      return;
    }
    finally {}
  }
  
  public void postOnSubThreadDelayed(Runnable paramRunnable, long paramLong)
  {
    try
    {
      if (this.mSubThread == null)
      {
        this.mSubThread = new HandlerThread("VideoPlatfom_SUB", 0);
        this.mSubThread.start();
        this.mSubHandler = new Handler(this.mSubThread.getLooper());
        if (LogUtil.isColorLevel()) {
          LogUtil.d(getLogTag(), 2, "new sub thread");
        }
      }
      this.mSubHandler.postDelayed(paramRunnable, paramLong);
      return;
    }
    finally {}
  }
  
  public void postOnUIThread(Runnable paramRunnable)
  {
    try
    {
      if (this.mMainHandler == null) {
        this.mMainHandler = new Handler(Looper.getMainLooper());
      }
      this.mMainHandler.post(paramRunnable);
      return;
    }
    finally {}
  }
  
  public void postOnUIThreadDelayed(Runnable paramRunnable, long paramLong)
  {
    try
    {
      if (this.mMainHandler == null) {
        this.mMainHandler = new Handler(Looper.getMainLooper());
      }
      this.mMainHandler.postDelayed(paramRunnable, paramLong);
      return;
    }
    finally {}
  }
  
  /* Error */
  public void quitSubThread()
  {
    // Byte code:
    //   0: invokestatic 51	com/tencent/mobileqq/videoplatform/util/LogUtil:isColorLevel	()Z
    //   3: ifeq +13 -> 16
    //   6: aload_0
    //   7: invokespecial 53	com/tencent/mobileqq/videoplatform/imp/ThreadMgrImp:getLogTag	()Ljava/lang/String;
    //   10: iconst_2
    //   11: ldc 80
    //   13: invokestatic 59	com/tencent/mobileqq/videoplatform/util/LogUtil:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   16: aload_0
    //   17: monitorenter
    //   18: aload_0
    //   19: getfield 24	com/tencent/mobileqq/videoplatform/imp/ThreadMgrImp:mSubThread	Landroid/os/HandlerThread;
    //   22: ifnull +19 -> 41
    //   25: getstatic 86	android/os/Build$VERSION:SDK_INT	I
    //   28: bipush 18
    //   30: if_icmplt +24 -> 54
    //   33: aload_0
    //   34: getfield 24	com/tencent/mobileqq/videoplatform/imp/ThreadMgrImp:mSubThread	Landroid/os/HandlerThread;
    //   37: invokevirtual 89	android/os/HandlerThread:quitSafely	()Z
    //   40: pop
    //   41: aload_0
    //   42: aconst_null
    //   43: putfield 45	com/tencent/mobileqq/videoplatform/imp/ThreadMgrImp:mSubHandler	Landroid/os/Handler;
    //   46: aload_0
    //   47: aconst_null
    //   48: putfield 24	com/tencent/mobileqq/videoplatform/imp/ThreadMgrImp:mSubThread	Landroid/os/HandlerThread;
    //   51: aload_0
    //   52: monitorexit
    //   53: return
    //   54: aload_0
    //   55: getfield 24	com/tencent/mobileqq/videoplatform/imp/ThreadMgrImp:mSubThread	Landroid/os/HandlerThread;
    //   58: invokevirtual 92	android/os/HandlerThread:quit	()Z
    //   61: pop
    //   62: goto -21 -> 41
    //   65: astore_1
    //   66: aload_0
    //   67: monitorexit
    //   68: aload_1
    //   69: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	70	0	this	ThreadMgrImp
    //   65	4	1	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   18	41	65	finally
    //   41	53	65	finally
    //   54	62	65	finally
    //   66	68	65	finally
  }
  
  public void removeCallbackOnSubHandler(Runnable paramRunnable)
  {
    try
    {
      if (this.mSubHandler != null) {
        this.mSubHandler.removeCallbacks(paramRunnable);
      }
      return;
    }
    finally {}
  }
  
  public void removeCallbackOnUIHandler(Runnable paramRunnable)
  {
    try
    {
      if (this.mMainHandler != null) {
        this.mMainHandler.removeCallbacks(paramRunnable);
      }
      return;
    }
    finally {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.videoplatform.imp.ThreadMgrImp
 * JD-Core Version:    0.7.0.1
 */