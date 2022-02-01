package com.google.common.graph;

import com.google.errorprone.annotations.CanIgnoreReturnValue;
import java.util.Set;

abstract interface NetworkConnections<N, E>
{
  public abstract void addInEdge(E paramE, N paramN, boolean paramBoolean);
  
  public abstract void addOutEdge(E paramE, N paramN);
  
  public abstract Set<N> adjacentNodes();
  
  public abstract Set<E> edgesConnecting(Object paramObject);
  
  public abstract Set<E> inEdges();
  
  public abstract Set<E> incidentEdges();
  
  public abstract N oppositeNode(Object paramObject);
  
  public abstract Set<E> outEdges();
  
  public abstract Set<N> predecessors();
  
  @CanIgnoreReturnValue
  public abstract N removeInEdge(Object paramObject, boolean paramBoolean);
  
  @CanIgnoreReturnValue
  public abstract N removeOutEdge(Object paramObject);
  
  public abstract Set<N> successors();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     com.google.common.graph.NetworkConnections
 * JD-Core Version:    0.7.0.1
 */