package com.squareup.okhttp;

import com.squareup.okhttp.internal.DiskLruCache.Snapshot;
import java.io.IOException;
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     com.squareup.okhttp.Cache.CacheResponseBody.1
 * JD-Core Version:    0.7.0.1
 */