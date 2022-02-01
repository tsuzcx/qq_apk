package com.google.common.collect;

import com.google.common.annotations.GwtCompatible;
import com.google.common.base.Preconditions;
import java.util.Comparator;
import java.util.Iterator;
import java.util.NavigableSet;
import javax.annotation.Nullable;

@GwtCompatible(emulated=true)
abstract class AbstractSortedMultiset<E>
  extends AbstractMultiset<E>
  implements SortedMultiset<E>
{
  @GwtTransient
  final Comparator<? super E> comparator;
  private transient SortedMultiset<E> descendingMultiset;
  
  AbstractSortedMultiset()
  {
    this(Ordering.natural());
  }
  
  AbstractSortedMultiset(Comparator<? super E> paramComparator)
  {
    this.comparator = ((Comparator)Preconditions.checkNotNull(paramComparator));
  }
  
  public Comparator<? super E> comparator()
  {
    return this.comparator;
  }
  
  SortedMultiset<E> createDescendingMultiset()
  {
    return new AbstractSortedMultiset.1DescendingMultisetImpl(this);
  }
  
  NavigableSet<E> createElementSet()
  {
    return new SortedMultisets.NavigableElementSet(this);
  }
  
  abstract Iterator<Multiset.Entry<E>> descendingEntryIterator();
  
  Iterator<E> descendingIterator()
  {
    return Multisets.iteratorImpl(descendingMultiset());
  }
  
  public SortedMultiset<E> descendingMultiset()
  {
    SortedMultiset localSortedMultiset2 = this.descendingMultiset;
    SortedMultiset localSortedMultiset1 = localSortedMultiset2;
    if (localSortedMultiset2 == null)
    {
      localSortedMultiset1 = createDescendingMultiset();
      this.descendingMultiset = localSortedMultiset1;
    }
    return localSortedMultiset1;
  }
  
  public NavigableSet<E> elementSet()
  {
    return (NavigableSet)super.elementSet();
  }
  
  public Multiset.Entry<E> firstEntry()
  {
    Iterator localIterator = entryIterator();
    if (localIterator.hasNext()) {
      return (Multiset.Entry)localIterator.next();
    }
    return null;
  }
  
  public Multiset.Entry<E> lastEntry()
  {
    Iterator localIterator = descendingEntryIterator();
    if (localIterator.hasNext()) {
      return (Multiset.Entry)localIterator.next();
    }
    return null;
  }
  
  public Multiset.Entry<E> pollFirstEntry()
  {
    Iterator localIterator = entryIterator();
    if (localIterator.hasNext())
    {
      Multiset.Entry localEntry = (Multiset.Entry)localIterator.next();
      localEntry = Multisets.immutableEntry(localEntry.getElement(), localEntry.getCount());
      localIterator.remove();
      return localEntry;
    }
    return null;
  }
  
  public Multiset.Entry<E> pollLastEntry()
  {
    Iterator localIterator = descendingEntryIterator();
    if (localIterator.hasNext())
    {
      Multiset.Entry localEntry = (Multiset.Entry)localIterator.next();
      localEntry = Multisets.immutableEntry(localEntry.getElement(), localEntry.getCount());
      localIterator.remove();
      return localEntry;
    }
    return null;
  }
  
  public SortedMultiset<E> subMultiset(@Nullable E paramE1, BoundType paramBoundType1, @Nullable E paramE2, BoundType paramBoundType2)
  {
    Preconditions.checkNotNull(paramBoundType1);
    Preconditions.checkNotNull(paramBoundType2);
    return tailMultiset(paramE1, paramBoundType1).headMultiset(paramE2, paramBoundType2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     com.google.common.collect.AbstractSortedMultiset
 * JD-Core Version:    0.7.0.1
 */