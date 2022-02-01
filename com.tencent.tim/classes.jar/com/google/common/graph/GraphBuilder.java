package com.google.common.graph;

import com.google.common.annotations.Beta;
import com.google.common.base.Optional;
import com.google.common.base.Preconditions;

@Beta
public final class GraphBuilder<N>
  extends AbstractGraphBuilder<N>
{
  private GraphBuilder(boolean paramBoolean)
  {
    super(paramBoolean);
  }
  
  private <N1 extends N> GraphBuilder<N1> cast()
  {
    return this;
  }
  
  public static GraphBuilder<Object> directed()
  {
    return new GraphBuilder(true);
  }
  
  public static <N> GraphBuilder<N> from(Graph<N> paramGraph)
  {
    return new GraphBuilder(paramGraph.isDirected()).allowsSelfLoops(paramGraph.allowsSelfLoops()).nodeOrder(paramGraph.nodeOrder());
  }
  
  public static GraphBuilder<Object> undirected()
  {
    return new GraphBuilder(false);
  }
  
  public GraphBuilder<N> allowsSelfLoops(boolean paramBoolean)
  {
    this.allowsSelfLoops = paramBoolean;
    return this;
  }
  
  public <N1 extends N> MutableGraph<N1> build()
  {
    return new ConfigurableMutableGraph(this);
  }
  
  public GraphBuilder<N> expectedNodeCount(int paramInt)
  {
    this.expectedNodeCount = Optional.of(Integer.valueOf(Graphs.checkNonNegative(paramInt)));
    return this;
  }
  
  public <N1 extends N> GraphBuilder<N1> nodeOrder(ElementOrder<N1> paramElementOrder)
  {
    GraphBuilder localGraphBuilder = cast();
    localGraphBuilder.nodeOrder = ((ElementOrder)Preconditions.checkNotNull(paramElementOrder));
    return localGraphBuilder;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     com.google.common.graph.GraphBuilder
 * JD-Core Version:    0.7.0.1
 */