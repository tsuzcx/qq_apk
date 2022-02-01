package com.google.common.collect;

import java.util.Iterator;
import java.util.Map.Entry;

class TreeRangeMap$SubRangeMap$SubRangeMapAsMap$3
  extends AbstractIterator<Map.Entry<Range<K>, V>>
{
  TreeRangeMap$SubRangeMap$SubRangeMapAsMap$3(TreeRangeMap.SubRangeMap.SubRangeMapAsMap paramSubRangeMapAsMap, Iterator paramIterator) {}
  
  protected Map.Entry<Range<K>, V> computeNext()
  {
    while (this.val$backingItr.hasNext())
    {
      TreeRangeMap.RangeMapEntry localRangeMapEntry = (TreeRangeMap.RangeMapEntry)this.val$backingItr.next();
      if (localRangeMapEntry.getLowerBound().compareTo(TreeRangeMap.SubRangeMap.access$200(this.this$2.this$1).upperBound) >= 0) {
        return (Map.Entry)endOfData();
      }
      if (localRangeMapEntry.getUpperBound().compareTo(TreeRangeMap.SubRangeMap.access$200(this.this$2.this$1).lowerBound) > 0) {
        return Maps.immutableEntry(localRangeMapEntry.getKey().intersection(TreeRangeMap.SubRangeMap.access$200(this.this$2.this$1)), localRangeMapEntry.getValue());
      }
    }
    return (Map.Entry)endOfData();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     com.google.common.collect.TreeRangeMap.SubRangeMap.SubRangeMapAsMap.3
 * JD-Core Version:    0.7.0.1
 */