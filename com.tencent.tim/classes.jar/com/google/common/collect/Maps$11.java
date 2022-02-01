package com.google.common.collect;

import com.google.common.base.Function;
import java.util.Map.Entry;

final class Maps$11
  implements Function<Map.Entry<K, V1>, Map.Entry<K, V2>>
{
  Maps$11(Maps.EntryTransformer paramEntryTransformer) {}
  
  public Map.Entry<K, V2> apply(Map.Entry<K, V1> paramEntry)
  {
    return Maps.transformEntry(this.val$transformer, paramEntry);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     com.google.common.collect.Maps.11
 * JD-Core Version:    0.7.0.1
 */