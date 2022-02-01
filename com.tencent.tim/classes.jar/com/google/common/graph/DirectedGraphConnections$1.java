package com.google.common.graph;

import com.google.common.collect.UnmodifiableIterator;
import java.util.AbstractSet;
import java.util.Map;
import java.util.Set;
import javax.annotation.Nullable;

class DirectedGraphConnections$1
  extends AbstractSet<N>
{
  DirectedGraphConnections$1(DirectedGraphConnections paramDirectedGraphConnections) {}
  
  public boolean contains(@Nullable Object paramObject)
  {
    return DirectedGraphConnections.access$100(DirectedGraphConnections.access$000(this.this$0).get(paramObject));
  }
  
  public UnmodifiableIterator<N> iterator()
  {
    return new DirectedGraphConnections.1.1(this, DirectedGraphConnections.access$000(this.this$0).entrySet().iterator());
  }
  
  public int size()
  {
    return DirectedGraphConnections.access$200(this.this$0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     com.google.common.graph.DirectedGraphConnections.1
 * JD-Core Version:    0.7.0.1
 */