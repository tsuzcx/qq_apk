package com.google.common.graph;

import com.google.common.annotations.Beta;
import java.util.Set;
import javax.annotation.Nullable;

@Beta
public abstract interface Network<N, E>
{
  public abstract Set<E> adjacentEdges(Object paramObject);
  
  public abstract Set<N> adjacentNodes(Object paramObject);
  
  public abstract boolean allowsParallelEdges();
  
  public abstract boolean allowsSelfLoops();
  
  public abstract Graph<N> asGraph();
  
  public abstract int degree(Object paramObject);
  
  public abstract ElementOrder<E> edgeOrder();
  
  public abstract Set<E> edges();
  
  public abstract Set<E> edgesConnecting(Object paramObject1, Object paramObject2);
  
  public abstract boolean equals(@Nullable Object paramObject);
  
  public abstract int hashCode();
  
  public abstract int inDegree(Object paramObject);
  
  public abstract Set<E> inEdges(Object paramObject);
  
  public abstract Set<E> incidentEdges(Object paramObject);
  
  public abstract EndpointPair<N> incidentNodes(Object paramObject);
  
  public abstract boolean isDirected();
  
  public abstract ElementOrder<N> nodeOrder();
  
  public abstract Set<N> nodes();
  
  public abstract int outDegree(Object paramObject);
  
  public abstract Set<E> outEdges(Object paramObject);
  
  public abstract Set<N> predecessors(Object paramObject);
  
  public abstract Set<N> successors(Object paramObject);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     com.google.common.graph.Network
 * JD-Core Version:    0.7.0.1
 */