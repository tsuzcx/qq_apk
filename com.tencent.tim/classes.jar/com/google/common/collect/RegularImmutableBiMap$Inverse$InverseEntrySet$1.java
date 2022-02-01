package com.google.common.collect;

import java.util.Map.Entry;

class RegularImmutableBiMap$Inverse$InverseEntrySet$1
  extends ImmutableAsList<Map.Entry<V, K>>
{
  RegularImmutableBiMap$Inverse$InverseEntrySet$1(RegularImmutableBiMap.Inverse.InverseEntrySet paramInverseEntrySet) {}
  
  ImmutableCollection<Map.Entry<V, K>> delegateCollection()
  {
    return this.this$2;
  }
  
  public Map.Entry<V, K> get(int paramInt)
  {
    Map.Entry localEntry = RegularImmutableBiMap.access$400(this.this$2.this$1.this$0)[paramInt];
    return Maps.immutableEntry(localEntry.getValue(), localEntry.getKey());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     com.google.common.collect.RegularImmutableBiMap.Inverse.InverseEntrySet.1
 * JD-Core Version:    0.7.0.1
 */