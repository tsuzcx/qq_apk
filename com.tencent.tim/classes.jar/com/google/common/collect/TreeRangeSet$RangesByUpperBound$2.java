package com.google.common.collect;

import java.util.Map.Entry;

class TreeRangeSet$RangesByUpperBound$2
  extends AbstractIterator<Map.Entry<Cut<C>, Range<C>>>
{
  TreeRangeSet$RangesByUpperBound$2(TreeRangeSet.RangesByUpperBound paramRangesByUpperBound, PeekingIterator paramPeekingIterator) {}
  
  protected Map.Entry<Cut<C>, Range<C>> computeNext()
  {
    if (!this.val$backingItr.hasNext()) {
      return (Map.Entry)endOfData();
    }
    Range localRange = (Range)this.val$backingItr.next();
    if (TreeRangeSet.RangesByUpperBound.access$000(this.this$0).lowerBound.isLessThan(localRange.upperBound)) {
      return Maps.immutableEntry(localRange.upperBound, localRange);
    }
    return (Map.Entry)endOfData();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     com.google.common.collect.TreeRangeSet.RangesByUpperBound.2
 * JD-Core Version:    0.7.0.1
 */