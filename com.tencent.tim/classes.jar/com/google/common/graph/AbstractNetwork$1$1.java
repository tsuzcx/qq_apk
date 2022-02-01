package com.google.common.graph;

import com.google.common.collect.Iterators;
import java.util.AbstractSet;
import java.util.Iterator;
import java.util.Set;
import javax.annotation.Nullable;

class AbstractNetwork$1$1
  extends AbstractSet<EndpointPair<N>>
{
  AbstractNetwork$1$1(AbstractNetwork.1 param1) {}
  
  public boolean contains(@Nullable Object paramObject)
  {
    if (!(paramObject instanceof EndpointPair)) {}
    do
    {
      return false;
      paramObject = (EndpointPair)paramObject;
    } while ((this.this$1.isDirected() != paramObject.isOrdered()) || (!this.this$1.nodes().contains(paramObject.nodeU())) || (!this.this$1.successors(paramObject.nodeU()).contains(paramObject.nodeV())));
    return true;
  }
  
  public Iterator<EndpointPair<N>> iterator()
  {
    return Iterators.transform(this.this$1.this$0.edges().iterator(), new AbstractNetwork.1.1.1(this));
  }
  
  public int size()
  {
    return this.this$1.this$0.edges().size();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     com.google.common.graph.AbstractNetwork.1.1
 * JD-Core Version:    0.7.0.1
 */