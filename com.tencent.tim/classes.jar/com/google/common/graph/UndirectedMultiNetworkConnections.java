package com.google.common.graph;

import com.google.common.base.Preconditions;
import com.google.common.collect.HashMultiset;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.Multiset;
import com.google.errorprone.annotations.concurrent.LazyInit;
import java.lang.ref.Reference;
import java.lang.ref.SoftReference;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import javax.annotation.Nullable;

final class UndirectedMultiNetworkConnections<N, E>
  extends AbstractUndirectedNetworkConnections<N, E>
{
  @LazyInit
  private transient Reference<Multiset<N>> adjacentNodesReference;
  
  private UndirectedMultiNetworkConnections(Map<E, N> paramMap)
  {
    super(paramMap);
  }
  
  private Multiset<N> adjacentNodesMultiset()
  {
    Multiset localMultiset = (Multiset)getReference(this.adjacentNodesReference);
    Object localObject = localMultiset;
    if (localMultiset == null)
    {
      localObject = HashMultiset.create(this.incidentEdgeMap.values());
      this.adjacentNodesReference = new SoftReference(localObject);
    }
    return localObject;
  }
  
  @Nullable
  private static <T> T getReference(@Nullable Reference<T> paramReference)
  {
    if (paramReference == null) {
      return null;
    }
    return paramReference.get();
  }
  
  static <N, E> UndirectedMultiNetworkConnections<N, E> of()
  {
    return new UndirectedMultiNetworkConnections(new HashMap(2, 1.0F));
  }
  
  static <N, E> UndirectedMultiNetworkConnections<N, E> ofImmutable(Map<E, N> paramMap)
  {
    return new UndirectedMultiNetworkConnections(ImmutableMap.copyOf(paramMap));
  }
  
  public void addInEdge(E paramE, N paramN, boolean paramBoolean)
  {
    if (!paramBoolean) {
      addOutEdge(paramE, paramN);
    }
  }
  
  public void addOutEdge(E paramE, N paramN)
  {
    super.addOutEdge(paramE, paramN);
    paramE = (Multiset)getReference(this.adjacentNodesReference);
    if (paramE != null) {
      Preconditions.checkState(paramE.add(paramN));
    }
  }
  
  public Set<N> adjacentNodes()
  {
    return Collections.unmodifiableSet(adjacentNodesMultiset().elementSet());
  }
  
  public Set<E> edgesConnecting(Object paramObject)
  {
    return new UndirectedMultiNetworkConnections.1(this, this.incidentEdgeMap, paramObject, paramObject);
  }
  
  public N removeInEdge(Object paramObject, boolean paramBoolean)
  {
    if (!paramBoolean) {
      return removeOutEdge(paramObject);
    }
    return null;
  }
  
  public N removeOutEdge(Object paramObject)
  {
    paramObject = super.removeOutEdge(paramObject);
    Multiset localMultiset = (Multiset)getReference(this.adjacentNodesReference);
    if (localMultiset != null) {
      Preconditions.checkState(localMultiset.remove(paramObject));
    }
    return paramObject;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     com.google.common.graph.UndirectedMultiNetworkConnections
 * JD-Core Version:    0.7.0.1
 */