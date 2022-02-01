package com.google.common.collect;

import com.google.common.annotations.Beta;
import com.google.common.annotations.GwtCompatible;
import com.google.common.base.Preconditions;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import java.io.Serializable;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import javax.annotation.Nullable;

@Deprecated
@Beta
@GwtCompatible
public final class MapConstraints
{
  private static <K, V> Map<K, V> checkMap(Map<? extends K, ? extends V> paramMap, MapConstraint<? super K, ? super V> paramMapConstraint)
  {
    paramMap = new LinkedHashMap(paramMap);
    Iterator localIterator = paramMap.entrySet().iterator();
    while (localIterator.hasNext())
    {
      Map.Entry localEntry = (Map.Entry)localIterator.next();
      paramMapConstraint.checkKeyValue(localEntry.getKey(), localEntry.getValue());
    }
    return paramMap;
  }
  
  private static <K, V> Collection<V> checkValues(K paramK, Iterable<? extends V> paramIterable, MapConstraint<? super K, ? super V> paramMapConstraint)
  {
    paramIterable = Lists.newArrayList(paramIterable);
    Iterator localIterator = paramIterable.iterator();
    while (localIterator.hasNext()) {
      paramMapConstraint.checkKeyValue(paramK, localIterator.next());
    }
    return paramIterable;
  }
  
  private static <K, V> Set<Map.Entry<K, Collection<V>>> constrainedAsMapEntries(Set<Map.Entry<K, Collection<V>>> paramSet, MapConstraint<? super K, ? super V> paramMapConstraint)
  {
    return new ConstrainedAsMapEntries(paramSet, paramMapConstraint);
  }
  
  private static <K, V> Map.Entry<K, Collection<V>> constrainedAsMapEntry(Map.Entry<K, Collection<V>> paramEntry, MapConstraint<? super K, ? super V> paramMapConstraint)
  {
    Preconditions.checkNotNull(paramEntry);
    Preconditions.checkNotNull(paramMapConstraint);
    return new MapConstraints.2(paramEntry, paramMapConstraint);
  }
  
  private static <K, V> Collection<Map.Entry<K, V>> constrainedEntries(Collection<Map.Entry<K, V>> paramCollection, MapConstraint<? super K, ? super V> paramMapConstraint)
  {
    if ((paramCollection instanceof Set)) {
      return constrainedEntrySet((Set)paramCollection, paramMapConstraint);
    }
    return new ConstrainedEntries(paramCollection, paramMapConstraint);
  }
  
  private static <K, V> Map.Entry<K, V> constrainedEntry(Map.Entry<K, V> paramEntry, MapConstraint<? super K, ? super V> paramMapConstraint)
  {
    Preconditions.checkNotNull(paramEntry);
    Preconditions.checkNotNull(paramMapConstraint);
    return new MapConstraints.1(paramEntry, paramMapConstraint);
  }
  
  private static <K, V> Set<Map.Entry<K, V>> constrainedEntrySet(Set<Map.Entry<K, V>> paramSet, MapConstraint<? super K, ? super V> paramMapConstraint)
  {
    return new ConstrainedEntrySet(paramSet, paramMapConstraint);
  }
  
  public static <K, V> ListMultimap<K, V> constrainedListMultimap(ListMultimap<K, V> paramListMultimap, MapConstraint<? super K, ? super V> paramMapConstraint)
  {
    return new ConstrainedListMultimap(paramListMultimap, paramMapConstraint);
  }
  
  public static <K, V> Map<K, V> constrainedMap(Map<K, V> paramMap, MapConstraint<? super K, ? super V> paramMapConstraint)
  {
    return new ConstrainedMap(paramMap, paramMapConstraint);
  }
  
  static class ConstrainedAsMapEntries<K, V>
    extends ForwardingSet<Map.Entry<K, Collection<V>>>
  {
    private final MapConstraint<? super K, ? super V> constraint;
    private final Set<Map.Entry<K, Collection<V>>> entries;
    
    ConstrainedAsMapEntries(Set<Map.Entry<K, Collection<V>>> paramSet, MapConstraint<? super K, ? super V> paramMapConstraint)
    {
      this.entries = paramSet;
      this.constraint = paramMapConstraint;
    }
    
    public boolean contains(Object paramObject)
    {
      return Maps.containsEntryImpl(delegate(), paramObject);
    }
    
    public boolean containsAll(Collection<?> paramCollection)
    {
      return standardContainsAll(paramCollection);
    }
    
    protected Set<Map.Entry<K, Collection<V>>> delegate()
    {
      return this.entries;
    }
    
    public boolean equals(@Nullable Object paramObject)
    {
      return standardEquals(paramObject);
    }
    
    public int hashCode()
    {
      return standardHashCode();
    }
    
    public Iterator<Map.Entry<K, Collection<V>>> iterator()
    {
      return new MapConstraints.ConstrainedAsMapEntries.1(this, this.entries.iterator());
    }
    
    public boolean remove(Object paramObject)
    {
      return Maps.removeEntryImpl(delegate(), paramObject);
    }
    
    public boolean removeAll(Collection<?> paramCollection)
    {
      return standardRemoveAll(paramCollection);
    }
    
    public boolean retainAll(Collection<?> paramCollection)
    {
      return standardRetainAll(paramCollection);
    }
    
    public Object[] toArray()
    {
      return standardToArray();
    }
    
    public <T> T[] toArray(T[] paramArrayOfT)
    {
      return standardToArray(paramArrayOfT);
    }
  }
  
  static class ConstrainedAsMapValues<K, V>
    extends ForwardingCollection<Collection<V>>
  {
    final Collection<Collection<V>> delegate;
    final Set<Map.Entry<K, Collection<V>>> entrySet;
    
    ConstrainedAsMapValues(Collection<Collection<V>> paramCollection, Set<Map.Entry<K, Collection<V>>> paramSet)
    {
      this.delegate = paramCollection;
      this.entrySet = paramSet;
    }
    
    public boolean contains(Object paramObject)
    {
      return standardContains(paramObject);
    }
    
    public boolean containsAll(Collection<?> paramCollection)
    {
      return standardContainsAll(paramCollection);
    }
    
    protected Collection<Collection<V>> delegate()
    {
      return this.delegate;
    }
    
    public Iterator<Collection<V>> iterator()
    {
      return new MapConstraints.ConstrainedAsMapValues.1(this, this.entrySet.iterator());
    }
    
    public boolean remove(Object paramObject)
    {
      return standardRemove(paramObject);
    }
    
    public boolean removeAll(Collection<?> paramCollection)
    {
      return standardRemoveAll(paramCollection);
    }
    
    public boolean retainAll(Collection<?> paramCollection)
    {
      return standardRetainAll(paramCollection);
    }
    
    public Object[] toArray()
    {
      return standardToArray();
    }
    
    public <T> T[] toArray(T[] paramArrayOfT)
    {
      return standardToArray(paramArrayOfT);
    }
  }
  
  static class ConstrainedEntries<K, V>
    extends ForwardingCollection<Map.Entry<K, V>>
  {
    final MapConstraint<? super K, ? super V> constraint;
    final Collection<Map.Entry<K, V>> entries;
    
    ConstrainedEntries(Collection<Map.Entry<K, V>> paramCollection, MapConstraint<? super K, ? super V> paramMapConstraint)
    {
      this.entries = paramCollection;
      this.constraint = paramMapConstraint;
    }
    
    public boolean contains(Object paramObject)
    {
      return Maps.containsEntryImpl(delegate(), paramObject);
    }
    
    public boolean containsAll(Collection<?> paramCollection)
    {
      return standardContainsAll(paramCollection);
    }
    
    protected Collection<Map.Entry<K, V>> delegate()
    {
      return this.entries;
    }
    
    public Iterator<Map.Entry<K, V>> iterator()
    {
      return new MapConstraints.ConstrainedEntries.1(this, this.entries.iterator());
    }
    
    public boolean remove(Object paramObject)
    {
      return Maps.removeEntryImpl(delegate(), paramObject);
    }
    
    public boolean removeAll(Collection<?> paramCollection)
    {
      return standardRemoveAll(paramCollection);
    }
    
    public boolean retainAll(Collection<?> paramCollection)
    {
      return standardRetainAll(paramCollection);
    }
    
    public Object[] toArray()
    {
      return standardToArray();
    }
    
    public <T> T[] toArray(T[] paramArrayOfT)
    {
      return standardToArray(paramArrayOfT);
    }
  }
  
  static class ConstrainedEntrySet<K, V>
    extends MapConstraints.ConstrainedEntries<K, V>
    implements Set<Map.Entry<K, V>>
  {
    ConstrainedEntrySet(Set<Map.Entry<K, V>> paramSet, MapConstraint<? super K, ? super V> paramMapConstraint)
    {
      super(paramMapConstraint);
    }
    
    public boolean equals(@Nullable Object paramObject)
    {
      return Sets.equalsImpl(this, paramObject);
    }
    
    public int hashCode()
    {
      return Sets.hashCodeImpl(this);
    }
  }
  
  static class ConstrainedListMultimap<K, V>
    extends MapConstraints.ConstrainedMultimap<K, V>
    implements ListMultimap<K, V>
  {
    ConstrainedListMultimap(ListMultimap<K, V> paramListMultimap, MapConstraint<? super K, ? super V> paramMapConstraint)
    {
      super(paramMapConstraint);
    }
    
    public List<V> get(K paramK)
    {
      return (List)super.get(paramK);
    }
    
    public List<V> removeAll(Object paramObject)
    {
      return (List)super.removeAll(paramObject);
    }
    
    public List<V> replaceValues(K paramK, Iterable<? extends V> paramIterable)
    {
      return (List)super.replaceValues(paramK, paramIterable);
    }
  }
  
  static class ConstrainedMap<K, V>
    extends ForwardingMap<K, V>
  {
    final MapConstraint<? super K, ? super V> constraint;
    private final Map<K, V> delegate;
    private transient Set<Map.Entry<K, V>> entrySet;
    
    ConstrainedMap(Map<K, V> paramMap, MapConstraint<? super K, ? super V> paramMapConstraint)
    {
      this.delegate = ((Map)Preconditions.checkNotNull(paramMap));
      this.constraint = ((MapConstraint)Preconditions.checkNotNull(paramMapConstraint));
    }
    
    protected Map<K, V> delegate()
    {
      return this.delegate;
    }
    
    public Set<Map.Entry<K, V>> entrySet()
    {
      Set localSet2 = this.entrySet;
      Set localSet1 = localSet2;
      if (localSet2 == null)
      {
        localSet1 = MapConstraints.constrainedEntrySet(this.delegate.entrySet(), this.constraint);
        this.entrySet = localSet1;
      }
      return localSet1;
    }
    
    @CanIgnoreReturnValue
    public V put(K paramK, V paramV)
    {
      this.constraint.checkKeyValue(paramK, paramV);
      return this.delegate.put(paramK, paramV);
    }
    
    public void putAll(Map<? extends K, ? extends V> paramMap)
    {
      this.delegate.putAll(MapConstraints.checkMap(paramMap, this.constraint));
    }
  }
  
  static class ConstrainedMultimap<K, V>
    extends ForwardingMultimap<K, V>
    implements Serializable
  {
    transient Map<K, Collection<V>> asMap;
    final MapConstraint<? super K, ? super V> constraint;
    final Multimap<K, V> delegate;
    transient Collection<Map.Entry<K, V>> entries;
    
    public ConstrainedMultimap(Multimap<K, V> paramMultimap, MapConstraint<? super K, ? super V> paramMapConstraint)
    {
      this.delegate = ((Multimap)Preconditions.checkNotNull(paramMultimap));
      this.constraint = ((MapConstraint)Preconditions.checkNotNull(paramMapConstraint));
    }
    
    public Map<K, Collection<V>> asMap()
    {
      Map localMap = this.asMap;
      Object localObject = localMap;
      if (localMap == null)
      {
        localObject = new MapConstraints.ConstrainedMultimap.1AsMap(this, this.delegate.asMap());
        this.asMap = ((Map)localObject);
      }
      return localObject;
    }
    
    protected Multimap<K, V> delegate()
    {
      return this.delegate;
    }
    
    public Collection<Map.Entry<K, V>> entries()
    {
      Collection localCollection2 = this.entries;
      Collection localCollection1 = localCollection2;
      if (localCollection2 == null)
      {
        localCollection1 = MapConstraints.constrainedEntries(this.delegate.entries(), this.constraint);
        this.entries = localCollection1;
      }
      return localCollection1;
    }
    
    public Collection<V> get(K paramK)
    {
      return Constraints.constrainedTypePreservingCollection(this.delegate.get(paramK), new MapConstraints.ConstrainedMultimap.1(this, paramK));
    }
    
    public boolean put(K paramK, V paramV)
    {
      this.constraint.checkKeyValue(paramK, paramV);
      return this.delegate.put(paramK, paramV);
    }
    
    public boolean putAll(Multimap<? extends K, ? extends V> paramMultimap)
    {
      paramMultimap = paramMultimap.entries().iterator();
      Map.Entry localEntry;
      for (boolean bool = false; paramMultimap.hasNext(); bool = put(localEntry.getKey(), localEntry.getValue()) | bool) {
        localEntry = (Map.Entry)paramMultimap.next();
      }
      return bool;
    }
    
    public boolean putAll(K paramK, Iterable<? extends V> paramIterable)
    {
      return this.delegate.putAll(paramK, MapConstraints.checkValues(paramK, paramIterable, this.constraint));
    }
    
    public Collection<V> replaceValues(K paramK, Iterable<? extends V> paramIterable)
    {
      return this.delegate.replaceValues(paramK, MapConstraints.checkValues(paramK, paramIterable, this.constraint));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     com.google.common.collect.MapConstraints
 * JD-Core Version:    0.7.0.1
 */