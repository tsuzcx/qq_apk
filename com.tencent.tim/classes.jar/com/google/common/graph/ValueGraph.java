package com.google.common.graph;

import com.google.common.annotations.Beta;
import javax.annotation.Nullable;

@Beta
public abstract interface ValueGraph<N, V>
  extends Graph<N>
{
  public abstract V edgeValue(Object paramObject1, Object paramObject2);
  
  public abstract V edgeValueOrDefault(Object paramObject1, Object paramObject2, @Nullable V paramV);
  
  public abstract boolean equals(@Nullable Object paramObject);
  
  public abstract int hashCode();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     com.google.common.graph.ValueGraph
 * JD-Core Version:    0.7.0.1
 */