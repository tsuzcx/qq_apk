package com.google.common.cache;

import com.google.common.collect.AbstractSequentialIterator;

class LocalCache$WriteQueue$2
  extends AbstractSequentialIterator<LocalCache.ReferenceEntry<K, V>>
{
  LocalCache$WriteQueue$2(LocalCache.WriteQueue paramWriteQueue, LocalCache.ReferenceEntry paramReferenceEntry)
  {
    super(paramReferenceEntry);
  }
  
  protected LocalCache.ReferenceEntry<K, V> computeNext(LocalCache.ReferenceEntry<K, V> paramReferenceEntry)
  {
    LocalCache.ReferenceEntry localReferenceEntry = paramReferenceEntry.getNextInWriteQueue();
    paramReferenceEntry = localReferenceEntry;
    if (localReferenceEntry == this.this$0.head) {
      paramReferenceEntry = null;
    }
    return paramReferenceEntry;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     com.google.common.cache.LocalCache.WriteQueue.2
 * JD-Core Version:    0.7.0.1
 */