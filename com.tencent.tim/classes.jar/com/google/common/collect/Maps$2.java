package com.google.common.collect;

import java.util.Collection;
import java.util.Set;

final class Maps$2
  extends ForwardingSet<E>
{
  Maps$2(Set paramSet) {}
  
  public boolean add(E paramE)
  {
    throw new UnsupportedOperationException();
  }
  
  public boolean addAll(Collection<? extends E> paramCollection)
  {
    throw new UnsupportedOperationException();
  }
  
  protected Set<E> delegate()
  {
    return this.val$set;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     com.google.common.collect.Maps.2
 * JD-Core Version:    0.7.0.1
 */