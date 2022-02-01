package retrofit;

import java.util.concurrent.Executor;
import rx.Observable;
import rx.Subscriber;
import rx.functions.Func1;

final class RxSupport
{
  private final ErrorHandler errorHandler;
  private final Executor executor;
  private final RequestInterceptor requestInterceptor;
  private final RxHandler retryHandler;
  
  RxSupport(Executor paramExecutor, ErrorHandler paramErrorHandler, RxHandler paramRxHandler, RequestInterceptor paramRequestInterceptor)
  {
    this.executor = paramExecutor;
    this.errorHandler = paramErrorHandler;
    this.retryHandler = paramRxHandler;
    this.requestInterceptor = paramRequestInterceptor;
  }
  
  private Runnable getRunnable(Subscriber<? super Object> paramSubscriber, Invoker paramInvoker, RequestInterceptorTape paramRequestInterceptorTape)
  {
    return new RxSupport.3(this, paramSubscriber, paramInvoker, paramRequestInterceptorTape);
  }
  
  Observable createRequestObservable(Invoker paramInvoker)
  {
    Observable localObservable1 = Observable.create(new RxSupport.1(this, paramInvoker));
    if (this.retryHandler == null) {
      return localObservable1;
    }
    Observable localObservable2 = this.retryHandler.onBefore(localObservable1);
    paramInvoker = localObservable1;
    if (localObservable2 != null) {
      paramInvoker = localObservable2.flatMap(new RxSupport.2(this, localObservable1));
    }
    return paramInvoker.retryWhen(new RetryWithHandler(this.retryHandler, 1));
  }
  
  static abstract interface Invoker
  {
    public abstract ResponseWrapper invoke(RequestInterceptor paramRequestInterceptor);
  }
  
  static class RetryWithHandler
    implements Func1<Observable<? extends Throwable>, Observable<?>>
  {
    private final int maxRetries;
    private int retryCount;
    private final RxHandler retryHandler;
    
    RetryWithHandler(RxHandler paramRxHandler, int paramInt)
    {
      this.retryHandler = paramRxHandler;
      this.maxRetries = paramInt;
    }
    
    public Observable<Object> call(Observable<? extends Throwable> paramObservable)
    {
      return paramObservable.flatMap(new RxSupport.RetryWithHandler.1(this));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     retrofit.RxSupport
 * JD-Core Version:    0.7.0.1
 */