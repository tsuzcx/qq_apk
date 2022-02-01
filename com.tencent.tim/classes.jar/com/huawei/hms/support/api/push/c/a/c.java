package com.huawei.hms.support.api.push.c.a;

import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class c
{
  private static final Object a = new Object();
  private static ThreadPoolExecutor b = new ThreadPoolExecutor(1, 50, 60L, TimeUnit.SECONDS, new LinkedBlockingQueue());
  
  public static ThreadPoolExecutor a()
  {
    synchronized (a)
    {
      ThreadPoolExecutor localThreadPoolExecutor = b;
      return localThreadPoolExecutor;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     com.huawei.hms.support.api.push.c.a.c
 * JD-Core Version:    0.7.0.1
 */