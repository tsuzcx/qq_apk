package rx.internal.operators;

import java.util.Iterator;
import java.util.Queue;
import java.util.concurrent.atomic.AtomicInteger;
import rx.Completable;
import rx.Completable.CompletableOnSubscribe;
import rx.Completable.CompletableSubscriber;
import rx.internal.util.unsafe.MpscLinkedQueue;
import rx.subscriptions.CompositeSubscription;

public final class CompletableOnSubscribeMergeDelayErrorIterable
  implements Completable.CompletableOnSubscribe
{
  final Iterable<? extends Completable> sources;
  
  public CompletableOnSubscribeMergeDelayErrorIterable(Iterable<? extends Completable> paramIterable)
  {
    this.sources = paramIterable;
  }
  
  public void call(Completable.CompletableSubscriber paramCompletableSubscriber)
  {
    CompositeSubscription localCompositeSubscription = new CompositeSubscription();
    AtomicInteger localAtomicInteger = new AtomicInteger(1);
    MpscLinkedQueue localMpscLinkedQueue = new MpscLinkedQueue();
    paramCompletableSubscriber.onSubscribe(localCompositeSubscription);
    label76:
    label100:
    do
    {
      for (;;)
      {
        Iterator localIterator;
        try
        {
          localIterator = this.sources.iterator();
          if (localIterator != null) {
            break label100;
          }
          paramCompletableSubscriber.onError(new NullPointerException("The source iterator returned is null"));
          return;
        }
        catch (Throwable localThrowable1)
        {
          paramCompletableSubscriber.onError(localThrowable1);
          return;
        }
        localThrowable1.getAndIncrement();
        Completable localCompletable;
        localCompletable.subscribe(new CompletableOnSubscribeMergeDelayErrorIterable.1(this, localCompositeSubscription, localMpscLinkedQueue, localThrowable1, paramCompletableSubscriber));
        if (!localCompositeSubscription.isUnsubscribed())
        {
          try
          {
            boolean bool = localIterator.hasNext();
            if (bool) {
              break label192;
            }
            if (localThrowable1.decrementAndGet() != 0) {
              continue;
            }
            if (!localMpscLinkedQueue.isEmpty()) {
              break label326;
            }
            paramCompletableSubscriber.onCompleted();
            return;
          }
          catch (Throwable localThrowable2)
          {
            localMpscLinkedQueue.offer(localThrowable2);
          }
          if (localThrowable1.decrementAndGet() == 0)
          {
            if (localMpscLinkedQueue.isEmpty())
            {
              paramCompletableSubscriber.onCompleted();
              return;
            }
            paramCompletableSubscriber.onError(CompletableOnSubscribeMerge.collectErrors(localMpscLinkedQueue));
            return;
            if (!localThrowable2.isUnsubscribed()) {
              try
              {
                localCompletable = (Completable)localIterator.next();
                if (!localThrowable2.isUnsubscribed())
                {
                  if (localCompletable != null) {
                    break label76;
                  }
                  localMpscLinkedQueue.offer(new NullPointerException("A completable source is null"));
                  if (localThrowable1.decrementAndGet() == 0)
                  {
                    if (!localMpscLinkedQueue.isEmpty()) {
                      break label314;
                    }
                    paramCompletableSubscriber.onCompleted();
                    return;
                  }
                }
              }
              catch (Throwable localThrowable3)
              {
                localMpscLinkedQueue.offer(localThrowable3);
              }
            }
          }
        }
      }
    } while (localThrowable1.decrementAndGet() != 0);
    label192:
    if (localMpscLinkedQueue.isEmpty())
    {
      paramCompletableSubscriber.onCompleted();
      return;
    }
    paramCompletableSubscriber.onError(CompletableOnSubscribeMerge.collectErrors(localMpscLinkedQueue));
    return;
    label314:
    paramCompletableSubscriber.onError(CompletableOnSubscribeMerge.collectErrors(localMpscLinkedQueue));
    return;
    label326:
    paramCompletableSubscriber.onError(CompletableOnSubscribeMerge.collectErrors(localMpscLinkedQueue));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     rx.internal.operators.CompletableOnSubscribeMergeDelayErrorIterable
 * JD-Core Version:    0.7.0.1
 */