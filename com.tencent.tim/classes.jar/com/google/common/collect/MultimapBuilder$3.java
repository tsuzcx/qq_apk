package com.google.common.collect;

import java.util.Collection;
import java.util.Comparator;
import java.util.Map;
import java.util.TreeMap;

final class MultimapBuilder$3
  extends MultimapBuilder.MultimapBuilderWithKeys<K0>
{
  MultimapBuilder$3(Comparator paramComparator) {}
  
  <K extends K0, V> Map<K, Collection<V>> createMap()
  {
    return new TreeMap(this.val$comparator);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     com.google.common.collect.MultimapBuilder.3
 * JD-Core Version:    0.7.0.1
 */