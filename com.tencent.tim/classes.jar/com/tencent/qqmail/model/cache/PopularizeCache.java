package com.tencent.qqmail.model.cache;

import com.tencent.qqmail.popularize.model.Popularize;

public class PopularizeCache
  extends QMReadWriteCache<Integer, Popularize>
{
  public Integer getKeyByItem(Popularize paramPopularize)
  {
    return Integer.valueOf(paramPopularize.getId());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.model.cache.PopularizeCache
 * JD-Core Version:    0.7.0.1
 */