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

final class DirectedMultiNetworkConnections<N, E>
  extends AbstractDirectedNetworkConnections<N, E>
{
  @LazyInit
  private transient Reference<Multiset<N>> predecessorsReference;
  @LazyInit
  private transient Reference<Multiset<N>> successorsReference;
  
  private DirectedMultiNetworkConnections(Map<E, N> paramMap1, Map<E, N> paramMap2, int paramInt)
  {
    super(paramMap1, paramMap2, paramInt);
  }
  
  @Nullable
  private static <T> T getReference(@Nullable Reference<T> paramReference)
  {
    if (paramReference == null) {
      return null;
    }
    return paramReference.get();
  }
  
  static <N, E> DirectedMultiNetworkConnections<N, E> of()
  {
    return new DirectedMultiNetworkConnections(new HashMap(2, 1.0F), new HashMap(2, 1.0F), 0);
  }
  
  static <N, E> DirectedMultiNetworkConnections<N, E> ofImmutable(Map<E, N> paramMap1, Map<E, N> paramMap2, int paramInt)
  {
    return new DirectedMultiNetworkConnections(ImmutableMap.copyOf(paramMap1), ImmutableMap.copyOf(paramMap2), paramInt);
  }
  
  private Multiset<N> predecessorsMultiset()
  {
    Multiset localMultiset = (Multiset)getReference(this.predecessorsReference);
    Object localObject = localMultiset;
    if (localMultiset == null)
    {
      localObject = HashMultiset.create(this.inEdgeMap.values());
      this.predecessorsReference = new SoftReference(localObject);
    }
    return localObject;
  }
  
  private Multiset<N> successorsMultiset()
  {
    Multiset localMultiset = (Multiset)getReference(this.successorsReference);
    Object localObject = localMultiset;
    if (localMultiset == null)
    {
      localObject = HashMultiset.create(this.outEdgeMap.values());
      this.successorsReference = new SoftReference(localObject);
    }
    return localObject;
  }
  
  public void addInEdge(E paramE, N paramN, boolean paramBoolean)
  {
    super.addInEdge(paramE, paramN, paramBoolean);
    paramE = (Multiset)getReference(this.predecessorsReference);
    if (paramE != null) {
      Preconditions.checkState(paramE.add(paramN));
    }
  }
  
  public void addOutEdge(E paramE, N paramN)
  {
    super.addOutEdge(paramE, paramN);
    paramE = (Multiset)getReference(this.successorsReference);
    if (paramE != null) {
      Preconditions.checkState(paramE.add(paramN));
    }
  }
  
  public Set<E> edgesConnecting(Object paramObject)
  {
    return new DirectedMultiNetworkConnections.1(this, this.outEdgeMap, paramObject, paramObject);
  }
  
  public Set<N> predecessors()
  {
    return Collections.unmodifiableSet(predecessorsMultiset().elementSet());
  }
  
  public N removeInEdge(Object paramObject, boolean paramBoolean)
  {
    paramObject = super.removeInEdge(paramObject, paramBoolean);
    Multiset localMultiset = (Multiset)getReference(this.predecessorsReference);
    if (localMultiset != null) {
      Preconditions.checkState(localMultiset.remove(paramObject));
    }
    return paramObject;
  }
  
  public N removeOutEdge(Object paramObject)
  {
    paramObject = super.removeOutEdge(paramObject);
    Multiset localMultiset = (Multiset)getReference(this.successorsReference);
    if (localMultiset != null) {
      Preconditions.checkState(localMultiset.remove(paramObject));
    }
    return paramObject;
  }
  
  public Set<N> successors()
  {
    return Collections.unmodifiableSet(successorsMultiset().elementSet());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     com.google.common.graph.DirectedMultiNetworkConnections
 * JD-Core Version:    0.7.0.1
 */