package com.google.common.collect;

import com.google.common.annotations.Beta;
import com.google.common.annotations.GwtIncompatible;
import com.google.common.base.MoreObjects;
import com.google.common.base.Preconditions;
import com.google.common.base.Predicate;
import java.util.AbstractMap;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.NavigableMap;
import java.util.NoSuchElementException;
import java.util.Set;
import java.util.SortedMap;
import javax.annotation.Nullable;

@Beta
@GwtIncompatible
public final class TreeRangeMap<K extends Comparable, V>
  implements RangeMap<K, V>
{
  private static final RangeMap EMPTY_SUB_RANGE_MAP = new TreeRangeMap.1();
  private final NavigableMap<Cut<K>, RangeMapEntry<K, V>> entriesByLowerBound = Maps.newTreeMap();
  
  public static <K extends Comparable, V> TreeRangeMap<K, V> create()
  {
    return new TreeRangeMap();
  }
  
  private RangeMap<K, V> emptySubRangeMap()
  {
    return EMPTY_SUB_RANGE_MAP;
  }
  
  private void putRangeMapEntry(Cut<K> paramCut1, Cut<K> paramCut2, V paramV)
  {
    this.entriesByLowerBound.put(paramCut1, new RangeMapEntry(paramCut1, paramCut2, paramV));
  }
  
  public Map<Range<K>, V> asDescendingMapOfRanges()
  {
    return new AsMapOfRanges(this.entriesByLowerBound.descendingMap().values());
  }
  
  public Map<Range<K>, V> asMapOfRanges()
  {
    return new AsMapOfRanges(this.entriesByLowerBound.values());
  }
  
  public void clear()
  {
    this.entriesByLowerBound.clear();
  }
  
  public boolean equals(@Nullable Object paramObject)
  {
    if ((paramObject instanceof RangeMap))
    {
      paramObject = (RangeMap)paramObject;
      return asMapOfRanges().equals(paramObject.asMapOfRanges());
    }
    return false;
  }
  
  @Nullable
  public V get(K paramK)
  {
    paramK = getEntry(paramK);
    if (paramK == null) {
      return null;
    }
    return paramK.getValue();
  }
  
  @Nullable
  public Map.Entry<Range<K>, V> getEntry(K paramK)
  {
    Map.Entry localEntry = this.entriesByLowerBound.floorEntry(Cut.belowValue(paramK));
    if ((localEntry != null) && (((RangeMapEntry)localEntry.getValue()).contains(paramK))) {
      return (Map.Entry)localEntry.getValue();
    }
    return null;
  }
  
  public int hashCode()
  {
    return asMapOfRanges().hashCode();
  }
  
  public void put(Range<K> paramRange, V paramV)
  {
    if (!paramRange.isEmpty())
    {
      Preconditions.checkNotNull(paramV);
      remove(paramRange);
      this.entriesByLowerBound.put(paramRange.lowerBound, new RangeMapEntry(paramRange, paramV));
    }
  }
  
  public void putAll(RangeMap<K, V> paramRangeMap)
  {
    paramRangeMap = paramRangeMap.asMapOfRanges().entrySet().iterator();
    while (paramRangeMap.hasNext())
    {
      Map.Entry localEntry = (Map.Entry)paramRangeMap.next();
      put((Range)localEntry.getKey(), localEntry.getValue());
    }
  }
  
  public void remove(Range<K> paramRange)
  {
    if (paramRange.isEmpty()) {
      return;
    }
    Map.Entry localEntry = this.entriesByLowerBound.lowerEntry(paramRange.lowerBound);
    RangeMapEntry localRangeMapEntry;
    if (localEntry != null)
    {
      localRangeMapEntry = (RangeMapEntry)localEntry.getValue();
      if (localRangeMapEntry.getUpperBound().compareTo(paramRange.lowerBound) > 0)
      {
        if (localRangeMapEntry.getUpperBound().compareTo(paramRange.upperBound) > 0) {
          putRangeMapEntry(paramRange.upperBound, localRangeMapEntry.getUpperBound(), ((RangeMapEntry)localEntry.getValue()).getValue());
        }
        putRangeMapEntry(localRangeMapEntry.getLowerBound(), paramRange.lowerBound, ((RangeMapEntry)localEntry.getValue()).getValue());
      }
    }
    localEntry = this.entriesByLowerBound.lowerEntry(paramRange.upperBound);
    if (localEntry != null)
    {
      localRangeMapEntry = (RangeMapEntry)localEntry.getValue();
      if (localRangeMapEntry.getUpperBound().compareTo(paramRange.upperBound) > 0)
      {
        putRangeMapEntry(paramRange.upperBound, localRangeMapEntry.getUpperBound(), ((RangeMapEntry)localEntry.getValue()).getValue());
        this.entriesByLowerBound.remove(paramRange.lowerBound);
      }
    }
    this.entriesByLowerBound.subMap(paramRange.lowerBound, paramRange.upperBound).clear();
  }
  
  public Range<K> span()
  {
    Map.Entry localEntry1 = this.entriesByLowerBound.firstEntry();
    Map.Entry localEntry2 = this.entriesByLowerBound.lastEntry();
    if (localEntry1 == null) {
      throw new NoSuchElementException();
    }
    return Range.create(((RangeMapEntry)localEntry1.getValue()).getKey().lowerBound, ((RangeMapEntry)localEntry2.getValue()).getKey().upperBound);
  }
  
  public RangeMap<K, V> subRangeMap(Range<K> paramRange)
  {
    if (paramRange.equals(Range.all())) {
      return this;
    }
    return new SubRangeMap(paramRange);
  }
  
  public String toString()
  {
    return this.entriesByLowerBound.values().toString();
  }
  
  final class AsMapOfRanges
    extends Maps.IteratorBasedAbstractMap<Range<K>, V>
  {
    final Iterable<Map.Entry<Range<K>, V>> entryIterable;
    
    AsMapOfRanges()
    {
      Object localObject;
      this.entryIterable = localObject;
    }
    
    public boolean containsKey(@Nullable Object paramObject)
    {
      return get(paramObject) != null;
    }
    
    Iterator<Map.Entry<Range<K>, V>> entryIterator()
    {
      return this.entryIterable.iterator();
    }
    
    public V get(@Nullable Object paramObject)
    {
      if ((paramObject instanceof Range))
      {
        paramObject = (Range)paramObject;
        TreeRangeMap.RangeMapEntry localRangeMapEntry = (TreeRangeMap.RangeMapEntry)TreeRangeMap.this.entriesByLowerBound.get(paramObject.lowerBound);
        if ((localRangeMapEntry != null) && (localRangeMapEntry.getKey().equals(paramObject))) {
          return localRangeMapEntry.getValue();
        }
      }
      return null;
    }
    
    public int size()
    {
      return TreeRangeMap.this.entriesByLowerBound.size();
    }
  }
  
  static final class RangeMapEntry<K extends Comparable, V>
    extends AbstractMapEntry<Range<K>, V>
  {
    private final Range<K> range;
    private final V value;
    
    RangeMapEntry(Cut<K> paramCut1, Cut<K> paramCut2, V paramV)
    {
      this(Range.create(paramCut1, paramCut2), paramV);
    }
    
    RangeMapEntry(Range<K> paramRange, V paramV)
    {
      this.range = paramRange;
      this.value = paramV;
    }
    
    public boolean contains(K paramK)
    {
      return this.range.contains(paramK);
    }
    
    public Range<K> getKey()
    {
      return this.range;
    }
    
    Cut<K> getLowerBound()
    {
      return this.range.lowerBound;
    }
    
    Cut<K> getUpperBound()
    {
      return this.range.upperBound;
    }
    
    public V getValue()
    {
      return this.value;
    }
  }
  
  class SubRangeMap
    implements RangeMap<K, V>
  {
    private final Range<K> subRange;
    
    SubRangeMap()
    {
      Object localObject;
      this.subRange = localObject;
    }
    
    public Map<Range<K>, V> asDescendingMapOfRanges()
    {
      return new TreeRangeMap.SubRangeMap.1(this);
    }
    
    public Map<Range<K>, V> asMapOfRanges()
    {
      return new SubRangeMapAsMap();
    }
    
    public void clear()
    {
      TreeRangeMap.this.remove(this.subRange);
    }
    
    public boolean equals(@Nullable Object paramObject)
    {
      if ((paramObject instanceof RangeMap))
      {
        paramObject = (RangeMap)paramObject;
        return asMapOfRanges().equals(paramObject.asMapOfRanges());
      }
      return false;
    }
    
    @Nullable
    public V get(K paramK)
    {
      if (this.subRange.contains(paramK)) {
        return TreeRangeMap.this.get(paramK);
      }
      return null;
    }
    
    @Nullable
    public Map.Entry<Range<K>, V> getEntry(K paramK)
    {
      if (this.subRange.contains(paramK))
      {
        paramK = TreeRangeMap.this.getEntry(paramK);
        if (paramK != null) {
          return Maps.immutableEntry(((Range)paramK.getKey()).intersection(this.subRange), paramK.getValue());
        }
      }
      return null;
    }
    
    public int hashCode()
    {
      return asMapOfRanges().hashCode();
    }
    
    public void put(Range<K> paramRange, V paramV)
    {
      Preconditions.checkArgument(this.subRange.encloses(paramRange), "Cannot put range %s into a subRangeMap(%s)", paramRange, this.subRange);
      TreeRangeMap.this.put(paramRange, paramV);
    }
    
    public void putAll(RangeMap<K, V> paramRangeMap)
    {
      if (paramRangeMap.asMapOfRanges().isEmpty()) {
        return;
      }
      Range localRange = paramRangeMap.span();
      Preconditions.checkArgument(this.subRange.encloses(localRange), "Cannot putAll rangeMap with span %s into a subRangeMap(%s)", localRange, this.subRange);
      TreeRangeMap.this.putAll(paramRangeMap);
    }
    
    public void remove(Range<K> paramRange)
    {
      if (paramRange.isConnected(this.subRange)) {
        TreeRangeMap.this.remove(paramRange.intersection(this.subRange));
      }
    }
    
    public Range<K> span()
    {
      Object localObject1 = TreeRangeMap.this.entriesByLowerBound.floorEntry(this.subRange.lowerBound);
      if ((localObject1 != null) && (((TreeRangeMap.RangeMapEntry)((Map.Entry)localObject1).getValue()).getUpperBound().compareTo(this.subRange.lowerBound) > 0)) {
        localObject1 = this.subRange.lowerBound;
      }
      for (;;)
      {
        Object localObject2 = TreeRangeMap.this.entriesByLowerBound.lowerEntry(this.subRange.upperBound);
        if (localObject2 == null)
        {
          throw new NoSuchElementException();
          localObject1 = (Cut)TreeRangeMap.this.entriesByLowerBound.ceilingKey(this.subRange.lowerBound);
          if ((localObject1 == null) || (((Cut)localObject1).compareTo(this.subRange.upperBound) >= 0)) {
            throw new NoSuchElementException();
          }
        }
        else
        {
          if (((TreeRangeMap.RangeMapEntry)((Map.Entry)localObject2).getValue()).getUpperBound().compareTo(this.subRange.upperBound) >= 0) {}
          for (localObject2 = this.subRange.upperBound;; localObject2 = ((TreeRangeMap.RangeMapEntry)((Map.Entry)localObject2).getValue()).getUpperBound()) {
            return Range.create((Cut)localObject1, (Cut)localObject2);
          }
        }
      }
    }
    
    public RangeMap<K, V> subRangeMap(Range<K> paramRange)
    {
      if (!paramRange.isConnected(this.subRange)) {
        return TreeRangeMap.this.emptySubRangeMap();
      }
      return TreeRangeMap.this.subRangeMap(paramRange.intersection(this.subRange));
    }
    
    public String toString()
    {
      return asMapOfRanges().toString();
    }
    
    class SubRangeMapAsMap
      extends AbstractMap<Range<K>, V>
    {
      SubRangeMapAsMap() {}
      
      private boolean removeEntryIf(Predicate<? super Map.Entry<Range<K>, V>> paramPredicate)
      {
        ArrayList localArrayList = Lists.newArrayList();
        Object localObject = entrySet().iterator();
        while (((Iterator)localObject).hasNext())
        {
          Map.Entry localEntry = (Map.Entry)((Iterator)localObject).next();
          if (paramPredicate.apply(localEntry)) {
            localArrayList.add(localEntry.getKey());
          }
        }
        paramPredicate = localArrayList.iterator();
        while (paramPredicate.hasNext())
        {
          localObject = (Range)paramPredicate.next();
          TreeRangeMap.this.remove((Range)localObject);
        }
        return !localArrayList.isEmpty();
      }
      
      public void clear()
      {
        TreeRangeMap.SubRangeMap.this.clear();
      }
      
      public boolean containsKey(Object paramObject)
      {
        return get(paramObject) != null;
      }
      
      Iterator<Map.Entry<Range<K>, V>> entryIterator()
      {
        if (TreeRangeMap.SubRangeMap.this.subRange.isEmpty()) {
          return Iterators.emptyIterator();
        }
        Cut localCut = (Cut)MoreObjects.firstNonNull(TreeRangeMap.this.entriesByLowerBound.floorKey(TreeRangeMap.SubRangeMap.this.subRange.lowerBound), TreeRangeMap.SubRangeMap.this.subRange.lowerBound);
        return new TreeRangeMap.SubRangeMap.SubRangeMapAsMap.3(this, TreeRangeMap.this.entriesByLowerBound.tailMap(localCut, true).values().iterator());
      }
      
      public Set<Map.Entry<Range<K>, V>> entrySet()
      {
        return new TreeRangeMap.SubRangeMap.SubRangeMapAsMap.2(this);
      }
      
      public V get(Object paramObject)
      {
        for (;;)
        {
          try
          {
            if (!(paramObject instanceof Range)) {
              break;
            }
            Range localRange = (Range)paramObject;
            if (!TreeRangeMap.SubRangeMap.this.subRange.encloses(localRange)) {
              break;
            }
            if (localRange.isEmpty()) {
              return null;
            }
            if (localRange.lowerBound.compareTo(TreeRangeMap.SubRangeMap.this.subRange.lowerBound) == 0)
            {
              paramObject = TreeRangeMap.this.entriesByLowerBound.floorEntry(localRange.lowerBound);
              if (paramObject != null)
              {
                paramObject = (TreeRangeMap.RangeMapEntry)paramObject.getValue();
                if ((paramObject == null) || (!paramObject.getKey().isConnected(TreeRangeMap.SubRangeMap.this.subRange)) || (!paramObject.getKey().intersection(TreeRangeMap.SubRangeMap.this.subRange).equals(localRange))) {
                  break;
                }
                return paramObject.getValue();
              }
            }
            else
            {
              paramObject = (TreeRangeMap.RangeMapEntry)TreeRangeMap.this.entriesByLowerBound.get(localRange.lowerBound);
              continue;
            }
            paramObject = null;
          }
          catch (ClassCastException paramObject)
          {
            return null;
          }
        }
        return null;
      }
      
      public Set<Range<K>> keySet()
      {
        return new TreeRangeMap.SubRangeMap.SubRangeMapAsMap.1(this, this);
      }
      
      public V remove(Object paramObject)
      {
        Object localObject = get(paramObject);
        if (localObject != null)
        {
          paramObject = (Range)paramObject;
          TreeRangeMap.this.remove(paramObject);
          return localObject;
        }
        return null;
      }
      
      public Collection<V> values()
      {
        return new TreeRangeMap.SubRangeMap.SubRangeMapAsMap.4(this, this);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     com.google.common.collect.TreeRangeMap
 * JD-Core Version:    0.7.0.1
 */