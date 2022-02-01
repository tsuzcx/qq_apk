package com.tencent.oskplayer.cache;

import java.io.File;

public class CacheListener
  implements Cache.Listener
{
  private File mCacheFile;
  private int mElapsedMs;
  private String mVideoKey;
  
  public CacheListener(String paramString, int paramInt)
  {
    this.mVideoKey = paramString;
    this.mElapsedMs = paramInt;
  }
  
  public void onSpanAdded(Cache paramCache, CacheSpan paramCacheSpan)
  {
    if (paramCacheSpan != null)
    {
      this.mCacheFile = paramCacheSpan.file;
      paramCache.removeListener(this.mVideoKey, this);
    }
  }
  
  public void onSpanRemoved(Cache paramCache, CacheSpan paramCacheSpan) {}
  
  public void onSpanTouched(Cache paramCache, CacheSpan paramCacheSpan1, CacheSpan paramCacheSpan2) {}
  
  public void setFileLastModified(int paramInt)
  {
    if (this.mCacheFile != null) {
      this.mCacheFile.setLastModified(paramInt);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.oskplayer.cache.CacheListener
 * JD-Core Version:    0.7.0.1
 */