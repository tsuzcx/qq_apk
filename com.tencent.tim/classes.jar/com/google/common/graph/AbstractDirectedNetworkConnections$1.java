package com.google.common.graph;

import com.google.common.collect.Iterables;
import com.google.common.collect.Iterators;
import com.google.common.collect.Sets;
import com.google.common.collect.UnmodifiableIterator;
import com.google.common.math.IntMath;
import java.util.AbstractSet;
import java.util.Map;
import javax.annotation.Nullable;

class AbstractDirectedNetworkConnections$1
  extends AbstractSet<E>
{
  AbstractDirectedNetworkConnections$1(AbstractDirectedNetworkConnections paramAbstractDirectedNetworkConnections) {}
  
  public boolean contains(@Nullable Object paramObject)
  {
    return (this.this$0.inEdgeMap.containsKey(paramObject)) || (this.this$0.outEdgeMap.containsKey(paramObject));
  }
  
  public UnmodifiableIterator<E> iterator()
  {
    if (AbstractDirectedNetworkConnections.access$000(this.this$0) == 0) {}
    for (Object localObject = Iterables.concat(this.this$0.inEdgeMap.keySet(), this.this$0.outEdgeMap.keySet());; localObject = Sets.union(this.this$0.inEdgeMap.keySet(), this.this$0.outEdgeMap.keySet())) {
      return Iterators.unmodifiableIterator(((Iterable)localObject).iterator());
    }
  }
  
  public int size()
  {
    return IntMath.saturatedAdd(this.this$0.inEdgeMap.size(), this.this$0.outEdgeMap.size() - AbstractDirectedNetworkConnections.access$000(this.this$0));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     com.google.common.graph.AbstractDirectedNetworkConnections.1
 * JD-Core Version:    0.7.0.1
 */