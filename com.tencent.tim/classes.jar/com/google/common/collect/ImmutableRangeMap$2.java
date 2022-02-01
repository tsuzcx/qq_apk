package com.google.common.collect;

class ImmutableRangeMap$2
  extends ImmutableRangeMap<K, V>
{
  ImmutableRangeMap$2(ImmutableRangeMap paramImmutableRangeMap1, ImmutableList paramImmutableList1, ImmutableList paramImmutableList2, Range paramRange, ImmutableRangeMap paramImmutableRangeMap2)
  {
    super(paramImmutableList1, paramImmutableList2);
  }
  
  public ImmutableRangeMap<K, V> subRangeMap(Range<K> paramRange)
  {
    if (this.val$range.isConnected(paramRange)) {
      return this.val$outer.subRangeMap(paramRange.intersection(this.val$range));
    }
    return ImmutableRangeMap.of();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     com.google.common.collect.ImmutableRangeMap.2
 * JD-Core Version:    0.7.0.1
 */