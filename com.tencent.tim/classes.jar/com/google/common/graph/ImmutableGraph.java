package com.google.common.graph;

import com.google.common.annotations.Beta;
import com.google.common.base.Function;
import com.google.common.base.Functions;
import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.ImmutableMap.Builder;
import com.google.common.collect.Maps;
import java.util.Iterator;
import java.util.Set;

@Beta
public abstract class ImmutableGraph<N>
  extends ForwardingGraph<N>
{
  private static <N> GraphConnections<N, GraphConstants.Presence> connectionsOf(Graph<N> paramGraph, N paramN)
  {
    Function localFunction = Functions.constant(GraphConstants.Presence.EDGE_EXISTS);
    if (paramGraph.isDirected()) {
      return DirectedGraphConnections.ofImmutable(paramGraph.predecessors(paramN), Maps.asMap(paramGraph.successors(paramN), localFunction));
    }
    return UndirectedGraphConnections.ofImmutable(Maps.asMap(paramGraph.adjacentNodes(paramN), localFunction));
  }
  
  public static <N> ImmutableGraph<N> copyOf(Graph<N> paramGraph)
  {
    if ((paramGraph instanceof ImmutableGraph)) {
      return (ImmutableGraph)paramGraph;
    }
    return new ValueBackedImpl(GraphBuilder.from(paramGraph), getNodeConnections(paramGraph), paramGraph.edges().size());
  }
  
  @Deprecated
  public static <N> ImmutableGraph<N> copyOf(ImmutableGraph<N> paramImmutableGraph)
  {
    return (ImmutableGraph)Preconditions.checkNotNull(paramImmutableGraph);
  }
  
  private static <N> ImmutableMap<N, GraphConnections<N, GraphConstants.Presence>> getNodeConnections(Graph<N> paramGraph)
  {
    ImmutableMap.Builder localBuilder = ImmutableMap.builder();
    Iterator localIterator = paramGraph.nodes().iterator();
    while (localIterator.hasNext())
    {
      Object localObject = localIterator.next();
      localBuilder.put(localObject, connectionsOf(paramGraph, localObject));
    }
    return localBuilder.build();
  }
  
  static class ValueBackedImpl<N, V>
    extends ImmutableGraph<N>
  {
    protected final ValueGraph<N, V> backingValueGraph;
    
    ValueBackedImpl(AbstractGraphBuilder<? super N> paramAbstractGraphBuilder, ImmutableMap<N, GraphConnections<N, V>> paramImmutableMap, long paramLong)
    {
      this.backingValueGraph = new ConfigurableValueGraph(paramAbstractGraphBuilder, paramImmutableMap, paramLong);
    }
    
    protected Graph<N> delegate()
    {
      return this.backingValueGraph;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     com.google.common.graph.ImmutableGraph
 * JD-Core Version:    0.7.0.1
 */