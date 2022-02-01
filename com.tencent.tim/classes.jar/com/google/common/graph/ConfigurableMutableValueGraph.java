package com.google.common.graph;

import com.google.common.base.Preconditions;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import java.util.Iterator;
import java.util.Set;

final class ConfigurableMutableValueGraph<N, V>
  extends ConfigurableValueGraph<N, V>
  implements MutableValueGraph<N, V>
{
  ConfigurableMutableValueGraph(AbstractGraphBuilder<? super N> paramAbstractGraphBuilder)
  {
    super(paramAbstractGraphBuilder);
  }
  
  @CanIgnoreReturnValue
  private GraphConnections<N, V> addNodeInternal(N paramN)
  {
    GraphConnections localGraphConnections = newConnections();
    if (this.nodeConnections.put(paramN, localGraphConnections) == null) {}
    for (boolean bool = true;; bool = false)
    {
      Preconditions.checkState(bool);
      return localGraphConnections;
    }
  }
  
  private GraphConnections<N, V> newConnections()
  {
    if (isDirected()) {
      return DirectedGraphConnections.of();
    }
    return UndirectedGraphConnections.of();
  }
  
  @CanIgnoreReturnValue
  public boolean addNode(N paramN)
  {
    Preconditions.checkNotNull(paramN, "node");
    if (containsNode(paramN)) {
      return false;
    }
    addNodeInternal(paramN);
    return true;
  }
  
  @CanIgnoreReturnValue
  public V putEdgeValue(N paramN1, N paramN2, V paramV)
  {
    Preconditions.checkNotNull(paramN1, "nodeU");
    Preconditions.checkNotNull(paramN2, "nodeV");
    Preconditions.checkNotNull(paramV, "value");
    if (!allowsSelfLoops()) {
      if (paramN1.equals(paramN2)) {
        break label153;
      }
    }
    label153:
    for (boolean bool = true;; bool = false)
    {
      Preconditions.checkArgument(bool, "Cannot add self-loop edge on node %s, as self-loops are not allowed. To construct a graph that allows self-loops, call allowsSelfLoops(true) on the Builder.", paramN1);
      GraphConnections localGraphConnections2 = (GraphConnections)this.nodeConnections.get(paramN1);
      GraphConnections localGraphConnections1 = localGraphConnections2;
      if (localGraphConnections2 == null) {
        localGraphConnections1 = addNodeInternal(paramN1);
      }
      Object localObject = localGraphConnections1.addSuccessor(paramN2, paramV);
      localGraphConnections2 = (GraphConnections)this.nodeConnections.get(paramN2);
      localGraphConnections1 = localGraphConnections2;
      if (localGraphConnections2 == null) {
        localGraphConnections1 = addNodeInternal(paramN2);
      }
      localGraphConnections1.addPredecessor(paramN1, paramV);
      if (localObject == null)
      {
        long l = this.edgeCount + 1L;
        this.edgeCount = l;
        Graphs.checkPositive(l);
      }
      return localObject;
    }
  }
  
  @CanIgnoreReturnValue
  public V removeEdge(Object paramObject1, Object paramObject2)
  {
    Preconditions.checkNotNull(paramObject1, "nodeU");
    Preconditions.checkNotNull(paramObject2, "nodeV");
    Object localObject = (GraphConnections)this.nodeConnections.get(paramObject1);
    GraphConnections localGraphConnections = (GraphConnections)this.nodeConnections.get(paramObject2);
    if ((localObject == null) || (localGraphConnections == null)) {
      paramObject2 = null;
    }
    do
    {
      return paramObject2;
      localObject = ((GraphConnections)localObject).removeSuccessor(paramObject2);
      paramObject2 = localObject;
    } while (localObject == null);
    localGraphConnections.removePredecessor(paramObject1);
    long l = this.edgeCount - 1L;
    this.edgeCount = l;
    Graphs.checkNonNegative(l);
    return localObject;
  }
  
  @CanIgnoreReturnValue
  public boolean removeNode(Object paramObject)
  {
    Preconditions.checkNotNull(paramObject, "node");
    Object localObject1 = (GraphConnections)this.nodeConnections.get(paramObject);
    if (localObject1 == null) {
      return false;
    }
    if ((allowsSelfLoops()) && (((GraphConnections)localObject1).removeSuccessor(paramObject) != null))
    {
      ((GraphConnections)localObject1).removePredecessor(paramObject);
      this.edgeCount -= 1L;
    }
    Object localObject2 = ((GraphConnections)localObject1).successors().iterator();
    while (((Iterator)localObject2).hasNext())
    {
      Object localObject3 = ((Iterator)localObject2).next();
      ((GraphConnections)this.nodeConnections.getWithoutCaching(localObject3)).removePredecessor(paramObject);
      this.edgeCount -= 1L;
    }
    if (isDirected())
    {
      localObject1 = ((GraphConnections)localObject1).predecessors().iterator();
      if (((Iterator)localObject1).hasNext())
      {
        localObject2 = ((Iterator)localObject1).next();
        if (((GraphConnections)this.nodeConnections.getWithoutCaching(localObject2)).removeSuccessor(paramObject) != null) {}
        for (boolean bool = true;; bool = false)
        {
          Preconditions.checkState(bool);
          this.edgeCount -= 1L;
          break;
        }
      }
    }
    this.nodeConnections.remove(paramObject);
    Graphs.checkNonNegative(this.edgeCount);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     com.google.common.graph.ConfigurableMutableValueGraph
 * JD-Core Version:    0.7.0.1
 */