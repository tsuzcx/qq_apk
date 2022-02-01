package com.google.common.collect;

import com.google.common.annotations.Beta;
import com.google.common.annotations.GwtCompatible;
import com.google.common.annotations.GwtIncompatible;
import com.google.common.base.Preconditions;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import java.util.ArrayDeque;
import java.util.Collection;
import java.util.Deque;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.PriorityBlockingQueue;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.TimeUnit;

@GwtCompatible(emulated=true)
public final class Queues
{
  @Beta
  @GwtIncompatible
  @CanIgnoreReturnValue
  public static <E> int drain(BlockingQueue<E> paramBlockingQueue, Collection<? super E> paramCollection, int paramInt, long paramLong, TimeUnit paramTimeUnit)
    throws InterruptedException
  {
    Preconditions.checkNotNull(paramCollection);
    long l = System.nanoTime();
    paramLong = paramTimeUnit.toNanos(paramLong);
    int i = 0;
    for (;;)
    {
      int j = i;
      if (i < paramInt)
      {
        j = i + paramBlockingQueue.drainTo(paramCollection, paramInt - i);
        i = j;
        if (j >= paramInt) {
          continue;
        }
        paramTimeUnit = paramBlockingQueue.poll(paramLong + l - System.nanoTime(), TimeUnit.NANOSECONDS);
        if (paramTimeUnit != null) {}
      }
      else
      {
        return j;
      }
      paramCollection.add(paramTimeUnit);
      i = j + 1;
    }
  }
  
  @Beta
  @GwtIncompatible
  @CanIgnoreReturnValue
  public static <E> int drainUninterruptibly(BlockingQueue<E> paramBlockingQueue, Collection<? super E> paramCollection, int paramInt, long paramLong, TimeUnit paramTimeUnit)
  {
    int j = 0;
    Preconditions.checkNotNull(paramCollection);
    long l = System.nanoTime();
    paramLong = paramTimeUnit.toNanos(paramLong);
    int i = 0;
    for (;;)
    {
      int k = i;
      int m = j;
      if (i < paramInt) {
        m = j;
      }
      try
      {
        k = paramBlockingQueue.drainTo(paramCollection, paramInt - i);
        k = i + k;
        i = k;
        if (k >= paramInt) {
          continue;
        }
        for (;;)
        {
          m = j;
          try
          {
            paramTimeUnit = paramBlockingQueue.poll(l + paramLong - System.nanoTime(), TimeUnit.NANOSECONDS);
            if (paramTimeUnit != null) {
              break;
            }
            m = j;
            return k;
          }
          catch (InterruptedException paramTimeUnit)
          {
            j = 1;
          }
        }
        m = j;
        paramCollection.add(paramTimeUnit);
        i = k + 1;
      }
      finally
      {
        if (m != 0) {
          Thread.currentThread().interrupt();
        }
      }
    }
  }
  
  @GwtIncompatible
  public static <E> ArrayBlockingQueue<E> newArrayBlockingQueue(int paramInt)
  {
    return new ArrayBlockingQueue(paramInt);
  }
  
  public static <E> ArrayDeque<E> newArrayDeque()
  {
    return new ArrayDeque();
  }
  
  public static <E> ArrayDeque<E> newArrayDeque(Iterable<? extends E> paramIterable)
  {
    if ((paramIterable instanceof Collection)) {
      return new ArrayDeque(Collections2.cast(paramIterable));
    }
    ArrayDeque localArrayDeque = new ArrayDeque();
    Iterables.addAll(localArrayDeque, paramIterable);
    return localArrayDeque;
  }
  
  @GwtIncompatible
  public static <E> ConcurrentLinkedQueue<E> newConcurrentLinkedQueue()
  {
    return new ConcurrentLinkedQueue();
  }
  
  @GwtIncompatible
  public static <E> ConcurrentLinkedQueue<E> newConcurrentLinkedQueue(Iterable<? extends E> paramIterable)
  {
    if ((paramIterable instanceof Collection)) {
      return new ConcurrentLinkedQueue(Collections2.cast(paramIterable));
    }
    ConcurrentLinkedQueue localConcurrentLinkedQueue = new ConcurrentLinkedQueue();
    Iterables.addAll(localConcurrentLinkedQueue, paramIterable);
    return localConcurrentLinkedQueue;
  }
  
  @GwtIncompatible
  public static <E> LinkedBlockingDeque<E> newLinkedBlockingDeque()
  {
    return new LinkedBlockingDeque();
  }
  
  @GwtIncompatible
  public static <E> LinkedBlockingDeque<E> newLinkedBlockingDeque(int paramInt)
  {
    return new LinkedBlockingDeque(paramInt);
  }
  
  @GwtIncompatible
  public static <E> LinkedBlockingDeque<E> newLinkedBlockingDeque(Iterable<? extends E> paramIterable)
  {
    if ((paramIterable instanceof Collection)) {
      return new LinkedBlockingDeque(Collections2.cast(paramIterable));
    }
    LinkedBlockingDeque localLinkedBlockingDeque = new LinkedBlockingDeque();
    Iterables.addAll(localLinkedBlockingDeque, paramIterable);
    return localLinkedBlockingDeque;
  }
  
  @GwtIncompatible
  public static <E> LinkedBlockingQueue<E> newLinkedBlockingQueue()
  {
    return new LinkedBlockingQueue();
  }
  
  @GwtIncompatible
  public static <E> LinkedBlockingQueue<E> newLinkedBlockingQueue(int paramInt)
  {
    return new LinkedBlockingQueue(paramInt);
  }
  
  @GwtIncompatible
  public static <E> LinkedBlockingQueue<E> newLinkedBlockingQueue(Iterable<? extends E> paramIterable)
  {
    if ((paramIterable instanceof Collection)) {
      return new LinkedBlockingQueue(Collections2.cast(paramIterable));
    }
    LinkedBlockingQueue localLinkedBlockingQueue = new LinkedBlockingQueue();
    Iterables.addAll(localLinkedBlockingQueue, paramIterable);
    return localLinkedBlockingQueue;
  }
  
  @GwtIncompatible
  public static <E extends Comparable> PriorityBlockingQueue<E> newPriorityBlockingQueue()
  {
    return new PriorityBlockingQueue();
  }
  
  @GwtIncompatible
  public static <E extends Comparable> PriorityBlockingQueue<E> newPriorityBlockingQueue(Iterable<? extends E> paramIterable)
  {
    if ((paramIterable instanceof Collection)) {
      return new PriorityBlockingQueue(Collections2.cast(paramIterable));
    }
    PriorityBlockingQueue localPriorityBlockingQueue = new PriorityBlockingQueue();
    Iterables.addAll(localPriorityBlockingQueue, paramIterable);
    return localPriorityBlockingQueue;
  }
  
  public static <E extends Comparable> PriorityQueue<E> newPriorityQueue()
  {
    return new PriorityQueue();
  }
  
  public static <E extends Comparable> PriorityQueue<E> newPriorityQueue(Iterable<? extends E> paramIterable)
  {
    if ((paramIterable instanceof Collection)) {
      return new PriorityQueue(Collections2.cast(paramIterable));
    }
    PriorityQueue localPriorityQueue = new PriorityQueue();
    Iterables.addAll(localPriorityQueue, paramIterable);
    return localPriorityQueue;
  }
  
  @GwtIncompatible
  public static <E> SynchronousQueue<E> newSynchronousQueue()
  {
    return new SynchronousQueue();
  }
  
  public static <E> Deque<E> synchronizedDeque(Deque<E> paramDeque)
  {
    return Synchronized.deque(paramDeque, null);
  }
  
  public static <E> Queue<E> synchronizedQueue(Queue<E> paramQueue)
  {
    return Synchronized.queue(paramQueue, null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     com.google.common.collect.Queues
 * JD-Core Version:    0.7.0.1
 */