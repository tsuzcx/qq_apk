package com.google.common.graph;

import com.google.common.collect.Multiset;
import java.util.Map;

class UndirectedMultiNetworkConnections$1
  extends MultiEdgesConnecting<E>
{
  UndirectedMultiNetworkConnections$1(UndirectedMultiNetworkConnections paramUndirectedMultiNetworkConnections, Map paramMap, Object paramObject1, Object paramObject2)
  {
    super(paramMap, paramObject1);
  }
  
  public int size()
  {
    return UndirectedMultiNetworkConnections.access$000(this.this$0).count(this.val$node);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     com.google.common.graph.UndirectedMultiNetworkConnections.1
 * JD-Core Version:    0.7.0.1
 */