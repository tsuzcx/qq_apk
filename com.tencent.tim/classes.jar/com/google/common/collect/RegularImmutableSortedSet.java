package com.google.common.collect;

import com.google.common.annotations.GwtCompatible;
import com.google.common.annotations.GwtIncompatible;
import com.google.common.base.Preconditions;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Set;
import javax.annotation.Nullable;

@GwtCompatible(emulated=true, serializable=true)
final class RegularImmutableSortedSet<E>
  extends ImmutableSortedSet<E>
{
  static final RegularImmutableSortedSet<Comparable> NATURAL_EMPTY_SET = new RegularImmutableSortedSet(ImmutableList.of(), Ordering.natural());
  private final transient ImmutableList<E> elements;
  
  RegularImmutableSortedSet(ImmutableList<E> paramImmutableList, Comparator<? super E> paramComparator)
  {
    super(paramComparator);
    this.elements = paramImmutableList;
  }
  
  private int unsafeBinarySearch(Object paramObject)
    throws ClassCastException
  {
    return Collections.binarySearch(this.elements, paramObject, unsafeComparator());
  }
  
  public E ceiling(E paramE)
  {
    int i = tailIndex(paramE, true);
    if (i == size()) {
      return null;
    }
    return this.elements.get(i);
  }
  
  public boolean contains(@Nullable Object paramObject)
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (paramObject != null) {}
    try
    {
      int i = unsafeBinarySearch(paramObject);
      bool1 = bool2;
      if (i >= 0) {
        bool1 = true;
      }
      return bool1;
    }
    catch (ClassCastException paramObject) {}
    return false;
  }
  
  public boolean containsAll(Collection<?> paramCollection)
  {
    Object localObject = paramCollection;
    if ((paramCollection instanceof Multiset)) {
      localObject = ((Multiset)paramCollection).elementSet();
    }
    if ((!SortedIterables.hasSameComparator(comparator(), (Iterable)localObject)) || (((Collection)localObject).size() <= 1)) {
      return super.containsAll((Collection)localObject);
    }
    PeekingIterator localPeekingIterator = Iterators.peekingIterator(iterator());
    localObject = ((Collection)localObject).iterator();
    paramCollection = ((Iterator)localObject).next();
    try
    {
      while (localPeekingIterator.hasNext())
      {
        int i = unsafeCompare(localPeekingIterator.peek(), paramCollection);
        if (i < 0)
        {
          localPeekingIterator.next();
        }
        else if (i == 0)
        {
          if (!((Iterator)localObject).hasNext()) {
            return true;
          }
          paramCollection = ((Iterator)localObject).next();
        }
        else if (i > 0)
        {
          return false;
        }
      }
    }
    catch (ClassCastException paramCollection)
    {
      return false;
      return false;
    }
    catch (NullPointerException paramCollection) {}
    return false;
  }
  
  int copyIntoArray(Object[] paramArrayOfObject, int paramInt)
  {
    return this.elements.copyIntoArray(paramArrayOfObject, paramInt);
  }
  
  ImmutableList<E> createAsList()
  {
    if (size() <= 1) {
      return this.elements;
    }
    return new ImmutableSortedAsList(this, this.elements);
  }
  
  ImmutableSortedSet<E> createDescendingSet()
  {
    Ordering localOrdering = Ordering.from(this.comparator).reverse();
    if (isEmpty()) {
      return emptySet(localOrdering);
    }
    return new RegularImmutableSortedSet(this.elements.reverse(), localOrdering);
  }
  
  @GwtIncompatible
  public UnmodifiableIterator<E> descendingIterator()
  {
    return this.elements.reverse().iterator();
  }
  
  public boolean equals(@Nullable Object paramObject)
  {
    if (paramObject == this) {}
    for (;;)
    {
      return true;
      if (!(paramObject instanceof Set)) {
        return false;
      }
      paramObject = (Set)paramObject;
      if (size() != paramObject.size()) {
        return false;
      }
      if (!isEmpty()) {
        if (SortedIterables.hasSameComparator(this.comparator, paramObject))
        {
          paramObject = paramObject.iterator();
          try
          {
            UnmodifiableIterator localUnmodifiableIterator = iterator();
            int i;
            do
            {
              if (!localUnmodifiableIterator.hasNext()) {
                break;
              }
              Object localObject1 = localUnmodifiableIterator.next();
              Object localObject2 = paramObject.next();
              if (localObject2 == null) {
                break label109;
              }
              i = unsafeCompare(localObject1, localObject2);
            } while (i == 0);
            label109:
            return false;
          }
          catch (ClassCastException paramObject)
          {
            return false;
          }
          catch (NoSuchElementException paramObject)
          {
            return false;
          }
        }
      }
    }
    return containsAll(paramObject);
  }
  
  public E first()
  {
    if (isEmpty()) {
      throw new NoSuchElementException();
    }
    return this.elements.get(0);
  }
  
  public E floor(E paramE)
  {
    int i = headIndex(paramE, true) - 1;
    if (i == -1) {
      return null;
    }
    return this.elements.get(i);
  }
  
  RegularImmutableSortedSet<E> getSubSet(int paramInt1, int paramInt2)
  {
    if ((paramInt1 == 0) && (paramInt2 == size())) {
      return this;
    }
    if (paramInt1 < paramInt2) {
      return new RegularImmutableSortedSet(this.elements.subList(paramInt1, paramInt2), this.comparator);
    }
    return emptySet(this.comparator);
  }
  
  int headIndex(E paramE, boolean paramBoolean)
  {
    ImmutableList localImmutableList = this.elements;
    Object localObject = Preconditions.checkNotNull(paramE);
    Comparator localComparator = comparator();
    if (paramBoolean) {}
    for (paramE = SortedLists.KeyPresentBehavior.FIRST_AFTER;; paramE = SortedLists.KeyPresentBehavior.FIRST_PRESENT) {
      return SortedLists.binarySearch(localImmutableList, localObject, localComparator, paramE, SortedLists.KeyAbsentBehavior.NEXT_HIGHER);
    }
  }
  
  ImmutableSortedSet<E> headSetImpl(E paramE, boolean paramBoolean)
  {
    return getSubSet(0, headIndex(paramE, paramBoolean));
  }
  
  public E higher(E paramE)
  {
    int i = tailIndex(paramE, false);
    if (i == size()) {
      return null;
    }
    return this.elements.get(i);
  }
  
  int indexOf(@Nullable Object paramObject)
  {
    if (paramObject == null) {
      return -1;
    }
    try
    {
      int i = SortedLists.binarySearch(this.elements, paramObject, unsafeComparator(), SortedLists.KeyPresentBehavior.ANY_PRESENT, SortedLists.KeyAbsentBehavior.INVERTED_INSERTION_INDEX);
      if (i >= 0) {}
      for (;;)
      {
        return i;
        i = -1;
      }
      return -1;
    }
    catch (ClassCastException paramObject) {}
  }
  
  boolean isPartialView()
  {
    return this.elements.isPartialView();
  }
  
  public UnmodifiableIterator<E> iterator()
  {
    return this.elements.iterator();
  }
  
  public E last()
  {
    if (isEmpty()) {
      throw new NoSuchElementException();
    }
    return this.elements.get(size() - 1);
  }
  
  public E lower(E paramE)
  {
    int i = headIndex(paramE, false) - 1;
    if (i == -1) {
      return null;
    }
    return this.elements.get(i);
  }
  
  public int size()
  {
    return this.elements.size();
  }
  
  ImmutableSortedSet<E> subSetImpl(E paramE1, boolean paramBoolean1, E paramE2, boolean paramBoolean2)
  {
    return tailSetImpl(paramE1, paramBoolean1).headSetImpl(paramE2, paramBoolean2);
  }
  
  int tailIndex(E paramE, boolean paramBoolean)
  {
    ImmutableList localImmutableList = this.elements;
    Object localObject = Preconditions.checkNotNull(paramE);
    Comparator localComparator = comparator();
    if (paramBoolean) {}
    for (paramE = SortedLists.KeyPresentBehavior.FIRST_PRESENT;; paramE = SortedLists.KeyPresentBehavior.FIRST_AFTER) {
      return SortedLists.binarySearch(localImmutableList, localObject, localComparator, paramE, SortedLists.KeyAbsentBehavior.NEXT_HIGHER);
    }
  }
  
  ImmutableSortedSet<E> tailSetImpl(E paramE, boolean paramBoolean)
  {
    return getSubSet(tailIndex(paramE, paramBoolean), size());
  }
  
  Comparator<Object> unsafeComparator()
  {
    return this.comparator;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     com.google.common.collect.RegularImmutableSortedSet
 * JD-Core Version:    0.7.0.1
 */