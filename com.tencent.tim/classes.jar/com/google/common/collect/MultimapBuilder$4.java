package com.google.common.collect;

import java.util.Collection;
import java.util.EnumMap;
import java.util.Map;

final class MultimapBuilder$4
  extends MultimapBuilder.MultimapBuilderWithKeys<K0>
{
  MultimapBuilder$4(Class paramClass) {}
  
  <K extends K0, V> Map<K, Collection<V>> createMap()
  {
    return new EnumMap(this.val$keyClass);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     com.google.common.collect.MultimapBuilder.4
 * JD-Core Version:    0.7.0.1
 */