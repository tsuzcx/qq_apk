package com.google.common.graph;

final class ConfigurableMutableGraph<N>
  extends ForwardingGraph<N>
  implements MutableGraph<N>
{
  private final MutableValueGraph<N, GraphConstants.Presence> backingValueGraph;
  
  ConfigurableMutableGraph(AbstractGraphBuilder<? super N> paramAbstractGraphBuilder)
  {
    this.backingValueGraph = new ConfigurableMutableValueGraph(paramAbstractGraphBuilder);
  }
  
  public boolean addNode(N paramN)
  {
    return this.backingValueGraph.addNode(paramN);
  }
  
  protected Graph<N> delegate()
  {
    return this.backingValueGraph;
  }
  
  public boolean putEdge(N paramN1, N paramN2)
  {
    return this.backingValueGraph.putEdgeValue(paramN1, paramN2, GraphConstants.Presence.EDGE_EXISTS) == null;
  }
  
  public boolean removeEdge(Object paramObject1, Object paramObject2)
  {
    return this.backingValueGraph.removeEdge(paramObject1, paramObject2) != null;
  }
  
  public boolean removeNode(Object paramObject)
  {
    return this.backingValueGraph.removeNode(paramObject);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     com.google.common.graph.ConfigurableMutableGraph
 * JD-Core Version:    0.7.0.1
 */