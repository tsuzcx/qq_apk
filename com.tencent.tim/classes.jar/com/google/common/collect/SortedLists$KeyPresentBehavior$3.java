package com.google.common.collect;

import java.util.Comparator;
import java.util.List;

 enum SortedLists$KeyPresentBehavior$3
{
  SortedLists$KeyPresentBehavior$3()
  {
    super(str, i, null);
  }
  
  <E> int resultIndex(Comparator<? super E> paramComparator, E paramE, List<? extends E> paramList, int paramInt)
  {
    int j = 0;
    int i = paramInt;
    paramInt = j;
    if (paramInt < i)
    {
      j = paramInt + i >>> 1;
      if (paramComparator.compare(paramList.get(j), paramE) < 0) {
        paramInt = j + 1;
      }
      for (;;)
      {
        break;
        i = j;
      }
    }
    return paramInt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     com.google.common.collect.SortedLists.KeyPresentBehavior.3
 * JD-Core Version:    0.7.0.1
 */