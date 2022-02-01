package com.google.common.graph;

import com.google.common.base.Function;

final class ImmutableNetwork$4
  implements Function<E, N>
{
  ImmutableNetwork$4(Network paramNetwork, Object paramObject) {}
  
  public N apply(E paramE)
  {
    return this.val$network.incidentNodes(paramE).adjacentNode(this.val$node);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     com.google.common.graph.ImmutableNetwork.4
 * JD-Core Version:    0.7.0.1
 */