package com.google.common.collect;

import java.util.Map.Entry;

class TreeRangeSet$ComplementRangesByLowerBound$1
  extends AbstractIterator<Map.Entry<Cut<C>, Range<C>>>
{
  Cut<C> nextComplementRangeLowerBound = this.val$firstComplementRangeLowerBound;
  
  TreeRangeSet$ComplementRangesByLowerBound$1(TreeRangeSet.ComplementRangesByLowerBound paramComplementRangesByLowerBound, Cut paramCut, PeekingIterator paramPeekingIterator) {}
  
  protected Map.Entry<Cut<C>, Range<C>> computeNext()
  {
    if ((TreeRangeSet.ComplementRangesByLowerBound.access$100(this.this$0).upperBound.isLessThan(this.nextComplementRangeLowerBound)) || (this.nextComplementRangeLowerBound == Cut.aboveAll())) {
      return (Map.Entry)endOfData();
    }
    Range localRange2;
    Range localRange1;
    if (this.val$positiveItr.hasNext())
    {
      localRange2 = (Range)this.val$positiveItr.next();
      localRange1 = Range.create(this.nextComplementRangeLowerBound, localRange2.lowerBound);
    }
    for (this.nextComplementRangeLowerBound = localRange2.upperBound;; this.nextComplementRangeLowerBound = Cut.aboveAll())
    {
      return Maps.immutableEntry(localRange1.lowerBound, localRange1);
      localRange1 = Range.create(this.nextComplementRangeLowerBound, Cut.aboveAll());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     com.google.common.collect.TreeRangeSet.ComplementRangesByLowerBound.1
 * JD-Core Version:    0.7.0.1
 */