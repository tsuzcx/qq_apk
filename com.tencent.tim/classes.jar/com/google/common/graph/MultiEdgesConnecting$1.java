package com.google.common.graph;

import com.google.common.collect.AbstractIterator;
import java.util.Iterator;
import java.util.Map.Entry;

class MultiEdgesConnecting$1
  extends AbstractIterator<E>
{
  MultiEdgesConnecting$1(MultiEdgesConnecting paramMultiEdgesConnecting, Iterator paramIterator) {}
  
  public E computeNext()
  {
    while (this.val$entries.hasNext())
    {
      Map.Entry localEntry = (Map.Entry)this.val$entries.next();
      if (MultiEdgesConnecting.access$000(this.this$0).equals(localEntry.getValue())) {
        return localEntry.getKey();
      }
    }
    return endOfData();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     com.google.common.graph.MultiEdgesConnecting.1
 * JD-Core Version:    0.7.0.1
 */