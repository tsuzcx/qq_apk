package rx.internal.operators;

import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import rx.Completable;
import rx.Completable.CompletableOnSubscribe;
import rx.Completable.CompletableSubscriber;
import rx.Observable;
import rx.Subscriber;
import rx.exceptions.CompositeException;
import rx.plugins.RxJavaErrorHandler;
import rx.plugins.RxJavaPlugins;
import rx.subscriptions.CompositeSubscription;

public final class CompletableOnSubscribeMerge
  implements Completable.CompletableOnSubscribe
{
  final boolean delayErrors;
  final int maxConcurrency;
  final Observable<? extends Completable> source;
  
  public CompletableOnSubscribeMerge(Observable<? extends Completable> paramObservable, int paramInt, boolean paramBoolean)
  {
    this.source = paramObservable;
    this.maxConcurrency = paramInt;
    this.delayErrors = paramBoolean;
  }
  
  public static Throwable collectErrors(Queue<Throwable> paramQueue)
  {
    ArrayList localArrayList = new ArrayList();
    for (;;)
    {
      Throwable localThrowable = (Throwable)paramQueue.poll();
      if (localThrowable == null) {
        break;
      }
      localArrayList.add(localThrowable);
    }
    if (localArrayList.isEmpty()) {
      return null;
    }
    if (localArrayList.size() == 1) {
      return (Throwable)localArrayList.get(0);
    }
    return new CompositeException(localArrayList);
  }
  
  public void call(Completable.CompletableSubscriber paramCompletableSubscriber)
  {
    CompletableMergeSubscriber localCompletableMergeSubscriber = new CompletableMergeSubscriber(paramCompletableSubscriber, this.maxConcurrency, this.delayErrors);
    paramCompletableSubscriber.onSubscribe(localCompletableMergeSubscriber);
    this.source.subscribe(localCompletableMergeSubscriber);
  }
  
  static final class CompletableMergeSubscriber
    extends Subscriber<Completable>
  {
    static final AtomicReferenceFieldUpdater<CompletableMergeSubscriber, Queue> ERRORS = AtomicReferenceFieldUpdater.newUpdater(CompletableMergeSubscriber.class, Queue.class, "errors");
    static final AtomicIntegerFieldUpdater<CompletableMergeSubscriber> ONCE = AtomicIntegerFieldUpdater.newUpdater(CompletableMergeSubscriber.class, "once");
    final Completable.CompletableSubscriber actual;
    final boolean delayErrors;
    volatile boolean done;
    volatile Queue<Throwable> errors;
    final int maxConcurrency;
    volatile int once;
    final CompositeSubscription set;
    final AtomicInteger wip;
    
    public CompletableMergeSubscriber(Completable.CompletableSubscriber paramCompletableSubscriber, int paramInt, boolean paramBoolean)
    {
      this.actual = paramCompletableSubscriber;
      this.maxConcurrency = paramInt;
      this.delayErrors = paramBoolean;
      this.set = new CompositeSubscription();
      this.wip = new AtomicInteger(1);
      if (paramInt == 2147483647)
      {
        request(9223372036854775807L);
        return;
      }
      request(paramInt);
    }
    
    Queue<Throwable> getOrCreateErrors()
    {
      Object localObject = this.errors;
      if (localObject != null) {}
      ConcurrentLinkedQueue localConcurrentLinkedQueue;
      do
      {
        return localObject;
        localConcurrentLinkedQueue = new ConcurrentLinkedQueue();
        localObject = localConcurrentLinkedQueue;
      } while (ERRORS.compareAndSet(this, null, localConcurrentLinkedQueue));
      return this.errors;
    }
    
    public void onCompleted()
    {
      if (this.done) {
        return;
      }
      this.done = true;
      terminate();
    }
    
    public void onError(Throwable paramThrowable)
    {
      if (this.done)
      {
        RxJavaPlugins.getInstance().getErrorHandler().handleError(paramThrowable);
        return;
      }
      getOrCreateErrors().offer(paramThrowable);
      this.done = true;
      terminate();
    }
    
    public void onNext(Completable paramCompletable)
    {
      if (this.done) {
        return;
      }
      this.wip.getAndIncrement();
      paramCompletable.subscribe(new CompletableOnSubscribeMerge.CompletableMergeSubscriber.1(this));
    }
    
    void terminate()
    {
      if (this.wip.decrementAndGet() == 0)
      {
        localObject = this.errors;
        if ((localObject == null) || (((Queue)localObject).isEmpty())) {
          this.actual.onCompleted();
        }
      }
      do
      {
        do
        {
          return;
          localObject = CompletableOnSubscribeMerge.collectErrors((Queue)localObject);
          if (ONCE.compareAndSet(this, 0, 1))
          {
            this.actual.onError((Throwable)localObject);
            return;
          }
          RxJavaPlugins.getInstance().getErrorHandler().handleError((Throwable)localObject);
          return;
        } while (this.delayErrors);
        localObject = this.errors;
      } while ((localObject == null) || (((Queue)localObject).isEmpty()));
      Object localObject = CompletableOnSubscribeMerge.collectErrors((Queue)localObject);
      if (ONCE.compareAndSet(this, 0, 1))
      {
        this.actual.onError((Throwable)localObject);
        return;
      }
      RxJavaPlugins.getInstance().getErrorHandler().handleError((Throwable)localObject);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     rx.internal.operators.CompletableOnSubscribeMerge
 * JD-Core Version:    0.7.0.1
 */