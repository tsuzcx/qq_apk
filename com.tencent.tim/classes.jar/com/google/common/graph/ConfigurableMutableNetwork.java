package com.google.common.graph;

import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableList;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import java.util.Iterator;
import java.util.Set;

final class ConfigurableMutableNetwork<N, E>
  extends ConfigurableNetwork<N, E>
  implements MutableNetwork<N, E>
{
  ConfigurableMutableNetwork(NetworkBuilder<? super N, ? super E> paramNetworkBuilder)
  {
    super(paramNetworkBuilder);
  }
  
  @CanIgnoreReturnValue
  private NetworkConnections<N, E> addNodeInternal(N paramN)
  {
    NetworkConnections localNetworkConnections = newConnections();
    if (this.nodeConnections.put(paramN, localNetworkConnections) == null) {}
    for (boolean bool = true;; bool = false)
    {
      Preconditions.checkState(bool);
      return localNetworkConnections;
    }
  }
  
  private NetworkConnections<N, E> newConnections()
  {
    if (isDirected())
    {
      if (allowsParallelEdges()) {
        return DirectedMultiNetworkConnections.of();
      }
      return DirectedNetworkConnections.of();
    }
    if (allowsParallelEdges()) {
      return UndirectedMultiNetworkConnections.of();
    }
    return UndirectedNetworkConnections.of();
  }
  
  @CanIgnoreReturnValue
  public boolean addEdge(N paramN1, N paramN2, E paramE)
  {
    boolean bool2 = false;
    Preconditions.checkNotNull(paramN1, "nodeU");
    Preconditions.checkNotNull(paramN2, "nodeV");
    Preconditions.checkNotNull(paramE, "edge");
    Object localObject;
    if (containsEdge(paramE))
    {
      localObject = incidentNodes(paramE);
      paramN1 = EndpointPair.of(this, paramN1, paramN2);
      Preconditions.checkArgument(((EndpointPair)localObject).equals(paramN1), "Edge %s already exists between the following nodes: %s, so it cannot be reused to connect the following nodes: %s.", paramE, localObject, paramN1);
      return false;
    }
    NetworkConnections localNetworkConnections = (NetworkConnections)this.nodeConnections.get(paramN1);
    if (!allowsParallelEdges()) {
      if ((localNetworkConnections != null) && (localNetworkConnections.successors().contains(paramN2))) {
        break label227;
      }
    }
    label227:
    for (boolean bool1 = true;; bool1 = false)
    {
      Preconditions.checkArgument(bool1, "Nodes %s and %s are already connected by a different edge. To construct a graph that allows parallel edges, call allowsParallelEdges(true) on the Builder.", paramN1, paramN2);
      boolean bool3 = paramN1.equals(paramN2);
      if (!allowsSelfLoops())
      {
        bool1 = bool2;
        if (!bool3) {
          bool1 = true;
        }
        Preconditions.checkArgument(bool1, "Cannot add self-loop edge on node %s, as self-loops are not allowed. To construct a graph that allows self-loops, call allowsSelfLoops(true) on the Builder.", paramN1);
      }
      localObject = localNetworkConnections;
      if (localNetworkConnections == null) {
        localObject = addNodeInternal(paramN1);
      }
      ((NetworkConnections)localObject).addOutEdge(paramE, paramN2);
      localNetworkConnections = (NetworkConnections)this.nodeConnections.get(paramN2);
      localObject = localNetworkConnections;
      if (localNetworkConnections == null) {
        localObject = addNodeInternal(paramN2);
      }
      ((NetworkConnections)localObject).addInEdge(paramE, paramN1, bool3);
      this.edgeToReferenceNode.put(paramE, paramN1);
      return true;
    }
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
  public boolean removeEdge(Object paramObject)
  {
    Preconditions.checkNotNull(paramObject, "edge");
    Object localObject1 = this.edgeToReferenceNode.get(paramObject);
    if (localObject1 == null) {
      return false;
    }
    NetworkConnections localNetworkConnections1 = (NetworkConnections)this.nodeConnections.get(localObject1);
    Object localObject2 = localNetworkConnections1.oppositeNode(paramObject);
    NetworkConnections localNetworkConnections2 = (NetworkConnections)this.nodeConnections.get(localObject2);
    localNetworkConnections1.removeOutEdge(paramObject);
    if ((allowsSelfLoops()) && (localObject1.equals(localObject2))) {}
    for (boolean bool = true;; bool = false)
    {
      localNetworkConnections2.removeInEdge(paramObject, bool);
      this.edgeToReferenceNode.remove(paramObject);
      return true;
    }
  }
  
  @CanIgnoreReturnValue
  public boolean removeNode(Object paramObject)
  {
    Preconditions.checkNotNull(paramObject, "node");
    Object localObject = (NetworkConnections)this.nodeConnections.get(paramObject);
    if (localObject == null) {
      return false;
    }
    localObject = ImmutableList.copyOf(((NetworkConnections)localObject).incidentEdges()).iterator();
    while (((Iterator)localObject).hasNext()) {
      removeEdge(((Iterator)localObject).next());
    }
    this.nodeConnections.remove(paramObject);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     com.google.common.graph.ConfigurableMutableNetwork
 * JD-Core Version:    0.7.0.1
 */