package com.google.common.collect;

import com.google.common.annotations.GwtCompatible;
import com.google.common.base.MoreObjects;
import com.google.common.base.Preconditions;
import com.google.common.base.Predicate;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import javax.annotation.Nullable;

@GwtCompatible
class FilteredEntryMultimap<K, V>
  extends AbstractMultimap<K, V>
  implements FilteredMultimap<K, V>
{
  final Predicate<? super Map.Entry<K, V>> predicate;
  final Multimap<K, V> unfiltered;
  
  FilteredEntryMultimap(Multimap<K, V> paramMultimap, Predicate<? super Map.Entry<K, V>> paramPredicate)
  {
    this.unfiltered = ((Multimap)Preconditions.checkNotNull(paramMultimap));
    this.predicate = ((Predicate)Preconditions.checkNotNull(paramPredicate));
  }
  
  static <E> Collection<E> filterCollection(Collection<E> paramCollection, Predicate<? super E> paramPredicate)
  {
    if ((paramCollection instanceof Set)) {
      return Sets.filter((Set)paramCollection, paramPredicate);
    }
    return Collections2.filter(paramCollection, paramPredicate);
  }
  
  private boolean satisfies(K paramK, V paramV)
  {
    return this.predicate.apply(Maps.immutableEntry(paramK, paramV));
  }
  
  public void clear()
  {
    entries().clear();
  }
  
  public boolean containsKey(@Nullable Object paramObject)
  {
    return asMap().get(paramObject) != null;
  }
  
  Map<K, Collection<V>> createAsMap()
  {
    return new AsMap();
  }
  
  Collection<Map.Entry<K, V>> createEntries()
  {
    return filterCollection(this.unfiltered.entries(), this.predicate);
  }
  
  Multiset<K> createKeys()
  {
    return new Keys();
  }
  
  Collection<V> createValues()
  {
    return new FilteredMultimapValues(this);
  }
  
  Iterator<Map.Entry<K, V>> entryIterator()
  {
    throw new AssertionError("should never be called");
  }
  
  public Predicate<? super Map.Entry<K, V>> entryPredicate()
  {
    return this.predicate;
  }
  
  public Collection<V> get(K paramK)
  {
    return filterCollection(this.unfiltered.get(paramK), new ValuePredicate(paramK));
  }
  
  public Set<K> keySet()
  {
    return asMap().keySet();
  }
  
  public Collection<V> removeAll(@Nullable Object paramObject)
  {
    return (Collection)MoreObjects.firstNonNull(asMap().remove(paramObject), unmodifiableEmptyCollection());
  }
  
  boolean removeEntriesIf(Predicate<? super Map.Entry<K, Collection<V>>> paramPredicate)
  {
    Iterator localIterator = this.unfiltered.asMap().entrySet().iterator();
    boolean bool = false;
    Collection localCollection;
    if (localIterator.hasNext())
    {
      Map.Entry localEntry = (Map.Entry)localIterator.next();
      Object localObject = localEntry.getKey();
      localCollection = filterCollection((Collection)localEntry.getValue(), new ValuePredicate(localObject));
      if ((localCollection.isEmpty()) || (!paramPredicate.apply(Maps.immutableEntry(localObject, localCollection)))) {
        break label150;
      }
      if (localCollection.size() == ((Collection)localEntry.getValue()).size())
      {
        localIterator.remove();
        label133:
        bool = true;
      }
    }
    label150:
    for (;;)
    {
      break;
      localCollection.clear();
      break label133;
      return bool;
    }
  }
  
  public int size()
  {
    return entries().size();
  }
  
  public Multimap<K, V> unfiltered()
  {
    return this.unfiltered;
  }
  
  Collection<V> unmodifiableEmptyCollection()
  {
    if ((this.unfiltered instanceof SetMultimap)) {
      return Collections.emptySet();
    }
    return Collections.emptyList();
  }
  
  class AsMap
    extends Maps.ViewCachingAbstractMap<K, Collection<V>>
  {
    AsMap() {}
    
    public void clear()
    {
      FilteredEntryMultimap.this.clear();
    }
    
    public boolean containsKey(@Nullable Object paramObject)
    {
      return get(paramObject) != null;
    }
    
    Set<Map.Entry<K, Collection<V>>> createEntrySet()
    {
      return new FilteredEntryMultimap.AsMap.1EntrySetImpl(this);
    }
    
    Set<K> createKeySet()
    {
      return new FilteredEntryMultimap.AsMap.1KeySetImpl(this);
    }
    
    Collection<Collection<V>> createValues()
    {
      return new FilteredEntryMultimap.AsMap.1ValuesImpl(this);
    }
    
    public Collection<V> get(@Nullable Object paramObject)
    {
      Collection localCollection = (Collection)FilteredEntryMultimap.this.unfiltered.asMap().get(paramObject);
      if (localCollection == null) {
        return null;
      }
      localCollection = FilteredEntryMultimap.filterCollection(localCollection, new FilteredEntryMultimap.ValuePredicate(FilteredEntryMultimap.this, paramObject));
      paramObject = localCollection;
      if (localCollection.isEmpty()) {
        paramObject = null;
      }
      return paramObject;
    }
    
    public Collection<V> remove(@Nullable Object paramObject)
    {
      Object localObject1 = (Collection)FilteredEntryMultimap.this.unfiltered.asMap().get(paramObject);
      if (localObject1 == null) {
        return null;
      }
      ArrayList localArrayList = Lists.newArrayList();
      localObject1 = ((Collection)localObject1).iterator();
      while (((Iterator)localObject1).hasNext())
      {
        Object localObject2 = ((Iterator)localObject1).next();
        if (FilteredEntryMultimap.this.satisfies(paramObject, localObject2))
        {
          ((Iterator)localObject1).remove();
          localArrayList.add(localObject2);
        }
      }
      if (localArrayList.isEmpty()) {
        return null;
      }
      if ((FilteredEntryMultimap.this.unfiltered instanceof SetMultimap)) {
        return Collections.unmodifiableSet(Sets.newLinkedHashSet(localArrayList));
      }
      return Collections.unmodifiableList(localArrayList);
    }
  }
  
  class Keys
    extends Multimaps.Keys<K, V>
  {
    Keys()
    {
      super();
    }
    
    public Set<Multiset.Entry<K>> entrySet()
    {
      return new FilteredEntryMultimap.Keys.1(this);
    }
    
    public int remove(@Nullable Object paramObject, int paramInt)
    {
      int i = 0;
      CollectPreconditions.checkNonnegative(paramInt, "occurrences");
      if (paramInt == 0) {
        i = count(paramObject);
      }
      do
      {
        return i;
        localObject1 = (Collection)FilteredEntryMultimap.this.unfiltered.asMap().get(paramObject);
      } while (localObject1 == null);
      Object localObject1 = ((Collection)localObject1).iterator();
      i = 0;
      while (((Iterator)localObject1).hasNext())
      {
        Object localObject2 = ((Iterator)localObject1).next();
        if (FilteredEntryMultimap.this.satisfies(paramObject, localObject2))
        {
          int j = i + 1;
          i = j;
          if (j <= paramInt)
          {
            ((Iterator)localObject1).remove();
            i = j;
          }
        }
      }
      return i;
    }
  }
  
  final class ValuePredicate
    implements Predicate<V>
  {
    private final K key;
    
    ValuePredicate()
    {
      Object localObject;
      this.key = localObject;
    }
    
    public boolean apply(@Nullable V paramV)
    {
      return FilteredEntryMultimap.this.satisfies(this.key, paramV);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     com.google.common.collect.FilteredEntryMultimap
 * JD-Core Version:    0.7.0.1
 */