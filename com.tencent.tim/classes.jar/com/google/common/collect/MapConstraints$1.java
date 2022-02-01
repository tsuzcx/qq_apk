package com.google.common.collect;

import java.util.Map.Entry;

final class MapConstraints$1
  extends ForwardingMapEntry<K, V>
{
  MapConstraints$1(Map.Entry paramEntry, MapConstraint paramMapConstraint) {}
  
  protected Map.Entry<K, V> delegate()
  {
    return this.val$entry;
  }
  
  public V setValue(V paramV)
  {
    this.val$constraint.checkKeyValue(getKey(), paramV);
    return this.val$entry.setValue(paramV);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     com.google.common.collect.MapConstraints.1
 * JD-Core Version:    0.7.0.1
 */