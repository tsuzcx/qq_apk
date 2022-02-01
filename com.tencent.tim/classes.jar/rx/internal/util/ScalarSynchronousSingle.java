package rx.internal.util;

import rx.Scheduler;
import rx.Scheduler.Worker;
import rx.Single;
import rx.Single.OnSubscribe;
import rx.SingleSubscriber;
import rx.functions.Action0;
import rx.functions.Func1;
import rx.internal.schedulers.EventLoopsScheduler;

public final class ScalarSynchronousSingle<T>
  extends Single<T>
{
  final T value;
  
  protected ScalarSynchronousSingle(T paramT)
  {
    super(new ScalarSynchronousSingle.1(paramT));
    this.value = paramT;
  }
  
  public static final <T> ScalarSynchronousSingle<T> create(T paramT)
  {
    return new ScalarSynchronousSingle(paramT);
  }
  
  public T get()
  {
    return this.value;
  }
  
  public <R> Single<R> scalarFlatMap(Func1<? super T, ? extends Single<? extends R>> paramFunc1)
  {
    return create(new ScalarSynchronousSingle.2(this, paramFunc1));
  }
  
  public Single<T> scalarScheduleOn(Scheduler paramScheduler)
  {
    if ((paramScheduler instanceof EventLoopsScheduler)) {
      return create(new DirectScheduledEmission((EventLoopsScheduler)paramScheduler, this.value));
    }
    return create(new NormalScheduledEmission(paramScheduler, this.value));
  }
  
  static final class DirectScheduledEmission<T>
    implements Single.OnSubscribe<T>
  {
    private final EventLoopsScheduler es;
    private final T value;
    
    DirectScheduledEmission(EventLoopsScheduler paramEventLoopsScheduler, T paramT)
    {
      this.es = paramEventLoopsScheduler;
      this.value = paramT;
    }
    
    public void call(SingleSubscriber<? super T> paramSingleSubscriber)
    {
      paramSingleSubscriber.add(this.es.scheduleDirect(new ScalarSynchronousSingle.ScalarSynchronousSingleAction(paramSingleSubscriber, this.value)));
    }
  }
  
  static final class NormalScheduledEmission<T>
    implements Single.OnSubscribe<T>
  {
    private final Scheduler scheduler;
    private final T value;
    
    NormalScheduledEmission(Scheduler paramScheduler, T paramT)
    {
      this.scheduler = paramScheduler;
      this.value = paramT;
    }
    
    public void call(SingleSubscriber<? super T> paramSingleSubscriber)
    {
      Scheduler.Worker localWorker = this.scheduler.createWorker();
      paramSingleSubscriber.add(localWorker);
      localWorker.schedule(new ScalarSynchronousSingle.ScalarSynchronousSingleAction(paramSingleSubscriber, this.value));
    }
  }
  
  static final class ScalarSynchronousSingleAction<T>
    implements Action0
  {
    private final SingleSubscriber<? super T> subscriber;
    private final T value;
    
    ScalarSynchronousSingleAction(SingleSubscriber<? super T> paramSingleSubscriber, T paramT)
    {
      this.subscriber = paramSingleSubscriber;
      this.value = paramT;
    }
    
    public void call()
    {
      try
      {
        this.subscriber.onSuccess(this.value);
        return;
      }
      catch (Throwable localThrowable)
      {
        this.subscriber.onError(localThrowable);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     rx.internal.util.ScalarSynchronousSingle
 * JD-Core Version:    0.7.0.1
 */