package com.google.common.graph;

import com.google.common.annotations.Beta;
import com.google.common.base.Objects;
import com.google.common.base.Preconditions;
import com.google.common.collect.Iterators;
import com.google.common.collect.UnmodifiableIterator;
import javax.annotation.Nullable;

@Beta
public abstract class EndpointPair<N>
  implements Iterable<N>
{
  private final N nodeU;
  private final N nodeV;
  
  private EndpointPair(N paramN1, N paramN2)
  {
    this.nodeU = Preconditions.checkNotNull(paramN1);
    this.nodeV = Preconditions.checkNotNull(paramN2);
  }
  
  static <N> EndpointPair<N> of(Graph<?> paramGraph, N paramN1, N paramN2)
  {
    if (paramGraph.isDirected()) {
      return ordered(paramN1, paramN2);
    }
    return unordered(paramN1, paramN2);
  }
  
  static <N> EndpointPair<N> of(Network<?, ?> paramNetwork, N paramN1, N paramN2)
  {
    if (paramNetwork.isDirected()) {
      return ordered(paramN1, paramN2);
    }
    return unordered(paramN1, paramN2);
  }
  
  public static <N> EndpointPair<N> ordered(N paramN1, N paramN2)
  {
    return new Ordered(paramN1, paramN2, null);
  }
  
  public static <N> EndpointPair<N> unordered(N paramN1, N paramN2)
  {
    return new Unordered(paramN2, paramN1, null);
  }
  
  public final N adjacentNode(Object paramObject)
  {
    if (paramObject.equals(this.nodeU)) {
      return this.nodeV;
    }
    if (paramObject.equals(this.nodeV)) {
      return this.nodeU;
    }
    throw new IllegalArgumentException(String.format("EndpointPair %s does not contain node %s", new Object[] { this, paramObject }));
  }
  
  public abstract boolean equals(@Nullable Object paramObject);
  
  public abstract int hashCode();
  
  public abstract boolean isOrdered();
  
  public final UnmodifiableIterator<N> iterator()
  {
    return Iterators.forArray(new Object[] { this.nodeU, this.nodeV });
  }
  
  public final N nodeU()
  {
    return this.nodeU;
  }
  
  public final N nodeV()
  {
    return this.nodeV;
  }
  
  public abstract N source();
  
  public abstract N target();
  
  static final class Ordered<N>
    extends EndpointPair<N>
  {
    private Ordered(N paramN1, N paramN2)
    {
      super(paramN2, null);
    }
    
    public boolean equals(@Nullable Object paramObject)
    {
      if (paramObject == this) {}
      do
      {
        return true;
        if (!(paramObject instanceof EndpointPair)) {
          return false;
        }
        paramObject = (EndpointPair)paramObject;
        if (isOrdered() != paramObject.isOrdered()) {
          return false;
        }
      } while ((source().equals(paramObject.source())) && (target().equals(paramObject.target())));
      return false;
    }
    
    public int hashCode()
    {
      return Objects.hashCode(new Object[] { source(), target() });
    }
    
    public boolean isOrdered()
    {
      return true;
    }
    
    public N source()
    {
      return nodeU();
    }
    
    public N target()
    {
      return nodeV();
    }
    
    public String toString()
    {
      return String.format("<%s -> %s>", new Object[] { source(), target() });
    }
  }
  
  static final class Unordered<N>
    extends EndpointPair<N>
  {
    private Unordered(N paramN1, N paramN2)
    {
      super(paramN2, null);
    }
    
    public boolean equals(@Nullable Object paramObject)
    {
      if (paramObject == this) {}
      do
      {
        return true;
        if (!(paramObject instanceof EndpointPair)) {
          return false;
        }
        paramObject = (EndpointPair)paramObject;
        if (isOrdered() != paramObject.isOrdered()) {
          return false;
        }
        if (nodeU().equals(paramObject.nodeU())) {
          return nodeV().equals(paramObject.nodeV());
        }
      } while ((nodeU().equals(paramObject.nodeV())) && (nodeV().equals(paramObject.nodeU())));
      return false;
    }
    
    public int hashCode()
    {
      return nodeU().hashCode() + nodeV().hashCode();
    }
    
    public boolean isOrdered()
    {
      return false;
    }
    
    public N source()
    {
      throw new UnsupportedOperationException("Cannot call source()/target() on a EndpointPair from an undirected graph. Consider calling adjacentNode(node) if you already have a node, or nodeU()/nodeV() if you don't.");
    }
    
    public N target()
    {
      throw new UnsupportedOperationException("Cannot call source()/target() on a EndpointPair from an undirected graph. Consider calling adjacentNode(node) if you already have a node, or nodeU()/nodeV() if you don't.");
    }
    
    public String toString()
    {
      return String.format("[%s, %s]", new Object[] { nodeU(), nodeV() });
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     com.google.common.graph.EndpointPair
 * JD-Core Version:    0.7.0.1
 */