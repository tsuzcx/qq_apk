package com.google.common.graph;

import com.google.common.base.Preconditions;
import com.google.common.collect.Sets;
import java.util.Collections;
import java.util.Map;
import java.util.Set;

abstract class AbstractDirectedNetworkConnections<N, E>
  implements NetworkConnections<N, E>
{
  protected final Map<E, N> inEdgeMap;
  protected final Map<E, N> outEdgeMap;
  private int selfLoopCount;
  
  protected AbstractDirectedNetworkConnections(Map<E, N> paramMap1, Map<E, N> paramMap2, int paramInt)
  {
    this.inEdgeMap = ((Map)Preconditions.checkNotNull(paramMap1));
    this.outEdgeMap = ((Map)Preconditions.checkNotNull(paramMap2));
    this.selfLoopCount = Graphs.checkNonNegative(paramInt);
    if ((paramInt <= paramMap1.size()) && (paramInt <= paramMap2.size())) {}
    for (boolean bool = true;; bool = false)
    {
      Preconditions.checkState(bool);
      return;
    }
  }
  
  public void addInEdge(E paramE, N paramN, boolean paramBoolean)
  {
    if (paramBoolean)
    {
      int i = this.selfLoopCount + 1;
      this.selfLoopCount = i;
      Graphs.checkPositive(i);
    }
    if (this.inEdgeMap.put(paramE, paramN) == null) {}
    for (paramBoolean = true;; paramBoolean = false)
    {
      Preconditions.checkState(paramBoolean);
      return;
    }
  }
  
  public void addOutEdge(E paramE, N paramN)
  {
    if (this.outEdgeMap.put(paramE, paramN) == null) {}
    for (boolean bool = true;; bool = false)
    {
      Preconditions.checkState(bool);
      return;
    }
  }
  
  public Set<N> adjacentNodes()
  {
    return Sets.union(predecessors(), successors());
  }
  
  public Set<E> inEdges()
  {
    return Collections.unmodifiableSet(this.inEdgeMap.keySet());
  }
  
  public Set<E> incidentEdges()
  {
    return new AbstractDirectedNetworkConnections.1(this);
  }
  
  public N oppositeNode(Object paramObject)
  {
    return Preconditions.checkNotNull(this.outEdgeMap.get(paramObject));
  }
  
  public Set<E> outEdges()
  {
    return Collections.unmodifiableSet(this.outEdgeMap.keySet());
  }
  
  public N removeInEdge(Object paramObject, boolean paramBoolean)
  {
    if (paramBoolean)
    {
      int i = this.selfLoopCount - 1;
      this.selfLoopCount = i;
      Graphs.checkNonNegative(i);
    }
    return Preconditions.checkNotNull(this.inEdgeMap.remove(paramObject));
  }
  
  public N removeOutEdge(Object paramObject)
  {
    return Preconditions.checkNotNull(this.outEdgeMap.remove(paramObject));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     com.google.common.graph.AbstractDirectedNetworkConnections
 * JD-Core Version:    0.7.0.1
 */