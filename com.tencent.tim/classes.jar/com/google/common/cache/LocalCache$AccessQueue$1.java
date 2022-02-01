package com.google.common.cache;

class LocalCache$AccessQueue$1
  extends LocalCache.AbstractReferenceEntry<K, V>
{
  LocalCache.ReferenceEntry<K, V> nextAccess = this;
  LocalCache.ReferenceEntry<K, V> previousAccess = this;
  
  LocalCache$AccessQueue$1(LocalCache.AccessQueue paramAccessQueue) {}
  
  public long getAccessTime()
  {
    return 9223372036854775807L;
  }
  
  public LocalCache.ReferenceEntry<K, V> getNextInAccessQueue()
  {
    return this.nextAccess;
  }
  
  public LocalCache.ReferenceEntry<K, V> getPreviousInAccessQueue()
  {
    return this.previousAccess;
  }
  
  public void setAccessTime(long paramLong) {}
  
  public void setNextInAccessQueue(LocalCache.ReferenceEntry<K, V> paramReferenceEntry)
  {
    this.nextAccess = paramReferenceEntry;
  }
  
  public void setPreviousInAccessQueue(LocalCache.ReferenceEntry<K, V> paramReferenceEntry)
  {
    this.previousAccess = paramReferenceEntry;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     com.google.common.cache.LocalCache.AccessQueue.1
 * JD-Core Version:    0.7.0.1
 */