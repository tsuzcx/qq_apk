package com.google.common.graph;

import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableMap;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

final class UndirectedGraphConnections<N, V>
  implements GraphConnections<N, V>
{
  private final Map<N, V> adjacentNodeValues;
  
  private UndirectedGraphConnections(Map<N, V> paramMap)
  {
    this.adjacentNodeValues = ((Map)Preconditions.checkNotNull(paramMap));
  }
  
  static <N, V> UndirectedGraphConnections<N, V> of()
  {
    return new UndirectedGraphConnections(new HashMap(2, 1.0F));
  }
  
  static <N, V> UndirectedGraphConnections<N, V> ofImmutable(Map<N, V> paramMap)
  {
    return new UndirectedGraphConnections(ImmutableMap.copyOf(paramMap));
  }
  
  public void addPredecessor(N paramN, V paramV)
  {
    addSuccessor(paramN, paramV);
  }
  
  public V addSuccessor(N paramN, V paramV)
  {
    return this.adjacentNodeValues.put(paramN, paramV);
  }
  
  public Set<N> adjacentNodes()
  {
    return Collections.unmodifiableSet(this.adjacentNodeValues.keySet());
  }
  
  public Set<N> predecessors()
  {
    return adjacentNodes();
  }
  
  public void removePredecessor(Object paramObject)
  {
    removeSuccessor(paramObject);
  }
  
  public V removeSuccessor(Object paramObject)
  {
    return this.adjacentNodeValues.remove(paramObject);
  }
  
  public Set<N> successors()
  {
    return adjacentNodes();
  }
  
  public V value(Object paramObject)
  {
    return this.adjacentNodeValues.get(paramObject);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     com.google.common.graph.UndirectedGraphConnections
 * JD-Core Version:    0.7.0.1
 */