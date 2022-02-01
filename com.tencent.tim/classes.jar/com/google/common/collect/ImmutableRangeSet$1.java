package com.google.common.collect;

import com.google.common.base.Preconditions;

class ImmutableRangeSet$1
  extends ImmutableList<Range<C>>
{
  ImmutableRangeSet$1(ImmutableRangeSet paramImmutableRangeSet, int paramInt1, int paramInt2, Range paramRange) {}
  
  public Range<C> get(int paramInt)
  {
    Preconditions.checkElementIndex(paramInt, this.val$length);
    if ((paramInt == 0) || (paramInt == this.val$length - 1)) {
      return ((Range)ImmutableRangeSet.access$000(this.this$0).get(this.val$fromIndex + paramInt)).intersection(this.val$range);
    }
    return (Range)ImmutableRangeSet.access$000(this.this$0).get(this.val$fromIndex + paramInt);
  }
  
  boolean isPartialView()
  {
    return true;
  }
  
  public int size()
  {
    return this.val$length;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     com.google.common.collect.ImmutableRangeSet.1
 * JD-Core Version:    0.7.0.1
 */