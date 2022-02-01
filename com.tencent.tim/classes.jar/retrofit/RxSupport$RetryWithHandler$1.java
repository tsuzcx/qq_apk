package retrofit;

import rx.Observable;
import rx.functions.Func1;

class RxSupport$RetryWithHandler$1
  implements Func1<Throwable, Observable<?>>
{
  RxSupport$RetryWithHandler$1(RxSupport.RetryWithHandler paramRetryWithHandler) {}
  
  public Observable<?> call(Throwable paramThrowable)
  {
    if ((RxSupport.RetryWithHandler.access$008(this.this$0) < RxSupport.RetryWithHandler.access$100(this.this$0)) && ((paramThrowable instanceof RetryError))) {
      return RxSupport.RetryWithHandler.access$200(this.this$0).onRetry(paramThrowable);
    }
    return Observable.error(paramThrowable);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     retrofit.RxSupport.RetryWithHandler.1
 * JD-Core Version:    0.7.0.1
 */