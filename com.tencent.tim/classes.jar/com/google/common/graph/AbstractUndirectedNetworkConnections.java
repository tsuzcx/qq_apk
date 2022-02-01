package com.google.common.graph;

import com.google.common.base.Preconditions;
import java.util.Collections;
import java.util.Map;
import java.util.Set;

abstract class AbstractUndirectedNetworkConnections<N, E>
  implements NetworkConnections<N, E>
{
  protected final Map<E, N> incidentEdgeMap;
  
  protected AbstractUndirectedNetworkConnections(Map<E, N> paramMap)
  {
    this.incidentEdgeMap = ((Map)Preconditions.checkNotNull(paramMap));
  }
  
  public void addInEdge(E paramE, N paramN, boolean paramBoolean)
  {
    if (!paramBoolean) {
      addOutEdge(paramE, paramN);
    }
  }
  
  public void addOutEdge(E paramE, N paramN)
  {
    if (this.incidentEdgeMap.put(paramE, paramN) == null) {}
    for (boolean bool = true;; bool = false)
    {
      Preconditions.checkState(bool);
      return;
    }
  }
  
  public Set<E> inEdges()
  {
    return incidentEdges();
  }
  
  public Set<E> incidentEdges()
  {
    return Collections.unmodifiableSet(this.incidentEdgeMap.keySet());
  }
  
  public N oppositeNode(Object paramObject)
  {
    return Preconditions.checkNotNull(this.incidentEdgeMap.get(paramObject));
  }
  
  public Set<E> outEdges()
  {
    return incidentEdges();
  }
  
  public Set<N> predecessors()
  {
    return adjacentNodes();
  }
  
  public N removeInEdge(Object paramObject, boolean paramBoolean)
  {
    if (!paramBoolean) {
      return removeOutEdge(paramObject);
    }
    return null;
  }
  
  public N removeOutEdge(Object paramObject)
  {
    return Preconditions.checkNotNull(this.incidentEdgeMap.remove(paramObject));
  }
  
  public Set<N> successors()
  {
    return adjacentNodes();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     com.google.common.graph.AbstractUndirectedNetworkConnections
 * JD-Core Version:    0.7.0.1
 */