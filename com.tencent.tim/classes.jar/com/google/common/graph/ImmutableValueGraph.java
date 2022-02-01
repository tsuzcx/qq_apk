package com.google.common.graph;

import com.google.common.annotations.Beta;
import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.ImmutableMap.Builder;
import com.google.common.collect.Maps;
import java.util.Iterator;
import java.util.Set;
import javax.annotation.Nullable;

@Beta
public final class ImmutableValueGraph<N, V>
  extends ImmutableGraph.ValueBackedImpl<N, V>
  implements ValueGraph<N, V>
{
  private ImmutableValueGraph(ValueGraph<N, V> paramValueGraph)
  {
    super(ValueGraphBuilder.from(paramValueGraph), getNodeConnections(paramValueGraph), paramValueGraph.edges().size());
  }
  
  private static <N, V> GraphConnections<N, V> connectionsOf(ValueGraph<N, V> paramValueGraph, N paramN)
  {
    ImmutableValueGraph.1 local1 = new ImmutableValueGraph.1(paramValueGraph, paramN);
    if (paramValueGraph.isDirected()) {
      return DirectedGraphConnections.ofImmutable(paramValueGraph.predecessors(paramN), Maps.asMap(paramValueGraph.successors(paramN), local1));
    }
    return UndirectedGraphConnections.ofImmutable(Maps.asMap(paramValueGraph.adjacentNodes(paramN), local1));
  }
  
  @Deprecated
  public static <N, V> ImmutableValueGraph<N, V> copyOf(ImmutableValueGraph<N, V> paramImmutableValueGraph)
  {
    return (ImmutableValueGraph)Preconditions.checkNotNull(paramImmutableValueGraph);
  }
  
  public static <N, V> ImmutableValueGraph<N, V> copyOf(ValueGraph<N, V> paramValueGraph)
  {
    if ((paramValueGraph instanceof ImmutableValueGraph)) {
      return (ImmutableValueGraph)paramValueGraph;
    }
    return new ImmutableValueGraph(paramValueGraph);
  }
  
  private static <N, V> ImmutableMap<N, GraphConnections<N, V>> getNodeConnections(ValueGraph<N, V> paramValueGraph)
  {
    ImmutableMap.Builder localBuilder = ImmutableMap.builder();
    Iterator localIterator = paramValueGraph.nodes().iterator();
    while (localIterator.hasNext())
    {
      Object localObject = localIterator.next();
      localBuilder.put(localObject, connectionsOf(paramValueGraph, localObject));
    }
    return localBuilder.build();
  }
  
  public V edgeValue(Object paramObject1, Object paramObject2)
  {
    return this.backingValueGraph.edgeValue(paramObject1, paramObject2);
  }
  
  public V edgeValueOrDefault(Object paramObject1, Object paramObject2, @Nullable V paramV)
  {
    return this.backingValueGraph.edgeValueOrDefault(paramObject1, paramObject2, paramV);
  }
  
  public String toString()
  {
    return this.backingValueGraph.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     com.google.common.graph.ImmutableValueGraph
 * JD-Core Version:    0.7.0.1
 */