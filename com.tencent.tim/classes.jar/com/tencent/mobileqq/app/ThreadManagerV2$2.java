package com.tencent.mobileqq.app;

import java.util.concurrent.ThreadFactory;

final class ThreadManagerV2$2
  implements ThreadFactory
{
  public Thread newThread(Runnable paramRunnable)
  {
    ThreadLog.printQLog("ThreadManager", "serialExecutor_thread");
    return new Thread(paramRunnable, "serialExecutor_thread");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes.jar
 * Qualified Name:     com.tencent.mobileqq.app.ThreadManagerV2.2
 * JD-Core Version:    0.7.0.1
 */