package com.google.common.collect;

import com.google.common.base.Preconditions;
import java.util.Map.Entry;

class StandardTable$Row$1$1
  extends ForwardingMapEntry<C, V>
{
  StandardTable$Row$1$1(StandardTable.Row.1 param1, Map.Entry paramEntry) {}
  
  protected Map.Entry<C, V> delegate()
  {
    return this.val$entry;
  }
  
  public boolean equals(Object paramObject)
  {
    return standardEquals(paramObject);
  }
  
  public V setValue(V paramV)
  {
    return super.setValue(Preconditions.checkNotNull(paramV));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     com.google.common.collect.StandardTable.Row.1.1
 * JD-Core Version:    0.7.0.1
 */