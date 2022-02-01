package com.google.common.collect;

import com.google.common.base.Function;
import java.util.Map.Entry;

final class Maps$9
  implements Function<Map.Entry<K, V1>, V2>
{
  Maps$9(Maps.EntryTransformer paramEntryTransformer) {}
  
  public V2 apply(Map.Entry<K, V1> paramEntry)
  {
    return this.val$transformer.transformEntry(paramEntry.getKey(), paramEntry.getValue());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     com.google.common.collect.Maps.9
 * JD-Core Version:    0.7.0.1
 */