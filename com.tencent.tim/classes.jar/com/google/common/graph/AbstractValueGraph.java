package com.google.common.graph;

import com.google.common.annotations.Beta;
import com.google.common.base.Preconditions;
import com.google.common.collect.Maps;
import java.util.Map;
import java.util.Set;

@Beta
public abstract class AbstractValueGraph<N, V>
  extends AbstractGraph<N>
  implements ValueGraph<N, V>
{
  private Map<EndpointPair<N>, V> edgeValueMap()
  {
    AbstractValueGraph.1 local1 = new AbstractValueGraph.1(this);
    return Maps.asMap(edges(), local1);
  }
  
  public V edgeValue(Object paramObject1, Object paramObject2)
  {
    Object localObject = edgeValueOrDefault(paramObject1, paramObject2, null);
    if (localObject == null)
    {
      Preconditions.checkArgument(nodes().contains(paramObject1), "Node %s is not an element of this graph.", paramObject1);
      Preconditions.checkArgument(nodes().contains(paramObject2), "Node %s is not an element of this graph.", paramObject2);
      throw new IllegalArgumentException(String.format("Edge connecting %s to %s is not present in this graph.", new Object[] { paramObject1, paramObject2 }));
    }
    return localObject;
  }
  
  public String toString()
  {
    return String.format("%s, nodes: %s, edges: %s", new Object[] { String.format("isDirected: %s, allowsSelfLoops: %s", new Object[] { Boolean.valueOf(isDirected()), Boolean.valueOf(allowsSelfLoops()) }), nodes(), edgeValueMap() });
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     com.google.common.graph.AbstractValueGraph
 * JD-Core Version:    0.7.0.1
 */