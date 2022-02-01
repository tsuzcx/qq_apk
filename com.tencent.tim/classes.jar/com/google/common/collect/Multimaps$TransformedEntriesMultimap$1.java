package com.google.common.collect;

import java.util.Collection;

class Multimaps$TransformedEntriesMultimap$1
  implements Maps.EntryTransformer<K, Collection<V1>, Collection<V2>>
{
  Multimaps$TransformedEntriesMultimap$1(Multimaps.TransformedEntriesMultimap paramTransformedEntriesMultimap) {}
  
  public Collection<V2> transformEntry(K paramK, Collection<V1> paramCollection)
  {
    return this.this$0.transform(paramK, paramCollection);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     com.google.common.collect.Multimaps.TransformedEntriesMultimap.1
 * JD-Core Version:    0.7.0.1
 */