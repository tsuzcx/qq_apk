package com.tencent.mm.algorithm;

import java.util.Comparator;
import java.util.Map.Entry;

class LRUMap$1
  implements Comparator
{
  LRUMap$1(LRUMap paramLRUMap) {}
  
  public int compare(Map.Entry paramEntry1, Map.Entry paramEntry2)
  {
    return ((LRUMap.TimeVal)paramEntry1.getValue()).t.compareTo(((LRUMap.TimeVal)paramEntry2.getValue()).t);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.mm.algorithm.LRUMap.1
 * JD-Core Version:    0.7.0.1
 */