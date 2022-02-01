package com.google.common.collect;

import com.google.common.base.Preconditions;
import java.util.Map;
import java.util.Map.Entry;

class StandardTable$Column$EntrySetIterator$1EntryImpl
  extends AbstractMapEntry<R, V>
{
  public R getKey()
  {
    return this.val$entry.getKey();
  }
  
  public V getValue()
  {
    return ((Map)this.val$entry.getValue()).get(this.this$2.this$1.columnKey);
  }
  
  public V setValue(V paramV)
  {
    return ((Map)this.val$entry.getValue()).put(this.this$2.this$1.columnKey, Preconditions.checkNotNull(paramV));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     com.google.common.collect.StandardTable.Column.EntrySetIterator.1EntryImpl
 * JD-Core Version:    0.7.0.1
 */