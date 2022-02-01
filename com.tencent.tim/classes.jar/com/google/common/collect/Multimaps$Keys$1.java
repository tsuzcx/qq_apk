package com.google.common.collect;

import java.util.Collection;
import java.util.Iterator;
import java.util.Map.Entry;

class Multimaps$Keys$1
  extends TransformedIterator<Map.Entry<K, Collection<V>>, Multiset.Entry<K>>
{
  Multimaps$Keys$1(Multimaps.Keys paramKeys, Iterator paramIterator)
  {
    super(paramIterator);
  }
  
  Multiset.Entry<K> transform(Map.Entry<K, Collection<V>> paramEntry)
  {
    return new Multimaps.Keys.1.1(this, paramEntry);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     com.google.common.collect.Multimaps.Keys.1
 * JD-Core Version:    0.7.0.1
 */