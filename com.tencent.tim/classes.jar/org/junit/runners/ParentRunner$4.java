package org.junit.runners;

import java.util.Comparator;
import org.junit.runner.manipulation.Sorter;

class ParentRunner$4
  implements Comparator<T>
{
  ParentRunner$4(ParentRunner paramParentRunner, Sorter paramSorter) {}
  
  public int compare(T paramT1, T paramT2)
  {
    return this.val$sorter.compare(this.this$0.describeChild(paramT1), this.this$0.describeChild(paramT2));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     org.junit.runners.ParentRunner.4
 * JD-Core Version:    0.7.0.1
 */