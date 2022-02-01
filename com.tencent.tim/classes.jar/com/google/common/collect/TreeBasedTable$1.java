package com.google.common.collect;

import com.google.common.base.Function;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

class TreeBasedTable$1
  implements Function<Map<C, V>, Iterator<C>>
{
  TreeBasedTable$1(TreeBasedTable paramTreeBasedTable) {}
  
  public Iterator<C> apply(Map<C, V> paramMap)
  {
    return paramMap.keySet().iterator();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     com.google.common.collect.TreeBasedTable.1
 * JD-Core Version:    0.7.0.1
 */