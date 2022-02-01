package com.google.common.collect;

import com.google.common.base.Function;
import java.util.Collection;

class Multimaps$UnmodifiableMultimap$1
  implements Function<Collection<V>, Collection<V>>
{
  Multimaps$UnmodifiableMultimap$1(Multimaps.UnmodifiableMultimap paramUnmodifiableMultimap) {}
  
  public Collection<V> apply(Collection<V> paramCollection)
  {
    return Multimaps.access$000(paramCollection);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     com.google.common.collect.Multimaps.UnmodifiableMultimap.1
 * JD-Core Version:    0.7.0.1
 */