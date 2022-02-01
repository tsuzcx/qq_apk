package com.google.common.collect;

import com.google.common.annotations.GwtCompatible;
import com.google.common.annotations.GwtIncompatible;
import com.google.common.base.Preconditions;
import java.io.Serializable;
import java.util.AbstractCollection;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.NavigableMap;
import java.util.NavigableSet;
import java.util.RandomAccess;
import java.util.Set;
import java.util.SortedMap;
import java.util.SortedSet;
import javax.annotation.Nullable;

@GwtCompatible(emulated=true)
abstract class AbstractMapBasedMultimap<K, V>
  extends AbstractMultimap<K, V>
  implements Serializable
{
  private static final long serialVersionUID = 2447537837011683357L;
  private transient Map<K, Collection<V>> map;
  private transient int totalSize;
  
  protected AbstractMapBasedMultimap(Map<K, Collection<V>> paramMap)
  {
    Preconditions.checkArgument(paramMap.isEmpty());
    this.map = paramMap;
  }
  
  private Collection<V> getOrCreateCollection(@Nullable K paramK)
  {
    Collection localCollection2 = (Collection)this.map.get(paramK);
    Collection localCollection1 = localCollection2;
    if (localCollection2 == null)
    {
      localCollection1 = createCollection(paramK);
      this.map.put(paramK, localCollection1);
    }
    return localCollection1;
  }
  
  private Iterator<V> iteratorOrListIterator(Collection<V> paramCollection)
  {
    if ((paramCollection instanceof List)) {
      return ((List)paramCollection).listIterator();
    }
    return paramCollection.iterator();
  }
  
  private void removeValuesForKey(Object paramObject)
  {
    paramObject = (Collection)Maps.safeRemove(this.map, paramObject);
    if (paramObject != null)
    {
      int i = paramObject.size();
      paramObject.clear();
      this.totalSize -= i;
    }
  }
  
  private List<V> wrapList(@Nullable K paramK, List<V> paramList, @Nullable AbstractMapBasedMultimap<K, V>.WrappedCollection paramAbstractMapBasedMultimap)
  {
    if ((paramList instanceof RandomAccess)) {
      return new RandomAccessWrappedList(paramK, paramList, paramAbstractMapBasedMultimap);
    }
    return new WrappedList(paramK, paramList, paramAbstractMapBasedMultimap);
  }
  
  Map<K, Collection<V>> backingMap()
  {
    return this.map;
  }
  
  public void clear()
  {
    Iterator localIterator = this.map.values().iterator();
    while (localIterator.hasNext()) {
      ((Collection)localIterator.next()).clear();
    }
    this.map.clear();
    this.totalSize = 0;
  }
  
  public boolean containsKey(@Nullable Object paramObject)
  {
    return this.map.containsKey(paramObject);
  }
  
  Map<K, Collection<V>> createAsMap()
  {
    if ((this.map instanceof SortedMap)) {
      return new SortedAsMap((SortedMap)this.map);
    }
    return new AsMap(this.map);
  }
  
  abstract Collection<V> createCollection();
  
  Collection<V> createCollection(@Nullable K paramK)
  {
    return createCollection();
  }
  
  Set<K> createKeySet()
  {
    if ((this.map instanceof SortedMap)) {
      return new SortedKeySet((SortedMap)this.map);
    }
    return new KeySet(this.map);
  }
  
  Collection<V> createUnmodifiableEmptyCollection()
  {
    return unmodifiableCollectionSubclass(createCollection());
  }
  
  public Collection<Map.Entry<K, V>> entries()
  {
    return super.entries();
  }
  
  Iterator<Map.Entry<K, V>> entryIterator()
  {
    return new AbstractMapBasedMultimap.2(this);
  }
  
  public Collection<V> get(@Nullable K paramK)
  {
    Collection localCollection2 = (Collection)this.map.get(paramK);
    Collection localCollection1 = localCollection2;
    if (localCollection2 == null) {
      localCollection1 = createCollection(paramK);
    }
    return wrapCollection(paramK, localCollection1);
  }
  
  public boolean put(@Nullable K paramK, @Nullable V paramV)
  {
    Collection localCollection = (Collection)this.map.get(paramK);
    if (localCollection == null)
    {
      localCollection = createCollection(paramK);
      if (localCollection.add(paramV))
      {
        this.totalSize += 1;
        this.map.put(paramK, localCollection);
        return true;
      }
      throw new AssertionError("New Collection violated the Collection spec");
    }
    if (localCollection.add(paramV))
    {
      this.totalSize += 1;
      return true;
    }
    return false;
  }
  
  public Collection<V> removeAll(@Nullable Object paramObject)
  {
    paramObject = (Collection)this.map.remove(paramObject);
    if (paramObject == null) {
      return createUnmodifiableEmptyCollection();
    }
    Collection localCollection = createCollection();
    localCollection.addAll(paramObject);
    this.totalSize -= paramObject.size();
    paramObject.clear();
    return unmodifiableCollectionSubclass(localCollection);
  }
  
  public Collection<V> replaceValues(@Nullable K paramK, Iterable<? extends V> paramIterable)
  {
    paramIterable = paramIterable.iterator();
    if (!paramIterable.hasNext()) {
      return removeAll(paramK);
    }
    paramK = getOrCreateCollection(paramK);
    Collection localCollection = createCollection();
    localCollection.addAll(paramK);
    this.totalSize -= paramK.size();
    paramK.clear();
    while (paramIterable.hasNext()) {
      if (paramK.add(paramIterable.next())) {
        this.totalSize += 1;
      }
    }
    return unmodifiableCollectionSubclass(localCollection);
  }
  
  final void setMap(Map<K, Collection<V>> paramMap)
  {
    this.map = paramMap;
    this.totalSize = 0;
    paramMap = paramMap.values().iterator();
    if (paramMap.hasNext())
    {
      Collection localCollection = (Collection)paramMap.next();
      if (!localCollection.isEmpty()) {}
      for (boolean bool = true;; bool = false)
      {
        Preconditions.checkArgument(bool);
        int i = this.totalSize;
        this.totalSize = (localCollection.size() + i);
        break;
      }
    }
  }
  
  public int size()
  {
    return this.totalSize;
  }
  
  Collection<V> unmodifiableCollectionSubclass(Collection<V> paramCollection)
  {
    if ((paramCollection instanceof SortedSet)) {
      return Collections.unmodifiableSortedSet((SortedSet)paramCollection);
    }
    if ((paramCollection instanceof Set)) {
      return Collections.unmodifiableSet((Set)paramCollection);
    }
    if ((paramCollection instanceof List)) {
      return Collections.unmodifiableList((List)paramCollection);
    }
    return Collections.unmodifiableCollection(paramCollection);
  }
  
  Iterator<V> valueIterator()
  {
    return new AbstractMapBasedMultimap.1(this);
  }
  
  public Collection<V> values()
  {
    return super.values();
  }
  
  Collection<V> wrapCollection(@Nullable K paramK, Collection<V> paramCollection)
  {
    if ((paramCollection instanceof SortedSet)) {
      return new WrappedSortedSet(paramK, (SortedSet)paramCollection, null);
    }
    if ((paramCollection instanceof Set)) {
      return new WrappedSet(paramK, (Set)paramCollection);
    }
    if ((paramCollection instanceof List)) {
      return wrapList(paramK, (List)paramCollection, null);
    }
    return new WrappedCollection(paramK, paramCollection, null);
  }
  
  class AsMap
    extends Maps.ViewCachingAbstractMap<K, Collection<V>>
  {
    final transient Map<K, Collection<V>> submap;
    
    AsMap()
    {
      Object localObject;
      this.submap = localObject;
    }
    
    public void clear()
    {
      if (this.submap == AbstractMapBasedMultimap.this.map)
      {
        AbstractMapBasedMultimap.this.clear();
        return;
      }
      Iterators.clear(new AsMapIterator());
    }
    
    public boolean containsKey(Object paramObject)
    {
      return Maps.safeContainsKey(this.submap, paramObject);
    }
    
    protected Set<Map.Entry<K, Collection<V>>> createEntrySet()
    {
      return new AsMapEntries();
    }
    
    public boolean equals(@Nullable Object paramObject)
    {
      return (this == paramObject) || (this.submap.equals(paramObject));
    }
    
    public Collection<V> get(Object paramObject)
    {
      Collection localCollection = (Collection)Maps.safeGet(this.submap, paramObject);
      if (localCollection == null) {
        return null;
      }
      return AbstractMapBasedMultimap.this.wrapCollection(paramObject, localCollection);
    }
    
    public int hashCode()
    {
      return this.submap.hashCode();
    }
    
    public Set<K> keySet()
    {
      return AbstractMapBasedMultimap.this.keySet();
    }
    
    public Collection<V> remove(Object paramObject)
    {
      paramObject = (Collection)this.submap.remove(paramObject);
      if (paramObject == null) {
        return null;
      }
      Collection localCollection = AbstractMapBasedMultimap.this.createCollection();
      localCollection.addAll(paramObject);
      AbstractMapBasedMultimap.access$220(AbstractMapBasedMultimap.this, paramObject.size());
      paramObject.clear();
      return localCollection;
    }
    
    public int size()
    {
      return this.submap.size();
    }
    
    public String toString()
    {
      return this.submap.toString();
    }
    
    Map.Entry<K, Collection<V>> wrapEntry(Map.Entry<K, Collection<V>> paramEntry)
    {
      Object localObject = paramEntry.getKey();
      return Maps.immutableEntry(localObject, AbstractMapBasedMultimap.this.wrapCollection(localObject, (Collection)paramEntry.getValue()));
    }
    
    class AsMapEntries
      extends Maps.EntrySet<K, Collection<V>>
    {
      AsMapEntries() {}
      
      public boolean contains(Object paramObject)
      {
        return Collections2.safeContains(AbstractMapBasedMultimap.AsMap.this.submap.entrySet(), paramObject);
      }
      
      public Iterator<Map.Entry<K, Collection<V>>> iterator()
      {
        return new AbstractMapBasedMultimap.AsMap.AsMapIterator(AbstractMapBasedMultimap.AsMap.this);
      }
      
      Map<K, Collection<V>> map()
      {
        return AbstractMapBasedMultimap.AsMap.this;
      }
      
      public boolean remove(Object paramObject)
      {
        if (!contains(paramObject)) {
          return false;
        }
        paramObject = (Map.Entry)paramObject;
        AbstractMapBasedMultimap.this.removeValuesForKey(paramObject.getKey());
        return true;
      }
    }
    
    class AsMapIterator
      implements Iterator<Map.Entry<K, Collection<V>>>
    {
      Collection<V> collection;
      final Iterator<Map.Entry<K, Collection<V>>> delegateIterator = AbstractMapBasedMultimap.AsMap.this.submap.entrySet().iterator();
      
      AsMapIterator() {}
      
      public boolean hasNext()
      {
        return this.delegateIterator.hasNext();
      }
      
      public Map.Entry<K, Collection<V>> next()
      {
        Map.Entry localEntry = (Map.Entry)this.delegateIterator.next();
        this.collection = ((Collection)localEntry.getValue());
        return AbstractMapBasedMultimap.AsMap.this.wrapEntry(localEntry);
      }
      
      public void remove()
      {
        this.delegateIterator.remove();
        AbstractMapBasedMultimap.access$220(AbstractMapBasedMultimap.this, this.collection.size());
        this.collection.clear();
      }
    }
  }
  
  abstract class Itr<T>
    implements Iterator<T>
  {
    Collection<V> collection = null;
    K key = null;
    final Iterator<Map.Entry<K, Collection<V>>> keyIterator = AbstractMapBasedMultimap.this.map.entrySet().iterator();
    Iterator<V> valueIterator = Iterators.emptyModifiableIterator();
    
    Itr() {}
    
    public boolean hasNext()
    {
      return (this.keyIterator.hasNext()) || (this.valueIterator.hasNext());
    }
    
    public T next()
    {
      if (!this.valueIterator.hasNext())
      {
        Map.Entry localEntry = (Map.Entry)this.keyIterator.next();
        this.key = localEntry.getKey();
        this.collection = ((Collection)localEntry.getValue());
        this.valueIterator = this.collection.iterator();
      }
      return output(this.key, this.valueIterator.next());
    }
    
    abstract T output(K paramK, V paramV);
    
    public void remove()
    {
      this.valueIterator.remove();
      if (this.collection.isEmpty()) {
        this.keyIterator.remove();
      }
      AbstractMapBasedMultimap.access$210(AbstractMapBasedMultimap.this);
    }
  }
  
  class KeySet
    extends Maps.KeySet<K, Collection<V>>
  {
    KeySet()
    {
      super();
    }
    
    public void clear()
    {
      Iterators.clear(iterator());
    }
    
    public boolean containsAll(Collection<?> paramCollection)
    {
      return map().keySet().containsAll(paramCollection);
    }
    
    public boolean equals(@Nullable Object paramObject)
    {
      return (this == paramObject) || (map().keySet().equals(paramObject));
    }
    
    public int hashCode()
    {
      return map().keySet().hashCode();
    }
    
    public Iterator<K> iterator()
    {
      return new AbstractMapBasedMultimap.KeySet.1(this, map().entrySet().iterator());
    }
    
    public boolean remove(Object paramObject)
    {
      paramObject = (Collection)map().remove(paramObject);
      int i;
      if (paramObject != null)
      {
        i = paramObject.size();
        paramObject.clear();
        AbstractMapBasedMultimap.access$220(AbstractMapBasedMultimap.this, i);
      }
      for (;;)
      {
        return i > 0;
        i = 0;
      }
    }
  }
  
  @GwtIncompatible
  class NavigableAsMap
    extends AbstractMapBasedMultimap<K, V>.SortedAsMap
    implements NavigableMap<K, Collection<V>>
  {
    NavigableAsMap()
    {
      super(localSortedMap);
    }
    
    public Map.Entry<K, Collection<V>> ceilingEntry(K paramK)
    {
      paramK = sortedMap().ceilingEntry(paramK);
      if (paramK == null) {
        return null;
      }
      return wrapEntry(paramK);
    }
    
    public K ceilingKey(K paramK)
    {
      return sortedMap().ceilingKey(paramK);
    }
    
    NavigableSet<K> createKeySet()
    {
      return new AbstractMapBasedMultimap.NavigableKeySet(AbstractMapBasedMultimap.this, sortedMap());
    }
    
    public NavigableSet<K> descendingKeySet()
    {
      return descendingMap().navigableKeySet();
    }
    
    public NavigableMap<K, Collection<V>> descendingMap()
    {
      return new NavigableAsMap(AbstractMapBasedMultimap.this, sortedMap().descendingMap());
    }
    
    public Map.Entry<K, Collection<V>> firstEntry()
    {
      Map.Entry localEntry = sortedMap().firstEntry();
      if (localEntry == null) {
        return null;
      }
      return wrapEntry(localEntry);
    }
    
    public Map.Entry<K, Collection<V>> floorEntry(K paramK)
    {
      paramK = sortedMap().floorEntry(paramK);
      if (paramK == null) {
        return null;
      }
      return wrapEntry(paramK);
    }
    
    public K floorKey(K paramK)
    {
      return sortedMap().floorKey(paramK);
    }
    
    public NavigableMap<K, Collection<V>> headMap(K paramK)
    {
      return headMap(paramK, false);
    }
    
    public NavigableMap<K, Collection<V>> headMap(K paramK, boolean paramBoolean)
    {
      return new NavigableAsMap(AbstractMapBasedMultimap.this, sortedMap().headMap(paramK, paramBoolean));
    }
    
    public Map.Entry<K, Collection<V>> higherEntry(K paramK)
    {
      paramK = sortedMap().higherEntry(paramK);
      if (paramK == null) {
        return null;
      }
      return wrapEntry(paramK);
    }
    
    public K higherKey(K paramK)
    {
      return sortedMap().higherKey(paramK);
    }
    
    public NavigableSet<K> keySet()
    {
      return (NavigableSet)super.keySet();
    }
    
    public Map.Entry<K, Collection<V>> lastEntry()
    {
      Map.Entry localEntry = sortedMap().lastEntry();
      if (localEntry == null) {
        return null;
      }
      return wrapEntry(localEntry);
    }
    
    public Map.Entry<K, Collection<V>> lowerEntry(K paramK)
    {
      paramK = sortedMap().lowerEntry(paramK);
      if (paramK == null) {
        return null;
      }
      return wrapEntry(paramK);
    }
    
    public K lowerKey(K paramK)
    {
      return sortedMap().lowerKey(paramK);
    }
    
    public NavigableSet<K> navigableKeySet()
    {
      return keySet();
    }
    
    Map.Entry<K, Collection<V>> pollAsMapEntry(Iterator<Map.Entry<K, Collection<V>>> paramIterator)
    {
      if (!paramIterator.hasNext()) {
        return null;
      }
      Map.Entry localEntry = (Map.Entry)paramIterator.next();
      Collection localCollection = AbstractMapBasedMultimap.this.createCollection();
      localCollection.addAll((Collection)localEntry.getValue());
      paramIterator.remove();
      return Maps.immutableEntry(localEntry.getKey(), AbstractMapBasedMultimap.this.unmodifiableCollectionSubclass(localCollection));
    }
    
    public Map.Entry<K, Collection<V>> pollFirstEntry()
    {
      return pollAsMapEntry(entrySet().iterator());
    }
    
    public Map.Entry<K, Collection<V>> pollLastEntry()
    {
      return pollAsMapEntry(descendingMap().entrySet().iterator());
    }
    
    NavigableMap<K, Collection<V>> sortedMap()
    {
      return (NavigableMap)super.sortedMap();
    }
    
    public NavigableMap<K, Collection<V>> subMap(K paramK1, K paramK2)
    {
      return subMap(paramK1, true, paramK2, false);
    }
    
    public NavigableMap<K, Collection<V>> subMap(K paramK1, boolean paramBoolean1, K paramK2, boolean paramBoolean2)
    {
      return new NavigableAsMap(AbstractMapBasedMultimap.this, sortedMap().subMap(paramK1, paramBoolean1, paramK2, paramBoolean2));
    }
    
    public NavigableMap<K, Collection<V>> tailMap(K paramK)
    {
      return tailMap(paramK, true);
    }
    
    public NavigableMap<K, Collection<V>> tailMap(K paramK, boolean paramBoolean)
    {
      return new NavigableAsMap(AbstractMapBasedMultimap.this, sortedMap().tailMap(paramK, paramBoolean));
    }
  }
  
  @GwtIncompatible
  class NavigableKeySet
    extends AbstractMapBasedMultimap<K, V>.SortedKeySet
    implements NavigableSet<K>
  {
    NavigableKeySet()
    {
      super(localSortedMap);
    }
    
    public K ceiling(K paramK)
    {
      return sortedMap().ceilingKey(paramK);
    }
    
    public Iterator<K> descendingIterator()
    {
      return descendingSet().iterator();
    }
    
    public NavigableSet<K> descendingSet()
    {
      return new NavigableKeySet(AbstractMapBasedMultimap.this, sortedMap().descendingMap());
    }
    
    public K floor(K paramK)
    {
      return sortedMap().floorKey(paramK);
    }
    
    public NavigableSet<K> headSet(K paramK)
    {
      return headSet(paramK, false);
    }
    
    public NavigableSet<K> headSet(K paramK, boolean paramBoolean)
    {
      return new NavigableKeySet(AbstractMapBasedMultimap.this, sortedMap().headMap(paramK, paramBoolean));
    }
    
    public K higher(K paramK)
    {
      return sortedMap().higherKey(paramK);
    }
    
    public K lower(K paramK)
    {
      return sortedMap().lowerKey(paramK);
    }
    
    public K pollFirst()
    {
      return Iterators.pollNext(iterator());
    }
    
    public K pollLast()
    {
      return Iterators.pollNext(descendingIterator());
    }
    
    NavigableMap<K, Collection<V>> sortedMap()
    {
      return (NavigableMap)super.sortedMap();
    }
    
    public NavigableSet<K> subSet(K paramK1, K paramK2)
    {
      return subSet(paramK1, true, paramK2, false);
    }
    
    public NavigableSet<K> subSet(K paramK1, boolean paramBoolean1, K paramK2, boolean paramBoolean2)
    {
      return new NavigableKeySet(AbstractMapBasedMultimap.this, sortedMap().subMap(paramK1, paramBoolean1, paramK2, paramBoolean2));
    }
    
    public NavigableSet<K> tailSet(K paramK)
    {
      return tailSet(paramK, true);
    }
    
    public NavigableSet<K> tailSet(K paramK, boolean paramBoolean)
    {
      return new NavigableKeySet(AbstractMapBasedMultimap.this, sortedMap().tailMap(paramK, paramBoolean));
    }
  }
  
  class RandomAccessWrappedList
    extends AbstractMapBasedMultimap<K, V>.WrappedList
    implements RandomAccess
  {
    RandomAccessWrappedList(@Nullable List<V> paramList, AbstractMapBasedMultimap<K, V>.WrappedCollection paramAbstractMapBasedMultimap)
    {
      super(paramList, paramAbstractMapBasedMultimap, localWrappedCollection);
    }
  }
  
  class SortedAsMap
    extends AbstractMapBasedMultimap<K, V>.AsMap
    implements SortedMap<K, Collection<V>>
  {
    SortedSet<K> sortedKeySet;
    
    SortedAsMap()
    {
      super(localMap);
    }
    
    public Comparator<? super K> comparator()
    {
      return sortedMap().comparator();
    }
    
    SortedSet<K> createKeySet()
    {
      return new AbstractMapBasedMultimap.SortedKeySet(AbstractMapBasedMultimap.this, sortedMap());
    }
    
    public K firstKey()
    {
      return sortedMap().firstKey();
    }
    
    public SortedMap<K, Collection<V>> headMap(K paramK)
    {
      return new SortedAsMap(AbstractMapBasedMultimap.this, sortedMap().headMap(paramK));
    }
    
    public SortedSet<K> keySet()
    {
      SortedSet localSortedSet2 = this.sortedKeySet;
      SortedSet localSortedSet1 = localSortedSet2;
      if (localSortedSet2 == null)
      {
        localSortedSet1 = createKeySet();
        this.sortedKeySet = localSortedSet1;
      }
      return localSortedSet1;
    }
    
    public K lastKey()
    {
      return sortedMap().lastKey();
    }
    
    SortedMap<K, Collection<V>> sortedMap()
    {
      return (SortedMap)this.submap;
    }
    
    public SortedMap<K, Collection<V>> subMap(K paramK1, K paramK2)
    {
      return new SortedAsMap(AbstractMapBasedMultimap.this, sortedMap().subMap(paramK1, paramK2));
    }
    
    public SortedMap<K, Collection<V>> tailMap(K paramK)
    {
      return new SortedAsMap(AbstractMapBasedMultimap.this, sortedMap().tailMap(paramK));
    }
  }
  
  class SortedKeySet
    extends AbstractMapBasedMultimap<K, V>.KeySet
    implements SortedSet<K>
  {
    SortedKeySet()
    {
      super(localMap);
    }
    
    public Comparator<? super K> comparator()
    {
      return sortedMap().comparator();
    }
    
    public K first()
    {
      return sortedMap().firstKey();
    }
    
    public SortedSet<K> headSet(K paramK)
    {
      return new SortedKeySet(AbstractMapBasedMultimap.this, sortedMap().headMap(paramK));
    }
    
    public K last()
    {
      return sortedMap().lastKey();
    }
    
    SortedMap<K, Collection<V>> sortedMap()
    {
      return (SortedMap)super.map();
    }
    
    public SortedSet<K> subSet(K paramK1, K paramK2)
    {
      return new SortedKeySet(AbstractMapBasedMultimap.this, sortedMap().subMap(paramK1, paramK2));
    }
    
    public SortedSet<K> tailSet(K paramK)
    {
      return new SortedKeySet(AbstractMapBasedMultimap.this, sortedMap().tailMap(paramK));
    }
  }
  
  class WrappedCollection
    extends AbstractCollection<V>
  {
    final AbstractMapBasedMultimap<K, V>.WrappedCollection ancestor;
    final Collection<V> ancestorDelegate;
    Collection<V> delegate;
    final K key;
    
    WrappedCollection(@Nullable Collection<V> paramCollection, AbstractMapBasedMultimap<K, V>.WrappedCollection paramAbstractMapBasedMultimap)
    {
      this.key = paramCollection;
      this.delegate = paramAbstractMapBasedMultimap;
      Object localObject;
      this.ancestor = localObject;
      if (localObject == null) {}
      for (this$1 = null;; this$1 = localObject.getDelegate())
      {
        this.ancestorDelegate = AbstractMapBasedMultimap.this;
        return;
      }
    }
    
    public boolean add(V paramV)
    {
      refreshIfEmpty();
      boolean bool1 = this.delegate.isEmpty();
      boolean bool2 = this.delegate.add(paramV);
      if (bool2)
      {
        AbstractMapBasedMultimap.access$208(AbstractMapBasedMultimap.this);
        if (bool1) {
          addToMap();
        }
      }
      return bool2;
    }
    
    public boolean addAll(Collection<? extends V> paramCollection)
    {
      boolean bool1;
      if (paramCollection.isEmpty()) {
        bool1 = false;
      }
      int i;
      boolean bool2;
      do
      {
        do
        {
          return bool1;
          i = size();
          bool2 = this.delegate.addAll(paramCollection);
          bool1 = bool2;
        } while (!bool2);
        int j = this.delegate.size();
        AbstractMapBasedMultimap.access$212(AbstractMapBasedMultimap.this, j - i);
        bool1 = bool2;
      } while (i != 0);
      addToMap();
      return bool2;
    }
    
    void addToMap()
    {
      if (this.ancestor != null)
      {
        this.ancestor.addToMap();
        return;
      }
      AbstractMapBasedMultimap.this.map.put(this.key, this.delegate);
    }
    
    public void clear()
    {
      int i = size();
      if (i == 0) {
        return;
      }
      this.delegate.clear();
      AbstractMapBasedMultimap.access$220(AbstractMapBasedMultimap.this, i);
      removeIfEmpty();
    }
    
    public boolean contains(Object paramObject)
    {
      refreshIfEmpty();
      return this.delegate.contains(paramObject);
    }
    
    public boolean containsAll(Collection<?> paramCollection)
    {
      refreshIfEmpty();
      return this.delegate.containsAll(paramCollection);
    }
    
    public boolean equals(@Nullable Object paramObject)
    {
      if (paramObject == this) {
        return true;
      }
      refreshIfEmpty();
      return this.delegate.equals(paramObject);
    }
    
    AbstractMapBasedMultimap<K, V>.WrappedCollection getAncestor()
    {
      return this.ancestor;
    }
    
    Collection<V> getDelegate()
    {
      return this.delegate;
    }
    
    K getKey()
    {
      return this.key;
    }
    
    public int hashCode()
    {
      refreshIfEmpty();
      return this.delegate.hashCode();
    }
    
    public Iterator<V> iterator()
    {
      refreshIfEmpty();
      return new WrappedIterator();
    }
    
    void refreshIfEmpty()
    {
      if (this.ancestor != null)
      {
        this.ancestor.refreshIfEmpty();
        if (this.ancestor.getDelegate() != this.ancestorDelegate) {
          throw new ConcurrentModificationException();
        }
      }
      else if (this.delegate.isEmpty())
      {
        Collection localCollection = (Collection)AbstractMapBasedMultimap.this.map.get(this.key);
        if (localCollection != null) {
          this.delegate = localCollection;
        }
      }
    }
    
    public boolean remove(Object paramObject)
    {
      refreshIfEmpty();
      boolean bool = this.delegate.remove(paramObject);
      if (bool)
      {
        AbstractMapBasedMultimap.access$210(AbstractMapBasedMultimap.this);
        removeIfEmpty();
      }
      return bool;
    }
    
    public boolean removeAll(Collection<?> paramCollection)
    {
      boolean bool1;
      if (paramCollection.isEmpty()) {
        bool1 = false;
      }
      int i;
      boolean bool2;
      do
      {
        return bool1;
        i = size();
        bool2 = this.delegate.removeAll(paramCollection);
        bool1 = bool2;
      } while (!bool2);
      int j = this.delegate.size();
      AbstractMapBasedMultimap.access$212(AbstractMapBasedMultimap.this, j - i);
      removeIfEmpty();
      return bool2;
    }
    
    void removeIfEmpty()
    {
      if (this.ancestor != null) {
        this.ancestor.removeIfEmpty();
      }
      while (!this.delegate.isEmpty()) {
        return;
      }
      AbstractMapBasedMultimap.this.map.remove(this.key);
    }
    
    public boolean retainAll(Collection<?> paramCollection)
    {
      Preconditions.checkNotNull(paramCollection);
      int i = size();
      boolean bool = this.delegate.retainAll(paramCollection);
      if (bool)
      {
        int j = this.delegate.size();
        AbstractMapBasedMultimap.access$212(AbstractMapBasedMultimap.this, j - i);
        removeIfEmpty();
      }
      return bool;
    }
    
    public int size()
    {
      refreshIfEmpty();
      return this.delegate.size();
    }
    
    public String toString()
    {
      refreshIfEmpty();
      return this.delegate.toString();
    }
    
    class WrappedIterator
      implements Iterator<V>
    {
      final Iterator<V> delegateIterator;
      final Collection<V> originalDelegate = AbstractMapBasedMultimap.WrappedCollection.this.delegate;
      
      WrappedIterator()
      {
        this.delegateIterator = AbstractMapBasedMultimap.this.iteratorOrListIterator(AbstractMapBasedMultimap.WrappedCollection.this.delegate);
      }
      
      WrappedIterator()
      {
        Object localObject;
        this.delegateIterator = localObject;
      }
      
      Iterator<V> getDelegateIterator()
      {
        validateIterator();
        return this.delegateIterator;
      }
      
      public boolean hasNext()
      {
        validateIterator();
        return this.delegateIterator.hasNext();
      }
      
      public V next()
      {
        validateIterator();
        return this.delegateIterator.next();
      }
      
      public void remove()
      {
        this.delegateIterator.remove();
        AbstractMapBasedMultimap.access$210(AbstractMapBasedMultimap.this);
        AbstractMapBasedMultimap.WrappedCollection.this.removeIfEmpty();
      }
      
      void validateIterator()
      {
        AbstractMapBasedMultimap.WrappedCollection.this.refreshIfEmpty();
        if (AbstractMapBasedMultimap.WrappedCollection.this.delegate != this.originalDelegate) {
          throw new ConcurrentModificationException();
        }
      }
    }
  }
  
  class WrappedList
    extends AbstractMapBasedMultimap<K, V>.WrappedCollection
    implements List<V>
  {
    WrappedList(@Nullable List<V> paramList, AbstractMapBasedMultimap<K, V>.WrappedCollection paramAbstractMapBasedMultimap)
    {
      super(paramList, paramAbstractMapBasedMultimap, localWrappedCollection);
    }
    
    public void add(int paramInt, V paramV)
    {
      refreshIfEmpty();
      boolean bool = getDelegate().isEmpty();
      getListDelegate().add(paramInt, paramV);
      AbstractMapBasedMultimap.access$208(AbstractMapBasedMultimap.this);
      if (bool) {
        addToMap();
      }
    }
    
    public boolean addAll(int paramInt, Collection<? extends V> paramCollection)
    {
      boolean bool1;
      if (paramCollection.isEmpty()) {
        bool1 = false;
      }
      int i;
      boolean bool2;
      do
      {
        do
        {
          return bool1;
          i = size();
          bool2 = getListDelegate().addAll(paramInt, paramCollection);
          bool1 = bool2;
        } while (!bool2);
        paramInt = getDelegate().size();
        AbstractMapBasedMultimap.access$212(AbstractMapBasedMultimap.this, paramInt - i);
        bool1 = bool2;
      } while (i != 0);
      addToMap();
      return bool2;
    }
    
    public V get(int paramInt)
    {
      refreshIfEmpty();
      return getListDelegate().get(paramInt);
    }
    
    List<V> getListDelegate()
    {
      return (List)getDelegate();
    }
    
    public int indexOf(Object paramObject)
    {
      refreshIfEmpty();
      return getListDelegate().indexOf(paramObject);
    }
    
    public int lastIndexOf(Object paramObject)
    {
      refreshIfEmpty();
      return getListDelegate().lastIndexOf(paramObject);
    }
    
    public ListIterator<V> listIterator()
    {
      refreshIfEmpty();
      return new WrappedListIterator();
    }
    
    public ListIterator<V> listIterator(int paramInt)
    {
      refreshIfEmpty();
      return new WrappedListIterator(paramInt);
    }
    
    public V remove(int paramInt)
    {
      refreshIfEmpty();
      Object localObject = getListDelegate().remove(paramInt);
      AbstractMapBasedMultimap.access$210(AbstractMapBasedMultimap.this);
      removeIfEmpty();
      return localObject;
    }
    
    public V set(int paramInt, V paramV)
    {
      refreshIfEmpty();
      return getListDelegate().set(paramInt, paramV);
    }
    
    public List<V> subList(int paramInt1, int paramInt2)
    {
      refreshIfEmpty();
      AbstractMapBasedMultimap localAbstractMapBasedMultimap = AbstractMapBasedMultimap.this;
      Object localObject2 = getKey();
      List localList = getListDelegate().subList(paramInt1, paramInt2);
      if (getAncestor() == null) {}
      for (Object localObject1 = this;; localObject1 = getAncestor()) {
        return localAbstractMapBasedMultimap.wrapList(localObject2, localList, (AbstractMapBasedMultimap.WrappedCollection)localObject1);
      }
    }
    
    class WrappedListIterator
      extends AbstractMapBasedMultimap<K, V>.WrappedCollection.WrappedIterator
      implements ListIterator<V>
    {
      WrappedListIterator()
      {
        super();
      }
      
      public WrappedListIterator(int paramInt)
      {
        super(AbstractMapBasedMultimap.WrappedList.this.getListDelegate().listIterator(paramInt));
      }
      
      private ListIterator<V> getDelegateListIterator()
      {
        return (ListIterator)getDelegateIterator();
      }
      
      public void add(V paramV)
      {
        boolean bool = AbstractMapBasedMultimap.WrappedList.this.isEmpty();
        getDelegateListIterator().add(paramV);
        AbstractMapBasedMultimap.access$208(AbstractMapBasedMultimap.this);
        if (bool) {
          AbstractMapBasedMultimap.WrappedList.this.addToMap();
        }
      }
      
      public boolean hasPrevious()
      {
        return getDelegateListIterator().hasPrevious();
      }
      
      public int nextIndex()
      {
        return getDelegateListIterator().nextIndex();
      }
      
      public V previous()
      {
        return getDelegateListIterator().previous();
      }
      
      public int previousIndex()
      {
        return getDelegateListIterator().previousIndex();
      }
      
      public void set(V paramV)
      {
        getDelegateListIterator().set(paramV);
      }
    }
  }
  
  @GwtIncompatible
  class WrappedNavigableSet
    extends AbstractMapBasedMultimap<K, V>.WrappedSortedSet
    implements NavigableSet<V>
  {
    WrappedNavigableSet(@Nullable NavigableSet<V> paramNavigableSet, AbstractMapBasedMultimap<K, V>.WrappedCollection paramAbstractMapBasedMultimap)
    {
      super(paramNavigableSet, paramAbstractMapBasedMultimap, localWrappedCollection);
    }
    
    private NavigableSet<V> wrap(NavigableSet<V> paramNavigableSet)
    {
      AbstractMapBasedMultimap localAbstractMapBasedMultimap = AbstractMapBasedMultimap.this;
      Object localObject2 = this.key;
      if (getAncestor() == null) {}
      for (Object localObject1 = this;; localObject1 = getAncestor()) {
        return new WrappedNavigableSet(localAbstractMapBasedMultimap, localObject2, paramNavigableSet, (AbstractMapBasedMultimap.WrappedCollection)localObject1);
      }
    }
    
    public V ceiling(V paramV)
    {
      return getSortedSetDelegate().ceiling(paramV);
    }
    
    public Iterator<V> descendingIterator()
    {
      return new AbstractMapBasedMultimap.WrappedCollection.WrappedIterator(this, getSortedSetDelegate().descendingIterator());
    }
    
    public NavigableSet<V> descendingSet()
    {
      return wrap(getSortedSetDelegate().descendingSet());
    }
    
    public V floor(V paramV)
    {
      return getSortedSetDelegate().floor(paramV);
    }
    
    NavigableSet<V> getSortedSetDelegate()
    {
      return (NavigableSet)super.getSortedSetDelegate();
    }
    
    public NavigableSet<V> headSet(V paramV, boolean paramBoolean)
    {
      return wrap(getSortedSetDelegate().headSet(paramV, paramBoolean));
    }
    
    public V higher(V paramV)
    {
      return getSortedSetDelegate().higher(paramV);
    }
    
    public V lower(V paramV)
    {
      return getSortedSetDelegate().lower(paramV);
    }
    
    public V pollFirst()
    {
      return Iterators.pollNext(iterator());
    }
    
    public V pollLast()
    {
      return Iterators.pollNext(descendingIterator());
    }
    
    public NavigableSet<V> subSet(V paramV1, boolean paramBoolean1, V paramV2, boolean paramBoolean2)
    {
      return wrap(getSortedSetDelegate().subSet(paramV1, paramBoolean1, paramV2, paramBoolean2));
    }
    
    public NavigableSet<V> tailSet(V paramV, boolean paramBoolean)
    {
      return wrap(getSortedSetDelegate().tailSet(paramV, paramBoolean));
    }
  }
  
  class WrappedSet
    extends AbstractMapBasedMultimap<K, V>.WrappedCollection
    implements Set<V>
  {
    WrappedSet(@Nullable Set<V> paramSet)
    {
      super(paramSet, localCollection, null);
    }
    
    public boolean removeAll(Collection<?> paramCollection)
    {
      boolean bool1;
      if (paramCollection.isEmpty()) {
        bool1 = false;
      }
      int i;
      boolean bool2;
      do
      {
        return bool1;
        i = size();
        bool2 = Sets.removeAllImpl((Set)this.delegate, paramCollection);
        bool1 = bool2;
      } while (!bool2);
      int j = this.delegate.size();
      AbstractMapBasedMultimap.access$212(AbstractMapBasedMultimap.this, j - i);
      removeIfEmpty();
      return bool2;
    }
  }
  
  class WrappedSortedSet
    extends AbstractMapBasedMultimap<K, V>.WrappedCollection
    implements SortedSet<V>
  {
    WrappedSortedSet(@Nullable SortedSet<V> paramSortedSet, AbstractMapBasedMultimap<K, V>.WrappedCollection paramAbstractMapBasedMultimap)
    {
      super(paramSortedSet, paramAbstractMapBasedMultimap, localWrappedCollection);
    }
    
    public Comparator<? super V> comparator()
    {
      return getSortedSetDelegate().comparator();
    }
    
    public V first()
    {
      refreshIfEmpty();
      return getSortedSetDelegate().first();
    }
    
    SortedSet<V> getSortedSetDelegate()
    {
      return (SortedSet)getDelegate();
    }
    
    public SortedSet<V> headSet(V paramV)
    {
      refreshIfEmpty();
      AbstractMapBasedMultimap localAbstractMapBasedMultimap = AbstractMapBasedMultimap.this;
      Object localObject = getKey();
      SortedSet localSortedSet = getSortedSetDelegate().headSet(paramV);
      if (getAncestor() == null) {}
      for (paramV = this;; paramV = getAncestor()) {
        return new WrappedSortedSet(localAbstractMapBasedMultimap, localObject, localSortedSet, paramV);
      }
    }
    
    public V last()
    {
      refreshIfEmpty();
      return getSortedSetDelegate().last();
    }
    
    public SortedSet<V> subSet(V paramV1, V paramV2)
    {
      refreshIfEmpty();
      AbstractMapBasedMultimap localAbstractMapBasedMultimap = AbstractMapBasedMultimap.this;
      Object localObject = getKey();
      paramV2 = getSortedSetDelegate().subSet(paramV1, paramV2);
      if (getAncestor() == null) {}
      for (paramV1 = this;; paramV1 = getAncestor()) {
        return new WrappedSortedSet(localAbstractMapBasedMultimap, localObject, paramV2, paramV1);
      }
    }
    
    public SortedSet<V> tailSet(V paramV)
    {
      refreshIfEmpty();
      AbstractMapBasedMultimap localAbstractMapBasedMultimap = AbstractMapBasedMultimap.this;
      Object localObject = getKey();
      SortedSet localSortedSet = getSortedSetDelegate().tailSet(paramV);
      if (getAncestor() == null) {}
      for (paramV = this;; paramV = getAncestor()) {
        return new WrappedSortedSet(localAbstractMapBasedMultimap, localObject, localSortedSet, paramV);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     com.google.common.collect.AbstractMapBasedMultimap
 * JD-Core Version:    0.7.0.1
 */