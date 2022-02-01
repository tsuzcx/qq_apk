package com.google.common.collect;

import com.google.common.annotations.Beta;
import com.google.common.annotations.GwtIncompatible;
import java.util.Iterator;
import java.util.NavigableSet;
import java.util.SortedSet;

@GwtIncompatible
public abstract class ForwardingNavigableSet<E>
  extends ForwardingSortedSet<E>
  implements NavigableSet<E>
{
  public E ceiling(E paramE)
  {
    return delegate().ceiling(paramE);
  }
  
  protected abstract NavigableSet<E> delegate();
  
  public Iterator<E> descendingIterator()
  {
    return delegate().descendingIterator();
  }
  
  public NavigableSet<E> descendingSet()
  {
    return delegate().descendingSet();
  }
  
  public E floor(E paramE)
  {
    return delegate().floor(paramE);
  }
  
  public NavigableSet<E> headSet(E paramE, boolean paramBoolean)
  {
    return delegate().headSet(paramE, paramBoolean);
  }
  
  public E higher(E paramE)
  {
    return delegate().higher(paramE);
  }
  
  public E lower(E paramE)
  {
    return delegate().lower(paramE);
  }
  
  public E pollFirst()
  {
    return delegate().pollFirst();
  }
  
  public E pollLast()
  {
    return delegate().pollLast();
  }
  
  protected E standardCeiling(E paramE)
  {
    return Iterators.getNext(tailSet(paramE, true).iterator(), null);
  }
  
  protected E standardFirst()
  {
    return iterator().next();
  }
  
  protected E standardFloor(E paramE)
  {
    return Iterators.getNext(headSet(paramE, true).descendingIterator(), null);
  }
  
  protected SortedSet<E> standardHeadSet(E paramE)
  {
    return headSet(paramE, false);
  }
  
  protected E standardHigher(E paramE)
  {
    return Iterators.getNext(tailSet(paramE, false).iterator(), null);
  }
  
  protected E standardLast()
  {
    return descendingIterator().next();
  }
  
  protected E standardLower(E paramE)
  {
    return Iterators.getNext(headSet(paramE, false).descendingIterator(), null);
  }
  
  protected E standardPollFirst()
  {
    return Iterators.pollNext(iterator());
  }
  
  protected E standardPollLast()
  {
    return Iterators.pollNext(descendingIterator());
  }
  
  @Beta
  protected NavigableSet<E> standardSubSet(E paramE1, boolean paramBoolean1, E paramE2, boolean paramBoolean2)
  {
    return tailSet(paramE1, paramBoolean1).headSet(paramE2, paramBoolean2);
  }
  
  protected SortedSet<E> standardSubSet(E paramE1, E paramE2)
  {
    return subSet(paramE1, true, paramE2, false);
  }
  
  protected SortedSet<E> standardTailSet(E paramE)
  {
    return tailSet(paramE, true);
  }
  
  public NavigableSet<E> subSet(E paramE1, boolean paramBoolean1, E paramE2, boolean paramBoolean2)
  {
    return delegate().subSet(paramE1, paramBoolean1, paramE2, paramBoolean2);
  }
  
  public NavigableSet<E> tailSet(E paramE, boolean paramBoolean)
  {
    return delegate().tailSet(paramE, paramBoolean);
  }
  
  @Beta
  public class StandardDescendingSet
    extends Sets.DescendingSet<E>
  {
    public StandardDescendingSet()
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     com.google.common.collect.ForwardingNavigableSet
 * JD-Core Version:    0.7.0.1
 */