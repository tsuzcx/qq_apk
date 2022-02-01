package com.google.common.collect;

import java.util.Map.Entry;

class ImmutableMapValues$2
  extends ImmutableAsList<V>
{
  ImmutableMapValues$2(ImmutableMapValues paramImmutableMapValues, ImmutableList paramImmutableList) {}
  
  ImmutableCollection<V> delegateCollection()
  {
    return this.this$0;
  }
  
  public V get(int paramInt)
  {
    return ((Map.Entry)this.val$entryList.get(paramInt)).getValue();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     com.google.common.collect.ImmutableMapValues.2
 * JD-Core Version:    0.7.0.1
 */