package com.google.common.graph;

final class GraphConstants
{
  static final int DEFAULT_EDGE_COUNT = 20;
  static final int DEFAULT_NODE_COUNT = 10;
  static final String EDGE_ALREADY_EXISTS = "Edge %s already exists in the graph.";
  static final String EDGE_CONNECTING_NOT_IN_GRAPH = "Edge connecting %s to %s is not present in this graph.";
  static final String EDGE_NOT_IN_GRAPH = "Edge %s is not an element of this graph.";
  static final int EXPECTED_DEGREE = 2;
  static final String GRAPH_STRING_FORMAT = "%s, nodes: %s, edges: %s";
  static final int INNER_CAPACITY = 2;
  static final float INNER_LOAD_FACTOR = 1.0F;
  static final String NODE_NOT_IN_GRAPH = "Node %s is not an element of this graph.";
  static final String NOT_AVAILABLE_ON_UNDIRECTED = "Cannot call source()/target() on a EndpointPair from an undirected graph. Consider calling adjacentNode(node) if you already have a node, or nodeU()/nodeV() if you don't.";
  static final String PARALLEL_EDGES_NOT_ALLOWED = "Nodes %s and %s are already connected by a different edge. To construct a graph that allows parallel edges, call allowsParallelEdges(true) on the Builder.";
  static final String REUSING_EDGE = "Edge %s already exists between the following nodes: %s, so it cannot be reused to connect the following nodes: %s.";
  static final String SELF_LOOPS_NOT_ALLOWED = "Cannot add self-loop edge on node %s, as self-loops are not allowed. To construct a graph that allows self-loops, call allowsSelfLoops(true) on the Builder.";
  
  static enum Presence
  {
    EDGE_EXISTS;
    
    private Presence() {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     com.google.common.graph.GraphConstants
 * JD-Core Version:    0.7.0.1
 */