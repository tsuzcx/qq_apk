package com.google.common.graph;

import com.google.common.collect.UnmodifiableIterator;
import java.util.AbstractSet;
import java.util.Map;
import java.util.Set;
import javax.annotation.Nullable;

class MapIteratorCache$1
  extends AbstractSet<K>
{
  MapIteratorCache$1(MapIteratorCache paramMapIteratorCache) {}
  
  public boolean contains(@Nullable Object paramObject)
  {
    return this.this$0.containsKey(paramObject);
  }
  
  public UnmodifiableIterator<K> iterator()
  {
    return new MapIteratorCache.1.1(this, MapIteratorCache.access$000(this.this$0).entrySet().iterator());
  }
  
  public int size()
  {
    return MapIteratorCache.access$000(this.this$0).size();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     com.google.common.graph.MapIteratorCache.1
 * JD-Core Version:    0.7.0.1
 */