package com.google.common.cache;

class LocalCache$WriteQueue$1
  extends LocalCache.AbstractReferenceEntry<K, V>
{
  LocalCache.ReferenceEntry<K, V> nextWrite = this;
  LocalCache.ReferenceEntry<K, V> previousWrite = this;
  
  LocalCache$WriteQueue$1(LocalCache.WriteQueue paramWriteQueue) {}
  
  public LocalCache.ReferenceEntry<K, V> getNextInWriteQueue()
  {
    return this.nextWrite;
  }
  
  public LocalCache.ReferenceEntry<K, V> getPreviousInWriteQueue()
  {
    return this.previousWrite;
  }
  
  public long getWriteTime()
  {
    return 9223372036854775807L;
  }
  
  public void setNextInWriteQueue(LocalCache.ReferenceEntry<K, V> paramReferenceEntry)
  {
    this.nextWrite = paramReferenceEntry;
  }
  
  public void setPreviousInWriteQueue(LocalCache.ReferenceEntry<K, V> paramReferenceEntry)
  {
    this.previousWrite = paramReferenceEntry;
  }
  
  public void setWriteTime(long paramLong) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     com.google.common.cache.LocalCache.WriteQueue.1
 * JD-Core Version:    0.7.0.1
 */