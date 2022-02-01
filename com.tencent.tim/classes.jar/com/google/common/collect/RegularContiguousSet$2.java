package com.google.common.collect;

class RegularContiguousSet$2
  extends AbstractSequentialIterator<C>
{
  final C first = this.this$0.first();
  
  RegularContiguousSet$2(RegularContiguousSet paramRegularContiguousSet, Comparable paramComparable)
  {
    super(paramComparable);
  }
  
  protected C computeNext(C paramC)
  {
    if (RegularContiguousSet.access$000(paramC, this.first)) {
      return null;
    }
    return this.this$0.domain.previous(paramC);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     com.google.common.collect.RegularContiguousSet.2
 * JD-Core Version:    0.7.0.1
 */