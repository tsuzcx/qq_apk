package com.google.common.collect;

import com.google.common.annotations.Beta;
import com.google.common.annotations.GwtCompatible;
import com.google.common.base.Objects;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import javax.annotation.Nullable;

@GwtCompatible
public abstract class ForwardingMap<K, V>
  extends ForwardingObject
  implements Map<K, V>
{
  public void clear()
  {
    delegate().clear();
  }
  
  public boolean containsKey(@Nullable Object paramObject)
  {
    return delegate().containsKey(paramObject);
  }
  
  public boolean containsValue(@Nullable Object paramObject)
  {
    return delegate().containsValue(paramObject);
  }
  
  protected abstract Map<K, V> delegate();
  
  public Set<Map.Entry<K, V>> entrySet()
  {
    return delegate().entrySet();
  }
  
  public boolean equals(@Nullable Object paramObject)
  {
    return (paramObject == this) || (delegate().equals(paramObject));
  }
  
  public V get(@Nullable Object paramObject)
  {
    return delegate().get(paramObject);
  }
  
  public int hashCode()
  {
    return delegate().hashCode();
  }
  
  public boolean isEmpty()
  {
    return delegate().isEmpty();
  }
  
  public Set<K> keySet()
  {
    return delegate().keySet();
  }
  
  @CanIgnoreReturnValue
  public V put(K paramK, V paramV)
  {
    return delegate().put(paramK, paramV);
  }
  
  public void putAll(Map<? extends K, ? extends V> paramMap)
  {
    delegate().putAll(paramMap);
  }
  
  @CanIgnoreReturnValue
  public V remove(Object paramObject)
  {
    return delegate().remove(paramObject);
  }
  
  public int size()
  {
    return delegate().size();
  }
  
  protected void standardClear()
  {
    Iterators.clear(entrySet().iterator());
  }
  
  @Beta
  protected boolean standardContainsKey(@Nullable Object paramObject)
  {
    return Maps.containsKeyImpl(this, paramObject);
  }
  
  protected boolean standardContainsValue(@Nullable Object paramObject)
  {
    return Maps.containsValueImpl(this, paramObject);
  }
  
  protected boolean standardEquals(@Nullable Object paramObject)
  {
    return Maps.equalsImpl(this, paramObject);
  }
  
  protected int standardHashCode()
  {
    return Sets.hashCodeImpl(entrySet());
  }
  
  protected boolean standardIsEmpty()
  {
    return !entrySet().iterator().hasNext();
  }
  
  protected void standardPutAll(Map<? extends K, ? extends V> paramMap)
  {
    Maps.putAllImpl(this, paramMap);
  }
  
  @Beta
  protected V standardRemove(@Nullable Object paramObject)
  {
    Iterator localIterator = entrySet().iterator();
    while (localIterator.hasNext())
    {
      Map.Entry localEntry = (Map.Entry)localIterator.next();
      if (Objects.equal(localEntry.getKey(), paramObject))
      {
        paramObject = localEntry.getValue();
        localIterator.remove();
        return paramObject;
      }
    }
    return null;
  }
  
  protected String standardToString()
  {
    return Maps.toStringImpl(this);
  }
  
  public Collection<V> values()
  {
    return delegate().values();
  }
  
  @Beta
  public abstract class StandardEntrySet
    extends Maps.EntrySet<K, V>
  {
    public StandardEntrySet() {}
    
    Map<K, V> map()
    {
      return ForwardingMap.this;
    }
  }
  
  @Beta
  public class StandardKeySet
    extends Maps.KeySet<K, V>
  {
    public StandardKeySet()
    {
      super();
    }
  }
  
  @Beta
  public class StandardValues
    extends Maps.Values<K, V>
  {
    public StandardValues()
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     com.google.common.collect.ForwardingMap
 * JD-Core Version:    0.7.0.1
 */