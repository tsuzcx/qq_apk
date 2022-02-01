package com.google.common.graph;

import java.util.Set;

class AbstractNetwork$1
  extends AbstractGraph<N>
{
  AbstractNetwork$1(AbstractNetwork paramAbstractNetwork) {}
  
  public Set<N> adjacentNodes(Object paramObject)
  {
    return this.this$0.adjacentNodes(paramObject);
  }
  
  public boolean allowsSelfLoops()
  {
    return this.this$0.allowsSelfLoops();
  }
  
  public Set<EndpointPair<N>> edges()
  {
    if (this.this$0.allowsParallelEdges()) {
      return super.edges();
    }
    return new AbstractNetwork.1.1(this);
  }
  
  public boolean isDirected()
  {
    return this.this$0.isDirected();
  }
  
  public ElementOrder<N> nodeOrder()
  {
    return this.this$0.nodeOrder();
  }
  
  public Set<N> nodes()
  {
    return this.this$0.nodes();
  }
  
  public Set<N> predecessors(Object paramObject)
  {
    return this.this$0.predecessors(paramObject);
  }
  
  public Set<N> successors(Object paramObject)
  {
    return this.this$0.successors(paramObject);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     com.google.common.graph.AbstractNetwork.1
 * JD-Core Version:    0.7.0.1
 */