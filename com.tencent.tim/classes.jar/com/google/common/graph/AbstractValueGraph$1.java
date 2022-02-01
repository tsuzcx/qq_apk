package com.google.common.graph;

import com.google.common.base.Function;

class AbstractValueGraph$1
  implements Function<EndpointPair<N>, V>
{
  AbstractValueGraph$1(AbstractValueGraph paramAbstractValueGraph) {}
  
  public V apply(EndpointPair<N> paramEndpointPair)
  {
    return this.this$0.edgeValue(paramEndpointPair.nodeU(), paramEndpointPair.nodeV());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     com.google.common.graph.AbstractValueGraph.1
 * JD-Core Version:    0.7.0.1
 */