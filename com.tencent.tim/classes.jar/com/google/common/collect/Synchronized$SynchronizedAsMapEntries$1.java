package com.google.common.collect;

import java.util.Collection;
import java.util.Iterator;
import java.util.Map.Entry;

class Synchronized$SynchronizedAsMapEntries$1
  extends TransformedIterator<Map.Entry<K, Collection<V>>, Map.Entry<K, Collection<V>>>
{
  Synchronized$SynchronizedAsMapEntries$1(Synchronized.SynchronizedAsMapEntries paramSynchronizedAsMapEntries, Iterator paramIterator)
  {
    super(paramIterator);
  }
  
  Map.Entry<K, Collection<V>> transform(Map.Entry<K, Collection<V>> paramEntry)
  {
    return new Synchronized.SynchronizedAsMapEntries.1.1(this, paramEntry);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     com.google.common.collect.Synchronized.SynchronizedAsMapEntries.1
 * JD-Core Version:    0.7.0.1
 */