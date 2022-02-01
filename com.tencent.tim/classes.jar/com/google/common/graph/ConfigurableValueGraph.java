package com.google.common.graph;

import com.google.common.base.Optional;
import com.google.common.base.Preconditions;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import javax.annotation.Nullable;

class ConfigurableValueGraph<N, V>
  extends AbstractValueGraph<N, V>
{
  private final boolean allowsSelfLoops;
  protected long edgeCount;
  private final boolean isDirected;
  protected final MapIteratorCache<N, GraphConnections<N, V>> nodeConnections;
  private final ElementOrder<N> nodeOrder;
  
  ConfigurableValueGraph(AbstractGraphBuilder<? super N> paramAbstractGraphBuilder)
  {
    this(paramAbstractGraphBuilder, paramAbstractGraphBuilder.nodeOrder.createMap(((Integer)paramAbstractGraphBuilder.expectedNodeCount.or(Integer.valueOf(10))).intValue()), 0L);
  }
  
  ConfigurableValueGraph(AbstractGraphBuilder<? super N> paramAbstractGraphBuilder, Map<N, GraphConnections<N, V>> paramMap, long paramLong)
  {
    this.isDirected = paramAbstractGraphBuilder.directed;
    this.allowsSelfLoops = paramAbstractGraphBuilder.allowsSelfLoops;
    this.nodeOrder = paramAbstractGraphBuilder.nodeOrder.cast();
    if ((paramMap instanceof TreeMap)) {}
    for (paramAbstractGraphBuilder = new MapRetrievalCache(paramMap);; paramAbstractGraphBuilder = new MapIteratorCache(paramMap))
    {
      this.nodeConnections = paramAbstractGraphBuilder;
      this.edgeCount = Graphs.checkNonNegative(paramLong);
      return;
    }
  }
  
  public Set<N> adjacentNodes(Object paramObject)
  {
    return checkedConnections(paramObject).adjacentNodes();
  }
  
  public boolean allowsSelfLoops()
  {
    return this.allowsSelfLoops;
  }
  
  protected final GraphConnections<N, V> checkedConnections(Object paramObject)
  {
    GraphConnections localGraphConnections = (GraphConnections)this.nodeConnections.get(paramObject);
    if (localGraphConnections == null)
    {
      Preconditions.checkNotNull(paramObject);
      throw new IllegalArgumentException(String.format("Node %s is not an element of this graph.", new Object[] { paramObject }));
    }
    return localGraphConnections;
  }
  
  protected final boolean containsNode(@Nullable Object paramObject)
  {
    return this.nodeConnections.containsKey(paramObject);
  }
  
  protected long edgeCount()
  {
    return this.edgeCount;
  }
  
  public V edgeValueOrDefault(Object paramObject1, Object paramObject2, @Nullable V paramV)
  {
    paramObject1 = (GraphConnections)this.nodeConnections.get(paramObject1);
    if (paramObject1 == null) {}
    do
    {
      return paramV;
      paramObject1 = paramObject1.value(paramObject2);
    } while (paramObject1 == null);
    return paramObject1;
  }
  
  public boolean isDirected()
  {
    return this.isDirected;
  }
  
  public ElementOrder<N> nodeOrder()
  {
    return this.nodeOrder;
  }
  
  public Set<N> nodes()
  {
    return this.nodeConnections.unmodifiableKeySet();
  }
  
  public Set<N> predecessors(Object paramObject)
  {
    return checkedConnections(paramObject).predecessors();
  }
  
  public Set<N> successors(Object paramObject)
  {
    return checkedConnections(paramObject).successors();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     com.google.common.graph.ConfigurableValueGraph
 * JD-Core Version:    0.7.0.1
 */