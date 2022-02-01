package com.google.common.graph;

import com.google.common.collect.UnmodifiableIterator;
import java.util.Iterator;
import java.util.Map.Entry;

class MapIteratorCache$1$1
  extends UnmodifiableIterator<K>
{
  MapIteratorCache$1$1(MapIteratorCache.1 param1, Iterator paramIterator) {}
  
  public boolean hasNext()
  {
    return this.val$entryIterator.hasNext();
  }
  
  public K next()
  {
    Map.Entry localEntry = (Map.Entry)this.val$entryIterator.next();
    MapIteratorCache.access$102(this.this$1.this$0, localEntry);
    return localEntry.getKey();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     com.google.common.graph.MapIteratorCache.1.1
 * JD-Core Version:    0.7.0.1
 */