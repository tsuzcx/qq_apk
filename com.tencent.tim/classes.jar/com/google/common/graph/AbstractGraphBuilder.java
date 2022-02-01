package com.google.common.graph;

import com.google.common.base.Optional;

abstract class AbstractGraphBuilder<N>
{
  boolean allowsSelfLoops = false;
  final boolean directed;
  Optional<Integer> expectedNodeCount = Optional.absent();
  ElementOrder<N> nodeOrder = ElementOrder.insertion();
  
  AbstractGraphBuilder(boolean paramBoolean)
  {
    this.directed = paramBoolean;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     com.google.common.graph.AbstractGraphBuilder
 * JD-Core Version:    0.7.0.1
 */