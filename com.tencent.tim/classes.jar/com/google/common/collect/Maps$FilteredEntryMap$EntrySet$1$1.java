package com.google.common.collect;

import com.google.common.base.Preconditions;
import java.util.Map.Entry;

class Maps$FilteredEntryMap$EntrySet$1$1
  extends ForwardingMapEntry<K, V>
{
  Maps$FilteredEntryMap$EntrySet$1$1(Maps.FilteredEntryMap.EntrySet.1 param1, Map.Entry paramEntry) {}
  
  protected Map.Entry<K, V> delegate()
  {
    return this.val$entry;
  }
  
  public V setValue(V paramV)
  {
    Preconditions.checkArgument(this.this$2.this$1.this$0.apply(getKey(), paramV));
    return super.setValue(paramV);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     com.google.common.collect.Maps.FilteredEntryMap.EntrySet.1.1
 * JD-Core Version:    0.7.0.1
 */