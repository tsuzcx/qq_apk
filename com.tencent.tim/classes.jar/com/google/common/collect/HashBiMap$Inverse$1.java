package com.google.common.collect;

import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;

class HashBiMap$Inverse$1
  extends Maps.EntrySet<V, K>
{
  HashBiMap$Inverse$1(HashBiMap.Inverse paramInverse) {}
  
  public Iterator<Map.Entry<V, K>> iterator()
  {
    return new HashBiMap.Inverse.1.1(this);
  }
  
  Map<V, K> map()
  {
    return this.this$1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     com.google.common.collect.HashBiMap.Inverse.1
 * JD-Core Version:    0.7.0.1
 */