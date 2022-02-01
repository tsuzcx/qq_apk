package com.google.common.collect;

import java.util.Collection;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

class MapConstraints$ConstrainedMultimap$1AsMap
  extends ForwardingMap<K, Collection<V>>
{
  Set<Map.Entry<K, Collection<V>>> entrySet;
  Collection<Collection<V>> values;
  
  public boolean containsValue(Object paramObject)
  {
    return values().contains(paramObject);
  }
  
  protected Map<K, Collection<V>> delegate()
  {
    return this.val$asMapDelegate;
  }
  
  public Set<Map.Entry<K, Collection<V>>> entrySet()
  {
    Set localSet2 = this.entrySet;
    Set localSet1 = localSet2;
    if (localSet2 == null)
    {
      localSet1 = MapConstraints.access$200(this.val$asMapDelegate.entrySet(), this.this$0.constraint);
      this.entrySet = localSet1;
    }
    return localSet1;
  }
  
  public Collection<V> get(Object paramObject)
  {
    try
    {
      paramObject = this.this$0.get(paramObject);
      boolean bool = paramObject.isEmpty();
      if (bool) {
        return null;
      }
      return paramObject;
    }
    catch (ClassCastException paramObject) {}
    return null;
  }
  
  public Collection<Collection<V>> values()
  {
    Collection localCollection = this.values;
    Object localObject = localCollection;
    if (localCollection == null)
    {
      localObject = new MapConstraints.ConstrainedAsMapValues(delegate().values(), entrySet());
      this.values = ((Collection)localObject);
    }
    return localObject;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     com.google.common.collect.MapConstraints.ConstrainedMultimap.1AsMap
 * JD-Core Version:    0.7.0.1
 */