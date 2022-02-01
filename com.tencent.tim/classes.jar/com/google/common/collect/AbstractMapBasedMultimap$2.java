package com.google.common.collect;

import java.util.Map.Entry;

class AbstractMapBasedMultimap$2
  extends AbstractMapBasedMultimap<K, V>.Itr<Map.Entry<K, V>>
{
  AbstractMapBasedMultimap$2(AbstractMapBasedMultimap paramAbstractMapBasedMultimap)
  {
    super(paramAbstractMapBasedMultimap);
  }
  
  Map.Entry<K, V> output(K paramK, V paramV)
  {
    return Maps.immutableEntry(paramK, paramV);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     com.google.common.collect.AbstractMapBasedMultimap.2
 * JD-Core Version:    0.7.0.1
 */