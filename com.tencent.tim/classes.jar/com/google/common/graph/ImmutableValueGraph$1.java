package com.google.common.graph;

import com.google.common.base.Function;

final class ImmutableValueGraph$1
  implements Function<N, V>
{
  ImmutableValueGraph$1(ValueGraph paramValueGraph, Object paramObject) {}
  
  public V apply(N paramN)
  {
    return this.val$graph.edgeValue(this.val$node, paramN);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     com.google.common.graph.ImmutableValueGraph.1
 * JD-Core Version:    0.7.0.1
 */