package com.squareup.okhttp;

import com.squareup.okhttp.internal.InternalCache;
import com.squareup.okhttp.internal.http.CacheRequest;
import com.squareup.okhttp.internal.http.CacheStrategy;
import java.io.IOException;

class Cache$1
  implements InternalCache
{
  Cache$1(Cache paramCache) {}
  
  public Response get(Request paramRequest)
    throws IOException
  {
    return this.this$0.get(paramRequest);
  }
  
  public CacheRequest put(Response paramResponse)
    throws IOException
  {
    return Cache.access$000(this.this$0, paramResponse);
  }
  
  public void remove(Request paramRequest)
    throws IOException
  {
    Cache.access$100(this.this$0, paramRequest);
  }
  
  public void trackConditionalCacheHit()
  {
    Cache.access$300(this.this$0);
  }
  
  public void trackResponse(CacheStrategy paramCacheStrategy)
  {
    Cache.access$400(this.this$0, paramCacheStrategy);
  }
  
  public void update(Response paramResponse1, Response paramResponse2)
    throws IOException
  {
    Cache.access$200(this.this$0, paramResponse1, paramResponse2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     com.squareup.okhttp.Cache.1
 * JD-Core Version:    0.7.0.1
 */