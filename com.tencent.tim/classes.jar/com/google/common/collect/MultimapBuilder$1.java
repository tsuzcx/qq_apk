package com.google.common.collect;

import java.util.Collection;
import java.util.Map;

final class MultimapBuilder$1
  extends MultimapBuilder.MultimapBuilderWithKeys<Object>
{
  MultimapBuilder$1(int paramInt) {}
  
  <K, V> Map<K, Collection<V>> createMap()
  {
    return Maps.newHashMapWithExpectedSize(this.val$expectedKeys);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     com.google.common.collect.MultimapBuilder.1
 * JD-Core Version:    0.7.0.1
 */