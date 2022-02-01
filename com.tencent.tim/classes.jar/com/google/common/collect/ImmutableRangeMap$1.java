package com.google.common.collect;

import com.google.common.base.Preconditions;

class ImmutableRangeMap$1
  extends ImmutableList<Range<K>>
{
  ImmutableRangeMap$1(ImmutableRangeMap paramImmutableRangeMap, int paramInt1, int paramInt2, Range paramRange) {}
  
  public Range<K> get(int paramInt)
  {
    Preconditions.checkElementIndex(paramInt, this.val$len);
    if ((paramInt == 0) || (paramInt == this.val$len - 1)) {
      return ((Range)ImmutableRangeMap.access$000(this.this$0).get(this.val$off + paramInt)).intersection(this.val$range);
    }
    return (Range)ImmutableRangeMap.access$000(this.this$0).get(this.val$off + paramInt);
  }
  
  boolean isPartialView()
  {
    return true;
  }
  
  public int size()
  {
    return this.val$len;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     com.google.common.collect.ImmutableRangeMap.1
 * JD-Core Version:    0.7.0.1
 */