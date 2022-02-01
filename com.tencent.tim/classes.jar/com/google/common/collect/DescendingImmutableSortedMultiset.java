package com.google.common.collect;

import com.google.common.annotations.GwtIncompatible;
import javax.annotation.Nullable;

@GwtIncompatible
final class DescendingImmutableSortedMultiset<E>
  extends ImmutableSortedMultiset<E>
{
  private final transient ImmutableSortedMultiset<E> forward;
  
  DescendingImmutableSortedMultiset(ImmutableSortedMultiset<E> paramImmutableSortedMultiset)
  {
    this.forward = paramImmutableSortedMultiset;
  }
  
  public int count(@Nullable Object paramObject)
  {
    return this.forward.count(paramObject);
  }
  
  public ImmutableSortedMultiset<E> descendingMultiset()
  {
    return this.forward;
  }
  
  public ImmutableSortedSet<E> elementSet()
  {
    return this.forward.elementSet().descendingSet();
  }
  
  public Multiset.Entry<E> firstEntry()
  {
    return this.forward.lastEntry();
  }
  
  Multiset.Entry<E> getEntry(int paramInt)
  {
    return (Multiset.Entry)this.forward.entrySet().asList().reverse().get(paramInt);
  }
  
  public ImmutableSortedMultiset<E> headMultiset(E paramE, BoundType paramBoundType)
  {
    return this.forward.tailMultiset(paramE, paramBoundType).descendingMultiset();
  }
  
  boolean isPartialView()
  {
    return this.forward.isPartialView();
  }
  
  public Multiset.Entry<E> lastEntry()
  {
    return this.forward.firstEntry();
  }
  
  public int size()
  {
    return this.forward.size();
  }
  
  public ImmutableSortedMultiset<E> tailMultiset(E paramE, BoundType paramBoundType)
  {
    return this.forward.headMultiset(paramE, paramBoundType).descendingMultiset();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     com.google.common.collect.DescendingImmutableSortedMultiset
 * JD-Core Version:    0.7.0.1
 */