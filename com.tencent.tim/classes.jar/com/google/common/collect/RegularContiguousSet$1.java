package com.google.common.collect;

class RegularContiguousSet$1
  extends AbstractSequentialIterator<C>
{
  final C last = this.this$0.last();
  
  RegularContiguousSet$1(RegularContiguousSet paramRegularContiguousSet, Comparable paramComparable)
  {
    super(paramComparable);
  }
  
  protected C computeNext(C paramC)
  {
    if (RegularContiguousSet.access$000(paramC, this.last)) {
      return null;
    }
    return this.this$0.domain.next(paramC);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     com.google.common.collect.RegularContiguousSet.1
 * JD-Core Version:    0.7.0.1
 */