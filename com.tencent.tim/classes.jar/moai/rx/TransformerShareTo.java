package moai.rx;

import android.util.Log;
import com.google.common.cache.Cache;
import com.google.common.cache.CacheBuilder;
import com.google.common.cache.LoadingCache;
import rx.Observable;
import rx.Observable.Transformer;

public class TransformerShareTo<K, T>
  implements Observable.Transformer<T, T>
{
  static final LoadingCache<String, Cache> shares = CacheBuilder.newBuilder().build(new TransformerShareTo.1());
  private final K key;
  private final String name;
  private final Cache<K, Observable<T>> shared;
  
  public TransformerShareTo(K paramK)
  {
    this("Default", paramK);
  }
  
  public TransformerShareTo(String paramString, K paramK)
  {
    this.name = paramString;
    this.key = paramK;
    this.shared = ((Cache)shares.getUnchecked(paramString));
  }
  
  public Observable<T> call(Observable<T> paramObservable)
  {
    Observable localObservable = (Observable)this.shared.getIfPresent(this.key);
    String str = this.name;
    if (localObservable != null) {}
    for (Object localObject = "shared";; localObject = "newobs")
    {
      Log.d("shareTo", String.format("[%s] %s => %s", new Object[] { str, localObject, this.key }));
      localObject = localObservable;
      if (localObservable == null)
      {
        localObject = paramObservable.cache().doAfterTerminate(new TransformerShareTo.2(this));
        this.shared.put(this.key, localObject);
      }
      return localObject;
    }
  }
  
  protected void invalidateKey(Object paramObject)
  {
    this.shared.invalidate(paramObject);
  }
  
  public String name()
  {
    return this.name;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     moai.rx.TransformerShareTo
 * JD-Core Version:    0.7.0.1
 */