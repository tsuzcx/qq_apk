package rx.internal.operators;

import rx.Subscriber;

class CachedObservable$CacheState$1
  extends Subscriber<T>
{
  CachedObservable$CacheState$1(CachedObservable.CacheState paramCacheState) {}
  
  public void onCompleted()
  {
    this.this$0.onCompleted();
  }
  
  public void onError(Throwable paramThrowable)
  {
    this.this$0.onError(paramThrowable);
  }
  
  public void onNext(T paramT)
  {
    this.this$0.onNext(paramT);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     rx.internal.operators.CachedObservable.CacheState.1
 * JD-Core Version:    0.7.0.1
 */