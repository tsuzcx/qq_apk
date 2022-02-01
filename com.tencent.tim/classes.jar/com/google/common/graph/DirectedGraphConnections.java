package com.google.common.graph;

import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableMap;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import javax.annotation.Nullable;

final class DirectedGraphConnections<N, V>
  implements GraphConnections<N, V>
{
  private static final Object PRED = new Object();
  private final Map<N, Object> adjacentNodeValues;
  private int predecessorCount;
  private int successorCount;
  
  private DirectedGraphConnections(Map<N, Object> paramMap, int paramInt1, int paramInt2)
  {
    this.adjacentNodeValues = ((Map)Preconditions.checkNotNull(paramMap));
    this.predecessorCount = Graphs.checkNonNegative(paramInt1);
    this.successorCount = Graphs.checkNonNegative(paramInt2);
    if ((paramInt1 <= paramMap.size()) && (paramInt2 <= paramMap.size())) {}
    for (boolean bool = true;; bool = false)
    {
      Preconditions.checkState(bool);
      return;
    }
  }
  
  private static boolean isPredecessor(@Nullable Object paramObject)
  {
    return (paramObject == PRED) || ((paramObject instanceof PredAndSucc));
  }
  
  private static boolean isSuccessor(@Nullable Object paramObject)
  {
    return (paramObject != PRED) && (paramObject != null);
  }
  
  static <N, V> DirectedGraphConnections<N, V> of()
  {
    return new DirectedGraphConnections(new HashMap(4, 1.0F), 0, 0);
  }
  
  static <N, V> DirectedGraphConnections<N, V> ofImmutable(Set<N> paramSet, Map<N, V> paramMap)
  {
    HashMap localHashMap = new HashMap();
    localHashMap.putAll(paramMap);
    Iterator localIterator = paramSet.iterator();
    while (localIterator.hasNext())
    {
      Object localObject1 = localIterator.next();
      Object localObject2 = localHashMap.put(localObject1, PRED);
      if (localObject2 != null) {
        localHashMap.put(localObject1, new PredAndSucc(localObject2));
      }
    }
    return new DirectedGraphConnections(ImmutableMap.copyOf(localHashMap), paramSet.size(), paramMap.size());
  }
  
  public void addPredecessor(N paramN, V paramV)
  {
    paramV = this.adjacentNodeValues.put(paramN, PRED);
    if (paramV == null)
    {
      i = this.predecessorCount + 1;
      this.predecessorCount = i;
      Graphs.checkPositive(i);
    }
    do
    {
      return;
      if ((paramV instanceof PredAndSucc))
      {
        this.adjacentNodeValues.put(paramN, paramV);
        return;
      }
    } while (paramV == PRED);
    this.adjacentNodeValues.put(paramN, new PredAndSucc(paramV));
    int i = this.predecessorCount + 1;
    this.predecessorCount = i;
    Graphs.checkPositive(i);
  }
  
  public V addSuccessor(N paramN, V paramV)
  {
    Object localObject2 = this.adjacentNodeValues.put(paramN, paramV);
    Object localObject1;
    if (localObject2 == null)
    {
      i = this.successorCount + 1;
      this.successorCount = i;
      Graphs.checkPositive(i);
      localObject1 = null;
    }
    do
    {
      return localObject1;
      if ((localObject2 instanceof PredAndSucc))
      {
        this.adjacentNodeValues.put(paramN, new PredAndSucc(paramV));
        return ((PredAndSucc)localObject2).successorValue;
      }
      localObject1 = localObject2;
    } while (localObject2 != PRED);
    this.adjacentNodeValues.put(paramN, new PredAndSucc(paramV));
    int i = this.successorCount + 1;
    this.successorCount = i;
    Graphs.checkPositive(i);
    return null;
  }
  
  public Set<N> adjacentNodes()
  {
    return Collections.unmodifiableSet(this.adjacentNodeValues.keySet());
  }
  
  public Set<N> predecessors()
  {
    return new DirectedGraphConnections.1(this);
  }
  
  public void removePredecessor(Object paramObject)
  {
    Object localObject = this.adjacentNodeValues.get(paramObject);
    if (localObject == PRED)
    {
      this.adjacentNodeValues.remove(paramObject);
      i = this.predecessorCount - 1;
      this.predecessorCount = i;
      Graphs.checkNonNegative(i);
    }
    while (!(localObject instanceof PredAndSucc)) {
      return;
    }
    this.adjacentNodeValues.put(paramObject, ((PredAndSucc)localObject).successorValue);
    int i = this.predecessorCount - 1;
    this.predecessorCount = i;
    Graphs.checkNonNegative(i);
  }
  
  public V removeSuccessor(Object paramObject)
  {
    Object localObject = this.adjacentNodeValues.get(paramObject);
    if ((localObject == null) || (localObject == PRED)) {
      return null;
    }
    if ((localObject instanceof PredAndSucc))
    {
      this.adjacentNodeValues.put(paramObject, PRED);
      i = this.successorCount - 1;
      this.successorCount = i;
      Graphs.checkNonNegative(i);
      return ((PredAndSucc)localObject).successorValue;
    }
    this.adjacentNodeValues.remove(paramObject);
    int i = this.successorCount - 1;
    this.successorCount = i;
    Graphs.checkNonNegative(i);
    return localObject;
  }
  
  public Set<N> successors()
  {
    return new DirectedGraphConnections.2(this);
  }
  
  public V value(Object paramObject)
  {
    Object localObject = this.adjacentNodeValues.get(paramObject);
    if (localObject == PRED) {
      paramObject = null;
    }
    do
    {
      return paramObject;
      paramObject = localObject;
    } while (!(localObject instanceof PredAndSucc));
    return ((PredAndSucc)localObject).successorValue;
  }
  
  static final class PredAndSucc
  {
    private final Object successorValue;
    
    PredAndSucc(Object paramObject)
    {
      this.successorValue = paramObject;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     com.google.common.graph.DirectedGraphConnections
 * JD-Core Version:    0.7.0.1
 */