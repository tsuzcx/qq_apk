package com.google.common.graph;

import com.google.common.annotations.Beta;
import java.util.Set;
import javax.annotation.Nullable;

@Beta
public abstract interface Graph<N>
{
  public abstract Set<N> adjacentNodes(Object paramObject);
  
  public abstract boolean allowsSelfLoops();
  
  public abstract int degree(Object paramObject);
  
  public abstract Set<EndpointPair<N>> edges();
  
  public abstract boolean equals(@Nullable Object paramObject);
  
  public abstract int hashCode();
  
  public abstract int inDegree(Object paramObject);
  
  public abstract boolean isDirected();
  
  public abstract ElementOrder<N> nodeOrder();
  
  public abstract Set<N> nodes();
  
  public abstract int outDegree(Object paramObject);
  
  public abstract Set<N> predecessors(Object paramObject);
  
  public abstract Set<N> successors(Object paramObject);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     com.google.common.graph.Graph
 * JD-Core Version:    0.7.0.1
 */