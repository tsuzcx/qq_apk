package com.google.common.collect;

import java.util.Iterator;
import java.util.Map;

class Multimaps$MapMultimap$1
  extends Sets.ImprovedAbstractSet<V>
{
  Multimaps$MapMultimap$1(Multimaps.MapMultimap paramMapMultimap, Object paramObject) {}
  
  public Iterator<V> iterator()
  {
    return new Multimaps.MapMultimap.1.1(this);
  }
  
  public int size()
  {
    if (this.this$0.map.containsKey(this.val$key)) {
      return 1;
    }
    return 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     com.google.common.collect.Multimaps.MapMultimap.1
 * JD-Core Version:    0.7.0.1
 */