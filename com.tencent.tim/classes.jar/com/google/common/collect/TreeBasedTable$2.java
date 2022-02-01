package com.google.common.collect;

import java.util.Comparator;
import java.util.Iterator;

class TreeBasedTable$2
  extends AbstractIterator<C>
{
  C lastValue;
  
  TreeBasedTable$2(TreeBasedTable paramTreeBasedTable, Iterator paramIterator, Comparator paramComparator) {}
  
  protected C computeNext()
  {
    if (this.val$merged.hasNext())
    {
      Object localObject = this.val$merged.next();
      if ((this.lastValue != null) && (this.val$comparator.compare(localObject, this.lastValue) == 0)) {}
      for (int i = 1; i == 0; i = 0)
      {
        this.lastValue = localObject;
        return this.lastValue;
      }
    }
    this.lastValue = null;
    return endOfData();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     com.google.common.collect.TreeBasedTable.2
 * JD-Core Version:    0.7.0.1
 */