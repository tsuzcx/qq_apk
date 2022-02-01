package com.google.common.collect;

import com.google.common.annotations.GwtCompatible;
import java.util.Comparator;
import java.util.NavigableSet;

@GwtCompatible(emulated=true)
final class UnmodifiableSortedMultiset<E>
  extends Multisets.UnmodifiableMultiset<E>
  implements SortedMultiset<E>
{
  private static final long serialVersionUID = 0L;
  private transient UnmodifiableSortedMultiset<E> descendingMultiset;
  
  UnmodifiableSortedMultiset(SortedMultiset<E> paramSortedMultiset)
  {
    super(paramSortedMultiset);
  }
  
  public Comparator<? super E> comparator()
  {
    return delegate().comparator();
  }
  
  NavigableSet<E> createElementSet()
  {
    return Sets.unmodifiableNavigableSet(delegate().elementSet());
  }
  
  protected SortedMultiset<E> delegate()
  {
    return (SortedMultiset)super.delegate();
  }
  
  public SortedMultiset<E> descendingMultiset()
  {
    UnmodifiableSortedMultiset localUnmodifiableSortedMultiset2 = this.descendingMultiset;
    UnmodifiableSortedMultiset localUnmodifiableSortedMultiset1 = localUnmodifiableSortedMultiset2;
    if (localUnmodifiableSortedMultiset2 == null)
    {
      localUnmodifiableSortedMultiset1 = new UnmodifiableSortedMultiset(delegate().descendingMultiset());
      localUnmodifiableSortedMultiset1.descendingMultiset = this;
      this.descendingMultiset = localUnmodifiableSortedMultiset1;
    }
    return localUnmodifiableSortedMultiset1;
  }
  
  public NavigableSet<E> elementSet()
  {
    return (NavigableSet)super.elementSet();
  }
  
  public Multiset.Entry<E> firstEntry()
  {
    return delegate().firstEntry();
  }
  
  public SortedMultiset<E> headMultiset(E paramE, BoundType paramBoundType)
  {
    return Multisets.unmodifiableSortedMultiset(delegate().headMultiset(paramE, paramBoundType));
  }
  
  public Multiset.Entry<E> lastEntry()
  {
    return delegate().lastEntry();
  }
  
  public Multiset.Entry<E> pollFirstEntry()
  {
    throw new UnsupportedOperationException();
  }
  
  public Multiset.Entry<E> pollLastEntry()
  {
    throw new UnsupportedOperationException();
  }
  
  public SortedMultiset<E> subMultiset(E paramE1, BoundType paramBoundType1, E paramE2, BoundType paramBoundType2)
  {
    return Multisets.unmodifiableSortedMultiset(delegate().subMultiset(paramE1, paramBoundType1, paramE2, paramBoundType2));
  }
  
  public SortedMultiset<E> tailMultiset(E paramE, BoundType paramBoundType)
  {
    return Multisets.unmodifiableSortedMultiset(delegate().tailMultiset(paramE, paramBoundType));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     com.google.common.collect.UnmodifiableSortedMultiset
 * JD-Core Version:    0.7.0.1
 */