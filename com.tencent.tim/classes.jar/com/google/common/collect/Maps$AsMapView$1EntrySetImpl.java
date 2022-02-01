package com.google.common.collect;

import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;

class Maps$AsMapView$1EntrySetImpl
  extends Maps.EntrySet<K, V>
{
  Maps$AsMapView$1EntrySetImpl(Maps.AsMapView paramAsMapView) {}
  
  public Iterator<Map.Entry<K, V>> iterator()
  {
    return Maps.asMapEntryIterator(this.this$0.backingSet(), this.this$0.function);
  }
  
  Map<K, V> map()
  {
    return this.this$0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     com.google.common.collect.Maps.AsMapView.1EntrySetImpl
 * JD-Core Version:    0.7.0.1
 */