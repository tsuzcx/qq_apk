package com.google.common.graph;

import com.google.common.annotations.Beta;
import com.google.errorprone.annotations.CanIgnoreReturnValue;

@Beta
public abstract interface MutableNetwork<N, E>
  extends Network<N, E>
{
  @CanIgnoreReturnValue
  public abstract boolean addEdge(N paramN1, N paramN2, E paramE);
  
  @CanIgnoreReturnValue
  public abstract boolean addNode(N paramN);
  
  @CanIgnoreReturnValue
  public abstract boolean removeEdge(Object paramObject);
  
  @CanIgnoreReturnValue
  public abstract boolean removeNode(Object paramObject);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     com.google.common.graph.MutableNetwork
 * JD-Core Version:    0.7.0.1
 */