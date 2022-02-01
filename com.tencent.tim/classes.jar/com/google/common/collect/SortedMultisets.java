package com.google.common.collect;

import com.google.common.annotations.GwtCompatible;
import com.google.common.annotations.GwtIncompatible;
import com.google.j2objc.annotations.Weak;
import java.util.Comparator;
import java.util.Iterator;
import java.util.NavigableSet;
import java.util.NoSuchElementException;
import java.util.SortedSet;
import javax.annotation.Nullable;

@GwtCompatible(emulated=true)
final class SortedMultisets
{
  private static <E> E getElementOrNull(@Nullable Multiset.Entry<E> paramEntry)
  {
    if (paramEntry == null) {
      return null;
    }
    return paramEntry.getElement();
  }
  
  private static <E> E getElementOrThrow(Multiset.Entry<E> paramEntry)
  {
    if (paramEntry == null) {
      throw new NoSuchElementException();
    }
    return paramEntry.getElement();
  }
  
  static class ElementSet<E>
    extends Multisets.ElementSet<E>
    implements SortedSet<E>
  {
    @Weak
    private final SortedMultiset<E> multiset;
    
    ElementSet(SortedMultiset<E> paramSortedMultiset)
    {
      this.multiset = paramSortedMultiset;
    }
    
    public Comparator<? super E> comparator()
    {
      return multiset().comparator();
    }
    
    public E first()
    {
      return SortedMultisets.getElementOrThrow(multiset().firstEntry());
    }
    
    public SortedSet<E> headSet(E paramE)
    {
      return multiset().headMultiset(paramE, BoundType.OPEN).elementSet();
    }
    
    public E last()
    {
      return SortedMultisets.getElementOrThrow(multiset().lastEntry());
    }
    
    final SortedMultiset<E> multiset()
    {
      return this.multiset;
    }
    
    public SortedSet<E> subSet(E paramE1, E paramE2)
    {
      return multiset().subMultiset(paramE1, BoundType.CLOSED, paramE2, BoundType.OPEN).elementSet();
    }
    
    public SortedSet<E> tailSet(E paramE)
    {
      return multiset().tailMultiset(paramE, BoundType.CLOSED).elementSet();
    }
  }
  
  @GwtIncompatible
  static class NavigableElementSet<E>
    extends SortedMultisets.ElementSet<E>
    implements NavigableSet<E>
  {
    NavigableElementSet(SortedMultiset<E> paramSortedMultiset)
    {
      super();
    }
    
    public E ceiling(E paramE)
    {
      return SortedMultisets.getElementOrNull(multiset().tailMultiset(paramE, BoundType.CLOSED).firstEntry());
    }
    
    public Iterator<E> descendingIterator()
    {
      return descendingSet().iterator();
    }
    
    public NavigableSet<E> descendingSet()
    {
      return new NavigableElementSet(multiset().descendingMultiset());
    }
    
    public E floor(E paramE)
    {
      return SortedMultisets.getElementOrNull(multiset().headMultiset(paramE, BoundType.CLOSED).lastEntry());
    }
    
    public NavigableSet<E> headSet(E paramE, boolean paramBoolean)
    {
      return new NavigableElementSet(multiset().headMultiset(paramE, BoundType.forBoolean(paramBoolean)));
    }
    
    public E higher(E paramE)
    {
      return SortedMultisets.getElementOrNull(multiset().tailMultiset(paramE, BoundType.OPEN).firstEntry());
    }
    
    public E lower(E paramE)
    {
      return SortedMultisets.getElementOrNull(multiset().headMultiset(paramE, BoundType.OPEN).lastEntry());
    }
    
    public E pollFirst()
    {
      return SortedMultisets.getElementOrNull(multiset().pollFirstEntry());
    }
    
    public E pollLast()
    {
      return SortedMultisets.getElementOrNull(multiset().pollLastEntry());
    }
    
    public NavigableSet<E> subSet(E paramE1, boolean paramBoolean1, E paramE2, boolean paramBoolean2)
    {
      return new NavigableElementSet(multiset().subMultiset(paramE1, BoundType.forBoolean(paramBoolean1), paramE2, BoundType.forBoolean(paramBoolean2)));
    }
    
    public NavigableSet<E> tailSet(E paramE, boolean paramBoolean)
    {
      return new NavigableElementSet(multiset().tailMultiset(paramE, BoundType.forBoolean(paramBoolean)));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     com.google.common.collect.SortedMultisets
 * JD-Core Version:    0.7.0.1
 */