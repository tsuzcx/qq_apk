package moai.storage;

import com.google.common.base.Function;
import com.google.common.base.Optional;

class Cache$CacheWrapper$2
  implements Function<Optional<T>, T>
{
  Cache$CacheWrapper$2(Cache.CacheWrapper paramCacheWrapper) {}
  
  public T apply(Optional<T> paramOptional)
  {
    return (Domain)paramOptional.orNull();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     moai.storage.Cache.CacheWrapper.2
 * JD-Core Version:    0.7.0.1
 */