package com.google.common.collect;

import java.util.Collection;
import java.util.NavigableSet;
import java.util.SortedSet;

final class Maps$4
  extends ForwardingNavigableSet<E>
{
  Maps$4(NavigableSet paramNavigableSet) {}
  
  public boolean add(E paramE)
  {
    throw new UnsupportedOperationException();
  }
  
  public boolean addAll(Collection<? extends E> paramCollection)
  {
    throw new UnsupportedOperationException();
  }
  
  protected NavigableSet<E> delegate()
  {
    return this.val$set;
  }
  
  public NavigableSet<E> descendingSet()
  {
    return Maps.access$400(super.descendingSet());
  }
  
  public NavigableSet<E> headSet(E paramE, boolean paramBoolean)
  {
    return Maps.access$400(super.headSet(paramE, paramBoolean));
  }
  
  public SortedSet<E> headSet(E paramE)
  {
    return Maps.access$300(super.headSet(paramE));
  }
  
  public NavigableSet<E> subSet(E paramE1, boolean paramBoolean1, E paramE2, boolean paramBoolean2)
  {
    return Maps.access$400(super.subSet(paramE1, paramBoolean1, paramE2, paramBoolean2));
  }
  
  public SortedSet<E> subSet(E paramE1, E paramE2)
  {
    return Maps.access$300(super.subSet(paramE1, paramE2));
  }
  
  public NavigableSet<E> tailSet(E paramE, boolean paramBoolean)
  {
    return Maps.access$400(super.tailSet(paramE, paramBoolean));
  }
  
  public SortedSet<E> tailSet(E paramE)
  {
    return Maps.access$300(super.tailSet(paramE));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     com.google.common.collect.Maps.4
 * JD-Core Version:    0.7.0.1
 */