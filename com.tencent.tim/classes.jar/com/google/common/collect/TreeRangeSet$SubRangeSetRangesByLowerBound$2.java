package com.google.common.collect;

import java.util.Iterator;
import java.util.Map.Entry;

class TreeRangeSet$SubRangeSetRangesByLowerBound$2
  extends AbstractIterator<Map.Entry<Cut<C>, Range<C>>>
{
  TreeRangeSet$SubRangeSetRangesByLowerBound$2(TreeRangeSet.SubRangeSetRangesByLowerBound paramSubRangeSetRangesByLowerBound, Iterator paramIterator) {}
  
  protected Map.Entry<Cut<C>, Range<C>> computeNext()
  {
    if (!this.val$completeRangeItr.hasNext()) {
      return (Map.Entry)endOfData();
    }
    Range localRange = (Range)this.val$completeRangeItr.next();
    if (TreeRangeSet.SubRangeSetRangesByLowerBound.access$300(this.this$0).lowerBound.compareTo(localRange.upperBound) >= 0) {
      return (Map.Entry)endOfData();
    }
    localRange = localRange.intersection(TreeRangeSet.SubRangeSetRangesByLowerBound.access$300(this.this$0));
    if (TreeRangeSet.SubRangeSetRangesByLowerBound.access$400(this.this$0).contains(localRange.lowerBound)) {
      return Maps.immutableEntry(localRange.lowerBound, localRange);
    }
    return (Map.Entry)endOfData();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     com.google.common.collect.TreeRangeSet.SubRangeSetRangesByLowerBound.2
 * JD-Core Version:    0.7.0.1
 */