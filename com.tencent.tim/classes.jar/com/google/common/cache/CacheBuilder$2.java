package com.google.common.cache;

import com.google.common.base.Supplier;

final class CacheBuilder$2
  implements Supplier<AbstractCache.StatsCounter>
{
  public AbstractCache.StatsCounter get()
  {
    return new AbstractCache.SimpleStatsCounter();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     com.google.common.cache.CacheBuilder.2
 * JD-Core Version:    0.7.0.1
 */