package com.google.common.graph;

import com.google.common.collect.AbstractIterator;
import java.util.Iterator;
import java.util.Map.Entry;

class DirectedGraphConnections$2$1
  extends AbstractIterator<N>
{
  DirectedGraphConnections$2$1(DirectedGraphConnections.2 param2, Iterator paramIterator) {}
  
  public N computeNext()
  {
    while (this.val$entries.hasNext())
    {
      Map.Entry localEntry = (Map.Entry)this.val$entries.next();
      if (DirectedGraphConnections.access$300(localEntry.getValue())) {
        return localEntry.getKey();
      }
    }
    return endOfData();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     com.google.common.graph.DirectedGraphConnections.2.1
 * JD-Core Version:    0.7.0.1
 */