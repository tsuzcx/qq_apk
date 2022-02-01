package com.google.common.collect;

import java.util.Iterator;
import java.util.Map.Entry;

class TreeRangeMap$SubRangeMap$1$1
  extends AbstractIterator<Map.Entry<Range<K>, V>>
{
  TreeRangeMap$SubRangeMap$1$1(TreeRangeMap.SubRangeMap.1 param1, Iterator paramIterator) {}
  
  protected Map.Entry<Range<K>, V> computeNext()
  {
    if (this.val$backingItr.hasNext())
    {
      TreeRangeMap.RangeMapEntry localRangeMapEntry = (TreeRangeMap.RangeMapEntry)this.val$backingItr.next();
      if (localRangeMapEntry.getUpperBound().compareTo(TreeRangeMap.SubRangeMap.access$200(this.this$2.this$1).lowerBound) <= 0) {
        return (Map.Entry)endOfData();
      }
      return Maps.immutableEntry(localRangeMapEntry.getKey().intersection(TreeRangeMap.SubRangeMap.access$200(this.this$2.this$1)), localRangeMapEntry.getValue());
    }
    return (Map.Entry)endOfData();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     com.google.common.collect.TreeRangeMap.SubRangeMap.1.1
 * JD-Core Version:    0.7.0.1
 */