package com.google.common.graph;

import com.google.common.annotations.Beta;
import com.google.errorprone.annotations.CanIgnoreReturnValue;

@Beta
public abstract interface MutableGraph<N>
  extends Graph<N>
{
  @CanIgnoreReturnValue
  public abstract boolean addNode(N paramN);
  
  @CanIgnoreReturnValue
  public abstract boolean putEdge(N paramN1, N paramN2);
  
  @CanIgnoreReturnValue
  public abstract boolean removeEdge(Object paramObject1, Object paramObject2);
  
  @CanIgnoreReturnValue
  public abstract boolean removeNode(Object paramObject);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     com.google.common.graph.MutableGraph
 * JD-Core Version:    0.7.0.1
 */