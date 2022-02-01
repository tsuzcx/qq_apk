package com.google.common.collect;

import com.google.common.annotations.Beta;
import com.google.common.annotations.GwtCompatible;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import javax.annotation.Nullable;

@GwtCompatible
public abstract class ForwardingList<E>
  extends ForwardingCollection<E>
  implements List<E>
{
  public void add(int paramInt, E paramE)
  {
    delegate().add(paramInt, paramE);
  }
  
  @CanIgnoreReturnValue
  public boolean addAll(int paramInt, Collection<? extends E> paramCollection)
  {
    return delegate().addAll(paramInt, paramCollection);
  }
  
  protected abstract List<E> delegate();
  
  public boolean equals(@Nullable Object paramObject)
  {
    return (paramObject == this) || (delegate().equals(paramObject));
  }
  
  public E get(int paramInt)
  {
    return delegate().get(paramInt);
  }
  
  public int hashCode()
  {
    return delegate().hashCode();
  }
  
  public int indexOf(Object paramObject)
  {
    return delegate().indexOf(paramObject);
  }
  
  public int lastIndexOf(Object paramObject)
  {
    return delegate().lastIndexOf(paramObject);
  }
  
  public ListIterator<E> listIterator()
  {
    return delegate().listIterator();
  }
  
  public ListIterator<E> listIterator(int paramInt)
  {
    return delegate().listIterator(paramInt);
  }
  
  @CanIgnoreReturnValue
  public E remove(int paramInt)
  {
    return delegate().remove(paramInt);
  }
  
  @CanIgnoreReturnValue
  public E set(int paramInt, E paramE)
  {
    return delegate().set(paramInt, paramE);
  }
  
  protected boolean standardAdd(E paramE)
  {
    add(size(), paramE);
    return true;
  }
  
  protected boolean standardAddAll(int paramInt, Iterable<? extends E> paramIterable)
  {
    return Lists.addAllImpl(this, paramInt, paramIterable);
  }
  
  @Beta
  protected boolean standardEquals(@Nullable Object paramObject)
  {
    return Lists.equalsImpl(this, paramObject);
  }
  
  @Beta
  protected int standardHashCode()
  {
    return Lists.hashCodeImpl(this);
  }
  
  protected int standardIndexOf(@Nullable Object paramObject)
  {
    return Lists.indexOfImpl(this, paramObject);
  }
  
  protected Iterator<E> standardIterator()
  {
    return listIterator();
  }
  
  protected int standardLastIndexOf(@Nullable Object paramObject)
  {
    return Lists.lastIndexOfImpl(this, paramObject);
  }
  
  protected ListIterator<E> standardListIterator()
  {
    return listIterator(0);
  }
  
  @Beta
  protected ListIterator<E> standardListIterator(int paramInt)
  {
    return Lists.listIteratorImpl(this, paramInt);
  }
  
  @Beta
  protected List<E> standardSubList(int paramInt1, int paramInt2)
  {
    return Lists.subListImpl(this, paramInt1, paramInt2);
  }
  
  public List<E> subList(int paramInt1, int paramInt2)
  {
    return delegate().subList(paramInt1, paramInt2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     com.google.common.collect.ForwardingList
 * JD-Core Version:    0.7.0.1
 */