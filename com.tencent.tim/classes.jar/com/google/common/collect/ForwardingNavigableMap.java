package com.google.common.collect;

import com.google.common.annotations.Beta;
import com.google.common.annotations.GwtIncompatible;
import java.util.Iterator;
import java.util.Map.Entry;
import java.util.NavigableMap;
import java.util.NavigableSet;
import java.util.NoSuchElementException;
import java.util.Set;
import java.util.SortedMap;

@GwtIncompatible
public abstract class ForwardingNavigableMap<K, V>
  extends ForwardingSortedMap<K, V>
  implements NavigableMap<K, V>
{
  public Map.Entry<K, V> ceilingEntry(K paramK)
  {
    return delegate().ceilingEntry(paramK);
  }
  
  public K ceilingKey(K paramK)
  {
    return delegate().ceilingKey(paramK);
  }
  
  protected abstract NavigableMap<K, V> delegate();
  
  public NavigableSet<K> descendingKeySet()
  {
    return delegate().descendingKeySet();
  }
  
  public NavigableMap<K, V> descendingMap()
  {
    return delegate().descendingMap();
  }
  
  public Map.Entry<K, V> firstEntry()
  {
    return delegate().firstEntry();
  }
  
  public Map.Entry<K, V> floorEntry(K paramK)
  {
    return delegate().floorEntry(paramK);
  }
  
  public K floorKey(K paramK)
  {
    return delegate().floorKey(paramK);
  }
  
  public NavigableMap<K, V> headMap(K paramK, boolean paramBoolean)
  {
    return delegate().headMap(paramK, paramBoolean);
  }
  
  public Map.Entry<K, V> higherEntry(K paramK)
  {
    return delegate().higherEntry(paramK);
  }
  
  public K higherKey(K paramK)
  {
    return delegate().higherKey(paramK);
  }
  
  public Map.Entry<K, V> lastEntry()
  {
    return delegate().lastEntry();
  }
  
  public Map.Entry<K, V> lowerEntry(K paramK)
  {
    return delegate().lowerEntry(paramK);
  }
  
  public K lowerKey(K paramK)
  {
    return delegate().lowerKey(paramK);
  }
  
  public NavigableSet<K> navigableKeySet()
  {
    return delegate().navigableKeySet();
  }
  
  public Map.Entry<K, V> pollFirstEntry()
  {
    return delegate().pollFirstEntry();
  }
  
  public Map.Entry<K, V> pollLastEntry()
  {
    return delegate().pollLastEntry();
  }
  
  protected Map.Entry<K, V> standardCeilingEntry(K paramK)
  {
    return tailMap(paramK, true).firstEntry();
  }
  
  protected K standardCeilingKey(K paramK)
  {
    return Maps.keyOrNull(ceilingEntry(paramK));
  }
  
  @Beta
  protected NavigableSet<K> standardDescendingKeySet()
  {
    return descendingMap().navigableKeySet();
  }
  
  protected Map.Entry<K, V> standardFirstEntry()
  {
    return (Map.Entry)Iterables.getFirst(entrySet(), null);
  }
  
  protected K standardFirstKey()
  {
    Map.Entry localEntry = firstEntry();
    if (localEntry == null) {
      throw new NoSuchElementException();
    }
    return localEntry.getKey();
  }
  
  protected Map.Entry<K, V> standardFloorEntry(K paramK)
  {
    return headMap(paramK, true).lastEntry();
  }
  
  protected K standardFloorKey(K paramK)
  {
    return Maps.keyOrNull(floorEntry(paramK));
  }
  
  protected SortedMap<K, V> standardHeadMap(K paramK)
  {
    return headMap(paramK, false);
  }
  
  protected Map.Entry<K, V> standardHigherEntry(K paramK)
  {
    return tailMap(paramK, false).firstEntry();
  }
  
  protected K standardHigherKey(K paramK)
  {
    return Maps.keyOrNull(higherEntry(paramK));
  }
  
  protected Map.Entry<K, V> standardLastEntry()
  {
    return (Map.Entry)Iterables.getFirst(descendingMap().entrySet(), null);
  }
  
  protected K standardLastKey()
  {
    Map.Entry localEntry = lastEntry();
    if (localEntry == null) {
      throw new NoSuchElementException();
    }
    return localEntry.getKey();
  }
  
  protected Map.Entry<K, V> standardLowerEntry(K paramK)
  {
    return headMap(paramK, false).lastEntry();
  }
  
  protected K standardLowerKey(K paramK)
  {
    return Maps.keyOrNull(lowerEntry(paramK));
  }
  
  protected Map.Entry<K, V> standardPollFirstEntry()
  {
    return (Map.Entry)Iterators.pollNext(entrySet().iterator());
  }
  
  protected Map.Entry<K, V> standardPollLastEntry()
  {
    return (Map.Entry)Iterators.pollNext(descendingMap().entrySet().iterator());
  }
  
  protected SortedMap<K, V> standardSubMap(K paramK1, K paramK2)
  {
    return subMap(paramK1, true, paramK2, false);
  }
  
  protected SortedMap<K, V> standardTailMap(K paramK)
  {
    return tailMap(paramK, true);
  }
  
  public NavigableMap<K, V> subMap(K paramK1, boolean paramBoolean1, K paramK2, boolean paramBoolean2)
  {
    return delegate().subMap(paramK1, paramBoolean1, paramK2, paramBoolean2);
  }
  
  public NavigableMap<K, V> tailMap(K paramK, boolean paramBoolean)
  {
    return delegate().tailMap(paramK, paramBoolean);
  }
  
  @Beta
  public class StandardDescendingMap
    extends Maps.DescendingMap<K, V>
  {
    public StandardDescendingMap() {}
    
    protected Iterator<Map.Entry<K, V>> entryIterator()
    {
      return new ForwardingNavigableMap.StandardDescendingMap.1(this);
    }
    
    NavigableMap<K, V> forward()
    {
      return ForwardingNavigableMap.this;
    }
  }
  
  @Beta
  public class StandardNavigableKeySet
    extends Maps.NavigableKeySet<K, V>
  {
    public StandardNavigableKeySet()
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     com.google.common.collect.ForwardingNavigableMap
 * JD-Core Version:    0.7.0.1
 */