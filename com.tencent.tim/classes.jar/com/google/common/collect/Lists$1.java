package com.google.common.collect;

import java.util.List;
import java.util.ListIterator;

final class Lists$1
  extends Lists.RandomAccessListWrapper<E>
{
  private static final long serialVersionUID = 0L;
  
  Lists$1(List paramList)
  {
    super(paramList);
  }
  
  public ListIterator<E> listIterator(int paramInt)
  {
    return this.backingList.listIterator(paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     com.google.common.collect.Lists.1
 * JD-Core Version:    0.7.0.1
 */