package com.google.common.collect;

import java.util.Iterator;
import java.util.Map.Entry;

class TreeRangeSet$RangesByUpperBound$1
  extends AbstractIterator<Map.Entry<Cut<C>, Range<C>>>
{
  TreeRangeSet$RangesByUpperBound$1(TreeRangeSet.RangesByUpperBound paramRangesByUpperBound, Iterator paramIterator) {}
  
  protected Map.Entry<Cut<C>, Range<C>> computeNext()
  {
    if (!this.val$backingItr.hasNext()) {
      return (Map.Entry)endOfData();
    }
    Range localRange = (Range)this.val$backingItr.next();
    if (TreeRangeSet.RangesByUpperBound.access$000(this.this$0).upperBound.isLessThan(localRange.upperBound)) {
      return (Map.Entry)endOfData();
    }
    return Maps.immutableEntry(localRange.upperBound, localRange);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     com.google.common.collect.TreeRangeSet.RangesByUpperBound.1
 * JD-Core Version:    0.7.0.1
 */