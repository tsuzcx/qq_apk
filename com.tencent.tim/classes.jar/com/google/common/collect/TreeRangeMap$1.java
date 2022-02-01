package com.google.common.collect;

import com.google.common.base.Preconditions;
import java.util.Collections;
import java.util.Map;
import java.util.Map.Entry;
import java.util.NoSuchElementException;
import javax.annotation.Nullable;

final class TreeRangeMap$1
  implements RangeMap
{
  public Map<Range, Object> asDescendingMapOfRanges()
  {
    return Collections.emptyMap();
  }
  
  public Map<Range, Object> asMapOfRanges()
  {
    return Collections.emptyMap();
  }
  
  public void clear() {}
  
  @Nullable
  public Object get(Comparable paramComparable)
  {
    return null;
  }
  
  @Nullable
  public Map.Entry<Range, Object> getEntry(Comparable paramComparable)
  {
    return null;
  }
  
  public void put(Range paramRange, Object paramObject)
  {
    Preconditions.checkNotNull(paramRange);
    throw new IllegalArgumentException("Cannot insert range " + paramRange + " into an empty subRangeMap");
  }
  
  public void putAll(RangeMap paramRangeMap)
  {
    if (!paramRangeMap.asMapOfRanges().isEmpty()) {
      throw new IllegalArgumentException("Cannot putAll(nonEmptyRangeMap) into an empty subRangeMap");
    }
  }
  
  public void remove(Range paramRange)
  {
    Preconditions.checkNotNull(paramRange);
  }
  
  public Range span()
  {
    throw new NoSuchElementException();
  }
  
  public RangeMap subRangeMap(Range paramRange)
  {
    Preconditions.checkNotNull(paramRange);
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     com.google.common.collect.TreeRangeMap.1
 * JD-Core Version:    0.7.0.1
 */