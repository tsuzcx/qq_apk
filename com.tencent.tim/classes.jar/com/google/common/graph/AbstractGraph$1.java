package com.google.common.graph;

import com.google.common.collect.UnmodifiableIterator;
import com.google.common.primitives.Ints;
import java.util.AbstractSet;
import java.util.Set;
import javax.annotation.Nullable;

class AbstractGraph$1
  extends AbstractSet<EndpointPair<N>>
{
  AbstractGraph$1(AbstractGraph paramAbstractGraph) {}
  
  public boolean contains(@Nullable Object paramObject)
  {
    if (!(paramObject instanceof EndpointPair)) {}
    do
    {
      return false;
      paramObject = (EndpointPair)paramObject;
    } while ((this.this$0.isDirected() != paramObject.isOrdered()) || (!this.this$0.nodes().contains(paramObject.nodeU())) || (!this.this$0.successors(paramObject.nodeU()).contains(paramObject.nodeV())));
    return true;
  }
  
  public UnmodifiableIterator<EndpointPair<N>> iterator()
  {
    return EndpointPairIterator.of(this.this$0);
  }
  
  public int size()
  {
    return Ints.saturatedCast(this.this$0.edgeCount());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     com.google.common.graph.AbstractGraph.1
 * JD-Core Version:    0.7.0.1
 */