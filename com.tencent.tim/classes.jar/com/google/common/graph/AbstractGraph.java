package com.google.common.graph;

import com.google.common.annotations.Beta;
import com.google.common.base.Preconditions;
import com.google.common.math.IntMath;
import java.util.Iterator;
import java.util.Set;

@Beta
public abstract class AbstractGraph<N>
  implements Graph<N>
{
  public int degree(Object paramObject)
  {
    if (isDirected()) {
      return IntMath.saturatedAdd(predecessors(paramObject).size(), successors(paramObject).size());
    }
    Set localSet = adjacentNodes(paramObject);
    if ((allowsSelfLoops()) && (localSet.contains(paramObject))) {}
    for (int i = 1;; i = 0) {
      return IntMath.saturatedAdd(localSet.size(), i);
    }
  }
  
  protected long edgeCount()
  {
    Iterator localIterator = nodes().iterator();
    for (long l = 0L; localIterator.hasNext(); l += degree(localIterator.next())) {}
    if ((1L & l) == 0L) {}
    for (boolean bool = true;; bool = false)
    {
      Preconditions.checkState(bool);
      return l >>> 1;
    }
  }
  
  public Set<EndpointPair<N>> edges()
  {
    return new AbstractGraph.1(this);
  }
  
  public int inDegree(Object paramObject)
  {
    if (isDirected()) {
      return predecessors(paramObject).size();
    }
    return degree(paramObject);
  }
  
  public int outDegree(Object paramObject)
  {
    if (isDirected()) {
      return successors(paramObject).size();
    }
    return degree(paramObject);
  }
  
  public String toString()
  {
    return String.format("%s, nodes: %s, edges: %s", new Object[] { String.format("isDirected: %s, allowsSelfLoops: %s", new Object[] { Boolean.valueOf(isDirected()), Boolean.valueOf(allowsSelfLoops()) }), nodes(), edges() });
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     com.google.common.graph.AbstractGraph
 * JD-Core Version:    0.7.0.1
 */