package com.google.common.graph;

import com.google.errorprone.annotations.CanIgnoreReturnValue;
import java.util.Set;
import javax.annotation.Nullable;

abstract interface GraphConnections<N, V>
{
  public abstract void addPredecessor(N paramN, V paramV);
  
  @CanIgnoreReturnValue
  public abstract V addSuccessor(N paramN, V paramV);
  
  public abstract Set<N> adjacentNodes();
  
  public abstract Set<N> predecessors();
  
  public abstract void removePredecessor(Object paramObject);
  
  @CanIgnoreReturnValue
  public abstract V removeSuccessor(Object paramObject);
  
  public abstract Set<N> successors();
  
  @Nullable
  public abstract V value(Object paramObject);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     com.google.common.graph.GraphConnections
 * JD-Core Version:    0.7.0.1
 */