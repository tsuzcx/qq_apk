package com.google.common.collect;

import java.util.Map.Entry;

class ImmutableMultimap$1
  extends ImmutableMultimap<K, V>.Itr<Map.Entry<K, V>>
{
  ImmutableMultimap$1(ImmutableMultimap paramImmutableMultimap)
  {
    super(paramImmutableMultimap, null);
  }
  
  Map.Entry<K, V> output(K paramK, V paramV)
  {
    return Maps.immutableEntry(paramK, paramV);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     com.google.common.collect.ImmutableMultimap.1
 * JD-Core Version:    0.7.0.1
 */