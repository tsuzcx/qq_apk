package com.google.common.graph;

import com.google.common.annotations.Beta;
import com.google.common.collect.ImmutableSet;
import com.google.common.collect.Maps;
import com.google.common.collect.Sets;
import com.google.common.math.IntMath;
import java.util.Map;
import java.util.Set;

@Beta
public abstract class AbstractNetwork<N, E>
  implements Network<N, E>
{
  private Map<E, EndpointPair<N>> edgeIncidentNodesMap()
  {
    AbstractNetwork.2 local2 = new AbstractNetwork.2(this);
    return Maps.asMap(edges(), local2);
  }
  
  public Set<E> adjacentEdges(Object paramObject)
  {
    EndpointPair localEndpointPair = incidentNodes(paramObject);
    return Sets.difference(Sets.union(incidentEdges(localEndpointPair.nodeU()), incidentEdges(localEndpointPair.nodeV())), ImmutableSet.of(paramObject));
  }
  
  public Graph<N> asGraph()
  {
    return new AbstractNetwork.1(this);
  }
  
  public int degree(Object paramObject)
  {
    if (isDirected()) {
      return IntMath.saturatedAdd(inEdges(paramObject).size(), outEdges(paramObject).size());
    }
    return IntMath.saturatedAdd(incidentEdges(paramObject).size(), edgesConnecting(paramObject, paramObject).size());
  }
  
  public int inDegree(Object paramObject)
  {
    if (isDirected()) {
      return inEdges(paramObject).size();
    }
    return degree(paramObject);
  }
  
  public int outDegree(Object paramObject)
  {
    if (isDirected()) {
      return outEdges(paramObject).size();
    }
    return degree(paramObject);
  }
  
  public String toString()
  {
    return String.format("%s, nodes: %s, edges: %s", new Object[] { String.format("isDirected: %s, allowsParallelEdges: %s, allowsSelfLoops: %s", new Object[] { Boolean.valueOf(isDirected()), Boolean.valueOf(allowsParallelEdges()), Boolean.valueOf(allowsSelfLoops()) }), nodes(), edgeIncidentNodesMap() });
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     com.google.common.graph.AbstractNetwork
 * JD-Core Version:    0.7.0.1
 */