package com.tencent.bugly.proguard;

import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;

final class w$1
  implements ThreadFactory
{
  w$1(w paramw) {}
  
  public final Thread newThread(Runnable paramRunnable)
  {
    paramRunnable = new Thread(paramRunnable);
    paramRunnable.setName("BuglyThread-" + w.c().getAndIncrement());
    return paramRunnable;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes.jar
 * Qualified Name:     com.tencent.bugly.proguard.w.1
 * JD-Core Version:    0.7.0.1
 */