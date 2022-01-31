package com.tencent.component.network.utils.thread;

import android.os.Process;

final class e
  extends Thread
{
  e(PriorityThreadFactory paramPriorityThreadFactory, Runnable paramRunnable, String paramString)
  {
    super(paramRunnable, paramString);
  }
  
  public final void run()
  {
    Process.setThreadPriority(PriorityThreadFactory.a(this.a));
    super.run();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     com.tencent.component.network.utils.thread.e
 * JD-Core Version:    0.7.0.1
 */