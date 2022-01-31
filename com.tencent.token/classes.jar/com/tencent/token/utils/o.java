package com.tencent.token.utils;

import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;

final class o
  implements ThreadFactory
{
  private final AtomicInteger a = new AtomicInteger(1);
  
  public Thread newThread(Runnable paramRunnable)
  {
    return new Thread(paramRunnable, "AsyncTask #" + this.a.getAndIncrement());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.utils.o
 * JD-Core Version:    0.7.0.1
 */