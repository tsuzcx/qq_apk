package com.google.common.collect;

import java.util.Comparator;
import java.util.List;

 enum SortedLists$KeyPresentBehavior$2
{
  SortedLists$KeyPresentBehavior$2()
  {
    super(str, i, null);
  }
  
  <E> int resultIndex(Comparator<? super E> paramComparator, E paramE, List<? extends E> paramList, int paramInt)
  {
    int i = paramList.size() - 1;
    while (paramInt < i)
    {
      int j = paramInt + i + 1 >>> 1;
      if (paramComparator.compare(paramList.get(j), paramE) > 0) {
        i = j - 1;
      } else {
        paramInt = j;
      }
    }
    return paramInt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     com.google.common.collect.SortedLists.KeyPresentBehavior.2
 * JD-Core Version:    0.7.0.1
 */