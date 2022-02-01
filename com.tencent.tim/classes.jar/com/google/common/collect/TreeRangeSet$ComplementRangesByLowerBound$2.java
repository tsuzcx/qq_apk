package com.google.common.collect;

import java.util.Map.Entry;

class TreeRangeSet$ComplementRangesByLowerBound$2
  extends AbstractIterator<Map.Entry<Cut<C>, Range<C>>>
{
  Cut<C> nextComplementRangeUpperBound = this.val$firstComplementRangeUpperBound;
  
  TreeRangeSet$ComplementRangesByLowerBound$2(TreeRangeSet.ComplementRangesByLowerBound paramComplementRangesByLowerBound, Cut paramCut, PeekingIterator paramPeekingIterator) {}
  
  protected Map.Entry<Cut<C>, Range<C>> computeNext()
  {
    if (this.nextComplementRangeUpperBound == Cut.belowAll()) {
      return (Map.Entry)endOfData();
    }
    Range localRange1;
    if (this.val$positiveItr.hasNext())
    {
      localRange1 = (Range)this.val$positiveItr.next();
      Range localRange2 = Range.create(localRange1.upperBound, this.nextComplementRangeUpperBound);
      this.nextComplementRangeUpperBound = localRange1.lowerBound;
      if (TreeRangeSet.ComplementRangesByLowerBound.access$100(this.this$0).lowerBound.isLessThan(localRange2.lowerBound)) {
        return Maps.immutableEntry(localRange2.lowerBound, localRange2);
      }
    }
    else if (TreeRangeSet.ComplementRangesByLowerBound.access$100(this.this$0).lowerBound.isLessThan(Cut.belowAll()))
    {
      localRange1 = Range.create(Cut.belowAll(), this.nextComplementRangeUpperBound);
      this.nextComplementRangeUpperBound = Cut.belowAll();
      return Maps.immutableEntry(Cut.belowAll(), localRange1);
    }
    return (Map.Entry)endOfData();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     com.google.common.collect.TreeRangeSet.ComplementRangesByLowerBound.2
 * JD-Core Version:    0.7.0.1
 */