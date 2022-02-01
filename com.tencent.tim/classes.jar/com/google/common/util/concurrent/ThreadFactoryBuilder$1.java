package com.google.common.util.concurrent;

import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicLong;

final class ThreadFactoryBuilder$1
  implements ThreadFactory
{
  ThreadFactoryBuilder$1(ThreadFactory paramThreadFactory, String paramString, AtomicLong paramAtomicLong, Boolean paramBoolean, Integer paramInteger, Thread.UncaughtExceptionHandler paramUncaughtExceptionHandler) {}
  
  public Thread newThread(Runnable paramRunnable)
  {
    paramRunnable = this.val$backingThreadFactory.newThread(paramRunnable);
    if (this.val$nameFormat != null) {
      paramRunnable.setName(ThreadFactoryBuilder.access$000(this.val$nameFormat, new Object[] { Long.valueOf(this.val$count.getAndIncrement()) }));
    }
    if (this.val$daemon != null) {
      paramRunnable.setDaemon(this.val$daemon.booleanValue());
    }
    if (this.val$priority != null) {
      paramRunnable.setPriority(this.val$priority.intValue());
    }
    if (this.val$uncaughtExceptionHandler != null) {
      paramRunnable.setUncaughtExceptionHandler(this.val$uncaughtExceptionHandler);
    }
    return paramRunnable;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     com.google.common.util.concurrent.ThreadFactoryBuilder.1
 * JD-Core Version:    0.7.0.1
 */