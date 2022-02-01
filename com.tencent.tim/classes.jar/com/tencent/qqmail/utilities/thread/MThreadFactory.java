package com.tencent.qqmail.utilities.thread;

import androidx.annotation.NonNull;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;

public class MThreadFactory
  implements ThreadFactory
{
  private AtomicInteger mCounter = new AtomicInteger(1);
  private String mPrefix = "";
  private int mPriority = 5;
  
  public MThreadFactory(String paramString)
  {
    this.mPrefix = paramString;
  }
  
  public MThreadFactory(String paramString, int paramInt)
  {
    this.mPrefix = paramString;
    this.mPriority = paramInt;
  }
  
  public Thread newThread(@NonNull Runnable paramRunnable)
  {
    return newThread(paramRunnable, String.valueOf(this.mCounter.getAndIncrement()));
  }
  
  public Thread newThread(Runnable paramRunnable, String paramString)
  {
    paramRunnable = new Thread(paramRunnable, this.mPrefix + " #" + paramString);
    paramRunnable.setPriority(this.mPriority);
    return paramRunnable;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.utilities.thread.MThreadFactory
 * JD-Core Version:    0.7.0.1
 */