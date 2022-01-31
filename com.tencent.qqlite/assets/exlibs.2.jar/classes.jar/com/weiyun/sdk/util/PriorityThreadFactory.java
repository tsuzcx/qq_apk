package com.weiyun.sdk.util;

import android.os.Process;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;

public class PriorityThreadFactory
  implements ThreadFactory
{
  private final String mName;
  private final AtomicInteger mNumber = new AtomicInteger();
  private final int mPriority;
  
  public PriorityThreadFactory(String paramString, int paramInt)
  {
    this.mName = paramString;
    this.mPriority = paramInt;
  }
  
  public Thread newThread(Runnable paramRunnable)
  {
    new Thread(paramRunnable, this.mName + '-' + this.mNumber.getAndIncrement())
    {
      public void run()
      {
        Process.setThreadPriority(PriorityThreadFactory.this.mPriority);
        super.run();
      }
    };
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.2.jar\classes.jar
 * Qualified Name:     com.weiyun.sdk.util.PriorityThreadFactory
 * JD-Core Version:    0.7.0.1
 */