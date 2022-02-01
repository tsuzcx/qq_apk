package com.google.common.collect;

import java.util.Collection;
import java.util.Iterator;

class Synchronized$SynchronizedAsMapValues$1
  extends TransformedIterator<Collection<V>, Collection<V>>
{
  Synchronized$SynchronizedAsMapValues$1(Synchronized.SynchronizedAsMapValues paramSynchronizedAsMapValues, Iterator paramIterator)
  {
    super(paramIterator);
  }
  
  Collection<V> transform(Collection<V> paramCollection)
  {
    return Synchronized.access$400(paramCollection, this.this$0.mutex);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     com.google.common.collect.Synchronized.SynchronizedAsMapValues.1
 * JD-Core Version:    0.7.0.1
 */