package com.google.common.cache;

final class CacheBuilder$1
  implements AbstractCache.StatsCounter
{
  public void recordEviction() {}
  
  public void recordHits(int paramInt) {}
  
  public void recordLoadException(long paramLong) {}
  
  public void recordLoadSuccess(long paramLong) {}
  
  public void recordMisses(int paramInt) {}
  
  public CacheStats snapshot()
  {
    return CacheBuilder.EMPTY_STATS;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     com.google.common.cache.CacheBuilder.1
 * JD-Core Version:    0.7.0.1
 */