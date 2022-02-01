package com.google.common.graph;

import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableSet;
import com.google.common.collect.Iterators;
import com.google.common.collect.UnmodifiableIterator;
import java.util.AbstractSet;
import java.util.Map;
import javax.annotation.Nullable;

final class EdgesConnecting<E>
  extends AbstractSet<E>
{
  private final Map<?, E> nodeToOutEdge;
  private final Object targetNode;
  
  EdgesConnecting(Map<?, E> paramMap, Object paramObject)
  {
    this.nodeToOutEdge = ((Map)Preconditions.checkNotNull(paramMap));
    this.targetNode = Preconditions.checkNotNull(paramObject);
  }
  
  @Nullable
  private E getConnectingEdge()
  {
    return this.nodeToOutEdge.get(this.targetNode);
  }
  
  public boolean contains(@Nullable Object paramObject)
  {
    Object localObject = getConnectingEdge();
    return (localObject != null) && (localObject.equals(paramObject));
  }
  
  public UnmodifiableIterator<E> iterator()
  {
    Object localObject = getConnectingEdge();
    if (localObject == null) {
      return ImmutableSet.of().iterator();
    }
    return Iterators.singletonIterator(localObject);
  }
  
  public int size()
  {
    if (getConnectingEdge() == null) {
      return 0;
    }
    return 1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     com.google.common.graph.EdgesConnecting
 * JD-Core Version:    0.7.0.1
 */