package com.google.common.collect;

import com.google.common.annotations.GwtCompatible;
import com.google.common.base.Preconditions;
import com.google.errorprone.annotations.concurrent.LazyInit;

@GwtCompatible(emulated=true, serializable=true)
final class SingletonImmutableSet<E>
  extends ImmutableSet<E>
{
  @LazyInit
  private transient int cachedHashCode;
  final transient E element;
  
  SingletonImmutableSet(E paramE)
  {
    this.element = Preconditions.checkNotNull(paramE);
  }
  
  SingletonImmutableSet(E paramE, int paramInt)
  {
    this.element = paramE;
    this.cachedHashCode = paramInt;
  }
  
  public boolean contains(Object paramObject)
  {
    return this.element.equals(paramObject);
  }
  
  int copyIntoArray(Object[] paramArrayOfObject, int paramInt)
  {
    paramArrayOfObject[paramInt] = this.element;
    return paramInt + 1;
  }
  
  ImmutableList<E> createAsList()
  {
    return ImmutableList.of(this.element);
  }
  
  public final int hashCode()
  {
    int j = this.cachedHashCode;
    int i = j;
    if (j == 0)
    {
      i = this.element.hashCode();
      this.cachedHashCode = i;
    }
    return i;
  }
  
  boolean isHashCodeFast()
  {
    return this.cachedHashCode != 0;
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
  
  public String toString()
  {
    return '[' + this.element.toString() + ']';
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     com.google.common.collect.SingletonImmutableSet
 * JD-Core Version:    0.7.0.1
 */