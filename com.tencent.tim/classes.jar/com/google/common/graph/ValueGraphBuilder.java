package com.google.common.graph;

import com.google.common.annotations.Beta;
import com.google.common.base.Optional;
import com.google.common.base.Preconditions;

@Beta
public final class ValueGraphBuilder<N, V>
  extends AbstractGraphBuilder<N>
{
  private ValueGraphBuilder(boolean paramBoolean)
  {
    super(paramBoolean);
  }
  
  private <N1 extends N, V1 extends V> ValueGraphBuilder<N1, V1> cast()
  {
    return this;
  }
  
  public static ValueGraphBuilder<Object, Object> directed()
  {
    return new ValueGraphBuilder(true);
  }
  
  public static <N> ValueGraphBuilder<N, Object> from(Graph<N> paramGraph)
  {
    return new ValueGraphBuilder(paramGraph.isDirected()).allowsSelfLoops(paramGraph.allowsSelfLoops()).nodeOrder(paramGraph.nodeOrder());
  }
  
  public static ValueGraphBuilder<Object, Object> undirected()
  {
    return new ValueGraphBuilder(false);
  }
  
  public ValueGraphBuilder<N, V> allowsSelfLoops(boolean paramBoolean)
  {
    this.allowsSelfLoops = paramBoolean;
    return this;
  }
  
  public <N1 extends N, V1 extends V> MutableValueGraph<N1, V1> build()
  {
    return new ConfigurableMutableValueGraph(this);
  }
  
  public ValueGraphBuilder<N, V> expectedNodeCount(int paramInt)
  {
    this.expectedNodeCount = Optional.of(Integer.valueOf(Graphs.checkNonNegative(paramInt)));
    return this;
  }
  
  public <N1 extends N> ValueGraphBuilder<N1, V> nodeOrder(ElementOrder<N1> paramElementOrder)
  {
    ValueGraphBuilder localValueGraphBuilder = cast();
    localValueGraphBuilder.nodeOrder = ((ElementOrder)Preconditions.checkNotNull(paramElementOrder));
    return localValueGraphBuilder;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     com.google.common.graph.ValueGraphBuilder
 * JD-Core Version:    0.7.0.1
 */