package com.google.common.graph;

import com.google.common.annotations.Beta;
import com.google.common.base.Function;
import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.ImmutableMap.Builder;
import com.google.common.collect.Maps;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

@Beta
public final class ImmutableNetwork<N, E>
  extends ConfigurableNetwork<N, E>
{
  private ImmutableNetwork(Network<N, E> paramNetwork)
  {
    super(NetworkBuilder.from(paramNetwork), getNodeConnections(paramNetwork), getEdgeToReferenceNode(paramNetwork));
  }
  
  private static <N, E> Function<E, N> adjacentNodeFn(Network<N, E> paramNetwork, N paramN)
  {
    return new ImmutableNetwork.4(paramNetwork, paramN);
  }
  
  private static <N, E> NetworkConnections<N, E> connectionsOf(Network<N, E> paramNetwork, N paramN)
  {
    if (paramNetwork.isDirected())
    {
      Map localMap1 = Maps.asMap(paramNetwork.inEdges(paramN), sourceNodeFn(paramNetwork));
      Map localMap2 = Maps.asMap(paramNetwork.outEdges(paramN), targetNodeFn(paramNetwork));
      int i = paramNetwork.edgesConnecting(paramN, paramN).size();
      if (paramNetwork.allowsParallelEdges()) {
        return DirectedMultiNetworkConnections.ofImmutable(localMap1, localMap2, i);
      }
      return DirectedNetworkConnections.ofImmutable(localMap1, localMap2, i);
    }
    paramN = Maps.asMap(paramNetwork.incidentEdges(paramN), adjacentNodeFn(paramNetwork, paramN));
    if (paramNetwork.allowsParallelEdges()) {
      return UndirectedMultiNetworkConnections.ofImmutable(paramN);
    }
    return UndirectedNetworkConnections.ofImmutable(paramN);
  }
  
  @Deprecated
  public static <N, E> ImmutableNetwork<N, E> copyOf(ImmutableNetwork<N, E> paramImmutableNetwork)
  {
    return (ImmutableNetwork)Preconditions.checkNotNull(paramImmutableNetwork);
  }
  
  public static <N, E> ImmutableNetwork<N, E> copyOf(Network<N, E> paramNetwork)
  {
    if ((paramNetwork instanceof ImmutableNetwork)) {
      return (ImmutableNetwork)paramNetwork;
    }
    return new ImmutableNetwork(paramNetwork);
  }
  
  private static <N, E> Map<E, N> getEdgeToReferenceNode(Network<N, E> paramNetwork)
  {
    ImmutableMap.Builder localBuilder = ImmutableMap.builder();
    Iterator localIterator = paramNetwork.edges().iterator();
    while (localIterator.hasNext())
    {
      Object localObject = localIterator.next();
      localBuilder.put(localObject, paramNetwork.incidentNodes(localObject).nodeU());
    }
    return localBuilder.build();
  }
  
  private static <N, E> Map<N, NetworkConnections<N, E>> getNodeConnections(Network<N, E> paramNetwork)
  {
    ImmutableMap.Builder localBuilder = ImmutableMap.builder();
    Iterator localIterator = paramNetwork.nodes().iterator();
    while (localIterator.hasNext())
    {
      Object localObject = localIterator.next();
      localBuilder.put(localObject, connectionsOf(paramNetwork, localObject));
    }
    return localBuilder.build();
  }
  
  private static <N, E> Function<E, N> sourceNodeFn(Network<N, E> paramNetwork)
  {
    return new ImmutableNetwork.2(paramNetwork);
  }
  
  private static <N, E> Function<E, N> targetNodeFn(Network<N, E> paramNetwork)
  {
    return new ImmutableNetwork.3(paramNetwork);
  }
  
  public ImmutableGraph<N> asGraph()
  {
    return new ImmutableNetwork.1(this, super.asGraph());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     com.google.common.graph.ImmutableNetwork
 * JD-Core Version:    0.7.0.1
 */