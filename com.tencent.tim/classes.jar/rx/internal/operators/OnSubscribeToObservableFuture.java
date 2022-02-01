package rx.internal.operators;

import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import rx.Observable.OnSubscribe;
import rx.Subscriber;
import rx.exceptions.Exceptions;
import rx.subscriptions.Subscriptions;

public final class OnSubscribeToObservableFuture
{
  private OnSubscribeToObservableFuture()
  {
    throw new IllegalStateException("No instances!");
  }
  
  public static <T> Observable.OnSubscribe<T> toObservableFuture(Future<? extends T> paramFuture)
  {
    return new ToObservableFuture(paramFuture);
  }
  
  public static <T> Observable.OnSubscribe<T> toObservableFuture(Future<? extends T> paramFuture, long paramLong, TimeUnit paramTimeUnit)
  {
    return new ToObservableFuture(paramFuture, paramLong, paramTimeUnit);
  }
  
  static class ToObservableFuture<T>
    implements Observable.OnSubscribe<T>
  {
    final Future<? extends T> that;
    private final long time;
    private final TimeUnit unit;
    
    public ToObservableFuture(Future<? extends T> paramFuture)
    {
      this.that = paramFuture;
      this.time = 0L;
      this.unit = null;
    }
    
    public ToObservableFuture(Future<? extends T> paramFuture, long paramLong, TimeUnit paramTimeUnit)
    {
      this.that = paramFuture;
      this.time = paramLong;
      this.unit = paramTimeUnit;
    }
    
    public void call(Subscriber<? super T> paramSubscriber)
    {
      paramSubscriber.add(Subscriptions.create(new OnSubscribeToObservableFuture.ToObservableFuture.1(this)));
      try
      {
        if (paramSubscriber.isUnsubscribed()) {
          return;
        }
        if (this.unit != null) {
          break label64;
        }
        localObject1 = this.that.get();
      }
      catch (Throwable localThrowable)
      {
        Object localObject1;
        while (!paramSubscriber.isUnsubscribed())
        {
          Exceptions.throwOrReport(localThrowable, paramSubscriber);
          return;
          Object localObject2 = this.that.get(this.time, this.unit);
        }
      }
      paramSubscriber.onNext(localObject1);
      paramSubscriber.onCompleted();
      return;
      label64:
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     rx.internal.operators.OnSubscribeToObservableFuture
 * JD-Core Version:    0.7.0.1
 */