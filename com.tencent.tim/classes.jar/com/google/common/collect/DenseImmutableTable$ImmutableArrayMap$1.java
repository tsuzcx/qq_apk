package com.google.common.collect;

import java.util.Map.Entry;

class DenseImmutableTable$ImmutableArrayMap$1
  extends AbstractIterator<Map.Entry<K, V>>
{
  private int index = -1;
  private final int maxIndex = this.this$0.keyToIndex().size();
  
  DenseImmutableTable$ImmutableArrayMap$1(DenseImmutableTable.ImmutableArrayMap paramImmutableArrayMap) {}
  
  protected Map.Entry<K, V> computeNext()
  {
    for (this.index += 1; this.index < this.maxIndex; this.index += 1)
    {
      Object localObject = this.this$0.getValue(this.index);
      if (localObject != null) {
        return Maps.immutableEntry(this.this$0.getKey(this.index), localObject);
      }
    }
    return (Map.Entry)endOfData();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     com.google.common.collect.DenseImmutableTable.ImmutableArrayMap.1
 * JD-Core Version:    0.7.0.1
 */