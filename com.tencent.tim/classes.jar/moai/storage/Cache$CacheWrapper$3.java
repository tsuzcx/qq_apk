package moai.storage;

import java.util.List;
import java.util.concurrent.ExecutionException;
import rx.Observable.OnSubscribe;
import rx.Subscriber;

class Cache$CacheWrapper$3
  implements Observable.OnSubscribe<List<T>>
{
  Cache$CacheWrapper$3(Cache.CacheWrapper paramCacheWrapper, Iterable paramIterable) {}
  
  public void call(Subscriber<? super List<T>> paramSubscriber)
  {
    try
    {
      paramSubscriber.onNext(this.this$0.list(this.val$ids));
      paramSubscriber.onCompleted();
      return;
    }
    catch (ExecutionException localExecutionException)
    {
      paramSubscriber.onError(localExecutionException);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     moai.storage.Cache.CacheWrapper.3
 * JD-Core Version:    0.7.0.1
 */