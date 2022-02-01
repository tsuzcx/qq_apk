package com.google.common.collect;

final class Iterators$10
  extends AbstractIndexedListIterator<T>
{
  Iterators$10(int paramInt1, int paramInt2, Object[] paramArrayOfObject, int paramInt3)
  {
    super(paramInt1, paramInt2);
  }
  
  protected T get(int paramInt)
  {
    return this.val$array[(this.val$offset + paramInt)];
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     com.google.common.collect.Iterators.10
 * JD-Core Version:    0.7.0.1
 */