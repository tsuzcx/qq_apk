package com.google.common.collect;

import java.util.Map.Entry;

class ArrayTable$ArrayMap$1
  extends AbstractIndexedListIterator<Map.Entry<K, V>>
{
  ArrayTable$ArrayMap$1(ArrayTable.ArrayMap paramArrayMap, int paramInt)
  {
    super(paramInt);
  }
  
  protected Map.Entry<K, V> get(int paramInt)
  {
    return new ArrayTable.ArrayMap.1.1(this, paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     com.google.common.collect.ArrayTable.ArrayMap.1
 * JD-Core Version:    0.7.0.1
 */