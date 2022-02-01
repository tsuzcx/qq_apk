package moai.storage;

import android.util.Log;
import com.google.common.base.Optional;
import com.google.common.cache.CacheLoader;

final class Cache$2
  extends CacheLoader<Integer, Optional<Domain>>
{
  public Optional<Domain> load(Integer paramInteger)
    throws Exception
  {
    Log.d("Cache", "load: key:" + paramInteger);
    return Optional.absent();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     moai.storage.Cache.2
 * JD-Core Version:    0.7.0.1
 */