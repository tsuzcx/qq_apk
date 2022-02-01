package com.google.common.graph;

import com.google.common.base.Function;

class AbstractNetwork$2
  implements Function<E, EndpointPair<N>>
{
  AbstractNetwork$2(AbstractNetwork paramAbstractNetwork) {}
  
  public EndpointPair<N> apply(E paramE)
  {
    return this.this$0.incidentNodes(paramE);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     com.google.common.graph.AbstractNetwork.2
 * JD-Core Version:    0.7.0.1
 */