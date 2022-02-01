package com.tencent.moai.mailsdk.util;

import androidx.annotation.NonNull;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

public class ThreadUtility
{
  private static final int MAX_THREAD_SIZE = 30;
  public static final ThreadPoolExecutor executorService = new ThreadPoolExecutor(30, 30, 3L, TimeUnit.MINUTES, new LinkedBlockingQueue(), new MThreadFactory());
  
  public static void start(Runnable paramRunnable)
  {
    executorService.execute(paramRunnable);
  }
  
  static class MThreadFactory
    implements ThreadFactory
  {
    private AtomicInteger mCounter = new AtomicInteger(1);
    
    public Thread newThread(@NonNull Runnable paramRunnable)
    {
      return newThread(paramRunnable, String.valueOf(this.mCounter.getAndIncrement()));
    }
    
    public Thread newThread(Runnable paramRunnable, String paramString)
    {
      paramRunnable = new Thread(paramRunnable, "ProtocolExecutor #" + paramString);
      paramRunnable.setPriority(3);
      return paramRunnable;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes7.jar
 * Qualified Name:     com.tencent.moai.mailsdk.util.ThreadUtility
 * JD-Core Version:    0.7.0.1
 */