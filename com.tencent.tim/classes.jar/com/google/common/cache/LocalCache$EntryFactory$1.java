package com.google.common.cache;

import javax.annotation.Nullable;

 enum LocalCache$EntryFactory$1
{
  LocalCache$EntryFactory$1()
  {
    super(str, i, null);
  }
  
  <K, V> LocalCache.ReferenceEntry<K, V> newEntry(LocalCache.Segment<K, V> paramSegment, K paramK, int paramInt, @Nullable LocalCache.ReferenceEntry<K, V> paramReferenceEntry)
  {
    return new LocalCache.StrongEntry(paramK, paramInt, paramReferenceEntry);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     com.google.common.cache.LocalCache.EntryFactory.1
 * JD-Core Version:    0.7.0.1
 */