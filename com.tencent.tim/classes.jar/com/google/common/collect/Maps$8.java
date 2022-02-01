package com.google.common.collect;

import com.google.common.base.Function;
import javax.annotation.Nullable;

final class Maps$8
  implements Function<V1, V2>
{
  Maps$8(Maps.EntryTransformer paramEntryTransformer, Object paramObject) {}
  
  public V2 apply(@Nullable V1 paramV1)
  {
    return this.val$transformer.transformEntry(this.val$key, paramV1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     com.google.common.collect.Maps.8
 * JD-Core Version:    0.7.0.1
 */