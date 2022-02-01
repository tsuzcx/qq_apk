package com.google.common.collect;

import com.google.common.annotations.GwtCompatible;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

@GwtCompatible
final class WellBehavedMap<K, V>
  extends ForwardingMap<K, V>
{
  private final Map<K, V> delegate;
  private Set<Map.Entry<K, V>> entrySet;
  
  private WellBehavedMap(Map<K, V> paramMap)
  {
    this.delegate = paramMap;
  }
  
  static <K, V> WellBehavedMap<K, V> wrap(Map<K, V> paramMap)
  {
    return new WellBehavedMap(paramMap);
  }
  
  protected Map<K, V> delegate()
  {
    return this.delegate;
  }
  
  public Set<Map.Entry<K, V>> entrySet()
  {
    Object localObject = this.entrySet;
    if (localObject != null) {
      return localObject;
    }
    localObject = new EntrySet(null);
    this.entrySet = ((Set)localObject);
    return localObject;
  }
  
  final class EntrySet
    extends Maps.EntrySet<K, V>
  {
    private EntrySet() {}
    
    public Iterator<Map.Entry<K, V>> iterator()
    {
      return new WellBehavedMap.EntrySet.1(this, WellBehavedMap.this.keySet().iterator());
    }
    
    Map<K, V> map()
    {
      return WellBehavedMap.this;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     com.google.common.collect.WellBehavedMap
 * JD-Core Version:    0.7.0.1
 */