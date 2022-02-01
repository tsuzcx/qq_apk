package com.google.common.collect;

import java.util.Iterator;
import java.util.Map.Entry;

class StandardTable$Row$1
  implements Iterator<Map.Entry<C, V>>
{
  StandardTable$Row$1(StandardTable.Row paramRow, Iterator paramIterator) {}
  
  public boolean hasNext()
  {
    return this.val$iterator.hasNext();
  }
  
  public Map.Entry<C, V> next()
  {
    return new StandardTable.Row.1.1(this, (Map.Entry)this.val$iterator.next());
  }
  
  public void remove()
  {
    this.val$iterator.remove();
    this.this$1.maintainEmptyInvariant();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     com.google.common.collect.StandardTable.Row.1
 * JD-Core Version:    0.7.0.1
 */