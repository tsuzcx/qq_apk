package com.google.common.graph;

import com.google.common.base.Preconditions;
import com.google.common.collect.AbstractIterator;
import com.google.common.collect.ImmutableSet;
import com.google.common.collect.Sets;
import java.util.Iterator;
import java.util.Set;

abstract class EndpointPairIterator<N>
  extends AbstractIterator<EndpointPair<N>>
{
  private final Graph<N> graph;
  protected N node = null;
  private final Iterator<N> nodeIterator;
  protected Iterator<N> successorIterator = ImmutableSet.of().iterator();
  
  private EndpointPairIterator(Graph<N> paramGraph)
  {
    this.graph = paramGraph;
    this.nodeIterator = paramGraph.nodes().iterator();
  }
  
  static <N> EndpointPairIterator<N> of(Graph<N> paramGraph)
  {
    if (paramGraph.isDirected()) {
      return new Directed(paramGraph, null);
    }
    return new Undirected(paramGraph, null);
  }
  
  protected final boolean advance()
  {
    if (!this.successorIterator.hasNext()) {}
    for (boolean bool = true;; bool = false)
    {
      Preconditions.checkState(bool);
      if (this.nodeIterator.hasNext()) {
        break;
      }
      return false;
    }
    this.node = this.nodeIterator.next();
    this.successorIterator = this.graph.successors(this.node).iterator();
    return true;
  }
  
  static final class Directed<N>
    extends EndpointPairIterator<N>
  {
    private Directed(Graph<N> paramGraph)
    {
      super(null);
    }
    
    protected EndpointPair<N> computeNext()
    {
      do
      {
        if (this.successorIterator.hasNext()) {
          return EndpointPair.ordered(this.node, this.successorIterator.next());
        }
      } while (advance());
      return (EndpointPair)endOfData();
    }
  }
  
  static final class Undirected<N>
    extends EndpointPairIterator<N>
  {
    private Set<N> visitedNodes;
    
    private Undirected(Graph<N> paramGraph)
    {
      super(null);
      this.visitedNodes = Sets.newHashSetWithExpectedSize(paramGraph.nodes().size());
    }
    
    protected EndpointPair<N> computeNext()
    {
      do
      {
        while (this.successorIterator.hasNext())
        {
          Object localObject = this.successorIterator.next();
          if (!this.visitedNodes.contains(localObject)) {
            return EndpointPair.unordered(this.node, localObject);
          }
        }
        this.visitedNodes.add(this.node);
      } while (advance());
      this.visitedNodes = null;
      return (EndpointPair)endOfData();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     com.google.common.graph.EndpointPairIterator
 * JD-Core Version:    0.7.0.1
 */