package com.tencent.component.network.utils.thread;

import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;

public class PriorityThreadFactory
  implements ThreadFactory
{
  public static final String FLAG_THREAD_NAME_SPLIT = " sub:";
  private final int a;
  private final AtomicInteger b = new AtomicInteger();
  private final String c;
  
  public PriorityThreadFactory(String paramString, int paramInt)
  {
    this.c = paramString;
    this.a = paramInt;
  }
  
  public Thread newThread(Runnable paramRunnable)
  {
    return new e(this, paramRunnable, this.c + '-' + this.b.getAndIncrement() + " sub:");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.2.jar\classes.jar
 * Qualified Name:     com.tencent.component.network.utils.thread.PriorityThreadFactory
 * JD-Core Version:    0.7.0.1
 */