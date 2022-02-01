package com.google.common.collect;

import java.util.Iterator;

class ImmutableRangeSet$AsSet$1
  extends AbstractIterator<C>
{
  Iterator<C> elemItr = Iterators.emptyIterator();
  final Iterator<Range<C>> rangeItr = ImmutableRangeSet.access$000(this.this$1.this$0).iterator();
  
  ImmutableRangeSet$AsSet$1(ImmutableRangeSet.AsSet paramAsSet) {}
  
  protected C computeNext()
  {
    while (!this.elemItr.hasNext()) {
      if (this.rangeItr.hasNext()) {
        this.elemItr = ContiguousSet.create((Range)this.rangeItr.next(), ImmutableRangeSet.AsSet.access$100(this.this$1)).iterator();
      } else {
        return (Comparable)endOfData();
      }
    }
    return (Comparable)this.elemItr.next();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     com.google.common.collect.ImmutableRangeSet.AsSet.1
 * JD-Core Version:    0.7.0.1
 */