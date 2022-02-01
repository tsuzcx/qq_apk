package com.google.common.graph;

import com.google.common.annotations.Beta;
import com.google.errorprone.annotations.CanIgnoreReturnValue;

@Beta
public abstract interface MutableValueGraph<N, V>
  extends ValueGraph<N, V>
{
  @CanIgnoreReturnValue
  public abstract boolean addNode(N paramN);
  
  @CanIgnoreReturnValue
  public abstract V putEdgeValue(N paramN1, N paramN2, V paramV);
  
  @CanIgnoreReturnValue
  public abstract V removeEdge(Object paramObject1, Object paramObject2);
  
  @CanIgnoreReturnValue
  public abstract boolean removeNode(Object paramObject);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     com.google.common.graph.MutableValueGraph
 * JD-Core Version:    0.7.0.1
 */