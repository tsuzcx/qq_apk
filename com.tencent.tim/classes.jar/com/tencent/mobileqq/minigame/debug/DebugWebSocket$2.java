package com.tencent.mobileqq.minigame.debug;

import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;

final class DebugWebSocket$2
  implements ThreadFactory
{
  private final AtomicInteger mCount = new AtomicInteger(1);
  
  public Thread newThread(Runnable paramRunnable)
  {
    paramRunnable = new Thread(paramRunnable, "miniDebugWeb #" + this.mCount.getAndIncrement());
    paramRunnable.setDaemon(false);
    return paramRunnable;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.minigame.debug.DebugWebSocket.2
 * JD-Core Version:    0.7.0.1
 */