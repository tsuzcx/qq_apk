package com.google.common.graph;

import com.google.common.base.Preconditions;
import com.google.common.collect.UnmodifiableIterator;
import java.util.AbstractSet;
import java.util.Map;
import java.util.Set;
import javax.annotation.Nullable;

abstract class MultiEdgesConnecting<E>
  extends AbstractSet<E>
{
  private final Map<E, ?> outEdgeToNode;
  private final Object targetNode;
  
  MultiEdgesConnecting(Map<E, ?> paramMap, Object paramObject)
  {
    this.outEdgeToNode = ((Map)Preconditions.checkNotNull(paramMap));
    this.targetNode = Preconditions.checkNotNull(paramObject);
  }
  
  public boolean contains(@Nullable Object paramObject)
  {
    return this.targetNode.equals(this.outEdgeToNode.get(paramObject));
  }
  
  public UnmodifiableIterator<E> iterator()
  {
    return new MultiEdgesConnecting.1(this, this.outEdgeToNode.entrySet().iterator());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     com.google.common.graph.MultiEdgesConnecting
 * JD-Core Version:    0.7.0.1
 */