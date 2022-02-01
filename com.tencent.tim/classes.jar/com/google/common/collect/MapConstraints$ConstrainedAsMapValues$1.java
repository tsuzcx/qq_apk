package com.google.common.collect;

import java.util.Collection;
import java.util.Iterator;
import java.util.Map.Entry;

class MapConstraints$ConstrainedAsMapValues$1
  implements Iterator<Collection<V>>
{
  MapConstraints$ConstrainedAsMapValues$1(MapConstraints.ConstrainedAsMapValues paramConstrainedAsMapValues, Iterator paramIterator) {}
  
  public boolean hasNext()
  {
    return this.val$iterator.hasNext();
  }
  
  public Collection<V> next()
  {
    return (Collection)((Map.Entry)this.val$iterator.next()).getValue();
  }
  
  public void remove()
  {
    this.val$iterator.remove();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     com.google.common.collect.MapConstraints.ConstrainedAsMapValues.1
 * JD-Core Version:    0.7.0.1
 */