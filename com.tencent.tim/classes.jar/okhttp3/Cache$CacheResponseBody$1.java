package okhttp3;

import java.io.IOException;
import okhttp3.internal.cache.DiskLruCache.Snapshot;
import okio.ForwardingSource;
import okio.Source;

class Cache$CacheResponseBody$1
  extends ForwardingSource
{
  Cache$CacheResponseBody$1(Cache.CacheResponseBody paramCacheResponseBody, Source paramSource, DiskLruCache.Snapshot paramSnapshot)
  {
    super(paramSource);
  }
  
  public void close()
    throws IOException
  {
    this.val$snapshot.close();
    super.close();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     okhttp3.Cache.CacheResponseBody.1
 * JD-Core Version:    0.7.0.1
 */