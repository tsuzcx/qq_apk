package rx;

import java.util.concurrent.Callable;
import rx.exceptions.Exceptions;

final class Single$25
  implements Single.OnSubscribe<T>
{
  Single$25(Callable paramCallable) {}
  
  public void call(SingleSubscriber<? super T> paramSingleSubscriber)
  {
    try
    {
      Single localSingle = (Single)this.val$singleFactory.call();
      localSingle.subscribe(paramSingleSubscriber);
      return;
    }
    catch (Throwable localThrowable)
    {
      Exceptions.throwIfFatal(localThrowable);
      paramSingleSubscriber.onError(localThrowable);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     rx.Single.25
 * JD-Core Version:    0.7.0.1
 */