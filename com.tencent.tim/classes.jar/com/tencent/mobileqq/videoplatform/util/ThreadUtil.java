package com.tencent.mobileqq.videoplatform.util;

import com.tencent.mobileqq.videoplatform.api.IThreadMgr;
import com.tencent.mobileqq.videoplatform.imp.ThreadMgrImp;

public class ThreadUtil
{
  private static IThreadMgr sThreadMgr = new ThreadMgrImp();
  
  public static void postOnSubThread(Runnable paramRunnable)
  {
    sThreadMgr.postOnSubThread(paramRunnable);
  }
  
  public static void postOnSubThreadDelayed(Runnable paramRunnable, long paramLong)
  {
    sThreadMgr.postOnSubThreadDelayed(paramRunnable, paramLong);
  }
  
  public static void postOnUIThread(Runnable paramRunnable)
  {
    sThreadMgr.postOnUIThread(paramRunnable);
  }
  
  public static void postOnUIThreadDelayed(Runnable paramRunnable, long paramLong)
  {
    sThreadMgr.postOnUIThreadDelayed(paramRunnable, paramLong);
  }
  
  public static void quitThread()
  {
    sThreadMgr.quitSubThread();
  }
  
  public static void removeCallbacksInSubHandler(Runnable paramRunnable)
  {
    sThreadMgr.removeCallbackOnSubHandler(paramRunnable);
  }
  
  public static void removeCallbacksOnUIHandler(Runnable paramRunnable)
  {
    sThreadMgr.removeCallbackOnUIHandler(paramRunnable);
  }
  
  public static void setThreadImp(IThreadMgr paramIThreadMgr)
  {
    sThreadMgr = paramIThreadMgr;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.videoplatform.util.ThreadUtil
 * JD-Core Version:    0.7.0.1
 */