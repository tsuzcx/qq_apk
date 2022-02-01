package com.google.common.cache;

import com.google.common.base.Equivalence;

 enum LocalCache$Strength$2
{
  LocalCache$Strength$2()
  {
    super(str, i, null);
  }
  
  Equivalence<Object> defaultEquivalence()
  {
    return Equivalence.identity();
  }
  
  <K, V> LocalCache.ValueReference<K, V> referenceValue(LocalCache.Segment<K, V> paramSegment, LocalCache.ReferenceEntry<K, V> paramReferenceEntry, V paramV, int paramInt)
  {
    if (paramInt == 1) {
      return new LocalCache.SoftValueReference(paramSegment.valueReferenceQueue, paramV, paramReferenceEntry);
    }
    return new LocalCache.WeightedSoftValueReference(paramSegment.valueReferenceQueue, paramV, paramReferenceEntry, paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     com.google.common.cache.LocalCache.Strength.2
 * JD-Core Version:    0.7.0.1
 */