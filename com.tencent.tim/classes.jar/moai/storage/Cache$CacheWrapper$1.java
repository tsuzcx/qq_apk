package moai.storage;

import com.google.common.base.Optional;
import com.google.common.cache.LoadingCache;
import rx.Observable.OnSubscribe;
import rx.Subscriber;

class Cache$CacheWrapper$1
  implements Observable.OnSubscribe<T>
{
  Cache$CacheWrapper$1(Cache.CacheWrapper paramCacheWrapper, int paramInt) {}
  
  public void call(Subscriber<? super T> paramSubscriber)
  {
    paramSubscriber.onNext(((Optional)this.this$0.loadingCache.getUnchecked(Integer.valueOf(this.val$key))).orNull());
    paramSubscriber.onCompleted();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     moai.storage.Cache.CacheWrapper.1
 * JD-Core Version:    0.7.0.1
 */