package com.google.common.util.concurrent;

import com.google.common.annotations.GwtCompatible;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import java.util.logging.Level;
import java.util.logging.Logger;

@GwtCompatible(emulated=true)
abstract class InterruptibleTask
  implements Runnable
{
  private static final AtomicHelper ATOMIC_HELPER;
  private static final Logger log = Logger.getLogger(InterruptibleTask.class.getName());
  private volatile boolean doneInterrupting;
  private volatile Thread runner;
  
  static
  {
    try
    {
      SafeAtomicHelper localSafeAtomicHelper = new SafeAtomicHelper(AtomicReferenceFieldUpdater.newUpdater(InterruptibleTask.class, Thread.class, "runner"));
      ATOMIC_HELPER = localSafeAtomicHelper;
      return;
    }
    catch (Throwable localThrowable)
    {
      for (;;)
      {
        log.log(Level.SEVERE, "SafeAtomicHelper is broken!", localThrowable);
        SynchronizedAtomicHelper localSynchronizedAtomicHelper = new SynchronizedAtomicHelper(null);
      }
    }
  }
  
  final void interruptTask()
  {
    Thread localThread = this.runner;
    if (localThread != null) {
      localThread.interrupt();
    }
    this.doneInterrupting = true;
  }
  
  /* Error */
  public final void run()
  {
    // Byte code:
    //   0: getstatic 61	com/google/common/util/concurrent/InterruptibleTask:ATOMIC_HELPER	Lcom/google/common/util/concurrent/InterruptibleTask$AtomicHelper;
    //   3: aload_0
    //   4: aconst_null
    //   5: invokestatic 95	java/lang/Thread:currentThread	()Ljava/lang/Thread;
    //   8: invokevirtual 99	com/google/common/util/concurrent/InterruptibleTask$AtomicHelper:compareAndSetRunner	(Lcom/google/common/util/concurrent/InterruptibleTask;Ljava/lang/Thread;Ljava/lang/Thread;)Z
    //   11: ifne +4 -> 15
    //   14: return
    //   15: aload_0
    //   16: invokevirtual 102	com/google/common/util/concurrent/InterruptibleTask:runInterruptibly	()V
    //   19: aload_0
    //   20: invokevirtual 106	com/google/common/util/concurrent/InterruptibleTask:wasInterrupted	()Z
    //   23: ifeq -9 -> 14
    //   26: aload_0
    //   27: getfield 90	com/google/common/util/concurrent/InterruptibleTask:doneInterrupting	Z
    //   30: ifne -16 -> 14
    //   33: invokestatic 109	java/lang/Thread:yield	()V
    //   36: goto -10 -> 26
    //   39: astore_1
    //   40: aload_0
    //   41: invokevirtual 106	com/google/common/util/concurrent/InterruptibleTask:wasInterrupted	()Z
    //   44: ifeq +16 -> 60
    //   47: aload_0
    //   48: getfield 90	com/google/common/util/concurrent/InterruptibleTask:doneInterrupting	Z
    //   51: ifne +9 -> 60
    //   54: invokestatic 109	java/lang/Thread:yield	()V
    //   57: goto -10 -> 47
    //   60: aload_1
    //   61: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	62	0	this	InterruptibleTask
    //   39	22	1	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   15	19	39	finally
  }
  
  abstract void runInterruptibly();
  
  abstract boolean wasInterrupted();
  
  static abstract class AtomicHelper
  {
    abstract boolean compareAndSetRunner(InterruptibleTask paramInterruptibleTask, Thread paramThread1, Thread paramThread2);
  }
  
  static final class SafeAtomicHelper
    extends InterruptibleTask.AtomicHelper
  {
    final AtomicReferenceFieldUpdater<InterruptibleTask, Thread> runnerUpdater;
    
    SafeAtomicHelper(AtomicReferenceFieldUpdater paramAtomicReferenceFieldUpdater)
    {
      super();
      this.runnerUpdater = paramAtomicReferenceFieldUpdater;
    }
    
    boolean compareAndSetRunner(InterruptibleTask paramInterruptibleTask, Thread paramThread1, Thread paramThread2)
    {
      return this.runnerUpdater.compareAndSet(paramInterruptibleTask, paramThread1, paramThread2);
    }
  }
  
  static final class SynchronizedAtomicHelper
    extends InterruptibleTask.AtomicHelper
  {
    private SynchronizedAtomicHelper()
    {
      super();
    }
    
    boolean compareAndSetRunner(InterruptibleTask paramInterruptibleTask, Thread paramThread1, Thread paramThread2)
    {
      try
      {
        if (paramInterruptibleTask.runner == paramThread1) {
          InterruptibleTask.access$202(paramInterruptibleTask, paramThread2);
        }
        return true;
      }
      finally {}
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     com.google.common.util.concurrent.InterruptibleTask
 * JD-Core Version:    0.7.0.1
 */