package okio;

import java.io.IOException;
import java.io.InterruptedIOException;
import java.util.concurrent.TimeUnit;
import javax.annotation.Nullable;

public class AsyncTimeout
  extends Timeout
{
  private static final long IDLE_TIMEOUT_MILLIS = TimeUnit.SECONDS.toMillis(60L);
  private static final long IDLE_TIMEOUT_NANOS = TimeUnit.MILLISECONDS.toNanos(IDLE_TIMEOUT_MILLIS);
  private static final int TIMEOUT_WRITE_SIZE = 65536;
  @Nullable
  static AsyncTimeout head;
  private boolean inQueue;
  @Nullable
  private AsyncTimeout next;
  private long timeoutAt;
  
  @Nullable
  static AsyncTimeout awaitTimeout()
    throws InterruptedException
  {
    Object localObject2 = null;
    Object localObject1 = head.next;
    if (localObject1 == null)
    {
      l1 = System.nanoTime();
      AsyncTimeout.class.wait(IDLE_TIMEOUT_MILLIS);
      localObject1 = localObject2;
      if (head.next == null)
      {
        localObject1 = localObject2;
        if (System.nanoTime() - l1 >= IDLE_TIMEOUT_NANOS) {
          localObject1 = head;
        }
      }
      return localObject1;
    }
    long l1 = ((AsyncTimeout)localObject1).remainingNanos(System.nanoTime());
    if (l1 > 0L)
    {
      long l2 = l1 / 1000000L;
      AsyncTimeout.class.wait(l2, (int)(l1 - 1000000L * l2));
      return null;
    }
    head.next = ((AsyncTimeout)localObject1).next;
    ((AsyncTimeout)localObject1).next = null;
    return localObject1;
  }
  
  /* Error */
  private static boolean cancelScheduledTimeout(AsyncTimeout paramAsyncTimeout)
  {
    // Byte code:
    //   0: ldc 2
    //   2: monitorenter
    //   3: getstatic 54	okio/AsyncTimeout:head	Lokio/AsyncTimeout;
    //   6: astore_2
    //   7: aload_2
    //   8: ifnull +39 -> 47
    //   11: aload_2
    //   12: getfield 56	okio/AsyncTimeout:next	Lokio/AsyncTimeout;
    //   15: aload_0
    //   16: if_acmpne +23 -> 39
    //   19: aload_2
    //   20: aload_0
    //   21: getfield 56	okio/AsyncTimeout:next	Lokio/AsyncTimeout;
    //   24: putfield 56	okio/AsyncTimeout:next	Lokio/AsyncTimeout;
    //   27: aload_0
    //   28: aconst_null
    //   29: putfield 56	okio/AsyncTimeout:next	Lokio/AsyncTimeout;
    //   32: iconst_0
    //   33: istore_1
    //   34: ldc 2
    //   36: monitorexit
    //   37: iload_1
    //   38: ireturn
    //   39: aload_2
    //   40: getfield 56	okio/AsyncTimeout:next	Lokio/AsyncTimeout;
    //   43: astore_2
    //   44: goto -37 -> 7
    //   47: iconst_1
    //   48: istore_1
    //   49: goto -15 -> 34
    //   52: astore_0
    //   53: ldc 2
    //   55: monitorexit
    //   56: aload_0
    //   57: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	58	0	paramAsyncTimeout	AsyncTimeout
    //   33	16	1	bool	boolean
    //   6	38	2	localAsyncTimeout	AsyncTimeout
    // Exception table:
    //   from	to	target	type
    //   3	7	52	finally
    //   11	32	52	finally
    //   39	44	52	finally
  }
  
  private long remainingNanos(long paramLong)
  {
    return this.timeoutAt - paramLong;
  }
  
  private static void scheduleTimeout(AsyncTimeout paramAsyncTimeout, long paramLong, boolean paramBoolean)
  {
    for (;;)
    {
      try
      {
        if (head == null)
        {
          head = new AsyncTimeout();
          new Watchdog().start();
        }
        long l = System.nanoTime();
        if ((paramLong != 0L) && (paramBoolean))
        {
          paramAsyncTimeout.timeoutAt = (Math.min(paramLong, paramAsyncTimeout.deadlineNanoTime() - l) + l);
          paramLong = paramAsyncTimeout.remainingNanos(l);
          localAsyncTimeout = head;
          if ((localAsyncTimeout.next != null) && (paramLong >= localAsyncTimeout.next.remainingNanos(l))) {
            break label175;
          }
          paramAsyncTimeout.next = localAsyncTimeout.next;
          localAsyncTimeout.next = paramAsyncTimeout;
          if (localAsyncTimeout == head) {
            AsyncTimeout.class.notify();
          }
          return;
        }
        if (paramLong != 0L)
        {
          paramAsyncTimeout.timeoutAt = (l + paramLong);
          continue;
        }
        if (!paramBoolean) {
          break label167;
        }
      }
      finally {}
      paramAsyncTimeout.timeoutAt = paramAsyncTimeout.deadlineNanoTime();
      continue;
      label167:
      throw new AssertionError();
      label175:
      AsyncTimeout localAsyncTimeout = localAsyncTimeout.next;
    }
  }
  
  public final void enter()
  {
    if (this.inQueue) {
      throw new IllegalStateException("Unbalanced enter/exit");
    }
    long l = timeoutNanos();
    boolean bool = hasDeadline();
    if ((l == 0L) && (!bool)) {
      return;
    }
    this.inQueue = true;
    scheduleTimeout(this, l, bool);
  }
  
  final IOException exit(IOException paramIOException)
    throws IOException
  {
    if (!exit()) {
      return paramIOException;
    }
    return newTimeoutException(paramIOException);
  }
  
  final void exit(boolean paramBoolean)
    throws IOException
  {
    if ((exit()) && (paramBoolean)) {
      throw newTimeoutException(null);
    }
  }
  
  public final boolean exit()
  {
    if (!this.inQueue) {
      return false;
    }
    this.inQueue = false;
    return cancelScheduledTimeout(this);
  }
  
  protected IOException newTimeoutException(@Nullable IOException paramIOException)
  {
    InterruptedIOException localInterruptedIOException = new InterruptedIOException("timeout");
    if (paramIOException != null) {
      localInterruptedIOException.initCause(paramIOException);
    }
    return localInterruptedIOException;
  }
  
  public final Sink sink(Sink paramSink)
  {
    return new AsyncTimeout.1(this, paramSink);
  }
  
  public final Source source(Source paramSource)
  {
    return new AsyncTimeout.2(this, paramSource);
  }
  
  protected void timedOut() {}
  
  static final class Watchdog
    extends Thread
  {
    Watchdog()
    {
      super();
      setDaemon(true);
    }
    
    public void run()
    {
      for (;;)
      {
        try
        {
          try
          {
            AsyncTimeout localAsyncTimeout = AsyncTimeout.awaitTimeout();
            if (localAsyncTimeout != null) {
              break label27;
            }
            continue;
          }
          finally {}
          continue;
        }
        catch (InterruptedException localInterruptedException) {}
        label27:
        if (localInterruptedException == AsyncTimeout.head)
        {
          AsyncTimeout.head = null;
          return;
        }
        localInterruptedException.timedOut();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     okio.AsyncTimeout
 * JD-Core Version:    0.7.0.1
 */