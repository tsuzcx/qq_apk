package com.google.common.collect;

import com.google.common.base.Function;

final class Maps$7
  implements Maps.EntryTransformer<K, V1, V2>
{
  Maps$7(Function paramFunction) {}
  
  public V2 transformEntry(K paramK, V1 paramV1)
  {
    return this.val$function.apply(paramV1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     com.google.common.collect.Maps.7
 * JD-Core Version:    0.7.0.1
 */