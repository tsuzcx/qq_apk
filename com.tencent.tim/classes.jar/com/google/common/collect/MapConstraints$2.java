package com.google.common.collect;

import java.util.Collection;
import java.util.Map.Entry;

final class MapConstraints$2
  extends ForwardingMapEntry<K, Collection<V>>
{
  MapConstraints$2(Map.Entry paramEntry, MapConstraint paramMapConstraint) {}
  
  protected Map.Entry<K, Collection<V>> delegate()
  {
    return this.val$entry;
  }
  
  public Collection<V> getValue()
  {
    return Constraints.constrainedTypePreservingCollection((Collection)this.val$entry.getValue(), new MapConstraints.2.1(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     com.google.common.collect.MapConstraints.2
 * JD-Core Version:    0.7.0.1
 */