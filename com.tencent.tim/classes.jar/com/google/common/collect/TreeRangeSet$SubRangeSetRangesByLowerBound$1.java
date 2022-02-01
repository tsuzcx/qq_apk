package com.google.common.collect;

import java.util.Iterator;
import java.util.Map.Entry;

class TreeRangeSet$SubRangeSetRangesByLowerBound$1
  extends AbstractIterator<Map.Entry<Cut<C>, Range<C>>>
{
  TreeRangeSet$SubRangeSetRangesByLowerBound$1(TreeRangeSet.SubRangeSetRangesByLowerBound paramSubRangeSetRangesByLowerBound, Iterator paramIterator, Cut paramCut) {}
  
  protected Map.Entry<Cut<C>, Range<C>> computeNext()
  {
    if (!this.val$completeRangeItr.hasNext()) {
      return (Map.Entry)endOfData();
    }
    Range localRange = (Range)this.val$completeRangeItr.next();
    if (this.val$upperBoundOnLowerBounds.isLessThan(localRange.lowerBound)) {
      return (Map.Entry)endOfData();
    }
    localRange = localRange.intersection(TreeRangeSet.SubRangeSetRangesByLowerBound.access$300(this.this$0));
    return Maps.immutableEntry(localRange.lowerBound, localRange);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     com.google.common.collect.TreeRangeSet.SubRangeSetRangesByLowerBound.1
 * JD-Core Version:    0.7.0.1
 */