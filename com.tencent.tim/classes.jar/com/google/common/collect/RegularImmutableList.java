package com.google.common.collect;

import com.google.common.annotations.GwtCompatible;

@GwtCompatible(emulated=true, serializable=true)
class RegularImmutableList<E>
  extends ImmutableList<E>
{
  static final ImmutableList<Object> EMPTY = new RegularImmutableList(ObjectArrays.EMPTY_ARRAY);
  private final transient Object[] array;
  
  RegularImmutableList(Object[] paramArrayOfObject)
  {
    this.array = paramArrayOfObject;
  }
  
  int copyIntoArray(Object[] paramArrayOfObject, int paramInt)
  {
    System.arraycopy(this.array, 0, paramArrayOfObject, paramInt, this.array.length);
    return this.array.length + paramInt;
  }
  
  public E get(int paramInt)
  {
    return this.array[paramInt];
  }
  
  boolean isPartialView()
  {
    return false;
  }
  
  public UnmodifiableListIterator<E> listIterator(int paramInt)
  {
    return Iterators.forArray(this.array, 0, this.array.length, paramInt);
  }
  
  public int size()
  {
    return this.array.length;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     com.google.common.collect.RegularImmutableList
 * JD-Core Version:    0.7.0.1
 */