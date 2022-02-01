package com.google.common.collect;

import com.google.common.annotations.Beta;
import com.google.common.annotations.GwtCompatible;
import java.util.Comparator;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.SortedSet;
import javax.annotation.Nullable;

@GwtCompatible
public abstract class ForwardingSortedSet<E>
  extends ForwardingSet<E>
  implements SortedSet<E>
{
  private int unsafeCompare(Object paramObject1, Object paramObject2)
  {
    Comparator localComparator = comparator();
    if (localComparator == null) {
      return ((Comparable)paramObject1).compareTo(paramObject2);
    }
    return localComparator.compare(paramObject1, paramObject2);
  }
  
  public Comparator<? super E> comparator()
  {
    return delegate().comparator();
  }
  
  protected abstract SortedSet<E> delegate();
  
  public E first()
  {
    return delegate().first();
  }
  
  public SortedSet<E> headSet(E paramE)
  {
    return delegate().headSet(paramE);
  }
  
  public E last()
  {
    return delegate().last();
  }
  
  @Beta
  protected boolean standardContains(@Nullable Object paramObject)
  {
    boolean bool = false;
    try
    {
      int i = unsafeCompare(tailSet(paramObject).first(), paramObject);
      if (i == 0) {
        bool = true;
      }
      return bool;
    }
    catch (NullPointerException paramObject)
    {
      return false;
    }
    catch (NoSuchElementException paramObject)
    {
      return false;
    }
    catch (ClassCastException paramObject) {}
    return false;
  }
  
  @Beta
  protected boolean standardRemove(@Nullable Object paramObject)
  {
    boolean bool2 = false;
    try
    {
      Iterator localIterator = tailSet(paramObject).iterator();
      boolean bool1 = bool2;
      if (localIterator.hasNext())
      {
        bool1 = bool2;
        if (unsafeCompare(localIterator.next(), paramObject) == 0)
        {
          localIterator.remove();
          bool1 = true;
        }
      }
      return bool1;
    }
    catch (NullPointerException paramObject)
    {
      return false;
    }
    catch (ClassCastException paramObject) {}
    return false;
  }
  
  @Beta
  protected SortedSet<E> standardSubSet(E paramE1, E paramE2)
  {
    return tailSet(paramE1).headSet(paramE2);
  }
  
  public SortedSet<E> subSet(E paramE1, E paramE2)
  {
    return delegate().subSet(paramE1, paramE2);
  }
  
  public SortedSet<E> tailSet(E paramE)
  {
    return delegate().tailSet(paramE);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     com.google.common.collect.ForwardingSortedSet
 * JD-Core Version:    0.7.0.1
 */