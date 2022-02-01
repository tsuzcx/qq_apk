package com.google.common.graph;

import com.google.common.collect.BiMap;
import com.google.common.collect.HashBiMap;
import com.google.common.collect.ImmutableBiMap;
import java.util.Collections;
import java.util.Map;
import java.util.Set;

final class UndirectedNetworkConnections<N, E>
  extends AbstractUndirectedNetworkConnections<N, E>
{
  protected UndirectedNetworkConnections(Map<E, N> paramMap)
  {
    super(paramMap);
  }
  
  static <N, E> UndirectedNetworkConnections<N, E> of()
  {
    return new UndirectedNetworkConnections(HashBiMap.create(2));
  }
  
  static <N, E> UndirectedNetworkConnections<N, E> ofImmutable(Map<E, N> paramMap)
  {
    return new UndirectedNetworkConnections(ImmutableBiMap.copyOf(paramMap));
  }
  
  public Set<N> adjacentNodes()
  {
    return Collections.unmodifiableSet(((BiMap)this.incidentEdgeMap).values());
  }
  
  public Set<E> edgesConnecting(Object paramObject)
  {
    return new EdgesConnecting(((BiMap)this.incidentEdgeMap).inverse(), paramObject);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     com.google.common.graph.UndirectedNetworkConnections
 * JD-Core Version:    0.7.0.1
 */