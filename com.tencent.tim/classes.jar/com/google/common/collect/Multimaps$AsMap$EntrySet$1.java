package com.google.common.collect;

import com.google.common.base.Function;
import java.util.Collection;

class Multimaps$AsMap$EntrySet$1
  implements Function<K, Collection<V>>
{
  Multimaps$AsMap$EntrySet$1(Multimaps.AsMap.EntrySet paramEntrySet) {}
  
  public Collection<V> apply(K paramK)
  {
    return Multimaps.AsMap.access$200(this.this$1.this$0).get(paramK);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     com.google.common.collect.Multimaps.AsMap.EntrySet.1
 * JD-Core Version:    0.7.0.1
 */