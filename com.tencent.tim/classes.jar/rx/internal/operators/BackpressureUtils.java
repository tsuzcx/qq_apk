package rx.internal.operators;

import java.util.Queue;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicLongFieldUpdater;
import rx.Subscriber;

public final class BackpressureUtils
{
  static final long COMPLETED_MASK = -9223372036854775808L;
  static final long REQUESTED_MASK = 9223372036854775807L;
  
  private BackpressureUtils()
  {
    throw new IllegalStateException("No instances!");
  }
  
  public static long addCap(long paramLong1, long paramLong2)
  {
    paramLong2 = paramLong1 + paramLong2;
    paramLong1 = paramLong2;
    if (paramLong2 < 0L) {
      paramLong1 = 9223372036854775807L;
    }
    return paramLong1;
  }
  
  public static long getAndAddRequest(AtomicLong paramAtomicLong, long paramLong)
  {
    long l;
    do
    {
      l = paramAtomicLong.get();
    } while (!paramAtomicLong.compareAndSet(l, addCap(l, paramLong)));
    return l;
  }
  
  public static <T> long getAndAddRequest(AtomicLongFieldUpdater<T> paramAtomicLongFieldUpdater, T paramT, long paramLong)
  {
    long l;
    do
    {
      l = paramAtomicLongFieldUpdater.get(paramT);
    } while (!paramAtomicLongFieldUpdater.compareAndSet(paramT, l, addCap(l, paramLong)));
    return l;
  }
  
  public static long multiplyCap(long paramLong1, long paramLong2)
  {
    long l2 = paramLong1 * paramLong2;
    long l1 = l2;
    if ((paramLong1 | paramLong2) >>> 31 != 0L)
    {
      l1 = l2;
      if (paramLong2 != 0L)
      {
        l1 = l2;
        if (l2 / paramLong2 != paramLong1) {
          l1 = 9223372036854775807L;
        }
      }
    }
    return l1;
  }
  
  public static <T> void postCompleteDone(AtomicLong paramAtomicLong, Queue<T> paramQueue, Subscriber<? super T> paramSubscriber)
  {
    long l = paramAtomicLong.get();
    if ((l & 0x0) != 0L) {}
    do
    {
      return;
      if (!paramAtomicLong.compareAndSet(l, l | 0x0)) {
        break;
      }
    } while (l == 0L);
    postCompleteDrain(paramAtomicLong, paramQueue, paramSubscriber);
  }
  
  static <T> void postCompleteDrain(AtomicLong paramAtomicLong, Queue<T> paramQueue, Subscriber<? super T> paramSubscriber)
  {
    long l1 = paramAtomicLong.get();
    long l2 = -9223372036854775808L;
    for (;;)
    {
      if (l2 != l1) {
        if (!paramSubscriber.isUnsubscribed()) {}
      }
      label86:
      do
      {
        do
        {
          return;
          Object localObject = paramQueue.poll();
          if (localObject == null)
          {
            paramSubscriber.onCompleted();
            return;
          }
          paramSubscriber.onNext(localObject);
          l2 += 1L;
          break;
          if (l2 != l1) {
            break label86;
          }
        } while (paramSubscriber.isUnsubscribed());
        if (paramQueue.isEmpty())
        {
          paramSubscriber.onCompleted();
          return;
        }
        long l3 = paramAtomicLong.get();
        l1 = l3;
        if (l3 != l2) {
          break;
        }
        l1 = paramAtomicLong.addAndGet(-(l2 & 0xFFFFFFFF));
      } while (l1 == -9223372036854775808L);
      l2 = -9223372036854775808L;
    }
  }
  
  public static <T> boolean postCompleteRequest(AtomicLong paramAtomicLong, long paramLong, Queue<T> paramQueue, Subscriber<? super T> paramSubscriber)
  {
    if (paramLong < 0L) {
      throw new IllegalArgumentException("n >= 0 required but it was " + paramLong);
    }
    if (paramLong == 0L) {
      return (paramAtomicLong.get() & 0x0) == 0L;
    }
    long l1;
    long l2;
    do
    {
      l1 = paramAtomicLong.get();
      l2 = 0x0 & l1;
    } while (!paramAtomicLong.compareAndSet(l1, addCap(0xFFFFFFFF & l1, paramLong) | l2));
    if (l1 == -9223372036854775808L)
    {
      postCompleteDrain(paramAtomicLong, paramQueue, paramSubscriber);
      return false;
    }
    return l2 == 0L;
  }
  
  public static long produced(AtomicLong paramAtomicLong, long paramLong)
  {
    long l1;
    long l2;
    do
    {
      l1 = paramAtomicLong.get();
      if (l1 == 9223372036854775807L) {
        return 9223372036854775807L;
      }
      l2 = l1 - paramLong;
      if (l2 < 0L) {
        throw new IllegalStateException("More produced than requested: " + l2);
      }
    } while (!paramAtomicLong.compareAndSet(l1, l2));
    return l2;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     rx.internal.operators.BackpressureUtils
 * JD-Core Version:    0.7.0.1
 */