package com.google.common.collect;

import com.google.common.annotations.GwtCompatible;
import com.google.common.base.Preconditions;

@GwtCompatible(emulated=true, serializable=true)
final class SingletonImmutableList<E>
  extends ImmutableList<E>
{
  final transient E element;
  
  SingletonImmutableList(E paramE)
  {
    this.element = Preconditions.checkNotNull(paramE);
  }
  
  public E get(int paramInt)
  {
    Preconditions.checkElementIndex(paramInt, 1);
    return this.element;
  }
  
  boolean isPartialView()
  {
    return false;
  }
  
  public UnmodifiableIterator<E> iterator()
  {
    return Iterators.singletonIterator(this.element);
  }
  
  public int size()
  {
    return 1;
  }
  
  public ImmutableList<E> subList(int paramInt1, int paramInt2)
  {
    Preconditions.checkPositionIndexes(paramInt1, paramInt2, 1);
    Object localObject = this;
    if (paramInt1 == paramInt2) {
      localObject = ImmutableList.of();
    }
    return localObject;
  }
  
  public String toString()
  {
    return '[' + this.element.toString() + ']';
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     com.google.common.collect.SingletonImmutableList
 * JD-Core Version:    0.7.0.1
 */