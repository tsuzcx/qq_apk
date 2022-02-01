package com.weiyun.sdk.util;

import android.os.Process;

class PriorityThreadFactory$1
  extends Thread
{
  PriorityThreadFactory$1(PriorityThreadFactory paramPriorityThreadFactory, Runnable paramRunnable, String paramString)
  {
    super(paramRunnable, paramString);
  }
  
  public void run()
  {
    Process.setThreadPriority(PriorityThreadFactory.access$000(this.this$0));
    super.run();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes12.jar
 * Qualified Name:     com.weiyun.sdk.util.PriorityThreadFactory.1
 * JD-Core Version:    0.7.0.1
 */