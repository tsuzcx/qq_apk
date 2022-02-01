package com.google.common.collect;

import java.util.Comparator;
import java.util.List;

 enum SortedLists$KeyPresentBehavior$4
{
  SortedLists$KeyPresentBehavior$4()
  {
    super(str, i, null);
  }
  
  public <E> int resultIndex(Comparator<? super E> paramComparator, E paramE, List<? extends E> paramList, int paramInt)
  {
    return LAST_PRESENT.resultIndex(paramComparator, paramE, paramList, paramInt) + 1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     com.google.common.collect.SortedLists.KeyPresentBehavior.4
 * JD-Core Version:    0.7.0.1
 */