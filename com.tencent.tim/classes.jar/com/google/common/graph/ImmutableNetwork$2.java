package com.google.common.graph;

import com.google.common.base.Function;

final class ImmutableNetwork$2
  implements Function<E, N>
{
  ImmutableNetwork$2(Network paramNetwork) {}
  
  public N apply(E paramE)
  {
    return this.val$network.incidentNodes(paramE).source();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     com.google.common.graph.ImmutableNetwork.2
 * JD-Core Version:    0.7.0.1
 */