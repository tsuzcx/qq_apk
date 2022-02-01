package com.tencent.qqlive.module.videoreport.utils;

import android.support.annotation.NonNull;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;

final class ThreadUtils$1
  implements ThreadFactory
{
  public Thread newThread(@NonNull Runnable paramRunnable)
  {
    return new Thread(paramRunnable, "vrpool-" + ThreadUtils.access$000().getAndIncrement() + "-thread");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqlive.module.videoreport.utils.ThreadUtils.1
 * JD-Core Version:    0.7.0.1
 */